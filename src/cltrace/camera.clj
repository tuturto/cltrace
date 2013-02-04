(ns cltrace.camera
  (:use cltrace.math))

(defn calculate-delta
  ^{:private true}
  [camera]
  (let [camera-settings (nth camera 1)] 
    (conj (vec (map / (map - (:point-1 camera-settings)
                           (:point-0 camera-settings))
         (map dec (:resolution camera-settings))))
          0.0)))

(defn get-grid
  "return matrix of points defining projection grid of the camera"
  [camera]
  (let [camera-settings (nth camera 1)
        delta (calculate-delta camera)
        z (nth (get camera-settings :point-0) 2)]
    (for [y (range (nth (:resolution camera-settings) 1))]
      (for [x (range (nth (:resolution camera-settings) 0))]
        (map + 
             (map * [x y z] delta) 
             (get camera-settings :point-0))))))

(defn get-camera-rays
  "return list of normalized rays originating from camera, through grid"
  [camera]
	(let [grid (get-grid camera)
        camera-settings (nth camera 1)
        origo (:location camera-settings)]
      (map (fn [y] (map (fn [x]
                          [origo (normalize-vector (vector-direction origo x))]) y)) grid)))

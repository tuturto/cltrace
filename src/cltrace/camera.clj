(ns cltrace.camera
  (:use cltrace.math))

(defn index-to-coordinates
  [width height index]
   [(rem index width)
    (quot index width)])

(defn coordinates-to-index
  [width height x y]
   (+ (* y width) x))

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
        width (nth (:resolution camera-settings) 0)
        height (nth (:resolution camera-settings) 1)
        planar-coordinates (partial index-to-coordinates width height)
        z (nth (get camera-settings :point-0) 2)]
    (for [index (range (* width height))]
        (map + 
             (map * (conj (planar-coordinates index) z)
                  delta)
             (get camera-settings :point-0)))))

(defn get-camera-rays
  "return list of normalized rays originating from camera, through grid"
  [camera]
	(let [grid (get-grid camera)
        camera-settings (nth camera 1)
        origo (:location camera-settings)]
      (map (fn [index]
             [origo (normalize-vector (vector-direction origo index))]) grid)))

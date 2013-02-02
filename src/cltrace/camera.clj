(ns cltrace.camera
  (:use cltrace.math))

(defn calculate-delta
  ^{:private true}
  [camera]
  (let [camera-settings (nth camera 1)] 
    (conj (vec (map / (map - (get camera-settings :point-1)
                (get camera-settings :point-0)
                )
         (map dec (get camera-settings :resolution))))
          0.0)
    )
  )

(defn get-grid
  "return matrix of points defining projection grid of the camera"
  [camera]
  (let [camera-settings (nth camera 1)
        delta (calculate-delta camera)
        z (nth (get camera-settings :point-0) 2)]
    (for [y (range (nth (get camera-settings :resolution) 1))]
      (for [x (range (nth (get camera-settings :resolution) 0))]
        (map + 
             (map * (list x y z) delta) 
             (get camera-settings :point-0))))
    )
  )

(defn get-camera-rays
  "return list of normalized rays originating from camera, through grid"
  [camera]
	(let [grid (get-grid camera)
        camera-settings (nth camera 1)]
    (let [origo (get camera-settings :location)]
      (map (fn [y]
             (map (fn [x]
                    (list origo (normalize-vector (vector-direction origo x)))) y)) grid)
      )
    )
  )

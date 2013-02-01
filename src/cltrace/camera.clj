(ns cltrace.camera)

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

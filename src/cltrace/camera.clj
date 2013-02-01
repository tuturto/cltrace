(ns cltrace.camera)

(defn calculate-delta
  [camera]
  (let [camera-settings (nth camera 1)] 
    (conj (vec (map / (map - (get camera-settings :point-1)
                (get camera-settings :point-0)
                )
         (get camera-settings :resolution)))
          0)
    )
  )

(defn get-grid
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

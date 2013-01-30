(ns cltrace.sphere
  (:use cltrace.geometry
        cltrace.math
        clojure.contrib.math))

(defn
  ^{:private true}
  calculate-b
  [sphere ray]
  (* 2 (dot 
      (map - (nth ray 0) (nth sphere 1)) 
      (nth ray 1))
     )
  )

(defn
  ^{:private true}
  calculate-c
  [sphere ray]
  (- (dot 
	(map - (nth ray 0) (nth sphere 1))
	(map - (nth ray 0) (nth sphere 1))
 )
(expt (nth sphere 2) 2)))


(defn
  ^{:private true}
  calculate-discriminant
  [b c]
  (- (expt b 2)
         (* c 4))
  )

(defn
  ^{:private true}
  intersections
  [b discriminant]
  (list
   (/ (+ (- b) (sqrt discriminant)) 2)
   (/ (- (- b) (sqrt discriminant)) 2)
   )
  )

(defn
  ^{:private true}
  intersection-distance
  [sphere ray]
  (let [b (calculate-b sphere ray) c (calculate-c sphere ray)]
    (let [discriminant (calculate-discriminant b c)]
      (reduce min (filter (fn[x] (> x 0)) (intersections b discriminant)))
      )
    )
  )

(defmethod closest-intersection :sphere
  [sphere ray]
  (scale (intersection-distance sphere ray)
         (map + (nth ray 0) (nth ray 1)))
  )

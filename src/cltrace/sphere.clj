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

(defmethod closest-intersection :sphere
  [sphere ray]
  (let [b (calculate-b sphere ray) c (calculate-c sphere ray)]
    (let [discriminant (calculate-discriminant b c)]
      (min (filter fn[x] (> x 0) (intersections b discriminant)))
      )
    )
)

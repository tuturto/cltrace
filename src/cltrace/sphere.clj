(ns cltrace.sphere
  (:use cltrace.geometry
        cltrace.math
        clojure.contrib.math))

(defn
  ^{:private true}
  calculate-b
  [sphere ray]
  (* 2 (dot-product 
        (map - (nth ray 0) (nth sphere 1)) 
        (nth ray 1))))

(defn
  ^{:private true}
  calculate-c
  [sphere ray]
  (- (dot-product 
      (map - (nth ray 0) (nth sphere 1))
      (map - (nth ray 0) (nth sphere 1)))
     (expt (nth sphere 2) 2)))


(defn
  ^{:private true}
  calculate-discriminant
  [b c]
  (- (expt b 2)
         (* c 4)))

(defn
  ^{:private true}
  intersections
  [b discriminant]
  [(/ (+ (- b) (sqrt discriminant)) 2)
   (/ (- (- b) (sqrt discriminant)) 2)])

(defn
  ^{:private true}
  intersection-distance
  [sphere ray]
  (let [b (calculate-b sphere ray) 
        c (calculate-c sphere ray)
        discriminant (calculate-discriminant b c)]
      (when (>= discriminant 0) 
        (let [positive-distances (filter (fn[x] (> x 0)) (intersections b discriminant))]
          (when (> (count positive-distances) 0)
            (reduce min positive-distances))))))

(defmethod 
  closest-intersection :sphere
  [sphere ray]
  (let [distance (intersection-distance sphere ray)]
    (when distance
  		(map + (nth ray 0) (scale-vector distance (nth ray 1))))))

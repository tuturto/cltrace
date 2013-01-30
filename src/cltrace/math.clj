(ns cltrace.math
  (:use clojure.contrib.math))

(defn dot-product
    "Returns the value of dot product of the vectors v1 and v2"
    [v1 v2] (reduce + (map * v1 v2)))

(defn cross-product
    "Return the cross product of vectors v1 and v2"
    [v1 v2] [(- (* (v1 1) (v2 2)) (* (v1 2) (v2 1)))
    (- (* (v1 2) (v2 0)) (* (v1 0) (v2 2)))
    (- (* (v1 0) (v2 1)) (* (v1 1) (v2 0)))])

(defn scale-vector
    "Returns the vector that is n times the vector v"
    [n v] (map #(* n %) v))

(defn vector-length
  [v]
  (sqrt (reduce + (map (fn [x] (expt x 2)) v)))
  )

(defn normalize-vector
  [v]
  (let [length (vector-length v)]
    (map (fn [x] (/ x length)) v))
  )

(ns cltrace.math)

(defn dot 
    "Returns the value of dot product of the vectors v1 and v2"
    [v1 v2] (reduce + (map * v1 v2)))

(defn cross
    "Return the cross product of vectors v1 and v2"
    [v1 v2] [(- (* (v1 1) (v2 2)) (* (v1 2) (v2 1)))
    (- (* (v1 2) (v2 0)) (* (v1 0) (v2 2)))
    (- (* (v1 0) (v2 1)) (* (v1 1) (v2 0)))])

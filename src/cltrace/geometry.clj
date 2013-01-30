(ns cltrace.geometry)

(defn select-shape
  [shape %params]
  (keyword (first shape))
  )

(defmulti closest-intersection select-shape)

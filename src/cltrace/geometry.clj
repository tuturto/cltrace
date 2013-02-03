(ns cltrace.geometry)

(defn select-shape
  [shape %params]
  (keyword (first shape))
  )

(defmulti closest-intersection select-shape)

(defn ray-start
  "get start of the ray"
  [ray]
  (nth ray 0)
  )

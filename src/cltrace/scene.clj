(ns cltrace.scene
  (:use cltrace.geometry
        cltrace.helpers))

(defn get-object-ray-intersections
  "cast ray and return list of intersection point and object from scene"
  [ray scene]
  (let [objects (get scene :objects)]
    (map (fn [object] (list object (closest-intersection (object-geometry object) ray))) objects)
    )
  )

(defn get-closest-object-ray-intersection
  "cast ray and return closest intersection point and object from scene"
  [ray scene]
  (get-object-ray-intersections ray scene)
  )

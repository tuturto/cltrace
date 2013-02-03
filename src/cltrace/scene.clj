(ns cltrace.scene
  (:use cltrace.geometry
        cltrace.helpers
        cltrace.math))

(defn intersection-point
  "get intersection point of object intersection"
  [object-intersection]
  (nth object-intersection 1)
  )

(defn get-object-ray-intersections
  "cast ray and return list of intersection point and object from scene"
  [ray scene]
  (filter (fn [x] (not= (intersection-point x) nil))
          (map (fn [object] (list object (closest-intersection (object-geometry object) ray))) 
               (get scene :objects))
          )
  )

(defn get-closest-intersection
  "from a list of object intersections, get the one closest to a given position"
  [position object-intersections]
  (reduce (fn [x y] (if (< (distance position (intersection-point x))
                           (distance position (intersection-point y)))
                      x y))
          object-intersections)
  )

(defn get-closest-object-ray-intersection
  "cast ray and return closest intersection point and object from scene, nil for no hit"
  [ray scene]
    (get-closest-intersection (ray-start ray)
                              (get-object-ray-intersections ray scene)
    )
  )

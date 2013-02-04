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
  (let [intersections (get-object-ray-intersections ray scene)]
    (if (not= (count intersections) 0)
      (get-closest-intersection (ray-start ray)
                                intersections
                                )
      nil
      )
    )
  )

(defn get-colour-of-intersection
  "get colour of ray-object intersection"
  [ray object-intersection scene]
  (texture-colour (object-texture 
                   (nth object-intersection 0))
                  )
  )

(defn get-colour-of-ray
  "get colour of ray"
  [ray scene]
  (let [intersection (get-closest-object-ray-intersection ray scene)]
    (if (= intersection nil)
      (nth (get scene :background) 1)
      (list 255 255 255)
      )
    )
  )

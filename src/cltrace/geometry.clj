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

(defn object-geometry
  "Get geometry of an object"
  [object]
  (get object :geometry)
  )

(defn object-texture
  "get texture of an object"
  [object]
  (get object :texture)
  )

(defn texture-colour
  "get base colour of an texture"
  [texture]
  (get (get texture :plain-colour) :colour)
  )

(defn texture-diffuse
  "get diffuse of an texture"
  [texture]
  (get (get texture :plain-colour) :diffuse)
  )

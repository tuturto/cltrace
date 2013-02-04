(ns cltrace.render
  (:use cltrace.camera
        cltrace.scene
        incanter.core))

(defn render
  "render a scene"
  [scene]
  (matrix-map (fn [ray] (get-colour-of-ray ray scene))
              (get-camera-rays (get scene :camera)))
  )
  
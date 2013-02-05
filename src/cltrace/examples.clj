(ns cltrace.examples
  (:use cltrace.render)
  (import java.io.File)
  (import java.awt.Color)
  (import java.awt.image.BufferedImage)
  (import javax.imageio.ImageIO))

(def scene (hash-map :objects [(hash-map :geometry [:sphere [0.0 6.0 0.0] 6.0]
                                         :texture [:plain-colour
                                                   (hash-map :colour [255 0 0]
                                                             :diffuse 0.5)])
                               (hash-map :geometry [:sphere [0.0 24.0 0.0] 6.0]
                                         :texture [:plain-colour
                                                   (hash-map :colour [0 255 0]
                                                             :diffuse 0.5)])]
                     :lights [[0.0 -20.0 -5.0]]
                     :camera [:grid-camera (hash-map :location [0.0 0.0 -20.0]
                                                     :point-0 [11.0 -7.0 0.0]
                                                     :point-1 [-11.0 15.0 0.0]
                                                     :resolution [255 255])]
                     :background [:plain-colour [0 0 0]]))


(def image-matrix (render scene))

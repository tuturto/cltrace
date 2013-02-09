(ns cltrace.render
  (:use cltrace.camera
        cltrace.scene
        cltrace.sphere
        incanter.core)
  (import java.io.File)
  (import java.awt.Color)
  (import java.awt.image.BufferedImage)
  (import javax.imageio.ImageIO))

(defn render
  "render a scene"
  [scene]
  (matrix-map (fn [ray] (get-colour-of-ray ray scene))
              (get-camera-rays (:camera scene))))

(defn save-rendered-image
  "save rendered image as a png file"
  [image-matrix file-name]
  (let [width (get-in scene [:camera 1 :resolution 0])
        height (get-in scene [:camera 1 :resolution 1])
        bi (BufferedImage. width height BufferedImage/TYPE_INT_ARGB)
        g (.createGraphics bi)]
    (do
      (.setColor g (Color. 0 0 0))
      (.fillRect g 0 0 width height)
      (doseq [[[x y] high] image-matrix]
        (.setColor g (Color. (int (nth high 0))
                   (int (nth high 1))
                   (int (nth high 2))))        
        (.fillRect g x y 1 1))
      (ImageIO/write bi "png" (File. file-name)))))

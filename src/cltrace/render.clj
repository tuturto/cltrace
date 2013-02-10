(ns cltrace.render
  (:use cltrace.camera
        cltrace.scene
        cltrace.sphere)
  (import java.io.File)
  (import java.awt.Color)
  (import java.awt.image.BufferedImage)
  (import javax.imageio.ImageIO))

(defn render
  "render a scene"
  [scene]
  (map (fn [ray] [(get-colour-of-ray (nth ray 0) scene)
                  (nth ray 1)])
       (get-camera-rays (:camera scene))))

(defn save-rendered-image
  "save rendered image as a png file"
  [image-matrix file-name width height]
  (let [bi (BufferedImage. width height BufferedImage/TYPE_INT_ARGB)
        g (.createGraphics bi)]
    (do
      (.setColor g (Color. 0 0 0))
      (.fillRect g 0 0 width height)
      (doseq [item image-matrix]
        (.setColor g (Color. (int (get-in item [0 0]))
                   (int (get-in item [0 1]))
                   (int (get-in item [0 2]))))        
        (.fillRect g (get-in item [1 0]) (get-in item [1 1]) 1 1))
      (ImageIO/write bi "png" (File. file-name)))))

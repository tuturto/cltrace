(ns cltrace.scene-test
  (:use clojure.test
        cltrace.scene))

(deftest test-getting-ray-scene-intersections
  (let [scene (hash-map :objects
                        (list (hash-map :geometry '(:sphere (0.0 6.0 0.0) 6.0),
                                        :texture (list :plain-colour
                                                       (hash-map :colour '(255 0 0),
                                                                 :diffuse 0.5))
                                        )
                              (hash-map :geometry '(:sphere (0.0 24.0 0.0) 6.0),
                                        :texture (list :plain-colour
                                                       (hash-map :colour '(0 255 0),
                                                                 :diffuse 0.5))
                                        )
                              )
                        :lights 
                        (list '(0.0 -20.0 -5.0)),
                        :camera
                        (list :grid-camera (hash-map :location '(0.0 0.0 -20.0),
                                                     :point-0 '(11.0 -7.0 0.0),
                                                     :point-1 '(-11.0 15.0 0.0),
                                                     :resolution '(255 255)))
                        )
        ray (list '(0.0 -10.0 0.0) '(0.0 1.0 0.0))]
    (list
     (is (= (nth (nth (get-object-ray-intersections ray scene) 0) 1)
            '(0.0 0.0 0.0)))
     (is (= (nth (nth (get-object-ray-intersections ray scene) 1) 1)
            '(0.0 18.0 0.0)))
     )
    )
  )
  


(deftest test-getting-closest-ray-scene-intersection
  (let [scene (hash-map :objects
                        (list (hash-map :geometry '(:sphere (0.0 6.0 0.0) 6.0),
                                        :texture (list :plain-colour
                                                       (hash-map :colour '(255 0 0),
                                                                 :diffuse 0.5))
                                        )
                              (hash-map :geometry '(:sphere (0.0 24.0 0.0) 6.0),
                                        :texture (list :plain-colour
                                                       (hash-map :colour '(0 255 0),
                                                                 :diffuse 0.5))
                                        )
                              )
                        :lights 
                        (list '(0.0 -20.0 -5.0)),
                        :camera
                        (list :grid-camera (hash-map :location '(0.0 0.0 -20.0),
                                                     :point-0 '(11.0 -7.0 0.0),
                                                     :point-1 '(-11.0 15.0 0.0),
                                                     :resolution '(255 255)))
                        )
        ray (list '(0.0 -10.0 0.0) '(0.0 1.0 0.0))]
    (is (= (intersection-point (get-closest-object-ray-intersection ray scene))
           '(0.0 0.0 0.0)))
    )
  )

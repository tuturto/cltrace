(ns cltrace.camera-test
  (:use clojure.test
        cltrace.camera
        cltrace.helpers))

(deftest test-getting-grid
  (is (in? (get-grid (list :grid-camera (hash-map :location '(0.0 0.0 0.0),
                                                  :point-0 '(0.0 0.0 10.0),
                                                  :point-1 '(10.0 10.0 10.0),
                                                  :resolution '(11 11)))) 
           '(10 10 10)))
  )

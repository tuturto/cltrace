(ns cltrace.camera-test
  (:use clojure.test
        cltrace.camera
        cltrace.helpers
        cltrace.math))

(deftest test-getting-grid-cell
  (let [grid (get-grid (list :grid-camera (hash-map :location '(0.0 0.0 0.0),
                                                  :point-0 '(0.0 0.0 10.0),
                                                  :point-1 '(10.0 10.0 10.0),
                                                  :resolution '(11 11))))]
    (list
     (is (= (nth (nth grid 10) 10) (list 10.0 10.0 10.0)))
     (is (= (nth (nth grid 0) 0) (list 0.0 0.0 10.0)))
     )
    )
  )

(deftest test-getting-camera-rays
  (let [rays (get-camera-rays (list :grid-camera (hash-map :location '(5.0 5.0 0.0),
                                                  :point-0 '(0.0 0.0 10.0),
                                                  :point-1 '(10.0 10.0 10.0),
                                                  :resolution '(11 11))))]
    (list
     (is (= (nth (nth rays 5) 5) (list 
                                  '(5.0 5.0 0.0)
                                  (normalize-vector '(0.0 0.0 1.0)))))
     (is (= (nth (nth rays 10) 10) (list
                                    '(5.0 5.0 0.0)
                                    (normalize-vector '(5.0 5.0 10.0)))))
     )
    )
  )

(ns cltrace.camera-test
  (:use clojure.test
        cltrace.camera
        cltrace.helpers))

(deftest test-getting-grid-last-cell
  (let [grid (get-grid (list :grid-camera (hash-map :location '(0.0 0.0 0.0),
                                                  :point-0 '(0.0 0.0 10.0),
                                                  :point-1 '(10.0 10.0 10.0),
                                                  :resolution '(11 11))))]
    (is (= (nth (nth grid 10) 10) (list 10.0 10.0 10.0)))
    )
  )

(deftest test-getting-grid-first-cell
  (let [grid (get-grid (list :grid-camera (hash-map :location '(0.0 0.0 0.0),
                                                  :point-0 '(0.0 0.0 10.0),
                                                  :point-1 '(10.0 10.0 10.0),
                                                  :resolution '(11 11))))]
    (is (= (nth (nth grid 0) 0) (list 0.0 0.0 10.0)))
    )
  )

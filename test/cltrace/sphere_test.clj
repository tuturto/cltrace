(ns cltrace.sphere-test
  (:use clojure.test
        cltrace.geometry
        cltrace.sphere))

(deftest test-closest-sphere-intersection
  (is (= [5 0 0] (closest-intersection (list [0 0 0] [1 0 0])
                               (list :sphere [10 0 0] 5)
                                        ))))

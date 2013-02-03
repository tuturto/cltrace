(ns cltrace.sphere-test
  (:use clojure.test
        cltrace.geometry
        cltrace.sphere))

(deftest test-closest-sphere-intersection
  (is (= [5 0 0] (closest-intersection (list :sphere [10 0 0] 5)
                  						(list [0 0 0] [1 0 0])
                                        ))))

(deftest test-no-intersection
  (is (= nil (closest-intersection (list :sphere [10 0 0] 5)
                                   (list [0 0 0] [0 1 0])
                                   ))))

(def test-no-intersection-behind-ray
  (is (= nil (closest-intersection (list :sphere [0.0 10.0 0.0] 5)
                                   (list [0.0 0.0 0.0] [0.0 -1.0 0.0])
                                   ))))

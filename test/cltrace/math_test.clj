(ns cltrace.math-test
  (:use clojure.test
        cltrace.math))

(deftest test-dot-length-3
    (is (= 29 (dot [2 3 4] [2 3 4]))))

(deftest test-dot-lentgh-1
    (is (= 4 (dot [2] [2]))))

(deftest test-cross-simple
    (is (= [-1 2 -1] (cross [1 2 3] [2 3 4]))))

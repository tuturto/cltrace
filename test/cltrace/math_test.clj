(ns cltrace.math-test
  (:use clojure.test
        cltrace.math))

(deftest test-dot-length-3
    (is (= 29 (dot-product [2 3 4] [2 3 4]))))

(deftest test-dot-lentgh-1
    (is (= 4 (dot-product [2] [2]))))

(deftest test-cross-simple
    (is (= [-1 2 -1] (cross-product [1 2 3] [2 3 4]))))

(deftest test-vector-length-short
  (is (= 2 (vector-length '(2)))))

(deftest test-vector-lenght-2
  (is (= 5 (vector-length '(3 4)))))

(deftest test-vector-length
  (is (= 5 (vector-length '(5 0 0)))))

(deftest test-normalize-vector
  (is (= '(1 0 0) (normalize-vector '(5 0 0)))))

(deftest test-distance
  (list
   (is (= (distance [0.0 0.0 0.0] [5.0 0.0 0.0]) 5.0))
   (is (= (distance [2.0 0.0 0.0] [-2.0 0.0 0.0]) 4.0))
   (is (= (distance [2.0 2.0 0.0] [-1.0 6.0 0.0]) 5.0))
   )
  )

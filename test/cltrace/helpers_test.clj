(ns cltrace.helpers-test
  (:use clojure.test
        cltrace.helpers))

(deftest should-report-false-when-not-found
  (is (= false (in? '(1 2 3 4) 5)))
  )

(deftest should-report-true-when-found
  (is (= true (in? '(1 2 3 4) 4)))
  )

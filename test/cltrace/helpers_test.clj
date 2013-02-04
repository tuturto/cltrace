(ns cltrace.helpers-test
  (:use clojure.test
        cltrace.helpers))

(deftest should-report-falsey-when-not-found
  (is (= nil (in? '(1 2 3 4) 5)))
  )

(deftest should-report-truthy-when-found
  (is (= 4 (in? '(1 2 3 4) 4)))
  )

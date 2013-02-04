(ns cltrace.helpers)

(defn in?
  "true if seq contains item"
  [seq item]
  ((set seq) item))

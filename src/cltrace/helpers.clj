(ns cltrace.helpers)

(defn in? 
  "true if seq contains item"
  [seq item]  
  (true? (some (fn [x] (= item x)) seq)))


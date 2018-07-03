(defn check
  "Returns `true` if 'ei' follows 'c', or if the word does not contain 'ei'."
  [word]
  (cond
    (.contains word "cie") false
    (and (.contains word "ei")
         (not (.contains word "cei"))) false
    :else true))

; tests
(map check ["a" "zombie" "transceiver" "veil" "icier"])

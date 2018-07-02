; TODO: params should be a string in format "DdS" to be parsed, ex: "3d6"
(defn roll-dice
  [dice sides]
  (loop [remaining-dice dice
         rolls []]
    (if (> remaining-dice 0)
      (recur (dec remaining-dice)
             (conj rolls (inc (rand-int sides))))
      rolls)))

; TODO: return this formatted string from roll-dice, instead of the vector of
; rolls
(let [results (roll-dice 5 8)
      results-as-string (clojure.string/join " " results)
      total (apply + results)]
  (str total ": " results-as-string))

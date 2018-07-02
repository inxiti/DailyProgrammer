(ns com.subpxl
  (:require [clojure.string :as string]))

; TODO: params should be a string in format "DdS" to be parsed, ex: "3d6"
(defn roll-dice
  "Rolls `amount` of dice, with `sides`."
  [amount sides]
  (loop [remaining-dice amount
         rolls []]
    (if (pos? remaining-dice)
      (recur (dec remaining-dice)
             (conj rolls (inc (rand-int sides))))
      (str (apply + rolls) ": " (string/join " " rolls)))))

; (roll-dice "3d20") ; goal
(roll-dice 5 20)
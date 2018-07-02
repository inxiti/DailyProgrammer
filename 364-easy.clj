(defn roll-dice [s]
  (let [numbers (clojure.string/split s #"[dD]")
        dice    (Integer/parseInt (first numbers))
        sides   (Integer/parseInt (last numbers))
        rolls   (take dice (repeatedly #(inc (rand-int sides))))
        total   (apply + rolls)]
    (str total ": " (clojure.string/join " " rolls))))

    (roll-dice "3d20")


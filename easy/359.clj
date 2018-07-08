(defn paper-fold
  "Paper fold up to `n` times."
  [n]
  (loop [counter 0
         sequence "1"]
    (if (>= counter n)
      sequence
      (recur (inc counter)
             ; can't this be done with a zip? zipping the first(altered) and
             ; second(unaltered) easier?
             (str (apply str (map #(str (if (= (mod (first %) 2) 0) "1" "0")
                                        (second %))
                                  (map-indexed vector sequence)))
                  "0")))))

(paper-fold 8)
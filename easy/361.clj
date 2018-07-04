(defn score-player [ch s]
  (hash-map (keyword ch)
            (- (+ (count (filter #(= (clojure.string/lower-case ch) %) s)) 0)
               (count (filter #(= (clojure.string/upper-case ch) %) s)))))

(defn score [s]
  (let [ss (clojure.string/split s #"")
        uniqs (clojure.string/split (->> s
                                         clojure.string/lower-case
                                         distinct
                                         (apply str))
                                    #"")
        scores (into {} (map #(score-player % ss) uniqs))]
    (reverse (sort-by val scores))))

(score "EbAAdbBEaBaaBBdAccbeebaec")

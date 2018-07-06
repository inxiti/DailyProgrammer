(def challenges
  {0 "    _  _     _  _  _  _  _ 
  | _| _||_||_ |_   ||_||_|
  ||_  _|  | _||_|  ||_| _|", ; = 123456789
   1 "    _  _  _  _  _  _  _  _ 
|_| _| _||_|| ||_ |_| _||_ 
  | _| _||_||_| _||_||_  _|", ; = 433805825
   2 " _  _  _  _  _  _  _  _  _ 
|_  _||_ |_| _|  ||_ | ||_|
 _||_ |_||_| _|  ||_||_||_|", ; = 526837608
   3 " _  _        _  _  _  _  _ 
|_||_ |_|  || ||_ |_ |_| _|
 _| _|  |  ||_| _| _| _||_ " ; = 954105592
})

(def legend {" _ | ||_|" 0,
             "     |  |" 1,
             " _  _||_ " 2,
             " _  _| _|" 3,
             "   |_|  |" 4,
             " _ |_  _|" 5,
             " _ |_ |_|" 6,
             " _   |  |" 7,
             " _ |_||_|" 8,
             " _ |_| _|" 9})

(defn decipher
  "Decipher seven segment display `s`, for nine numbers."
  [s]
  (let [input (clojure.string/split s #"\n")
        numbers 9  ; amount of digits
        width   3  ; width of digit
        height  3] ; height of digit
    (loop [begin  0
           result ""]
      (if (> begin (* (dec numbers) width))
        result
        (recur (+ begin width)
               (str result
                    (legend (apply str
                                   (map #(subs (input %) begin (+ begin width))
                                        (range height))))))))))

(map (comp decipher val) challenges)
; => ("123456789" "433805825" "526837608" "954105592")
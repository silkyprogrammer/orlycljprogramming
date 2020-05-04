(ns orlycljprogramming.chapter2)

;all of them will return true
(= 5 5)
(= 5 (+ 2 3) )
(= "boot" (str "bo" "ot"))

;How clojure handles immutability
(def h {[1 2] 3})
(h [1 2])
(conj (first (keys h)) 3)
(h [1 2])
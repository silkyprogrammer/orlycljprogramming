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

; calling a function twice
(defn call-twice
  "do anything I ask twice
  [f x]"
  (f x)
  (f x)
  )
(call-twice println 123)

(max 5 6)
(require 'clojure.string)
(clojure.string/lower-case "Clojure")

;maps
(map clojure.string/lower-case  ["Java" "Ruby"
                                 "World" "Peace" "Python"])
(map * [1 2 3 4] [1 2 3 4])

(reduce max [0 -3 10 48])

(reduce
  (fn [m v]
    (assoc m v (* v v)))
  {}
  [1 2 3 4 5])

(reduce
  #(assoc % %2 (* %2 %2))
  {}
  [1 2 3 4 5])

(apply hash-map [:a 5 :b 6])
(def args [2 -2 10])
(apply * 0.5 3 args)

(def only-strings (partial filter string?))
(only-strings ["a" 5 "b" 6])
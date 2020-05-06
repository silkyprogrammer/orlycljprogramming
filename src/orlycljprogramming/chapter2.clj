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

;Function compositions
(defn negated-sum-str
  "Function compositions"
  [& numbers]
  (str (- (apply + numbers)))
  )

(def negated-sum-str (comp str - +))

(require '[clojure.string :as str])
(def camel->keyword (comp keyword
                          str/join
                          (partial interpose \-)
                          (partial map str/lower-case)
                          #(str/split % #"(?<=[a-z])(?=[A-Z])")))

(defn camel->keyword2
  "A different approach"
  [s]
  (->> (str/split s #"(?<=[a-z])(?=[A-Z])")
       (map str/lower-case)
       (interpose \-)
       str/join
       keyword))
(def camel-pairs->map
    (comp (partial apply hash-map)
          (partial map-indexed (fn [i x]
                                 (if (odd? i)
                                   x
                                   (camel->keyword x))))))

; HOF (higher order functions)
(defn adder
  "A trivial example of HOF"
  [n]
  (fn [x] (+ n x)))

(defn doubler
  "A less trivial function example"
  [f]
  (fn [& args]
    (* 2 (apply f args))))
(def double-+ (doubler +))

(defn prime?
  "Check whether given integer is Prime or not"
  [n]
  (cond
    (== 1 n) false
    (== 2 n) true
    (even? n) false
    :else (->> (range 3 (inc (Math/sqrt n)) 2)
               (filter #(zero? (rem n %)))
               empty?)))
;Memoization
(let [m-prime? (memoize prime?)]
  (time (m-prime? 1125899906842679))
  (time (m-prime? 1125899906842679)))
;results
;"Elapsed time: 604.370919 msecs"
;"Elapsed time: 0.013111 msecs"


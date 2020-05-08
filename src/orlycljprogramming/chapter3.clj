(ns orlycljprogramming.chapter3)
;;list
'(a b :name 12.5)
;; vector
['a 'b :name 12.5]
;;map
{:name "Chas" :age 31}
;;set
#{1 2 3}
;; Another map
{Math/PI "~3.14"
 [:composite "key"] 42
 nil "nothing"}

#{{:fist-name "chas" :last-name "emerick"}
  {:first-name "brian" :last-name "carper"}
  {:first-name "christophe" :last-name "grand"}}

(def v [1 2 3])
(conj v 4)
(conj v 4 5)
(seq v)

(def m {:a 5 :b 6})
(conj m [:c 7])
(seq m)

(def s #{1 2 3})
(conj s 10)
(conj s 3 4)
(seq s)

(def lst '(1 2 3))
(conj lst 0)
(conj lst 0 -1)
(conj lst 10)
(seq lst)
(count lst)

(seq "Clojure")
(seq {:a 4 :b 5})
(seq (java.util.ArrayList. (range 5)))
(seq (into-array ["Clojure" "Programming"]))
(seq [])
(seq nil)
(map str "Clojure")
(set "Programming")


(first "Clojure")
(first (map str  (set "Programming")))
(rest "Clojure")
(rest (map str  (set "Programming")))
(next "Clojure")
(next (map str  (set "Programming")))

(def x [1 2 3 ])
(= (next x)
   (seq (rest x)))
(rest x)
(seq (rest x))
(next x)

(doseq [x (range 3)]
  (println x))
(let [r (range 3)
      rst (rest r)]
  (prn (map str rst))
  (prn (map #(+ 100 %) r))
  (prn (conj r -1) (conj rst 42)))

(let [s (range 1e6)]
  (time (count s)))

(let [s (apply list (range 1e6))]
  (time (count s)))

(cons 0 (range 1 5))
(cons :a [:b :c :d])
(cons 0 (cons 1 (cons 2 (cons 3 (range 4 10)))))
(list* 0 1 2 3 (range 4 10))

(lazy-seq [1 2 3])
(defn random-ints
  "Implementing a lazy sequence. Returns a lazy seq of random integers in the range [0, limit)."
  [limit]
  (lazy-seq
    (cons (rand-int limit)
          (random-ints limit)))
  )


(defn random-ints
  [limit]
  (lazy-seq
    (println "realizing random number")
    (cons (rand-int limit)
          (random-ints limit)))
  )

(def rands (take 10 (random-ints 50)))

(first rands)
(nth rands 3)
(count rands)

(repeatedly 10 (partial rand-int 50))


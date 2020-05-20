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

(def x (next (random-ints 50)))
(def x (rest (random-ints 50)))

(let [[x & rest] (random-ints 50)])
(dorun (take 5 (random-ints 50)))

(doc iterate)
(doc reverse)

(apply
  str
  (remove (set "aeiouy")
  "vowels are useless! or may be not ..."))
(split-with neg?(range -5 5))

;; This will cause OOM Error
(let [[t d] (split-with #(< % 12) (range 1e8))]
  [(count d) (count t)])

;; reverse the computation to get it working.
(let [[t d] (split-with #(< % 12) (range 1e8))]
  [(count t) (count d)])


;;associative data structure is map
(def m {:a 1 :b 2 :c 3 :d 4})
(get m :a)
(print m)
(assoc m :e 5)
(dissoc m :b)

(assoc m
  :x 4
  :y 5
  :z 6)
(dissoc m :a :c)

(def v [1 2 3])
(get v 1)
(get v 10 )
(get v 10 "not-found")
;;updating the vector using assoc
(assoc v
  1 4
  0 -12
  2 :P)
(assoc v 3 10)

(get #{1 2 3} 2)
(get #{1 2 3} 4)
(get #{1 2 3} 4 "not-found")

(when (get #{1 2 3} 2)
  (println "It contains `2`"))

;; checks whether an item is available at index 0
(contains? [1 2 3] 0)
(contains? {:a 1 :b 2} :b)
(contains? {:a 1 :b 2} 42)
;; 1 is associated to key 1, hence true , 4 is not there hence false.
(contains? #{1 2 3} 1)
(contains? #{1 2 3} 4)

(get "Clojure" 3)
(contains? (java.util.HashMap.) "not-there")
(get (into-array [1 2 3])0)

(get {:ethel nil} :lucy)
(get {:ethel nil} :ethel)
(find {:ethel nil} :lucy)
(find {:ethel nil} :ethel)

(if-let [e (find {:a 5 :b 6} :a)]
  (format "found %s=>%s" (key e) (val e))
  "not found")
(if-let [e (find {:a 5 :b 6} :c)]
  (format "found %s=>%s" (key e) (val e))
  "not found")

(if-let [[k v] (find {:a 5 :b 6} :a)]
  (format "found %s=>%s" k v)
  "not-found")

(nth [:a :b :c] 2)
(get [:a :b :c] 2)
(nth [:a :b :c] 3)
(get [:a :b :c] 3)
(nth [:a :b :c] -1)
(get [:a :b :c] -1)

(nth [:a :b :c] -1 :not-found)
(get [:a :b :c] -1 :not-found)

;; stacks in clojure achieved through conj, pop, peek
;; lists and vectors are used as stacks.

(conj '() 1)
(conj '(2 1) 3)
(peek '(3 2 1))
(pop '(3 2 1))
(pop '(1))

(conj [] 1)
(conj [1 2] 3)
(peek [1 2 3])
(pop [1 2 3])
(pop [1])
;; gets an error, coz stack is empty
(pop [])

;Set
(get #{1 2 3} 2)
(get #{1 2 3} 4)
(get #{1 2 3} 4 "not-found")
(disj #{1 2 3} 3 1)

(def sm (sorted-map :z 5 :x 9 :y 0 :b 2 :a 3 :c 4))
(rseq sm)
(subseq sm <= :c)
(rsubseq sm <= :c)
(subseq sm > :b <= :y)
(rsubseq sm > :b <= :y)


(compare 2 2)
(compare "ab" "abc")
(compare ["a" "b" "c"] ["a" "b"])
(compare ["a" 2] ["a" 2 0])


(sort < (repeatedly 10 #(rand-int 100)))
(sort-by first > (map-indexed vector "Clojure"))

(map :name [{:age 21 :name "david"}
            {:gender :f :name "Suzanne"}
            {:name "Sara" :location "NYC"}])

(some #{1 3 7} [0 2 4 5 6])
(some #{1 3 7} [0 2 3 4 5 6])

(filter :age [{:age 21 :name "David"}
              {:gender :f :name "Suzanne"}
              {:name "Sara" :location "NYC"}])
(filter (comp (partial <= 25) :age)
        [{:age 21 :name "David"}
         {:gender :f :name "Suzanne" :age 20}
         {:name "Sara" :location "NYC" :age 34}])



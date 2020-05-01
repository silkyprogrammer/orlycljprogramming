(ns orlycljprogramming.core)

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(defn average
  "docstring"
  [numbers]
  (/ (apply + numbers) (count numbers))
  )

(do
  (println "hi")
  (apply * [4,5,6]))


(do
  (println "hi")
  (apply * [4 5 6]))

(let [a (inc (rand-int 6)),
      b (inc (rand-int 6))]
  (println (format "You rolled a %s and a %s" a b))
  (+ a b))

(defn hypot
  [x y]
  (let [x2 (* x x)
        y2 (* y y)]
    (Math/sqrt (+ x2 y2))))

(def v [42 "foo" 99.2 [5 ,12]])
(first v)
(second v)
(last v)
(nth v 2)
(.get v 1)
(v 2)
(+ (first v) (v 2))
(+ (first v) (first (last v)))

;(def v [42 "foo" 10 [5 20]])

(let [[w x y z] v]
  (apply + z)
  (apply * z)
  ;(apply + w y (apply + z))
  )

(let [[w x y [z a]] v]
  ;(apply + z)
  ;(apply * z)
  ;(apply + w y (apply + z))
  (+ z a)
  (+ w z a)
  )

(let [[x _ _ [y z]] v]
  (+ x y z))

(def m {:a 5 :b 6 :c [7 8 9]
        :d {:e 10 :f 11} "foo" 88
        42 false})

; a & b is added from "m".
(let [{a :a b :b} m]
  (+ a b))

; foo value is assigned to f, and then +12 is added.
(let [{ f "foo"} m]
  (+ f 12))

(let [{[x _ y] :c} m] (+ x y))


(def map-in-vector ["James" {:birthday (java.util.Date. 73 1 6)}])

(let [[name {bd :birthday}] map-in-vector]
  (str name " was born on " bd))

(def chass {:name "Chas" :Age 31 :location "Bangalore"})

(let [{name :name age :Age location :location} chass]
  (format "%s is %s years old and lives in %s." name age location))

(let [{:keys [name age location]} chass]
  (format "%s is %s years old and lives in %s." name age location))

(fn [x]
  (+ 10 x))

(defn concat-rest
  "docstring"
  [x & rest]
  (apply str (butlast rest))
  )

(defn make-user
  [& [user-id]]
  {:user-id (or user-id (str (java.util.UUID/randomUUID)))})


(defn make-user
  [username & {:keys [email join-date]
               :or {join-date (java.util.Date.)}}]
  {:username username
   :join-date join-date
   :email email
   :exp-date (java.util.Date. (long (+ 2.592e9 (.getTime join-date))))}
  )

(defn foo
  [& {k ["m" 9]}] (inc k))

(fn [x y ] (Math/pow x y))

(defn countdown
  "docstring"
  [x]
  (if (zero? x)
    :blastoff!
    (do (println x)
        (recur (dec x))))
  )








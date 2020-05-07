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
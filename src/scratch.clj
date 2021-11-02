(ns scratch)

;;; Loop and reduce

;; Implement reduce with loop

(defn -reduce
  [f init coll]
  ())

(comment
  (-reduce + 0 [1 2 3 4]);; => 10
  (-reduce conj [] [1 2 3 4]);; => [1 2 3 4]
  (-reduce conj () [1 2 3 4]);; => (4 3 2 1)
  )

;;; Map and Filter
;; Implement map with loop

(defn -map
  [f coll]
  ())

(-map inc [1 2 3 4])

;; Implement map with -reduce

(defn -map
  ([f coll]
   (-map f [] coll))
  ([f init coll]
   ()))

;; Same for filter

(defn -filter
  [pred coll]
  ())

(-filter even? [1 2 3 4])

(defn -filter
  ([pred coll]
   (-filter pred [] coll))
  ([pred init coll]
   ()))

(-filter even? [1 2 3 4])

;;; Refactor
;; Extract the core process from map:


(defn map-core
  [f]
  ())

(defn -map
  ([f coll]
   (-map f [] coll))
  ([f init coll]
   (-reduce (map-core f) init coll)))

(-map inc [1 2 3 4])

;; Filter


(defn filter-core
  [pred]
  ())

(defn -filter
  ([pred coll]
   (-filter pred [] coll))
  ([pred init coll]
   (-reduce (filter-core pred) init coll)))

(-filter even? [1 2 3 4])

;;; Push / Pull
;; Factor accumulation out of map

(defn map-core
  [f accumulate]
  ())

(defn -map
  ([f coll]
   (-map f [] coll))
  ([f init coll]
   (-reduce (map-core f conj) init coll)))

(-map inc [1 2 3 4])

;; Now with currying

(defn map-core
  [f]
  ())

(defn -map
  ([f coll]
   (-map f [] coll))
  ([f init coll]
   (-reduce ((map-core f) conj) init coll)))

(-map inc [1 2 3 4])

;; Do the same with filter

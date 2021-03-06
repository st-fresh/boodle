(ns boodle.utils.numbers)

(defn en->ita
  [x]
  (-> x
      .toString
      (clojure.string/replace #"\." ",")))

(defn convert-amount
  [m k]
  (->> (get m k 0)
       en->ita
       (assoc m k)))

(defn or-zero
  [x]
  (if x
    x
    0))

(defn str->integer
  [s]
  (if (string? s)
    (Integer/parseInt s)
    s))

(defn strs->integers
  [xs]
  (if (sequential? xs)
    (map #(Integer/parseInt %) xs)
    (Integer/parseInt xs)))

(defn record-str->double
  [record k]
  (let [s (k record)
        n (clojure.string/replace s #"," ".")]
    (->> n
         Double/parseDouble
         (assoc record k))))

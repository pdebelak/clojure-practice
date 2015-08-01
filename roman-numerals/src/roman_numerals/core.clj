(ns roman-numerals.core
  (:gen-class))

(def roman-table
  [
   {:num 1000 :char "m"}
   {:num 900 :char "cm"}
   {:num 500 :char "d"}
   {:num 400 :char "cd"}
   {:num 100 :char "c"}
   {:num 90 :char "xc"}
   {:num 50 :char "l"}
   {:num 40 :char "xl"}
   {:num 10 :char "x"}
   {:num 9 :char "ix"}
   {:num 5 :char "v"}
   {:num 4 :char "iv"}
   {:num 1 :char "i"}
   ]
  )

(defn int-to-roman
  ([to-convert]
   (let [chars []]
     (int-to-roman to-convert chars roman-table)))
  ([to-convert chars table]
  (if (= to-convert 0)
    (apply str chars)
    (let [[conversion & remaining-table] table
          num (get conversion :num)
          char (get conversion :char)]
      (if (>= to-convert num)
        (int-to-roman (- to-convert num) (conj chars char) table)
        (int-to-roman to-convert chars remaining-table))))))

(defn roman-to-int
  ([to-convert]
  (let [conversion-table (into {} (map (fn [map] {(:char map) (:num map)}) roman-table))]
    (roman-to-int (clojure.string/split to-convert #"") 0 conversion-table)))
  ([to-convert total conversion-table]
   (if (empty? to-convert)
     total
     (let [[first-char second-char & rest] to-convert]
       (if second-char
        (if (get conversion-table (clojure.string/join [first-char second-char]))
            (roman-to-int rest (+ total (get conversion-table (clojure.string/join [first-char second-char]))) conversion-table)
            (roman-to-int (conj rest second-char) (+ total (get conversion-table first-char)) conversion-table))
        (roman-to-int rest (+ total (get conversion-table first-char)) conversion-table))))))

(defn roman-convert
  "Converts integers to roman numerals and vice versa"
  [to-convert]
  (if (string? to-convert)
    (roman-to-int to-convert)
    (int-to-roman to-convert)))

(defn -main
  "I don't do a whole lot ... yet."
  [arg & args]
  (if (re-seq #"[0-9]+" arg)
    (println (roman-convert (Integer. arg)))
    (println (roman-convert arg))
    ))

(ns fizz-buzz.core
  (:gen-class))

(defn divisible?
  [divisor]
  (fn
    [num]
    (= (mod num divisor) 0)
    )
  )

(defn fizz?
  [num]
  ((divisible? 3) num)
  )

(defn buzz?
  [num]
  ((divisible? 5) num)
  )

(defn fizz-buzzer
  "Returns the number or appropriate word"
  [num]
  (if (and (buzz? num) (fizz? num))
    "FizzBuzz"
    (if (buzz? num)
        "Buzz"
        (if (fizz? num)
            "Fizz"
            num
        )
      )
    )
  )

(defn fizz-buzz
  "Calls fizz-buzzer on first 100 integers"
  []
  (map fizz-buzzer (range 1 101))
  )

(defn -main
  "Prints first 100 numbers as fizz buzz"
  [& args]
  (doseq [i (fizz-buzz)]
    (println i)
    ))

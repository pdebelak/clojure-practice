(ns fizz-buzz.core-test
  (:require [clojure.test :refer :all]
            [fizz-buzz.core :refer :all]))

(deftest fizz-buzz-test
  (testing "fizz-buzz"
    (is (= (count (fizz-buzz)) 100))
    (is (= (first (fizz-buzz)) 1))
    (is (= (last (fizz-buzz)) "Buzz"))
    (is (= (nth (fizz-buzz) 29) "FizzBuzz"))
    )
  )

(deftest fizz-buzzer-test
  (testing "fizz-buzzer"
    (is (= (fizz-buzzer 1) 1))
    (is (= (fizz-buzzer 2) 2))
    (is (= (fizz-buzzer 3) "Fizz"))
    (is (= (fizz-buzzer 5) "Buzz"))
    (is (= (fizz-buzzer 9) "Fizz"))
    (is (= (fizz-buzzer 10) "Buzz"))
    (is (= (fizz-buzzer 15) "FizzBuzz"))
    )
  )

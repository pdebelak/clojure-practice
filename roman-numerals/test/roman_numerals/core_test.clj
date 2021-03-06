(ns roman-numerals.core-test
  (:require [clojure.test :refer :all]
            [roman-numerals.core :refer :all]))

(deftest to-roman
  (testing "Changing integers to roman numerals"
    (is (= (roman-convert 1) "i"))
    (is (= (roman-convert 2) "ii"))
    (is (= (roman-convert 4) "iv"))
    (is (= (roman-convert 5) "v"))
    (is (= (roman-convert 6) "vi"))
    (is (= (roman-convert 9) "ix"))
    (is (= (roman-convert 10) "x"))
    (is (= (roman-convert 20) "xx"))
    (is (= (roman-convert 40) "xl"))
    (is (= (roman-convert 50) "l"))
    (is (= (roman-convert 90) "xc"))
    (is (= (roman-convert 100) "c"))
    (is (= (roman-convert 400) "cd"))
    (is (= (roman-convert 500) "d"))
    (is (= (roman-convert 900) "cm"))
    (is (= (roman-convert 1000) "m"))
    (is (= (roman-convert 3999) "mmmcmxcix"))
    (is (= (roman-convert 2015) "mmxv"))
    (is (= (roman-convert 238) "ccxxxviii"))
    )
  )

(deftest to-int
  (testing "Changing roman numerals to integers"
    (is (= (roman-convert "i") 1))
    (is (= (roman-convert "ii") 2))
    (is (= (roman-convert "iv") 4))
    (is (= (roman-convert "v") 5))
    (is (= (roman-convert "ix") 9))
    (is (= (roman-convert "x") 10))
    (is (= (roman-convert "xx") 20))
    (is (= (roman-convert "xl") 40))
    (is (= (roman-convert "l") 50))
    (is (= (roman-convert "xc") 90))
    (is (= (roman-convert "c") 100))
    (is (= (roman-convert "cd") 400))
    (is (= (roman-convert "d") 500))
    (is (= (roman-convert "cm") 900))
    (is (= (roman-convert "m") 1000))
    (is (= (roman-convert "mmmcmxcix") 3999))
    (is (= (roman-convert "mmxv") 2015))
    (is (= (roman-convert "ccxxxviii") 238))
    )
  )

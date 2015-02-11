(ns hello-clojure-rest-2.bom-test
  (:require [expectations :as e]
            [hello-clojure-rest-2.bom :as bom]))

(e/expect
  1022.2
  (bom/item-price {:price 102.22 :qty 10}))



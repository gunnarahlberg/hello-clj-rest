(ns hello-clojure-rest-2.handler-test
  (:require
            [ring.mock.request :as mock]
            [hello-clojure-rest-2.handler :refer :all])
  (:use expectations))

(expect "{\"id\":1,\"message\":\"hello\"}" (:body (app (mock/request :get "/"))))

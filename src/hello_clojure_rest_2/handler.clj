(ns hello-clojure-rest-2.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.middleware.json :refer [wrap-json-response]]
            [ring.util.response :refer [response]]))

(defroutes app-routes
  (GET "/" [] (wrap-json-response (fn [_] (response {:id 1 :message "hello"}) )))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))

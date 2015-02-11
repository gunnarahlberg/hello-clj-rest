(ns hello-clojure-rest.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.middleware.json :refer [wrap-json-response]]
            [ring.util.response :refer [response]])
<<<<<<< HEAD:src/hello_clojure_rest_2/handler.clj
  )

(defn create-db []
  (try (db-do-commands db (create-table-ddl  :quote
                                             [:customer :text]))
       (catch Exception e (println e))))

=======
  (:use     [korma.core]))
>>>>>>> b9f3e6e72b24bb0d1ad45ef3bbf70783f42a3505:src/hello_clojure_rest/handler.clj

(defroutes app-routes
  ;(GET "/q" [] (wrap-json-response (select quote )))
  (GET "/" [] (wrap-json-response (fn [_] (response {:id 1 :message "hello2"}) )))
  (GET "/bom" [id] (wrap-json-response (fn [_] (response {:id 1 :message "hello2"}) )))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))


;;; start function for starting jetty
(defn start [port]
  (run-jetty #'app {:port (or port 8080) :join? false}))

(defn -main [&args]
  (let [port (Integer/parseInt (System/getenv "PORT"))]
    (start port)))

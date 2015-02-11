(defproject hello-clojure-rest "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.3.1"]
                 [ring/ring-json "0.3.1"]
                 [ring/ring-defaults "0.1.2"]
<<<<<<< HEAD
                 [com.h2database/h2 "1.3.170"]
                 [korma "0.4.0"]
                 [org.clojure/java.jdbc "0.3.5"]
                 [com.novemberain/welle "3.0.0"]]
=======
                 [korma "0.3.0"]
                 [lobo]
                 [org.xerial/sqlite-jdbc "3.7.15-M1"]]
>>>>>>> b9f3e6e72b24bb0d1ad45ef3bbf70783f42a3505
  :plugins [[lein-ring "0.8.13"]
            [lein-expectations "0.0.8"]]
  :ring {:handler hello-clojure-rest.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]
                        [expectations "2.0.9"]]}})

(defproject hello-clojure-rest-2 "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.3.1"]
                 [ring/ring-json "0.3.1"]
                 [ring/ring-defaults "0.1.2"]
                 [com.h2database/h2 "1.3.170"]
                 [korma "0.4.0"]
                 [org.clojure/java.jdbc "0.3.5"]
                 [com.novemberain/welle "3.0.0"]]
  :plugins [[lein-ring "0.8.13"]
            [lein-expectations "0.0.8"]]
  :ring {:handler hello-clojure-rest-2.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]
                        [expectations "2.0.9"]]}})

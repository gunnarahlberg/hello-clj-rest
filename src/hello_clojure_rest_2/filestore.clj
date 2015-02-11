(ns
  ^{:doc "File database storage"}
  hello-clojure-rest-2.filestore

  (:require [clojure.java.io :refer [file]]
            [clojure.edn :as edn]))


(defn- ann [doc id rev]
  (with-meta doc {:id id :rev rev}))

(defn- open-doc [db id]
  (let [doc-dir (file db (str id))
        rev (last (sort (map str (.list doc-dir))))]
    (ann (edn/read-string (slurp (file doc-dir rev)))
         id rev)))

(defn- list-docs [dir]
  (sort (map #(Long. (str %)) (.list (file dir)))))

(defn- find-rev [db-path id]
  (inc (or (last (list-docs (file db-path (str id)))) 0)))

(defn- write-doc! [db-path id doc]
  (let [rev (find-rev db-path id)
        doc-dir (file db-path (str id))]
    (.mkdirs doc-dir)
    (spit (file doc-dir (str rev)) doc)
    (ann doc id rev)))

(defn open [path]
  "Connects you with a database at the specified path. Any missing directory is created "
  (let [dir (file path)]
    (or (.isDirectory dir)
        (.mkdirs dir))
    dir))
(defn find-one [db id]
  "Return whatever first element found by id"
  (open-doc db id))

(defn find-all
  ([db predicate]
     "applies predicate to the database"
    (filter predicate (find-all db)))
  ([db]
     "applies 'find-one' predicate to database"
    (map #(find-one db %) (list-docs db))))

(defn next-id [db]
  "Returns hightest current id or 1, whichever that is bigges"
  (inc (or (last (list-docs db)) 0)))

(defn insert! [db doc]
  "Inserts document to the database with an incremented id"
  (let [id (next-id db)]
    (write-doc! db id doc)))

(defn update! [db id doc]
  "Update database with document"
  (write-doc! db id doc))


(comment
  (require ['hello-clojure-rest-2.filestore :as 'fs])



                                        ; open database, may exist which will read it or not exist which will create it
  (def db (fs/open "/tmp/friends"))

                                        ; save document
                                        ; stored in /tmp/friends/1/1
  (def alice
    (fs/insert! db {:name "Alice"
                    :age 31
                    :interests #{:travel :friends :beauty}}))

                                        ; save document
                                        ; stored in /tmp/friends/2/1
  (def bob
    (fs/insert! db {:name "Bob"
                    :age 29
                    :interests #{:technology :football :cars}}))

                                        ; document id and revision stored in metadata
  (println (meta alice))                ; => {:id 1 :rev 1}
  (println (meta bob))                  ; => {:id 2 :rev 1}

                                        ; update document
                                        ; stored in /tmp/friends/2/2
  (def bob2
    (fs/update! db (:id (meta bob)) {:name "Bob"
                                     :age 23
                                     :interests #{:technology :football :music}}))

  (println (meta bob2))                 ; => {:id 2 :rev 2}

                                        ; retrieve latest rev of a document
  (def res (fs/find-one db (:id (meta bob2))))
  (println (:age  res ) )               ; => 23
  )

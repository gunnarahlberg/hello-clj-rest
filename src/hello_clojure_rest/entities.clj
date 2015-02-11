(ns hello-clojure-rest.entities
  (:use [korma.core]))

;;http://sqlkorma.com/

(defentity customer
           (pk :customer_id)
           (entity-fields :organization_id
                          :primary_contact_id))

(def customer-schema
  "
  CREATE TABLE CUSTOMER (
      id int primary key,
      int primary_contact_id
      )
  ")
(defentity person
           (pk :person_id)
           (entity-fields :fname
                          :lname
                          :ssid
                          :phoneNr
                          :email
                          :org_id))
(defentity organization
           (pk :org_id)
           (entity-fields :parent_id))
(defentity asset
           (pk :asset_id))
(defentity quotation
           (pk :quote_id)
           (entity-fields :customer_id
                          :create_time))

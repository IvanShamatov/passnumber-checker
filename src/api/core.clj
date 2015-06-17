(ns api.core)

(require '[clojure.java.jdbc :as db])

(def mysql-db {:classname "com.mysql.jdbc.Driver"
               :subprotocol "mysql"
               :subname "//127.0.0.1:3306/passports"
               :user "root"
               :password ""})

(defn check-passport
  [serial number]
  (db/query mysql-db
    ["select * from passports where serial = ? and number = ?" serial number]
    :row-fn :cost)
  )




(defn handler [request]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body 'request})



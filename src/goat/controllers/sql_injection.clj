(ns goat.controllers.sql-injection
  (:require [goat.util.templates :refer [render-with-header-and-footer]]
            [monger.core :as mg]
            [monger.collection :as mc]))

(defn- find-all-locations []
  (let [conn (mg/connect)
        db   (mg/get-db conn "clojuregoat")]
    (mc/find-maps db "weather_locations")))

(defn weather []
  (let [locations (find-all-locations)]
  (render-with-header-and-footer "sql-injection" {:locations locations})))
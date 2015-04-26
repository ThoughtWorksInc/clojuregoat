(ns goat.controllers.sql-injection
  (:require [goat.util.templates :refer [render-with-header-and-footer]]
            [monger.core :as mg]
            [monger.collection :as mc]))

(defn- find-all-locations []
  (let [conn (mg/connect)
        db (mg/get-db conn "clojuregoat")]
    (mc/find-maps db "weather_locations")))

(defn- find-location-by-id [location-id]
  (let [conn (mg/connect)
        db (mg/get-db conn "clojuregoat")]
    (mc/find-one-as-map db "weather_locations" {:id location-id})))

(defn weather [selected-location-id]
  (let [all-locations (find-all-locations)
        selected-location (find-location-by-id selected-location-id)
        view-model {:selected-location selected-location
                    :locations         all-locations}]
    (render-with-header-and-footer "sql-injection" view-model)))
(ns goat.controllers.sql-injection
  (:require [goat.util.templates :refer [render-with-header-and-footer]]
            [monger.core :as mg]
            [monger.collection :as mc]))

(defn- create-connected-db []
  (let [conn (mg/connect)]
    (mg/get-db conn "clojuregoat")))

(defn- find-all-locations []
  (-> (create-connected-db) (mc/find-maps "weather_locations")))

(defn- find-location-by-id [location-id]
  (-> (create-connected-db) (mc/find-maps "weather_locations" {:id location-id})))

(defn weather [selected-location-id]
  (let [all-locations (find-all-locations)
        selected-location (find-location-by-id selected-location-id)
        view-model {:selected-location selected-location
                    :locations         all-locations}]
    (render-with-header-and-footer "sql-injection" view-model)))
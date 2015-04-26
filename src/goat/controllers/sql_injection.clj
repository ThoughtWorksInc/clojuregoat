(ns goat.controllers.sql-injection
  (:use [goat.util.templates :only [render-with-header-and-footer]]))

(defn weather []
  (render-with-header-and-footer "sql-injection"))
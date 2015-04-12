(ns goat.controllers.home
  (:use [ring.util.response :only [redirect]]
        [goat.util.templates :only [render-with-header-and-footer]]))

(defn home []
  (render-with-header-and-footer "home"))

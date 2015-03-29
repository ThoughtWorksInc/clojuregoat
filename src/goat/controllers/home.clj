(ns goat.controllers.home
  (:use [ring.util.response :only [redirect]]
        [goat.util.templates :only [render-with-header-and-footer]]))

(defn home [request]
  (render-with-header-and-footer "home"))

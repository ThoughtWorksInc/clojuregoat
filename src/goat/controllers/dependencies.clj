(ns goat.controllers.dependencies
  (:use [ring.util.response :only [redirect]]
        [goat.util.templates :only [render-with-header-and-footer]]))

(defn registration []
  (render-with-header-and-footer "clostache"))

(defn register-account [username]
  (render-with-header-and-footer
    "clostache"
    {:registered true
     :username   username}))
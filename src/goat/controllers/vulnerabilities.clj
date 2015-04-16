(ns goat.controllers.vulnerabilities
  (:use [ring.util.response :only [redirect]]
    [goat.util.templates :only [render-with-header-and-footer]]))

(defn templating [username]
  (render-with-header-and-footer "clostache" {:username username}))

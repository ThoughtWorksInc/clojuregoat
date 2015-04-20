(ns goat.controllers.unvalidated-redirects
  (:use [ring.util.response :only [redirect]]
        [goat.util.templates :only [render-with-header-and-footer]]))

(defn explanation []
  (render-with-header-and-footer "unvalidated-redirects"))

(defn redirector [redirect-url]
  (redirect redirect-url))

(defn redirect-target []
  (render-with-header-and-footer "redirect-target"))
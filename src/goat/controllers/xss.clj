(ns goat.controllers.xss
  (:use [ring.util.response :only [redirect]]
        [goat.util.templates :only [render-with-header-and-footer]]))

(defn search [request]
  (render-with-header-and-footer "search"))

(defn postsearch [query]
    (render-with-header-and-footer "search",  {:results true :query query}))

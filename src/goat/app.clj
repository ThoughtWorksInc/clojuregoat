(ns goat.app
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [goat.controllers.home :as home]
            [goat.controllers.xss :as xss]
            [goat.controllers.error :as error]))

(defroutes router
  (GET  "/"           []         (home/home))
  (GET  "/search"     []         (xss/search))
  (POST "/search"     [query]    (xss/postsearch query))
  (GET  "/dependency" [username] (xss/dependency username))
  (route/resources "/")
  (route/not-found (error/not-found)))

(def app
  (handler/site router))

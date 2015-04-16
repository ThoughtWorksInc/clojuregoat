(ns goat.app
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [goat.controllers.home :as home]
            [goat.controllers.xss :as xss]
            [goat.controllers.vulnerabilities :as vulns]
            [goat.controllers.error :as error]))

(defroutes router
  (GET  "/"   []         (home/home))
  (GET  "/a3" []         (xss/search))
  (POST "/a3" [query]    (xss/postsearch query))
  (GET  "/a9" [username] (vulns/templating username))
  (route/resources "/")
  (route/not-found (error/not-found)))

(def app
  (handler/site router))

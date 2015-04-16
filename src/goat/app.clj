(ns goat.app
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [goat.controllers.home :as home]
            [goat.controllers.xss :as xss]
            [goat.controllers.dependencies :as deps]
            [goat.controllers.error :as error]))

(defroutes router
  (GET  "/"   []         (home/home))
  (GET  "/a3" []         (xss/search))
  (POST "/a3" [query]    (xss/postsearch query))
  (GET  "/a9" []         (deps/registration))
  (POST "/a9" [username] (deps/register-account username))
  (route/resources "/")
  (route/not-found (error/not-found)))

(def app
  (handler/site router))

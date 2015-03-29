(ns goat.app
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [goat.controllers.home :as home]
            [goat.controllers.error :as error]))

(defroutes router
  (GET "/" [request] (home/home request))
  (route/resources "/")
  (route/not-found (error/not-found)))

(def app
  (handler/site router))

(ns goat.app
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [goat.controllers.home :as home]
            [goat.controllers.xss :as xss]
            [goat.controllers.dependencies :as deps]
            [goat.controllers.error :as error]
            [goat.controllers.unvalidated-redirects :as unvalidated-redirects]))

(defroutes router
           (GET "/" [] (home/home))
           (GET "/a3" [] (xss/search))
           (POST "/a3" [query] (xss/postsearch query))
           (GET "/a9" [] (deps/registration))
           (POST "/a9" [username] (deps/register-account username))
           (GET "/a10" [] (unvalidated-redirects/explanation))
           (GET "/a10-redirector" [redirectTo] (unvalidated-redirects/redirector redirectTo))
           (GET "/a10-redirect-target" [] (unvalidated-redirects/redirect-target))
           (route/resources "/")
           (route/not-found (error/not-found)))

(def app
  (handler/site router))

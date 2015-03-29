(ns web.test.util.routes
  (:use midje.sweet)
  (:require [goat.app :refer :all]
            [ring.mock.request :as mock]))

(facts "routes"
  (fact "it shows the home page"
    (let [response (-> (mock/request :get "/")
                       app)]
         (:status response) => 200
         (:body response)   => (contains "Hello World!")))

  (fact "it shows not found when the page does not exist"
    (let [response (-> (mock/request :get "/invalid")
                       app)]
         (:status response) => 404
         (:body response)   => (contains "Not Found"))))

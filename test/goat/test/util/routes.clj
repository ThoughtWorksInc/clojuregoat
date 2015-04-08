(ns goat.test.util.routes
  (:use midje.sweet)
  (:require [goat.app :refer :all]
            [ring.mock.request :as mock]))

(facts "routes"
  (fact "it shows the home page"
    (let [response (-> (mock/request :get "/")
                       app)]
         (:status response) => 200
         (:body response)   => (contains "Welcome")))

  (fact "it shows not found when the page does not exist"
    (let [response (-> (mock/request :get "/invalid")
                       app)]
         (:status response) => 404
         (:body response)   => (contains "Not Found")))

  (fact "it shows the search page ok"
    (let [response (-> (mock/request :get "/search")
                   app)]
          (:status response) => 200
          (:body response)   => (contains "This facility will search the WebGoat source"))))


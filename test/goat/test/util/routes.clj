(ns goat.test.util.routes
  (:use midje.sweet)
  (:require [goat.app :refer :all]
            [ring.mock.request :as mock]))

(facts "routes"
       (fact "it shows the home page"
             (let [response (-> (mock/request :get "/")
                                app)]
               (:status response) => 200
               (:body response) => (contains "Welcome")))

       (fact "it shows not found when the page does not exist"
             (let [response (-> (mock/request :get "/invalid")
                                app)]
               (:status response) => 404
               (:body response) => (contains "Not Found")))

       (fact "it shows the search page ok"
             (let [response (-> (mock/request :get "/a3")
                                app)]
               (:status response) => 200
               (:body response) => (contains "Search")))

       (fact "you can post blank to the search page and get the extra section at the bottom"
             (let [response (-> (mock/request :post "/a3")
                                app)]
               (:status response) => 200
               (:body response) => (contains "returned no results")))

       (fact "you can post to the search page and get the query back in the response"
             (let [response (-> (mock/request :post "/a3", {:query "verbatim safe query"})
                                app)]
               (:status response) => 200
               (:body response) => (contains "verbatim safe query")))

       (fact "it will verbatim back terribly unsafe stuff"
             (let [response (-> (mock/request :post "/a3", {:query "<script>alert('I am an alert box!');</script>"})
                                app)]
               (:status response) => 200
               (:body response) => (contains "<script>alert('I am an alert box!');</script>")))

       (fact "it shows the unvalidated redirect page that includes a redirect link"
             (let [response (-> (mock/request :get "/a10")
                                app)]
               (:status response) => 200
               (:body response) => (contains "Unvalidated Redirects")
               (:body response) => (contains "<a href=\"a10-redirector?redirectTo=a10-redirect-target\">Redirect Me</a>")))

       (fact "redirector page redirects user to url in query param"
             (let [response (-> (mock/request :get "/a10-redirector?redirectTo=redirect-target-page")
                                app)]
               (:status response) => 302
               (-> response :headers (get "Location")) => "redirect-target-page"))

       (fact "redirect target page displays ok"
             (let [response (-> (mock/request :get "/a10-redirect-target")
                                app)]
               (:status response) => 200
               (:body response) => (contains "Redirect Target")))

       (fact "it shows the sql injection page ok"
             (let [response (-> (mock/request :get "/a1") app)]
               (:status response) => 200
               (:body response) => (contains "SQL Injection"))))



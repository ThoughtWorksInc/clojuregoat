(ns main
  (:use [goat.app :only [app]]
        [org.httpkit.server :only [run-server]])
  (:gen-class))

(defonce server (atom nil))

(defn -main [& args]
  (let [port (Integer/parseInt (get (System/getenv) "PORT" "80"))]
    (reset! server (run-server #'app {:port port}))
    (println "Running server on port" port)))

(defproject ask "0.1.0-SNAPSHOT"
  :description "a goat, in Clojure"
  :url "https://github.com/ThoughtWorksInc/clojuregoat"
  :min-lein-version "2.0.0"
  :main main
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.1.9"]
                 [http-kit "2.1.5"]
                 [de.ubercode.clostache/clostache "1.4.0"]]
  :profiles {:dev
              {:dependencies [[javax.servlet/servlet-api "2.5"]
                              [ring-mock "0.1.5"]
                              [midje "1.6.3" :exclusions [org.clojure/clojure]]]
               :plugins      [[lein-midje "3.1.3"]]}
             :production
              {:dependencies [[javax.servlet/servlet-api "2.5"]]}})

(ns goat.util.templates
  (:require [clojure.java.io :as io]
            [clostache.parser :as clostache])
  (:use [goat.util.path :only [join-paths]]))

(defn- read-template [template-name]
  (slurp (io/resource (join-paths "templates"
                                  (str template-name ".html.template")))))

(defn- read-partial [templates]
  (reduce (fn [so-far current]
            (assoc so-far
                   current
                   (read-template (name current))))
          {}
          templates))

(defn render
  ([name]
    (render name {} []))
  ([name parameters]
    (render name parameters []))
  ([name parameters partials]
    (clostache/render (read-template name)
                      parameters
                      (read-partial partials))))

(defn render-with-header-and-footer
  ([name]
    (render-with-header-and-footer name {}))
  ([name data]
    (clostache/render (read-template "page")
                      data
                      {:header (read-template "header")
                       :footer (read-template "footer")
                       :content (read-template name)})))

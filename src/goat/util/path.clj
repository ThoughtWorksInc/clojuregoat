(ns goat.util.path
  (:require [clojure.java.io :as io]))

(defn join-paths [& paths]
  (str (apply io/file paths)))

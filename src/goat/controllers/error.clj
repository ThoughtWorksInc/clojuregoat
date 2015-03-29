(ns goat.controllers.error
  (:use [ring.util.response :only [redirect]])
  (:require [org.httpkit.server :as ws]))

(defn not-found []
  "Not Found")

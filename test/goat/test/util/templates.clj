(ns web.test.util.templates
  (:use midje.sweet)
  (:require [goat.util.templates :refer :all]))

(facts "the templating engine"
  (fact "renders the template name given"
    (render "my-template") => "Hello!"

    (provided
      (#'ask.util.templates/read-template anything) => "Hello!"))

  (fact "replaces a pair of moustaches with the associated variable"
    (render "my-template"
            {:name "Rob"}) => "Rob!"

    (provided
      (#'ask.util.templates/read-template anything) => "{{name}}!"))

  (fact "replaces multiple pairs of moustaches with their associated variables"
    (render "my-template"
            {:name "Rob"}) => "RobRob!"

    (provided
      (#'ask.util.templates/read-template anything) => "{{name}}{{name}}!"))

  (fact "renders partials"
    (render "my-template"
            {:name "Rob"}
            [:header]) => "<h1>Rob!</h1>"

    (provided
      (#'ask.util.templates/read-template "header") => "<h1>{{name}}!</h1>"
      (#'ask.util.templates/read-template "my-template") => "{{> header}}")))

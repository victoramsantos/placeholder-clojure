(ns controller.poem
  (:require [service.poem :as s.poem]
            [io.pedestal.http :as http]
            [ring.util.response :as ring-resp]
            [io.pedestal.http.body-params :as body-params]))

;; /poem

(defn get
  [request]
  (ring-resp/status (ring-resp/response (s.poem/list-poems)) 200))

(def json-encoding-interceptors [(body-params/body-params) http/json-body])

(def routes
  #{["/get" :get (conj json-encoding-interceptors `get)]})

(def service {:env                 :prod
              ::http/routes        routes
              ::http/resource-path "/public"
              ::http/type          :jetty
              ::http/port          8081})

;(defn get-query
;  [request]
;  (let [name (get-in request [:params :name] "World")]
;    (s.poem/get-query query))
;
;(defn post!
;  [content
;   author]
;  (s.poem/add-poem! content author))
;
;(defn get-random
;  []
;  (s.poem/get-random))
;
;(defn get-at [pos]
;  (s.poem/get-at pos))
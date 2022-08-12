(ns controller.poem
  (:require [service.poem :as s.poem]))

;; /poem

(defn get
  []
  (s.poem/list-poems))

(defn get-query
  [query]
  (s.poem/get-query query))

(defn post!
  [content
   author]
  (s.poem/add-poem! content author))

(defn get-random
  []
  (s.poem/get-random))

(defn get-at [pos]
  (s.poem/get-at pos))
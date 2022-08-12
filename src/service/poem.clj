(ns service.poem
  (:require [repository.poem :as r.poem]
            [clojure.set])
  (:use [clojure.string :as str :only [includes?]]))

(defn list-poems
  []
  (r.poem/list-poems))

(defn add-poem!
  [content
   author]
  (r.poem/add-poem! content author))

(defn get-query [query]
  (let [poems (list-poems)]
    (clojure.set/union
      (filter #(str/includes? (get % :content) query) @poems)
      (filter #(str/includes? (get % :author) query) @poems))))

(defn get-random []
  (let [count_poems (count @(r.poem/list-poems))
        rand (rand-int count_poems)]
    (get @(r.poem/list-poems) rand)))

(defn get-at [pos]
  (get @(r.poem/list-poems) pos))

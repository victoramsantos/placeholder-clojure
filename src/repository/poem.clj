(ns repository.poem
  (:require [database.core :as db.core]))

(defn list-poems
  []
  db.core/poems)

(defn add-poem!
  [content
   author]
  (swap! db.core/poems conj {:content content :author author}))

(ns core.main
  (:use [clojure pprint])
  (:require [controller.poem :as c.poem]))

(pprint (c.poem/get))

(c.poem/post! "awesome poem" "Brilliant Author")

(pprint (c.poem/get))

(println "\nFiltered by `em`: ")
(pprint (c.poem/get-query "em"))

(println "\nRandom poem: ")
(pprint (c.poem/get-random))

(println "\nGet poem at [2]: ")
(pprint (c.poem/get-at 2))

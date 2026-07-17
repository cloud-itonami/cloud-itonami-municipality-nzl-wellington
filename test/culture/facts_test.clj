(ns culture.facts-test
  (:require [clojure.edn :as edn]
            [clojure.string :as str]
            [clojure.test :refer [deftest is]]
            [culture.facts :as facts]))

(deftest wellington-has-culture-basis
  (let [sb (facts/spec-basis "wellington")]
    (is (= 9 (count sb)))
    (is (= (count sb) (count (set (map :culture/id sb)))))
    (is (every? #(str/starts-with? (:culture/url %) "https://") sb))
    (is (every? #(= "wellington" (:culture/municipality %)) sb))
    (is (every? #(= "NZL" (:culture/country %)) sb))
    (is (every? #(seq (:culture/summary %)) sb))
    (is (every? #(string? (:culture/retrieved-at %)) sb))))

(deftest unknown-municipality-has-no-basis
  (is (nil? (facts/spec-basis "auckland")))
  (is (nil? (facts/spec-basis "zzz"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["wellington" "auckland"])]
    (is (= 2 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["auckland"] (:missing-municipalities c)))))

(deftest by-kind-filters
  (is (= 3 (count (facts/by-kind "wellington" :dish))))
  (is (= ["wellington.beverage.flat-white"]
         (mapv :culture/id (facts/by-kind "wellington" :beverage))))
  (is (empty? (facts/by-kind "wellington" :craft)))
  (is (empty? (facts/by-kind "auckland" :dish))))

(deftest tx-file-matches-catalog
  (let [tx (edn/read-string (slurp "data/culture-tx.edn"))
        flat (mapcat val (sort-by key facts/catalog))]
    (is (= (vec flat) (vec tx)))))

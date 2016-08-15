(ns grail.test.mapping
  (:require [grail.mapping.zone :as zone]
            [clojure.test :refer :all]))

;; Room ids are descriptive, for testing purposes, but in real life they will
;; be random strings.
(defn create-simple-zone []
  (let [rooms
        [{:id :path-approaching-cave
          :name "Path Approaching Cave"
          :description "A path approaching a cave."
          :exits {:w :cave-entrance}}
         {:id :cave-entrance
          :name "Cave Entrance"
          :description "The entrance to a cave."
          :exits {:e :path-approaching-cave}}]
        rooms-lookup (into {} (map #([(:id %) %])))
        {:rooms rooms
         :lookup rooms-lookup}])
  )

(defn create-actor []
  {:id :hero
   :location :path-approaching-cave})

(deftest test-find-destination
  (let [zone (create-simple-zone)
        actor (create-actor)]
    (is (= :cave-entrance (zone/find-destination zone actor :w))
        "west from :path-approaching-cave should be :cave-entrance")))

(deftest test-can-move?
  (testing "with valid directions"
    (let [zone (create-simple-zone)
          actor (create-actor)]
      (is (= true (zone/can-move? zone actor :w))
          "actor can move when using a valid exit")
      (is (= false (zone/can-move? zone actor :e))
          "actor cannot move when using a nonexistent exit")))
  (testing "with invalid actor"
    ; TODO: actually test nilness of every damn thing?
    ; Perhaps specs can help, I don't know.
    ))

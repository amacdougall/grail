(ns grail.mapping.zone
  (:require [clojure.spec :as s]
            [com.rpl.specter :as specter]))

(defn find-destination [zone actor direction]
  (let [room ((:location actor) (:rooms zone))
        destination-id (-> room :exits direction)]
    destination-id))

(defn can-move? [zone actor direction]
  (let [destination-id (find-destination zone actor direction)]
    (and
      (not (nil? destination-id))
      (not (nil? (destination-id (:rooms zone)))))))

(defn move [zone character-id direction]
  ; TODO: use Specter to wrangle some datas
  ; TODO: return the zone, with the character moved to a new room; or throw an
  ; exception if the character could not actually move. It's okay to throw an
  ; exception here, because we really should have been checking can-move?
  zone
  )

; room spec elements

(s/def ::description string?)
(s/def ::id keyword?)

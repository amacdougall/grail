(ns grail.handlers
    (:require [re-frame.core :as re-frame]
              [grail.db :as db]))

(re-frame/register-handler
 :initialize-db
 (fn  [_ _]
   db/default-db))

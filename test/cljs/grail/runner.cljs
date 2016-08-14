(ns grail.runner
    (:require [doo.runner :refer-macros [doo-tests]]
              [grail.core-test]))

(doo-tests 'grail.core-test)

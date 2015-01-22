(ns ann.playground
  (:require [ann.core :as ann])
  (:refer-clojure :exclude [+ - * == /])
  (:use clojure.core.matrix)
  (:use clojure.core.matrix.operators)
  (:require [clatrix.core :as cl]))

(def test-mat (ann/make-random-matrix 3))
(pm test-mat)
(pm (ann/normalize-matrix-elements test-mat))

(class {:input-node-count 3
        :hidden-layer-count 1
        :output-layer-count 7
        ;:activation-function default-fire-function
        })

(ns playground
  (:refer-clojure :exclude [+ - * == /])
  (:use clojure.core.matrix)
  (:use clojure.core.matrix.operators)
;  (:use clojure.core.matrix.linear)
  (:require [clatrix.core :as cl]))

; use clatrix as default implementation
(set-current-implementation :clatrix)

(defn make-rand-matrix-with-shape
  "Create a MxM or MxN matrix filled with random ints taken from [0, 100]"
  ([m] (matrix (for [i (range m)]
                 (for [j (range m)]
                   (rand-int 100)))))
  ([m n] (matrix (for [i (range m)]
                   (for [j (range n)]
                     (rand-int 100))))))

(defn normalize-elts
  "Normalize all matrix elements to a sum of 1.0"
  ([mat] (array (map #(/ % (esum %))
                     (rows mat)))))

(def test-mat (make-rand-matrix-with-shape 3))
(pm test-mat)
(pm (normalize-elts test-mat))

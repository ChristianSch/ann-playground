(ns ann.lib.core
  (:refer-clojure :exclude [+ - * == /])
  (:use clojure.core.matrix)
  (:use clojure.core.matrix.operators)
  (:require [clatrix.core :as cl]))

; use clatrix as default implementation
(set-current-implementation :clatrix)

(defn make-random-matrix
  "Create a MxM or MxN matrix filled with random ints taken from [0, 100]"
  ([m] (matrix (for [i (range m)]
                 (for [j (range m)]
                   (rand-int 100)))))
  ([m n] (matrix (for [i (range m)]
                   (for [j (range n)]
                     (rand-int 100))))))

(defn normalize-matrix-elements
  "Normalize the matrix in the way that all elements of a row sum up to 1.0"
  ([mat] (array (map #(/ % (esum %))
                     (rows mat)))))

(defn default-fire-function
  "The default function for determining whether the neuron `fires` or not.
  Uses tanh as sigmoid function."
  [x]
  (Math/tanh x))

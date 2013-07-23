(ns gogo.core
  (:require [clojure.core.async :refer [go]]))


;; ## Macros Wrapping Macros
;;
;; `gogo` is a tiny, simple macro library that wraps the `go` macro of
;; `clojure.core.async`. Its purpose is to provide helpers after the fashion of
;; things like `when-let` and `if-let`.


(defmacro go-if [tst then else?]
  "
  Like `if`, but wrapped in a `go` block.
  "
  `(go (if ~tst ~then ~else?)))


(defmacro go-if-not [tst then else?]
  "
  Like `if-not`, but wrapped in a `go` block.
  "
  `(go (if-not ~tst ~then ~else?)))


(defmacro go-if-let
  "
  Like `if-let`, but wrapped in a `go` block.
  "
  ([bindings then]
   `(go-if-let ~bindings ~then nil))
  ([bindings then else & oldform]
   `(go (if-let ~bindings ~then ~else & ~oldform))))


(defmacro go-let [bindings & body]
  "
  Like `let`, but wrapped in a `go` block.
  "
  `(go (let ~bindings ~@body)))


(defmacro go-when [tst & body]
  "
  Like `when`, but wrapped in a `go` block.
  "
  `(go (when ~tst ~@body)))


(defmacro go-when-not [tst & body]
  "
  Like `when-not`, but wrapped in a `go` block.
  "
  `(go (when-not ~tst ~@body)))


(defmacro go-when-let [bindings & body]
  "
  Like `when-let`, but wrapped in a `go` block.
  "
  `(go (when-let ~bindings ~@body)))


(defmacro go-while [tst & body]
  "
  Like `while`, but wrapped in a `go` block.
  "
  `(go (while ~tst ~@body)))

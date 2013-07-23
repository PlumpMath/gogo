# gogo

A tiny macro library for clojure.core.async/go.

## Usage

```clojure
(require '[clojure.core.async :refer :all])
(require '[gogo.core :refer :all])

;; a silly example
(go-let [c (chan)] (go (>! c "foo")) (prn (<! c)))

;; another silly example
(def c (chan))
(go-while true (>! c "foo"))
(<!! c)
```

## License

Copyright © 2013 Max Countryman

Distributed under the BSD License.

(ns friday.myns
  (:require-macros [net.cgrand.macrovich :as macrovich]))

(js/console.log "hello from toplevel")

(defn toplevelfunction []
  (js/console.log "hello from toplevel function"))

(defmacro toplevelmacro []
  (js/console.log "hello from toplevelmacro expansion")

  `(js/console.log "hello from toplevelmacro result evaluation"))

(macrovich/usetime
 (js/console.log "hello from usetime")

 (defn usetimefunction []
   (js/console.log "hello from usetimefunction"))

 (defmacro usetimemacro []
   (js/console.log "hello from usetimemacro expansion")

   `(js/console.log "hello from usetimemacro result evaluation")))


(macrovich/deftime
  (js/console.log "hello from deftime")

  (defn deftimefunction []
    (js/console.log "hello from deftimefunction"))

  (defmacro deftimemacro []
    (js/console.log "hello from deftimemacro expansion")

    `(js/console.log "hello from deftimemacro result evaluation")))

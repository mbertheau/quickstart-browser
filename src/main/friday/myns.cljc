(ns friday.myns
  (:require-macros [net.cgrand.macrovich :as macrovich]))

(js/console.log (and *ns* (ns-name *ns*)))
(js/console.log "hello from toplevel")

(defn toplevelfunction []
  (js/console.log (and *ns* (ns-name *ns*)))
  (js/console.log "hello from toplevel function"))

(defmacro toplevelmacro []
  (js/console.log (and *ns* (ns-name *ns*)))
  (js/console.log "hello from toplevelmacro expansion")

  `(do
     (js/console.log (and *ns* (ns-name *ns*)))
     (js/console.log "hello from toplevelmacro result evaluation")))

(macrovich/usetime
 (js/console.log (and *ns* (ns-name *ns*)))
 (js/console.log "hello from usetime")

 (defn usetimefunction []
   (js/console.log (and *ns* (ns-name *ns*)))
   (js/console.log "hello from usetimefunction"))

 (defmacro usetimemacro []
   (js/console.log (and *ns* (ns-name *ns*)))
   (js/console.log "hello from usetimemacro expansion")

   `(do
      (js/console.log (and *ns* (ns-name *ns*)))
      (js/console.log "hello from usetimemacro result evaluation"))))


(macrovich/deftime
  (js/console.log (and *ns* (ns-name *ns*)))
  (js/console.log "hello from deftime")

  (defn deftimefunction []
    (js/console.log (and *ns* (ns-name *ns*)))
    (js/console.log "hello from deftimefunction"))

  (defmacro deftimemacro []
    (js/console.log (and *ns* (ns-name *ns*)))
    (js/console.log "hello from deftimemacro expansion")

    `(do
       (js/console.log (and *ns* (ns-name *ns*)))
       (js/console.log "hello from deftimemacro result evaluation"))))

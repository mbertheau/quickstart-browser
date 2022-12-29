(ns starter.browser
  (:require [cljs.js :as cljs]
            [cljs.env :as env]
            [shadow.cljs.bootstrap.browser :as boot]))

;; start is called by init and after code reloading finishes
(defn print-result [{:keys [error value] :as result}]
  (js/console.log "result" result)
  (set! (.-innerHTML (js/document.getElementById "dump")) value))

(def code
  "(ns markus.pumpkin
     (:require [friday.myns :as myns :include-macros true])
   )

   (js/console.log \"hello from self-hosted!\")

   ; working
   (myns/toplevelfunction)
   (myns/usetimefunction)

   (myns/toplevelmacro)
   (myns/usetimemacro)

   ; unexpectedly not working
   (myns/deftimefunction)
   (myns/deftimemacro)
   ")


(defonce compile-state-ref (env/default-compiler-env))

(defn compile-it []
  (cljs/eval-str
    compile-state-ref
    code
    "[test]"
    {:eval         cljs/js-eval
     :analyze-deps false
     :verbose      true
     :load         (partial boot/load compile-state-ref)}
    print-result))

(defn start []
  (boot/init compile-state-ref
             {:path "/bootstrap"}
    compile-it))

(defn init []
  ;; init is called ONCE when the page loads
  ;; this is called in the index.html and must be exported
  ;; so it is available even in :advanced release builds
  (js/console.log "init")
  (start))

;; this is called before any code is reloaded
(defn ^:dev/before-load stop []
  (js/console.log "stop"))

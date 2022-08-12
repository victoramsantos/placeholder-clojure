(ns database.core)


; Database
(def poems (atom []) )

(defn bootstrap-db!
  []
  (swap! poems conj {:content "Não sou alegre nem triste: sou poeta!" :author "Cecília Meireles"})
  (swap! poems conj {:content "É proibido chorar sem aprender." :author "Alfredo Cuervo Barrero"})
  (swap! poems conj {:content "Ela errou,eu errei, nós dois erramos.." :author "A vida"}))

(bootstrap-db!)
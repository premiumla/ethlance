(ns ethlance.server.core
  (:require
   [mount.core :as mount]
   [taoensso.timbre :as log]
   [cljs.nodejs :as nodejs]
   [cljs-oweb3.eth :as web3-eth]

   ;; District Server Components
   [district.server.web3]
   [district.server.config :refer [config]]
   [district.server.smart-contracts]
   [district.server.logging]

   [ethlance.shared.smart-contracts]))


(def main-config
  {:web3 {:port 8545}
   :smart-contracts {:contracts-var #'ethlance.shared.smart-contracts/smart-contracts
                     :print-gas-usage? false
                     :auto-mining? false}})


(defn -main [& args]
  (log/info "Initializing Server...")
  (mount/start (mount/with-args main-config)))


(set! *main-cli-fn* -main)
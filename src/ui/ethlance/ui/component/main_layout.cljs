(ns ethlance.ui.component.main-layout
  (:require
   [re-frame.core :as rf]
   
   ;; Ethlance Components
   [ethlance.ui.component.circle-button :refer [c-circle-icon-button]]
   [ethlance.ui.component.main-navigation-bar :refer [c-main-navigation-bar]]
   [ethlance.ui.component.main-navigation-menu :refer [c-main-navigation-menu]]
   [ethlance.ui.component.mobile-navigation-bar :refer [c-mobile-navigation-bar]]))


(defn c-main-layout
  [{:keys [container-opts] :as opts}
   & children]
  (let [opts (dissoc opts :container-opts)]
    [:div.main-layout opts
     [c-main-navigation-bar]
     [c-mobile-navigation-bar]
     [:div.main-margin
      [c-main-navigation-menu]
      [:div.main-container container-opts children]]
     [:div.footer
      [:div.copyright
       [:span "Copyright © 2019 Ethlance.com"]
       [:div.spacer "|"]
       [:span "All rights reserved."]]
      [:div.social
       [c-circle-icon-button {:name :facebook :size :small}]
       [c-circle-icon-button {:name :twitter :size :small}]
       [c-circle-icon-button {:name :github :size :small}]
       [c-circle-icon-button {:name :slack :size :small}]]]]))

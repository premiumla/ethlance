(ns ethlance.ui.page.sign-up
  (:require
   [taoensso.timbre :as log]
   [district.ui.component.page :refer [page]]

   [ethlance.shared.enumeration.currency-type :as enum.currency]

   ;; Ethlance Components
   [ethlance.ui.component.currency-input :refer [c-currency-input]]
   [ethlance.ui.component.email-input :refer [c-email-input]]
   [ethlance.ui.component.inline-svg :refer [c-inline-svg]]
   [ethlance.ui.component.main-layout :refer [c-main-layout]]
   [ethlance.ui.component.radio-select :refer [c-radio-select c-radio-search-filter-element]]
   [ethlance.ui.component.rating :refer [c-rating]]
   [ethlance.ui.component.search-input :refer [c-chip-search-input]]
   [ethlance.ui.component.tabular-layout :refer [c-tabular-layout]]
   [ethlance.ui.component.tag :refer [c-tag c-tag-label]]
   [ethlance.ui.component.text-input :refer [c-text-input]]))


(defn c-candidate-sign-up []
  [:div.candidate-sign-up
   [:div.form-container
    [:div.label "Sign Up"]
    [:div.first-forms
     [c-inline-svg {:root-class "form-image"}]
     [c-text-input {:class "form-name"}]
     [c-email-input {:class "form-email"}]
     [c-text-input {:class "form-professional-title"}]
     [c-currency-input {:class "form-hourly-rate"}]
     [:div.select-input {:class "form-country"}] ;; TODO: implement select input
     [:div.form-connect-github "github"]
     [:div.form-connect-linkedin "linkedin"]]]
   [:div.form-submit "Create"]])


(defn c-employer-sign-up []
  [:div.employer-sign-up
   "employer"])


(defn c-arbiter-sign-up []
  [:div.arbiter-sign-up
   "arbiter"])


(defmethod page :route.me/sign-up []
  (let []
    (fn []
      [c-main-layout {:container-opts {:class :sign-up-main-container}}
       [c-tabular-layout
        {:key "sign-up-tabular-layout"
         :default-tab 0}
        
        {:label "Candidate"}
        [c-candidate-sign-up]
        
        {:label "Employer"}
        [c-employer-sign-up]
        
        {:label "Arbiter"}
        [c-arbiter-sign-up]]])))


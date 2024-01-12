@magazaBul
Feature: Mağaza bulma ve bastırma

  Scenario: Mağaza bulma ve bastırma senaryosu
    Given Cerezler kabul edilir
    When Footerdan KurumsalMagazalarimiz tiklanir
    And Magaza Bulucu formundan il ve ilce secimi yapilir
    And Magaza listesi bastirilir


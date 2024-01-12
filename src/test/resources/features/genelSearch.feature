@searchGenel
Feature: Ürün arama ve sepete ekleme

  Scenario Outline: Ürün arama ve sepete ekleme senaryosu
    Given Cerezler kabul edilir
    When Arama kutusuna <Urun adi> yazilir ve entera basilir
    And BlueTooth kulaklik secilir
    And En cok satanlar filtrelenir
    And Ilk ve son urunler sepete eklenir
    And Sepete gidilir
    And En ucuz urun adedi 2 yapilir
    And Uye olmadan devam et yapilir
    And Email girilir


    Examples:
      | Urun adi |
      | "kulaklık" |

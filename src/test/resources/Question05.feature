Feature: Question 05

  Scenario Outline: Database üzerinden bed tablosunda bed group id'si 4 ve is_active= "no" olan hastanin
  name bilgisinin 105 oldugunu dogrulayiniz.

    Given Database baglantisi kurulur.
    Then Patient bed group_id <id> ve aktiflik bilgisi <is_active> gonderilip hasta ismi dogrulanir.
    Then Gerekli bilgi <name> olarak dogrulanir.
    And Database baglantisi kapatilir.

    Examples:
      | id | is_active | name |
      | 4  | no        | 105  |
Feature:
  @Q_04
  Scenario: Database uzerinden bed tablosunda created_at = 2021-10-25 03:34:25 olan yatagin active oldugunu dogrulayiniz.
    Given Database baglantisi kurulur.
    Then Bed tablosunda verilen hastanin active olup olmadigi dogrulanir.
    Then Database baglantisi kapatilir.
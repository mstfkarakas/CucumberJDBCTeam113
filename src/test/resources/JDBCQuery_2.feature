Feature: JDBC Query_2

  # Database üzerinden hastane sistemine gerekli bilgiler girilerek
  # randevu alinabildigini dogrulayiniz.
  @query2
  Scenario: hastane sistemine gerekli bilgiler girilerek randevu alinabildigini dogrulayiniz.

    * Database baglantisi kurulur.
    * Update Query'si hazirlanir.
    * Sonuclari alinir ve dogrulanir.
    * Database baglantisi kapatilir.



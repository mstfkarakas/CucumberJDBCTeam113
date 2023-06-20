Feature: JDBC Query 4

    #heallife_hospitaltraining.languages bolumunde karsilastirma yapilir
    #  Database üzerinden languages tablosundaki short_code "yi" olan verinin language bilgisinin
    #  "Yiddish" oldugunu dogrulayin.

  Background: Connection
    * Database baglantisi kurulur.
  @query4

  Scenario: Database üzerinden languages tablosundaki short_code "yi" olan verinin language bilgisinin "Yiddish" oldugunu dogrulayin.

    * Languages tablosuna query gönderilir ve sonuclar dogrulanir.
    * Database baglantisi kapatilir.
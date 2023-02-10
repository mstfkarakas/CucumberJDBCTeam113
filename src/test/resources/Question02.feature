Feature: Question 02

  Background: Connection
    * Database baglantisi kurulur.


  @Q_02

  Scenario Outline: Database üzerinden appointment_payment tablosunda odeme turu olarak "offline" secen
                    hasta id'lerinin (1,2,3,16,17,18,20,21,24,25,31) oldugunu dogrulayiniz.

    * Appointment payment Query olusturulur ve <id> dogrulanir.
    * Database baglantisi kapatilir.
    Examples:
      | id |
      | 1  |
      | 2  |
      | 3  |
      | 16 |
      | 17 |
      | 18 |
      | 20 |
      | 21 |
      | 24 |
      | 25 |
      | 31 |
Feature: Question 05

  @Q_05
  Scenario Outline: Database üzerinden bed tablosunda bed group id'si 4 ve is_active= "no" olan hastanin
  name bilgisinin 105 oldugunu dogrulayiniz.

    Given Connection to Heal Life database.
    Then  Query the bed table with "name" bed_group_id is 4 AND is_active = no
    Then  The patient "name" should be <name>.
    And   Close the Heal Life database.

    Examples:
      | name |
      | 105  |
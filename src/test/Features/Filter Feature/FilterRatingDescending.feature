Feature: Filter room rating for hotel on web page by descending

  Scenario: Verification of filter rating column is working 7
    Given Open chrome and login with registred account 7
    When Select hotel, check in date, check out date then click search now 7
    And Click on rating and filter rating by descending
    Then user will see hotel rating displayed by descending
Feature: Filter room rating for hotel on web page by ascending

  Scenario: Verification of filter rating column is working 6
    Given Open chrome and login with registred account 6
    When Select hotel, check in date, check out date then click search now 6
    And Click on rating and filter rating by ascending
    Then user will see hotel rating displayed by ascending


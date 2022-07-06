Feature: Filter room price for hotel on web page by highest to lowest

  Scenario: Verification of filter price column is working 5
    Given Open chrome and login with registred account 5
    When Select hotel, check in date, check out date then click search now 5
    And Click on price and filter price from highest to lowest
    Then user will see hotel price displayed from highest to lowest

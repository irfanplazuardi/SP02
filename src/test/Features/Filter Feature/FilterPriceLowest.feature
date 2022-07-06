Feature: Filter room price for hotel on web page by lowest to highest

  Scenario: Verification of filter price column is working 4
    Given Open chrome and login with registred account 4
    When Select hotel, check in date, check out date then click search now 4
    And Click on price and filter price from lowest to highest
    Then user will see hotel price displayed from lowest to highest


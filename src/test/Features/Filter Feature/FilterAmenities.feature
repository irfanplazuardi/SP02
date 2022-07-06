Feature: Filter room amenities for hotel on web page

  Scenario: Verification of filter column is working 8
    Given Open chrome and login with registred account 8
    When Select hotel, check in date, check out date then click search now 8
    And Click on desired amenities on the amenities box
    Then user will see hotel amenities displayed based on amenities filter


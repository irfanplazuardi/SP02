Feature: Book a hotel room from the website by bank wire

  Scenario: Verification on hotel is booked confirmed 1
    Given Open chrome and login with registred account 1
    When Select hotel, check in date, check out date then click search now 1
    And Book a room and proceed to checkout 1
    And Proceed for payment room with bank wire
    Then Confirmation hotel room order is complete 1



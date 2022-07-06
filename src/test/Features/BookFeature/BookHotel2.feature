Feature: Book a hotel room from the website by check

  Scenario: Verification on hotel is booked confirmed 2
    Given Open chrome and login with registered account 2
    When Select hotel, check in date, check out date then click search now 2
    And Book a room and proceed to checkout 2
    And Proceed for payment room with check
    Then Confirmation hotel room order is complete 2
Feature: Book a hotel room from the website by paypal

  Scenario: Verification on hotel is booked confirmed 3
    Given Open chrome and login with registered account 3
    When Select hotel, check in date, check out date then click search now 3
    And Book a room and proceed to checkout 3
    And Proceed for payment room with paypal
    Then Confirmation hotel room order is complete 3
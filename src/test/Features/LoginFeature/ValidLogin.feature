Feature: Login functionality on login page with valid account

  Scenario: Verification of login button works
    Given Open chrome and launch with valid account
    When Enter the username and password with valid account
    And Click login button with valid account
    Then user will be directed to my account page


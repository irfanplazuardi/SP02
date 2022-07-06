Feature: Register new account on webpage with valid account

  Scenario: Verification of register button works with valid input
    Given Open the chrome and launch web with valid input
    When Enter Email and click create account valid
    And fill in your personal information and click register with valid input
    Then A new account is registered



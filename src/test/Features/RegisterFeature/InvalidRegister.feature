Feature: Register new account on webpage with invalid account

  Scenario: Verification of register button doesn't work with invalid input
    Given Open the chrome and launch web with invalid input
    When Input Email and click create account
    And fill in your personal information and click register with invalid input
    Then user will see register account error
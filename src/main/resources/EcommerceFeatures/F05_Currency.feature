@smoke
Feature: F05_Currency


  Background: user has account
    Given user had an actual account
    And open home page again

  Scenario: SC5- Logged User could switch between currencies US-Euro

    When user chooses from currency dropdown list

    Then verification process from currency
@smoke
Feature: F07_Color

  Background: user has account
    Given user had an actual account
    And open home page again

  Scenario: SC7- Logged user could filter with color

    When user chooses Category and hover to open sub-Category

    And user can filter sub-Category with color

    Then user will find product with the selected color

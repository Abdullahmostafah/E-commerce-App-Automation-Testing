@smoke
Feature: F11_Compare

  Background: user has account
    Given user had an actual account
    And open home page again

  Scenario: SC11- Logged user could add different products to compare list
    Given user adds First Product to CompareList
    And user adds Second Product to CompareList
    And user adds Third Product to CompareList

    When user goes to CompareProductsList

    And user deletes all the choosedProducts
@smoke
Feature: F14_FollowUs

  Background: user goes to home page

    Given open home page again
    And user goes to home page

  Scenario: Confirm "Follow us" links open the corresponding websites

    Given user scroll down

    When user clicked on icons link

    Then user can switch between pages
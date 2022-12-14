@smoke
Feature: F08_Tag


  Background: user has account
    Given user had an actual account
    And open home page again

  Scenario: SC8- Logged user could select different tags
    Given user scrolls down to products

    When user presses on add to wishlist

    Then user chooses attributes for product if found
    And user found the product that he added to wishlist in the wishlist
    And open home page again
    And user adds another product to the Wishlist
    And logged user navigates to his Wishlist page
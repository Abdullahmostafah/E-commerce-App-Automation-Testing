@smoke
Feature: F09_Cart

  Background: user has account
    Given user had an actual account
    And open home page again

  Scenario: SC9- Logged user could add different products to Shopping cart
    When user scrolls down to products
    And user chooses product randomly
    And press on ADD TO CART button

    Then the product is added to the user's shopping cart and message appears says The product has been added to your shopping cart
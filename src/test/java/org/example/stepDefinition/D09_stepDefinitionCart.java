package org.example.stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.example.pages.P09_Cart;
import org.testng.asserts.SoftAssert;

public class D09_stepDefinitionCart {
    P09_Cart p09_shoppingCart = new P09_Cart();
    @And("user chooses product randomly")
    public void user_chooses_product_randomly() {
        p09_shoppingCart.ChooseingAnyProduct().click();
    }
    @And("press on ADD TO CART button")
    public void press_on_add_to_cart_button() {
        p09_shoppingCart.AddingSpecificProductBtn().click();
    }
    @Then("the product is added to the user's shopping cart and message appears says The product has been added to your shopping cart")
    public void the_product_is_added_to_the_user_s_shopping_cart_and_message_appears_says_the_product_has_been_added_to_your_shopping_cart() {
        SoftAssert wishlistAssertion = new SoftAssert();
        if (p09_shoppingCart.DisplayingMessage().isDisplayed()) {
            wishlistAssertion.assertEquals(p09_shoppingCart.DisplayingMessage().getText(), "The product has been added to your shopping cart");
            wishlistAssertion.assertEquals(p09_shoppingCart.DisplayingMessage().getCssValue("background-color"), "rgba(75, 176, 122, 1)");
            wishlistAssertion.assertAll();
            //System.out.println("Add product to shopping cart successfully");
        }
    }
}
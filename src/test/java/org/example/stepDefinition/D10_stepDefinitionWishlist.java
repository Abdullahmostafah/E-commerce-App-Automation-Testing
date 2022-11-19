package org.example.stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P10_Wishlist;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class D10_stepDefinitionWishlist {
    SoftAssert softAssert = new SoftAssert();
    P10_Wishlist p10_wishList = new P10_Wishlist();
    @When("user presses on add to wishlist")
    public void user_presses_on_add_to_wishlist() {
        p10_wishList.PressingWishlistIcon().click();
        Hooks.sleep(20);
    }
    @Then("user chooses attributes for product if found")
    public void user_chooses_attributes_for_product_if_found() {
        P10_Wishlist.ChoosingProcessorType();
        P10_Wishlist.ChoosingRAM();
        P10_Wishlist.ChoosingHDD();
        P10_Wishlist.ChoosingOS();
        P10_Wishlist.ChoosingSoftware();
    }
    @Then("user found the product that he added to wishlist in the wishlist")
    public void user_should_found_the_product_added_to_wishlist_in_the_wishlist() {
        p10_wishList.PressingWishlistBtn().click();

        String expectedMessage = "The product has been added to your wishlist";
        softAssert.assertTrue(p10_wishList.DisplayingMessage().getText().contains(expectedMessage), "Not add in wishlist");

        if (p10_wishList.DisplayingMessage().isDisplayed()) {
            Hooks.driver.findElement(By.cssSelector(".content > a:nth-child(1)")).click();
            softAssert.assertEquals(Hooks.driver.getCurrentUrl(), "https://demo.nopcommerce.com/wishlist", "Not ");
            softAssert.assertEquals(Hooks.driver.findElement(By.cssSelector("a[class=\"product-name\"]")).getText(), "Build your own computer", "Wrong product in wishlist");
            softAssert.assertAll();
            System.out.println("Add product to wishlist successfully");
        }
    }
    @And("user adds another product to the Wishlist")
    public void add_another_product_to_Wishlist()  {
        // Add product_2 to Wishlist & Assert its existence using POM //
        p10_wishList.AddSecondProduct().click();
        // Assertion product_2 //
        Assert.assertTrue(p10_wishList.DisplayingSecondProductAsser().isDisplayed());
        Hooks.sleep(3);
        System.out.println("Second product has been added to your wishlist");
    }
    @Then("logged user navigates to his Wishlist page")
    public void navigates_to_Wishlist() {
        Hooks.driver.get("https://demo.nopcommerce.com/wishlist");
        System.out.println("You have two products in your Wishlist table");
    }
}
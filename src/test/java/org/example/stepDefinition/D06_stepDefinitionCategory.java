package org.example.stepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P06_Category;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

public class D06_stepDefinitionCategory {
    SoftAssert verifyLink = new SoftAssert();
    P06_Category p06_Category = new P06_Category();
    @When("user chooses category randomly")
    public void user_chooses_category_randomly() {
        Actions actions = new Actions(Hooks.driver);
        actions.moveToElement(p06_Category.ChoosingMenuElement());
        actions.moveToElement(p06_Category.ChoosingSubMenuElement());
        Hooks.sleep(20);
        actions.click().build().perform();
    }
    @Then("user return to the choosed category page")
    public void user_return_to_the_choosed_category_page() {
        String expectedResult = "https://demo.nopcommerce.com/shoes";
        verifyLink.assertEquals(Hooks.driver.getCurrentUrl(), expectedResult, "Wrong Page");
        verifyLink.assertAll();
    }
}

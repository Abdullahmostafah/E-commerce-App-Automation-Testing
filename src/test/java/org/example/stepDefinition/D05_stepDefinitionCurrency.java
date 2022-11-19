package org.example.stepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P05_Currency;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class D05_stepDefinitionCurrency {
    P05_Currency p05_switchCurrency = new P05_Currency();
    @When("user chooses from currency dropdown list")
    public void user_chooses_from_currency_dropdown_list() {
        if (p05_switchCurrency.ChoosingFromListElement().isEnabled() && p05_switchCurrency.ChoosingFromListElement().isDisplayed()) {
            System.out.println("DropList is Enabled and Visible");
        } else {
            System.out.println("DropList is not Visible");
        }
        Select select = new Select(p05_switchCurrency.ChoosingFromListElement());
        select.selectByValue("https://demo.nopcommerce.com/changecurrency/6?returnUrl=%2F");
    }
    @Then("verification process from currency")
    public void verificationProcess_from_currency() {
        SoftAssert productAssert = new SoftAssert();
        String expectedResult = "€";
        for (int i = 0; i < p05_switchCurrency.DisplayingChoosedProductPrice().size(); i++) {
            productAssert.assertEquals(p05_switchCurrency.DisplayingChoosedProductPrice().get(i).getText().substring(0, 1), expectedResult, "Error found different currency");
            productAssert.assertAll();
            //System.out.println("Right: " + p05_switchCurrency.DisplayingChoosedProductPrice().get(i).getText());
        }
    }
}
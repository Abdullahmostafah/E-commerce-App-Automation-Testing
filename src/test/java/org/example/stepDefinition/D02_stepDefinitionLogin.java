package org.example.stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_Login;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class D02_stepDefinitionLogin {
    public static SoftAssert verifyLogin = new SoftAssert();
    P02_Login p02_login = new P02_Login();
    @Given("user had an actual account")
    public void user_had_an_actual_account() {
        Assert.assertTrue(!(Hooks.userValidEmail.isEmpty() && Hooks.CheckRegistration), "There's no valid account registered yet");
    }
    @When("user pressed on Log-in link in the header")
    public void user_pressed_on_log_in_link_in_the_header() {
        p02_login.PressingLogInLink().click();
        Assert.assertEquals(Hooks.driver.getCurrentUrl(), "https://demo.nopcommerce.com/login?returnUrl=%2F", "Wrong Log In Link");
        Hooks.sleep(20);
    }
    @And("user enters email address in login page")
    public void userEntersEmailAddressInLoginPage() {
        p02_login.GettingUserEmailAddress().sendKeys(Hooks.userValidEmail);
    }
    @When("user pressed on Log-in button")
    public void user_pressed_on_Log_in_button() {
        p02_login.PressingLogInBtn().click();
        Hooks.sleep(20);
    }
    @Then("user log-in successfully")
    public void user_log_in_successfully() {
        String expectedResult = "https://demo.nopcommerce.com/";
        verifyLogin.assertEquals(Hooks.driver.getCurrentUrl(), expectedResult, "Process Failed 1");
        verifyLogin.assertTrue(p02_login.DisplayingMyAccountLink().isDisplayed(), "Process Failed 2");
        verifyLogin.assertAll();
    }
}
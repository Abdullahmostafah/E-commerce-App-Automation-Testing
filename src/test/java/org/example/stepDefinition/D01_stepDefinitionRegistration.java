package org.example.stepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_Register;
import org.testng.Assert;

public class D01_stepDefinitionRegistration {
P01_Register register= new P01_Register();
    @When("user pressed on Register link")
    public void user_pressed_on_Register_link(){
        register.GettingRegisterLink().click();
        Assert.assertEquals(Hooks.driver.getCurrentUrl(), "https://demo.nopcommerce.com/register?returnUrl=%2F", "Wrong Registration Link");
        Hooks.sleep(20);
    }
    @When("user enters first name")
    public void user_enters_first_name() {
        register.GettingUserFirstName().clear();
        register.GettingUserFirstName().sendKeys(Hooks.userFirstName);
    }
    @When("user enters last name")
    public void user_enters_last_name() {
        register.GettingUserLastName().clear();
        register.GettingUserLastName().sendKeys(Hooks.userLastName);
    }
    @When("user enters confirm password")
    public void user_enters_confirm_password() {
        register.GettingUserConfirmPassword().sendKeys(Hooks.userValidPassword);
    }
    @When("user pressed on REGISTER button")
    public void user_pressed_on_register_button() throws InterruptedException {
        register.PressingRegisterBtn().click();
        Hooks.sleep(20);
    }
    @Then("user log-in successfully and log-out link appears in the header")
    public void log_out_link_appears_in_the_header() {
        Hooks.verifyRegistration.assertTrue(register.PressingLogOutLink().isDisplayed(), "Registration Process Failed_2");
        Hooks.verifyRegistration.assertAll();
        Hooks.CheckRegistration = true;
    }
    @Then("display {string} message to user")
    public void display_message_to_user(String expectedResult) {
        String actualResult = register.DisplayingMessage().getText();
        Hooks.verifyRegistration.assertTrue(actualResult.contains(expectedResult), "Registration Process Failed_1");
        Hooks.verifyRegistration.assertAll();
        register.PressingContinueBtn().click();
    }
}
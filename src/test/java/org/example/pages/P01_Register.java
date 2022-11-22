package org.example.pages;

import org.example.stepDefinition.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P01_Register {
    public static WebElement GettingRegisterLink() {
        return Hooks.driver.findElement(By.className("ico-register"));
    }
    public static WebElement GettingUserFirstName() {
        return Hooks.driver.findElement(By.id("FirstName"));
    }
    public static WebElement GettingUserLastName() {
        return Hooks.driver.findElement(By.id("LastName"));
    }
    public static WebElement GettingUserEmailAddress() {
        return Hooks.driver.findElement(By.id("Email"));
    }
    public static WebElement GettingUserPassword() {
        return Hooks.driver.findElement(By.id("Password"));
    }
    public static WebElement GettingUserConfirmPassword() {
        return Hooks.driver.findElement(By.id("ConfirmPassword"));
    }
    public static WebElement PressingRegisterBtn() {
        return Hooks.driver.findElement(By.id("register-button"));
    }
    // After Registration
    public static WebElement DisplayingMessage() {
        return Hooks.driver.findElement(By.className("result"));
    }
    public static WebElement PressingContinueBtn() {
        return Hooks.driver.findElement(By.cssSelector("a[class=\"button-1 register-continue-button\"]"));
    }
    public static WebElement PressingLogOutLink() {
        return Hooks.driver.findElement(By.className("ico-logout"));
    }
    public static WebElement PressingLogOutBtn() {
        return Hooks.driver.findElement(By.className("ico-logout"));
    }
}
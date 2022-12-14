package org.example.pages;

import org.example.stepDefinition.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P03_ResetPassword {
    public static WebElement PressingOnForgetPasswordLink() {
        return Hooks.driver.findElement(By.cssSelector("a[href=\"/passwordrecovery\"]"));
    }
    public static WebElement PressingOnRecoverBtnLink() {
        return Hooks.driver.findElement((By.cssSelector("button[class=\"button-1 password-recovery-button\"]")));
    }
    public static WebElement DisplayingMessage() {
        return Hooks.driver.findElement(By.cssSelector("p[class=\"content\"]"));
    }
}
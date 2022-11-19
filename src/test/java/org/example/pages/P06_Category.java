package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.example.stepDefinition.Hooks;

public class P06_Category {
    public static WebElement ChoosingMenuElement() {
        return Hooks.driver.findElement(By.cssSelector("a[href=\"/apparel\"]"));
    }
    public static WebElement ChoosingSubMenuElement() {
        return Hooks.driver.findElement(By.cssSelector("a[href=\"/shoes\"]"));
    }
}
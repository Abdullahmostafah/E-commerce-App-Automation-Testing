package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import org.example.stepDefinition.Hooks;

public class P05_Currency {
    public static List<WebElement> DisplayingChoosedProductPrice() {
        return Hooks.driver.findElements(By.cssSelector("span[class=\"price actual-price\"]"));
    }
    public static WebElement ChoosingFromListElement() {
        return Hooks.driver.findElement(By.id("customerCurrency"));
    }
}
package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.example.stepDefinition.Hooks;

public class P07_Color {
    public static WebElement colorFilterProduct() {
        return Hooks.driver.findElement(By.id("attribute-option-15"));
    }
    public static WebElement colorCheckProduct() {
        return Hooks.driver.findElement(By.id("attribute-option-15"));
    }
}
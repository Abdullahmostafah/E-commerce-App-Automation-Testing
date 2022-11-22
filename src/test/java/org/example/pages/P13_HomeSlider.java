package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.example.stepDefinition.Hooks.driver;

public class P13_HomeSlider {
    public static WebElement link_1() {
        return driver.findElement(By.cssSelector("a[rel=\"0\"]"));
    }
    public static WebElement link_2() {
        return driver.findElement(By.cssSelector("a[rel=\"1\"]"));
    }
}
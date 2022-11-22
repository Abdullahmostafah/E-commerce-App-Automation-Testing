package org.example.stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


import static org.example.pages.P14_FollowUs.openTab;
import static org.example.pages.P14_FollowUs.switchTab;
import static org.example.stepDefinition.Hooks.driver;

public class D14_stepDefinitionFollowUs {
    @Given("user scroll down")
    public void user_scroll_down() {
        JavascriptExecutor scroll = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.cssSelector("ul[class=\"networks\"]"));
        scroll.executeScript("arguments[0].scrollIntoView();", element);
        Hooks.sleep(20);
    }
    @When("user clicked on icons link")
    public void user_clicked_on_icons_link() {
        openTab();
    }

    @Then("user can switch between pages")
    public void user_can_switch_between_pages() {
        switchTab();
    }
}

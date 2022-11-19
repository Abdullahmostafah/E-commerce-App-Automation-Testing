package org.example.stepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P04_Search;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import java.util.List;

public class D04_stepDefinitionSearch {
    P04_Search p04_search = new P04_Search();
    public static String store = "";
    @When("user presses on search box")
    public void user_presses_on_search_box() {
        p04_search.PressingOnSearchBox().click();
    }
    @When("write {string} in the search box")
    public void searchBox(String searchTerm) {
        p04_search.WrittingSearchSentance().sendKeys(searchTerm);
        store = searchTerm;
    }
    @When("user presses on search button")
    public void user_presses_on_search_button() {
        p04_search.PressingSearchBtn().click();
    }
    @Then("user will find all related products")
    public void user_will_find_all_related_products() {
        List<WebElement> results = p04_search.DisplayingAllRelatedResult();
        for (int i = 0; i < results.size(); i++) {
            Assert.assertTrue(results.get(i).getText().toLowerCase().contains(store), "Search result validation failed at instance [ + i + ].");
            //System.out.println(results.get(i).getText());
        }
    }
    @Then("user will find {string}")
    public void user_will_find(String expectedResult) {
        SoftAssert softAssert = new SoftAssert();
        String actual = Hooks.driver.findElement(By.cssSelector("div[class=\"details\"]")).getText();
        softAssert.assertTrue(actual.contains(expectedResult), "Not found product");
        softAssert.assertAll();
    }
}
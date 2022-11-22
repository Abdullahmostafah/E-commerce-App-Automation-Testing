package org.example.stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.example.pages.P07_Color;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import static org.example.pages.P06_Category.ChoosingMenuElement;
import static org.example.pages.P06_Category.ChoosingSubMenuElement;

public class D07_stepDefinitionColor {
    P07_Color p07_filterColor = new P07_Color();
    @And("user chooses Category and hover to open sub-Category")
    public void user_choose_Category_hover_to_open_subCategory() throws InterruptedException {
        Actions act = new Actions(Hooks.driver);
        act.moveToElement(ChoosingMenuElement()).moveToElement(ChoosingSubMenuElement()).click().build().perform();
    }
    @And("user can filter sub-Category with color")
    public void user_can_filter_subCategory_with_color() {
        p07_filterColor.colorFilterProduct().click();
    }
    @Then("user will find product with the selected color")
    public void user_will_find_product_with_the_selected_color() {
        Hooks.sleep(15);
        Assert.assertTrue(p07_filterColor.colorCheckProduct().isDisplayed(), "Error Message: Selected Color Not Found!");
    }
}

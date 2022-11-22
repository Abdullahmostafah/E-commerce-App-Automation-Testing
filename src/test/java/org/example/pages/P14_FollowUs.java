package org.example.pages;

import org.example.stepDefinition.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

import static org.example.stepDefinition.Hooks.driver;

public class P14_FollowUs {
        static String originalWindow;
        static SoftAssert verifyLink = new SoftAssert();
        public static By xpathUl() {
            return By.xpath("/html/body/div[6]/div[4]/div[1]/div[4]/div[1]/ul//a");
        }
        public static void openTab() {
            int sizeOfLinks = driver.findElements(xpathUl()).size();
            originalWindow = driver.getWindowHandle();
            for (int i = 0; i < sizeOfLinks; i++) {
                String clickAndOpenTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
                driver.findElements(xpathUl()).get(i).sendKeys(clickAndOpenTab);
                Hooks.sleep(100);
            }
        }
        public static void switchTab() {
            ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
            for (int i = 1; i <= 4; i++) {
                Hooks.sleep(100);
                driver.switchTo().window(tabs2.get(i));
                Hooks.sleep(100);
                driver.close();
            }
            driver.switchTo().window(originalWindow);
        }
        public static List<WebElement> ul() {
            return driver.findElements(By.xpath("/html/body/div[6]/div[4]/div[1]/div[4]/div[1]/ul//a"));
        }
}

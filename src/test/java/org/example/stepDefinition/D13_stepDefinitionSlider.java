package org.example.stepDefinition;

import io.cucumber.java.en.Given;

import static org.example.pages.P13_HomeSlider.link_1;
import static org.example.pages.P13_HomeSlider.link_2;

public class D13_stepDefinitionSlider {
        @Given("user select nivo control")
        public void user_select_nivo_control() {
            String linkClass_1 = link_1().getAttribute("class");
            String linkClass_2 = link_2().getAttribute("class");
            if (linkClass_1.contains("active")) {
                link_2().click();
                System.out.println("click on second link");
            }
            Hooks.sleep(20);
            if (linkClass_2.contains("active")) {
                link_1().click();
                System.out.println("click on first link");
            }
            Hooks.sleep(20);
        }
    }

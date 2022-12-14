package org.example.stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P12_Order;
import org.openqa.selenium.support.ui.Select;

public class D12_stepDefinitionOrder {
    P12_Order p12_orderCheckOut = new P12_Order();
    public static String city = "Cairo";
    public static String address1 = "Masr Elgdeda";
    public static String postCode = "11777";
    public static String phoneNo = "012345678911";
    public static String faxNo = "12345678";
    public static String cardHolderName = "Merna Hesham";
    public static String cardNumber = "9999999999";
    public static String cardCode = "999";

    @And("open shopping page")
    public void open_shopping_page(){
        Hooks.driver.get("https://demo.nopcommerce.com/cart");
    }
    @When("user agrees with terms and proceed to Checkout")
    public void user_agrees_with_terms_and_proceed_to_Checkout()  {
        p12_orderCheckOut.checkoutTermsPOM().click();
        p12_orderCheckOut.checkoutBtnPOM().click();

    }
    @And("user types Billing address to Create Order")
    public void user_types_Billing_address_to_Create_Order() {
        // Enter First Name //
        p12_orderCheckOut.checkoutFNamePOM().click();
        p12_orderCheckOut.checkoutFNamePOM().clear();
        p12_orderCheckOut.checkoutFNamePOM().sendKeys(Hooks.userFirstName);
        p12_orderCheckOut.checkoutLNamePOM().click();
        p12_orderCheckOut.checkoutLNamePOM().clear();
        p12_orderCheckOut.checkoutLNamePOM().sendKeys(Hooks.userLastName);
        p12_orderCheckOut.checkoutMailPOM().click();
        p12_orderCheckOut.checkoutMailPOM().clear();
        p12_orderCheckOut.checkoutMailPOM().sendKeys(Hooks.userValidEmail);
        Select country = new Select(p12_orderCheckOut.checkoutCountryPOM());
        country.selectByVisibleText("Egypt"); //Select Country Name using visible text
        Hooks.sleep(5000);
        p12_orderCheckOut.checkoutCityPOM().click();
        p12_orderCheckOut.checkoutCityPOM().clear();
        p12_orderCheckOut.checkoutCityPOM().sendKeys(city);
        p12_orderCheckOut.checkoutAddressPOM().click();
        p12_orderCheckOut.checkoutAddressPOM().clear();
        p12_orderCheckOut.checkoutAddressPOM().sendKeys(address1);
        p12_orderCheckOut.checkoutPostCodePOM().click();
        p12_orderCheckOut.checkoutPostCodePOM().clear();
        p12_orderCheckOut.checkoutPostCodePOM().sendKeys(postCode);
        p12_orderCheckOut.checkoutPhoneNoPOM().click();
        p12_orderCheckOut.checkoutPhoneNoPOM().clear();
        p12_orderCheckOut.checkoutPhoneNoPOM().sendKeys(phoneNo);
        p12_orderCheckOut.checkoutFaxNoPOM().click();
        p12_orderCheckOut.checkoutFaxNoPOM().clear();
        p12_orderCheckOut.checkoutFaxNoPOM().sendKeys(faxNo);
    }
    @And("user confirms Billing address")
    public void user_confirms_Billing_address() {
        p12_orderCheckOut.checkoutBillAddSaveBtnPOM().click();
        Hooks.sleep(3000);
    }
    @And("user chooses Shipping Method to Continue")
    public void user_chooses_Shipping_Method_to_Continue() {
        p12_orderCheckOut.checkoutShipMethSelPOM().click();
        p12_orderCheckOut.checkoutShipMethSaveBtnPOM().click();
        Hooks.sleep(3000);
    }
    @And("user chooses Payment Method to Continue")
    public void user_chooses_Payment_Method_to_Continue() {
        p12_orderCheckOut.checkoutPayMethSelPOM().click();
        p12_orderCheckOut.checkoutPayMethSaveBtnPOM().click();
        Hooks.sleep(3000);
    }
    @And("user fills out Payment Information")
    public void user_fills_out_Payment_Information() {
        Select card = new Select(p12_orderCheckOut.checkoutCardTypePOM());
        card.selectByValue("MasterCard"); //Select Credit Card Type from Value
        p12_orderCheckOut.checkoutCardHolderNamePOM().click();
        p12_orderCheckOut.checkoutCardHolderNamePOM().clear();
        p12_orderCheckOut.checkoutCardHolderNamePOM().sendKeys(cardHolderName);
        p12_orderCheckOut.checkoutCardNoPOM().click();
        p12_orderCheckOut.checkoutCardNoPOM().clear();
        p12_orderCheckOut.checkoutCardNoPOM().sendKeys(cardNumber);
        Select month = new Select(p12_orderCheckOut.checkoutCardExpMonthPOM());
        month.selectByValue("8");
        Select year = new Select(p12_orderCheckOut.checkoutCardExpYearPOM());
        year.selectByValue("2023"); //Select Card Expiration Year from Value
        p12_orderCheckOut.checkoutCardCodePOM().click();
        p12_orderCheckOut.checkoutCardCodePOM().clear();
        p12_orderCheckOut.checkoutCardCodePOM().sendKeys(cardCode);
        p12_orderCheckOut.checkoutPaymentSaveBtnPOM().click();
        System.out.println("Create Successful Order!");
    }
    @Then("user confirms his order")
    public void user_confirms_his_order() {
        p12_orderCheckOut.checkoutOrderConfirmBtnPOM().click();
        System.out.println("Your order has been successfully processed!");
    }
    @And("user checks order details")
    public void user_checks_order_details() {
        p12_orderCheckOut.checkoutOrderDetailsPOM().click();
        System.out.println("Title of page is: " + Hooks.driver.getTitle());
    }
    @And("user saves invoice")
    public void user_saves_invoice() {
        p12_orderCheckOut.checkoutInvoiceSavePOM().click();
        Hooks.sleep(3000);
        System.out.println("PDF Invoice has been downloaded Successfully");
    }
    @And("user prints invoice")
    public void user_prints_invoice() {
        p12_orderCheckOut.checkoutInvoicePrintPOM().click();
        Hooks.sleep(3000);
        System.out.println("Invoice has been printed Successfully");
    }
}
package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.ContactUs_PO;

public class A07_contactUs_Steps {

    ContactUs_PO contactUs_po = new ContactUs_PO();
    @Given("I navigate to contact us page")
    public void iNavigateToContactUsPage() {
        contactUs_po.navigateToContactUsPage();
    }

    @Then("I am presented with {string}, {string} and {string}")
    public void iAmPresentedWithCustomerCareInsuranceOfficerAndHROfficer(String a,String b, String c) {
        contactUs_po.verifyCustomerCareInsuranceOfficerAndHROfficerVisible(a, b, c);
    }

    @Then("I scroll down and verify the address")
    public void iScrollDownAndVerifyTheAddress() {
        contactUs_po.verifyAddress();
    }
}

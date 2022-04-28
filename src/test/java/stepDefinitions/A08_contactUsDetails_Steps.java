package stepDefinitions;

import io.cucumber.java.en.Then;
import pageObjects.ContactUsDetails_PO;

public class A08_contactUsDetails_Steps {

    ContactUsDetails_PO contactUsDetails_po = new ContactUsDetails_PO();

    @Then("I verify Department Name and Telephone Number are visible")
    public void iVerifyDepartmentNameAndTelephoneNumberAreVisible() {
        contactUsDetails_po.verifyDepartmentNameAndTelephoneNumberAreVisible();
    }

    @Then("I verify their Email Address and Brief Explanation are visible")
    public void iVerifyTheirEmailAddressAndBriefExplanationAreVisible() {
        contactUsDetails_po.verifyTheirEmailAddressAndBriefExplanationAreVisible();
    }
}

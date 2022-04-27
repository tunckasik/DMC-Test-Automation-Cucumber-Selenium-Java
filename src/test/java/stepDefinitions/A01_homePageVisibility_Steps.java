package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePageVisibility_PO;

public class A01_homePageVisibility_Steps {

    HomePageVisibility_PO homePageVisibility_po = new HomePageVisibility_PO();

    @Given("I navigate to homepage")
    public void iNavigateToHomepage() {
        homePageVisibility_po.navigatetohomepage();
    }

    @Then("I verify {} is visible")
    public void iVerifyInsurancePartnersIsVisible(String string) {
        switch (string) {
            case "home page logo":
                homePageVisibility_po.verifyHomePageLogo();
                break;
            case "Insurance Partners":
                homePageVisibility_po.verifyInsurancePartners();
                break;
            case "Working Hours":
                homePageVisibility_po.verifyWorkingHoursVisible();
                break;
            case "Request an Appointment":
                homePageVisibility_po.verifyAppointmentButtonVisible();
                break;
        }
    }

    @Then("I verify {string}, {string}, {string}, {string} and {string} are visible")
    public void iVerifyAboutUsDepartmentsContactCareersAndMagazineAreVisible(String a, String b, String c, String d, String e) {
        homePageVisibility_po.verifyAboutUsDepartmentsContactCareersMagazine(a, b, c, d, e);
    }

    @When("I click request an appointment")
    public void iClickRequestAnAppointment() {
        homePageVisibility_po.requestAnAppointmentButton.click();
    }

    @Then("I should be presented with a notice for insurance members")
    public void iShouldBePresentedWithANoticeForInsuranceMembers() {
        homePageVisibility_po.verifyNoticeMessageForInsuranceMembers();
    }

    @Then("I close the pop")
    public void iCloseThePop() {
        homePageVisibility_po.closeButton.click();
    }


}

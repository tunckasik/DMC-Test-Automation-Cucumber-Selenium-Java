package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.*;

public class A01_homePageVisibility_Steps {

    HomePageVisibility_PO homePageVisibility_po = new HomePageVisibility_PO();
    AboutUs_PO aboutUs_po = new AboutUs_PO();
    Departments_PO departments_po = new Departments_PO();
    ContactUs_PO contactUs_po = new ContactUs_PO();
    CareerPage_ApplyNow_PO careerPage_applyNow_po = new CareerPage_ApplyNow_PO();

    @Given("I navigate to homepage")
    public void iNavigateToHomepage() {
        homePageVisibility_po.navigatetohomepage();
    }

    @Then("I verify {} is visible")
    public void iVerifyInsurancePartnersIsVisible(String string) {
        switch (string) {
            case "home page":
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
            //aboutUs #6 is also here
            case "about us page":
                aboutUs_po.verifyAboutUsPageIsVisible();
                break;
            case "Core Value of DMC":
                aboutUs_po.verifyCoreValueofDMCIsVisible();
                break;
            case "Dr. Kadir":
                aboutUs_po.verifyDrKadirIsVisible();
                break;
                //department #6 is also here;
            case "Our Medical Services":
                departments_po.verifyOurMedicalServicesIsVisible();
                break;
                //contact Us #6
            case "contact us":
                contactUs_po.verifyContactUs();
                break;
                //careerPage #9
            case "Apply Now":
                careerPage_applyNow_po.verifyApplyNowIsVisible();
                break;
            case "Home /Careers":
                careerPage_applyNow_po.verifyHomeCareerIsVisible();
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
        homePageVisibility_po.clickCloseButton();
    }


}

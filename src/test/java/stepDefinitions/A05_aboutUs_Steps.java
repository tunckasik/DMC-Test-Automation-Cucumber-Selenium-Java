package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AboutUs_PO;

public class A05_aboutUs_Steps {

    AboutUs_PO aboutUs_po = new AboutUs_PO();

    @Given("I navigate to about us page")
    public void iNavigateToAboutUsPage() {
        aboutUs_po.navigateToAboutUsPage();
    }

    @When("I scroll down and verify Our Mission, Our Vision and Core Value are visible")
    public void iScrollDownAndVerifyOurMissionOurVisionAndCoreValueAreVisible() {
        aboutUs_po.scrollDownAndVerifyOurMissionOurVisionAndCoreValueAreVisible();
    }

    @Then("I click Core Value")
    public void iClickCoreValue() {
        aboutUs_po.clickCoreVue();
    }

    @Then("I verify {int} doctors are listed")
    public void iVerifyDoctorsAreListed(int arg0) {
        aboutUs_po.verifyDoctorsNumber(arg0);
    }
}

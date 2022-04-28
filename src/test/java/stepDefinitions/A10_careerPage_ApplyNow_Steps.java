package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.CareerPage_ApplyNow_PO;

public class A10_careerPage_ApplyNow_Steps {

    CareerPage_ApplyNow_PO careerPage_applyNow_po = new CareerPage_ApplyNow_PO();

    @Given("I navigate to career page")
    public void iNavigateToCareerPage() {
        careerPage_applyNow_po.navigateToCareerPage();
    }

    @Then("I click Apply Now and verify Application form is opened")
    public void iClickApplyNowAndVerifyApplicationFormIsOpened() {
    careerPage_applyNow_po.clickApplyNowAndVerifyApplicationFormIsOpened();
    }

    @Then("I fill the application form")
    public void iFillTheApplicationForm() {
    careerPage_applyNow_po.setFillTheApplicationForm();
    }

    @Then("I attach my profile photo and write a message")
    public void iAttachMyProfilePhotoAndWriteAMessage() {
    careerPage_applyNow_po.setAttachMyProfilePhotoAndWriteAMessage();
    }

    @Then("I click on send, I should be directed to home page")
    public void iClickOnSendIShouldBeDirectedToHomePage() {
        careerPage_applyNow_po.clickOnSendIShouldBeDirectedToHomePage();
    }
}

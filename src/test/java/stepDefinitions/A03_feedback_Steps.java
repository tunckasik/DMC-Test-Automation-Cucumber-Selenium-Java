package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Feedback_PO;

public class A03_feedback_Steps {

    Feedback_PO feedback_po = new Feedback_PO();
    @When("I hover and click feedback button")
    public void iHoverAndClickFeedbackButton() {
        feedback_po.hoverAndClickFeedback();
    }

    @Then("I verify feedback popup opened")
    public void iVerifyFeedbackPopupOpened() {
        feedback_po.verifyFeedbackPopupOpened();
    }

    @When("I fill the details and send the feedback")
    public void iFillTheDetailsAndSendTheFeedback() {
        feedback_po.fillTheDetailsAndSendTheFeedback();
    }

    @Then("I should be presented with a success feedback message")
    public void iShouldBePresentedWithASuccessFeedbackMessage() {
        feedback_po.verifySuccessFeedbackMessage();
    }

    @Then("I click OK and navigate to homepage")
    public void iClickOKAndNavigateToHomepage() {
        feedback_po.clickOKAndNavigateToHomepage();
     }


}

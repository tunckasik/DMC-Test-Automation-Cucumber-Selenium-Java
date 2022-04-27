package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.RequestAnAppointment_PO;

public class A02_requestAnAppointment_Steps {

    RequestAnAppointment_PO requestAnAppointment_po = new RequestAnAppointment_PO();


    @Then("I click next and fill the details")
    public void iClickNextAndFillTheDetails() {
        requestAnAppointment_po.clickNextAndFillTheDetails();
    }

    @Then("I attach the a file and write a message")
    public void iAttachTheAFileAndWriteAMessage() {
        requestAnAppointment_po.setAttachAFileAndWriteAMessage();
    }

    @When("I click on Request, I should be presented with success message")
    public void iClickOnRequestIShoulBePresentedWithSuccessMessage() {
        requestAnAppointment_po.clickOnRequestAndVerifySuccessMessage();
    }

}

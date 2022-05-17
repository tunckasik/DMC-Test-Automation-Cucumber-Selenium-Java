package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.JoinUsDirection_PO;

public class A04_joinUsDirection_Steps {

    JoinUsDirection_PO joinUsDirection_po = new JoinUsDirection_PO();
    @When("I scroll down and verify Join us is visible")
    public void iScrollDownAndVerifyJoinUsIsVisible() {
        joinUsDirection_po.ScrollDownAndVerifyJoinUsIsVisible();
    }

    @Then("I click Apply Now button")
    public void iClickApplyNowButton() {
        joinUsDirection_po.clickApplyNow();
    }

    @Then("I should be directed to new page")
    public void iShouldBeDirectedToNewPage() {
        joinUsDirection_po.handleNewWindowPage();
    }

    @Then("I verify I am navigated to career page")
    public void iVerifyIAmNavigatedToCareerPage() {
        joinUsDirection_po.verifyIAmNavigatedToCareerPage();
    }


}

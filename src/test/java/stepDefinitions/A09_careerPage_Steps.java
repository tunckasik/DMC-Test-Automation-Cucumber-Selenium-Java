package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CareerPage_PO;

public class A09_careerPage_Steps {
    CareerPage_PO careerPage_po = new CareerPage_PO();

    @Then("I verify {string} and {string} are visible")
    public void iVerifyApplyNowAndHomeCareersAreVisible(String string, String string2) {
        careerPage_po.verifyCareerAndHomeCareersAreVisible(string, string2);
    }

    @And("I verify Latest Jobs and Physiotherapist are visible")
    public void iVerifyLatestJobsAndPhysiotherapistAreVisible() {
        careerPage_po.verifyLatestJobsAndPhysiotherapistAreVisible();
    }

    @When("I click Learn More")
    public void iClickLearnMore() {
        careerPage_po.clickLearnMore();
    }

    @Then("I verify {string}, {string}, {string} and {string} are visible")
    public void iVerifyJobBriefResponsibilitiesQualificationsSkillsAndRequirementsAreVisible(String a, String b, String c, String d) {
        careerPage_po.verifyJobBriefResponsibilitiesQualificationsSkillsAndRequirementsAreVisible(a, b, c, d);
    }

    @Then("I verify that Apply Now visible")
    public void iVerifyThatApplyNowVisible() {
        careerPage_po.verifyApplyNowIsVisible();
    }
}

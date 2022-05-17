package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CareerPage_PO extends Base_PO {
    public CareerPage_PO() {
        super();
    }

    @FindBy(xpath = "//a[@class='popup-with-form'][contains(.,'Apply Now')]")
    public WebElement applyNowTextAndLink;

    @FindBy(xpath = "//p[contains(.,'Home / Careers')]")
    public WebElement homeCareers;

    @FindBy(xpath = "//h3[@class='mb-30'][contains(.,'Latest Jobs')]")
    public WebElement latestJobs;

    @FindBy(xpath = "//h3[contains(.,'Physiotherapist')]")
    public WebElement physiotherapist;

    @FindBy(xpath = "//a[@href='/job_detail/9'][contains(.,'Learn More')]")
    public WebElement learnMoreButton;

    @FindBy(xpath = "//b[contains(.,'Job Brief')]")
    public WebElement jobBrief;

    @FindBy(xpath = "//b[contains(.,'Responsibilities')]")
    public WebElement responsibilities;

    @FindBy(xpath = "//b[contains(.,'Qualifications/Skills')]")
    public WebElement qualificationsSkills;

    @FindBy(xpath = "//b[contains(.,'Requirements')]")
    public WebElement requirements;

    @FindBy(xpath = "//b[contains(.,'Apply Now')]")
    public WebElement applyNowButton;

    public void verifyCareerAndHomeCareersAreVisible(String applynow,String homecareer) {
        waitForSubmissionAndValidateText(applyNowTextAndLink, applynow);
        waitForSubmissionAndValidateText(homeCareers, homecareer);
    }
    public void verifyLatestJobsAndPhysiotherapistAreVisible(){
        scrollDown(latestJobs);
        waitForWebelement_Message(latestJobs);
        waitForWebelement_Message(physiotherapist);
    }
    public void clickLearnMore(){
        waitForWebElementAndClick(learnMoreButton);
        waitFor(2);
    }

    public void verifyJobBriefResponsibilitiesQualificationsSkillsAndRequirementsAreVisible(String a, String b, String c, String d){
        scrollDown(jobBrief);
        Assert.assertEquals(jobBrief.getText(), a);
        Assert.assertEquals(responsibilities.getText(), b);
        scrollDown(qualificationsSkills);
        Assert.assertEquals(qualificationsSkills.getText(), c);
        Assert.assertEquals(requirements.getText(), d);
    }
    public void verifyApplyNowIsVisible(){
        scrollDown(applyNowButton);
        waitForWebelement_Message(applyNowButton);
    }
}

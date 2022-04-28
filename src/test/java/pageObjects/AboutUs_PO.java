package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utils.ConfigReader;

import java.util.List;

public class AboutUs_PO extends Base_PO {
    public AboutUs_PO() {
        super();
    }


    @FindBy(xpath = "(//a[@href='/about/'][contains(.,'About us')])[1]")
    public WebElement aboutUsLink;

    @FindBy(xpath = "//p[contains(.,'Home /About us')]")
    public WebElement AboutUsText;

    @FindBy(xpath = "//div[@class='welcome_docmed_info']")
    public WebElement welcomeEdgeforScrolldown;
    @FindBy(xpath = "//a[@class='nav-link active'][contains(.,'Our Vision')]")
    public WebElement ourVision;

    @FindBy(xpath = "//a[@class='nav-link'][contains(.,'Our mission')]")
    public WebElement ourMission;

    @FindBy(xpath = "//a[@id='contact-tab']")
    public WebElement ourCoreValues;

    @FindBy(xpath = "//h3[contains(.,'Core values of Deva Medical Center')]")
    public WebElement coreValuesOfText;

    @FindBy(xpath = "//div[@class='col-md-6 col-lg-3']")
    public WebElement doctorslist;

    @FindBy(xpath = "//h3[contains(.,'Dr. Kadir MAMATALIEV')]")
    public WebElement drkadir;

    public void navigateToAboutUsPage() {
        waitFor(2);
        navigateTo_URL(ConfigReader.DEFAULT_WEBSITE_HOMEPAGE);
        waitForWebElementAndClick(aboutUsLink);
        waitFor(1);
    }

    public void verifyAboutUsPageIsVisible() {
        waitForWebelement_Message(AboutUsText);
    }

    public void scrollDownAndVerifyOurMissionOurVisionAndCoreValueAreVisible() {
        scrollDown(welcomeEdgeforScrolldown);
        waitForWebelement_Message(ourVision);
        waitForWebelement_Message(ourMission);
        waitForWebelement_Message(ourCoreValues);
        System.out.println("I verified vision, mission and core values are visible");
    }

    public void clickCoreVue() {
        waitForWebElementAndClick(ourCoreValues);
        scrollDown(ourCoreValues);
        System.out.println("I clicked on 'Our core values'");
    }

    public void verifyCoreValueofDMCIsVisible() {
        waitForWebelement_Message(coreValuesOfText);
    }

    public void  verifyDrKadirIsVisible(){
        waitForWebelement_Message(drkadir);
    }

    public void verifyDoctorsNumber(int expected) {
        List<WebElement> list = getDriver().findElements(By.xpath("//div[@class='col-md-6 col-lg-3']"));

        System.out.println("Number of Doctors listed in About Us Page is : " + list.size());

        int actual = list.size();
        Assert.assertEquals(actual,expected);
    }

}

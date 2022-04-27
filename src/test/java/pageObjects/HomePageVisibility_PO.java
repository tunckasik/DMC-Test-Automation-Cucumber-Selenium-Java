package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.ConfigReader;
import utils.DriverFactory;

public class HomePageVisibility_PO extends Base_PO {

    public HomePageVisibility_PO() {
        super();
    }


    @FindBy(xpath = "//img[@src='/static/img/logo.png']")
    public WebElement headimage;

    @FindBy(xpath = "(//a[contains(.,'About us')])[1]")
    public WebElement aboutUs;

    @FindBy(xpath = "(//a[contains(.,'Departments')])[1]")
    public WebElement departments;

    @FindBy(xpath = "(//a[contains(.,'Contact')])[1]")
    public WebElement contactUs;

    @FindBy(xpath = "(//a[contains(.,'Careers')])[1]")
    public WebElement careers;

    @FindBy(xpath = "(//a[contains(.,'Magazine')])[1]")
    public WebElement magazine;

    @FindBy(xpath = "//h2[@class='d-flex align-items-center'][contains(.,'Working Hours')]")
    public WebElement workingHoursText;

    @FindBy(xpath = "//h2[@class='d-flex align-items-center'][contains(.,'Insurance Partners')]")
    public WebElement insurancePartnerText;

    @FindBy(xpath = "//a[@class='popup-with-form'][contains(.,'Request an appointment')]")
    public WebElement requestAnAppointmentButton;

    @FindBy(xpath = "//h3[contains(.,'NOTICE FOR INSURANCE MEMBERS')]")
    public WebElement noticeForInsuranceMemberText;

    @FindBy(xpath = "//button[@title='Close (Esc)'][contains(.,'×')]")
    public WebElement closeButton;


    public void navigatetohomepage() {
        System.out.println("We are landing home page");
        waitFor(2);
        navigateTo_URL(ConfigReader.DEFAULT_WEBSITE_HOMEPAGE);
    }

    public void verifyHomePageLogo() {
        waitForSubmission_Message(headimage);
    }

    public void verifyWorkingHoursVisible(){
        waitForSubmission_Message(workingHoursText);
    }

    public void verifyInsurancePartners() {
        waitForSubmission_Message(insurancePartnerText);
    }

    public void verifyAppointmentButtonVisible(){
        waitForSubmission_Message(requestAnAppointmentButton);
    }

    public void verifyAboutUsDepartmentsContactCareersMagazine(String a, String b, String c, String d, String e) {
        Assert.assertEquals(aboutUs.getText(), a);
        Assert.assertEquals(departments.getText(), b);
        Assert.assertEquals(contactUs.getText(), c);
        Assert.assertEquals(careers.getText(), d);
        Assert.assertEquals(magazine.getText(), e);
    }

    public void verifyNoticeMessageForInsuranceMembers() {
        String expectedNotice = "NOTICE FOR INSURANCE MEMBERS";
        String actualNotice = noticeForInsuranceMemberText.getText();
        Assert.assertEquals(actualNotice, expectedNotice);
        System.out.println("Notice for Insurance Member is visible!");
    }
}

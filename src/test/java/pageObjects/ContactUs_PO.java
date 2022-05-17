package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utils.ConfigReader;

public class ContactUs_PO extends Base_PO {
    public ContactUs_PO() {
        super();
    }

    @FindBy(xpath = "//a[@href='/contact/'][contains(.,'Contact')]")
    public WebElement contactLink;

    @FindBy(xpath = "//h3[contains(.,'Contact us')]")
    public WebElement contactUs;

    @FindBy(xpath = "//h3[contains(.,'Customer Care')]")
    public WebElement customerCare;

    @FindBy(xpath = "//h3[contains(.,'Insurance Officer')]")
    public WebElement insuranceOfficer;

    @FindBy(xpath = "//h3[contains(.,'HR Officer')]")
    public WebElement hrOfficer;


    //Google Map locator
    @FindBy(xpath = "//html[contains(@class,'js sizes customelements history pointerevents postmessage webgl websockets cssanimations csscolumns csscolumns-width csscolumns-span csscolumns-fill csscolumns-gap csscolumns-rule csscolumns-rulecolor csscolumns-rulestyle csscolumns-rulewidth csscolumns-breakbefore csscolumns-breakafter csscolumns-breakinside flexbox picture srcset webworkers')]")
    public WebElement addressText;

    public void navigateToContactUsPage() {
        navigateTo_URL(ConfigReader.DEFAULT_WEBSITE_HOMEPAGE);
        waitFor(2);
        waitForWebElementAndClick(contactLink);
    }

    public void verifyContactUs() {
        waitForWebelement_Message(contactUs);
    }

    public void verifyCustomerCareInsuranceOfficerAndHROfficerVisible(String a, String b, String c) {
        Assert.assertEquals(customerCare.getText(), a);
        Assert.assertEquals(insuranceOfficer.getText(), b);
        Assert.assertEquals(hrOfficer.getText(), c);
    }

    public void verifyAddress(){
        scrollDown(customerCare);
        waitFor(5);
        waitForWebelement_Message(addressText);
    }
}

package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utils.ConfigReader;

public class ContactUsDetails_PO extends Base_PO {

    public ContactUsDetails_PO() {
        super();
    }

    @FindBy(xpath = "//h3[contains(.,'Customer Care')]")
    public WebElement customerCareText;

    @FindBy(xpath = "//h3[contains(.,'+250 788 333 111')]")
    public WebElement  customerCare_Telephone;

    @FindBy(xpath = "//h3[contains(.,'info@devamc.com')]")
    public WebElement  customerCare_Email;

    @FindBy(xpath = "(//p[contains(.,'Send us your query anytime!')])[1]")
    public WebElement  customerCare_brief;

    @FindBy(xpath = "//h3[contains(.,'Insurance Officer')]")
    public WebElement  insuranceOfficerText;

    @FindBy(xpath = "//h3[contains(.,'+250 788 333 999')]")
    public WebElement  insuranceOfficer_Telephone;

    @FindBy(xpath = "//h3[contains(.,'insurance@devamc.com')]")
    public WebElement  insuranceOfficer_Email;

    @FindBy(xpath = "(//p[contains(.,'Send us your query anytime!')])[2]")
    public WebElement  insuranceOfficer_breif;

    @FindBy(xpath = "//h3[contains(.,'HR Officer')]")
    public WebElement  hROfficerText;

    @FindBy(xpath = "//h3[contains(.,'+250 788 333 000')]")
    public WebElement  hROfficer_Telephone;

    @FindBy(xpath = "//h3[contains(.,'hr@devamc.com')]")
    public WebElement  hROfficer_Email;

    @FindBy(xpath = "//p[contains(.,'Before sending an email please check on career page!')]")
    public WebElement  hROfficer_breif;

    public void verifyDepartmentNameAndTelephoneNumberAreVisible(){
        Assert.assertEquals(customerCareText.getText(), ConfigReader.getProperty("Department_1"));
        Assert.assertEquals(customerCare_Telephone.getText(),ConfigReader.getProperty("Customer_Care_Tel_No"));

        Assert.assertEquals(insuranceOfficerText.getText(), ConfigReader.getProperty("Department_2"));
        Assert.assertEquals(insuranceOfficer_Telephone.getText(),ConfigReader.getProperty("Insurance_Officer_Tel_No"));

        Assert.assertEquals(hROfficerText.getText(), ConfigReader.getProperty("Department_3"));
        Assert.assertEquals(hROfficer_Telephone.getText(),ConfigReader.getProperty("HR_Officer_Tel_No"));
        waitFor(1);
    }
    public void verifyTheirEmailAddressAndBriefExplanationAreVisible(){
        Assert.assertEquals(customerCare_Email.getText(), ConfigReader.getProperty("Customer_Care_Email"));
        Assert.assertEquals(customerCare_brief.getText(),ConfigReader.getProperty("Customer_Care_brief"));

        Assert.assertEquals(insuranceOfficer_Email.getText(), ConfigReader.getProperty("Insurance_Officer_Email"));
        Assert.assertEquals(insuranceOfficer_breif.getText(),ConfigReader.getProperty("Insurance_Officer_brief"));

        Assert.assertEquals(hROfficer_Email.getText(), ConfigReader.getProperty("HR_Officer_Email"));
        Assert.assertEquals(hROfficer_breif.getText(),ConfigReader.getProperty("HR_Officer_brief"));
        waitFor(1);
    }
}

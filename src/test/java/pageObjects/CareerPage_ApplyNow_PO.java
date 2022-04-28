package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utils.ConfigReader;

public class CareerPage_ApplyNow_PO extends Base_PO {

    public CareerPage_ApplyNow_PO() {
        super();
    }

    @FindBy(xpath = "(//a[@href='/career/'][contains(.,'Careers')])[1]")
    public WebElement careersLink;

    @FindBy(xpath = "//p[contains(.,'Home / Careers')]")
    public WebElement homeCareerText;

    @FindBy(xpath = "//a[@class='popup-with-form'][contains(.,'Apply Now')]")
    public WebElement applyNowTextAndLink;

    @FindBy(xpath = "//h3[contains(.,'Application Form')]")
    public WebElement applicationFormText;

    @FindBy(xpath = "//span[@class='current'][contains(.,'Position Title')]")
    public WebElement positionTitleDropList;

    @FindBy(xpath = "//li[@data-value='Finance/Accountant'][contains(.,'Finance/Accountant')]")
    public WebElement positionTitleFinanceLink;

    @FindBy(xpath = "//input[contains(@name,'applicant_name')]")
    public WebElement applicantName;

    @FindBy(xpath = "//input[contains(@name,'applicant_phone')]")
    public WebElement applicantPhone;

    @FindBy(xpath = "//input[contains(@type,'email')]")
    public WebElement applicantEmail;

    @FindBy(xpath = "//div[@class='nice-select form-select wide'][contains(.,'GenderGenderMaleFemale')]")
    public WebElement genderDropList;

    @FindBy(xpath = "//li[@data-value='Female'][contains(.,'Female')]")
    public WebElement genderFemaleLink;
    @FindBy(xpath = "//input[contains(@id,'birthdate')]")
    public WebElement birthdate;

    @FindBy(xpath = "//input[contains(@name,'applicant_resume')]")
    public WebElement resumeInput;

    @FindBy(xpath = "//input[contains(@name,'additional_docs')]")
    public WebElement additionalInput;

    @FindBy(xpath = "//span[@class='current'][contains(.,'English Level')]")
    public WebElement englishLevelDropList;

    @FindBy(xpath = "//li[@data-value='Elemantary'][contains(.,'Elemantary')]")
    public WebElement englishLevelElementary;

    @FindBy(xpath = "//span[@class='current'][contains(.,'Employee Status')]")
    public WebElement employeeStatusDropList;

    @FindBy(xpath = "//li[@data-value='Working'][contains(.,'Working')]")
    public WebElement employeeStatusWorking;

    @FindBy(xpath = "//input[contains(@name,'current_position')]")
    public WebElement current_position;

    @FindBy(xpath = "//span[@class='current'][contains(.,'Experience Years')]")
    public WebElement experienceYearsDropList;

    @FindBy(xpath = "//li[@data-value='1-3'][contains(.,'1-3')]")
    public WebElement experienceYearsOneThree;

    @FindBy(xpath = "//input[contains(@placeholder,'profile Picture')]")
    public WebElement photoInput;

    @FindBy(xpath = "//input[contains(@name,'city')]")
    public WebElement cityName;

    @FindBy(xpath = "//input[contains(@name,'sector')]")
    public WebElement sectorName;

    @FindBy(xpath = "//input[contains(@name,'cell')]")
    public WebElement cellName;

    @FindBy(xpath = "//textarea[contains(@name,'message')]")
    public WebElement messageField;

    @FindBy(xpath = "//button[@type='submit'][contains(.,'Send')]")
    public WebElement sendButton;

    @FindBy(xpath = "//img[@src='/static/img/logo.png']")
    public WebElement headimage;

    public void navigateToCareerPage() {
        navigateTo_URL(ConfigReader.DEFAULT_WEBSITE_HOMEPAGE);
        waitFor(1);
        waitForWebElementAndClick(careersLink);
        waitFor(1);
    }

    public void verifyApplyNowIsVisible() {
        waitForWebelement_Message(applicationFormText);
    }

    public void verifyHomeCareerIsVisible() {
        waitForWebelement_Message(homeCareerText);
    }

    public void clickApplyNowAndVerifyApplicationFormIsOpened() {
        waitForWebElementAndClick(applyNowTextAndLink);
        waitForWebelement_Message(applicationFormText);
    }

    public void setFillTheApplicationForm() {
        waitFor(1);
        waitForDropListAndSelectOption(positionTitleDropList, positionTitleFinanceLink);
        waitFor(1);
        sendKeys(applicantName, ConfigReader.getProperty("Applicant_Name"));
        sendKeys(applicantPhone, ConfigReader.getProperty("Applicant_Telephone"));
        sendKeys(applicantEmail, ConfigReader.getProperty("Applicant_Email"));
        waitFor(1);
        waitForDropListAndSelectOption(genderDropList, genderFemaleLink);
        waitFor(1);
        sendKeys(birthdate, "10" + "10" + "2000");
        resumeInput.sendKeys(ConfigReader.getProperty("Upload_Resume"));
        additionalInput.sendKeys(ConfigReader.getProperty("Upload_Resume"));
        waitForDropListAndSelectOption(englishLevelDropList, englishLevelElementary);
        waitForDropListAndSelectOption(employeeStatusDropList,employeeStatusWorking );
        scrollDown(current_position);
        waitFor(1);
        sendKeys(current_position, ConfigReader.getProperty("Applicant_CurrentPosition"));
        waitForDropListAndSelectOption(experienceYearsDropList, experienceYearsOneThree);
    }

    public void setAttachMyProfilePhotoAndWriteAMessage() {
        photoInput.sendKeys(ConfigReader.getProperty("Applicant_Photo"));
        sendKeys(cityName, ConfigReader.getProperty("Applicant_City"));
        sendKeys(sectorName, ConfigReader.getProperty("Applicant_Sector"));
        sendKeys(cellName, ConfigReader.getProperty("Applicant_Cell"));
        sendKeys(messageField, "Thank you!");
        waitFor(1);

    }

    public void clickOnSendIShouldBeDirectedToHomePage() {
        waitForWebElementAndClick(sendButton);
        waitFor(2);
        waitForWebelement_Message(headimage);

    }

}

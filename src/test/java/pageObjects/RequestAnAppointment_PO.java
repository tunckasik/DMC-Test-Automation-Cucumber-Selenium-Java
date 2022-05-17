package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utils.ConfigReader;

public class RequestAnAppointment_PO extends Base_PO {

    public RequestAnAppointment_PO(){
        super();
    }

    @FindBy(xpath = "//button[@class='boxed-btn3'][contains(.,'Next')]")
    public WebElement nextButton;

    @FindBy(xpath = "(//h3[contains(.,'Request an appointment')])[1]")
    public WebElement  requestAnAppointmentText;

    @FindBy(xpath = "//input[contains(@name,'first_name')]")
    public WebElement  firstNameField;

    @FindBy(xpath = "//input[contains(@name,'last_name')]")
    public WebElement  lastNameField;

    @FindBy(xpath = "//select[contains(@name,'gender')]")
    public WebElement  genderDropList;

    @FindBy(xpath = "//select[@name='age']")
    public WebElement  ageDropList;

    @FindBy(xpath = "//select[contains(@id,'insurance1')]")
    public WebElement  insuranceYesNoDropList;

    @FindBy(xpath = "//select[contains(@id,'insurance2')]")
    public WebElement  insurancesDropList;

    @FindBy(xpath = "(//select[contains(@name,'department')])[2]")
    public WebElement departmentDropList;

    @FindBy(xpath = "//select[contains(@name,'doctor')]")
    public WebElement  doctorDropList;

    @FindBy(xpath = "//input[contains(@placeholder,'Pick date')]")
    public WebElement  dateField;

    @FindBy(xpath = "//input[contains(@type,'time')]")
    public WebElement  timeField;

    @FindBy(xpath = "//input[@name='phone']")
    public WebElement  phoneNumberField;

    @FindBy(xpath = "//input[contains(@name,'phone2')]")
    public WebElement  phoneNumberConfirmField;

    @FindBy(xpath = "//input[contains(@type,'file')]")
    public WebElement chooseFileButton;

    @FindBy(xpath = "//textarea[contains(@placeholder,'Write a message...')]")
    public WebElement  writeMessageField;

    @FindBy(xpath = "//button[@type='submit'][contains(.,'Request')]")
    public WebElement  requestInRequestButton;

    @FindBy(xpath = "//a[@href='/'][contains(.,'OK')]")
    public WebElement  okButton;

    @FindBy(xpath = "//strong[contains(.,'Thank you for your request!We will get back to you shortly')]")
    public WebElement  thankYouForYourRequestText;

    public void clickNextAndFillTheDetails(){
        waitForWebelement_Message(requestAnAppointmentText);
        waitForWebElementAndClick(nextButton);
        sendKeys(firstNameField,ConfigReader.getProperty("First_name"));
        sendKeys(lastNameField,ConfigReader.getProperty("Last_name"));

        selectByValueFromDropDown(genderDropList, ConfigReader.getProperty("Gender"));
        selectByValueFromDropDown(ageDropList,ConfigReader.getProperty("Age"));
        selectByValueFromDropDown(insuranceYesNoDropList,ConfigReader.getProperty("Insurance_YesNo"));
        selectByValueFromDropDown(insurancesDropList,ConfigReader.getProperty("Insurance_Company"));
        selectByValueFromDropDown(departmentDropList,ConfigReader.getProperty("Department"));
        selectByValueFromDropDown(doctorDropList,ConfigReader.getProperty("Doctor"));

        waitFor(1);
        sendKeys(dateField,"01" + "01" + "2022");
        //To be able to select AM or PM "1" or "2"
        sendKeys(timeField,"07" + "30" + "1");
        sendKeys(phoneNumberField,ConfigReader.getProperty("Phone_Number"));
        sendKeys(phoneNumberConfirmField,ConfigReader.getProperty("Phone_Number"));

    }
    public void  setAttachAFileAndWriteAMessage() {
        chooseFileButton.sendKeys("C:/Users/CanBec/Downloads/MurakozeTest.txt");
        sendKeys(writeMessageField, "Murakoze cyane!");
        waitFor(1);

    }
    public void clickOnRequestAndVerifySuccessMessage(){
        scrollDown(requestInRequestButton);
        waitForWebElementAndClick(requestInRequestButton);
        waitFor(2);
        String expectedSuccessMessage = "Thank you for your request!\n" +
                "We will get back to you shortly";
        String actualSuccessMessage = thankYouForYourRequestText.getText();
        System.out.println(actualSuccessMessage);
        Assert.assertEquals(actualSuccessMessage, expectedSuccessMessage);
    }
}

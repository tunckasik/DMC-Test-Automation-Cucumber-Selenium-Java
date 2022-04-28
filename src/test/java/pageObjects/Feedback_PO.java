package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.ConfigReader;

public class Feedback_PO extends Base_PO {

    public Feedback_PO(){
        super();
    }

    @FindBy(xpath = "//button[contains(@id,'brochure')]")
    public WebElement feedbackButton;

    @FindBy(xpath = "//h3[contains(.,'Share you experience with us')]")
    public WebElement  feedbackMessageText;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement  nameInput;

    @FindBy(xpath = "//input[contains(@name,'title')]")
    public WebElement  titleInput;

    @FindBy(xpath = "(//textarea[contains(@name,'message')])")
    public WebElement  messageInput;

    @FindBy(xpath = "//button[@type='submit'][contains(.,'Send')]")
    public WebElement  sendButton;

    @FindBy(xpath = "//strong[contains(.,'Thank you for your feedback')]")
    public WebElement  successMessageText;

    @FindBy(xpath = "//a[@href='/'][contains(.,'OK')]")
    public WebElement successOkButton;

    @FindBy(xpath = "//img[@src='/static/img/logo.png']")
    public WebElement headimage;

    public void hoverAndClickFeedback(){
        hover(feedbackButton);
        feedbackButton.click();
    }
    public void verifyFeedbackPopupOpened(){
        waitForSubmissionAndValidateText(feedbackMessageText,"Share you experience with us");
    }

    public void fillTheDetailsAndSendTheFeedback(){
        sendKeys(nameInput, ConfigReader.getProperty("Name"));
        sendKeys(titleInput,ConfigReader.getProperty("Title"));
        sendKeys(messageInput,ConfigReader.getProperty("Message"));
        waitFor(2);
        sendButton.click();
    }
    public void verifySuccessFeedbackMessage(){
        waitForSubmissionAndValidateText(successMessageText,"Thank you for your feedback");
        waitFor(1);
    }
    public void clickOKAndNavigateToHomepage(){
        waitForWebElementAndClick(successOkButton);
        waitFor(2);
        waitForWebelement_Message(headimage);

    }
}

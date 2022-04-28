package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Set;

public class JoinUsDirection_PO extends Base_PO{

    public JoinUsDirection_PO(){
        super();
    }

    @FindBy(xpath = "//h5[@class='widget-title'][contains(.,'Join us')]")
    public WebElement  joinUsText;

    @FindBy(xpath = "//p[contains(.,'Join our special warm family....we can do better with you')]")
    public WebElement joinUsMessage;

    @FindBy(xpath = "//b[contains(.,'Apply Now')]")
    public WebElement  applyNowButton;

    @FindBy(xpath = "//p[contains(.,'Home / Careers')]")
    public WebElement careerPageTitle;

    public void ScrollDownAndVerifyJoinUsIsVisible(){
        scrollDown(joinUsText);
        waitForSubmissionAndValidateText(joinUsMessage, "Join our special warm family....we can do better with you");
        waitFor(1);
    }

    public void clickApplyNow(){
        waitForWebElementAndClick(applyNowButton);
    }
    public void handleNewWindowPage() {
        String parentWindow = getDriver().getWindowHandle();
        Set<String> handles =  getDriver().getWindowHandles();
        for(String newURL  : handles)
        {
            if(!newURL.equals(parentWindow))
            {
                getDriver().switchTo().window(newURL);
//         Perform the operation here for new window
//                getDriver().close(); //closing child window
//                getDriver().switchTo().window(parentWindow); //cntrl to parent window
            }
        }
    }

    public void verifyIAmNavigatedToCareerPage(){
        waitFor(2);
        waitForWebelement_Message(careerPageTitle);
    }
}

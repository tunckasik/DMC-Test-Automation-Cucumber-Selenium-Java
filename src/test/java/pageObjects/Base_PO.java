package pageObjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.ConfigReader;
import utils.DriverFactory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Base_PO {

    public Base_PO() {
        PageFactory.initElements(getDriver(), this);
    }

    public WebDriver getDriver() {
        return DriverFactory.getDriver();
    }

    public void navigateTo_URL(String URL) {
        getDriver().get(URL);
    }

    public String generateRandomNumber(int length) {
        return RandomStringUtils.randomNumeric(length);
    }

    public String generateRandomString(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    public void sendKeys(WebElement element, String textToType) {
        WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofSeconds(ConfigReader.DEFAULT_EXPLICIT_TIMEOUT));
        wait1.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(textToType);
    }

    public void waitForWebElementAndClick(WebElement by) {
        WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofSeconds(ConfigReader.DEFAULT_EXPLICIT_TIMEOUT));
        wait1.until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    public void waitForWebElementAndClick(WebElement element, String submitButton) {
        WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofSeconds(ConfigReader.DEFAULT_EXPLICIT_TIMEOUT));
        wait1.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void waitForAlert_And_ValidateText(String text) {
        WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofSeconds(ConfigReader.DEFAULT_EXPLICIT_TIMEOUT));
        wait1.until(ExpectedConditions.alertIsPresent());
        String alert_Message_Text = getDriver().switchTo().alert().getText();
        Assert.assertEquals(alert_Message_Text, text);
    }

    public void waitForSubmissionAndValidateText(WebElement element, String expectedNotice) {
        WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofSeconds(ConfigReader.DEFAULT_EXPLICIT_TIMEOUT));
        String actualNotice = element.getText();
        System.out.println("Actual Text : " + actualNotice);
        Assert.assertEquals(actualNotice, expectedNotice);
    }

    public void waitForSubmission_And_ValidateText(By by) {
        WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofSeconds(ConfigReader.DEFAULT_EXPLICIT_TIMEOUT));
        wait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public void waitForWebelement_Message(WebElement element) {
        WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofSeconds(ConfigReader.DEFAULT_EXPLICIT_TIMEOUT));
        wait1.until(ExpectedConditions.visibilityOf(element));
    }

    //For Home Page Validation
    public void waitForValidation(WebElement element) {
        WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofSeconds(ConfigReader.DEFAULT_EXPLICIT_TIMEOUT));
        wait1.until(ExpectedConditions.visibilityOf(element));

    }

    public void waitForAlertAndAccept() {
        getDriver().switchTo().alert().accept();
    }

    //========Scroll Down=====//

    public void scrollDown(WebElement link) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
        /**
         *  this script must scroll, until link element is visible
         *  once link element visible, it will stop scrolling
         *  arguments[0] = means first webelement after comma (link)
         *  arguments it's an array of webelements after comma
         *  arguments[0] = link web element, it can be any web element
         */
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        js.executeScript("arguments[0].scrollIntoView(true)", link);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //========Switching Window=====//
    public void switchToWindow(String targetTitle) {
        String origin = getDriver().getWindowHandle();
        for (String handle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(handle);
            if (getDriver().getTitle().equals(targetTitle)) {
                return;
            }
        }
        getDriver().switchTo().window(origin);
    }

    //This java method's part switches to the newest window.
    // Also consider maximizing it, because sometimes tests masses up in not maximized windows.
    public void handleNewWindowPage() {
        String winHandleBefore = getDriver().getWindowHandle();
        for (String newURL : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(newURL);
        }
    }

    /**
     * Selects a random value from a dropdown list and returns the selected Web Element
     *
     * @param select
     * @return
     */
    public static WebElement selectRandomTextFromDropdown(WebElement element, Select select) {
        Random random = new Random();
        element.click();
        List<WebElement> weblist = select.getOptions();
        int optionIndex = 1 + random.nextInt(weblist.size() - 1);
        select.selectByIndex(optionIndex);
        return select.getFirstSelectedOption();
    }
    //SELECTION METHODS

    //This method asks for the value of the desired option rather than the option text or an index.
    // It takes a String parameter which is one of the values of Select element and it does not return anything.
    public static void selectByValueFromDropDown(WebElement selectData, String value) {
        Select selectElement = new Select(selectData);
        selectElement.selectByValue(value);
    }

    //This method selects one of the options in a drop-down box or an option among multiple selection boxes.
    //It takes a parameter of String which is one of the values of Select element and it returns nothing.
    public void selectByVisibleTextFromDropDown(WebElement element1, String string) {
        Select selectElement = new Select(element1);
        selectElement.selectByVisibleText(ConfigReader.getProperty("Gender"));

    }

    //SPAN DROPLIST SELECTION
    //If 'select' option is not needed for droplist, we use the method below;
    public void waitForDropListAndSelectOption(WebElement element, WebElement selection) {
        WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofSeconds(ConfigReader.DEFAULT_EXPLICIT_TIMEOUT));
        wait1.until(ExpectedConditions.elementToBeClickable(element)).click();
        wait1.until(ExpectedConditions.elementToBeClickable(selection)).click();
    }

    //   HARD WAIT WITH THREAD.SLEEP
    //   waitFor(5);  => waits for 5 second
    public static void waitFor(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String getScreenshot(String name) throws IOException {
        // naming the screenshot with the current date to avoid duplication
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // TakesScreenshot is an interface of selenium that takes the screenshot
        TakesScreenshot ts = (TakesScreenshot) DriverFactory.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String target = System.getProperty("user.dir") + "/test-output/Screenshots/" + name + date + ".png";
        File finalDestination = new File(target);
        // save the screenshot to the path given
        FileUtils.copyFile(source, finalDestination);
        return target;
    }

    //========Hover Over=====//
    public static void hover(WebElement element) {
        Actions actions = new Actions(DriverFactory.getDriver());
        actions.moveToElement(element).perform();
    }

    //========Returns the Text of the element given an element locator==//
    public static List<String> getElementsText(By locator) {
        List<WebElement> elems = DriverFactory.getDriver().findElements(locator);
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : elems) {
            if (!el.getText().isEmpty()) {
                elemTexts.add(el.getText());
            }
        }
        return elemTexts;
    }
}

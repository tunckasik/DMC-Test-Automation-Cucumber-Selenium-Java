package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utils.ConfigReader;

import java.util.List;

public class Departments_PO extends Base_PO {

    public Departments_PO(){
        super();
    }
    @FindBy(xpath = "(//a[@href='/departments/'][contains(.,'Departments')])[1]")
    public WebElement departmentsLink;

    @FindBy(xpath = "//h3[contains(.,'Our Medical Services')]")
    public WebElement ourMedicalServiceText;

    @FindBy(xpath = "//div[@class='col-xl-4 col-md-6 col-lg-4']")
    public WebElement departmentTable;

    public void navigateToDepartmentsPage() {
        navigateTo_URL(ConfigReader.DEFAULT_WEBSITE_HOMEPAGE);
        waitForWebElementAndClick(departmentsLink);
        waitFor(1);
    }
    public void verifyOurMedicalServicesIsVisible(){
        waitFor(1);
        waitForWebelement_Message(ourMedicalServiceText);
    }
    public void verifyDepartmentsNumber(int expected) {
        List<WebElement> list = getDriver().findElements(By.xpath("//div[@class='col-xl-4 col-md-6 col-lg-4']"));

        System.out.println("Number of Departments is : " + list.size());

        int actual = list.size();
        Assert.assertEquals(actual,expected);
    }
}

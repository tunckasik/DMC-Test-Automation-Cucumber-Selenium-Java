package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.sql.Timestamp;

import static utils.DriverFactory.cleanupDriver;
import static utils.DriverFactory.getDriver;

public class Hooks {
    public WebDriver driver;

    @Before
    public void setup() {
        getDriver();
    }

    @AfterStep
    public void captureExceptionImage(Scenario scenario) {
        if (scenario.isFailed()) {
            Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
            String timeMilleSeconds = Long.toString(timeStamp.getTime());

            byte[] screenshoot = ((TakesScreenshot) getDriver())
                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshoot, "image/png", timeMilleSeconds);
        }
    }

    @After
    public void tearDown() {
        cleanupDriver();
    }

}
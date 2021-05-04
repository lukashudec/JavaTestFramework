package main.utilityClasses.AbstractClasses.BaseTests;

import lombok.Getter;
import main.utilityClasses.utility.resourceMapping;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public abstract class GuiBaseTest extends BaseTest {

    protected static ChromeDriverService service;
    @Getter
    protected WebDriver driver;

    @BeforeSuite
    public static void createAndStartService() throws IOException {
        service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(resourceMapping.pathToChromedriver))
                .usingAnyFreePort()
                .build();
        service.start();
    }

    @AfterSuite
    public static void createAndStopService() {
        service.stop();
    }


    @BeforeTest
    public void createDriver() {
        ChromeOptions options = new ChromeOptions();
        options.setBinary(resourceMapping.pathToChrome);
        driver = new RemoteWebDriver(service.getUrl(),
                new ChromeOptions());
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @AfterTest
    public void quitDriver() {
        driver.quit();
    }

   /* @AfterMethod
    public void checkResult(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            ExtentTestManager.getTest()
                    .fail(MediaEntityBuilder.createScreenCaptureFromBase64String(CaptureScreen()).build());
        }
    }

    public String CaptureScreen() {
        return "data:image/jpg;base64, " + ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
    }*/
}

package main.utilityClasses.reporting;

import com.aventstack.extentreports.MediaEntityBuilder;
import main.utilityClasses.AbstractClasses.BaseTests.GuiBaseTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class testListener implements ITestListener {

    public void onFinish(ITestContext context) {
        ExtentTestManager.endTest();
        ExtentManager.getInstance().flush();
    }

    public void onTestStart(ITestResult result) {
        ExtentTestManager.startTest(result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {
        ExtentTestManager.getTest().pass("Test passed");
    }

    public void onTestFailure(ITestResult result) {
        try {
            WebDriver driver = ((GuiBaseTest) result.getInstance()).getDriver();
            //ExtentReports log and screenshot operations for failed tests.
            ExtentTestManager.getTest().fail("Test Failed",
                    MediaEntityBuilder.createScreenCaptureFromBase64String(CaptureScreen(driver)).build())
                    .fail(result.getThrowable());
        } catch (ClassCastException e) {
            ExtentTestManager.getTest().fail("Test Failed")
                    .fail(result.getThrowable());
        }

    }

    public void onTestSkipped(ITestResult result) {
        ExtentTestManager.getTest().skip("Test Skipped");
    }

    public String CaptureScreen(WebDriver driver) {
        return "data:image/jpg;base64, " + ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
    }
}
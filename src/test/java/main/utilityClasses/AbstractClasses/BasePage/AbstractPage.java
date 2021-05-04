package main.utilityClasses.AbstractClasses.BasePage;

import com.aventstack.extentreports.ExtentTest;
import main.utilityClasses.AbstractClasses.BaseTestObject.BaseTestObject;
import main.utilityClasses.reporting.ExtentTestManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class AbstractPage extends BaseTestObject {
    protected final WebDriver driver;
    protected final ExtentTest extentTest;


    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        extentTest = ExtentTestManager.getTest();
        PageFactory.initElements(driver, this);
    }

    public WebElement findElement(By element) {
        return driver.findElement(element);
    }

    public List<WebElement> findElements(By element) {
        return driver.findElements(element);
    }

}

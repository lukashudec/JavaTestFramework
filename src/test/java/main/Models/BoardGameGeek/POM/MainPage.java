package main.Models.BoardGameGeek.POM;

import main.utilityClasses.AbstractClasses.BasePage.AbstractPage;
import main.utilityClasses.AbstractClasses.Interfaces.Loggable;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainPage extends AbstractPage {

    @FindBy(name = "searchTerm")
    protected WebElement search_bar;
    @FindBy(linkText = "Sign In")
    protected WebElement signInButton;
    @FindBy(xpath = "//button[contains(.,'Help ')]")
    protected WebElement helpDropdown;
    @FindBy(linkText = "FAQ")
    protected WebElement faqButton;
    protected String root = "https://www.boardgamegeek.com/";

    public MainPage(WebDriver driver) {
        super(driver);
    }


    public MainPage visit() {
        Loggable.staticStep("Open main page");
        driver.get(root);
        return this;
    }

    public MainPage clickOnHelp() {
        Loggable.staticStep("Click on Help button");
        helpDropdown.click();
        return this;
    }


    public FaqPage clickOnFaq() {
        Loggable.staticStep("Click on Faq button");
        faqButton.click();
        return new FaqPage(driver);
    }


    public SignInPage clickOnSignIn() {
        Loggable.staticStep("Click on Sign In button");
        signInButton.click();
        return new SignInPage(driver);
    }


    public GeekSearchResultPage searchGames(String input) {
        Loggable.staticStep("Search for game " + input);
        search_bar.sendKeys(input + Keys.ENTER);
        return new GeekSearchResultPage(driver);
    }

    public MainPage performVisualCheck() {
        // not implemented
        Loggable.staticStep("Perform visual check");
        return this;
    }
}

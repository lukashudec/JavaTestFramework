package main.Models.BoardGameGeek.POM;

import main.utilityClasses.AbstractClasses.BasePage.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SignInPage extends AbstractPage {

    @FindBy(xpath = "//form[@name='loginform']")
    protected WebElement loginForm;
    @FindBy(id = "inputUsername")
    protected WebElement username;
    @FindBy(id = "inputPassword")
    protected WebElement password;
    @FindBy(xpath = "//button[contains(.,'Sign In')]")
    protected WebElement signInButton;
    @FindBy(xpath = "//span[contains(.,'Invalid username or password')]")
    protected WebElement invalidUsernameMessage;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public MainPage signIn(String username, String password) {
        Step("Click on Sign in");
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.signInButton.click();

        Step("Verify sign in");
        assertFalse(invalidUsernameMessage.isDisplayed(), "Invalid username or password");
        return new MainPage(driver);
    }

    public SignInPage isFormDisplayed() {
        Step("Check if form is displayed");

        assertTrue(loginForm.isDisplayed());
        return this;
    }

    public SignInPage isUsernameDisplayed() {
        Step("Check if username is displayed");
        assertTrue(username.isDisplayed());
        return this;
    }

    public SignInPage isPasswordDisplayed() {
        Step("Check if password is displayed");
        assertTrue(password.isDisplayed());
        return this;
    }

}

package main.Models.BoardGameGeek.POM;

import main.utilityClasses.AbstractClasses.BasePage.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class GeekSearchResultPage extends AbstractPage {

    public GeekSearchResultPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getGameLink(String input) {
        return findElements(By.linkText(input));
    }

    public List<WebElement> getGameImage(String input) {
        return findElements(By.xpath("//img[@alt='Board Game: " + input + "']"));
    }

    public GeekSearchResultPage isGameLinkFound(String input) {
        Step("Check if game link is present");
        assertNotEquals(0, getGameLink(input).size());
        return this;
    }

    public GeekSearchResultPage isGameImageFound(String input) {
        Step("Check if game image is present");
        assertNotEquals(0, getGameImage(input).size());
        return this;
    }
}

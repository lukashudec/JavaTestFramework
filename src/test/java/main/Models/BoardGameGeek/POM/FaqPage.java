package main.Models.BoardGameGeek.POM;

import main.utilityClasses.AbstractClasses.BasePage.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FaqPage extends AbstractPage {

    @FindBy(id = "wiki-search")
    protected WebElement helpSearch;
    @FindBy(name = "B1")
    protected WebElement helpSearchButton;
    @FindBy(xpath = "//table[@class='forum_table']")
    protected WebElement forumTable;
    @FindBy(xpath = "//a[@href='/wiki/page/BoardGameGeek_FAQ']")
    protected WebElement faqArticle;

    protected String root = "https://www.boardgamegeek.com/wiki/page/BoardGameGeek_FAQ";

    public FaqPage(WebDriver driver) {
        super(driver);
    }

    public FaqPage visit() {
        extentTest.info("Open FAQ page");
        driver.get(root);
        return this;
    }

    public FaqPage search(String input) {
        extentTest.info("Search FAQ page for " + input);
        helpSearch.sendKeys(input + Keys.ENTER);
        return this;
    }

    public WebElement checkResultTable(String searchResult) {
        Step("Check result table");
        return findElement(By.xpath("//a[@href='/wiki/page/" + searchResult + "']"));
    }

    public FaqPage isSearchDisplayed() {
        Step("Check if search is displayed");
        assertTrue(helpSearch.isDisplayed());
        return this;
    }

    public FaqPage isArticleDisplayed() {
        Step("Check if article is displayed");
        assertNotNull(faqArticle);
        return this;
    }

    public FaqPage isResultFound(String searchResult) {
        Step("Check if proper search result for " + searchResult + " is present");
        assertNotNull(checkResultTable(searchResult));
        return this;
    }

}

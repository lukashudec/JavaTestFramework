package main.TestRunners;

import main.Models.BoardGameGeek.POM.FaqPage;
import main.Models.BoardGameGeek.POM.MainPage;
import main.utilityClasses.AbstractClasses.BaseTests.GuiBaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/*
Prepare a test framework that will automate any process that could be important from your perspective.
        Choose one of your favorite website to prepare some interesting and automated test cases, example:
        1. Automate search process on store platform, flight tickets,
        2. Automate notification on stock market, weather anomaly,
        3. Automate daily tasks that could speed up your work.
        It’s an open task so feel free to deliver an interesting solution that does matter. What is important for us:
        1. Use Java or JavaScript as programing language,
        2. Use build automation tool (maven, gradle, ant),
        3. Use testing platform (JUnit, TestNg),
        4. Prepare report from tests,
        5. Make your framework platform independent,
        6. Don’t forget about documentation that describe briefly problem, framework, solution or steps
        to properly use your project
*/

public class BoardGameGeekWebTest extends GuiBaseTest {

    @DataProvider(name = "loginData")
    public static Object[][] loginDataProvider() {
        return new Object[][]{{"name", "pass"}, {"", ""}, {"02154", "02154"}};
    }

    @Test
    void testGameSearch() {
/*  Given I am on the home page
    When I enter search term: Prophecy
    Then Search results for link: Prophecy should appear
    And Search results for image: Prophecy should appear */
        new MainPage(driver).visit()
                .searchGames("Prophecy")
                .isGameImageFound("Prophecy")
                .isGameLinkFound("Prophecy");
    }

    @Test(dataProvider = "loginData")
    void testSignIn(String name, String password) {
/*  Given I am on the main page
    When I click on Sign in button
    Then popup is shown
    And it contains field username
    And it contains field password
    When I enter name and pass */
        new MainPage(driver).visit()
                .clickOnSignIn()
                .isFormDisplayed()
                .isPasswordDisplayed()
                .isUsernameDisplayed()
                .signIn(name, password);
    }

    @Test
    void testHelpSearch() {
/*  Given I am on the FAQ page
    Then search box is present
    And BoardGameGeek FAQ article is present
    When I search for API
    Then List of results with BGG_XML_API2 is shown */
        new FaqPage(driver).visit()
                .isSearchDisplayed()
                .isArticleDisplayed()
                .search("API")
                .isResultFound("BGG_XML_API2");
    }
}

# Project Description

## Task 1: REST API

    Using open API execute commands:
    1. Data structure creation:
       a. Create POJO class 'Comment' that will represent the response form /comments
       endpoint,
       b. Send request to get comments and deserialize response into the collection of objects
       'Comment'.
    2. Send request GET on /comments endpoint and assert:
       a. response code,
       b. number of comments is greater than 0,
       c. response body has a comment with any of existing emails e.g.
       Jayne_Kuhic@sydney.com.
    3. Filter the collection from point 1 using given condition:
       a. remove all comments from the collection that has postId different than 1,
       b. remove all comments that do not contain the word "non" in the body.

    Solution:
        Fluent API Object model + POJO :
            src/test/java/main/models/Typicode/AOM/
        Test : 
            src/test/java/main/TestRunners/TypicodeCommentsTest/
        Tools/ Dependencies :
            com.fasterxml.jackson.core - used for databind
            io.rest-assured - used for API calls

## Task 2: E2E Automation

    Prepare a test framework that will automate any process that could be important from your perspective.
    Choose one of your favorite website to prepare some interesting and automated test cases, example:
    1. Automate search process on store platform, flight tickets,

    Solution:
        Fluent Page Object model :
            src/test/java/main/models/BoardGameGeek/POM/
        Test : 
            src/test/java/main/TestRunners/BoardGameGeekWebTest/
        Tools/ Dependencies :
            org.seleniumhq.selenium - Webdriver, WebBrowser controll

## Requirements

    1. Java / JavaScript
    2. Maven /gradle / ant
    3. JUnit / TestNg
    4. Reporting
    5. Platform independent,
    6. Documentation that describe briefly problem, framework, solution or steps
       to properly use your project

    Solution: 
        Tech : Java + Maven + TestNg
        Assertion : JUnit
        Report : extentReports

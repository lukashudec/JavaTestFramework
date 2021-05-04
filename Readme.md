# TakeHomeTest

Before running please set up proper paths in src/test/java/resources

* DriverPath - path to chromeDriver
* ChromePath - path to chrome executable ( Different Chrome version are installed in different locations )

Run options

* Directly from IDE
    * Run TestNq.xml
    * Run class from src/test/java/main/TestRunners
* Maven
    * mvn clean test -DsuiteXmlFile=testng.xml -Dmaven.test.failure.ignore=true

I already had most of the task done in https://github.com/lukashudec/JavaProject

## Project description

### Task 1: REST API

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

### Task 2: E2E Automation

    Prepare a test framework that will automate any process that could be important from your perspective.
    Choose one of your favorite website to prepare some interesting and automated test cases, example:
    1. Automate search process on store platform, flight tickets,
    2. Automate notification on stock market, weather anomaly,
    3. Automate daily tasks that could speed up your work.

    Solution:
        Fluent Page Object model :
            src/test/java/main/models/BoardGameGeek/POM/
        Test : 
            src/test/java/main/TestRunners/BoardGameGeekWebTest/
        Tools/ Dependencies :
            org.seleniumhq.selenium - Webdriver, WebBrowser controll

### Requirements

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
        Platform independent : Hopefully, but cant say for sure
                               ChromeDriver is for win32 and chrome v90, proper Platform independance would need more config  
        Documentation : Readme.md :)

## src/test/java/main/..

### Model

    Page Object Models , API Object Models, Classes for deserialization 

### TestRunners

    Test runners / Test cases / Test collection

### utilityClasses

    Small utility classes (f.e. reporting ) 
    Base / Abstract Classes

## src/test/java/testSuites

    Prepared test suite, from 2 TestRunners. Running in parallel ( 2 threads )

# Possible improvements

    1. Adding AspectJ for custom annotations ( instead of using interface Step / Measurable ) ( had some problems with getting stable results )
    2. Improved reporting ( would be solved with 1. ) 
    3. API Object Model is not polished , maybe different approach would be better 
    4. Add custom JavaScript operation ( f.e. marking used fields on page for better reporting / bug tracking )
    5. Add page visual verification ( compare screenshot to template ) 
    6. Add appium / locust / security testing support
    7. Add support for Selenium Grid
    8. Add cucumber support 
    and many more :) 
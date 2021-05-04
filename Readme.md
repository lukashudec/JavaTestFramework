# JavaTestFramework

## run
    Before running please set up proper paths in src/test/java/resources
    
    * DriverPath - path to chromeDriver
    * ChromePath - path to chrome executable ( Different Chrome version are installed in different locations )
    
    Run options
    
    * Directly from IDE
        * Run TestNq.xml
        * Run class from src/test/java/main/TestRunners
    * Maven
        * mvn clean test -DsuiteXmlFile=testng.xml -Dmaven.test.failure.ignore=true
  
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
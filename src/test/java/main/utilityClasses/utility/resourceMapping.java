package main.utilityClasses.utility;

public class resourceMapping {
    // Base
    public static final String fileSeparator = System.getProperty("file.separator");
    public static final String root = System.getProperty("user.dir");
    public static final String time = "" + System.currentTimeMillis() / 1000L;

    // Base settings
    // not implemented
    public static final Boolean reportsEnabled = true;

    // Chrome Settings
    public static final String pathToChromedriver = root + fileSeparator + "/ChromeDriver/chromedriver_w32_90.exe";
    public static final String pathToChrome = "C:/Program Files/Google/Chrome/Application/chrome.exe";

    // Reporter Settings
    public static final String reportFileName = "Test-Automaton-Report-" + time + ".html";
    public static final String reportFilepath = root + fileSeparator + "TestReport";
    public static final String reportFileLocation = reportFilepath + fileSeparator + reportFileName;
}

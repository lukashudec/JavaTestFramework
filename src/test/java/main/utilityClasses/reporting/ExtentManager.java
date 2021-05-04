package main.utilityClasses.reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import main.utilityClasses.utility.resourceMapping;

import java.io.File;

public class ExtentManager {
    private static final String reportFileName = resourceMapping.reportFileName;
    private static final String reportFilepath = resourceMapping.reportFilepath;
    private static final String reportFileLocation = resourceMapping.reportFileLocation;
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null)
            createInstance();
        return extent;
    }

    //Create an extent report instance
    private static void createInstance() {
        String fileName = getReportPath(reportFilepath);

        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(fileName);
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setDocumentTitle(reportFileName);
        sparkReporter.config().setEncoding("utf-8");
        sparkReporter.config().setReportName(reportFileName);
        sparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    //Create the report path
    private static String getReportPath(String path) {
        File testDirectory = new File(path);
        if (!testDirectory.exists()) {
            if (testDirectory.mkdir()) {
                return reportFileLocation;
            } else {
                return System.getProperty("user.dir");
            }
        }
        return reportFileLocation;
    }

}

package main.utilityClasses.AbstractClasses.Interfaces;

import com.aventstack.extentreports.Status;
import main.utilityClasses.reporting.ExtentTestManager;

// temporary interface, should be switched for Annotation + Aspect
public interface Loggable {

    static void staticStep(String message) {
        ExtentTestManager.getTest().pass(message);
    }

    default void Step(String message) {
        ExtentTestManager.getTest().pass(message);
    }

    default void log(Status status, String message) {
        ExtentTestManager.getTest().log(status, message);
    }
}

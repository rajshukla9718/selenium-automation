package test;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener {

    public void onTestStart(ITestResult result) {
        System.out.println("Test Exection started");
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Case Passed");
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("Test Case Failed");
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Case Skipped");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    public void onTestFailedWithTimeout(ITestResult result) {
        this.onTestFailure(result);
    }

    public void onStart(ITestContext context) {
        System.out.println("Exection Started");
    }

    public void onFinish(ITestContext context) {
        System.out.println("Exection Completed");
    }


}

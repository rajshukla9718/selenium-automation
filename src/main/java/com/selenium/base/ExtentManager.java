package com.selenium.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentManager implements ITestListener {

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    // ✅ Call this in @BeforeSuite from BaseClass
    public static void initExtent() {
        if (extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter("target/ExtentReport.html");
            extent = new ExtentReports();
            extent.attachReporter(spark);
            System.out.println("[ExtentManager] ExtentReports initialized.");
        }
    }

    // ✅ Call this in @AfterSuite from BaseClass
    public static void flushExtent() {
        if (extent != null) {
            extent.flush();
            System.out.println("[ExtentManager] ExtentReports flushed.");
        }
    }

    // ✅ Access current test instance
    public static synchronized ExtentTest getTest() {
        return test.get();
    }

    @Override
    public synchronized void onTestStart(ITestResult result) {
        if (extent == null) {
            System.err.println("[ExtentManager] ERROR: ExtentReports not initialized! Call initExtent() before tests start.");
            return;
        }

        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
        extentTest.log(Status.INFO, "Test started: " + result.getMethod().getMethodName());
    }

    @Override
    public synchronized void onTestSuccess(ITestResult result) {
        if (getTest() != null) {
            getTest().log(Status.PASS, "Test Passed");
        }
    }

    @Override
    public synchronized void onTestFailure(ITestResult result) {
        if (getTest() != null) {
            getTest().log(Status.FAIL, "Test Failed");
            getTest().log(Status.FAIL, result.getThrowable());
        } else if (extent != null) {
            ExtentTest fallbackTest = extent.createTest(result.getMethod().getMethodName());
            fallbackTest.log(Status.FAIL, "Test Failed (ExtentTest was null)");
            fallbackTest.log(Status.FAIL, result.getThrowable());
        }
    }

    @Override
    public synchronized void onTestSkipped(ITestResult result) {
        if (getTest() != null) {
            getTest().log(Status.SKIP, "Test Skipped");
        } else if (extent != null) {
            ExtentTest skippedTest = extent.createTest(result.getMethod().getMethodName());
            skippedTest.log(Status.SKIP, "Test Skipped (ExtentTest was null)");
        }
    }

    @Override
    public void onStart(ITestContext context) {
        // Optional: you can add suite/test info here if needed
    }

    @Override
    public void onFinish(ITestContext context) {
        // Nothing to do here — flush happens in @AfterSuite via BaseClass
    }
}

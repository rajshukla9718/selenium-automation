package com.selenium.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class BaseClass {
    public static WebDriver driver;
    protected static final Logger log = LogManager.getLogger(BaseClass.class);

    @BeforeSuite
    public void initializeExtent() {
        ExtentManager.initExtent();  // Initialize ExtentReports
        log.info("ExtentReports initialized");
    }

    @BeforeMethod
    public void setUp(Method method) {
        // Set per-test log file name for Routing appender
        ThreadContext.put("testName", method.getName());

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        log.info("Launching Chrome browser");
        driver.get("https://www.automationexercise.com/");
        log.info("Navigated to AutomationExercise");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            log.info("Browser closed");
        }
        ThreadContext.clearAll();
    }

    @AfterSuite
    public void flushExtent() {
        ExtentManager.flushExtent();  // Flush ExtentReports
        log.info("ExtentReports flushed");
    }
}

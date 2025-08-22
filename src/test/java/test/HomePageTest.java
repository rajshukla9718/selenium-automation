package test;

import com.selenium.actions.ActionHelper;
import com.selenium.base.BaseClass;
import com.selenium.pageobjects.HomePage;
import com.selenium.pageobjects.RegisterPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends BaseClass {

    private static final Logger log = LogManager.getLogger(HomePageTest.class);
    private HomePage hp;
    private RegisterPage rp;
    private ActionHelper ah;

    @BeforeMethod
    public void setupPageObjects() {
        // Instantiate page objects before each test
        hp = new HomePage(driver);
        rp = new RegisterPage(driver);
        ah = new ActionHelper(driver);
        log.info("Page objects initialized");
    }

    @Test
    public void navigateToRegisterPage() throws InterruptedException {
        log.info("===== Starting navigateToRegisterPage Test =====");

        hp.clickSignUpLoginButton();
        log.info("Clicked on Sign Up / Login button");

        Thread.sleep(3000); // ⚠️ Replace with proper explicit wait later
        log.debug("Waited 3 seconds for Sign Up page to load");

        rp.validateSignUpPage("New User Signup!");
        log.info("Verified Sign Up page header");

        rp.setName("TestName4567754");
        log.debug("Entered Name: TestName4567754");

        rp.setSignUpEmail("test65456@gmail.com");
        log.debug("Entered Email: test65456@gmail.com");

        rp.clkSignUpBtn();
        log.info("Clicked Sign Up button");

        log.info("===== navigateToRegisterPage Test Completed =====");
    }

    @Test
    public void ClickcontactUsPageTest() {
        log.info("===== Starting contactUsPageTest =====");

        hp.getContactUsMenuBtn().click();
        log.info("Clicked on Contact Us menu button");

        log.info("===== contactUsPageTest Completed =====");
    }

    @Test
    public void verifyPageTitle(){
        log.info("=========Started Verify Page Title===========");
        String pageTitle = hp.getPageTitle();
        log.info("========Verifying Page Title=========");
        Assert.assertEquals(pageTitle, "Automation Exercise");

    }
}

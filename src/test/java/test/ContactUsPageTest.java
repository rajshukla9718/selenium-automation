package test;

import com.selenium.base.BaseClass;
import com.selenium.pageobjects.HomePage;
import com.selenium.pageobjects.ContactUsPage;
import com.selenium.actions.ActionHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactUsPageTest extends BaseClass {

    private static final Logger log = LogManager.getLogger(ContactUsPageTest.class);

    private HomePage hp;
    private ContactUsPage cp;
    private ActionHelper ah;

    @BeforeMethod
    public void setupPageObjects() {
        hp = new HomePage(driver);
        cp = new ContactUsPage(driver);
        ah = new ActionHelper(driver);
        log.info("Page objects initialized");
    }

    @Test
    public void contactUsPageTest() {
        log.info("===== Starting Contact Us Page Test =====");

        hp.getContactUsMenuBtn().click();
        log.info("Clicked on Contact Us menu button");

        Assert.assertEquals(cp.getContactUsPageTxt().getText(), "GET IN TOUCH");
        log.info("Verified Contact Us page header");

        ah.sendKeys(cp.getName(), "Test");
        log.debug("Entered Name: Test");

        ah.sendKeys(cp.getEmail(), "test@gmail.com");
        log.debug("Entered Email: test@gmail.com");

        ah.sendKeys(cp.getSubject(), "This is a subject");
        log.debug("Entered Subject");

        ah.sendKeys(cp.getMessage(), "This is a random message hehe");
        log.debug("Entered Message");

        ah.click(cp.getSubmitBtn());
        log.info("Clicked Submit button");

        driver.switchTo().alert().accept();
        log.info("Accepted success alert");

        Assert.assertEquals(cp.getSuccessTxt().getText(),
                "Success! Your details have been submitted successfully.");
        log.info("Verified success message");

        hp.getHomeBtn().click();
        Assert.assertEquals(driver.getTitle(), "Automation Exercise");
        log.info("Verified Home page title");

        log.info("===== Contact Us Page Test Completed Successfully =====");
    }
}

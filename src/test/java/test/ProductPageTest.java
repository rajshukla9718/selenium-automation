package test;

import com.selenium.base.BaseClass;
import com.selenium.pageobjects.HomePage;
import com.selenium.pageobjects.ProductPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductPageTest extends BaseClass {

    private HomePage hp;
    private ProductPage pp;

    @BeforeMethod
    public void setupPageObjects() {
        // Instantiate the HomePage object once before each test
        hp = new HomePage(driver);
        pp = new ProductPage(driver);
    }

    @Test
    public void addProduct() throws InterruptedException {
        hp.clickProduct();
        Thread.sleep(3000);
        pp.addStylishDress();
        Thread.sleep(3000);
        pp.openCart();
        Thread.sleep(3000);
        pp.verifyProduct();
    }




}

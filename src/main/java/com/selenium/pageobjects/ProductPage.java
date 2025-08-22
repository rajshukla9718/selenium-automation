package com.selenium.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProductPage {

    private WebDriver driver;
    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id=\"search_product\"]")
    WebElement searchProduct;

    @FindBy(xpath = "//button[@id=\"submit_search\"]")
    WebElement searchBtn;

    @FindBy(xpath = "//div[@class='productinfo text-center']//p[text()='Stylish Dress']/following-sibling::a")
    WebElement stylishDress;

    @FindBy(xpath = "//u[text()=\"View Cart\"]")
    WebElement viewCart;

    @FindBy(xpath = "//a[text()=\"Stylish Dress\"]")
    WebElement sd_Text;


    public void addStylishDress(){
        stylishDress.click();
    }

    public void openCart(){
        viewCart.click();
    }

    public void verifyProduct(){
        Assert.assertEquals(sd_Text.getText(), "Stylish Dress");
    }





}

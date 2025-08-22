package com.selenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    private WebDriver driver;

    @FindBy(xpath = "//a[text()=' Signup / Login']")
    private WebElement signUpBtn;

    @FindBy(xpath = "//a[text()=' Products\']")
    WebElement productBtn;

    @FindBy(xpath = "//header[@id=\"header\"]//ul//li//a")
    WebElement  menuButton;

    @FindBy(xpath = "//a[text()=' Contact us\']")
    WebElement contactUsMenuBtn;

    @FindBy(xpath = "//a[text()=' Home\']")
    WebElement homeBtn;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickSignUpLoginButton() {
        signUpBtn.click();
    }

    public void clickProduct(){
        productBtn.click();
    }

    public List<WebElement> getMenuTxt(){
        return driver.findElements(By.xpath(String.valueOf(menuButton)));
    }

    public WebElement getContactUsMenuBtn(){
        return contactUsMenuBtn;
    }

    public WebElement getHomeBtn() {
        return homeBtn;
    }
}
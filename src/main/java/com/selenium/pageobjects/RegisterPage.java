package com.selenium.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RegisterPage {

    private WebDriver driver;

    @FindBy(xpath = "//h2[text()='New User Signup!\']")
    WebElement signUpText;

    @FindBy(xpath = "//input[@placeholder=\"Name\"]")
    WebElement nameLoc;

    @FindBy(xpath = "//form[@action=\"/signup\"]//input[@placeholder=\"Email Address\"]")
    WebElement signUpEmail;

    @FindBy(xpath = "//button[text()='Signup']")
    WebElement signUpBtn;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void validateSignUpPage(String expected){
        String signUptxt = signUpText.getText();
        Assert.assertEquals(signUptxt, expected);
    }

    public void setName(String name){
        nameLoc.sendKeys(name);
    }

    public void setSignUpEmail(String email){
        signUpEmail.sendKeys(email);
    }

    public void clkSignUpBtn(){
        signUpBtn.click();
    }
}

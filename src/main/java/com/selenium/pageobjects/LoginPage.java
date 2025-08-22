package com.selenium.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    private WebDriver driver;

    @FindBy(xpath = "//h2[text()='Login to your account'")
    WebElement loginText;

    @FindBy(xpath = "//form[@action=\"/login\"]//input[@placeholder=\"Email Address\"]")
    WebElement loginEmail;

    @FindBy(xpath = "//input[@placeholder=\"Password\"]")
    WebElement loginPassword;

    @FindBy(xpath = "//button[text()='Login'")
    WebElement loginbtn;


    public void setLoginEmail(String email){
        loginEmail.sendKeys(email);
    }

    public void setLoginPassword(String password){
        loginPassword.sendKeys(password);
    }

    public void clkLoginButton(){
        loginbtn.click();
    }


}

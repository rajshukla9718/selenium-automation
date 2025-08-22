package com.selenium.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.print.attribute.standard.MediaSize;

public class ContactUsPage {

    private WebDriver driver;

    public ContactUsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//h2[text()=\"Get In Touch\"]")
    WebElement contactUsPageTxt;

    @FindBy(xpath = "//input[@placeholder=\"Name\"]")
    WebElement Name;

    @FindBy(xpath = "//input[@placeholder=\"Email\"]")
    WebElement email;

    @FindBy(xpath = "//input[@placeholder=\"Subject\"]")
    WebElement subject;

    @FindBy(xpath = "//textarea[@placeholder=\"Your Message Here\"]")
    WebElement message;

    @FindBy(xpath = "//input[@name=\"submit\"]")
    WebElement submitBtn;

    @FindBy(xpath = "//div[contains(@class, \"status\")]")
    WebElement successTxt;

    public WebElement getName(){
        return Name;
    }

    public WebElement getContactUsPageTxt(){
        return contactUsPageTxt;
    }

    public WebElement getEmail(){
        return email;
    }

    public WebElement getSubject(){
        return subject;
    }

    public WebElement getMessage(){
        return message;
    }

    public WebElement getSubmitBtn(){
        return  submitBtn;
    }

    public WebElement getSuccessTxt(){
        return successTxt;
    }



}

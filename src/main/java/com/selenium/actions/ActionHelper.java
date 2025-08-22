package com.selenium.actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class ActionHelper {

    private WebDriver driver;
    private Actions actions;

    public ActionHelper(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    // Mouse Actions
    public void click(WebElement element) {
        actions.click(element).perform();
    }

    public void doubleClick(WebElement element) {
        actions.doubleClick(element).perform();
    }

    public void rightClick(WebElement element) {
        actions.contextClick(element).perform();
    }

    public void hoverOverElement(WebElement element) {
        actions.moveToElement(element).perform();
    }

    public void dragAndDrop(WebElement source, WebElement target) {
        actions.dragAndDrop(source, target).perform();
    }

    // Keyboard Actions
    public void sendKeys(WebElement element, String text) {
        actions.sendKeys(element, text).perform();
    }

    public void pressEnterKey(WebElement element) {
        actions.sendKeys(element, Keys.ENTER).perform();
    }

    public void copyAndPaste(WebElement source, WebElement target) {
        actions.click(source)
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .sendKeys("c")
                .keyUp(Keys.CONTROL)
                .click(target)
                .keyDown(Keys.CONTROL)
                .sendKeys("v")
                .keyUp(Keys.CONTROL)
                .build()
                .perform();

    }
}
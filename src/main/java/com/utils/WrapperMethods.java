package com.utils;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.driver.DriverFactory;

import jdk.internal.org.jline.utils.Log;

public class WrapperMethods {

    WebDriver driver;
    WebDriverWait wait;

    public WrapperMethods() {
        this.driver = DriverFactory.getDriver();
        this.wait= new WebDriverWait(driver,Duration.ofSeconds(10));
    }

    // Generic click method
    public void click(WebElement element) {
    	Log.info("Clicking element: " + element);
    	wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        Log.info("Click successful");
    }

    // Generic send keys method
    public void type(WebElement element, String value) {
    	Log.info("Send element: " + element);
    	wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(value);
        Log.info("SendElement successful");
    }

    // Generic get text method
    public String getText(WebElement element) {
    	Log.info("getText: " + element);
    	wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }
}

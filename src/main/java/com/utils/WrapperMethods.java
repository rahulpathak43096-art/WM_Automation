package com.utils;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.driver.DriverFactory;

public class WrapperMethods {

    WebDriver driver;
    WebDriverWait wait;

    public WrapperMethods() {
        this.driver = DriverFactory.getDriver();
        this.wait= new WebDriverWait(driver,Duration.ofSeconds(10));
    }

    // Generic click method
    public void click(WebElement element) {
    	wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    // Generic send keys method
    public void type(WebElement element, String value) {
    	wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(value);
    }

    // Generic get text method
    public String getText(WebElement element) {
    	wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }
}

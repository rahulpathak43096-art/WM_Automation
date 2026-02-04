package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utils.WrapperMethods;

public class SecurePage {

    WebDriver driver;
    WrapperMethods wrapper;
    @FindBy(id = "flash")
    WebElement successMessage;

    public SecurePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wrapper = new WrapperMethods(driver);
    }

    // Returns login success message
    public String getSuccessMessage() {

        String fullText = wrapper.getText(successMessage);

        String actualMessage = fullText.split("\n")[0];

        return actualMessage.trim();
    }
}

package com.pages;

import org.openqa.selenium.WebDriver;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

import com.driver.DriverFactory;
import com.utils.ScreenshotUtils;
import com.utils.WrapperMethods;

public class LoginPage {

    WebDriver driver;
    WrapperMethods wrapper;
    
    @FindBy(id = "username")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(css = "button[type='submit']")
    WebElement loginBtn;

    public LoginPage() {
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
        wrapper = new WrapperMethods();
    }


    // Performs login operation
    public void login(String user, String pass) {
        //capture Screenshot after login click
        ScreenshotUtils.captureScreenshot("LoginPage");
        
        wrapper.type(username, user);
        wrapper.type(password, pass);
        wrapper.click(loginBtn);

    }
}

package com.pages;

import org.openqa.selenium.WebDriver;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

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

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wrapper = new WrapperMethods(driver);
    }


    // Performs login operation
    public void login(String user, String pass) {
        wrapper.type(username, user);
        wrapper.type(password, pass);
        wrapper.click(loginBtn);
    }
}

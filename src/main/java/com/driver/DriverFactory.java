package com.driver;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    // Creates and return WebDriver
    public static WebDriver initDriver(String browser) {
    	WebDriver driver;
    	if(browser == null) {
    		throw new RuntimeException("Browser value is NULL. Check config.properties");
    	}
        switch (browser.toLowerCase()) {
        
        case "chrome":
        	WebDriverManager.chromedriver().setup();
        	driver = new ChromeDriver();
        	break;
        
        case "firefox":
        	WebDriverManager.firefoxdriver().setup();
        	driver = new FirefoxDriver();
        	break;
        	
        case "edge":
        	System.setProperty("webdriver.edge.driver", "C:\\SeleniumFramework\\EdgeDriver\\msedgedriver.exe");
        	driver = new EdgeDriver();
        	break;
        	
        default:
        	throw new RuntimeException("Invalid browser name in config.properties: " + browser);
        	      	
        }
        driver.manage().window().maximize();
        return driver;
    }
}

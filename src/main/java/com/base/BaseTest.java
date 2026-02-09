package com.base;

import org.openqa.selenium.WebDriver;




import org.testng.annotations.*;

import com.driver.DriverFactory;
import com.utils.PropertyUtils;



public class BaseTest {

    protected WebDriver driver;

    // Launch browser and open application
    @BeforeMethod
   
    public void setup() {

    	
    	//priority 1-> Maven parameter in Command prompt
    	
    	String browser = System.getProperty("browser");
  
    	
    	//Priority 2-> config.properties
    	if(browser==null || browser.isEmpty()) {
    		browser=PropertyUtils.getProperty("browser");
    	}
    	if(browser==null || browser.isEmpty()) {
    		throw new RuntimeException("Browser not provided. pass via mvn or config.properties");
    	}
        DriverFactory.initDriver(browser);
        DriverFactory.getDriver().get(PropertyUtils.getProperty("baseUrl"));
    }

    // Close browser
    @AfterMethod
    public void tearDown() {
    	DriverFactory.quitDriver();
    }
}

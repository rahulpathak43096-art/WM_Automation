package com.base;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;




import org.testng.annotations.*;

import com.driver.DriverFactory;
import com.utils.LoggerUtils;
import com.utils.PropertyUtils;



public class BaseTest {

    protected WebDriver driver;
    
    Logger log = LoggerUtils.getLogger(BaseTest.class);

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
    	log.info("Launching browser: " + browser); 
        DriverFactory.initDriver(browser);
        String url =PropertyUtils.getProperty("baseUrl");
        DriverFactory.getDriver().get(url);
        log.info("Navigated to URL: " + url);
    }

    // Close browser
    @AfterMethod
    public void tearDown() {
    	log.info("Closing browser");
    	DriverFactory.quitDriver();
    }
}

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
        String browser = PropertyUtils.getProperty("browser");
        driver = DriverFactory.initDriver(browser);
        driver.get(PropertyUtils.getProperty("baseUrl"));
    }

    // Close browser
    @AfterMethod
    public void tearDown() {
    	if(driver != null) {
    		driver.quit();
    	}
    }
}

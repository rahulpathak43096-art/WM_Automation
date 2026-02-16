package com.driver;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.utils.LoggerUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    // Creates ThreadLocal for parallel execution
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	//private constructor -> Singleton
	
	private DriverFactory() {}
	
	//Initialize driver
 
    public static void initDriver(String browser) {
    	
    	Logger log = LoggerUtils.getLogger(DriverFactory.class);
    	
    	log.info("initializing browser: " + browser);
    	
    	log.info("Driver created for Thread: " + Thread.currentThread().getId());
    	
    	if(browser == null) {
    		throw new RuntimeException("Browser value is NULL. Pass from mvn or config.");
    	}
        switch (browser.toLowerCase()) {
        
        case "chrome":
        	WebDriverManager.chromedriver().setup();
        	driver.set(new ChromeDriver());
        	break;
        
        case "firefox":
        	WebDriverManager.firefoxdriver().setup();
        	driver.set(new FirefoxDriver());
        	break;
        	
        case "edge":
        	//System.setProperty("webdriver.edge.driver", "C:\\WM\\SeleniumFrameworkWM\\EdgeDriver\\msedgedriver.exe");
        	WebDriverManager.edgedriver().setup();
        	driver.set(new EdgeDriver());
        	break;
        	
        default:
        	throw new RuntimeException("Invalid browser " + browser);
        	      	
        }
        getDriver().manage().window().maximize();
    }
        //Get driver instance
        public static WebDriver getDriver() {
        	return driver.get();
        }
        //Quit driver
        public static void quitDriver() {
        	if(driver.get()!=null) {
        		driver.get().quit();
        		driver.remove();
        	}
    }
}

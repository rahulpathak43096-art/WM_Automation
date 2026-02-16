package com.tests;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;



import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pages.LoginPage;
import com.pages.SecurePage;
import com.utils.ExcelUtils;
import com.utils.LoggerUtils;
import com.utils.PropertyUtils;

public class LoginTest extends BaseTest {

    @Test
    public void verifyLoginAndTextFromExcel() {
    	
    	Logger log = LoggerUtils.getLogger(LoginTest.class);
    	
    	log.info("Starting Login Test");

        LoginPage loginPage = new LoginPage();
        SecurePage securePage = new SecurePage();

        // Login to application
        loginPage.login(
                PropertyUtils.getProperty("username"),
                PropertyUtils.getProperty("password")
        );
        
        log.info("Validating success message");

        // Get actual text from UI
        String actualText = securePage.getSuccessMessage();

        // Get expected text from excel
        String expectedText =
                ExcelUtils.getCellData("Sheet1", 0, 0);


        // Validate text
        Assert.assertEquals(actualText, expectedText);

    }
}

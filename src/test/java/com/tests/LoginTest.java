package com.tests;

import org.testng.Assert;



import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pages.LoginPage;
import com.pages.SecurePage;
import com.utils.ExcelUtils;
import com.utils.PropertyUtils;

public class LoginTest extends BaseTest {

    @Test
    public void verifyLoginAndTextFromExcel() {

        LoginPage loginPage = new LoginPage(driver);
        SecurePage securePage = new SecurePage(driver);

        // Login to application
        loginPage.login(
                PropertyUtils.getProperty("username"),
                PropertyUtils.getProperty("password")
        );

        // Get actual text from UI
        String actualText = securePage.getSuccessMessage();

        // Get expected text from excel
        String expectedText =
                ExcelUtils.getCellData("Sheet1", 0, 0);


        // Validate text
        Assert.assertEquals(actualText, expectedText);

    }
}

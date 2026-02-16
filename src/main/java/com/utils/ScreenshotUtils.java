package com.utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.text.SimpleDateFormat;

import com.driver.DriverFactory;

public class ScreenshotUtils {
	public static String captureScreenshot(String screenshotName) {
		WebDriver driver = DriverFactory.getDriver();
		//TimeStamp Creation For giving Unique Naming.
		String timeStamp = new SimpleDateFormat("yyyMMdd_HHmmss").format(new Date());
		//Go-To Project Root
		String path = System.getProperty("user.dir")+"/screenshots/"+screenshotName + "_"+timeStamp + ".png";
		//Taking Screenshot
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		File dest = new File(path);
		
		try {
			FileUtils.copyFile(src,  dest);
		} catch(IOException e) {
			e.printStackTrace();
		}
		return path;
		
	}

}

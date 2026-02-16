package com.utils;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	// Singleton object.
	private static ExtentReports extent;
	public static ExtentReports getInstance() {
		if(extent == null) {
			//Create HTML report file.
			ExtentSparkReporter reporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/ExtentReport.html");
			
			reporter.config().setReportName("Automation COE Report");
			
			reporter.config().setDocumentTitle("Execution Results");
			
			extent = new ExtentReports();
			//Link HTML reporter to extent engine.
			extent.attachReporter(reporter);
		}
		return extent;
	}

}

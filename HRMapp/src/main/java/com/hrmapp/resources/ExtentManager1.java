package com.hrmapp.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class ExtentManager1 {
	
	public static ExtentReports exReport;
	public static  ExtentSparkReporter spark;
	public static ExtentTest exTest;
	
	public void extentReports() {
		exReport = new ExtentReports();
		spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/ExtentReports/MyReport.html");
		exReport.attachReporter(spark);
		
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Banking App");
		spark.config().setReportName("Extent Reports");
		exReport.setSystemInfo("Project Name", "Guru Banking App");
		exReport.setSystemInfo("Tester", "Lavanya");
		
	}
	
	

}

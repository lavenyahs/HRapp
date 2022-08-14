package com.hrmapp.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.hrmapp.base.BaseClass;

public class ExtentManager extends BaseClass {
	
	public static ExtentReports exRep;
	public static ExtentTest exTest;
	public static ExtentSparkReporter spark;
	
	public void ExtentRep1() {
		
		exRep = new ExtentReports();
		spark= new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/MyReport.html");
		exRep.attachReporter(spark);
		
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Automation Report");
		exRep.setSystemInfo("Tester", "Lavanya");
		
	
	}

}

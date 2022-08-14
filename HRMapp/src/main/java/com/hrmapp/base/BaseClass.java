package com.hrmapp.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static  ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	//public static WebDriver driver;
	public static Properties prop1;
	public static String uname,passwd;
	public static Logger log= LogManager.getLogger(BaseClass.class.getName());
	
	
	@BeforeSuite(groups="Smoke")
	public void ExtentReports() {
		ExtentRep();
	}
	
	@BeforeSuite(groups="Smoke")
	public   Properties loadConfig1() {
		
		
		prop1= new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"/Configuration/config1.properties");
			prop1.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
					return prop1;
	}
	
	
	@BeforeMethod(groups="Smoke")
	public static  WebDriver getDriver() {
		return driver.get();
	}
	
	@BeforeMethod(groups="Smoke")
	public void launchBrowser() {
		String browserName=prop1.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
			
		}
		getDriver().get(returnUrl());
	}
	
	public  String returnUrl() {
	return loadConfig1().getProperty("url");
	}

	public String returnuserName() {
	return loadConfig1().getProperty("username");
	
	}
	public  String returnPassword() {
	return loadConfig1().getProperty("password");
	}
	
	
	public static ExtentReports exRep;
	public static ExtentTest exTest;
	public static ExtentSparkReporter spark;
	
public void ExtentRep() {
		
	
	
	exRep = new ExtentReports();
	spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/ExtentReports/MyReport.html");
	exRep.attachReporter(spark);
	
		
		
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Automation Report");
		exRep.setSystemInfo("Tester", "Lavanya");
		
	
	}
public String screenShot(WebDriver driver, String filename) {
	String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
	File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
	String destination = System.getProperty("user.dir") + "\\ScreenShots\\" + filename + "_" + dateName + ".png";

	try {
		FileUtils.copyFile(source, new File(destination));
	} catch (Exception e) {
		e.getMessage();}
	return destination;
	}

}
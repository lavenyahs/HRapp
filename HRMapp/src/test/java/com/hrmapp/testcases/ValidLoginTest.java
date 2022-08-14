package com.hrmapp.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hrmapp.base.BaseClass;
import com.hrmapp.pages.LoginPageValidLogin;

public class ValidLoginTest extends BaseClass {
	
	 LoginPageValidLogin ValidLogin;

	 @Test(groups="Smoke")
	 public void verifyTitleTest() {
		 //driver.get().get(returnUrl());
		 log.info("Title Verification test");
		 ValidLogin = new LoginPageValidLogin();
		String Title = ValidLogin.verifyTitle();
		Assert.assertEquals(Title, "OrangeH");
		log.info("Title Verified");
		 
		 }
	 
	 @Test(groups="Smoke")
	 public void LoginTest() {
		 
		// driver.get().get(returnUrl());
		 log.info("Verify Valid Login Test");
		 
		 ValidLogin = new LoginPageValidLogin();

		 ValidLogin.validLogin();
		 String currentUrl=getDriver().getCurrentUrl();
		 String expectedUrl="https://seleniumtesting-osondemand.orangehrm.com/symfony/web/index.php/dashboard";
		 Assert.assertEquals(currentUrl, expectedUrl);
		 log.info("Login Test Passed");
	 }
}

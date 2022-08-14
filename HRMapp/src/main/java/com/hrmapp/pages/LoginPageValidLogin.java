package com.hrmapp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrmapp.base.BaseClass;



public class LoginPageValidLogin extends BaseClass{

	
	
	@FindBy(xpath="//input[contains(@id,'txtPassword')]")
	WebElement passWord;
	
	//@FindBy(xpath="//input[contains(@name,'txtUsername')]")
	@FindBy(xpath= "//input[@id='txtUsername']")	
	WebElement userName;
	
	@FindBy(xpath="//input[contains(@name,'Submit')]")
	WebElement login;
	
	@FindBy(xpath="//*[contains(text(),'Dashboard')]//parent::a")
	WebElement dashBoard;
	
	public LoginPageValidLogin() {
		PageFactory.initElements(getDriver(), this);
	}
	
	
	public String verifyTitle() {
		//driver.get().get(returnUrl());
		return getDriver().getTitle();
	}
	
	public void validLogin() {
		userName.sendKeys(returnuserName());
		passWord.sendKeys(returnPassword());
		login.click();
		
	}
}

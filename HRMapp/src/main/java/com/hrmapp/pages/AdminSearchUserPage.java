package com.hrmapp.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



import com.hrmapp.base.BaseClass;

public class AdminSearchUserPage extends BaseClass {
	
	Actions actions = new Actions(driver.get());

	@FindBy(xpath="//a[@id='menu_admin_viewAdminModule']")
	WebElement Admin;
	
	//@FindBy(xpath="//a[contains(text(),'User Management')]")
	
	@FindBy(xpath="//a[@id='menu_admin_UserManagement']")
	WebElement userManage;
	
	@FindBy(xpath="//a[@id='menu_admin_viewSystemUsers']")
	WebElement Users;
	
	@FindBy(id="searchSystemUser_employeeName_empName")
	WebElement empName;
	
	@FindBy(xpath="//input[@class='searchbutton']")
	WebElement search;
	
	@FindBy(xpath="//input[@id='searchSystemUser_userName']")
	WebElement userName;
	
	public AdminSearchUserPage() {
		PageFactory.initElements(driver.get(), this);
	}
	
	
	public void searchUsername() {
		
		actions.moveToElement(Admin);
		actions.moveToElement(userManage);
		actions.moveToElement(Users).click().build().perform();
		//Select sel = new Select(empName);
		//sel.selectByVisibleText("Ananya Dash");
		empName.sendKeys("Sun Sun");
		empName.sendKeys(Keys.DOWN);
		empName.sendKeys(Keys.RETURN);
		search.click();
		
		
	}
	
	
	public void userNamefind() {
		actions.moveToElement(Admin);
		actions.moveToElement(userManage);
		actions.moveToElement(Users).click().build().perform();
		userName.sendKeys("sunsun");
		search.click();
		
	}
}

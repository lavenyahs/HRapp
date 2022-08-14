package com.hrmapp.testcases;

import org.testng.annotations.Test;

import com.hrmapp.base.BaseClass;
import com.hrmapp.pages.AdminSearchUserPage;
import com.hrmapp.pages.LoginPageValidLogin;


public class SearchUserTest extends BaseClass {
	
	LoginPageValidLogin vl  ;
	 AdminSearchUserPage adSe;
	
	
	
	
		
	@Test(enabled=true)
	public  void userX()
	{
		vl = new LoginPageValidLogin();
		adSe = new AdminSearchUserPage();
		vl.validLogin();
		adSe.searchUsername();
		
	}

	
	@Test(enabled=true, groups="Smoke")
	public  void userFind() 
	{
		vl = new LoginPageValidLogin();
		adSe= new AdminSearchUserPage();
		vl.validLogin();
		adSe.userNamefind();
		
	}
	
	
}

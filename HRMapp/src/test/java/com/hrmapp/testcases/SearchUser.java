package com.hrmapp.testcases;

import org.testng.annotations.Test;

import com.hrmapp.base.BaseClass;
import com.hrmapp.pages.AdminSearchUserPage;
import com.hrmapp.pages.LoginPageValidLogin;

public class SearchUser extends BaseClass {
	
	static LoginPageValidLogin vl;
	static AdminSearchUserPage as;
	
	@Test
	public static void empNa() {
		log.info("Search by Employee Name started");
		vl = new LoginPageValidLogin();
		as= new AdminSearchUserPage();
		vl.validLogin();
		as.searchUsername();
		log.info("Search by EmpName passed");
	}

	
	@Test(groups="Smoke")
	public static void userNamefield()  {
		
		log.info("UserName Find  Test started");
		vl= new LoginPageValidLogin();
		
		vl.validLogin();
		
		as= new AdminSearchUserPage();
		
		as.userNamefind();
		log.info("UserName Passed");
	}
}

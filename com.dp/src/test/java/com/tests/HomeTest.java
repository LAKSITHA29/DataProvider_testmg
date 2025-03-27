package com.tests;


import org.testng.Assert;
import org.testng.annotations.Test;


public class HomeTest extends BaseTest {
	com.pages.HomePage objHome;
	 @Test(priority = 0)
	  public void loginTest() {
		  objHome=new com.pages.HomePage(driver);
		  String loginPageTitle=objHome.getLoginPageText();
		  //Assert.assertTrue(loginPageTitle.contains("Welcome to the new Tricentis store!"));
	  }

}
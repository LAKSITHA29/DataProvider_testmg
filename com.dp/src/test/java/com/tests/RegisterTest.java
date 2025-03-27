package com.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.RegisterPage;

public class RegisterTest extends BaseTest {
	HomePage objHome;
	RegisterPage objReg;
	
	
  @Test(dataProvider = "excelData", dataProviderClass = DPExcel.class)
  public void Register(String Gender,String firstName, String lastName, String email, String password, String confirmPassword) {
	  objHome=new HomePage(driver);
	  objHome.register();
	  objReg=new RegisterPage(driver);
	  Assert.assertTrue(objReg.getRegisterPageText().contains("Register"));
	  objReg.setGender("male");
	    objReg.setFirstName(firstName);
	    objReg.setLastName(lastName);
	    objReg.setEmail(email);
	    objReg.setPassword(password);
	    objReg.setConfirmPassword(confirmPassword);
	    objReg.clickRegisterButton();

	  //  Assert.assertTrue(driver.getPageSource().contains("Your registration completed"), "Registration was not successful");
	  
  }
}
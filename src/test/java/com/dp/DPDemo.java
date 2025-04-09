package com.dp;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DPDemo {
	WebDriver driver;
  
	 @DataProvider(name="testData")
	  public Object[][] dataprovFunc() {
	    return new Object[][] {{"Selenium"},{"TestNG"},{"Automation"}};
	  }
}

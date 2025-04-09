package com.dp;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProviderDemo{
	WebDriver driver;

	 @DataProvider(name = "testData")
	    public Object[][] dataprovFunc() {
	        return new Object[][] { { "Selenium" }, { "TestNG" } };
	    }
	
	@BeforeMethod
	public void verify() {
		System.out.println("Start of test");
		driver=new ChromeDriver();
		driver.get("https://www.bing.com");
		driver.manage().window().maximize();
	}
	
//	@Test(dataProvider = "testData")
//	public void Search(String keyWord) throws InterruptedException {
//		 WebElement searchBox = driver.findElement(By.name("q"));
//         searchBox.sendKeys(keyWord);
//         System.out.println("Keyword entered: " + keyWord);
//         searchBox.sendKeys(Keys.ENTER);
//         System.out.println("Search results displayed");
//         
//         Thread.sleep(3000);
//         
//         String actualTitle = driver.getTitle();
//         System.out.println("Actual Title: " + actualTitle);
//
//         // Construct expected title
//         String expectedTitle = "Search - " + keyWord;
//
//         // Assert that the title is exactly as expected
//         Assert.assertEquals(actualTitle, expectedTitle, "Title does not match expected format.");
//     }
	@Test(dataProvider = "testData")
	public void search(String keyWord) throws InterruptedException {
	    WebElement searchBox = driver.findElement(By.name("q"));
	    searchBox.sendKeys(keyWord);
	    System.out.println("Keyword entered: " + keyWord);
	    searchBox.sendKeys(Keys.ENTER);
	    System.out.println("Search results displayed");

	    // Wait for results to load (use explicit wait if needed)
	    Thread.sleep(3000);

	    String actualTitle = driver.getTitle();
	    System.out.println("Actual Title: " + actualTitle);

	    // Assert that the actual title contains the keyword
	    Assert.assertTrue(actualTitle.toLowerCase().contains(keyWord.toLowerCase()), 
	        "Title does not contain the expected keyword: " + keyWord + ". Actual Title: " + actualTitle);
	}

	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		System.out.println("End of test");
		
	}
	
}
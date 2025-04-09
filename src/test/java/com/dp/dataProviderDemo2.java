//package com.dp;
//
//import org.testng.annotations.Test;
//import org.testng.annotations.BeforeMethod;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//
//public class dataProviderDemo2 {
//	public WebDriver driver;
// 
//  @BeforeMethod
//  public void setUp() {
//	  System.out.println("Start the test");
//	  driver=new ChromeDriver();
//	  driver.get("https://www.bing.com/");
//	  driver.manage().window().maximize();	  
//  }
//  
//   @Test(dataProvider = "testData",dataProviderClass=DPDemo.class)
//   public void search(String keyWord,String keyword2) {
//	   
//	   WebElement searchbox=driver.findElement(By.name("q"));
//	   searchbox.sendKeys(keyWord,keyword2);
//	   
//	   System.out.println("Keyword entered is:"+keyWord+" "+keyword2);
//	   searchbox.sendKeys(Keys.ENTER);
//	   System.out.println("Search result is displayed");
//	   
//	   String expectedTitle="selenium - Search"; 
//	   String actual=driver.getTitle();
//	   Assert.assertEquals(expectedTitle, actual);
//	   System.out.println(driver.getTitle());
//	 
//   }
//
//   @AfterMethod
//   public void tearDown() {
// 	  driver.quit();
// 	  System.out.println("End the test");	  
//   }
// }

package com.dp;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class dataProviderDemo2 {
	public WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.out.println("Start the test");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // Implicit Wait
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
	}
	 @Test(dataProvider = "testData", dataProviderClass = DPDemo.class)
	  public void search(String keyWord) throws InterruptedException {
	      WebElement searchbox = driver.findElement(By.name("q"));
	      searchbox.sendKeys(keyWord);
	      System.out.println("Keyword entered is: " + keyWord);
	      searchbox.sendKeys(Keys.ENTER);
	      System.out.println("Search result is displayed");

	      // Wait until the title is updated from "Search - Microsoft Bing"
//	      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	      wait.until(ExpectedConditions.not(ExpectedConditions.titleIs("Search - Microsoft Bing")));
	      
	      Thread.sleep(3000);

	      // Get the actual title
	      String actualTitle = driver.getTitle();
	      System.out.println("Actual Title: " + actualTitle);

	      Thread.sleep(3000);
	      // Assert that the title contains the search keyword
	      Assert.assertTrue(actualTitle.toLowerCase().contains(keyWord.toLowerCase()), 
	          "Expected title to contain: " + keyWord + ", but got: " + actualTitle);
	  }

	@AfterMethod
	public void tearDown() {
		driver.quit();
		System.out.println("End the test");
	}
}


//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.annotations.*;
//
//import java.time.Duration;
//
//public class dataProviderDemo2 {
//    public WebDriver driver;
//
//    @BeforeMethod
//    public void setUp() {
//        System.out.println("Start the test");
//        driver = new ChromeDriver();
//        driver.get("https://www.bing.com/");
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Implicit Wait
//    }
//
//    @Test(dataProvider = "testData", dataProviderClass = DPDemo.class)
//    public void search(String keyWord) {
//        WebElement searchbox = driver.findElement(By.name("q"));
//        searchbox.sendKeys(keyWord);
//        System.out.println("Keyword entered is: " + keyWord);
//        searchbox.sendKeys(Keys.ENTER);
//        System.out.println("Search result is displayed");
//
//        // Explicit Wait: Wait until the title contains the keyword
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.titleContains(keyWord));
//
//        // Get and verify the actual title
//        String actualTitle = driver.getTitle();
//        System.out.println("Actual Title: " + actualTitle);
//
//        Assert.assertTrue(actualTitle.toLowerCase().contains(keyWord.toLowerCase()),
//                "Expected title to contain: " + keyWord + ", but got: " + actualTitle);
//    }
//
//    @AfterMethod
//    public void tearDown() {
//        driver.quit();
//        System.out.println("End the test");
//    }
//}


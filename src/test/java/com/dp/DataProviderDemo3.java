//package com.dp;
//
//import org.testng.annotations.Test;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.DataProvider;
//
//import java.time.Duration;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//
//public class DataProviderDemo3 {
//	private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
////	@DataProvider(name="testData")
////	public Object[][] dataProvFunc(){
////		return new Object[][] {{"Selenium"},{"TestNG"}};
////	}
////  @Test(dataProvider = "testData", dataProviderClass = DPDemo.class)
//	@Test(dataProvider = "testData", dataProviderClass = DPDemo2.class)
//  public void search(String Keyword,String Experience) { 
//		WebDriver driver = getDriver();
////	  WebElement txtBox=driver.findElement(By.id("sb_form_q"));
////	  txtBox.sendKeys(Keyword);
////	  System.out.println("Keyword entered is: "+Keyword);
////	  txtBox.sendKeys(Keys.ENTER);
//	  WebElement txtBox = driver.findElement(By.id("sb_form_q"));
//	  txtBox.sendKeys(Keyword + " " + Experience);
//	  System.out.println("Keyword entered is: " + Keyword + " " + Experience);
//	  txtBox.sendKeys(Keys.ENTER);
//	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
//      wait.until(ExpectedConditions.titleContains(Keyword));
//	    String searchResultPageTitle = driver.getTitle();
//	    Assert.assertTrue(searchResultPageTitle.contains(Keyword), "Search result page title does not contain the keyword: " + Keyword);
//	  System.out.println("Search result is displayed.");
//	  
//  }
//  @BeforeMethod
//  public void setup() {
//	  System.out.println("Start the test");
//	  WebDriver driver = getDriver();
//		driver = new ChromeDriver();
//		driver.get("https://www.google.com/");
//		driver.manage().window().maximize();
//		setDriver(driver);
//  }
//
//  @AfterMethod
//  public void afterMethod() {
//	  WebDriver driver = getDriver();
//	  driver.quit();
//	  removeDriver();
//	  System.out.println("End the test");
//  }
//  private void setDriver(WebDriver driver) {
//      driverThreadLocal.set(driver);
//  }
//
//  private WebDriver getDriver() {
//      return driverThreadLocal.get();
//  }
//
//  private void removeDriver() {
//      driverThreadLocal.remove();
//  }
//}

package com.dp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class DataProviderDemo3 {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeMethod
    public void setup() {
        System.out.println("Initializing WebDriver for thread: " + Thread.currentThread().getId());

        // Configure ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        driver.set(new ChromeDriver(options));
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(dataProvider = "searchData" )
    public void search(String keyword) {
        WebDriver webDriver = driver.get();
        webDriver.get("https://www.google.com");

        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        WebElement searchBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("q")));

        searchBox.sendKeys(keyword);
        searchBox.submit();

        WebElement searchResults = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='search']")));
        System.out.println("Search result displayed for: " + keyword);
        System.out.println("Page Title: " + webDriver.getTitle());
    }

    @AfterMethod
    public void afterMethod() {
        WebDriver webDriver = driver.get();
        if (webDriver != null) {
            System.out.println("Closing Selenium WebDriver for thread: " + Thread.currentThread().getId());
            webDriver.quit();
            driver.remove();
        }
    }

    @DataProvider(name = "searchData",parallel=true)
    public Object[][] searchData() {
        return new Object[][] {
                {"selenium"},
                {"TestNG"},
                {"java"},{"python"}
        };
    }
}
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
//import org.testng.annotations.DataProvider;
//
//public class DataProviderExcel {
//	public WebDriver driver;
//	
//  @BeforeMethod
//  public void beforeMethod() {
//	  System.out.println("Start the test");
//	  driver=new ChromeDriver();
//	  driver.get("https://www.google.com");
//	  driver.manage().window().maximize();
//  }
//  
//  @Test(dataProvider="excelData", dataProviderClass=DPExcel.class)
//  public void search(String keyWord) {  
//      WebElement txtbox = driver.findElement(By.name("q")); 
//     // System.out.println("Keyword entered is: " + keyWord);
//
//      txtbox.sendKeys(keyWord);
//      
//      System.out.println("Keyword entered is: " + keyWord);
//      txtbox.sendKeys(Keys.ENTER);
//      System.out.println("Search result is displayed");
//
//      System.out.println("Result: " + driver.getTitle());
//
//      Assert.assertTrue(driver.getPageSource().contains(keyWord));
//  }
//
////	 @Test(dataProvider = "excelData",dataProviderClass=DPExcel.class)
////	   public void search(String keyword1,String keyword2) throws InterruptedException {
////			   
////			   WebElement searchbox=driver.findElement(By.id("sb_form_q"));
////			   searchbox.sendKeys(keyword1," " ,keyword2);
////			   
////			   System.out.println("Keyword entered is:"+keyword1+" "+keyword2);
////			   searchbox.sendKeys(Keys.ENTER);
////			   System.out.println("Search result is displayed");
////			   System.out.println("RESULT: "+driver.getTitle());
////			   Thread.sleep(3000);
////			   Assert.assertTrue(driver.getPageSource().contains(keyword1));
////	 }
//			   
//  @AfterMethod
//  public void afterMethod() {
//	  driver.quit();
//  }
//
//  }

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

public class DataProviderExcel {

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

    @Test(dataProvider = "excelData",dataProviderClass=DPExcel.class)
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
//            driver.remove();
        }
    }
}

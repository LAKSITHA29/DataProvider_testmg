//package com.dp;
//	
//
//	import java.awt.AWTException;
//	import java.awt.Robot;
//	import java.awt.Toolkit;
//	import java.awt.datatransfer.StringSelection;
//	import java.awt.event.KeyEvent;
//	import java.time.Duration;
//
//	import org.openqa.selenium.By;
//	import org.openqa.selenium.WebDriver;
//	import org.openqa.selenium.WebElement;
//	import org.openqa.selenium.chrome.ChromeDriver;
//
//	public class Fileupload1 {
//
//	    public static void main(String[] args) throws AWTException, InterruptedException {
//	        Robot rb = new Robot();
//	        WebDriver driver = new ChromeDriver();
//			driver.manage().window().maximize();
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//			driver.get("https://pdf2doc.com/");
//			
//			WebElement upload = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/label/span"));
//			upload.click();
//			//Thread.sleep(1000);
//
//	        // COPY FILE PATH TO CLIPBOARD
//	        StringSelection str = new StringSelection("C:\\Users\\ADMIN\\Downloads\\12_Exception Handling");
//	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
//
//	        // Give time for the clipboard to be ready
//	        Thread.sleep(1000);
//
//	        // PRESS CTRL + V FOR PASTING
//	        rb.keyPress(KeyEvent.VK_CONTROL);
//	        rb.keyPress(KeyEvent.VK_V);
//	        
//	        //RELEASE CTRL V FOR PASTING
//	        rb.keyRelease(KeyEvent.VK_V);
//	        rb.keyRelease(KeyEvent.VK_CONTROL);
//
//	        // FOR PRESSING AND RELEASING ENTER
//	        rb.keyPress(KeyEvent.VK_ENTER);
//	        rb.keyRelease(KeyEvent.VK_ENTER);
//	    }
//		
//
//
//}
package com.dp;

import org.testng.annotations.Test;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Fileupload1 {

    @Test
    public void uploadPDFTest() throws AWTException, InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://pdf2doc.com/");

        WebElement uploadBtn = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/label/span"));
        uploadBtn.click();

        Thread.sleep(2000); 

        StringSelection selection = new StringSelection("C:\\Users\\ADMIN\\Downloads\\12_Exception Handling");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

        Robot rb = new Robot();
        rb.delay(1000);

        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);
        rb.keyRelease(KeyEvent.VK_V);
        rb.keyRelease(KeyEvent.VK_CONTROL);

        rb.delay(500);
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
    }
}
package com.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
  public HomePage(WebDriver driver) {
		super(driver);
	}
  @FindBy(xpath = "//a[text()='Register']")
  WebElement register;
  
  @FindBy(xpath = "//div[@class=\"topic-html-content-body\"]//p[1]")
  WebElement titleText;
  public void register() {
	  register.click();
  }
  public String getLoginPageText() {
		return titleText.getText();
	}

}
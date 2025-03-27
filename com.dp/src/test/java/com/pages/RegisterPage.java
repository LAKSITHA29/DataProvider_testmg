package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class RegisterPage extends BasePage {
	
  public RegisterPage(WebDriver driver) {
		super(driver);
	}
  @FindBy(xpath="//h1[text()='Register']")
  WebElement registerText;
  
  @FindBy(id = "gender-male")
  private WebElement genderMale;

  @FindBy(id = "gender-female")
  private WebElement genderFemale;

  @FindBy(id = "FirstName")
  private WebElement firstName;

  @FindBy(id = "LastName")
  private WebElement lastName;

  @FindBy(id = "Email")
  private WebElement email;

  @FindBy(id = "Password")
  private WebElement password;

  @FindBy(id = "ConfirmPassword")
  private WebElement confirmPassword;

  @FindBy(id = "register-button")
  private WebElement registerButton;
  
  public String getRegisterPageText() {
	  return registerText.getText();
  }
  
  public void setGender(String gender) {
      if ("male".equalsIgnoreCase(gender)) {
          genderMale.click();
      } else if ("female".equalsIgnoreCase(gender)) {
          genderFemale.click();
      } else {
          throw new IllegalArgumentException("Invalid gender: " + gender);
      }
  }

  public void setFirstName(String firstName) {
      this.firstName.sendKeys(firstName);
  }

  public void setLastName(String lastName) {
      this.lastName.sendKeys(lastName);
  }

  public void setEmail(String email) {
      this.email.sendKeys(email);
  }

  public void setPassword(String password) {
      this.password.sendKeys(password);
  }

  public void setConfirmPassword(String confirmPassword) {
      this.confirmPassword.sendKeys(confirmPassword);
  }

  public void clickRegisterButton() {
      registerButton.click();
  }

  
}
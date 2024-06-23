package com.Fanflix.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.qa.base.TestBase;


public class LoginPage extends TestBase {
    @CacheLookup
	@FindBy(xpath = "//img[contains(@src, 'fanfix')]")
	WebElement fanfixLogo;
	
	@FindBy(xpath = "//p[text()='Log in']")
	WebElement loginText;
	
	@FindBy(id = "email")
	WebElement emailField;
	
	@FindBy(id = "password")
	WebElement passwordField;
	
	@FindBy(xpath = "//button[text()='Continue']")
	WebElement continueButton;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyLoginPageTitle(){
		return driver.getTitle();
	}

	public boolean verifyLoginText(){
		return loginText.isDisplayed();
	}
	
	
	public boolean verifyFanfixLogo(){
		return fanfixLogo.isDisplayed();
	
	}
	
	public DashboardPage dologin(String username,String passcode){
		Assert.assertFalse(continueButton.isEnabled());
		emailField.sendKeys(username);
		passwordField.sendKeys(passcode);
		Assert.assertTrue(continueButton.isEnabled());
		waitforElementClickable(continueButton);
		continueButton.click();
		return new DashboardPage();
		
	}
	

}
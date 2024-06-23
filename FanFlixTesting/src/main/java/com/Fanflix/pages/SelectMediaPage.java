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


public class SelectMediaPage extends TestBase {
    @CacheLookup
	@FindBy(xpath = "//button[text()= 'Upload Media']")
	WebElement uploadMediaButton;
	

	
	@FindBy(xpath = "//button[text()='Add Media']")
	WebElement addMedia;

	
	@FindBy(xpath = "//div[contains (@data-testid,'grid-item-0')]")
	WebElement latestUploadImage;

	public SelectMediaPage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyLoginPageTitle(){
		return driver.getTitle();
	}

	

	public NewPostCreatePage selectUploadedFile(){
		latestUploadImage.click();
		latestUploadImage.isSelected();
		addMedia.click();
		return new NewPostCreatePage();
	
	}
	public UploadMediaPage uploadFile(){
		waitforElementVisible(uploadMediaButton);
		uploadMediaButton.click();
		return new UploadMediaPage();
		
	}
	

}
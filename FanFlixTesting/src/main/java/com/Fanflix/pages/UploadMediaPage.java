package com.Fanflix.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.base.TestBase;


public class UploadMediaPage extends TestBase {
	@CacheLookup
	@FindBy(xpath = "//input[@class='filepond--browser']")
	WebElement dragDropFiles;

	@CacheLookup
	@FindBy(xpath = "//button[text()='Continue'] ")
	WebElement continueButton;

	public UploadMediaPage() {
		PageFactory.initElements(driver, this);
	}
	public SelectMediaPage doUpload(String filepath) throws IOException{
		dragDropFiles.sendKeys(filepath);
		waitforElementClickable(continueButton);
		continueButton.click();
		return new SelectMediaPage();

	}


}
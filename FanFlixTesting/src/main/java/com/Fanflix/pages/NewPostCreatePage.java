package com.Fanflix.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.qa.base.TestBase;

public class NewPostCreatePage extends TestBase {

	SoftAssert softAssert = new SoftAssert();

	@FindBy(id = "post-caption")
	WebElement postCaptionTextBox;

	@FindBy(xpath = "//div[@data-testid='media-stack-upload-c']")
	WebElement mediaUpload;

	@FindBy(xpath = "//img[@title='post media']")
	WebElement fileUploadedImg;

	@FindBy(xpath = "//p[text()='Subscriber Price']/..//following-sibling::div//p[text()='Custom']")
	WebElement customSubscriberValue;

	@FindBy(xpath = "//p[text()='Non-Subscriber Price']/..//following-sibling::div//p[text()='Custom']")
	WebElement customNonSubscriberValue;

	@FindBy(xpath = "(//input[@name='custom-sub'])[1]")
	WebElement customSubscriberInputValue;

	@FindBy(xpath = "(//input[@name='custom-sub'])[2]")
	WebElement customNonSubscriberInputValue;

	@FindBy(xpath = "//button[text()='Post to Profile']")
	WebElement postToProfileButton;


	public NewPostCreatePage() {
		PageFactory.initElements(driver, this);
	}

	public void FileisUploaded(){
		waitforElementVisible(fileUploadedImg);

	}

	public SelectMediaPage UploadImg(String Caption){

		postCaptionTextBox.sendKeys(Caption);
		System.out.println("Caption"+Caption);

		mediaUpload.click();

		return new SelectMediaPage();

	}


	public boolean createPostWrongInput(String wrongCustomSubValue,String wrongCustomNonSubValue){

		customSubscriberValue.click();
		customNonSubscriberValue.click();


		return postToProfileButton.isEnabled();



	}

	public DashboardPage createPostCorrectInput(String customSubValue,String customNonSubValue){

		customSubscriberInputValue.sendKeys(customSubValue);
		customNonSubscriberInputValue.sendKeys(customNonSubValue);
		waitforElementClickable(postToProfileButton);
		postToProfileButton.click();
		return new DashboardPage();



	}






}

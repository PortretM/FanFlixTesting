package com.Fanflix.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class DashboardPage extends TestBase {



	@FindBy(xpath   = "//a[@href='/dashboard']")
	WebElement dashboardSection;

	@FindBy(xpath = "//p[text()='Creator Dashboard']")
	@CacheLookup
	private WebElement creatorDashboardText;

	@FindBy(xpath = "//button[text()='New Post']")
	@CacheLookup
	private WebElement newPostButton;

	@FindBy(xpath = "//div[@data-testid='latest-posts-container-box-c']//li[@data-testid='mobile-table-row-0-ds']//p")
	@CacheLookup
	private WebElement latestPostValue;
	
	@FindBy(xpath = "(//a[@href='/posts'])[1]")
	@CacheLookup
	private WebElement postTabLink;
	
	
	

	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}

	public void verifyDashboardPage(){
		implicitWait(10);
		waitforElementVisible(dashboardSection);
		
	}


	public NewPostCreatePage clickNewPost(){
		waitforElementClickable(newPostButton);
		newPostButton.click();
		return new NewPostCreatePage();

	}

	public String getLatestPostText(){
		System.out.println(latestPostValue.getAttribute("innerHTML"));
		return latestPostValue.getAttribute("innerHTML");
	}
	
	public void clickPostTab(){
	
		postTabLink.click();

		
		

	}


}

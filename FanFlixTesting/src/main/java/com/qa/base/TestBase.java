package com.qa.base;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;



public class TestBase {

	public static WebDriver driver;
	WebDriverWait wait ;
	private JavascriptExecutor js = (JavascriptExecutor) driver;

	public static int TIME_FOR_SLEEP = 3;

	public static void initialization(String browser, String url) {


		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver", "D:\\EcomTesting\\EcommerceAppWebTesting\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();


		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		}
		else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		}
		implicitWait(20);
		driver.manage().window().maximize();
		driver.get(url);

	}


	public static void implicitWait(int timeInSecond) {
		driver.manage().timeouts().implicitlyWait(timeInSecond, TimeUnit.SECONDS);
	}
	
	public void refresh(int timeInSecond) {
		sleep(timeInSecond);
		driver.getCurrentUrl();
		driver.navigate().refresh();
	}

	public void waitforElementClickable(WebElement webelement) {
		wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(webelement));
	}
	public void waitforElementVisible(WebElement webelement) {
		wait=new WebDriverWait(driver,10);
		List<WebElement> ab=	wait.until(ExpectedConditions.visibilityOfAllElements(webelement));
		Assert.assertEquals(ab.size(), 1);
	}

public   static String getCurrentDate() {
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");  
	LocalDateTime now = LocalDateTime.now();  
	System.out.println(dtf.format(now));  
	return dtf.format(now);
}
	public void sleep(int timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void QuitDriver(){
		driver.quit();
	}


}

package FanflixTests;



import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Fanflix.pages.DashboardPage;
import com.Fanflix.pages.LoginPage;
import com.Fanflix.pages.NewPostCreatePage;
import com.Fanflix.pages.SelectMediaPage;
import com.Fanflix.pages.UploadMediaPage;
import com.qa.base.TestBase;


public class FanflixWorkflowTest  extends TestBase
{

	LoginPage loginPage;

	DashboardPage dashboardPage;

	NewPostCreatePage newPostCreatePage;
	UploadMediaPage uploadMediaPage;
	SelectMediaPage selectMediaPage;
	public String postcaption;

	@BeforeTest
	@Parameters({"browser", "url"})
	public void setup(String browser, String url) {
		initialization(browser, url);

	}

	//Covers TC-1:Verify Appn is redirecting to dashboard page after giving correct credentials
	@Parameters({"username", "password"})
	@Test(priority = 1)
	public void verifyLoginPage(String Username,String Password) {

		SoftAssert softAssert = new SoftAssert();
		loginPage = new LoginPage();
		implicitWait(20);
		softAssert.assertTrue(loginPage.verifyFanfixLogo());
		softAssert.assertTrue(loginPage.verifyLoginText());
		dashboardPage = loginPage.dologin(Username, Password);
		softAssert.assertAll();


	}



	//Covers TC-2:User is Able to Upload A file for a new post
	@Test(priority = 2)
	public void UploadFile() throws IOException {

		SoftAssert softAssert = new SoftAssert();
		implicitWait(20);

		dashboardPage.verifyDashboardPage();
		newPostCreatePage = dashboardPage.clickNewPost();

		postcaption = "This post is done by automation assignment"+getCurrentDate();
		System.out.println(postcaption);
		selectMediaPage= newPostCreatePage.UploadImg(postcaption);
		uploadMediaPage=selectMediaPage.uploadFile();

		//Image to upload
		String filePath = System.getProperty("user.dir") + "/Files/test2.jpg";
		System.out.println(filePath);
		selectMediaPage=uploadMediaPage.doUpload(filePath);

		newPostCreatePage=selectMediaPage.selectUploadedFile();
		newPostCreatePage.FileisUploaded();
		softAssert.assertAll();
	}
	//Covers TC-3:User is Able to Post with Subscription values more than 5 dollars
	@Test(priority = 3)
	public void UploadPost()  {

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertFalse(newPostCreatePage.createPostWrongInput("2", "3"));
		dashboardPage = newPostCreatePage.createPostCorrectInput("6", "5");
		refresh(5);
		softAssert.assertEquals(dashboardPage.getLatestPostText(), postcaption);
		softAssert.assertAll();

	}


	@AfterTest
	public void EndSession() {
		QuitDriver();
	}

}

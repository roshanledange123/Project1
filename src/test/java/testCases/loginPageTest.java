package testCases;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Base.testBase;
import Pages.loginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ExtentReportManager;
import utility.captureScreenShot;
import utility.readData;

public class loginPageTest extends testBase {

	
	loginPage login; //=new loginPage();
	
	//This method is used to open the browser
	@BeforeMethod(alwaysRun = true)
	public void setup() throws Exception
	{
		login=new loginPage();
		Initialization();
	}
	
	//This test case to get title of loginpage
	@Test(priority = 2,enabled = false)
	public void verifyLoginPageTitleTest() throws Exception
	{
	//	String expTitle = "Swag Labs";
		String expTitle =readData.readExcelFile(0, 0);
		String actTitle = login.verifyLoginPageTitle();
		Assert.assertEquals(actTitle,expTitle);
		Reporter.log("LoginPageTitle="+actTitle);
	}
	
	//This test case to get url of loginpage
	@Test(priority = 4,enabled =  false,groups = "Regression")
	public void verifyLoginPageURLTest() throws Exception
	{
	//	String expURL = "https://www.saucedemo.com/";
		String expURL = readData.readExcelFile(0, 1);
		String actURL = login.verifyLoginPageURL();
		Assert.assertEquals(actURL, expURL);
		Reporter.log("LoginPageURL="+actURL);
	}
	
	//This test case to get logo of loginpage
	@Test(priority = 3,enabled = false,groups = "Regression")
	public void verifyLoginLogoTest() throws Exception
	{
		login=new loginPage();
	//	String expLogo = "Swag Labs";
		String expLogo = readData.readExcelFile(0, 2);
		String actLogo = login.verifyLoginLogo();
		Assert.assertEquals(actLogo, expLogo);
		Reporter.log("logoText="+actLogo);
	}
	
	//This test case to enter or login the page
	@Test(priority = 1,enabled =  true,invocationCount = 1)
	public void verifyLoginToTheAppTest() throws Exception
	{
		login=new loginPage();
	//	String expUrl = "https://www.saucedemo.com/inventory.html";
		String expUrl = readData.readExcelFile(0, 3);  //0,3
		String actUrl = login.verifyLoginToTheApp();
		Assert.assertEquals(actUrl, expUrl);
		Reporter.log("URL of InventoryPage="+actUrl);
	}
	
	//This method is used to close the Browser and capture Screenshot filed test case
	@AfterMethod(alwaysRun = true)
	public void closeBrowser(ITestResult it) throws Exception
	{
		if(it.FAILURE==it.getStatus())
		{
			captureScreenShot.screenShot(it.getName());
		}
		report.flush();
		
		driver.close();
	}
}

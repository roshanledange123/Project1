package testCases;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.testBase;
import Pages.cartPage;
import Pages.checkOutCompletePage;
import Pages.checkOutOverViewPage;
import Pages.checkOutPage;
import Pages.inventoryPage;
import Pages.loginPage;
import utility.captureScreenShot;
import utility.readData;

public class checkOutCompletePageTest extends testBase{

	
	loginPage login; //=new loginPage();
	inventoryPage invent; //=new inventoryPage();
	cartPage cart; //=new cartPage();
	checkOutPage check; //=new checkOutPage();
	checkOutOverViewPage over; //=new checkOutOverViewPage();
	checkOutCompletePage copl; //= new checkOutCompletePage();

	@BeforeMethod
	public void setup() throws Exception
	{
		Initialization();
		login=new loginPage();
		login.verifyLoginToTheApp();
		invent=new inventoryPage();
		invent.verifyCartPage();
		cart =new cartPage();
		cart.verifyCheckOutPageOne();
		check=new checkOutPage();
		check.verifyCheckOutInformation();
		over=new checkOutOverViewPage();
		over.verifyFinishButton();
		copl= new checkOutCompletePage();
	}
	
	@Test(priority = 1,enabled = true)
	public void verifyCheckoutCompleteLableTest() throws Exception
	{
	//	String expText = "Checkout: Complete!";
		String expText = readData.readExcelFile(5, 0);
		String actText = copl.verifyCheckoutCompleteLable();
		Assert.assertEquals(actText, expText);
		Reporter.log("Checkout complete lable="+actText);
	}
	
	@Test(priority = 2,enabled = true)
	public void verifyPonyExpressLogoTest()
	{
		boolean actLogo = copl.verifyPonyExpressLogo();
		Assert.assertEquals(actLogo, true);
		Reporter.log("Pony Express logo="+actLogo);
	}
	
	@Test(priority = 3,enabled = true)
	public void verifyThankuLableTest() throws Exception
	{
	//	String expText ="Thank you for your order!";
		String expText = readData.readExcelFile(5, 1);
		String actText = copl.verifyThankuLable();
		Assert.assertEquals(actText, expText);
		Reporter.log("Thanku Lable="+actText);
	}
	
	@Test(priority = 4,enabled = true)
	public void verifyBackToHomeButtonTest() throws Exception
	{
	//	String expUrl = "https://www.saucedemo.com/inventory.html";
		String expUrl = readData.readExcelFile(5, 2);
		String actUrl = copl.verifyBackToHomeButton();
		Assert.assertEquals(actUrl, expUrl);
		Reporter.log("After clicking Back button Url get="+actUrl);
	}
	
	@AfterMethod
	public void closeBrowser(ITestResult it) throws Exception
	{
		if(it.FAILURE==it.getStatus())
		{
			captureScreenShot.screenShot(it.getName());
		}
		driver.close();
	}
}

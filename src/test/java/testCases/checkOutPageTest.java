package testCases;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.testBase;
import Pages.cartPage;
import Pages.checkOutPage;
import Pages.inventoryPage;
import Pages.loginPage;
import utility.captureScreenShot;
import utility.readData;

public class checkOutPageTest extends testBase {

	loginPage login; //=new loginPage();
	inventoryPage invent; //=new inventoryPage();
	cartPage cart; //=new cartPage();
	checkOutPage check; //=new checkOutPage();
	
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
	}
	
	@Test(priority = 1,enabled = true)
	public void verifyCheckOutLebalTest() throws Exception
	{
	//	String expLebal = "Checkout: Your Information";
		String expLebal = readData.readExcelFile(2, 0);
		String actLebal = check.verifyCheckOutLebal();
		Assert.assertEquals(actLebal, expLebal);
		Reporter.log("Checkout Lable="+actLebal);
	}
	
	@Test(priority = 2,enabled = true)
	public void verifyCancleButtonTest() throws Exception 
	{
	//	String expUrl = "https://www.saucedemo.com/cart.html";
		String expUrl = readData.readExcelFile(2, 1);
		String actUrl = check.verifyCancleButton();
		Assert.assertEquals(actUrl, expUrl);
		Reporter.log("After clicking cancle button Url get="+actUrl);
	}
	
	@Test(priority = 3,enabled = true)
	public void verifyCheckOutInformationTest() throws Exception
	{
	//	String expURL = "https://www.saucedemo.com/checkout-step-two.html";
		String expURL = readData.readExcelFile(2, 2);
		String actURL = check.verifyCheckOutInformation();
		Assert.assertEquals(actURL, expURL);
		Reporter.log("after filing info and clicking continue Url get="+actURL);
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

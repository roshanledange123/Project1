package testCases;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.testBase;
import Pages.cartPage;
import Pages.inventoryPage;
import Pages.loginPage;
import utility.captureScreenShot;
import utility.readData;

public class cartPageTest extends testBase {

	loginPage login; //=new loginPage();
	inventoryPage invent; //=new inventoryPage();
	cartPage cart; // =new cartPage();
	
	@BeforeMethod
	public void setup() throws Exception
	{
		Initialization();
		login=new loginPage();
		login.verifyLoginToTheApp();
		invent=new inventoryPage();
		invent.verifyCartPage();
		cart =new cartPage();
	}
	
	@Test(priority = 4,enabled = true)
	public void verifyCartLabelTest() throws Exception
	{
	//	String expLabel = "Your Cart";
		String expLabel = readData.readExcelFile(4, 0);
		String actLabel = cart.verifyCartLabel();
		Assert.assertEquals(actLabel, expLabel);
		Reporter.log("CartLable="+actLabel);
	}
	
	@Test(priority = 3,enabled = true)
	public void verifyBagPagLabelTest() throws Exception
	{
	//	String expLebal="Sauce Labs Backpack";
		String expLebal=readData.readExcelFile(4, 1);
		String actLebal = cart.verifyBagPagLabel();
		Assert.assertEquals(actLebal, expLebal);
		Reporter.log("BagPackLable="+actLebal);
	}
	
	@Test(priority = 1,enabled = true)
	public void verifyRemoveProductFromCartTest() throws Exception
	{
	//	String expCount = "2";
		String expCount = readData.readExcelFile(4, 2);
		String actCount = cart.verifyRemoveProductFromCart();
		Assert.assertEquals(actCount, expCount);
		Reporter.log("Product Count After Remove Product="+actCount);
	}
	
	@Test(priority = 2,enabled = true)
	public void verifyCheckOutPageOneTest() throws Exception
	{
	//	String expUrl = "https://www.saucedemo.com/checkout-step-one.html";
		String expUrl = readData.readExcelFile(4, 3);
		String actUrl = cart.verifyCheckOutPageOne();
		Assert.assertEquals(actUrl, expUrl);
		Reporter.log("URL of checkout Page One="+actUrl);
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

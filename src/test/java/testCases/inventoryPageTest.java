package testCases;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.testBase;
import Pages.inventoryPage;
import Pages.loginPage;
import utility.captureScreenShot;
import utility.readData;

public class inventoryPageTest extends testBase {

	loginPage login; //=new loginPage();
	inventoryPage invent; //=new inventoryPage();
	
	//this method is used to open the browser and land to the url
	@BeforeMethod(alwaysRun = true)
	public void setup() throws Exception
	{
		Initialization();
		invent=new inventoryPage();
		login=new loginPage();
		login.verifyLoginToTheApp();
	}
	
	//this test is used to display the product lable
	@Test(priority = 5,enabled =  false,groups = "Regression")
	public void verifyProductLebalTest()
	{
		boolean result = invent.verifyProductLebal();
		Assert.assertEquals(result, true);
		Reporter.log("Product lebal="+result);
	}
	
	//this test is used to add product in cart and get count from cart
	@Test(priority = 4,enabled = false)
	public void verifyAddToCartCountTest() throws Exception
	{
	//	String expCount = "4";
		String expCount = readData.readExcelFile(1, 0);
		String actCount = invent.verifyAddToCartCount();
		Assert.assertEquals(actCount, expCount);
		Reporter.log("Total Count="+actCount);
	}
	
	//this test is used to get item text
	@Test(priority = 3,enabled = false)
	public void verifyItemTextTest() throws Exception
	{
	//	String expText = "Sauce Labs Backpack";
		String expText = readData.readExcelFile(1, 1);
		String actText = invent.verifyItemText();
		Assert.assertEquals(actText, expText);
		Reporter.log("Item Text="+actText);
	}
	
	//this test is used to visibility of image
	@Test(priority = 2,enabled = false,groups = "Regression")
	public void verifyItemImageTest()
	{
		boolean result = invent.verifyItemImage();
		Assert.assertEquals(result, true);
		Reporter.log("Item Image="+result);
	}
	
	//this test is used to working of facebook link
	@Test(priority = 1,enabled =false)
	public void verifyFacebookLinkTest() throws Exception
	{
	//	String expUrl = "https://www.facebook.com/saucelabs";
		String expUrl = readData.readExcelFile(1, 2);
	    String actUrl = invent.verifyFacebookLink();
       	Assert.assertEquals(actUrl, expUrl);
       	Reporter.log("facebook link="+actUrl);
	}
	
	//this test is used to select the option from drop down
	@Test(enabled =false)
	public void verifySelectListTest() throws Exception
	{
		String expText = "Name (A to Z) Name (Z to A) Price (low to high) Price (high to low)";
		String actText = invent.verifySelectList();
		Assert.assertEquals(actText, expText);
		Reporter.log("select list text="+actText);
	}
	
	//this test is used to remove product and get count from cart
	@Test(enabled =  false)
	public void verifyRemoveCartCountTest() throws Exception
	{
	//	String expCount ="2";
		String expCount =readData.readExcelFile(1, 3);
		String actCount =invent.verifyRemoveCartCount();
		Assert.assertEquals(actCount, expCount);
		Reporter.log("total count after remove="+actCount);
	}
	
	//this test is used to move to cart page and get url 
	@Test(enabled = true)
	public void verifyCartPageTest() throws Exception
	{
		String expLink = "https://www.saucedemo.com/cart.html";
		String actLink = invent.verifyCartPage();
		Assert.assertEquals(actLink, expLink);
	}
	
	//this method is used to close the Browser and capture the screenshot of failed test cases
	@AfterMethod(alwaysRun = true)
	public void closeBrowser(ITestResult it) throws Exception
	{
		if(it.FAILURE==it.getStatus())
		{
			captureScreenShot.screenShot(it.getName());
		}
		driver.close();
	}
}


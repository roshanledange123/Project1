package testCases;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.testBase;
import Pages.cartPage;
import Pages.checkOutOverViewPage;
import Pages.checkOutPage;
import Pages.inventoryPage;
import Pages.loginPage;
import utility.captureScreenShot;
import utility.readData;

public class checkOutOverViewPageTest extends testBase {

	loginPage login; //=new loginPage();
	inventoryPage invent; //=new inventoryPage();
	cartPage cart; //=new cartPage();
	checkOutPage check; //=new checkOutPage();
	checkOutOverViewPage over; //=new checkOutOverViewPage();
	
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
	}
	
	@Test(priority = 1,enabled = true)
	public void verifyOverViewLableTest() throws Exception
	{
	//	String expText = "Checkout: Overview";
		String expText = readData.readExcelFile(3, 0);
		String actText = over.verifyOverViewLable();
		Assert.assertEquals(actText, expText);
		Reporter.log("Overview lable="+actText);
	}
	
	@Test(priority = 2,enabled = true)
	public void verifyPaymentInfoLabelTest()
	{
		boolean actLable = over.verifyPaymentInfoLabel();
		Assert.assertEquals(actLable, true);
		Reporter.log("Payment info lable="+actLable);
	}
	
	@Test(priority = 3,enabled = true)
	public void verifyShippingInfoLableTest()
	{
		boolean actLable = over.verifyShippingInfoLable();
		Assert.assertEquals(actLable, true);
		Reporter.log("Shipping info lable="+actLable);
	}
	
	@Test(priority = 4,enabled = true)
	public void verifyTotalPriceLableTest()
	{
		boolean actLable = over.verifyTotalPriceLable();
		Assert.assertEquals(actLable, true);
		Reporter.log("Total price lable="+actLable);
	}
		
	@Test(priority = 5,enabled = true)
	public void verifyTotalLableTest()
	{
		boolean actLable = over.verifyTotalLable();
		Assert.assertEquals(actLable, true);
		Reporter.log("Total lable="+actLable);
	}
	
	@Test(priority = 6,enabled = true)
	public void verifyCancleButtonTest() throws Exception
	{
	//	String expUrl = "https://www.saucedemo.com/inventory.html";
		String expUrl = readData.readExcelFile(3, 1);
		String actUrl = over.verifyCancleButton();
		Assert.assertEquals(actUrl, expUrl);
		Reporter.log("After clicking cancle button Url get="+actUrl);
	}
	
	@Test(priority = 7,enabled = true)
	public void verifyFinishButtonTest() throws Exception
	{
	//	String expUrl="https://www.saucedemo.com/checkout-complete.html";
		String expUrl=readData.readExcelFile(3, 2);
		String actUrl = over.verifyFinishButton();
		Assert.assertEquals(actUrl, expUrl);
		Reporter.log("After finish button Url get="+actUrl);
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

package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import Base.testBase;
import utility.readData;


public class loginPage extends testBase{
	
	//objectRepository
	@FindBy(xpath = "//div[@class=\"login_logo\"]") private WebElement loginLogoElement;
	@FindBy(xpath="//input[@id=\"user-name\"]") private WebElement userNamElement;
	@FindBy(xpath = "//input[@id=\"password\"]") private WebElement passwordElement;
    @FindBy(xpath = "//input[@id=\"login-button\"]") private WebElement loginButoonElement;
      
    
    //To connect driver with webElements
    public loginPage()
    {
    	PageFactory.initElements(driver,this);
    }
     
    //This test case to get title of loginpage
	public String verifyLoginPageTitle()
	{
		return driver.getTitle();
	}
	 
	//This test case to get url of loginpage
	public String verifyLoginPageURL()
	{
		return driver.getCurrentUrl();
	}
	 
	//This test case to get logo of loginpage
	public String verifyLoginLogo()
	{
		return loginLogoElement.getText();
	}
	
	//This test case to enter or login the page
	public String verifyLoginToTheApp() throws Exception
	{
		logger=report.createTest("loging to soucelab application");
		userNamElement.sendKeys(readData.readPropertyFile("username"));
		logger.log(Status.INFO, "username is entered");
		passwordElement.sendKeys(readData.readPropertyFile("password"));
		logger.log(Status.INFO, "password is entered");
	//  userNamElement.sendKeys("standard_user");
	//	passwordElement.sendKeys("secret_sauce");
		loginButoonElement.click();
		logger.log(Status.PASS, "Login succesfull");
		Thread.sleep(2000);
		return driver.getCurrentUrl();
	}
	
}

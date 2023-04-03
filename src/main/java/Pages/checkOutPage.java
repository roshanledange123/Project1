package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.testBase;

public class checkOutPage extends testBase {

	//ObjectRepository
	@FindBy(xpath = "//span[@class=\"title\"]") private WebElement checkOutLebalElement;
	@FindBy(xpath = "//input[@id=\"first-name\"]") private WebElement firstNameElement;
	@FindBy(xpath = "//input[@id=\"last-name\"]") private WebElement lastNameElement;
	@FindBy(xpath = "//input[@id=\"postal-code\"]") private WebElement postalCodeElement;
	@FindBy(xpath = "//button[@id=\"cancel\"]") private WebElement cancleButtonElement;
	@FindBy(xpath = "//input[@id=\"continue\"]") private WebElement continueElement;
	
	public checkOutPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyCheckOutLebal()
	{
		return checkOutLebalElement.getText();
	}
	
	public String verifyCancleButton()
	{
		cancleButtonElement.click();
		return driver.getCurrentUrl();
	}
	
	public String verifyCheckOutInformation()
	{
		firstNameElement.sendKeys("Roshan");
		lastNameElement.sendKeys("Ledange");
		postalCodeElement.sendKeys("445304");
		continueElement.click();
		return driver.getCurrentUrl();
	}
}

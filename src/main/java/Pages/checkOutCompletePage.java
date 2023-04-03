package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.testBase;

public class checkOutCompletePage extends testBase {

	//ObjectRepository
	@FindBy(xpath = "//span[@class=\"title\"]") private WebElement checkoutCompleteLablElement;
	@FindBy(xpath = "//img[@class=\"pony_express\"]") private WebElement ponyExpressElement;
	@FindBy(xpath = "//h2[@class=\"complete-header\"]") private WebElement thankuLableElement;
	@FindBy(xpath = "//button[@id=\"back-to-products\"]") private WebElement backToHomebuttonElement;
	
	public checkOutCompletePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyCheckoutCompleteLable()
	{
		return checkoutCompleteLablElement.getText();
	}
	
	public boolean verifyPonyExpressLogo()
	{
		return ponyExpressElement.isDisplayed();
	}
	
	public String verifyThankuLable()
	{
		return thankuLableElement.getText();
	}
	
	public String verifyBackToHomeButton()
	{
		backToHomebuttonElement.click();
		return driver.getCurrentUrl();
	}
}

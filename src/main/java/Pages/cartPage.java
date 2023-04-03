package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.testBase;

public class cartPage extends testBase {

	//ObjectRepository
	@FindBy(xpath = "//span[@class=\"title\"]") private WebElement cartLabElement;
	@FindBy(xpath = "(//div[@class=\"inventory_item_name\"])[1]") private WebElement bagPackLabElement;
	@FindBy(xpath = "(//button[@class=\"btn btn_secondary btn_small cart_button\"])[1]") private WebElement removeProductElement;
	@FindBy(xpath = "//button[@class=\"btn btn_action btn_medium checkout_button\"]") private WebElement checkOutButtonElement;
	@FindBy(xpath = "//a[@class=\"shopping_cart_link\"]") private WebElement cartCountElement;
	
	public cartPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyCartLabel()
	{
		return cartLabElement.getText();
	}
	
	public String verifyBagPagLabel()
	{
		return bagPackLabElement.getText();
	}
	
	public String verifyRemoveProductFromCart() throws Exception
	{
		
		removeProductElement.click();
		Thread.sleep(3000);
		return cartCountElement.getText();
	}
	
	public String verifyCheckOutPageOne()
	{
		checkOutButtonElement.click();
		return driver.getCurrentUrl();
	}
}

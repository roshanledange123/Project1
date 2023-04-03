package Pages;

import java.sql.Driver;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Base.testBase;
import net.bytebuddy.asm.Advice.Return;
import utility.selectClass;
import utility.windowHandling;

public class inventoryPage extends testBase {

	//objectRepository
	@FindBy(xpath = "//span[@class=\"title\"]") private WebElement productLogoElement;
	@FindBy(xpath = "(//button[@class=\"btn btn_primary btn_small btn_inventory\"])[1]") private WebElement addCartButton1;
	@FindBy(xpath = "(//button[@class=\"btn btn_primary btn_small btn_inventory\"])[2]") private WebElement addCartButton2;
	@FindBy(xpath = "(//button[@class=\"btn btn_primary btn_small btn_inventory\"])[3]") private WebElement addCartButton3;
	@FindBy(xpath = "//button[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]") private WebElement addCartButton4;
	@FindBy(xpath = "//a[@class=\"shopping_cart_link\"]") private WebElement addCartElement;
	@FindBy(xpath = "(//div[@class=\"inventory_item_name\"])[1]") private WebElement textItemElement;
	@FindBy(xpath = "//img[@alt=\"Sauce Labs Backpack\"]") private WebElement imgItemElement;
	@FindBy(xpath = "//a[text()=\"Twitter\"]") private WebElement twitterLinkElement;
	@FindBy(xpath = "(//span[text()=\"Sauce Labs\"])[1]") WebElement twitterElement;
	@FindBy(xpath = "//a[text()=\"Facebook\"]") private WebElement facebookElement;
	@FindBy(xpath = "//select[@class=\"product_sort_container\"]") private WebElement selectElement;
	@FindBy(xpath = "//button[@id=\"remove-sauce-labs-backpack\"]") private WebElement removeCart1;
	@FindBy(xpath = "//button[@id=\"remove-sauce-labs-bolt-t-shirt\"]") private WebElement removeCart2;
	
	//To conntect driver to webElements
	public inventoryPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//this method is used to display the product lable
	public boolean verifyProductLebal()
	{
		return productLogoElement.isDisplayed();
	}
	
	//this method is used to add product in cart and get count from cart
	public String verifyAddToCartCount() throws Exception
	{
		addCartButton1.click();
		Thread.sleep(2000);
		addCartButton2.click();
		Thread.sleep(2000);		
		addCartButton3.click();
		Thread.sleep(2000);
		addCartButton4.click();
		Thread.sleep(2000);
		System.out.println("count="+addCartElement.getText());
		return addCartElement.getText();
		
	}
	
	//this method is used to get item text
	public String verifyItemText()
	{
		return textItemElement.getText();
	}
	
	//this method is used to visibility of image
	public boolean verifyItemImage()
	{
		return imgItemElement.isDisplayed();
	}
	
	//this method is used to working of facebook link
	public String verifyFacebookLink() throws Exception
	{
		facebookElement.click();
		windowHandling.windowHandlingOfFaceebook(); 
	    return driver.getCurrentUrl();
	}
	
	//this method is used to select the option from drop down
	public String verifySelectList() throws Exception
	{
	//	Select s=new Select(selectElement);
	//  s.selectByVisibleText("Price (low to high)");
		selectClass.selectClassDropDown(selectElement, "Price (low to high)");
	    Thread.sleep(5000);
	   // System.out.println( s.selectByVisibleText("Price (low to high)"));
		return selectElement.getText();
	}
	
	//this method is used to remove product and get count from cart
	public String verifyRemoveCartCount() throws Exception
	{
		verifyAddToCartCount();
		removeCart1.click();
		removeCart2.click();
		return addCartElement.getText();
	}
	
	//this method is used to move to cart page and get url 
	public String verifyCartPage() throws Exception
	{
		addCartButton1.click();
		Thread.sleep(2000);
		addCartButton2.click();
		Thread.sleep(2000);		
		addCartButton3.click();
		Thread.sleep(2000);
		addCartElement.click();
		Thread.sleep(2000);
		return driver.getCurrentUrl();
	}
}

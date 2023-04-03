package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.testBase;
import net.bytebuddy.asm.Advice.This;

public class checkOutOverViewPage extends testBase {

	//ObjectRepository
	@FindBy(xpath = "//span[@class=\"title\"]") private WebElement overviewLablElement;
	@FindBy(xpath = "(//div[@class=\"summary_info_label\"])[1]") private WebElement paymentInfoElement;
	@FindBy(xpath = "(//div[@class=\"summary_info_label\"])[2]") private WebElement shippingInfoElement;
	@FindBy(xpath = "(//div[@class=\"summary_info_label\"])[3]") private WebElement totalPriceElement;
	@FindBy(xpath = "//div[@class=\"summary_info_label summary_total_label\"]") private WebElement totalElement;
	@FindBy(xpath = "//button[@id=\"cancel\"]") private WebElement cancleButtonElement;
	@FindBy(xpath = "//button[@id=\"finish\"]") private WebElement finishButtonElement;
	
	
	public checkOutOverViewPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyOverViewLable()
	{
		return overviewLablElement.getText();
	}
	
	public boolean verifyPaymentInfoLabel()
	{
		return paymentInfoElement.isDisplayed();
	}
	
	public boolean verifyShippingInfoLable()
	{
		return shippingInfoElement.isDisplayed();
	}
	
	public boolean verifyTotalPriceLable()
	{
		return totalPriceElement.isDisplayed();
	}
	
	public boolean verifyTotalLable()
	{
		return totalElement.isDisplayed();
	}
	
	public String verifyCancleButton()
	{
		cancleButtonElement.click();
		return driver.getCurrentUrl();
	}
	
	public String verifyFinishButton()
	{
		finishButtonElement.click();
		return driver.getCurrentUrl();
	}
}

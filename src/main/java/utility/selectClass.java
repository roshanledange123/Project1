package utility;

import javax.swing.text.Element;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class selectClass {

	public static void selectClassDropDown(WebElement ele,String value)
	{
		Select s=new Select(ele);
		s.selectByVisibleText(value);
	}
}

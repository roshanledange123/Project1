package utility;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.util.Date;
import java.util.logging.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Base.testBase;

public class captureScreenShot extends testBase {
	
	
	public static void screenShot(String methodName) throws Exception 
	{
		Date date = new Date();
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\admin\\eclipse-workspace\\project1\\ScreenShot\\"+methodName+".jpeg");
		org.openqa.selenium.io.FileHandler.copy(source, dest);
	}
}

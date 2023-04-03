package Base;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ExtentReportManager;
import utility.readData;

public class testBase {

	public ExtentReports report=ExtentReportManager.getReport();
	public ExtentTest logger;
	
	//driver is defined global by which it can be use by all page and test classes
	//driver is defined static cause only single copy of driver shared to all classes
	public  static WebDriver driver;

	//this method is used to open the browser and web application
	public void Initialization() throws Exception
	{
		String Browser=readData.readPropertyFile("browser");
	//	String Browser="chrome";
		if(Browser.equals("chrome"))
		{
			
			WebDriverManager.chromedriver().setup();
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver=new ChromeDriver(options);
		}
		else if(Browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options=new FirefoxOptions();
			options.addArguments("--remote-allow-origins=*");
			driver=new FirefoxDriver(options);
		}
		else if(Browser.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			EdgeOptions options=new EdgeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver=new EdgeDriver(options);
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	//	driver.get("https://www.saucedemo.com/");
		driver.get(readData.readPropertyFile("url"));
	}
}

package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportManager {

	public static ExtentReports report;
	public static ExtentReports getReport()
	{
	if(report==null)
	{
	
	ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter("C:\\Users\\admin\\eclipse-workspace\\project1\\ExtentReport");
    report=new ExtentReports();
	report.attachReporter(htmlReporter);
	report.setSystemInfo("OS", "windows");
	report.setSystemInfo("Environment", "Production");
	report.setSystemInfo("Build no", "7.11");
	report.setSystemInfo("Browser", "Chrome");
	
	htmlReporter.config().setDocumentTitle("UI Automation");
	htmlReporter.config().setReportName("UI Test Report");
	}
	return report;
}
}

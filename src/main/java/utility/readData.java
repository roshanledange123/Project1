package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class readData {
   
	//to read the data from property file
	public static String readPropertyFile(String value) throws Exception
	{
		Properties pro=new Properties();
		FileInputStream file=new FileInputStream("C:\\Users\\admin\\eclipse-workspace\\project1\\TestData\\config.properties");
		pro.load(file);
		return pro.getProperty(value);
	}
	//to read the data from excel file
	public static String readExcelFile(int row,int col) throws Exception
	{
		FileInputStream file= new FileInputStream("C:\\Users\\admin\\eclipse-workspace\\project1\\TestData\\Book1.xlsx");
		Sheet excleSheet = WorkbookFactory.create(file).getSheet("Sheet1");
		String value = excleSheet.getRow(row).getCell(col).getStringCellValue();
		return value;
	}
}

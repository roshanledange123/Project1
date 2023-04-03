package utility;

import java.util.Iterator;
import java.util.Set;

import Base.testBase;

public class windowHandling extends testBase {

	public static void windowHandlingOfFaceebook()
	{
		Set<String> window = driver.getWindowHandles();
		System.out.println(window.size());
		Iterator itr=window.iterator();
		//while(itr.hasNext())
		String win[]=new String[window.size()];
		for(int i=0;i<window.size();i++)
		{
			win[i]= (String) itr.next();
		}
		driver.switchTo().window(win[0]);
		System.out.println("url of win 0="+driver.getCurrentUrl());
		driver.close();
		
		driver.switchTo().window(win[1]);
	    System.out.println("url of win1="+driver.getCurrentUrl());
	}
}

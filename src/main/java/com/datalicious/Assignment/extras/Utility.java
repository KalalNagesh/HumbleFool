package com.datalicious.Assignment.extras;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {
	public static void cpaturescreenshot(WebDriver driver,String screenshotName){
		try{
			TakesScreenshot ts =(TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./Screenshots/"+screenshotName+".jpeg"));
			System.out.println("screenshots taken");
		}
		catch(Exception e){
			System.out.println("didn't captured screenshot");
		}

}
}
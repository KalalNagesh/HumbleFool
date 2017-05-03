package com.datalicious.Assignment.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.datalicious.Assignment.extras.DesiredCaps;
import com.datalicious.Assignment.extras.Utility;
import com.datalicious.Assignment.pages.DataliciousPage;
import com.datalicious.Assignment.pages.GooglePage;

public class Task1 {
	DesiredCaps abc = new DesiredCaps();
	Dimension d = new Dimension(1024,786);
	GooglePage gPage;
	DataliciousPage dPage;
	WebDriver driver;
	String url = "";
	@BeforeTest
	public void setDriver(){
			driver = new PhantomJSDriver(abc.setdesiredcaps());
	}

	@Test
	public void verifyhomepage() throws InterruptedException{
		gPage = new GooglePage(driver);
		dPage = new DataliciousPage(driver);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.google.com");
		driver.getTitle();
		Assert.assertEquals("Google", driver.getTitle());
		Utility.cpaturescreenshot(driver, "googletitle");
		gPage.putdata();
		gPage.enterdata();
		Utility.cpaturescreenshot(driver, "organicsearchResult");
		gPage.resultsearch();
		System.out.println(driver.getTitle());
		Assert.assertEquals("Smarter Marketing | Datalicious", driver.getTitle());
		driver.manage().window().setSize(d);
		dPage.cliclmenu();
		Utility.cpaturescreenshot(driver, "MenuPage");
		dPage.clickGA();
		Thread.sleep(2000);
	    url=	driver.getCurrentUrl();
		System.out.println(url);	
	}
	@AfterTest
	public String getURL(){
		return url;
	}
	public void shutDriver(){
		driver.quit();
	}
}

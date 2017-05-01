package com.datalicious.Assignment.test;

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
	
	@BeforeTest
	public void setDriver(){
			driver = new PhantomJSDriver(abc.setdesiredcaps());
	}

	@Test
	public void verifyhomepage() throws InterruptedException{
		gPage = new GooglePage(driver);
		dPage = new DataliciousPage(driver);
		
		driver.get("https://www.google.com");
		driver.getTitle();
		Assert.assertEquals("Google", driver.getTitle());
		Utility.cpaturescreenshot(driver, "googletitle");
		Thread.sleep(3000);
		gPage.putdata();
		gPage.enterdata();
		Thread.sleep(2000);
		Utility.cpaturescreenshot(driver, "organicsearchResult");
		gPage.resultsearch();
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		Assert.assertEquals("Smarter Marketing | Datalicious", driver.getTitle());
		driver.manage().window().setSize(d);
		dPage.cliclmenu();
		Thread.sleep(2000);
		Utility.cpaturescreenshot(driver, "MenuPage");
		dPage.clickGA();
		Thread.sleep(2000);
	    String url=	driver.getCurrentUrl();
		System.out.println(url);	
	}
	@AfterTest
	
	public void shutDriver(){
		driver.quit();
	}
}

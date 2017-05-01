package com.datalicious.Assignment.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.datalicious.Assignment.extras.DesiredCaps;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.proxy.CaptureType;

public class Task2 {
	String sFileName = "G:\\com.datalicious.Assignment\\HARfiles";
	public WebDriver driver;
	public BrowserMobProxy proxy;
	DesiredCaps abc = new DesiredCaps();
	
	
	@BeforeTest
	public void setUp() throws InterruptedException {
	    proxy = new BrowserMobProxyServer();
	    proxy.start(0);
	    Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
	    abc.setdesiredcaps().setCapability(CapabilityType.PROXY, seleniumProxy);
	    driver = new PhantomJSDriver(abc.setdesiredcaps());
	    proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
	    proxy.newHar("seleniumeasy.com");
	    driver.get("https://www.datalicious.com/google/analytics-360-suite/");
        
	}
	
	@Test
	public void testCaseOne() {
		System.out.println("Navigate to Google 360 page");
		System.out.println(driver.getTitle());
	}
	
	
	@AfterTest
	public void tearDown() throws FileNotFoundException {
		Har har = proxy.getHar();
		File harFile = new File(sFileName);
		try {
			har.writeTo(harFile);
		} catch (IOException ex) {
			 System.out.println (ex.toString());
		     System.out.println("Could not find file " + sFileName);
		}
		if (driver != null) {
			proxy.stop();
			driver.quit();
	

}
	}
}

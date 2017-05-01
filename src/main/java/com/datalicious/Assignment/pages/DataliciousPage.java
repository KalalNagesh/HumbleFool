package com.datalicious.Assignment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DataliciousPage {
	WebDriver driver;
	WebDriverWait wait;
	
	public DataliciousPage(WebDriver driver){
		this.driver = driver;
		wait = new WebDriverWait(driver, 30);
	}
	By menubar = By.xpath("(//div[@class='middle-bar'])[2]");
	By GA1 = By.xpath("(//a[@href='/google/analytics-360-suite/'])[1]");
	
	
	
	public void cliclmenu() {
		driver.findElement(menubar).click();
	}
	
	public void clickGA(){
		driver.findElement(GA1).click();
	}

}

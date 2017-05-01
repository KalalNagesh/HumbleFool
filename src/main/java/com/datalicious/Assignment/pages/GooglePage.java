package com.datalicious.Assignment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GooglePage {
	WebDriver driver;
	WebDriverWait wait;
	public GooglePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 30);
		}
	
	By searchbar = By.name("q");
	By organicsearch = By.cssSelector(".r>a");
	
	public void putdata() {
		driver.findElement(searchbar).sendKeys("Datalicious");
	}
	
	public void enterdata()
	{
		driver.findElement(searchbar).sendKeys(Keys.ENTER);		
	}
	
	public void resultsearch(){
		driver.findElement(organicsearch).click();
	}


}

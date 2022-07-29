package com.pg.tide.uistore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HowToRemoveStainsUI {
	
	public WebDriver driver;
	public HowToRemoveStainsUI(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By stainTypeBox = By.xpath("//input[@id='article-listing-search-input']");
	By greaseResult = By.xpath("//div[@class='article-listing-search-results']//a");
	
	
	
	
	
	public WebElement getStainTypeBox()
	{
		return driver.findElement(stainTypeBox);
	}
	public WebElement getGreaseResult()
	{
		return driver.findElement(greaseResult);
	}
	
	
	
}

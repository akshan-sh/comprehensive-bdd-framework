package com.pg.tide.uistore;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultsUI {
	
	public WebDriver driver;
	public SearchResultsUI(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By verify = By.xpath("//div[normalize-space()='for \"pods\"']");
	By popupCloser = By.xpath("//a[contains(@class,'close-link')]");
	
	public WebElement getVerify()
	{
		return driver.findElement(verify);
	}
	public List<WebElement> getPopupClosers()
	{
		return driver.findElements(popupCloser);
	}
	public WebElement getPopupCloser()
	{
		return driver.findElement(popupCloser);
	}
	
	
	
}

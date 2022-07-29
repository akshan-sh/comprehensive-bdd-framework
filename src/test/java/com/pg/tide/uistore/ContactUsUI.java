package com.pg.tide.uistore;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactUsUI {
	
	public WebDriver driver;
	public ContactUsUI(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By iframe = By.xpath("//iframe[@title='pgcontactus']");
	By callUs = By.xpath("//h1[normalize-space()='Welcome. How can we help you?']");
	By number = By.xpath("//div[contains(@class,'callUsContainer')]//a");
	By popupCloser = By.xpath("//a[contains(@class,'close-link')]");
	
	
	public WebElement getIframe()
	{
		return driver.findElement(iframe);
	}
	
	public WebElement getCallUs()
	{
		return driver.findElement(callUs);
	}
	
	public WebElement getNumber()
	{
		return driver.findElement(number);
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

package com.pg.tide.uistore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GreaseStainUI {
	
	public WebDriver driver;
	public GreaseStainUI(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By article = By.xpath("//h1[@class='article-intro-title']");
	
	
	
	
	
	public WebElement getArticle()
	{
		return driver.findElement(article);
	}
	
	
	
	
}

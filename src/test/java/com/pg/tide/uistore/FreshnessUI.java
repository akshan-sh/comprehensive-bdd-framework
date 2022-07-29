package com.pg.tide.uistore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FreshnessUI {
	
	public WebDriver driver;
	public FreshnessUI(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By febreze4in1 = By.xpath("//strong[contains(text(),'Febreze™ 4in1 Spring and Renewal')]");
	
	
	
	
	
	public WebElement getFebreze4in1()
	{
		return driver.findElement(febreze4in1);
	}
	
	
	
	
}

package com.pg.tide.uistore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SavingsCalculatorUI {
	
	public WebDriver driver;
	public SavingsCalculatorUI(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By inputBox = By.xpath("//input[@id='inputValue']");
	By costForTenWash = By.xpath("(//span[contains(text(),'$3.60')])[1]");
	By closeSticker = By.xpath("//button[@aria-label='Close Sticker']");
	
	
	
	public WebElement getInputBox()
	{
		return driver.findElement(inputBox);
	}
	public WebElement getCostForTenWash()
	{
		return driver.findElement(costForTenWash);
	}
	public WebElement getCloseSticker()
	{
		return driver.findElement(closeSticker);
	}
	
	
}

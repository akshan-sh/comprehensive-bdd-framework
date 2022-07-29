package com.pg.tide.uistore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChatUI {
	
	public WebDriver driver;
	public ChatUI(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By agree = By.xpath("//button[@type='button']");
	By firstName = By.xpath("//input[@placeholder='First Name']");
	By lastName = By.xpath("//input[@placeholder='Last Name']");
	By email = By.xpath("//input[@placeholder='Email Address']");
	By chat = By.xpath("//input[@type='button']");
	By chatBox = By.xpath("//textarea[@placeholder='Write a message...']");
	By sendChat = By.xpath("//button[@title='title']");
	By closeButton = By.xpath("//button[text()='Close']");
	
	
	
	
	public WebElement getAgree()
	{
		return driver.findElement(agree);
	}
	public WebElement getFirstName()
	{
		return driver.findElement(firstName);
	}
	public WebElement getLastName()
	{
		return driver.findElement(lastName);
	}
	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	public WebElement getChat()
	{
		return driver.findElement(chat);
	}
	public WebElement getChatBox()
	{
		return new WebDriverWait(driver, 200).until(ExpectedConditions.elementToBeClickable(chatBox));
	}
	public WebElement getSendChat()
	{
		return driver.findElement(sendChat);
	}
	public WebElement getCloseButton()
	{
		return driver.findElement(closeButton);
	}
	
	
	
	
	
	
}



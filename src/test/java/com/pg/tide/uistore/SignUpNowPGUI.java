package com.pg.tide.uistore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpNowPGUI {
	
	public WebDriver driver;
	public SignUpNowPGUI(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By enterName = By.xpath("//input[@id='name']");
	By enterEmail = By.xpath("//input[@id='email']");
	By enterPassword = By.xpath("//input[@id='password']");
	By showPassword = By.xpath("//div[@class='icon-toggle']");
	By createAccount = By.xpath("//input[@value='CREATE ACCOUNT']");
	By thanksForSigningUp = By.xpath("//p[text()='Thanks for signing up!']");
	By loginLink = By.xpath("//button[text()='Log in']");
	By loginEmail = By.xpath("//input[@id='login-email']");
	By loginPassword = By.xpath("//input[@id='login-password']");
	By loginButton = By.xpath("//input[@value='LOG IN']");
	By loggedIn = By.xpath("//div[contains(@class,'md:flex md:flex-flow-reverse')]//div//div//button[contains(@aria-label,'button')]");
	By googleCaptchaIframe = By.xpath("//iframe[@title='recaptcha challenge expires in two minutes']");
	By spamMarked = By.xpath("//div[contains(text(),'OOPS! Something went wrong. Please try again')]");
	By alreadyRegistered = By.xpath("//p[contains(text(),'sorry')]");
	public WebElement getEnterName() 
	{
		return driver.findElement(enterName);
	}

	public WebElement getEnterEmail() {
		return driver.findElement(enterEmail);
	}

	public WebElement getEnterPassword() {
		return driver.findElement(enterPassword);
	}


	public WebElement getShowPassword() {
		return driver.findElement(showPassword);
	}


	public WebElement getCreateAccount() {
		return driver.findElement(createAccount);
	}
	
	public WebElement getThanksForSigningUp() 
	{
		return driver.findElement(thanksForSigningUp);
	}
	
	public WebElement getLoginLink() 
	{
		return driver.findElement(loginLink);
	}
	
	public WebElement getLoginEmail() 
	{
		return driver.findElement(loginEmail);
	}
	
	public WebElement getLoginPassword() 
	{
		return driver.findElement(loginPassword);
	}
	
	public WebElement getLoginButton() 
	{
		return driver.findElement(loginButton);
	}
	
	public WebElement getLoggedIn()
	{
		return driver.findElement(loggedIn);
	}
	public WebElement getGoogleCaptchaIframe()
	{
		return new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(googleCaptchaIframe));
	}
	public WebElement getSpamMarked()
	{
		return new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(spamMarked));
	}
	public WebElement getAlreadyRegistered()
	{
		return new WebDriverWait(driver, 7).until(ExpectedConditions.elementToBeClickable(alreadyRegistered));
	}
	
}


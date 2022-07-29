package com.pg.tide.uistore;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeUI {
	
	public WebDriver driver;
	public HomeUI(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By searchBox = By.xpath("//input[@placeholder='Search']");
	By searchIcon = By.xpath("//button[@aria-label='Sumbit Search']");
	By contactUs = By.xpath("//a[contains(text(),'Contact Us')]");
	By register = By.xpath("//a[text()='Register']");
	By changeLang = By.xpath("//div[@aria-label='Menu']//button");
	By closeSticker = By.xpath("//button[@aria-label='Close Sticker']");
	By cantFindTheRightStain = By.xpath("//a[@data-action-detail='stain_selector_cant_find_link']");
	By signUpLink = By.xpath("//a[text()='Sign up now']");
	By canadaFrench = By.xpath("//a[text()='Canada - French']");
	By frenchCheck = By.xpath("//span[text()='Fait partie de la famille P&G']");
	By cantFindStain = By.xpath("//a[@data-action-detail='stain_selector_cant_find_link']");
	By savingsStickyBanner = By.xpath("//a[@data-action-detail='sticky_banner_cta']");
	By popupCloser = By.xpath("//a[contains(@class,'close-link')]");
	By pg = By.xpath("//img[@alt='P&G icon']");
	By downy = By.xpath("//img[@alt='Downy icon']");
	By bounce = By.xpath("//img[@alt='Bounce icon']");
	By pgEveryday = By.xpath("//img[@alt='P&G Everyday icon']");
	By liveChat = By.xpath("//a[normalize-space()='Live Chat']");
	By startChat = By.xpath("//button[@data-action-detail='chat_start_static']");
	By chatClosed = By.xpath("//button[@data-action-detail='chat_closed_click']");
	By browseByNeed = By.xpath("//img[@alt='Stained t-shirts']");
	By freshness = By.xpath("//img[@alt='Tide HE Liquid Plus Febreze ']");
	
	
	
	
	
	
	
	
	
	
	public WebElement getSearchBox()
	{
		return driver.findElement(searchBox);
	}
	public WebElement getSearchIcon()
	{
		return driver.findElement(searchIcon);
	}
	public WebElement getContactUs()
	{
		return driver.findElement(contactUs);
	}
	public WebElement getRegister()
	{
		return driver.findElement(register);
	}
	public WebElement getChangeLang()
	{
		return driver.findElement(changeLang);
	}
	public WebElement getCloseSticker()
	{
		return driver.findElement(closeSticker);
	}
	public WebElement getCantFindTheRightStain()
	{
		return driver.findElement(cantFindTheRightStain);
	}
	public WebElement getSignUpLink()
	{
		return driver.findElement(signUpLink);
	}
	public WebElement getCanadaFrench()
	{
		return driver.findElement(canadaFrench);
	}
	public WebElement getFrenchCheck()
	{
		return driver.findElement(frenchCheck);
	}
	public WebElement getCantFindStain()
	{
		return driver.findElement(cantFindStain);
	}
	public WebElement getSavingsStickyBanner()
	{
		return driver.findElement(savingsStickyBanner);
	}
	public List<WebElement> getPopupClosers()
	{
		return driver.findElements(popupCloser);
	}
	public WebElement getPopupCloser()
	{
		return new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(popupCloser));
	}
	public WebElement getPg()
	{
		return driver.findElement(pg);
	}
	public WebElement getDowny()
	{
		return driver.findElement(downy);
	}
	public WebElement getBounce()
	{
		return driver.findElement(bounce);
	}
	public WebElement getPgEveryday()
	{
		return driver.findElement(pgEveryday);
	}
	public WebElement getLiveChat()
	{
		return driver.findElement(liveChat);
	}
	public WebElement getStartChat()
	{
		return new WebDriverWait(driver, 7).until(ExpectedConditions.elementToBeClickable(startChat));
	}
	public WebElement getChatClosed()
	{
		return new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(chatClosed));
	}
	public WebElement getBrowseByNeed()
	{
		return driver.findElement(browseByNeed);
	}
	public WebElement getFreshness()
	{
		return driver.findElement(freshness);
	}
}

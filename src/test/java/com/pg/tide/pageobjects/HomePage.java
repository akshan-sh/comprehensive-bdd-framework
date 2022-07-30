package com.pg.tide.pageobjects;



import java.util.ArrayList;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.internal.AssumptionViolatedException;

import com.pg.tide.stepdefinitions.Base;
import com.pg.tide.uistore.HomeUI;
import com.pg.tide.utilities.Logging;
import com.pg.tide.utilities.Reporting;



public class HomePage {
	
	HomeUI homeUi;
	Reporting report;
	Logging log;
	public HomePage(WebDriver driver, Reporting report, Logging log)
	{
		homeUi = new HomeUI(driver);
		this.report = report;
		this.log = log;
	}
	
	
	
	public void goToPGRegistrationPage()
	{
		closePopup();
		report.getTest().info("Clicking on Register Link on homepage");
		log.getLog().info("Clicking on Register Link on homepage");
		homeUi.getRegister().click();
		
		report.getTest().info("Clicking on Signup on Registration Page");
		log.getLog().info("Clicking on Signup on Registration Page");
		homeUi.getSignUpLink().click();
		
	}
	
	public void verifyFrench()
	{	
		
	
		
		boolean result = homeUi.getFrenchCheck().isDisplayed();
		if(result)
		{	
			report.getTest().pass("Success in changing to Canada French language");
			log.getLog().trace("Success in changing to Canada French language");
		}
		else
		{
			report.getTest().fail("Failure in changing to Canada French language");
			log.getLog().fatal("Failure in changing to Canada French language");
		}
	}
	
	public void clickOnCanadaFrench()
	{
		report.getTest().info("Clicking on Canada french from the available langs in the popup");
		log.getLog().info("Clicking on Canada french from the available langs in the popup");
		homeUi.getCanadaFrench().click();
	}
	
	public void clickOnChangeLanguageButton()
	{
		closePopup();
		report.getTest().info("Clicking on US-English on homepage to change language");
		log.getLog().info("Clicking on US-English on homepage to change language");
		
		homeUi.getChangeLang().click();
	}
	
	public void clickOnCantFindStain()
	{
		closePopup();
		
		report.getTest().info("Clicking on Can't find the right stain");
		log.getLog().info("Clicking on Can't find the right stain");
		homeUi.getCantFindStain().click();
	}
	
	public void clickOnSavingsBanner()
	{	closePopup();
	
		report.getTest().info("Clicking on the sticker banner for saving calcualtor page");
		log.getLog().info("Clicking on the sticker banner for saving calcualtor page");		
		homeUi.getSavingsStickyBanner().click();
	}
	
	public void closePopup()
	{	
		
		Actions action = new Actions(homeUi.driver);
		try {
			
			action.moveToElement(homeUi.getPopupCloser()).click().build().perform();
			report.getTest().info("Closing popup");
			log.getLog().info("Closing popup");
		}
		catch(Exception e)
		{
			report.getTest().info("No initial popup found, great");
			log.getLog().info("No initial popup found, great");

		}
		
	}
	
	public void clickOnContactUs()
	{
		closePopup();
		
		report.getTest().info("Clicking on ContactUs link on top of the page");
		log.getLog().info("Clicking on ContactUs link on top of the page");
		homeUi.getContactUs().click();
	}
	
	public void search(String query)
	{
		closePopup();
		
		report.getTest().info("Entering text on the search box");
		log.getLog().info("Entering text on the search box");
		homeUi.getSearchBox().sendKeys(query);
		
		report.getTest().info("Clicking on the search icon");
		log.getLog().info("Clicking on the search icon");
		homeUi.getSearchIcon().click();
	}
	public void openPartCompanySites()
	{
		closePopup();
		
		Actions action = new Actions(homeUi.driver);
		report.getTest().info("Opening all the part company websites using control+click");
		log.getLog().info("Opening all the part company websites using control+click");
		action.moveToElement(homeUi.getPg()).keyDown(Keys.CONTROL).click().build().perform();
		action.moveToElement(homeUi.getDowny()).keyDown(Keys.CONTROL).click().build().perform();
		action.moveToElement(homeUi.getBounce()).keyDown(Keys.CONTROL).click().build().perform();
		action.moveToElement(homeUi.getPgEveryday()).keyDown(Keys.CONTROL).click().build().perform();
	}
	
	public void verifyPartCompanySites() throws InterruptedException
	{	
		
		
		String [] arr = {"https://www.pggoodeveryday.com/","https://www.bouncefresh.com/en-us","https://downy.com/en-us","https://us.pg.com/"};
		ArrayList<String> tabs = new ArrayList<String>(homeUi.driver.getWindowHandles());
		for(int i = 1; i<tabs.size();i++)
		{
			homeUi.driver.switchTo().window(tabs.get(i));
			if(homeUi.driver.getCurrentUrl().contains(arr[i-1]))
			{
				report.getTest().info(homeUi.driver.getTitle() + "page VERIFIED NOW CLOSING IT");
				log.getLog().info(homeUi.driver.getTitle() + "page VERIFIED NOW CLOSING IT");
				homeUi.driver.close();
			}
			else
			{
				System.out.println((homeUi.driver.getCurrentUrl() + "different url than expected"));
				report.getTest().fail(homeUi.driver.getTitle() + "different url than expected");
				log.getLog().error(homeUi.driver.getTitle() + "different url than expected");
				Assert.fail();
			}

		}
	}
	
	public void navigateToChatWindow() throws InterruptedException
	{	
		closePopup();
		
		Thread.sleep(3000l);
		
		report.getTest().info("Clicking on Live chat option on top of homepage");
		log.getLog().info("Clicking on Live chat option on top of homepage");
		homeUi.getLiveChat().click();
		
		Actions action = new Actions(homeUi.driver);
		
		try{
			if(!homeUi.getStartChat().isDisplayed())
			{	
				action.moveToElement(homeUi.getChatClosed()).build().perform();
				
				report.getTest().skip("Chat is closed right now, come between 10am to 6pm");
				log.getLog().warn("Chat is closed right now, come between 10am to 6pm");
				Base.skipFlag = true;
				throw new AssumptionViolatedException("Chat is closed right now, come between 10am to 6pm");
				
			}
		} catch(AssumptionViolatedException e) {
			
			throw new AssumptionViolatedException("Chat is closed right now, come between 10am to 6pm");
			
		} catch(NoSuchElementException e) {
			report.getTest().skip("Chat is closed right now");
			report.getTest().skip(e.getMessage());
			throw new AssumptionViolatedException("Chat is closed right now, come between 10am to 6pm");
		}catch(TimeoutException e) {
			report.getTest().info("Chat is closed right now or Button taking too much time to load");
			Assert.fail("Chat is closed right nowButton taking too much time to load");
		}
		catch(Exception e) {
			report.getTest().fail("Something unexpected happened");
			report.getTest().info(e.getMessage());
			Assert.fail("Something unexpected happened");
		}
		
		
		
		action.moveToElement(homeUi.getStartChat()).build().perform();
		action.moveToElement(homeUi.getStartChat()).click().build().perform();
		report.getTest().pass("Successfully clicked on Start Chat");
		log.getLog().info("Successfully clicked on Start Chat");
		
		
		
		ArrayList<String> tabs2 = new ArrayList<String>(homeUi.driver.getWindowHandles());
		homeUi.driver.switchTo().window(tabs2.get(1));
		

	}
	
	public void goToFreshnessPageThroughBrowseByNeed() throws InterruptedException
	{	closePopup();
	
		Actions action = new Actions(homeUi.driver);
		
		report.getTest().info("Scrolling down to browse by need section");
		log.getLog().info("Scrolling down to browse by need section");
		action.moveToElement(homeUi.getBrowseByNeed()).build().perform();
		Thread.sleep(200l);
		action.moveToElement(homeUi.getBrowseByNeed()).build().perform();
		
		
		action.moveToElement(homeUi.getBrowseByNeed()).click().build().perform();
		report.getTest().info("Clicked on browse by need section");
		log.getLog().info("Clicked on browse by need section");
		
		Thread.sleep(2000l);
		
		try {
			
		action.moveToElement(homeUi.getFreshness()).click().build().perform();
		report.getTest().info("Clicked on Freshness/Scent");
		log.getLog().info("Clicked on Freshness/Scent");
		
	} catch(Exception e) {
		
		report.getTest().fail("UI animation lagging");
		log.getLog().info("UI animation lagging");
	}
		
	}
	
	
}

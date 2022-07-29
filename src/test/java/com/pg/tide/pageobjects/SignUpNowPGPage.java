package com.pg.tide.pageobjects;



import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.internal.AssumptionViolatedException;

import com.pg.tide.stepdefinitions.Base;
import com.pg.tide.uistore.SignUpNowPGUI;
import com.pg.tide.utilities.Logging;
import com.pg.tide.utilities.Reporting;




public class SignUpNowPGPage {
	
	SignUpNowPGUI nowUi;
	Reporting report;
	Logging log;
	public SignUpNowPGPage(WebDriver driver, Reporting report, Logging log)
	{
		nowUi = new SignUpNowPGUI(driver);
		this.report = report;
		this.log = log;
	}
	
	
	public void signUp(String name, String email, String password)
	{	
		nowUi.getEnterName().sendKeys(name);
		report.getTest().info("Entered Name");
		nowUi.getEnterEmail().sendKeys(email);
		report.getTest().info("Entered Email");
		nowUi.getEnterPassword().sendKeys("P@ss1234");
		report.getTest().info(password);
		nowUi.getShowPassword().click();
		report.getTest().info("Password made visible");
		
		log.getLog().info("Entered all the credentials from the excel file");
		
		nowUi.getCreateAccount().click();
		report.getTest().info("Clicked on create account");
		log.getLog().info("Clicked on created account");
		
		
		
		
	
	}
	public void verifySignup()
	{
		
		try {
			if(nowUi.getGoogleCaptchaIframe().isDisplayed())
			{
				report.getTest().skip("Skipped due to google captcha");
				log.getLog().warn("Skipped due to google captcha");
				Base.skipFlag = true;
				throw new AssumptionViolatedException("Skipped due to google captcha");
				
			}
		} catch(AssumptionViolatedException e) {
			throw new AssumptionViolatedException("Skipped due to google captcha");
			
		} catch(Exception e ) {
			//carrying on
		} 
		
		try {
			if(nowUi.getAlreadyRegistered().isDisplayed())
			{
				report.getTest().fail("User already registered");
				log.getLog().warn("User already registered");
				Assert.fail("User already registered");
				
			}
			
		} catch(NoSuchElementException e ) {
			//carrying on
		}
		
		try {
			if(nowUi.getThanksForSigningUp().isDisplayed())
			{
				report.getTest().pass("Signup successfull");
				log.getLog().trace("Signup successfull");
			}else {
				report.getTest().fail("Can't verify successfull signup");
				log.getLog().fatal("Can't verify successfull signup");
				Assert.fail("Could not verify signup");
			}
				
		}catch(Exception e) {
			report.getTest().fail("Could not verify signup");
			log.getLog().fatal("Could not verify signup");
			Assert.fail("Could not verify signup");
		}
		
	}
	
	public void clickOnLoginLink()
	{
		nowUi.getLoginLink().click();
		report.getTest().info("Clicked on Login link");
		
	}
	public void login(String email, String password)
	{
		
		nowUi.getLoginEmail().sendKeys(email);
		report.getTest().info("Entered Email address");
		nowUi.getLoginPassword().sendKeys(password);
		report.getTest().info("Entered Password");
		nowUi.getLoginButton().click();
		
		log.getLog().info("Entered all the credentials from the excel file");
		
		report.getTest().info("Clicked on Login button");
		log.getLog().info("Clicked on Login button");
		
		
		
	}
	
	public void verifyLogin()
	{	
		
		try {
			if(nowUi.getGoogleCaptchaIframe().isDisplayed())
			{
				report.getTest().skip("Skipped due to google captcha");
				log.getLog().warn("Skipped due to google captcha");
				Base.skipFlag = true;
				throw new AssumptionViolatedException("Skipped due to google captcha");
				
			}
		} catch(AssumptionViolatedException e) {
			throw new AssumptionViolatedException("Skipped due to google captcha"); 
		} catch(Exception e ) {
			//carrying on
			
		} 
		
		try {
			if(nowUi.getSpamMarked().isDisplayed())
			{
				report.getTest().fail("System marked us as spam probably");
				log.getLog().warn("System marked us as spam probably");
				Assert.fail("System marked us as spam probably");
				
			}
			
		} catch(Exception e ) {
			//carrying on
		}
		
		
		
		
		
		try {
		
		
		if(nowUi.getLoggedIn().isDisplayed())
		{
			report.getTest().pass("Login is Successfull");
			log.getLog().trace("Login is Successfull");
		}
		}
		catch(Exception e) {
		
			report.getTest().fail("Unable to verify login");
			log.getLog().fatal("Unable to verify login");
	}
	}
	
	
	
	
	
}

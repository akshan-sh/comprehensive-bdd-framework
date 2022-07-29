package com.pg.tide.pageobjects;



import org.openqa.selenium.WebDriver;
import org.junit.Assert;

import com.pg.tide.uistore.ContactUsUI;
import com.pg.tide.utilities.Logging;
import com.pg.tide.utilities.Reporting;





public class ContactUsPage {
	
	ContactUsUI contactUi;
	Reporting report;
	Logging log;
	public ContactUsPage(WebDriver driver, Reporting report, Logging log)
	{
		contactUi = new ContactUsUI(driver);
		this.report = report;
		this.log = log;
	}
	
	public void checkIFrameVisibility() throws InterruptedException
	{	
		try
	{
		if(contactUi.getIframe().isDisplayed()) {
			
			report.getTest().pass("Contact Optons iframe window is present");
			log.getLog().trace("Contact Optons iframe window is present");
		}
			
	}
	catch(Exception e)
	{
		report.getTest().fail("Unable to locate iframe window with contact options");
		log.getLog().fatal("Unable to locate iframe window with contact options");
		Assert.fail();
	}

		
		
	}
	
	public void closePopup()
	{
		if(contactUi.getPopupCloser().isDisplayed())
			contactUi.getPopupCloser().click();
		
		
	}
	
	
	
}

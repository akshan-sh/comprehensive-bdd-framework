package com.pg.tide.pageobjects;



import org.openqa.selenium.WebDriver;
import org.junit.Assert;

import com.pg.tide.uistore.GreaseStainUI;
import com.pg.tide.utilities.Logging;
import com.pg.tide.utilities.Reporting;




public class GreaseStainPage {
	
	GreaseStainUI greaseUi;
	Reporting report;
	Logging log;
	public GreaseStainPage(WebDriver driver, Reporting report, Logging log)
	{
		greaseUi = new GreaseStainUI(driver);
		this.report = report;
		this.log = log;
	}
	
	public void isGreaseContentPresent() throws InterruptedException
	{	
		try
		{
			if(greaseUi.getArticle().getText().contains("Grease")) {
				
				report.getTest().pass("Content related to Grease stain found in the article page");
				log.getLog().trace("Content related to Grease stain found in the article page");
				
			}
			
		}
		catch(Exception e)
		{
			report.getTest().fail("Content related to Grease stain NOT found in the article page");
			log.getLog().fatal("Content related to Grease stain NOT found in the article page");
			Assert.fail("Content related to Grease stain NOT found in the article page");
		}
		
		
	}
	
	
	
	
	
}

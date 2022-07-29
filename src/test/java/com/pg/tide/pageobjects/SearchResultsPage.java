package com.pg.tide.pageobjects;



import org.openqa.selenium.WebDriver;
import org.junit.Assert;

import com.pg.tide.uistore.SearchResultsUI;
import com.pg.tide.utilities.Logging;
import com.pg.tide.utilities.Reporting;





public class SearchResultsPage {
	
	SearchResultsUI searchUi;
	Reporting report;
	Logging log;
	public SearchResultsPage(WebDriver driver, Reporting report, Logging log)
	{
		searchUi = new SearchResultsUI(driver);
		this.report = report;
		this.log = log;
	}
	
	
	public void checkSearchResults()
	{	
		try
		{
			if(searchUi.getVerify().isDisplayed())
			{
				report.getTest().pass("pods contained in search results");
				log.getLog().trace("pods contained in search results");
				
			}
		}
		catch(Exception e)
		{
			report.getTest().fail("pods not found in search result");
			log.getLog().fatal("pods not found in search result");
			Assert.fail("pods not found in search result");
		}
		
	}
	
	
	
}

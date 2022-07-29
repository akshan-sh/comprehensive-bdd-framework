package com.pg.tide.pageobjects;



import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;

import com.pg.tide.uistore.SavingsCalculatorUI;
import com.pg.tide.utilities.Logging;
import com.pg.tide.utilities.Reporting;




public class SavingsCalculatorPage {
	
	SavingsCalculatorUI savingsUi;
	Reporting report;
	Logging log;
	public SavingsCalculatorPage(WebDriver driver, Reporting report, Logging log)
	{
		savingsUi = new SavingsCalculatorUI(driver);
		this.report = report;
		this.log = log;
	}
	
	public void verfiySavings()
	{		
			
			
			try
			{
				if(savingsUi.getCostForTenWash().isDisplayed())
				{
					report.getTest().pass("Accurate cost calculation");
					log.getLog().trace("Accurate cost calculation");
				}
			}
			catch(Exception e)
			{
				report.getTest().fail("Something went wrong");
				log.getLog().fatal("Something went wrong");
				Assert.fail("Something went wrong");
			}
			
	}
	
	public void calculateSavingsForTenWash(String numberOfWash)
	{
		savingsUi.getInputBox().sendKeys(numberOfWash, Keys.ENTER);
		report.getTest().info("Entered 10 in the number of washes");
		log.getLog().info("Entered 10 in the number of washes");
	}
	
	
}

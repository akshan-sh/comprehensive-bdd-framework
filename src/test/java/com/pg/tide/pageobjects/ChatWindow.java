package com.pg.tide.pageobjects;



import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;

import com.pg.tide.uistore.ChatUI;
import com.pg.tide.utilities.Logging;
import com.pg.tide.utilities.Reporting;






public class ChatWindow {
	
	ChatUI chatUi;
	Reporting report;
	Logging log;
	public ChatWindow(WebDriver driver, Reporting report, Logging log)
	{
		chatUi = new ChatUI(driver);
		this.report = report;
		this.log = log;
	}
	
	public void continueChat(String firstName, String lastName, String email) 
	{	
		report.getTest().info("Clicking on agreeing and continue");
		log.getLog().info("Clicking on agreeing and continue");
		chatUi.getAgree().click();
		
		report.getTest().info("Entering first name");
		log.getLog().info("Entering first name");
		chatUi.getFirstName().sendKeys(firstName);
		
		report.getTest().info("Entering last name");
		log.getLog().info("Entering last name");
		chatUi.getLastName().sendKeys(lastName);
		
		report.getTest().info("Entering email address");
		log.getLog().info("Entering email address");
		chatUi.getEmail().sendKeys(email);
		
		report.getTest().info("Clicking on Chat Button");
		log.getLog().info("Clicking on Chat Button");
		chatUi.getChat().click();
		
	}
		
		
	public void verifyAndSendMessage(String hiMessage) throws InterruptedException
	{
		try {
		chatUi.getChatBox().sendKeys(hiMessage);
		}
		catch(NoSuchElementException e)
		{	
			report.getTest().fail("Agents are not available");
			log.getLog().error("Agents are not available");
			Assert.fail();
		}
		catch(Exception e)
		{
			report.getTest().fail("Chat persons are busy or there is high traffic for chat service");
			log.getLog().error("Chat persons are busy or there is high traffic for chat service");
			Assert.fail();
			
		}
		report.getTest().info("Entering initial chat message");
		log.getLog().info("Entering initial chat message");
		
		Thread.sleep(1000l);
		
		report.getTest().info("Sending the message typed in the chat box");
		log.getLog().info("Sending the message typed in the chat box");
		chatUi.getSendChat().click();
		
	}
	
	
	
	
	
}

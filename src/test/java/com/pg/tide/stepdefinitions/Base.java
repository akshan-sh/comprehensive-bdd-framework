package com.pg.tide.stepdefinitions;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.pg.tide.utilities.PropertyReading;




public class Base 
{	PropertyReading gp = new PropertyReading();
	WebDriver driver;
	public static boolean skipFlag = false;
	
	public WebDriver initializeDriver() throws IOException
	{
		System.setProperty("webdriver.chrome.driver",gp.getFromProperty("chromePath") );
		driver = new ChromeDriver();
		return driver;
	}
	
	public WebDriver navigateDriver() throws IOException
	{
		driver.get(gp.getFromProperty("tideHome"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}
	
	public WebDriver getDriver()
	{
		return this.driver;
	}
}



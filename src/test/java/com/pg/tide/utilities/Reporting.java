package com.pg.tide.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reporting {
	
	ExtentReports extent;
	ExtentSparkReporter spark;
	String timeStamp;
	public ExtentTest test;

	//initialization block
	{
	
	timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
	extent = new ExtentReports();
	spark = new ExtentSparkReporter("Reports/" + timeStamp + ".html");
	getExtent().attachReporter(spark);
	spark.config().setDocumentTitle("Tide Test Report");
	}

	public ExtentReports getExtent() {
		return this.extent;
	}
	public ExtentTest getTest()
	{
		return this.test;
	}
	
}

package com.pg.tide.cucumberoptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/com/pg/tide/features",
				glue = "com.pg.tide.stepdefinitions",
				tags = "@now",
				dryRun = false,
				/*for pretty reporting*/
				plugin = {"pretty", "html:target/report.html", 
				/*for extent reporting*/
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
				monochrome = true)
public class TestRunner {

}

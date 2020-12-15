package com.runner;

import java.io.File;

import org.testng.annotations.AfterClass;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(strict = true, features = { "src/test/resources/Feature/Amazon.feature" }, plugin = { "pretty:STDOUT",
		"html:D:\\Aseef_Workspace\\Rest\\test-output\\Reports\\cucumber-pretty",
		"json:D:\\Aseef_Workspace\\Rest\\test-output\\Reports\\cucumber-json\\cucumber.json",
		"com.cucumber.listener.ExtentCucumberFormatter:test-output/Reports/cucumber-extent/report.html" }, monochrome = true, glue = {
				"" }, dryRun = false)

public class TestRunnerDemo extends AbstractTestNGCucumberTests {
	
	@AfterClass
public void setup() {
	
		
		Reporter.loadXMLConfig(new File("D:\\Aseef_Workspace\\Cucumber\\extent-config.xml"));
		// Reporter.setSystemInfo("Test User", System.getProperty("user.name"));
		Reporter.setSystemInfo("User Name", "Aseef");
		Reporter.setSystemInfo("Application Name", "Amazon");
		Reporter.setSystemInfo("Operating System Type", System.getProperty("os.name").toString());
		Reporter.setSystemInfo("Environment", "Production");
		Reporter.setTestRunnerOutput("Test Execution Cucumber Report");
		
		
	}
}

//Strict : it will try to find the pending steps or missing steps, and fail if not find
//feature :need to provide path of feature
//plugin : will contains the reporting features
//tag : for tagged hookes for scenarios
//monochrome : enhance the readbility
//glue : provide your stepdefinition class path
// dryrun : will check if u have pending or missing steps, but will not fail scripts
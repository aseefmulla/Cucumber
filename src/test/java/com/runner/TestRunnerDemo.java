package com.runner;

import java.io.File;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(strict = true, features = { "src/test/resources/Feature/Amazon.feature" }, plugin = { "pretty:STDOUT",
		"html:C:\\Users\\ASIFM\\Downloads\\MavenCucucmberSelenium\\test-output\\Reports\\cucumber-pretty",
		"json:C:\\Users\\ASIFM\\Downloads\\MavenCucucmberSelenium\\test-output\\Reports\\cucumber-json\\cucumber.json",
		"com.cucumber.listener.ExtentCucumberFormatter:C:\\Users\\ASIFM\\Downloads\\MavenCucucmberSelenium\\test-output\\Reports\\cucumber-extent\\report.html" }, monochrome = true, 
		glue = {""}, 
		dryRun = false
		)

public class TestRunnerDemo extends AbstractTestNGCucumberTests {
	@AfterClass
	public static void setup()
	{
	Reporter.loadXMLConfig(new File("C:\\Users\\ASIFM\\Downloads\\MavenCucucmberSelenium\\extent-config.xml"));
	//Reporter.setSystemInfo("Test User", System.getProperty("user.name"));
	Reporter.setSystemInfo("User Name", "Aseef");
	Reporter.setSystemInfo("Application Name", "Amazon");
	Reporter.setSystemInfo("Operating System Type", System.getProperty("os.name").toString());
	Reporter.setSystemInfo("Environment", "Production");
	Reporter.setTestRunnerOutput("Test Execution Cucumber Report");
	}
//	@Before
//	public void setup1() {
//		System.out.println("Test started: ");
//	}
//	@After
//	public void setup2(ITestResult result) {
//		System.out.println("Test ended: ");
//	}
	}

//Strict : it will try to find the pending steps or missing steps, and fail if not find
//feature :need to provide path of feature
//plugin : will contains the reporting features
//tag : for tagged hookes for scenarios
//monochrome : enhance the readbility
//glue : provide your stepdefinition class path
// dryrun : will check if u have pending or missing steps, but will not fail scripts
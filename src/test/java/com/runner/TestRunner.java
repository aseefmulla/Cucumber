package com.runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(strict = true, features = { "src/test/resources/Feature/Amazon.feature" }, plugin = { "pretty:STDOUT",
		"html:D:\\Aseef_Workspace\\Rest\\test-output\\Reports\\cucumber-pretty",
		"json:D:\\Aseef_Workspace\\Rest\\test-output\\Reports\\cucumber-json\\cucumber.json",
		"com.cucumber.listener.ExtentCucumberFormatter:D:\\Aseef_Workspace\\Rest\\test-output\\Reports\\cucumber-extent\\report.html" }, monochrome = true, glue = {
				"" }, dryRun = false)
public class TestRunner {
private TestNGCucumberRunner testNGCucumberRunner;

@BeforeClass(alwaysRun = true)
public void setUpClass() throws Exception {
    testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
}


@AfterClass(alwaysRun = true)
public void tearDownClass() throws Exception {
    testNGCucumberRunner.finish();
}
 }

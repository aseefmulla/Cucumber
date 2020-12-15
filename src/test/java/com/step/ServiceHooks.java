package com.step;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.cucumber.listener.Reporter;
import com.utility.Utility;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class ServiceHooks extends Utility{

	

	@Before
	public void beforeScenario(Scenario scenario) {
		System.out.println(scenario.getName() + " is started");
	}

	@After()
	public void tearDown(Scenario scenario) throws IOException {
		if (scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			TakesScreenshot ts = (TakesScreenshot) driver;
			File sourcePath = ts.getScreenshotAs(OutputType.FILE);

			File destinationPath = new File(
					System.getProperty("user.dir") + "/test-output/Screenshots/" + screenshotName + ".png");

			FileUtils.copyFile(sourcePath, destinationPath);

			Reporter.addScreenCaptureFromPath(destinationPath.toString());
			// Reporter.addScreenCast(destinationPath.toString());

		} else {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			TakesScreenshot ts = (TakesScreenshot) driver;
			File sourcePath = ts.getScreenshotAs(OutputType.FILE);

			File destinationPath = new File(
					System.getProperty("user.dir") + "/test-output/Screenshots/" + screenshotName + ".png");

			FileUtils.copyFile(sourcePath, destinationPath);

			Reporter.addScreenCaptureFromPath(destinationPath.toString());
			// Reporter.addScreenCast(destinationPath.toString());
		}
		driver.quit();
	}
}

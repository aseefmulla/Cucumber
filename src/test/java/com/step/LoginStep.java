package com.step;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.pages.HomePage;
import com.utility.Utility;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStep {

	Utility util = new Utility();

	WebDriver driver;
	
	@Before
	public void tear(Scenario scenario) {
		System.out.println("The scenario :"+scenario.getName());
	}
	
	@After
	public void setup(Scenario scenario) {
		scenario.write("Finished scenario");
		if(scenario.isFailed()) {
			scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES), "image/png");
		}
	}
	
	

	@Given("^user open the browser and launch facebook application$")
	public void user_open_the_browser_and_launch_facebook_application() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Driver/chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

		driver.get("https://www.facebook.com/login");
	}

	@Given("^user enters abc(\\d+) and wer(\\d+)$")
	public void user_enters_abc_and_wer(String user, String pass) {
		try {
			Thread.sleep(3*1200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.id("email")).sendKeys(user);
		driver.findElement(By.id("pass")).sendKeys(pass);
		
		
	}

	@When("^user clicks on submit button$")
	public void user_clicks_on_submit_button() {
		driver.findElement(By.id("loginbutton")).click();
		
		
	}

	@Then("^application displays user and pass is incorrect$")
	public void application_displays_user_and_pass_is_incorrect() {
	try {
		Thread.sleep(3*1200);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _62c3 _4jy4 _517h _51sy']")).isDisplayed();
	}

	@Then("^Close the browser$")
	public void close_the_browser() {
		driver.quit();
	}

}
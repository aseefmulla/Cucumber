package com.step;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.pages.HomePage;
import com.utility.Utility;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStep extends HomePage {

	

	@Given("^user open the browser and launch facebook application$")
	public void user_open_the_browser_and_launch_facebook_application() {
		OpenFacebook();
	}

	@Given("^user enters username ([^\\\\\\\"]*)$")
	public void user_enters_username_abdf(String username) throws InterruptedException {
		Thread.sleep(1200);
		sendUsername(username);
		
	}
	
	@Given("^user enters password ([^\\\\\"]*)$")
	public void user_enters_password_werty(String password) throws InterruptedException {
		sendPassword(password);
	}

	@When("^user clicks on submit button$")
	public void user_clicks_on_submit_button() {
		click();
	}

	@Then("^application displays user and pass is incorrect$")
	public void application_displays_user_and_pass_is_incorrect() throws InterruptedException {
		Thread.sleep(1200);
		errorMsg();

	}

	@Then("^Close the browser$")
	public void close_the_browser() {
		driver.close();
	}
}
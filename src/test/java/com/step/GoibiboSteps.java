package com.step;

import com.pages.GoibiboHomePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoibiboSteps extends GoibiboHomePage {

	@Given("^user open browser and launch goibibo application$")
	public void user_open_browser_and_launch_goibibo_application() {
		goibiboAmazon();
	}

	@When("^user click on goibibo login page$")
	public void user_click_on_goibibo_login_page() throws InterruptedException {
		click();
		Thread.sleep(1200);
	}

	@Then("^goibibo login page displayed$")
	public void goibibo_login_page_displayed() {

		// Assert.assertEquals(true,goibiboPage());
		goibiboPage();

	}

	// Scenario2
	@Given("^selects from ([^\"]*) and to ([^\\\"]*)$")
	public void selects_from_Bangalore_and_to_Delhi(String from,String to) {
		selectFromAndTo(from,to);
	}

	@Given("^select departure ([^\\\"]*)$")
	public void select_departure_April(String depdate) {
		datePicker(depdate);
	}

	@When("^user clicks search button$")
	public void user_clicks_search_button() {
		searchButton();
	}

	@Then("^click on round trip radio button$")
	public void click_on_round_trip_radio_button_displayed() {
		selectRadioButton();
	}

	@Then("^select round trip radio button is selected$")
	public void select_round_trip_radio_butto() {
		IsSelectedRadioButton();
	}

}

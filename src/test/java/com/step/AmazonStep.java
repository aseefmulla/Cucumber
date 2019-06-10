package com.step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.pages.AmazonHomePgae;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AmazonStep extends AmazonHomePgae {

	@Given("^user open browser and launch amazon application$")
	public void user_open_browser_and_launch_amazon_application() throws InterruptedException {
		OpenAmazon();
		Thread.sleep(1200);
	}

	@When("^user click on login page$")
	public void user_click_on_login_page() {
		click();
	}

	@Then("^amazon login page displayed$")
	public void amazon_login_page_displayed() throws Throwable {
		Assert.assertEquals(true, amazomPage());
	}

	// scenario 2

	@Given("^user selects ([^\"]*)$")
	public void user_selects_Books(String dropdown) {
		dropDownValueSelect(dropdown);
	}

	@Given("^user enter ([^\\\"]*)$")
	public void user_enter_freedom(String searchvalue) {
		sendValue(searchvalue);
		// driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys(searchvalue);
	}

	@When("^user click on submit button of amazon$")
	public void user_click_on_submit_button_of_amazon() {
		clickOnSubmitButton();
	}

	@Then("^application display ([^\\\"]*) result for search$")
	public void application_display_search_result_for_search(String searchvalue) {
		Assert.assertTrue(displaySearchResult(searchvalue));
	}

	// scenario3

	@Given("^user clicks on random search result link$")
	public void user_clicks_on_random_search_result_link() throws InterruptedException {
		Thread.sleep(3000);
		clickOnRandomLink();

	}

	@When("^user click on add to cartbutton$")
	public void user_click_on_add_to_cartbutton() {
		clickAddCartbutton();
	}

	@Then("^item is adde to cart$")
	public void item_is_adde_to_cart() {
		Assert.assertTrue(addedToCart());
	}

	@Given("^verify product details$")
	public void verify_product_details() throws InterruptedException {
		Assert.assertEquals("\r\n" + "Boat Rockerz 400 On-Ear Bluetooth Headphones (Carbon Black)", productDetails());

	}

	@Given("^swich back to main window$")
	public void swich_back_to_main_window() throws InterruptedException {
		swichWindow(1);

	}

	@Given("^close amazon site$")
	public void close_amazon_site() {
		 driver.close();

	}

}

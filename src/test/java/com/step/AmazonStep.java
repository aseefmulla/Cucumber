package com.step;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.pages.AmazonHomePage;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AmazonStep {
	
	AmazonHomePage amazonPage=new AmazonHomePage();
	WebDriver driver;

	@Given("^user open browser and launch amazon application$")
	public void user_open_browser_and_launch_amazon_application() throws InterruptedException {
		amazonPage.OpenAmazon();
		Thread.sleep(1200);
	}

	@When("^user click on login button$")
	public void user_click_on_login_page() throws InterruptedException {
		amazonPage.click();
	}

	@Then("^amazon login page displayed$")
	public void amazon_login_page_displayed() throws Throwable {
		Assert.assertEquals(true, amazonPage.amazomPage());
	}

//	// scenario 2

	@Given("^user selects ([^\"]*)$")
	public void user_selects_Books(String dropdown) {
		amazonPage.dropDownValueSelect(dropdown);
	}

	@Given("^user enter ([^\\\"]*)$")
	public void user_enter_freedom(String searchvalue) {
		amazonPage.sendValue(searchvalue);
		// driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys(searchvalue);
	}

	@When("^user click on submit button of amazon$")
	public void user_click_on_submit_button_of_amazon() {
		amazonPage.clickOnSubmitButton();
	}

	@Then("^application display ([^\\\"]*) result for search$")
	public void application_display_search_result_for_search(String searchvalue) {
		Assert.assertTrue(amazonPage.displaySearchResult(searchvalue));
	}

	// scenario3

	@Given("^user clicks on random search result link$")
	public void user_clicks_on_random_search_result_link() throws InterruptedException {
		Thread.sleep(3000);
		amazonPage.clickOnRandomLink();

	}

	@When("^user click on add to cartbutton$")
	public void user_click_on_add_to_cartbutton() {
		amazonPage.clickAddCartbutton();
	}

	@Then("^item is adde to cart$")
	public void item_is_adde_to_cart() {
		Assert.assertTrue(amazonPage.addedToCart());
	}

	@Given("^verify product details$")
	public void verify_product_details() throws InterruptedException {
		Assert.assertEquals("\r\n" + "Boat Rockerz 400 On-Ear Bluetooth Headphones (Carbon Black)", amazonPage.productDetails());

	}

	@Given("^swich back to main window$")
	public void swich_back_to_main_window() throws InterruptedException {
		amazonPage.swichWindow(1);

	}

	@Given("^close amazon site$")
	public void close_amazon_site() {
	
		amazonPage.closeBrowser();

	}

}

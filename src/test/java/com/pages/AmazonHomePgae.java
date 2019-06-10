package com.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.utility.Utility;

public class AmazonHomePgae extends Utility {

	public void OpenAmazon() {
		initialization(prop.getProperty("Amazonurl"));

	}

	public void click() {
		Actions actions = new Actions(driver);
		WebElement mainMenu = driver.findElement(By.id("nav-link-yourAccount"));
		actions.moveToElement(mainMenu);
		actions.build().perform();
        //driver.switchTo().frame(2);
		WebElement subMenu = driver.findElement(By.cssSelector("span.nav-action-inner"));
		actions.moveToElement(subMenu);
		actions.click().build().perform();

	}

	public boolean amazomPage() {
		WebElement amazompage = driver.findElement(By.xpath("//h1[@class='a-spacing-small']"));

		return waitAndIsDisplayed(amazompage);
	}

	public void dropDownValueSelect(String value) {
		WebElement locatorDropDown = driver.findElement(By.xpath("//*[@id=\"searchDropdownBox\"]"));
		selectDropDown(locatorDropDown, value);
	}

	public void sendValue(String value) {
		WebElement locatorsearch = driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
		locatorsearch.sendKeys(value);
	}

	public void clickOnSubmitButton() {
		WebElement clickLocator = driver.findElement(By.xpath("//*[@id=\"nav-search\"]/form/div[2]/div/input"));
		waitAndClick(clickLocator);
	}

	public boolean displaySearchResult(String search) {
		return driver.findElement(By.xpath("//*[@id=\"search\"]/span/h1/div/div[1]/div/div/span[4]")).getText()
				.contains(search);
	}

	public void clickOnRandomLink() {

		List<WebElement> links = driver.findElements(By.xpath("//div[@class='a-section a-spacing-none']/h2/a"));
		//div[@class='a-section a-spacing-none']/h2/a
		//div[@class='s-result-list sg-row']/div
		int count = links.size();
		System.out.println("Number of links are:" + count);

		for (int i = 0; i < count; i++) {
			Random rd = new Random();
			links.get(rd.nextInt(1)).click();
			break;

		}

	}

	public void swichWindow(int index) {
		String windowId = null;
		Set<String> windowids = driver.getWindowHandles();
		Iterator<String> itr = windowids.iterator();
		for (int i = 0; i < index; i++) {
			windowId=itr.next();
			
		}
		driver.switchTo().window(windowId);

	}

	public void clickAddCartbutton() {
		swichWindow(2);
		driver.findElement(By.cssSelector("input#add-to-cart-button")).click();
	}

	public boolean addedToCart() {
		return driver.findElement(By.xpath("//*[@class='a-size-medium a-text-bold']")).isDisplayed();

	}
	
	public String productDetails() {
		WebElement pro=driver.findElement(By.xpath("//div[@class='a-box-inner']/img"));
		hover(pro);
		driver.switchTo().frame(1);
		WebElement productText=driver.findElement(By.cssSelector("span.a-size-medium sc-product-title"));
		String productTextis=getText(productText);
		return productTextis;
		
	}
	
	
	
}

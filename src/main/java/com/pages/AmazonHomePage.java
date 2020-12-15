package com.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.utility.FileUtils;
import com.utility.Utility;

public class AmazonHomePage extends Utility   {
	
	FileUtils fileReadWrite=new FileUtils();
	Utility util= new Utility();
	public static Properties prop;

	public static String endpoint;
	
	
	@FindBy(id="nav-link-accountList")
	private WebElement mainMenu;
	
	@FindBy(xpath="//*[@id=\"nav-link-accountList\"]/div/span")
	public WebElement subMenu;
	
	
	public void OpenAmazon() {
		endpoint=fileReadWrite.getEndpoint("amazon");
		initialization(endpoint);

	}

	public void click() throws InterruptedException {
		

		WebElement ele=driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/div/span"));
		waitAndClick(ele);
	

	}

	public boolean amazomPage() {
		WebElement amazompage = driver.findElement(By.xpath("//h1[@class='a-spacing-small']"));

		return waitAndIsDisplayed(amazompage);
	}
	public void closeBrowser() {
		driver.quit();
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
		WebElement clickLocator = driver.findElement(By.xpath("//*[@id=\"nav-search-submit-text\"]/input"));
		waitAndClick(clickLocator);
	}

	public boolean displaySearchResult(String search) {
		return driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/span/h1/div/div[1]/div/div/span[3]")).getText()
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

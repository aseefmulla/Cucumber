package com.pages;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class NewTest extends AmazonHomePgae {
	// WebDriver driver;

	@Test(priority = 1)
	public void f() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Driver/chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

		driver.get("https://amazon.in");
//		Thread.sleep(3000);
//		List<WebElement> links = driver.findElements(By.xpath("//a"));
//		int count = links.size();
//		System.out.println("Number of links are:" + count);
//		Random r = new Random();
//		int linkNo = r.nextInt(count);
//		WebElement link = links.get(linkNo);
//		System.out.println(link.getText());
//		Thread.sleep(2000);
//		link.click();
		WebElement locatorDropDown = driver.findElement(By.xpath("//*[@id=\"searchDropdownBox\"]"));
		// wait.until(ExpectedConditions.visibilityOf(locatorDropDown));

		Select dropDown = new Select(locatorDropDown);
		locatorDropDown.click();
		dropDown.selectByVisibleText("Electronics");
		WebElement locatorsearch = driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('twotabsearchtextbox').value='Headphone';");
		WebElement clickLocator = driver.findElement(By.xpath("//*[@id=\"nav-search\"]/form/div[2]/div/input"));
		js.executeScript("arguments[0].click();", clickLocator);
		Thread.sleep(3000);
		List<WebElement> links = driver.findElements(By.xpath("//div[@class='s-result-list sg-row']/div"));
		int count = links.size();
		System.out.println("Number of links are:" + count);

		for (int i = 0; i < count; i++) {
			Random rd = new Random();
			links.get(rd.nextInt(5)).click();
			break;

		}

	}

	@Test(priority = 2)
	public void g() {
		swichWindow(2);
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
	}

}

///Date select

//	@Test(priority = 2)
//	public void date() {
//		String dot = "18/April 2019";
//		String date, month, year;
//		String caldt, calmonth, calyear;
//		/*
//		 * Split the String into String Array
//		 */
//		String dateArray[] = dot.split("/");
//		date = dateArray[0];
//		
//		year = dateArray[1];
//
//		driver.findElement(By.xpath("//div[@class='dF whiteBg col-sm-5 alignItemsCenter  col-md-2 ']/input")).click();
//
//		calyear = driver.findElement(By.xpath("//div[@class='DayPicker-Caption']")).getText();
//		/**
//		 * Select the year
//		 */
//		while (!calyear.equals(year)) {
//			driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
//			calyear = driver.findElement(By.xpath("//div[@class='DayPicker-Caption']")).getText();
//			System.out.println("Displayed Year::" + calyear);
//		}
//
//		
//		/**
//		 * Select the Date
//		 */
//		driver.findElement(By.xpath("//div[text()='" + date + "']")).click();
//	}

      

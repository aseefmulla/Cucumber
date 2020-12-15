package com.pages;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.utility.Utility;

public class NewTest1 extends Utility {
	 WebDriver driver;

	@Test(priority = 1)
	public void f1() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Driver/chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

	}

	@Test(priority = 2)
	public void facebook() {

		driver.get("https://www.flipkart.com");
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ESCAPE).build().perform();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.findElement(By.cssSelector("input.LM6RPg")).sendKeys("Moblie");

		driver.findElement(By.cssSelector("button.vh79eN")).submit();
	}

	// click on perticualar link
	@Test(priority = 3)
	public void f2() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Driver/chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");

		WebElement locatorDropDown = driver.findElement(By.xpath("//*[@id=\"searchDropdownBox\"]"));
		// wait.until(ExpectedConditions.visibilityOf(locatorDropDown));

		Select dropDown = new Select(locatorDropDown);
		locatorDropDown.click();
		dropDown.selectByVisibleText("Electronics");
		WebElement locatorsearch = driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('twotabsearchtextbox').value='Headphone';");

	}

	@Test(priority = 4, enabled = false)
	public void adressBook() {
		driver.get("http://a.testaddressbook.com/");
		System.out.println("Title of the page is" + driver.getTitle());
		String text = driver.findElement(By.tagName("body")).getText();
		System.out.println("Your text is" + text);
		driver.findElement(By.cssSelector("a#sign-in")).click();
		;
//        Actions action=new Actions(driver);
//        action.moveToElement(signIn).click().build().perform();
		driver.findElement(By.cssSelector("div>input#session_email")).sendKeys("arifpakirabhai@gmail.com");
		driver.findElement(By.cssSelector("div>input#session_password")).sendKeys("abcd123");
		driver.findElement(By.name("commit")).click();
		driver.findElement(By.xpath("//a[text()='Addresses']")).click();
		driver.findElement(By.xpath("//a[text()='New Address']")).click();
		driver.findElement(By.cssSelector("input#address_first_name")).sendKeys("arif");
		driver.findElement(By.cssSelector("input#address_last_name")).sendKeys("pkr");
		driver.findElement(By.cssSelector("input#address_street_address")).sendKeys("kundal");
		driver.findElement(By.cssSelector("input#address_secondary_address")).sendKeys("colony");
		driver.findElement(By.cssSelector("input#address_city")).sendKeys("bglr");

		WebElement select = driver.findElement(By.cssSelector("select#address_state"));
		Select dropdown = new Select(select);
		dropdown.selectByVisibleText("Indiana");
		driver.findElement(By.cssSelector("input#address_zip_code")).sendKeys("560037");
		WebDriverWait wait = new WebDriverWait(driver, 60);

		driver.findElement(By.cssSelector("input#address_country_us")).click();
		driver.findElement(By.cssSelector("input#address_birthday")).sendKeys("17/07/1998");
		String color="#FFFF00";
		//driver.findElement(By.cssSelector("input#address_color")).sendKeys(color);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("document.getElementById('address_color').value=\'"+color+"\';");
		driver.findElement(By.cssSelector("input#address_picture")).click();
		
		String imagePath = "D:\\abc.txt";
		uploadFileWithRobot(imagePath);
		
		
		driver.findElement(By.cssSelector("input[name=commit]")).click();
		String colorof=driver.findElement(By.cssSelector("span[data-test=color]")).getCssValue("background-color");
		
System.out.println("color is: "+colorof);

	}

	@Test(priority = 4, enabled = false)
	public void adressBook1() {}
	
}

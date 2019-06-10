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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.utility.Utility;

public class NewTest extends Utility {
	// WebDriver driver;
	
	@Test(priority = 1)
	public void f1() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Driver/chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

		driver.get("https://www.flipkart.com");
		Actions act=new Actions(driver);
	act.sendKeys(Keys.ESCAPE).build().perform();
	
	
//	String str=js.executeScript("return document.documentElement.innerText;").toString();
//	String str1=js.executeScript("return document.title;").toString();
//	String str2=js.executeScript("return document.domain;").toString();
//	String str3=js.executeScript("return document.URL;").toString();
//	System.out.println("text is:"+str);
//	System.out.println("title is:"+str1);
//	System.out.println("domain is:"+str2);
//	System.out.println("url is:"+str3);
	driver.findElement(By.cssSelector("input.LM6RPg")).sendKeys("Moblie");
	JavascriptExecutor js=(JavascriptExecutor)driver;
//	js.executeScript("document.getElementsByClassName('LM6RPg').value='Mobile';");
	driver.findElement(By.cssSelector("button.vh79eN")).submit();
	//Thread.sleep(1000);
	js.executeScript("window.scrollBy(0,2000)");

}
	//click on perticualar link
	@Test(priority = 2,enabled =false)
	public void f2() {
		List<WebElement> link=driver.findElements(By.xpath("//div[@class='_1UoZlX']/a"));
		link.get(11).click();
		swichWindow(2);
		WebElement buttonAddCart=driver.findElement(By.xpath("//button[@class='_2AkmmA _2Npkh4 _2MWPVK']"));
		Actions act=new Actions(driver);
		act.click(buttonAddCart).build().perform();
		String s1=driver.getTitle();
		System.out.println("Title1: "+s1);
		swichWindow(1);
		driver.findElement(By.xpath("//span[text()='Cart']")).click();
	//js.executeScript("window.location=''");
		
		
		
		
		
	}

	@Test(priority = 2)
	public void tearDown() {
		//driver.close();
	}

}



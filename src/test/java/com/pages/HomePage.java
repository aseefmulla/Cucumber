package com.pages;

import java.time.temporal.WeekFields;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.FindBy;

import com.utility.Utility;

public class HomePage {
	WebDriver driver;
	@FindBy(xpath = "//span[text()='Hello, Sign in']")
	public WebElement signinbutton;
	
	@FindBy(xpath = "//i[@class='a-icon a-icon-logo']")
	public WebElement amazonloginpage;
	

	Utility util = new Utility();

	public void OpenApplicaion() {
		util.initialization();
		
	}

	public boolean amazonpage() {
		WebElement ele=driver.findElement(By.xpath("//a[text()='Your Amazon.in']"));
		return  util.waitAndIsDisplayed(ele);
		
	}
	
	public void click() {
		WebElement signin= driver.findElement(By.xpath("//*[contains(text(),'Hello. Sign in')]"));
		util.waitAndClick(signin);
		
	}
	public void signInAmazon(String value) {
		
		util.sendKeys(signinbutton, value);
	}
	
	public boolean amazonLoginPage() {
		
		WebElement ele1 = driver.findElement(By.xpath("//*[contains(text(),'Email or mobile phone number')]"));
		WebElement ele2 = driver.findElement(By.xpath("//*[contains(text(),'Password')]"));
		
		System.out.println(ele1.getText()+" is Displayed");
		System.out.println(ele2.getText()+" is Displayed");
		
		return(util.waitAndIsDisplayed(ele1) && util.waitAndIsDisplayed(ele2));
		
		
	}
	
	public void selectValue(String value) {
		WebElement locatorDropDown = driver.findElement(By.xpath("//*[@id=\"searchDropdownBox\"]"));
		util.dropDown(locatorDropDown, value);
	}

	public void sendValues(String value) {
		WebElement locatorsearch = driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
		util.sendKeys(locatorsearch, value);
		
	}
}

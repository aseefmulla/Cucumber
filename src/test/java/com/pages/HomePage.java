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

public class HomePage extends Utility {
	
	@FindBy(xpath = "//span[text()='Hello, Sign in']")
	public WebElement signinbutton;
	
	@FindBy(xpath = "//i[@class='a-icon a-icon-logo']")
	public WebElement amazonloginpage;
	

	public void OpenFacebook() {
		initialization(prop.getProperty("facebookurl"));
		
	}
	
	
	public void click() {
		WebElement signin= driver.findElement(By.id("loginbutton"));
		waitAndClick(signin);
		
	}
	public void sendUsername(String value) {
		
		WebElement username=driver.findElement(By.id("email"));
		username.sendKeys(value);
	}
	
public void sendPassword(String value) {
		
		WebElement username=driver.findElement(By.id("pass"));
		username.sendKeys(value);
	}

public boolean errorMsg() {
	return driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _62c3 _4jy4 _517h _51sy']")).isDisplayed();
}
	
	
}

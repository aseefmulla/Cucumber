package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utility.Utility;

public class GoibiboHomePage extends Utility {
	public void goibiboAmazon() {
		initialization(prop.getProperty("Goibibourl"));

	}

	public void click() {

		WebElement signin = driver.findElement(By.xpath("//a[@id='get_sign_in']"));

		waitAndClick(signin);

	}

	public void goibiboPage() {
		WebElement frameElement = driver.findElement(By.xpath("//iframe[@id='authiframe']"));
		driver.switchTo().frame(frameElement);
		// iframe[@id='authiframe']
		WebElement goibiboPage = driver.findElement(By.xpath("//input[@id='authMobile']"));

		goibiboPage.sendKeys("sdfds");

	}
	
	public void selectFromAndTo(String from,String to) {
		WebElement fr=driver.findElement(By.xpath("//input[@id='gosuggest_inputSrc']"));
		fr.sendKeys(from);
		//dropDown(fr,from);
		
		WebElement too=driver.findElement(By.xpath("//input[@id='gosuggest_inputDest']"));
		too.sendKeys(to);
		//dropDown(too,to);
	
		
	}
	public void searchButton() {
		driver.findElement(By.xpath("//button[@id='gi_search_btn']")).submit();
	}

	public void datePicker(String dot) {
		String date, month, year;
		String caldt, calmonth, calyear;
		/*
		 * Split the String into String Array
		 */
		String dateArray[] = dot.split("/");
		date = dateArray[0];
		
		year = dateArray[1];

		driver.findElement(By.xpath("//div[@class='dF whiteBg col-sm-5 alignItemsCenter  col-md-2 ']/input")).click();

		calyear = driver.findElement(By.xpath("//div[@class='DayPicker-Caption']")).getText();
		/**
		 * Select the year
		 */
		while (!calyear.equals(year)) {
			driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
			calyear = driver.findElement(By.xpath("//div[@class='DayPicker-Caption']")).getText();
			System.out.println("Displayed Year::" + calyear);
		}

		
		/**
		 * Select the Date
		 */
		driver.findElement(By.xpath("//div[text()='" + date + "']")).click();
	}
	
	public void selectRadioButton() {
		driver.findElement(By.xpath("//input[@id='gi_roundtrip_label_srp']")).click();
	}
	
	public void IsSelectedRadioButton() {
		driver.findElement(By.xpath("//input[@id='gi_roundtrip_label_srp']")).isSelected();
	}

}

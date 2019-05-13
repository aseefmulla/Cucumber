package com.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

public class Utility {
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	

	public Utility() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/resources/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization(String url) {
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Driver/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			options.addArguments("--disable-web-security");
			options.addArguments("--no-proxy-server");

			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			prefs.put("profile.default_content_setting_values.notifications", 2);
			options.setExperimentalOption("prefs", prefs);
			driver = new ChromeDriver(options);
			//driver = new ChromeDriver();
		} else if (browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "/Users/naveenkhunteta/Documents/SeleniumServer/geckodriver");
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

		driver.get(url);

	}

	public boolean waitAndIsDisplayed(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(ele));
		return ele.isDisplayed();

	}

	public void sendKeys(WebElement ele, String value) {

		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(ele));
		ele.sendKeys("value");

	}

	public void waitAndClick(WebElement ele) {

		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(ele));
		ele.click();

	}
	public void dropDown(WebElement locatorDropDown,String value) {
		
		Select dropDown = new Select(locatorDropDown);
		locatorDropDown.click();
		dropDown.selectByVisibleText(value);
	}
	
	public void hoverMouse(WebElement btn) {
	Actions action = new Actions(driver);
	action.moveToElement(btn).build().perform();
	}
	
	public void swichAlert() {
		driver.switchTo().alert();
	}
	
	public void selectDropDown(WebElement locatorDropDown,String text) {
		
		Select dropDown = new Select(locatorDropDown);
		locatorDropDown.click();
		dropDown.selectByVisibleText(text);
	}
	public void pracitce(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		boolean a=wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ele)) != null;
		
	}

}

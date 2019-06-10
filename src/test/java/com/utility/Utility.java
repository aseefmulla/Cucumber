package com.utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
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
			// driver = new ChromeDriver();
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

	/**
	
	 **/

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

	public void dropDown(WebElement locatorDropDown, String value) {

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

	public void selectDropDown(WebElement locatorDropDown, String text) {

		Select dropDown = new Select(locatorDropDown);
		locatorDropDown.click();
		dropDown.selectByVisibleText(text);
	}

	public void pracitce(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		boolean a = wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ele)) != null;

	}

	public void swichWindow(int index) {
		String windowId = null;
		Set<String> windowids = driver.getWindowHandles();
		Iterator<String> itr = windowids.iterator();
		for (int i = 0; i < index; i++) {
			windowId = itr.next();

		}
		driver.switchTo().window(windowId);

	}

	public void hover(WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).build().perform();
	}

	public String getText(WebElement ele) {
		return ele.getText();

	}
	public void uploadFileWithRobot (String imagePath) {
        StringSelection stringSelection = new StringSelection(imagePath);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
 
        Robot robot = null;
 
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
 
        robot.delay(250);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(150);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
	public String getColour(WebElement ele) {
		String color=ele.getCssValue("color");
		System.out.println("Color is: "+color);
		return color;
	}

}

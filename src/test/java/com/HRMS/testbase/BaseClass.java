package com.HRMS.testbase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.HRMS.utils.ConfigsRead;
import com.HRMS.utils.Constants;

public class BaseClass {
	public static WebDriver driver;
	
	/**
	 * Will open a browser and get the url from configs
	 * @return WebDriver
	 */
	
	@BeforeMethod (alwaysRun = true)//to make this method to run before every @test
	public static WebDriver setUp() {
		ConfigsRead.readProperty(Constants.CONFIGS_PATH);
		
		switch(ConfigsRead.getProperty("browser").toLowerCase()) {
		case "chrome":
			System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "true");
			System.setProperty("webdriver.chrome.driver",Constants.CHROME_FILE_PATH);
			driver = new ChromeDriver();
			break;
		case"firefox":
			System.setProperty("webdriver.chrome.driver",Constants.GECKO_FILE_PATH);
			driver = new FirefoxDriver();
			break;
		default:
			throw new RuntimeException("Invalid Browser");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
		driver.get(ConfigsRead.getProperty("url"));
		
		//accessing initialize method in PageInitializer to access all page objects as a part of setUp 
		PageInitializer.initialize();
		
		return driver;
	}
	/**
	 * Will quit the browser  if driver is not null
	 */
	@AfterMethod (alwaysRun = true)//to make this method to run after every @test
	public static void tearDown() {
		if(driver != null) {
			//CommonMethods.sleep(3);
			driver.quit();
		}
	}

}

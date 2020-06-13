package com.HRMS.testbase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.HRMS.utils.CommonMethods;
import com.HRMS.utils.ConfigsRead;
import com.HRMS.utils.Constants;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseClass {
	public static WebDriver driver;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports report;
	public static ExtentTest test;

	/**
	 * Will open a browser and get the url from configs
	 * 
	 * @return WebDriver
	 */

	@BeforeTest(alwaysRun = true)
	public void generateReport() {

		ConfigsRead.readProperty(Constants.CONFIGS_PATH);

		htmlReporter = new ExtentHtmlReporter(Constants.REPORT_FILE_PATH);
		htmlReporter.config().setDocumentTitle(ConfigsRead.getProperty("reprotTitle"));
		htmlReporter.config().setReportName(ConfigsRead.getProperty("reportName"));
		htmlReporter.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(htmlReporter);
	}

	@AfterTest(alwaysRun = true)
	public void writeReport() {
		report.flush();
	}

	@BeforeMethod(alwaysRun = true) // to make this method to run before every @test
	public static WebDriver setUp() {

		System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "true");

		switch (ConfigsRead.getProperty("browser").toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", Constants.CHROME_FILE_PATH);
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.chrome.driver", Constants.GECKO_FILE_PATH);
			driver = new FirefoxDriver();
			break;
		default:
			throw new RuntimeException("Invalid Browser");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
		driver.get(ConfigsRead.getProperty("url"));

		// accessing initialize method in PageInitializer to access all page objects as
		// a part of setUp
		PageInitializer.initialize();

		return driver;
	}

	/**
	 * Will quit the browser if driver is not null
	 */
	@AfterMethod(alwaysRun = true) // to make this method to run after every @test
	public static void tearDown() {
		if (driver != null) {
			CommonMethods.sleep(3);
			driver.quit();
		}
	}

}

package com.HRMS.utils;

public class Constants {
	
	public static final String CHROME_FILE_PATH = System.getProperty("user.dir")+"/src/test/resources/drivers/chromedriver";
	
	public static final String GECKO_FILE_PATH = System.getProperty("user.dir")+"/src/test/resources/drivers/geckodriver";

	public static final String CONFIGS_PATH = System.getProperty("user.dir")+"/src/test/resources/configs/configurations.properties";

	public static final int  IMPLICIT_WAIT_TIME = 20;
	
	public static final int EXPLICIT_WAIT_TIME = 30;
	
	public static final String TESTDATA_FILEPATH = System.getProperty("user.dir")+"/src/test/resources/testdata/hrmsTestData.xlsx";
	
	public static final String REPORT_FILE_PATH = System.getProperty("user.dir")+"/target/html-report/HRMS.html";
	
}

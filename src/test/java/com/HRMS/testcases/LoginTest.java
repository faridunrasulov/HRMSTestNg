package com.HRMS.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.HRMS.utils.CommonMethods;
import com.HRMS.utils.ConfigsRead;

public class LoginTest extends CommonMethods {

//	@BeforeMethod
//	public void openBrowser() {
//		setUp();
//		initialize();
//	}
//
//	@AfterMethod
//	public void closeBrowser() {
//		tearDown();
//	}

	@Test(groups = {"smoke"})
	public void validAdminLogin() {
		//before
		//LogInPageElements login = new LogInPageElements();
		//now
		sendText(loginPage.username, ConfigsRead.getProperty("userName"));
		sendText(loginPage.password, ConfigsRead.getProperty("password"));
		waitAndClick(loginPage.loginBtn);
		//before
		//dashBoardElements dashboard = new dashBoardElements();

		//now
		String actualUser = dashboard.welcome.getText();
		Assert.assertTrue(actualUser.contains(ConfigsRead.getProperty("userName")));
	}
	
	@Test(groups = {"regression"})
	public void invalidCreden() {
		sendText(loginPage.username, "asdsa");
		sendText(loginPage.password,"asdasdasd");
		waitAndClick(loginPage.loginBtn);
		String expectedError = "Invalid credentials";
		Assert.assertEquals(loginPage.invalidCredenMSg.getText(), expectedError);
	}
	
	@Test(groups = {"regression"})
	public void emptyUserName() {
		
		sendText(loginPage.password, ConfigsRead.getProperty("password"));
		waitAndClick(loginPage.loginBtn);
	
		String expectedError = "Username cannot be empty";
		Assert.assertEquals(loginPage.invalidCredenMSg.getText(), expectedError);
		
	}

}

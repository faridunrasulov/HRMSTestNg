package com.HRMS.testcases;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.HRMS.testbase.BaseClass;
import com.HRMS.utils.CommonMethods;
import com.HRMS.utils.ConfigsRead;

public class LoginTest extends CommonMethods {
	


	@Test(groups = {"smoke"})
	public void validAdminLogin() {
		//before
		//LogInPageElements login = new LogInPageElements();
		//now
		test.info("Entering valid admin credentials");
		sendText(loginPage.username, ConfigsRead.getProperty("userName"));
		sendText(loginPage.password, ConfigsRead.getProperty("password"));
		waitAndClick(loginPage.loginBtn);
		//before
		//dashBoardElements dashboard = new dashBoardElements();

		//now
		test.info("veryfing welcome messeage is displayed");
		String actualUser = dashboard.welcome.getText();
		Assert.assertTrue(actualUser.contains(ConfigsRead.getProperty("userName")));
	}
	
	@Test(groups = {"regression"})
	public void invalidCreden() {
		test.info("Entering valid admin credentials");
		sendText(loginPage.username, "asdsa");
		sendText(loginPage.password,"asdasdasd");
		waitAndClick(loginPage.loginBtn);
		
		test.info("verifying valid usernames creden with element text");
		String expectedError = "Invalid credentials";
		Assert.assertEquals(loginPage.invalidCredenMSg.getText(), expectedError);
	}
	
	@Test(groups = {"regression"})
	public void emptyUserName() {
		test.info("Entering valid admin credentials");
		sendText(loginPage.password, ConfigsRead.getProperty("password"));
		waitAndClick(loginPage.loginBtn);
		
		test.info("verifying 'User cannot be empty' message is displayed");
		String expectedError = "Username cannot be empty";
		Assert.assertEquals(loginPage.invalidCredenMSg.getText(), expectedError);
		
	}
	
//	@Test
//	public void timeStamp() {
//		Date d= new Date();
//		System.out.println(d.getTime());
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
//		System.out.println(sdf.format(d.getTime()));
//	}

}

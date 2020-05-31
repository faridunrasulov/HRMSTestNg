package com.HRMS.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.HRMS.utils.CommonMethods;
import com.HRMS.utils.ConfigsRead;
import com.HRMS.utils.Constants;
import com.HRMS.utils.ExcelUtility;

public class HwData extends CommonMethods{
	
	@Test(dataProvider = "userDataFromExcel",groups = {"addEmp","smoke","regression"})
	public void test(String firstName, String lastName, String username, String password) {
		// System.out.println(firstName + " " + lastName + " " + username + " " +
		// password);

		// login into HRMS
		loginPage.logIn(ConfigsRead.getProperty("userName"), ConfigsRead.getProperty("password"));

		// navigate to Add Employee page
		employeePage.navigateAddEmpPage();
		sleep(1);

		// add employee information
		sendText(employeePage.firstName, firstName);
		sendText(employeePage.lastName, lastName);
		// get EmployeeID
		String expectedEmpId = employeePage.empId.getAttribute("value");

		// click on Create Login Details
		click(employeePage.credentialButton);

		sendText(employeePage.credenUserName, username);
		sendText(employeePage.credenUserPassword, password);
		sendText(employeePage.confirmCredenPassword, password);
		
//		waitAndClick(employeePage.saveButton);
//
//		// validation
//		waitForVisibility(pdetails.lblPersonalDetails);
//		String actualEmpId = pdetails.lblPersonalDetails.getAttribute("value");
//		Assert.assertEquals(actualEmpId, expectedEmpId, "Employee ID did not match!");
//
//		// take screeshot
//		takeScreenshots(firstName + "_" + lastName);
	}

	@DataProvider(name = "userData")
	public Object[][] getData() {
		Object[][] data = {
				{ "Raj", "Capoor", "raj123", "AmirKhan_@123" }, 
//				{ "John", "Smith", "john123", "AmirKhan_@123" }, 
//				{ "Mary", "Ann", "mary123", "AmirKhan_@123" }, 
//				{ "Rohani", "Sakhi", "rohani123", "AmirKhan_@123" },
//				{ "Ali", "Tarlaci", "ali123", "AmirKhan_@123" },
		};

		return data;
	}
	
	@DataProvider(name = "userDataFromExcel")
	public Object[][] getData2() {
		Object[][] getData = ExcelUtility.getDataFromExcel(Constants.TESTDATA_FILEPATH, "EmployeeLogInCredentials");
		return getData;
	}

}

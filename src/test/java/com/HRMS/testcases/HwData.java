package com.HRMS.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.HRMS.utils.CommonMethods;
import com.HRMS.utils.ConfigsRead;
import com.HRMS.utils.Constants;
import com.HRMS.utils.ExcelUtility;

public class HwData extends CommonMethods{
	
	@Test(dataProvider = "userDataFromExcel")
	public void addEmp(String firstName, String lastName, String username, String password) {

		// login into HRMS
		test.info("Entering HRMS application with valid credentials");
		loginPage.logIn(ConfigsRead.getProperty("userName"), ConfigsRead.getProperty("password"));

		// navigate to Add Employee page
		test.info("Naviagting to employee page ");
		employeePage.navigateAddEmpPage();
		sleep(1);

		// add employee information
		test.info("Sending test data to our search boxes");
		sendText(employeePage.firstName, firstName);
		sendText(employeePage.lastName, lastName);
		// get EmployeeID
		String expectedEmpId = employeePage.ADDemployeeId.getAttribute("value");

		// click on Create Login Details
		
		test.info("clicking 'create log in details' button");
		click(employeePage.credentialButton);
		
		test.info("Sending additioaal data test to our search box for 'create log in details' ");
		sendText(employeePage.credenUserName, username);
		sendText(employeePage.credenUserPassword, password);
		sendText(employeePage.confirmCredenPassword, password);
		
		test.info("Clicking on save employee Button");
		waitAndClick(employeePage.saveButton);

		// validation
		test.info("verifying id form add employee page and id from personal details page are matching");
		waitForVisibility(pdetails.personalEmpID);
		String actualEmpId = pdetails.personalEmpID.getAttribute("value");
		Assert.assertEquals(actualEmpId, expectedEmpId, "Employee ID did not match!");
		
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

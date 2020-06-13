package com.HRMS.testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.HRMS.utils.CommonMethods;
import com.HRMS.utils.ConfigsRead;

public class DefineReport extends CommonMethods{
	
	@Test(groups = "smoke")
	public void reports() {
		//entering hrms credentials
		loginPage.logIn(ConfigsRead.getProperty("userName"), ConfigsRead.getProperty("password"));
		//navigate to report page
		report.navigateToReports();
		sendText(report.reportName, "Valid reports");
		//selectDdValue(report.selectionCriteria, "Employee Name");
		click(report.criteriaAddButton);
		report.empName.sendKeys("John smith",Keys.ENTER);
		//selectDdValue(report.reportCompare, "Current Employees Only");
		//selectDdValue(report.displayGroups, "Personal ");
		waitAndClick(report.fieldAddButton);
		//selectDdValue(report.displayFields, "Employee Id");
		
		click(report.checkBox);
		
		sleep(3);
		waitAndClick(report.reportSaveBTN);
		
		
	}
	

}

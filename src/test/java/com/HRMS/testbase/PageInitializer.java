package com.HRMS.testbase;

import com.HRMS.pages.LogInPageElements;
import com.HRMS.pages.PersonalDetailsPageElements;
import com.HRMS.pages.ReportPage;
import com.HRMS.pages.addEmployeePage;
import com.HRMS.pages.dashBoardElements;

public class PageInitializer extends BaseClass{
	
	public static LogInPageElements loginPage;
	public static dashBoardElements dashboard;
	public static PersonalDetailsPageElements pdetails;
	public static addEmployeePage employeePage;
	public static ReportPage report;

	public static void initialize() {
		loginPage = new LogInPageElements();
		dashboard = new dashBoardElements();
		pdetails = new PersonalDetailsPageElements();
		employeePage = new addEmployeePage();
		report = new ReportPage();
	}

}

package com.HRMS.testbase;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.HRMS.utils.CommonMethods;

public class Listener implements ITestListener{
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("The test case started "+result.getName());
		BaseClass.test = BaseClass.report.createTest(result.getName());
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("The test case Passed "+result.getName());
		BaseClass.test.pass("Test Case Passed "+result.getName());
		try {
			BaseClass.test.addScreenCaptureFromPath(CommonMethods.takeScreenshots("passed testCases/"+result.getName()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("The test case Failed "+result.getName());
		BaseClass.test.fail("Test Case Failed "+result.getName());
		try {
			BaseClass.test.addScreenCaptureFromPath(CommonMethods.takeScreenshots("Failed testCases/"+result.getName()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

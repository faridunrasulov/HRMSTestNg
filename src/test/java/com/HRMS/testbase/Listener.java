package com.HRMS.testbase;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener{
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("The test case started "+result.getName());
		BaseClass.report.createTest(result.getName());
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("The test case Passed "+result.getName());
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("The test case Failed "+result.getName());
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("The test case Skipped "+result.getName());
	}
	
	@Override
	public void onStart(ITestContext context) {
		System.out.println("Functionality Testing Started");
	}
	
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Functionality Testing Finished");
	}
	
}

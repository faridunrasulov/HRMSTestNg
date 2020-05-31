package com.HRMS.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.HRMS.testbase.BaseClass;
import com.HRMS.utils.CommonMethods;

public class addEmployeePage extends CommonMethods{
	
	@FindBy(xpath="//b[text()='PIM']")
	public WebElement PIM;
	
	@FindBy(id="menu_pim_addEmployee")
	public WebElement addEmp;
	
	@FindBy(xpath="//label[text()='Full Name']")
	public WebElement nameDisplayed;
	
	@FindBy(xpath="//label[text()='Employee Id']")
	public WebElement employIdDisplayed;
	
	@FindBy(xpath="//label[text()='Photograph']")
	public WebElement photoDisplayed;
	
	@FindBy(css="input#firstName")
	public WebElement firstName;
	
	@FindBy(css="input#lastName")
	public WebElement lastName;
	
	@FindBy(css="input#photofile")
	public WebElement uploadPhoto;
	
	@FindBy(id="btnSave")
	public WebElement saveButton;
	
	@FindBy(id="profile-pic")
	public WebElement profilePic;
	
	@FindBy(id="chkLogin")
	public WebElement credentialButton;
	
	@FindBy(id="user_name")
	public WebElement credenUserName;
	
	@FindBy(id="user_password")
	public WebElement credenUserPassword;
	
	@FindBy(id="re_password")
	public WebElement confirmCredenPassword;
	
	@FindBy(xpath="//span[@for='firstName']")
	public WebElement nameRequiredMsg;
	
	@FindBy(xpath="//span[@for='lastName']")
	public WebElement lastNameRequiMsg;
	
	public addEmployeePage() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	
	@FindBy(id="status")
	public WebElement selectStatus;
	
	@FindBy(id="employeeId")
	public WebElement empId;
	
	public void navigateAddEmpPage() {
		moveHoverToElement(PIM);
		waitAndClick(addEmp);
	}

	public void addEmployee(String firstName,String lastName,String userName,String password,String confirmPassword,String screenShot) {
		sendText(employeePage.firstName, firstName);
		sendText(employeePage.lastName, lastName);
		click(employeePage.credentialButton);
		sendText(employeePage.credenUserName, userName);
		sendText(employeePage.credenUserPassword, password);
		sendText(employeePage.confirmCredenPassword,confirmPassword);
		waitAndClick(employeePage.saveButton);
		String expectedValue = firstName+" "+lastName;
		Assert.assertEquals(employeePage.profilePic.getText(), expectedValue);
		sleep(1);
		takeScreenshots(screenShot);
	}


}

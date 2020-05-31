package com.HRMS.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HRMS.testbase.BaseClass;
import com.HRMS.utils.CommonMethods;

public class dashBoardElements extends CommonMethods{
	
	@FindBy(id = "welcome")
	public WebElement welcome;
	
	@FindBy(xpath = "//div[@id='branding']/a[1]/img")
	public WebElement logo;
	
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
	
	public dashBoardElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	
	public void navigateAddEmpPage() {
		moveHoverToElement(PIM);
		waitAndClick(addEmp);
	}
	

}

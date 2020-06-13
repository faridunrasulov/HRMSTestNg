package com.HRMS.pages;

import java.util.List;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HRMS.testbase.BaseClass;

public class PersonalDetailsPageElements {
	
	@FindBy(id = "personal_cmbNation")
	public WebElement nationalityDD;

	@FindBy(name = "personal[optGender]")
	public List<WebElement> genderRadioGroup;

	@FindBy(id = "personal_txtEmployeeId")
	public WebElement personalEmpID;

	@FindBy(id = "personal_txtEmployeeId")
	public WebElement employeeId;

	public PersonalDetailsPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	

}

package com.HRMS.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HRMS.testbase.BaseClass;
import com.HRMS.utils.CommonMethods;

public class LogInPageElements extends CommonMethods{
	
	// Not using PageFactory, You have to extend CommonMethods or BaseClass
		// public WebElement username2=driver.findElement(By.id("txtUsername"));

		// Using PageFactory and @FindBy Annotation
		@FindBy(id = "txtUsername")
		public  WebElement username;//if i make it private then

		@FindBy(name = "txtPassword")
		public WebElement password;

		@FindBy(css = "input#btnLogin")
		public WebElement loginBtn;

		@FindBy(xpath = "//div[@id='divLogo']/img")
		public WebElement logo;

		@FindBy(id = "spanMessage")
		public WebElement invalidPassMsg;
		
		@FindBy(id="spanMessage")
		public WebElement invalidCredenMSg;
		

		public LogInPageElements() {
			PageFactory.initElements(BaseClass.driver, this);
		}
		
		//if we would be keeping elements as private
		//then we will need to create public getters and setters
		//so we can access page elements from test classes
		
		public WebElement getUserName() {
			return username;
		}
		
		public void sendUserName(String uid) {
			sendText(username, uid);
		}
		
		public void logIn(String uid,String pwd) {
			sendText(username, uid);
			sendText(password, pwd);
			waitAndClick(loginBtn);
		}

}

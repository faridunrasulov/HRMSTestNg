package com.HRMS.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.HRMS.utils.CommonMethods;
import com.HRMS.utils.ConfigsRead;





public class dataProviderTest extends CommonMethods {

	@Test(dataProvider = "getTestData")
	public void HRMS(String firstName, String lastName, String userName, String password, String confirmPassword,
			String screenShot) {
		loginPage.logIn(ConfigsRead.getProperty("userName"), ConfigsRead.getProperty("password"));
		employeePage.navigateAddEmpPage();
		
		employeePage.addEmployee(firstName, lastName, userName, password, confirmPassword, screenShot);

	}
	
	@DataProvider
	public Object[][] getTestData() {
		Object data[][] = {
				{"Morgan","Freeman","MorganF","MorganFreeman@56!!","MorganFreeman@56!!","screenshots/employee/morgan.png"},
//				{"Edward","Norton","EdwardN","NortonEdward@1234!!","MorganFreeman@56!!","screenshots/employee/edward.png"},
//				{"Matt","Damon","damon321","demonMatt@D232!!","demonMatt@D232!!","screenshots/employee/matt.png"},
//				{"Martin","Sheen","sheen123","MartinSheen@312....","MartinSheen@312....","screenshots/employee/martin.png"},
//				{"Bradley","Copper","copper1233","BradleyCopper@978!!!","BradleyCopper@978!!!","screenshots/employee/bradley.png"},
		};
		return data;
	}
}

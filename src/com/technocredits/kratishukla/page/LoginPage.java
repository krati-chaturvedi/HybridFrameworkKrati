package com.technocredits.kratishukla.page;

import org.openqa.selenium.By;

import com.technocredits.kratishukla.base.PredefinedActions;

public class LoginPage extends PredefinedActions{
	
	//Validating if Logo is displayed
	public boolean isLogoDisplayed() {
		return isElementDisplayed("xpath", "//div[@id='divLogo']", true);
		//return driver.findElement(By.xpath("//div[@id='divLogo']")).isDisplayed();
	}
	
		
	//Sending userName
	public LoginPage enterUserName(String uName) throws Exception {
		PredefinedActions.enteringData("xpath","//input[@id='txtUsername']",false,uName);
		return new LoginPage();
	}
	
	//Sending Password
	public LoginPage enterPassword(String pwd) throws Exception {
		PredefinedActions.enteringData("xpath","//input[@id='txtPassword']",false,pwd);
		return new LoginPage();
	}
	
	//Click on Submit button
	public HomePage clickSubmitButton(){
		PredefinedActions.clickOnElement("xpath", "//input[@name='Submit']", false);
		return new HomePage();
		
	}

	//Method to enter Username - Passowrd & click on submit
	public HomePage performLogin(String uName, String pwd) throws Exception {
		enterUserName(uName);
		enterPassword(pwd);
		clickSubmitButton();
		return new HomePage();
	}
	
}

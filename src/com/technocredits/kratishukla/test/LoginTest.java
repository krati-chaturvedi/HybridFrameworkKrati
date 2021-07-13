package com.technocredits.kratishukla.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.technocredits.kratishukla.base.PredefinedActions;
import com.technocredits.kratishukla.page.AttendancePage;
import com.technocredits.kratishukla.page.Attendance_PunchPage;
import com.technocredits.kratishukla.page.HomePage;
import com.technocredits.kratishukla.page.LoginPage;


public class LoginTest {

	@Test
	public void checkLoginPage() throws Exception {
		
		PredefinedActions.set("https://kratic-trials71.orangehrmlive.com/auth/login");
		
		LoginPage loginPage = new LoginPage();
		//boolean isLogo = loginPage.isLogoDisplayed();
		Assert.assertTrue(loginPage.isLogoDisplayed(), "Logo is not displayed"); //validating if Logo is displayed on Login page
		
		HomePage homePage = loginPage.performLogin("Admin", "5@AN9zuTlP");//Login to site using provided credentials
		
		 Assert.assertTrue(homePage.isDashboardLoaded(), "By default DashBoard page is not loaded");// Validating if dashBoard is displayed
		
		System.out.println("Total count of header is :"+homePage.menuCount());
		Assert.assertEquals(16, homePage.menuCount(), "Some Menu is mssing");
		
		AttendancePage attendance = new AttendancePage();
		//Assert.assertTrue(attendance.punchInPunchOut(), "PunchIn PunchOut could not be clicked");
		attendance.clickAttendance();
		Attendance_PunchPage attendance_PunchPage = attendance.punchInPunchOut();
	}

}

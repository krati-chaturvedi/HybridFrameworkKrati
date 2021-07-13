package com.technocredits.kratishukla.page;

import org.openqa.selenium.WebElement;

import com.technocredits.kratishukla.base.PredefinedActions;
import com.technocredits.kratishukla.utilities.DateOperation;

public class AttendancePage extends PredefinedActions {
	
	public void clickAttendance() {
		WebElement element = getElement("xpath", "//span[text()='Attendance']", true);
		//toScrollElement(element);
		clickOnElement("xpath", "//span[text()='Attendance']", true);
	}
	
	public Attendance_PunchPage punchInPunchOut() {
		
		Attendance_PunchPage attendance_PunchPage = new Attendance_PunchPage();
		attendance_PunchPage.clickPunch();
		attendance_PunchPage.clickDatePicker();
		
		DateOperation dateOperation = new DateOperation();
		//int date = dateOperation.sysDate();
		//String month = dateOperation.sysMonth();
		//String day = dateOperation.sysDay();
		//int year = dateOperation.sysYear();
		//attendance_PunchPage.verifySelectedDate(day, date, month, year);
		attendance_PunchPage.verifySelectedDate(dateOperation.sysDay(), dateOperation.sysDate(),  dateOperation.sysMonth(), dateOperation.sysYear());
		return new Attendance_PunchPage();
	}

}

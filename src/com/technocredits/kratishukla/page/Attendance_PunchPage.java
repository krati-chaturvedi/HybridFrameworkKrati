package com.technocredits.kratishukla.page;

import com.technocredits.kratishukla.base.PredefinedActions;

public class Attendance_PunchPage extends PredefinedActions {
	
	 void clickPunch() {
		clickOnElement("xpath", "//span[@combinedmenutitle='Attendance > Punch In/Out']", true);
	}
	 
	 void clickDatePicker() {
		 clickOnElement("xpath", "//i[@class='material-icons action-icon date-picker-open-icon']", true);
	 }
	 
	 public  void verifySelectedDate(String day, int date, String month, int year) {
		 //Wed, 07 Jul 2021
		
		 String concatenatedDate = String.valueOf(date);
		 if (date<10)
			 concatenatedDate = "0"+ concatenatedDate;
		 String finalDate = day+","+" "+concatenatedDate+" "+month+" "+year;
		 System.out.println(finalDate);
		 clickOnElement("xpath", "//div[@aria-label='"+finalDate+"']", false);
	 }
}

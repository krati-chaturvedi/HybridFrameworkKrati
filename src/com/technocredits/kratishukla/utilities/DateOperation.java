package com.technocredits.kratishukla.utilities;

import java.util.Calendar;
import java.util.Date;

public class DateOperation {
	
		private String[] getSystemDate() {
		Date date = Calendar.getInstance().getTime();
		String sysDate = String.valueOf(date);
		System.out.println(date);
		String sysDateArr[] = sysDate.split(" ");
		return sysDateArr;
	}

	public String sysDay() {
		String sysDateArr[] = getSystemDate();
		return sysDateArr[0];
	}
	
	public String sysMonth() {
		String sysDateArr[] = getSystemDate();
		return sysDateArr[1];
	}
	
	public int sysDate() {
		String sysDateArr[] = getSystemDate();
		return Integer.parseInt(sysDateArr[2]);
	}
	
	public int sysTime() {
		String sysDateArr[] = getSystemDate();
		return Integer.parseInt(sysDateArr[3]);
	}
	
	public String sysZone() {
		String sysDateArr[] = getSystemDate();
		return sysDateArr[4];
	}
	
	public int sysYear() {
		String sysDateArr[] = getSystemDate();
		return Integer.parseInt(sysDateArr[5]);
	}

}

package com.technocredits.kratishukla.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.technocredits.kratishukla.base.PredefinedActions;

public class HomePage extends PredefinedActions {
	
	public boolean isDashboardLoaded() {
		
		//WebDriverWait wait = new WebDriverWait(driver,30);
		//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[@id='menu_dashboard_index']")));
		String actualDashboard = getElementText("xpath", "//a[@id='menu_dashboard_index']", true);
		return (actualDashboard).equals("Dashboard");
		
	}
	
	public int menuCount() {
		int totalMenu = getElements("xpath", "//li[contains(@class,'level1')]").size(); //Getting the total count of headers available
		//int headerTotal = headerList.size();
		return totalMenu;
	}

}

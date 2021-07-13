package com.technocredits.kratishukla.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class testtemp {
	
	@Test
	public void punchInPunchOut() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\krachaturvedi\\Documents\\TechnoCredits\\HybridKratiShukla\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://kratic-trials71.orangehrmlive.com/auth/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("5@AN9zuTlP");
		driver.findElement(By.xpath("//input[@name='Submit']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Attendance']")));
		driver.findElement(By.xpath("//span[text()='Attendance']")).click();
		driver.findElement(By.xpath("//span[@combinedmenutitle='Attendance > Punch In/Out']")).click();
		System.out.println("Element has been clicked");
		
	}

}

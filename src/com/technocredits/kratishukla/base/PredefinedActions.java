package com.technocredits.kratishukla.base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.technocredits.kratishukla.constant.ConstantPath;

public class PredefinedActions {

	protected static WebDriver driver;
	
	//Initializing Chrome driver
	 public static void set(String url) {
		 System.setProperty(ConstantPath.CHROMEDRIVER, ConstantPath.CHROMEDRIVEREXE);
			driver = new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();
	}
	 
		 // method to send any data into textboxes	 
	 public static void enteringData(String locatorType, String locatorPath,boolean isWaitRequired, String input) throws Exception {
			WebElement element = getElement(locatorType , locatorPath, isWaitRequired);
			if (element.isEnabled())
				element.sendKeys(input);
			else
				throw new Exception("Locator Type :"+locatorType+" is not enabled for locator :"+locatorPath);
			
	}
	 
	 //method to perform CLICK actions
	 public static void clickOnElement(String locatorType, String locatorPath,boolean isWaitRequired) {
		 WebElement element = getElement(locatorType , locatorPath, isWaitRequired);
		 if (element.isEnabled())
				element.click();
	 }
	 
	 //Finding webElement
	 public static WebElement getElement(String locatorType, String locatorPath, boolean isWaitRequired) {
		 WebElement element;
		 WebDriverWait wait = new WebDriverWait(driver, ConstantPath.AVGWAIT);
		 switch (locatorType.toUpperCase())
		{
			case "XPATH":
				if (isWaitRequired)
					element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorPath)));
			else
					element = driver.findElement(By.xpath(locatorPath));
				break;
				
			case "ID":
				if (isWaitRequired)
					element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorPath)));
			else
					element = driver.findElement(By.id(locatorPath));
				break;
			default :
				element = null;
				System.out.println("Invalid Locator Type");
		} 
		 return element;
	 }
	 
	//Finding List of webElement
	 public static List getElements(String locatorType, String locatorPath) {
		 List element;
		 switch (locatorType.toUpperCase())
		{
			case "XPATH":
					 element = driver.findElements(By.xpath(locatorPath));
					break;
			default :
				element = null;
		}
		 return element;
	 }
	 
	 protected  boolean isElementDisplayed(WebElement element) { // to Validate if element is Displayed
		 if(element.isDisplayed())
			 return true;
		 else {
			 toScrollElement(element);
			 return element.isDisplayed();
		 }
	 }
	 
	 protected  boolean isElementDisplayed(String locatorType, String locatorPath, boolean isWaitRequired) { // to Validate if element is Displayed
		 WebElement element = getElement(locatorType, locatorPath, isWaitRequired);
		 return isElementDisplayed(element);
	 }


	protected void toScrollElement(WebElement element) { //If element is not in view then scrolling down
		JavascriptExecutor je = (JavascriptExecutor) driver;
			je.executeScript("arguments[0].scrollIntoView(true)", element);
	}
 
	protected String getElementText(String locatorType, String locatorPath, boolean isWaitRequired) {
		WebElement element = getElement(locatorType, locatorPath, isWaitRequired);
		return element.getText();
	}
	


}

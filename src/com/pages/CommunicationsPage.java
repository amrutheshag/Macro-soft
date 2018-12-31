package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BrowserUtils;
import utility.Log;

public class CommunicationsPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	
	By MyOpenCasesListingLink= By.linkText("My Open Cases");
	
	By MyCasesForFollowupTodayLink= By.linkText("My Cases for Follow-up Today");
	
	By MyCaseHistoryLink = By.linkText("My Case History");
	
	
	public CommunicationsPage(WebDriver driver){
		this.driver= driver;
		this.wait = new WebDriverWait(driver, 20);
	}
	
	public void clickMyOpenCasesListing() throws Exception{
		
		try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(MyOpenCasesListingLink));
		driver.findElement(MyOpenCasesListingLink).click();
		System.out.println("clicked my open cases listing");
		Log.info("Log4j msg- clicked my open cases listing");
		
		}catch(Exception e){
			System.out.println("error in clicking my open cases");
			Log.info("log4j msg:error in clicking my open cases");
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
			driver.quit();
		}
	}

	
	
	public void clickMyOpenCasesForFollowUp() throws Exception{
		
		try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(MyCasesForFollowupTodayLink));
		driver.findElement(MyCasesForFollowupTodayLink).click();
		System.out.println("clicked my open cases  for followup today listing");
	
	Log.info("Log4j msg- clicked my open cases for followup today listing");
		}catch(Exception e){
			System.out.println("error in clicking my cases for followup");
			Log.info("log4j msg:error in clicking my  cases for followup");
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
			driver.quit();
		}
	
	
	}
	
	public void clickMyCaseHistory() throws Exception{
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(MyCaseHistoryLink));
		
		driver.findElement(MyCaseHistoryLink).click();
		System.out.println("clicked My Case History");
		Log.info("Log4j msg- clicked My Case History");
		}catch(Exception e){
			System.out.println("error in clicking case history");
			Log.info("log4j msg:error in clicking case history");
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
			driver.quit();
		}
		}
}
	
	
	

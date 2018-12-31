package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BrowserUtils;
import utility.Log;

public class ProvidersPage {

	WebDriver driver;
	WebDriverWait wait;  
	
	By ProvidersLink = 		By.xpath("id('Providers')/li[@class='ng-scope']/a[@class='nav-menu member-list ng-binding ng-scope']");
	
	By CaseManagersLink =By.linkText("Case Managers");
	
	By FeeSchedulesLink = By.linkText("Fee Schedules");
	
	By TaxpayersAndRatesLink = By.linkText("Taxpayers and Rates");
	
	By LateClaimInterestRatesLink = By.linkText("Late Claim Interest Schedules");
	
	
	
	
	
	
	public ProvidersPage(WebDriver driver){
		this.driver= driver;
		this.wait = new WebDriverWait(driver, 35);  
	}
	
	//Providers
	public void clickOnProviders() throws Exception{
		try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(ProvidersLink));
		driver.findElement(ProvidersLink).click();
		Log.info("Log4j msg- clicked on Providers in Providers page");
		System.out.println("Clicked on Providers in Providers page");
	}catch(Exception e){System.out.println("Error in clicking Providers");
	Log.info("log4j- msg- Error in clicking Providers"); 
	BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
	driver.quit(); }
	}
	
	
	//case managers
	public void clickOnCaseManagers() throws Exception{
		try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(CaseManagersLink));
		driver.findElement(CaseManagersLink).click();
		Log.info("Log4j msg- clicked on Case Managers in Providers page");
		System.out.println("Clicked on Case Managers in Providers page");
		}catch(Exception e){System.out.println("Error in clicking Case Managers"); 
		Log.info("log4j- msg- Error in clicking Case managers"); 
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
		driver.quit(); }
		}
		
	
	//fee schedules
	public void clickOnFeeSchedules(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(FeeSchedulesLink));
		driver.findElement(FeeSchedulesLink).click();
		Log.info("Log4j msg- clicked on Fee Schedules in Providers page");
		System.out.println("Clicked on Fee Schedules in Providers page");
	}
	//tax payers and rates
	public void clickOnTaxpayersAndRates() throws Exception{
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(TaxpayersAndRatesLink));
		
		driver.findElement(TaxpayersAndRatesLink).click();
		Log.info("Log4j msg- clicked on Taxpayers and Rates in Providers page");
		System.out.println("Clicked on Taxpayers and Rates in Providers page");
		}catch(Exception e){System.out.println("Error in clicking Tax Payers and Rates"); 
		Log.info("log4j- msg- Error in clicking Tax Payers and Rates"); 
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
		driver.quit(); }
		}

	public void clickOnLateClaimInterestRates() throws Exception{
		
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(LateClaimInterestRatesLink));
		
		driver.findElement(LateClaimInterestRatesLink).click();
		Log.info("Log4j msg- Clicked on Late Claim Interest Rates Link in Providers page");
		System.out.println("Clicked on Late Claim Interest Rates Link in Providers page");
		}catch(Exception e){
			System.out.println("Error in clicking Late Claim Interest Schedules"); 
			Log.info("log4j- msg- Error in clicking Late Claims Interest Schedules"); 
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
			driver.quit();
		}
		}

}

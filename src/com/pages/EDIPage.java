package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BrowserUtils;
import utility.Log;

public class EDIPage {

	WebDriver driver;
	WebDriverWait wait; 

	By BatchClaimsAdjudicationLink = 	By.linkText("Batch Claims Adjudication");
	
	By EDISubmittersLink=				By.linkText("EDI Submitters");
	
	public EDIPage(WebDriver driver){
		this.driver= driver;
		this.wait= new WebDriverWait(driver, 20);
	}
	


	public void clickBatchClaimsAdjudication() throws Exception{
		
		try{
			
		wait.until(ExpectedConditions.visibilityOfElementLocated(BatchClaimsAdjudicationLink));
		driver.findElement(BatchClaimsAdjudicationLink).click();
		System.out.println("clicked Batch claims Adjudication");
		Log.info("Log4j msg- clicked Batch claims Adjudication");
		}catch(Exception e) {
			System.out.println("error in clicking Batch claims Adjudication");
			Log.info("error in clicking Batch claims Adjudication");
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit();
		}
	}

	
	
	
	
	public void clickEDISubmitters() throws Exception{
		
		try{
			
		wait.until(ExpectedConditions.visibilityOfElementLocated(EDISubmittersLink));
		driver.findElement(EDISubmittersLink).click();
		System.out.println("clicked EDI Submitters");
		Log.info("Log4j msg- clicked EDI Submitters");
		}catch(Exception e) {
			System.out.println("error in clicking EDI Submitters");
			Log.info("error in clicking EDI Submitters"); 
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
			driver.quit();
		}
	}



}

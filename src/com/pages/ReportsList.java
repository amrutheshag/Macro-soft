package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Log;

public class ReportsList {
	
	WebDriver driver;
	WebDriverWait wait; 
	
	By ClaimsBillingFromTheImageRecordsLink = By.linkText("Claims Billing from the Image Records");
	
	By ExplanationOfBenefitsReportLink = By.linkText("Explanation of Benefits Report");
	
	By ClaimITReportLink =  By.linkText("Claim-IT Report");
			
	public ReportsList(WebDriver driver){
		this.driver= driver;
		this.wait = new WebDriverWait(driver, 35);   
	}
	
	public void clickClaimsBillingFromTheImageRecords() throws Exception{
		try{
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(ClaimsBillingFromTheImageRecordsLink));
		driver.findElement(ClaimsBillingFromTheImageRecordsLink).click();
		System.out.println("Clicked Claims Billing From The Image Records Link");
		Log.info("Log4j msg- Clicked Claims Billing From The Image Records Link ");
	}catch(Exception e){System.out.println("error in clicking Claims Billing From The Image Records Link" );
	Log.info("error in clicking Claims Billing From The Image Records Link" );
	}
		
	}
	
	public void clickExplanationOfBenefitsReport() throws Exception{
		
		try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(ExplanationOfBenefitsReportLink));
		driver.findElement(ExplanationOfBenefitsReportLink).click();
		System.out.println("Clicked Explanation Of Benefits Report Link");
		Log.info("Log4j msg- Clicked Explanation Of Benefits Report Link");
		}catch(Exception e){System.out.println("error in clicking Explanation Of Benefits Report Link" );
		Log.info("error in clicking Explanation Of Benefits Report Link" );
		}
		}
	

	public void clickClaimITReport() throws Exception{
		
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(ClaimITReportLink));
		driver.findElement(ClaimITReportLink).click();
		System.out.println("Clicked Claim IT Report Link");
		Log.info("Log4j msg- Clicked Claim IT Report Link");
		}catch(Exception e){System.out.println("error in clicking Claim IT Report Link" );
		Log.info("error in clicking Claim IT Report Link" );
		}
	}
}

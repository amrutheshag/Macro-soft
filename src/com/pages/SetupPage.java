package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.BrowserUtils;
import utility.Log;

public class SetupPage {
	
	WebDriver driver;
	WebDriverWait wait ;    
	
	By UnlockClaimsLink=By.linkText("Unlock all Claims locked by EOB Process");
	
	By ConfirmUnlockButton= By.xpath("//button[text()='Yes']");
	
	
	By OKButton= By.xpath("//button[text()='OK']");
	
	public SetupPage(WebDriver driver){
		this.driver= driver;
		this.wait= new WebDriverWait(driver, 35);
	}
	
	public void clickUnlockClaims() throws Exception{
		try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(UnlockClaimsLink));
			driver.findElement(UnlockClaimsLink).click();
			Log.info("log4j msg- clicked on Unlock Claims");
			System.out.println("clicked on Unlock Claims");
			
			
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(ConfirmUnlockButton));
			driver.findElement(ConfirmUnlockButton).click();
			Log.info("log4j msg- clicked Yes to Confirm");
			System.out.println("clicked Yes to Confirm");
			
			
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(OKButton));
			driver.findElement(OKButton).click();
			Log.info("log4j msg- Locks Removed- clicked OK");
			System.out.println("Locks Removed- clicked ok");
			
			
			
			
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
			driver.quit();
			
			
			
			
		}catch(Exception e) {
			Log.info("log4j msg- Error in Unlocking claims  \n"); 
			System.out.println("Error in Unlocking claims \n"); 	

			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
			driver.quit();
		
		}
	}
}

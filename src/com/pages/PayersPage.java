package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.BrowserUtils;
import utility.Log;

public class PayersPage {
	
	WebDriver driver;
	WebDriverWait wait ;   
	
	By PayersLink = 				By.linkText("Payers");
	
	By BenefitPlansLink = 			By.linkText("Benefit Plans");
	
	By BenefitClassesLink = 		By.linkText("Benefit Classes");
	
	By BenefitProductsLink= 		By.linkText("Benefit Products");
	
	By TierCopaysSchedules = 		By.linkText("Tier Copays Schedules");
	
	By CarrierCoverageTypes = 		By.linkText("Carrier Coverage Types");
	    
	By CarrierRelationshipTypes = 	By.linkText("Carrier Relationship Types");
	    
	By NorthAmericanIndustrialClassifications = By.linkText("North American Industrial Classifications");
	   
	By Carriers = 					By.linkText("Carriers");
	    
	By LegalRepresentatives = 		By.linkText("Legal Representatives");
	    
	By EmployerGroups = 			By.linkText("Employer Groups");
	
	
	
	
	
	
	
	public PayersPage(WebDriver driver){
		this.driver= driver;
		this.wait= new WebDriverWait(driver, 35); 
	}
	
	//Providers
	public void clickOnPayers() throws Exception{
		
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(PayersLink));
		driver.findElement(PayersLink).click();
		Log.info("Log4j msg- clicked on Payers in Payers-Emps page");
		System.out.println("Clicked on Payers in payers-Emps page");
		}catch(Exception e){
			System.out.println("Error in clicking Payers"); 
			Log.info("log4j msg- Error in clicking Payers");
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
			driver.quit();
		
		}
		
	}
	
	//Benefit Plans
	public void clickOnBenefitPlans() throws Exception{
		try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitPlansLink));
		driver.findElement(BenefitPlansLink).click();
		Log.info("Log4j msg- clicked on Benefit Plans in Payers-Emps page");
		System.out.println("Clicked on Benefit Plans in payers-Emps page");
		}catch(Exception e){
			System.out.println("Error in clicking Benefit Plans"); 
			Log.info("log4j msg- Error in clicking Benefit Plans ");
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
			driver.quit();
		
		
		}
		
	}
	
	//Benefit Classes
	public void clickOnBenefitClasses() throws Exception{
		try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitClassesLink));
		driver.findElement(BenefitClassesLink).click();
		Log.info("Log4j msg- clicked on Benefit Classes in Payers-Emps page");
		System.out.println("Clicked on Benefit Classes in payers-Emps page");
		
		}catch(Exception e){
			System.out.println("Error in clicking Benefit Classes"); 
			Log.info("log4j msg- Error in clicking Benefit Classes");
			
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
			driver.quit();
		
		
		}
	}
	
	
	
	//Benefit 	Products	
	public void clickOnBenefitProducts() throws Exception{
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitProductsLink));
		driver.findElement(BenefitProductsLink).click();
		Log.info("Log4j msg- clicked on Benefit Products in Payers-Emps page");
		System.out.println("Clicked on Benefit Products in payers-Emps page");
		
		}catch(Exception e){
			
			System.out.println("Error in clicking Benefit products"); 
			Log.info("log4j msg- Error in clicking Benefit Products");
			
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
			driver.quit();
			
		}
	}
	
	//Tier Copays Schedules
	public void clickOnTierCopaySchedules() throws Exception{
		
		try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(TierCopaysSchedules));
		driver.findElement(TierCopaysSchedules).click();
		Log.info("Log4j msg- clicked on Tier Copays Schedules in Payers-Emps page");
		System.out.println("Clicked on Tier Copays Schedules in payers-Emps page");
		
		}catch(Exception e){
			System.out.println("Error in clicking Tier Copay Schedules"); 
			Log.info("log4j msg- Error in clicking Tier Copay Schedules");
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
			driver.quit();
		
		}
	}
	
	
	 public void clickOnCarrierCoverageTypes() throws Exception{
		 try{
	         wait.until(ExpectedConditions.visibilityOfElementLocated(CarrierCoverageTypes));
	        driver.findElement(CarrierCoverageTypes).click();
	        Log.info("Log4j msg- clicked on Carrier Coverage Types in Payers-Emps page");
	        System.out.println("Clicked on Carrier Coverage Types in payers-Emps page");
	        
			}catch(Exception e){
				System.out.println("Error in clicking Carrier Coverage Types"); 
				Log.info("log4j msg- Error in clicking Carrier Coverage Types");
				
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
				driver.quit();
			}
	}

	    
	    public void clickOnCarrierRelationshipTypes() throws Exception{
	       try{   wait.until(ExpectedConditions.visibilityOfElementLocated(CarrierRelationshipTypes));
	        driver.findElement(CarrierRelationshipTypes).click();
	        Log.info("Log4j msg- clicked on Carrier Relationship Types in Payers-Emps page");
	        System.out.println("Clicked on Carrier Relationship Types in payers-Emps page");
	   	}catch(Exception e){
	   		
	   		System.out.println("Error in clicking Carrier Relationship Types");

	   		Log.info("log4j msg- Error in clicking Carrier Relationship Types");
	   		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
	   		driver.quit();
	   		
	   	}
	    }
	    public void clickOnNorthAmericanIndustrialClassifications() throws Exception{
	        try{
	           wait.until(ExpectedConditions.visibilityOfElementLocated(NorthAmericanIndustrialClassifications));
	        driver.findElement(NorthAmericanIndustrialClassifications).click();
	        Log.info("Log4j msg- clicked on NorthAmerican Industrial Classifications in Payers-Emps page");
	        System.out.println("Clicked on North AmericanIndustrial Classifications in payers-Emps page");
	    	}catch(Exception e){
	    		
	    		System.out.println("Error in clicking North American Industrial Classifications"); 
	    		Log.info("log4j msg- Error in clicking North American Industrial Classifications");
	    		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
	    		driver.quit();	
	    	} 
	    }
	    
	    public void clickOnCarriers() throws Exception{ try{
	         wait.until(ExpectedConditions.visibilityOfElementLocated(Carriers));
	        driver.findElement(Carriers).click();
	        Log.info("Log4j msg- clicked on Carriers in Payers-Emps page");
	        System.out.println("Clicked on Carriers in payers-Emps page");
		}catch(Exception e){
			
			System.out.println("Error in clicking Carriers "); 
			
			Log.info("log4j msg- Error in clicking Carriers ");
			
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
			driver.quit();
			}
	    }
	    
	    public void clickOnLegalRepresentatives() throws Exception{
	    	try{
	        wait.until(ExpectedConditions.visibilityOfElementLocated(LegalRepresentatives));
	        driver.findElement(LegalRepresentatives).click();
	        Log.info("Log4j msg- clicked on Legal Representatives in Payers-Emps page");
	        System.out.println("Clicked on Legal Representatives in payers-Emps page");
	    	}catch(Exception e){
	    		System.out.println("Error in clicking Legal Representatives"); 
	    		Log.info("log4j msg- Error in clicking Legal Representatives");
	    		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
	    		driver.quit();	
	    	}   
	    }
	    
	    public void clickOnEmployerGroups() throws Exception{
	    	try{
	         wait.until(ExpectedConditions.visibilityOfElementLocated(EmployerGroups));
	        driver.findElement(EmployerGroups).click();
	        Log.info("Log4j msg- clicked on Employer Groups in Payers-Emps page");
	        System.out.println("Clicked on Employer Groups in payers-Emps page");
	    	}catch(Exception e){
	    		System.out.println("Error in clicking Employer Groups"); 
	    		Log.info("log4j msg- Error in clicking Employer Groups");
	    		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
	    		driver.quit();
	    	}


	}
}



package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.BenefitPlanListing;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.PayersPage;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class BenefitPlanCopy {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void BenefitPlanCopyTestScript() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing Benefit Plan- Copy");
			Log.info("Executing  Benefit Plan Copy ");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_Add_BenefitPlan;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String benefitPlanCode= ExcelUtils.getCellData(count,1);
		    		String benefitPlanName=ExcelUtils.getCellData(count,2);	
		    		String benefitPlanPayer = ExcelUtils.getCellData(count,3);
		    		
		    		
		    		String newBenefitPlanCode= ExcelUtils.getCellData(count,4);
		    		String newBenefitPlanName=ExcelUtils.getCellData(count,5);
		    		String newBenefitPlanPayer = ExcelUtils.getCellData(count,6);
		    		String editedBenefitPlan = ExcelUtils.getCellData(count,7);
		    		
		    		
		    		
		    		String newClaimTypeQuery = ExcelUtils.getCellData(count,8);
		    		String newServiceTypeQuery = ExcelUtils.getCellData(count,9);
		    		String premiumStartDate = ExcelUtils.getCellData(count,10);
		    		String visionPremium = ExcelUtils.getCellData(count,11);
		    		String newNotes = ExcelUtils.getCellData(count,12);
		    			
		    			//String benefitPlanCommSubject= ExcelUtils.getCellData(count, 13);
		    						//String benefitPlanCommNoteType = ExcelUtils.getCellData(count, 14);
		    						//String benefitPlanCommNoteMedium = ExcelUtils.getCellData(count, 15);
		    						//String benefitPlanCommDetails = ExcelUtils.getCellData(count, 16);
		    						
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("End of Test Data");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("Benefit Plan Copy- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("Benefit Plan Copy- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
   		 	copyBenefitPlanMultiple(driver,benefitPlanCode, benefitPlanName, benefitPlanPayer, newBenefitPlanCode, newBenefitPlanName, newBenefitPlanPayer, newClaimTypeQuery, newServiceTypeQuery, premiumStartDate, visionPremium, newNotes);
		    		}
		    	}
			}catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void copyBenefitPlanMultiple(WebDriver driver,String benefitPlanCode, String benefitPlanName, String benefitPlanPayer, String newBenefitPlanCode, String newBenefitPlanName, String newBenefitPlanPayer, String newClaimTypeQuery, String newServiceTypeQuery, String premiumStartDate, String visionPremium, String newNotes) throws Exception
			{
			
			
			// Launch Chrome Browser
			driver= BrowserUtils.openChromeBrowser();
						
			//open risk manager
			driver.get(Constant.URL);
			System.out.println("opened browser");
						
			//click network user
			LoginPage loginPageObject = new LoginPage(driver);
			loginPageObject.clickNetworkUser();
			HomePage homePageObject = new HomePage(driver);
			try{
				homePageObject.clickExitMyOpenCaseListing();
			}catch(Exception e)
			{ System.out.println("Blank Home Page");
			Log.info("log4j - msg -Blank Home Page");}
			homePageObject.clickPayersEmps();	
			
			
			Thread.sleep(2000);
			PayersPage payersPageObject = new PayersPage(driver);
			payersPageObject.clickOnBenefitPlans();
					
			Thread.sleep(2000);
			
		BenefitPlanListing benefitPlanPageObject = new BenefitPlanListing(driver);
			benefitPlanPageObject.copyBenefitPlan( benefitPlanCode, benefitPlanName, benefitPlanPayer, newBenefitPlanCode, newBenefitPlanName, newBenefitPlanPayer, newClaimTypeQuery, newServiceTypeQuery, premiumStartDate, visionPremium, newNotes);
			
			}

		@AfterMethod
		public void afterMethod() throws Exception {
		if (driver!=null) driver.quit();
		System.out.println("Done with Benefit Plan-Copy  \n\n");
		Log.info("Done with Benefit Plan-Copy  \n\n");
		if (fis != null) 
				fis.close();
				
	}
}

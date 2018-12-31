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

public class BenefitPlanAddComm {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void BenefitPlanAddCommTestScript() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing Benefit Plan AddComm");
			Log.info("Executing  Benefit Plan AddComm ");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_Add_BenefitPlan;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String benefitPlanCode= ExcelUtils.getCellData(count,1);
		    		String benefitPlanName=ExcelUtils.getCellData(count,2);	
		    		String benefitPlanPayer = ExcelUtils.getCellData(count,3);
		    		
		    		//String benefitPlanNewCode= ExcelUtils.getCellData(count, 3);
		    		//String benefitPlanNewDescription= ExcelUtils.getCellData(count, 4);
		    		//String benefitPlanEditDescription= ExcelUtils.getCellData(count, 5);
		    		
		    				
		    						String subject= ExcelUtils.getCellData(count, 13);
		    						String noteType = ExcelUtils.getCellData(count, 14);
		    						String noteMedium = ExcelUtils.getCellData(count, 14);
		    						String noteDetails = ExcelUtils.getCellData(count, 16);
		    						
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("End of Test Data");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("Benefit Plan Add Comm- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("Benefit Plan Add Comm- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
   		 	addCommBenefitClassMultiple(driver,benefitPlanCode, benefitPlanName, benefitPlanPayer, subject, noteType, noteMedium, noteDetails);
		    		}
		    	}
			}catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void addCommBenefitClassMultiple(WebDriver driver,String benefitPlanCode, String benefitPlanName, String benefitPlanPayer, String subject, String noteType, String noteMedium, String noteDetails) throws Exception
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
			benefitPlanPageObject.addCommBenefitPlan( benefitPlanCode, benefitPlanName, benefitPlanPayer, subject, noteType, noteMedium, noteDetails);
			
			}

		@AfterMethod
		public void afterMethod() throws Exception {
		if (driver!=null) driver.quit();
		System.out.println("Done with Benefit Plan-Add Comm  \n\n");
Log.info("Done with Benefit Plan-Add Comm  \n\n");
if (fis != null)
				fis.close();
				
	}
}

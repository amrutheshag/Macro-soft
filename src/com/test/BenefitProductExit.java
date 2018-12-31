package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.BenefitProductListing;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.PayersPage;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class BenefitProductExit {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void BenefitProductExitTestScript() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing Benefit Product- Exit");
			Log.info("Executing  Benefit Product- Exit ");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_Add_BenefitProduct;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String benefitClassCode= ExcelUtils.getCellData(count,1);
		    		String benefitClassDescription=ExcelUtils.getCellData(count,2);	
		    		String benefitClassNewCode= ExcelUtils.getCellData(count, 3);
		    		String benefitClassNewDescription= ExcelUtils.getCellData(count, 4);
		    		String benefitClassEditDescription= ExcelUtils.getCellData(count, 5);
		    		
		    				
		    						String benefitClassCommSubject= ExcelUtils.getCellData(count, 6);
		    						String benefitClassCommNoteType = ExcelUtils.getCellData(count, 7);
		    						String benefitClassCommNoteMedium = ExcelUtils.getCellData(count, 8);
		    						String benefitClassCommDetails = ExcelUtils.getCellData(count, 9);
		    						
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("End of Test Data");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("Benefit Product Exit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("Benefit Product Exit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
   		 	exitBenefitProductMultiple(driver,benefitClassCode);
		    		}
		    	}
			}catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void exitBenefitProductMultiple(WebDriver driver,String benefitClassCode) throws Exception
			{
			
			
			// Launch Chrome Browser
			driver= BrowserUtils.openChromeBrowser();
						
			//open risk manager
			driver.get(Constant.URL);
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
			payersPageObject.clickOnBenefitClasses();
					
			Thread.sleep(2000);
			BenefitProductListing benefitClassPageObject = new BenefitProductListing(driver);
			benefitClassPageObject.exitBenefitProduct( benefitClassCode);
			
			}

		@AfterMethod
		public void afterMethod() throws Exception {
		if (driver!=null) driver.quit();
		System.out.println("Done with Benefit Product-Exit  \n\n");
		Log.info("Done with Benefit Product-Exit  \n\n");
		if (fis != null) 
				fis.close();
		}
}


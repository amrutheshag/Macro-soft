package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.ProviderOrganizationAffiliationTypes;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class ProviderOrganizationAffiliationTypesAddCommTestScript {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void ProviderOrganizationAffiliationTypesAddCommTestScript1() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing Provider-Organization Affiliation Types- Add Comm");
			Log.info("Executing  Provider-Organization Affiliation Types- Add Comm ");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_Add_ProviderOrganizationAffiliationTypes;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String providerorganizationaffiliationTypesCode= ExcelUtils.getCellData(count,1);
		    		String providerorganizationaffiliationTypesDescription=ExcelUtils.getCellData(count,2);	
		    		String providerorganizationaffiliationTypesNewCode= ExcelUtils.getCellData(count, 3);
		    		String providerorganizationaffiliationTypesNewDescription= ExcelUtils.getCellData(count, 4);
		    		String providerorganizationaffiliationTypesEditDescription= ExcelUtils.getCellData(count, 5);
		    		
		    				
		    						String providerorganizationaffiliationTypesCommSubject= ExcelUtils.getCellData(count, 6);
		    						String providerorganizationaffiliationTypesCommNoteType = ExcelUtils.getCellData(count, 7);
		    						String providerorganizationaffiliationTypesCommMedium = ExcelUtils.getCellData(count, 8);
		    						String providerorganizationaffiliationTypesCommDetails = ExcelUtils.getCellData(count, 9);
		    						
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("End of Test Data");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("Provider-Organization Affiliation Types Add Comm- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("Provider-Organization Affiliation Types Add Comm- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
   		 	addCommProviderOrganizationAffiliationTypesMultiple(driver, providerorganizationaffiliationTypesCode, providerorganizationaffiliationTypesDescription, providerorganizationaffiliationTypesCommSubject, providerorganizationaffiliationTypesCommNoteType, providerorganizationaffiliationTypesCommMedium, providerorganizationaffiliationTypesCommDetails);
		    		}
		    	}
			}catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void addCommProviderOrganizationAffiliationTypesMultiple(WebDriver driver,String providerorganizationaffiliationTypesCode, String providerorganizationaffiliationTypesDescription, String providerorganizationaffiliationTypesCommSubject, String providerorganizationaffiliationTypesCommNoteType, String providerorganizationaffiliationTypesCommMedium, String providerorganizationaffiliationTypesCommDetails) throws Exception
			{
			
			
			// Launch Chrome Browser
			driver= BrowserUtils.openChromeBrowser();
						
			//open risk manager
			driver.get(Constant.URL);
			System.out.println("opened browser");
						
			//click network user
			LoginPage loginPageObject = new LoginPage(driver);
			loginPageObject.clickNetworkUser();
			System.out.println("clicked Network user");
								
		
			HomePage homePageObject = new HomePage(driver);
			try{
                homePageObject.clickExitMyOpenCaseListing();
           }
			catch(Exception e){ 
				System.out.println("Blank Home Page");
				Log.info("log4j - msg -Blank Home Page");
			}

			homePageObject.clickReferencegotoProviderOrganizationAffiliationTypes();	
			
			Thread.sleep(2000);
			
            
         	ProviderOrganizationAffiliationTypes providerorganizationaffiliationTypesPageObject = new ProviderOrganizationAffiliationTypes(driver);
			providerorganizationaffiliationTypesPageObject.addCommProviderOrganizationAffiliationTypes( providerorganizationaffiliationTypesCode,  providerorganizationaffiliationTypesDescription,  providerorganizationaffiliationTypesCommSubject,  providerorganizationaffiliationTypesCommNoteType,  providerorganizationaffiliationTypesCommMedium,  providerorganizationaffiliationTypesCommDetails);
			
			}

		@AfterMethod
		public void afterMethod() throws Exception {
		if (driver!=null) driver.quit();
		System.out.println("Done with Provider-Organization Affiliation Types-Add Comm  \n\n");
		Log.info("log4j -Done with Provider-Organization Affiliation Types-Add Comm  \n\n");
		if (fis != null)
				fis.close();
	}
}






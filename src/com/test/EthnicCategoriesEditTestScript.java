package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.pages.EthnicCategories;
import com.pages.HomePage;
import com.pages.LoginPage;
import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class EthnicCategoriesEditTestScript {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void EthnicCategoriesEditTestScript1() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing Ethnic Categories- Edit");
			Log.info("Executing  Ethnic Categories- Edit ");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_Add_EthnicCategories;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String ethnicCategoriesCode= ExcelUtils.getCellData(count,1);
		    		String ethnicCategoriesDescription=ExcelUtils.getCellData(count,2);	
		    		String ethnicCategoriesNewCode= ExcelUtils.getCellData(count, 3);
		    		String ethnicCategoriesNewDescription= ExcelUtils.getCellData(count, 4);
		    		String ethnicCategoriesRecordMark= ExcelUtils.getCellData(count, 5);
		    		
		    				
		    						//String ethnicCategoriesCommSubject= ExcelUtils.getCellData(count, 6);
		    						///String ethnicCategoriesCommNoteType = ExcelUtils.getCellData(count, 7);
		    						//String ethnicCategoriesCommNoteMedium = ExcelUtils.getCellData(count, 8);
		    				//		String ethnicCategoriesCommDetails = ExcelUtils.getCellData(count, 9);
		    						
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("End of Test Data");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("Ethnic Categories Edit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("Ethnic Categories Edit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
   		 	editEthnicCategoriesMultiple(driver,ethnicCategoriesCode, ethnicCategoriesDescription, ethnicCategoriesRecordMark);
		    		}
		    	}
			}catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void editEthnicCategoriesMultiple(WebDriver driver,String EthnicCategoriesCode, String EthnicCategoriesDescription, String EthnicCategoriesRecordMark) throws Exception
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

			homePageObject.clickReferencegotoEthnicCategories();	
			Thread.sleep(2000);
			
            
        
			
			EthnicCategories ethnicCategoriesPageObject = new EthnicCategories(driver);
			ethnicCategoriesPageObject.editEthnicCategories( EthnicCategoriesCode, EthnicCategoriesDescription, EthnicCategoriesRecordMark);
			
			}

		@AfterMethod
		public void afterMethod() throws Exception {
		if (driver!=null) driver.quit();
		System.out.println("Done with Ethnic Categories-Edit \n\n");
		if (fis != null)
				fis.close();
	}
}




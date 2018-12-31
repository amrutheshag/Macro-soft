package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.ContractTypes;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class ContractTypesDeleteTestScript {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void ContractTypesDeleteTestScript1() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing Contract Types- Delete");
			Log.info("Executing  Contract Types- Delete ");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_Delete_ContractTypes;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String contractTypesCode= ExcelUtils.getCellData(count,1);
		    		String contractTypesDescription=ExcelUtils.getCellData(count,2);	
		    		String contractTypesNewCode= ExcelUtils.getCellData(count, 3);
		    		String contractTypesNewDescription= ExcelUtils.getCellData(count, 4);
		    		String contractTypesEditDescription= ExcelUtils.getCellData(count, 5);
		    		
		    				
		    						String contractTypesCommSubject= ExcelUtils.getCellData(count, 6);
		    						String contractTypesCommNoteType = ExcelUtils.getCellData(count, 7);
		    						String contractTypesCommNoteMedium = ExcelUtils.getCellData(count, 8);
		    						String contractTypesCommDetails = ExcelUtils.getCellData(count, 9);
		    						
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("End of Test Data");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("Contract Types Delete- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("Contract Types Delete- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
   		 	deleteContractTypesMultiple(driver,contractTypesCode);
		    		}
		    	}
			}catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void deleteContractTypesMultiple(WebDriver driver,String contractTypesCode) throws Exception
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
           }
            catch(Exception e){ 
            	System.out.println("Blank Home Page");
            	Log.info("log4j - msg -Blank Home Page");
            }

			homePageObject.clickReferencegotoContractTypes();	
			
			
			Thread.sleep(2000);
		/*	
			PayersPage payersPageObject = new PayersPage(driver);
			payersPageObject.clickOnContractTypes();
					
			Thread.sleep(2000);
		*/	
			ContractTypes contractTypesPageObject = new ContractTypes(driver);
			contractTypesPageObject.deleteContractTypes( contractTypesCode);
			
			}

			  @AfterMethod
      		public void afterMethod() throws Exception {
      		if (driver!=null) driver.quit();
      		System.out.println("Done with Contract Types-Delete  \n\n");
      		Log.info("Done with  Contract Types-Delete  \n\n");
      		if (fis != null)
      				fis.close();
      	}
      }





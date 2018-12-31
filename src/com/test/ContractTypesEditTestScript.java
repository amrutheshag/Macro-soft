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

public class ContractTypesEditTestScript {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void ContractTypesEditTestScript1() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing Contract Types- Edit");
			Log.info("Executing  Contract Types- Edit ");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_Add_ContractTypes;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String contractTypesCode= ExcelUtils.getCellData(count,1);
		    		String contractTypesDescription=ExcelUtils.getCellData(count,2);	
		    		String contractTypesNewCode= ExcelUtils.getCellData(count, 3);
		    		String contractTypesNewDescription= ExcelUtils.getCellData(count, 4);
		    		String contractTypesRecordMark= ExcelUtils.getCellData(count, 5);
		    		
		    				
		    						//String contractTypesCommSubject= ExcelUtils.getCellData(count, 6);
		    						///String contractTypesCommNoteType = ExcelUtils.getCellData(count, 7);
		    						//String contractTypesCommNoteMedium = ExcelUtils.getCellData(count, 8);
		    				//		String contractTypesCommDetails = ExcelUtils.getCellData(count, 9);
		    						
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("End of Test Data");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("Contract Types Edit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("Contract Types Edit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
   		 	editContractTypesMultiple(driver,contractTypesCode, contractTypesRecordMark);
		    		}
		    	}
			}catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void editContractTypesMultiple(WebDriver driver,String contractTypesCode, String contractTypesRecordMark) throws Exception
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
			
			
			
		/*	
			MemberSupportingCodes payersPageObject = new MemberSupportingCodes(driver);
			payersPageObject.clickOnContractTypes();
					
			Thread.sleep(2000);
			*/
			ContractTypes contractTypesPageObject = new ContractTypes(driver);
			contractTypesPageObject.editContractTypes(contractTypesCode, contractTypesRecordMark);
			
			}

			  @AfterMethod
      		public void afterMethod() throws Exception {
      		if (driver!=null) driver.quit();
      		System.out.println("Done with Contract Types-Edit  \n\n");
      		Log.info("Done with Communication Contract Types-Edit  \n\n");
      		if (fis != null)
      				fis.close();
      	}
      }


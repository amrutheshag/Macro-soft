package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.OtherCredentiallingSourceTypes;
import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class OtherCredentiallingSourceTypesAddCommTestScript {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void OtherCredentiallingSourceTypesAddCommTestScript1() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing Other Credentialling Source Types- Add Comm");
			Log.info("Executing  Other Credentialling Source Types- Add Comm ");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_Add_OtherCredentiallingSourceTypes;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String othercredentiallingsourceTypesCode= ExcelUtils.getCellData(count,1);
		    		String othercredentiallingsourceTypesDescription=ExcelUtils.getCellData(count,2);	
		    		String othercredentiallingsourceTypesNewCode= ExcelUtils.getCellData(count, 3);
		    		String othercredentiallingsourceTypesNewDescription= ExcelUtils.getCellData(count, 4);
		    		String othercredentiallingsourceTypesEditDescription= ExcelUtils.getCellData(count, 5);
		    		
		    				
		    						String othercredentiallingsourceTypesCommSubject= ExcelUtils.getCellData(count, 6);
		    						String othercredentiallingsourceTypesCommNoteType = ExcelUtils.getCellData(count, 7);
		    						String othercredentiallingsourceTypesCommMedium = ExcelUtils.getCellData(count, 8);
		    						String othercredentiallingsourceTypesCommDetails = ExcelUtils.getCellData(count, 9);
		    						
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("End of Test Data");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("Other Credentialling Source Types Add Comm- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("Other Credentialling Source Types Add Comm- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
   		 	addCommOtherCredentiallingSourceTypesMultiple(driver, othercredentiallingsourceTypesCode, othercredentiallingsourceTypesDescription, othercredentiallingsourceTypesCommSubject, othercredentiallingsourceTypesCommNoteType, othercredentiallingsourceTypesCommMedium, othercredentiallingsourceTypesCommDetails);
		    		}
		    	}
			}catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void addCommOtherCredentiallingSourceTypesMultiple(WebDriver driver,String othercredentiallingsourceTypesCode, String othercredentiallingsourceTypesDescription, String othercredentiallingsourceTypesCommSubject, String othercredentiallingsourceTypesCommNoteType, String othercredentiallingsourceTypesCommMedium, String othercredentiallingsourceTypesCommDetails) throws Exception
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

			homePageObject.clickReferencegotoOtherCredentiallingSourceTypes();	
			
			Thread.sleep(2000);
			
			OtherCredentiallingSourceTypes othercredentiallingsourceTypesPageObject = new OtherCredentiallingSourceTypes(driver);
			othercredentiallingsourceTypesPageObject.addCommOtherCredentiallingSourceTypes(othercredentiallingsourceTypesCode,  othercredentiallingsourceTypesDescription,  othercredentiallingsourceTypesCommSubject,  othercredentiallingsourceTypesCommNoteType,  othercredentiallingsourceTypesCommMedium,  othercredentiallingsourceTypesCommDetails);
			
			}

		    @AfterMethod
      		public void afterMethod() throws Exception {
      		if (driver!=null) driver.quit();
      		System.out.println("Done with Other Credentialling Source Types-Add Comm  \n\n");
      		Log.info("log4j -Done with Other Credentialling Source Types-Add Comm  \n\n");
      		if (fis != null) 	fis.close();
      	}
      }








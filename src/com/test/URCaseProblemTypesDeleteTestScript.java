package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.URCaseProblemTypes;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class URCaseProblemTypesDeleteTestScript {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void URCaseProblemTypesDeleteTestScript1() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing UR Case/Problem Types- Delete");
			Log.info("Executing  UR Case/Problem Types- Delete ");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_Delete_URCaseProblemTypes;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String urcaseproblemTypesCode= ExcelUtils.getCellData(count,1);
		    		String urcaseproblemTypesDescription=ExcelUtils.getCellData(count,2);	
		    		String urcaseproblemTypesNewCode= ExcelUtils.getCellData(count, 3);
		    		String urcaseproblemTypesNewDescription= ExcelUtils.getCellData(count, 4);
		    		String urcaseproblemTypesEditDescription= ExcelUtils.getCellData(count, 5);
		    		
		    				
		    						String urcaseproblemTypesCommSubject= ExcelUtils.getCellData(count, 6);
		    						String urcaseproblemTypesCommNoteType = ExcelUtils.getCellData(count, 7);
		    						String urcaseproblemTypesCommNoteMedium = ExcelUtils.getCellData(count, 8);
		    						String urcaseproblemTypesCommDetails = ExcelUtils.getCellData(count, 9);
		    						
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("End of Test Data");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("UR Case/Problem Types Delete- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("UR Case/Problem Types Delete- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
   		 	deleteURCaseProblemTypesMultiple(driver,urcaseproblemTypesCode, urcaseproblemTypesDescription);
		    		}
		    	}
			}catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void deleteURCaseProblemTypesMultiple(WebDriver driver,String urcaseproblemTypesCode, String urcaseproblemTypesDescription) throws Exception
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

			homePageObject.clickReferencegotoURCaseProblemTypes();	
			
			Thread.sleep(2000);
			URCaseProblemTypes urcaseproblemTypesPageObject = new URCaseProblemTypes(driver);
			urcaseproblemTypesPageObject.deleteURCaseProblemTypes(urcaseproblemTypesCode, urcaseproblemTypesDescription);
			
			}

			  @AfterMethod
	      		public void afterMethod() throws Exception {
	      		if (driver!=null) driver.quit();
	      		System.out.println("Done with UR Case/Problem Types-Delete \n\n");
	      		Log.info("log4j-Done with UR Case/Problem Types-Delete \n\n");
	      		if (fis != null) 		fis.close();
	      	}
	      }






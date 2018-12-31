package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.pages.HomePage;
import com.pages.OccupationalClasses;
import com.pages.LoginPage;
import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class OccupationalClassesExitTestScript {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void OccupationalClassesExitTestScript1() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing Occupational Classes- Exit");
			Log.info("Executing  Occupational Classes- Exit ");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_Add_OccupationalClasses;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String occupationalClassesCode= ExcelUtils.getCellData(count,1);
		    		String occupationalClassesDescription=ExcelUtils.getCellData(count,2);	
		    		String occupationalClassesNewCode= ExcelUtils.getCellData(count, 3);
		    		String occupationalClassesNewDescription= ExcelUtils.getCellData(count, 4);
		    		String occupationalClassesEditDescription= ExcelUtils.getCellData(count, 5);
		    		
		    				
		    						String occupationalClassesCommSubject= ExcelUtils.getCellData(count, 6);
		    						String occupationalClassesCommNoteType = ExcelUtils.getCellData(count, 7);
		    						String occupationalClassesCommNoteMedium = ExcelUtils.getCellData(count, 8);
		    						String occupationalClassesCommDetails = ExcelUtils.getCellData(count, 9);
		    						
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("End of Test Data");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("Occupational Classes Exit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("Occupational Classes Exit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
   		 	exitOccupationalClassesMultiple(driver,occupationalClassesCode);
		    		}
		    	}
			}catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void exitOccupationalClassesMultiple(WebDriver driver,String occupationalClassesCode) throws Exception
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

			homePageObject.clickReferencegotoOccupationalClasses();
			
			
			Thread.sleep(2000);

			//exit
			OccupationalClasses occupationalClassesPageObject = new OccupationalClasses(driver);
			occupationalClassesPageObject.exitOccupationalClasses(occupationalClassesCode);
			
			}

		@AfterMethod
		public void afterMethod() throws Exception {
		if (driver!=null) driver.quit();
		System.out.println("Done with Occupational Classes-Exit  \n\n");
		if (fis != null)	fis.close();
	}
}



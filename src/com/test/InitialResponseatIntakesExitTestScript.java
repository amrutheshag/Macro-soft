package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.InitialResponseatIntakes;
import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class InitialResponseatIntakesExitTestScript {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void InitialResponseatIntakesExitTestScript1() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing Initial Response at Intakes- Exit");
			Log.info("Executing  Initial Response at Intakes- Exit ");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_Add_InitialResponseatIntakes;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String initialresponseatIntakesCode= ExcelUtils.getCellData(count,1);
		    		String initialresponseatIntakesDescription=ExcelUtils.getCellData(count,2);	
		    		String initialresponseatIntakesNewCode= ExcelUtils.getCellData(count, 3);
		    		String initialresponseatIntakesNewDescription= ExcelUtils.getCellData(count, 4);
		    		String initialresponseatIntakesEditDescription= ExcelUtils.getCellData(count, 5);
		    		
		    				
		    						String initialresponseatIntakesCommSubject= ExcelUtils.getCellData(count, 6);
		    						String initialresponseatIntakesCommNoteType = ExcelUtils.getCellData(count, 7);
		    						String initialresponseatIntakesCommNoteMedium = ExcelUtils.getCellData(count, 8);
		    						String initialresponseatIntakesCommDetails = ExcelUtils.getCellData(count, 9);
		    						
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("End of Test Data");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("Initial Response at Intakes Exit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("Initial Response at Intakes Exit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
   		 	exitInitialResponseatIntakesMultiple(driver,initialresponseatIntakesCode);
		    		}
		    	}
			}catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void exitInitialResponseatIntakesMultiple(WebDriver driver,String initialresponseatIntakesCode) throws Exception
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

			homePageObject.clickReferencegotoInitialResponseatIntakes();
			Thread.sleep(2000);
			
            InitialResponseatIntakes initialresponseatIntakesPageObject = new InitialResponseatIntakes(driver);
			initialresponseatIntakesPageObject.exitInitialResponseatIntakes( initialresponseatIntakesCode);
			
			}

			@AfterMethod
      		public void afterMethod() throws Exception {
      		if (driver!=null) driver.quit();
      		System.out.println("Done with Initial Response at Intakes-Exit \n\n");
      		Log.info("log4j -Done with Initial Response at Intakes-Exit \n\n");
      		if (fis != null) 
      				fis.close();
      	}
      }








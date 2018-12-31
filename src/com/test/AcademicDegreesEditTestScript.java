package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.AcademicDegrees;
import com.pages.HomePage;
import com.pages.LoginPage;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class AcademicDegreesEditTestScript {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void AcademicDegreesEditTestScript1() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing Academic Degrees- Edit");
			Log.info("Executing  Academic Degrees- Edit ");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_Add_AcademicDegrees;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String academicDegreesCode= ExcelUtils.getCellData(count,1);
		    		String academicDegreesDescription=ExcelUtils.getCellData(count,2);	
		    		//String academicDegreesNewCode= ExcelUtils.getCellData(count, 3);
		    		//String academicDegreesNewDescription= ExcelUtils.getCellData(count, 4);
		    		String academicDegreesRecordMark= ExcelUtils.getCellData(count, 5);
		    		
		    							
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("End of Test Data");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("Academic Degrees Edit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("Academic Degrees Edit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
   		 	editAcademicDegreesMultiple(driver, academicDegreesCode, academicDegreesDescription, academicDegreesRecordMark);
		    		}
		    	}
			}catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void editAcademicDegreesMultiple(WebDriver driver, String AcademicDegreesCode, String AcademicDegreesDescription, String AcademicDegreesRecordMark) throws Exception
			{
			
			
			// Launch Chrome Browser
			driver= BrowserUtils.openChromeBrowser();
						
			//open risk manager
			driver.get(Constant.URL);
			System.out.println("Browser Launched");
						
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

			homePageObject.clickReferencegotoAcademicDegrees();	
			
			
			Thread.sleep(2000);
			
        		AcademicDegrees academicDegreesPageObject = new AcademicDegrees(driver);
        		academicDegreesPageObject.editAcademicDegrees(AcademicDegreesCode, AcademicDegreesDescription, AcademicDegreesRecordMark);
			
			}

			@AfterMethod
			public void afterMethod() throws Exception {
			if (driver!=null) driver.quit();
			System.out.println("Done with Academic Degrees-Edit \n\n");
			Log.info("log4j -Done with Academic Degrees-Edit \n\n");
			if (fis != null) 
					fis.close();
				
		}
	}





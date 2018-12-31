package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.InsuranceCoverageExtents;
import com.pages.HomePage;
import com.pages.LoginPage;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class InsuranceCoverageExtentsEditTestScript {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void InsuranceCoverageExtentsEditTestScript1() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing Insurance Coverage Extents- Edit");
			Log.info("Executing  Insurance Coverage Extents- Edit ");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_Add_InsuranceCoverageExtents;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String insurancecoverageExtentsCode= ExcelUtils.getCellData(count,1);
		    		String insurancecoverageExtentsDescription=ExcelUtils.getCellData(count,2);	
		    		String insurancecoverageExtentsNewCode= ExcelUtils.getCellData(count, 3);
		    		String insurancecoverageExtentsNewDescription= ExcelUtils.getCellData(count, 4);
		    		String insurancecoverageExtentsRecordMark= ExcelUtils.getCellData(count, 5);
		    		
		    				
		    						//String insurancecoverageExtentsCommSubject= ExcelUtils.getCellData(count, 6);
		    						///String insurancecoverageExtentsCommNoteType = ExcelUtils.getCellData(count, 7);
		    						//String insurancecoverageExtentsCommNoteMedium = ExcelUtils.getCellData(count, 8);
		    				//		String insurancecoverageExtentsCommDetails = ExcelUtils.getCellData(count, 9);
		    						
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("End of Test Data");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("Insurance Coverage Extents Edit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("Insurance Coverage Extents Edit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
   		 	editInsuranceCoverageExtentsMultiple(driver,insurancecoverageExtentsCode, insurancecoverageExtentsDescription, insurancecoverageExtentsRecordMark);
		    		}
		    	}
			}catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void editInsuranceCoverageExtentsMultiple(WebDriver driver,String insurancecoverageExtentsCode, String insurancecoverageExtentsDescription, String insurancecoverageExtentsRecordMark) throws Exception
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

			homePageObject.clickReferencegotoInsuranceCoverageExtents();	
			
			
			
			InsuranceCoverageExtents insurancecoverageExtentsPageObject = new InsuranceCoverageExtents(driver);
			insurancecoverageExtentsPageObject.editInsuranceCoverageExtents(insurancecoverageExtentsCode, insurancecoverageExtentsDescription, insurancecoverageExtentsRecordMark);
			
			}

			@AfterMethod
      		public void afterMethod() throws Exception {
      		if (driver!=null) driver.quit();
      		System.out.println("Done with Insurance Coverage Extents-edit  \n\n");
      		Log.info("log4j -Done with Insurance Coverage Extents-edit  \n\n");
      		if (fis != null) 
      				fis.close();
      	}
      }


package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.DiagnosisCodes;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class DiagnosisCodesExitTestScript {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void DiagnosisCodesExitTestScript1() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing Diagnosis Codes- Exit");
			Log.info("Executing  Diagnosis Codes- Exit ");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_Add_DiagnosisCodes;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String diagnosisCodesCode= ExcelUtils.getCellData(count,1);
		    		String diagnosisCodesDescription=ExcelUtils.getCellData(count,2);	
		    		String diagnosisCodesNewCode= ExcelUtils.getCellData(count, 3);
		    		String diagnosisCodesNewDescription= ExcelUtils.getCellData(count, 4);
		    		String diagnosisCodesEditDescription= ExcelUtils.getCellData(count, 5);
		    		
		    				
		    						String diagnosisCodesCommSubject= ExcelUtils.getCellData(count, 6);
		    						String diagnosisCodesCommNoteType = ExcelUtils.getCellData(count, 7);
		    						String diagnosisCodesCommNoteMedium = ExcelUtils.getCellData(count, 8);
		    						String diagnosisCodesCommDetails = ExcelUtils.getCellData(count, 9);
		    						
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("End of Test Data");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("Diagnosis Codes Exit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("Diagnosis Codes Exit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
   		 	exitDiagnosisCodesMultiple(driver,diagnosisCodesCode);
		    		}
		    	}
			}catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void exitDiagnosisCodesMultiple(WebDriver driver,String diagnosisCodesCode) throws Exception
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

			homePageObject.clickReferencegotoDiagnosisCodes();
			
			
			Thread.sleep(2000);
			
            
            /*          
                         MemberSupportingCodes MemberSupportingCodesObject = new MemberSupportingCodes(driver);
                 		MemberSupportingCodesObject.clickOnDiagnosisCodes(); 
                      
               */    
			
			DiagnosisCodes diagnosisCodesPageObject = new DiagnosisCodes(driver);
			diagnosisCodesPageObject.exitDiagnosisCodes(diagnosisCodesCode);
			
			}

			  @AfterMethod
       		public void afterMethod() throws Exception {
       		if (driver!=null) driver.quit();
       		System.out.println("Done with Diagnosis Codes-Exit  \n\n");
       		Log.info("Done with Diagnosis Codes-Exit  \n\n");
       		if (fis != null) 
       				fis.close();
       	}
       }




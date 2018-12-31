package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.InpatientWardsUnits;
import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class InpatientWardsUnitsCopyTestScript {
	 WebDriver driver;
     FileInputStream fis;
                     @Test
                     public void InpatientWardsUnitsCopyTestScript1() throws Exception{
                                     DOMConfigurator.configure("log4j.xml");
                                     System.out.println("\n*****************************************************\n");
                                     Log.info("\n*****************************************************\n");
                                     System.out.println("Executing Inpatient Wards/Units- Copy");
                                     Log.info("Executing  Inpatient Wards/Units- Copy ");
                                     
                                     
                                     try{
                                                     String Path=Constant.Path_TestData + Constant.File_Add_InpatientWardsUnits;
                                                     int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
                                     for (int count=1; count<=rowCount; count++){
                                                     String inpatientwardsUnitsCode= ExcelUtils.getCellData(count,1);
                                                     String inpatientwardsUnitsDescription=ExcelUtils.getCellData(count,2); 
                                                     String inpatientwardsUnitsNewCode= ExcelUtils.getCellData(count, 3);
                                                     String inpatientwardsUnitsNewDescription= ExcelUtils.getCellData(count, 4);
                                                     String inpatientwardsUnitsEditDescription= ExcelUtils.getCellData(count, 5);
                                                     
                                                                                     
                                                                                                                     String inpatientwardsUnitsCommSubject= ExcelUtils.getCellData(count, 6);
                                                                                                                     String inpatientwardsUnitsCommNoteType = ExcelUtils.getCellData(count, 7);
                                                                                                                     String inpatientwardsUnitsCommNoteMedium = ExcelUtils.getCellData(count, 8);
                                                                                                                     String inpatientwardsUnitsCommDetails = ExcelUtils.getCellData(count, 9);
                                                                                                                     
                                                     if (ExcelUtils.getCellData(count,0).isEmpty())
                                                     {System.out.println("End of Test Data");}
                                                     else{
                                                     
                                                     System.out.println("\n----------------------------------------------------\n");
                                                                     System.out.println("Inpatient Wards/Units Copy- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
                                                                     System.out.println("\n----------------------------------------------------\n");
                                                                     Log.info("----------------------------------------------------");
                                                                     Log.info("Inpatient Wards/Units Copy- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
                                                                     Log.info("----------------------------------------------------");
                                     copyInpatientWardsUnitsMultiple(driver,inpatientwardsUnitsCode, inpatientwardsUnitsNewCode, inpatientwardsUnitsNewDescription);
                                                     }
                                     }
                                     }catch (Exception e) {e.printStackTrace();System.out.println("Test Data File not found");e.printStackTrace();}
                     }
                     
                                     
                                     public void copyInpatientWardsUnitsMultiple(WebDriver driver,String inpatientwardsUnitsCode, String inpatientwardsUnitsNewCode, String inpatientwardsUnitsNewDescription) throws Exception
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

                                     homePageObject.clickReferencegotoInpatientWardsUnits();     
                                     
                                     
                                     InpatientWardsUnits inpatientwardsUnitsPageObject = new InpatientWardsUnits(driver);
                                     inpatientwardsUnitsPageObject.copyInpatientWardsUnits( inpatientwardsUnitsCode, inpatientwardsUnitsNewCode, inpatientwardsUnitsNewDescription);
                                     
                                     }

                                     @AfterMethod
	                    	      		public void afterMethod() throws Exception {
	                    	      		if (driver!=null) driver.quit();
	                    	      		System.out.println("Done with Inpatient Wards/Units-Copy \n\n");
	                    	      		Log.info("log4j -Done with Inpatient Wards/Units-Copy \n\n");
	                    	      		if (fis != null) 
	                    	      				fis.close();
	                    	      	}
	                    	      }



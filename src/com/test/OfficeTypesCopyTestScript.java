package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.pages.OfficeTypes;
import com.pages.HomePage;
import com.pages.LoginPage;
import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class OfficeTypesCopyTestScript {
	 WebDriver driver;
     FileInputStream fis;
                     @Test
                     public void OfficeTypesCopyTestScript1() throws Exception{
                                     DOMConfigurator.configure("log4j.xml");
                                     System.out.println("\n*****************************************************\n");
                                     Log.info("\n*****************************************************\n");
                                     System.out.println("Executing Office Types- Copy");
                                     Log.info("Executing  Office Types- Copy ");
                                     
                                     
                                     try{
                                                     String Path=Constant.Path_TestData + Constant.File_Add_OfficeTypes;
                                                     int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
                                     for (int count=1; count<=rowCount; count++){
                                                     String officeTypesCode= ExcelUtils.getCellData(count,1);
                                                     String officeTypesDescription=ExcelUtils.getCellData(count,2); 
                                                     String officeTypesNewCode= ExcelUtils.getCellData(count, 3);
                                                     String officeTypesNewDescription= ExcelUtils.getCellData(count, 4);
                                                     String officeTypesEditDescription= ExcelUtils.getCellData(count, 5);
                                                     
                                                                                     
                                                                                                                     String officeTypesCommSubject= ExcelUtils.getCellData(count, 6);
                                                                                                                     String officeTypesCommNoteType = ExcelUtils.getCellData(count, 7);
                                                                                                                     String officeTypesCommNoteMedium = ExcelUtils.getCellData(count, 8);
                                                                                                                     String officeTypesCommDetails = ExcelUtils.getCellData(count, 9);
                                                                                                                     
                                                     if (ExcelUtils.getCellData(count,0).isEmpty())
                                                     {System.out.println("End of Test Data");}
                                                     else{
                                                     
                                                     System.out.println("\n----------------------------------------------------\n");
                                                                     System.out.println("Office Types Copy- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
                                                                     System.out.println("\n----------------------------------------------------\n");
                                                                     Log.info("----------------------------------------------------");
                                                                     Log.info("Office Types Copy- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
                                                                     Log.info("----------------------------------------------------");
                                     copyOfficeTypesMultiple(driver,officeTypesCode, officeTypesNewCode, officeTypesNewDescription);
                                                     }
                                     }
                                     }catch (Exception e) {e.printStackTrace();System.out.println("Test Data File not found");e.printStackTrace();}
                     }
                     
                                     
                                     public void copyOfficeTypesMultiple(WebDriver driver,String officeTypesCode, String officeTypesNewCode, String officeTypesNewDescription) throws Exception
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

                                     homePageObject.clickReferencegotoOfficeTypes();     
                                     OfficeTypes officeTypesPageObject = new OfficeTypes(driver);
                                     officeTypesPageObject.copyOfficeTypes(officeTypesCode, officeTypesNewCode, officeTypesNewDescription);
                                     
                                     }

                                     @AfterMethod
	                    	      		public void afterMethod() throws Exception {
	                    	      		if (driver!=null) driver.quit();
	                    	      		System.out.println("Done with Office Types-Copy \n\n");
	                    	      		Log.info("log4j -Done with Office Types-Copy \n\n");
	                    	      		if (fis != null) 		fis.close();
	                    	      	}
	                    	      }
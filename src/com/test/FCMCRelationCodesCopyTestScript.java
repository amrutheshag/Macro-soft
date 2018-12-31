package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.FCMCRelationCodes;
import com.pages.HomePage;
import com.pages.LoginPage;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class FCMCRelationCodesCopyTestScript {
	 WebDriver driver;
     FileInputStream fis;
                     @Test
                     public void FCMCRelationCodesCopyTestScript1() throws Exception{
                                     DOMConfigurator.configure("log4j.xml");
                                     System.out.println("\n*****************************************************\n");
                                     Log.info("\n*****************************************************\n");
                                     System.out.println("Executing FCMC Relation Codes- Copy");
                                     Log.info("Executing  FCMC Relation Codes- Copy ");
                                     
                                     
                                     try{
                                                     String Path=Constant.Path_TestData + Constant.File_Add_FCMCRelationCodes;
                                                     int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
                                     for (int count=1; count<=rowCount; count++){
                                                     String fcmcrelationCodesCode= ExcelUtils.getCellData(count,1);
                                                     String fcmcrelationCodesDescription=ExcelUtils.getCellData(count,2); 
                                                     String fcmcrelationCodesNewCode= ExcelUtils.getCellData(count, 3);
                                                     String fcmcrelationCodesNewDescription= ExcelUtils.getCellData(count, 4);
                                                     String fcmcrelationCodesEditDescription= ExcelUtils.getCellData(count, 5);
                                                     
                                                                                     
                                                                                                                     String fcmcrelationCodesCommSubject= ExcelUtils.getCellData(count, 6);
                                                                                                                     String fcmcrelationCodesCommNoteType = ExcelUtils.getCellData(count, 7);
                                                                                                                     String fcmcrelationCodesCommNoteMedium = ExcelUtils.getCellData(count, 8);
                                                                                                                     String fcmcrelationCodesCommDetails = ExcelUtils.getCellData(count, 9);
                                                                                                                     
                                                     if (ExcelUtils.getCellData(count,0).isEmpty())
                                                     {System.out.println("End of Test Data");}
                                                     else{
                                                     
                                                     System.out.println("\n----------------------------------------------------\n");
                                                                     System.out.println("FCMC Relation Codes Copy- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
                                                                     System.out.println("\n----------------------------------------------------\n");
                                                                     Log.info("----------------------------------------------------");
                                                                     Log.info("FCMC Relation Codes Copy- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
                                                                     Log.info("----------------------------------------------------");
                                     copyFCMCRelationCodesMultiple(driver,fcmcrelationCodesCode, fcmcrelationCodesNewCode, fcmcrelationCodesNewDescription);
                                                     }
                                     }
                                     }catch (Exception e) {e.printStackTrace();System.out.println("Test Data File not found");e.printStackTrace();}
                     }
                     
                                     
                                     public void copyFCMCRelationCodesMultiple(WebDriver driver,String fcmcrelationCodesCode, String fcmcrelationCodesNewCode, String fcmcrelationCodesNewDescription) throws Exception
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

                                     homePageObject.clickReferencegotoFCMCRelationCodes();     
                                     
                                     FCMCRelationCodes fcmcrelationCodesPageObject = new FCMCRelationCodes(driver);
                                     fcmcrelationCodesPageObject.copyFCMCRelationCodes( fcmcrelationCodesCode, fcmcrelationCodesNewCode, fcmcrelationCodesNewDescription);
                                     
                                     }

                                     @AfterMethod
	                            		public void afterMethod() throws Exception {
	                            		if (driver!=null) driver.quit();
	                            		System.out.println("Done with FCMC Relation Codes-Copy  \n\n");
	                            		Log.info("log4j -Done with FCMC Relation Codes-Copy  \n\n");
	                            		if (fis != null)	fis.close();
	                            				
	                            	}
	                            }




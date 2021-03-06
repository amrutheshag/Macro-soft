package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.UMCaseStatusCodes;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class UMCaseStatusCodesAddTestScript {
	 WebDriver driver;
     FileInputStream fis;
                     @Test
                     public void UMCaseStatusCodesAddTestScript1() throws Exception{
                                     DOMConfigurator.configure("log4j.xml");
                                     System.out.println("\n*****************************************************\n");
                                     Log.info("\n*****************************************************\n");
                                     System.out.println("Executing UM Case Status Codes- Add");
                                     Log.info("Executing  UM Case Status Codes- Add ");
                                     
                                     
                                     try{
                                                     String Path=Constant.Path_TestData + Constant.File_Add_UMCaseStatusCodes;
                                                     int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
                                     for (int count=1; count<=rowCount; count++){
                                                     String umcasestatusCodesCode= ExcelUtils.getCellData(count,1);
                                                     String umcasestatusCodesName=ExcelUtils.getCellData(count,2); 
                                                     String umcasestatusCodesNewCode= ExcelUtils.getCellData(count, 3);
                                                     String umcasestatusCodesNewName= ExcelUtils.getCellData(count, 4);
                                                     String umcasestatusCodesEditName= ExcelUtils.getCellData(count, 5);
                                                     
                                                                                     
                                                                                                                     String umcasestatusCodesCommSubject= ExcelUtils.getCellData(count, 6);
                                                                                                                     String  umcasestatusCodesCommNoteType = ExcelUtils.getCellData(count, 7);
                                                                                                                     String  umcasestatusCodesCommNoteMedium = ExcelUtils.getCellData(count, 8);
                                                                                                                     String  umcasestatusCodesCommDetails = ExcelUtils.getCellData(count, 9);
                                                                                                                     
                                                     if (ExcelUtils.getCellData(count,0).isEmpty())
                                                     {System.out.println("End of Test Data");}
                                                     else{
                                                     
                                                     System.out.println("\n----------------------------------------------------\n");
                                                                     System.out.println("UM Case Status Codes Add- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
                                                                     System.out.println("\n----------------------------------------------------\n");
                                                                     Log.info("----------------------------------------------------");
                                                                     Log.info("UM Case Status Codes Add- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
                                                                     Log.info("----------------------------------------------------");
                                                                     addumcasestatusCodesMultiple(driver,umcasestatusCodesCode, umcasestatusCodesName);
                                                     }
                                     }
                                     }catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
                     }
                     
                                     
                                     public void addumcasestatusCodesMultiple(WebDriver driver,String umcasestatusCodesCode, String umcasestatusCodesName) throws Exception
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

                         			homePageObject.clickReferencegotoUMCaseStatusCodes();	
                         			   
                                     
                                     UMCaseStatusCodes UMCaseStatusCodesObject = new UMCaseStatusCodes(driver);
                                     UMCaseStatusCodesObject.addUMCaseStatusCodes(umcasestatusCodesCode, umcasestatusCodesName);
                                     
                                     }
                                     @AfterMethod
                             		public void afterMethod() throws Exception {
                             		if (driver!=null) driver.quit();
                             		System.out.println("Done with UM Case Status Codes-Add \n\n");
                             		Log.info("log4j-Done with UM Case Status Codes-Add \n\n");
                             		if (fis != null)
                             				fis.close();
                             	}
                             }

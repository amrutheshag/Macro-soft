package com.test;

import java.io.FileInputStream;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.DispositionCodes;
import com.pages.HomePage;
import com.pages.LoginPage;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class DispositionCodesAddTestScript {
	 WebDriver driver;
     FileInputStream fis;
                     @Test
                     public void DispositionCodesAddTestScript1() throws Exception{
                                     DOMConfigurator.configure("log4j.xml");
                                     System.out.println("\n*****************************************************\n");
                                     Log.info("\n*****************************************************\n");
                                     System.out.println("Executing Disposition Codes- Add");
                                     Log.info("Executing  Disposition Codes- Add ");
                                     
                                     
                                     try{
                                                     String Path=Constant.Path_TestData + Constant.File_Add_DispositionCodes;
                                                     int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
                                     for (int count=1; count<=rowCount; count++){
                                                     String dispositionCodesCode= ExcelUtils.getCellData(count,1);
                                                     String DispositionCodesDescriptionInput=ExcelUtils.getCellData(count,2); 
                                                     String dispositionCodesNewCode= ExcelUtils.getCellData(count, 3);
                                                     String dispositionCodesNewName= ExcelUtils.getCellData(count, 4);
                                                     String dispositionCodesEditName= ExcelUtils.getCellData(count, 5);
                                                     String DiagnosticCategory=ExcelUtils.getCellData(count, 10);
                                                     
                                                                                     
                                                                                                                     String dispositionCodesCommSubject= ExcelUtils.getCellData(count, 6);
                                                                                                                     String  dispositionCodesCommNoteType = ExcelUtils.getCellData(count, 7);
                                                                                                                     String  dispositionCodesCommNoteMedium = ExcelUtils.getCellData(count, 8);
                                                                                                                     String  dispositionCodesCommDetails = ExcelUtils.getCellData(count, 9);
                                                                                                                     
                                                     if (ExcelUtils.getCellData(count,0).isEmpty())
                                                     {System.out.println("End of Test Data");}
                                                     else{
                                                     
                                                     System.out.println("\n----------------------------------------------------\n");
                                                                     System.out.println("Disposition Codes Add- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
                                                                     System.out.println("\n----------------------------------------------------\n");
                                                                     Log.info("----------------------------------------------------");
                                                                     Log.info("Disposition Codes Add- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
                                                                     Log.info("----------------------------------------------------");
                                                                     adddispositionCodesMultiple(driver,dispositionCodesCode, DispositionCodesDescriptionInput, DiagnosticCategory);
                                                     }
                                     }
                                     }catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
                     }
                     
                                     
                                     public void adddispositionCodesMultiple(WebDriver driver,String dispositionCodesCode, String DispositionCodesDescriptionInput, String DiagnosticCategory) throws Exception
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

                         			homePageObject.clickReferencegotoDispositionCodes();	
                         			   
                                     
                                     
                        /*          
                                     MemberSupportingCodes MemberSupportingCodesObject = new MemberSupportingCodes(driver);
                             		MemberSupportingCodesObject.clickOnDispositionCodes(); 
                                  
                           */          
                                  
                                     
                         			DispositionCodes DispositionCodesObject = new DispositionCodes(driver);
                                     DispositionCodesObject.addDispositionCodes(dispositionCodesCode, DispositionCodesDescriptionInput, DiagnosticCategory);
                                     
                                     }

                                     @AfterMethod
                             		public void afterMethod() throws Exception {
                             		if (driver!=null) driver.quit();
                             		System.out.println("Done with Disposition codes-Add   \n\n");
                             		if (fis != null) 
                             				fis.close();
                             	}               

}




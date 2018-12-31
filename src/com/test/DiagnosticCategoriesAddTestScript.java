package com.test;

import java.io.FileInputStream;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.DiagnosticCategories;
import com.pages.HomePage;
import com.pages.LoginPage;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class DiagnosticCategoriesAddTestScript {
	 WebDriver driver;
     FileInputStream fis;
                     @Test
                     public void DiagnosticCategoriesAddTestScript1() throws Exception{
                                     DOMConfigurator.configure("log4j.xml");
                                     System.out.println("\n*****************************************************\n");
                                     Log.info("\n*****************************************************\n");
                                     System.out.println("Executing Diagnostic Categories- Add");
                                     Log.info("Executing  Diagnostic Categories- Add ");
                                     
                                     
                                     try{
                                                     String Path=Constant.Path_TestData + Constant.File_Add_DiagnosticCategories;
                                                     int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
                                     for (int count=1; count<=rowCount; count++){
                                                     String diagnosticCategoriesCode= ExcelUtils.getCellData(count,1);
                                                     String diagnosticCategoriesName=ExcelUtils.getCellData(count,2); 
                                                     String diagnosticCategoriesNewCode= ExcelUtils.getCellData(count, 3);
                                                     String diagnosticCategoriesNewName= ExcelUtils.getCellData(count, 4);
                                                     String diagnosticCategoriesEditName= ExcelUtils.getCellData(count, 5);
                                                     
                                                                                     
                                                                                                                     String diagnosticCategoriesCommSubject= ExcelUtils.getCellData(count, 6);
                                                                                                                     String  diagnosticCategoriesCommNoteType = ExcelUtils.getCellData(count, 7);
                                                                                                                     String  diagnosticCategoriesCommNoteMedium = ExcelUtils.getCellData(count, 8);
                                                                                                                     String  diagnosticCategoriesCommDetails = ExcelUtils.getCellData(count, 9);
                                                                                                                     
                                                     if (ExcelUtils.getCellData(count,0).isEmpty())
                                                     {System.out.println("End of Test Data");}
                                                     else{
                                                     
                                                     System.out.println("\n----------------------------------------------------\n");
                                                                     System.out.println("Diagnostic Categories Add- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
                                                                     System.out.println("\n----------------------------------------------------\n");
                                                                     Log.info("----------------------------------------------------");
                                                                     Log.info("Diagnostic Categories Add- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
                                                                     Log.info("----------------------------------------------------");
                                                                     adddiagnosticCategoriesMultiple(driver,diagnosticCategoriesCode, diagnosticCategoriesName);
                                                     }
                                     }
                                     }catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
                     }
                     
                                     
                                     public void adddiagnosticCategoriesMultiple(WebDriver driver,String diagnosticCategoriesCode, String diagnosticCategoriesName) throws Exception
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

                         			homePageObject.clickReferencegotoDiagnosticCategories();	
                         			   
                                     
                                     
                        /*          
                                     MemberSupportingCodes MemberSupportingCodesObject = new MemberSupportingCodes(driver);
                             		MemberSupportingCodesObject.clickOnDiagnosticCategories(); 
                                  
                           */          
                                  
                                      DiagnosticCategories DiagnosticCategoriesObject = new DiagnosticCategories(driver);
                                     DiagnosticCategoriesObject.addDiagnosticCategories(diagnosticCategoriesCode, diagnosticCategoriesName);
                                     
                                     }

                                     @AfterMethod
                             		public void afterMethod() throws Exception {
                             		if (driver!=null) driver.quit();
                             		System.out.println("Done with Diagnostic Categories - Add  \n\n");
                             		if (fis != null) 
                             				fis.close();
                             	} 

}





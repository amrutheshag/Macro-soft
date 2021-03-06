package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.UMDegreesofClinicalUrgency;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class UMDegreesofClinicalUrgencyCopyTestScript {
	 WebDriver driver;
     FileInputStream fis;
                     @Test
                     public void UMDegreesofClinicalUrgencyCopyTestScript1() throws Exception{
                                     DOMConfigurator.configure("log4j.xml");
                                     System.out.println("\n*****************************************************\n");
                                     Log.info("\n*****************************************************\n");
                                     System.out.println("Executing UM Degrees of Clinical Urgency- Copy");
                                     Log.info("Executing  UM Degrees of Clinical Urgency- Copy ");
                                     
                                     
                                     try{
                                                     String Path=Constant.Path_TestData + Constant.File_Add_UMDegreesofClinicalUrgency;
                                                     int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
                                                     for (int count=1; count<=rowCount; count++){
                                                     String umdegreesofclinicalUrgencyCode= ExcelUtils.getCellData(count,1);
                                                     String umdegreesofclinicalUrgencyDescription=ExcelUtils.getCellData(count,2); 
                                                     String umdegreesofclinicalUrgencyNewCode= ExcelUtils.getCellData(count, 3);
                                                     String umdegreesofclinicalUrgencyNewDescription= ExcelUtils.getCellData(count, 4);
                                                     String umdegreesofclinicalUrgencyEditDescription= ExcelUtils.getCellData(count, 5);
                                                     
                                                                                     
                                                                                                                     String umdegreesofclinicalUrgencyCommSubject= ExcelUtils.getCellData(count, 6);
                                                                                                                     String umdegreesofclinicalUrgencyCommNoteType = ExcelUtils.getCellData(count, 7);
                                                                                                                     String umdegreesofclinicalUrgencyCommNoteMedium = ExcelUtils.getCellData(count, 8);
                                                                                                                     String umdegreesofclinicalUrgencyCommDetails = ExcelUtils.getCellData(count, 9);
                                                                                                                     
                                                     if (ExcelUtils.getCellData(count,0).isEmpty())
                                                     {System.out.println("End of Test Data");}
                                                     else{
                                                     
                                                     System.out.println("\n----------------------------------------------------\n");
                                                     System.out.println("UM Degrees of Clinical Urgency Copy- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
                                                                     System.out.println("\n----------------------------------------------------\n");
                                                                     Log.info("----------------------------------------------------");
                                                                     Log.info("UM Degrees of Clinical Urgency Copy- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
                                                                     Log.info("----------------------------------------------------");
                                     copyUMDegreesofClinicalUrgencyMultiple(driver,umdegreesofclinicalUrgencyCode, umdegreesofclinicalUrgencyNewCode, umdegreesofclinicalUrgencyNewDescription);
                                                     }
                                     }
                                     }catch (Exception e) {e.printStackTrace();System.out.println("Test Data File not found");e.printStackTrace();}
                     					}
                     
                                     
                                     public void copyUMDegreesofClinicalUrgencyMultiple(WebDriver driver,String umdegreesofclinicalUrgencyCode, String umdegreesofclinicalUrgencyNewCode, String umdegreesofclinicalUrgencyNewDescription) throws Exception
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
                                                                                                                     
                                     //click Payers-Emps
                                     HomePage homePageObject = new HomePage(driver);
                                     try{
                                         homePageObject.clickExitMyOpenCaseListing();
                                    }
                                     	catch(Exception e){ 
                                     		System.out.println("Blank Home Page");
                                     		Log.info("log4j - msg -Blank Home Page");
                                     	}

                                     homePageObject.clickReferencegotoUMDegreesofClinicalUrgency();     
                                     
                                     
                                     
                                      UMDegreesofClinicalUrgency umdegreesofclinicalUrgencyPageObject = new UMDegreesofClinicalUrgency(driver);
                                     umdegreesofclinicalUrgencyPageObject.copyUMDegreesofClinicalUrgency( umdegreesofclinicalUrgencyCode, umdegreesofclinicalUrgencyNewCode, umdegreesofclinicalUrgencyNewDescription);
                                     
                                     }

                                     @AfterMethod
	                            		public void afterMethod() throws Exception {
	                            		if (driver!=null) driver.quit();
	                            		System.out.println("Done with UM Degrees of Clinical Urgency-Copy \n\n");
	                            		Log.info("log4j-Done with UM Degrees of Clinical Urgency-Copy \n\n");
	                            		if (fis != null) 	fis.close();
	                            	}
	                            }




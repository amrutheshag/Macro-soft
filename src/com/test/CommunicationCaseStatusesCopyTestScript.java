package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.CommunicationCaseStatuses;
import com.pages.HomePage;
import com.pages.LoginPage;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class CommunicationCaseStatusesCopyTestScript {
	 WebDriver driver;
     FileInputStream fis;
                     @Test
                     public void CommunicationCaseStatusesCopyTestScript1() throws Exception{
                                     DOMConfigurator.configure("log4j.xml");
                                     System.out.println("\n*****************************************************\n");
                                     Log.info("\n*****************************************************\n");
                                     System.out.println("Executing Communication Case Statuses- Copy");
                                     Log.info("Executing  Communication Case Statuses- Copy ");
                                     
                                     
                                     try{
                                                     String Path=Constant.Path_TestData + Constant.File_Add_CommunicationCaseStatuses;
                                                     int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
                                     for (int count=1; count<=rowCount; count++){
                                                     String communicationcaseStatusesCode= ExcelUtils.getCellData(count,1);
                                                     String communicationcaseStatusesDescription=ExcelUtils.getCellData(count,2); 
                                                     String communicationcaseStatusesNewCode= ExcelUtils.getCellData(count, 3);
                                                     String communicationcaseStatusesNewDescription= ExcelUtils.getCellData(count, 4);
                                                     String communicationcaseStatusesEditDescription= ExcelUtils.getCellData(count, 5);
                                                     
                                                                                     
                                                                                                                     String communicationcaseStatusesCommSubject= ExcelUtils.getCellData(count, 6);
                                                                                                                     String communicationcaseStatusesCommNoteType = ExcelUtils.getCellData(count, 7);
                                                                                                                     String communicationcaseStatusesCommNoteMedium = ExcelUtils.getCellData(count, 8);
                                                                                                                     String communicationcaseStatusesCommDetails = ExcelUtils.getCellData(count, 9);
                                                                                                                     
                                                     if (ExcelUtils.getCellData(count,0).isEmpty())
                                                     {System.out.println("End of Test Data");}
                                                     else{
                                                     
                                                     System.out.println("\n----------------------------------------------------\n");
                                                                     System.out.println("Communication Case Statuses Copy- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
                                                                     System.out.println("\n----------------------------------------------------\n");
                                                                     Log.info("----------------------------------------------------");
                                                                     Log.info("Communication Case Statuses Copy- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
                                                                     Log.info("----------------------------------------------------");
                                     copyCommunicationCaseStatusesMultiple(driver,communicationcaseStatusesCode, communicationcaseStatusesNewCode, communicationcaseStatusesNewDescription);
                                                     }
                                     }
                                     }catch (Exception e) {e.printStackTrace();System.out.println("Test Data File not found");e.printStackTrace();}
                     }
                     
                                     
                                     public void copyCommunicationCaseStatusesMultiple(WebDriver driver,String communicationcaseStatusesCode, String communicationcaseStatusesNewCode, String communicationcaseStatusesNewDescription) throws Exception
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

                                     homePageObject.clickReferencegotoCommunicationCaseStatuses();     
                                     
                                     /* 
                                     	MemberSupportingCodes MemberSupportingCodesObject = new MemberSupportingCodes(driver);
                         				MemberSupportingCodesObject.clickOnCommunicationCaseStatuses();
                                      */                                    
                                   
                                     CommunicationCaseStatuses communicationcaseStatusesPageObject = new CommunicationCaseStatuses(driver);
                                     communicationcaseStatusesPageObject.copyCommunicationCaseStatuses( communicationcaseStatusesCode, communicationcaseStatusesNewCode, communicationcaseStatusesNewDescription);
                                     
                                     }

                                     @AfterMethod
	                            		public void afterMethod() throws Exception {
	                            		if (driver!=null) driver.quit();
	                            		System.out.println("Done with Communication Case Statuses-Copy  \n\n");
	                            		Log.info("log4j -Done with Communication Case Statuses-Copy  \n\n");
	                            		if (fis != null) 
	                            				fis.close();
	                            				
	                            	}
	                            }

	




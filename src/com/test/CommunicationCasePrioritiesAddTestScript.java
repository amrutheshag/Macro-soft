package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.CommunicationCasePriorities;
import com.pages.HomePage;
import com.pages.LoginPage;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class CommunicationCasePrioritiesAddTestScript {
	 WebDriver driver;
     FileInputStream fis;
                     @Test
                     public void CommunicationCasePrioritiesAddTestScript1() throws Exception{
                                     DOMConfigurator.configure("log4j.xml");
                                     System.out.println("\n*****************************************************\n");
                                     Log.info("\n*****************************************************\n");
                                     System.out.println("Executing Communication Case Priorities- Add");
                                     Log.info("Executing  Communication Case Priorities- Add ");
                                     
                                     
                                     try{
                                                     String Path=Constant.Path_TestData + Constant.File_Add_CommunicationCasePriorities;
                                                     int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
                                     for (int count=1; count<=rowCount; count++){
                                                     String communicationcasePrioritiesCode= ExcelUtils.getCellData(count,1);
                                                     String communicationcasePrioritiesName=ExcelUtils.getCellData(count,2); 
                                                     String communicationcasePrioritiesNewCode= ExcelUtils.getCellData(count, 3);
                                                     String communicationcasePrioritiesNewName= ExcelUtils.getCellData(count, 4);
                                                     String communicationcasePrioritiesEditName= ExcelUtils.getCellData(count, 5);
                                                     
                                                                                     
                                                                                                                     String communicationcasePrioritiesCommSubject= ExcelUtils.getCellData(count, 6);
                                                                                                                     String  communicationcasePrioritiesCommNoteType = ExcelUtils.getCellData(count, 7);
                                                                                                                     String  communicationcasePrioritiesCommNoteMedium = ExcelUtils.getCellData(count, 8);
                                                                                                                     String  communicationcasePrioritiesCommDetails = ExcelUtils.getCellData(count, 9);
                                                                                                                     
                                                     if (ExcelUtils.getCellData(count,0).isEmpty())
                                                     {System.out.println("End of Test Data");}
                                                     else{
                                                     
                                                     System.out.println("\n----------------------------------------------------\n");
                                                                     System.out.println("Communication Case Priorities Add- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
                                                                     System.out.println("\n----------------------------------------------------\n");
                                                                     Log.info("----------------------------------------------------");
                                                                     Log.info("Communication Case Priorities Add- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
                                                                     Log.info("----------------------------------------------------");
                                                                     addcommunicationcasePrioritiesMultiple(driver,communicationcasePrioritiesCode, communicationcasePrioritiesName);
                                                     }
                                     }
                                     }catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
                     }
                     
                                     
                                     public void addcommunicationcasePrioritiesMultiple(WebDriver driver,String communicationcasePrioritiesCode, String communicationcasePrioritiesName) throws Exception
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

                         			homePageObject.clickReferencegotoCommunicationCasePriorities();	
                         			   
                                     
                                     
                        /*          
                                     MemberSupportingCodes MemberSupportingCodesObject = new MemberSupportingCodes(driver);
                             		MemberSupportingCodesObject.clickOnCommunicationCasePriorities(); 
                                  
                           */          
                                  
                                     
                                     //add new Tier Copay Schedule
                                     CommunicationCasePriorities CommunicationCasePrioritiesObject = new CommunicationCasePriorities(driver);
                                     CommunicationCasePrioritiesObject.addCommunicationCasePriorities(communicationcasePrioritiesCode, communicationcasePrioritiesName);
                                     
                                     }
                                     @AfterMethod
                             		public void afterMethod() throws Exception {
                             		if (driver!=null) driver.quit();
                             		System.out.println("Done with Communication Case Priorities-Add   \n\n");
                             		Log.info("log4j -Done with Communication Case Priorities-Add  \n\n");
                             		if (fis != null) 
                             				fis.close();
                             	}
                            }




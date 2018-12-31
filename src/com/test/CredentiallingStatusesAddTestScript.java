package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.CredentiallingStatuses;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class CredentiallingStatusesAddTestScript {
	 WebDriver driver;
     FileInputStream fis;
                     @Test
                     public void CredentiallingStatusesAddTestScript1() throws Exception{
                                     DOMConfigurator.configure("log4j.xml");
                                     System.out.println("\n*****************************************************\n");
                                     Log.info("\n*****************************************************\n");
                                     System.out.println("Executing Credentialling Statuses- Add");
                                     Log.info("Executing  Credentialling Statuses- Add ");
                                     
                                     
                                     try{
                                                     String Path=Constant.Path_TestData + Constant.File_Add_CredentiallingStatuses;
                                                     int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
                                     for (int count=1; count<=rowCount; count++){
                                                     String credentiallingStatusesCode= ExcelUtils.getCellData(count,1);
                                                     String credentiallingStatusesName=ExcelUtils.getCellData(count,2); 
                                                     String credentiallingStatusesNewCode= ExcelUtils.getCellData(count, 3);
                                                     String credentiallingStatusesNewName= ExcelUtils.getCellData(count, 4);
                                                     String credentiallingStatusesEditName= ExcelUtils.getCellData(count, 5);
                                                     
                                                                                     
                                                                                                                     String credentiallingStatusesCommSubject= ExcelUtils.getCellData(count, 6);
                                                                                                                     String  credentiallingStatusesCommNoteType = ExcelUtils.getCellData(count, 7);
                                                                                                                     String  credentiallingStatusesCommNoteMedium = ExcelUtils.getCellData(count, 8);
                                                                                                                     String  credentiallingStatusesCommDetails = ExcelUtils.getCellData(count, 9);
                                                                                                                     
                                                     if (ExcelUtils.getCellData(count,0).isEmpty())
                                                     {System.out.println("End of Test Data");}
                                                     else{
                                                     
                                                     System.out.println("\n----------------------------------------------------\n");
                                                                     System.out.println("Credentialling Statuses Add- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
                                                                     System.out.println("\n----------------------------------------------------\n");
                                                                     Log.info("----------------------------------------------------");
                                                                     Log.info("Credentialling Statuses Add- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
                                                                     Log.info("----------------------------------------------------");
                                                                     addcredentiallingStatusesMultiple(driver,credentiallingStatusesCode, credentiallingStatusesName);
                                                     }
                                     }
                                     }catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
                     }
                     
                                     
                                     public void addcredentiallingStatusesMultiple(WebDriver driver,String credentiallingStatusesCode, String credentiallingStatusesName) throws Exception
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

                         			homePageObject.clickReferencegotoCredentiallingStatuses();	
                                      
                         			CredentiallingStatuses CredentiallingStatusesObject = new CredentiallingStatuses(driver);
                                     CredentiallingStatusesObject.addCredentiallingStatuses(credentiallingStatusesCode, credentiallingStatusesName);
                                     
                                     }
                                     @AfterMethod
                             		public void afterMethod() throws Exception {
                             		if (driver!=null) driver.quit();
                             		System.out.println("Done with Credentialling Statuses-Add  \n\n");
                             		Log.info("Done with Credentialling Statuses-Add  \n\n");
                             		if (fis != null) 
                             				fis.close();
                             				
                             	}
                             }


package com.test;

import java.io.FileInputStream;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.FCMCActionCodes;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class FCMCActionCodesAddCommTestScript {
	 WebDriver driver;
	    FileInputStream fis;
	                    @Test
	                    public void FCMCActionCodesAddCommTestScriptTestScript() throws Exception{
	                                    DOMConfigurator.configure("log4j.xml");
	                                    System.out.println("\n*****************************************************\n");
	                                    Log.info("\n*****************************************************\n");
	                                    System.out.println("Executing FCMC Action Codes- Add Comm");
	                                    Log.info("Executing  FCMC Action Codes- Add Comm");
	                                    
	                                    
	                                    try{
	                                                    String Path=Constant.Path_TestData + Constant.File_Add_FCMCActionCodes;
	                                                    int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
	                                    for (int count=1; count<=rowCount; count++){
	                                                    String fcmcactionCodesCode= ExcelUtils.getCellData(count,1);
	                                                    String fcmcactionCodesName=ExcelUtils.getCellData(count,2); 
	                                                    String fcmcactionCodesNewCode= ExcelUtils.getCellData(count, 3);
	                                                    String fcmcactionCodesNewName= ExcelUtils.getCellData(count, 4);
	                                                    String fcmcactionCodesEditName= ExcelUtils.getCellData(count, 5);
	                                                    
	                                                                                    
	                                                                                                                    String fcmcactionCodesCommSubject= ExcelUtils.getCellData(count, 6);
	                                                                                                                    String  fcmcactionCodesCommNoteType = ExcelUtils.getCellData(count, 7);
	                                                                                                                    String  fcmcactionCodesCommNoteMedium = ExcelUtils.getCellData(count, 8);
	                                                                                                                    String  fcmcactionCodesCommDetails = ExcelUtils.getCellData(count, 9);
	                                                                                                                    
	                                                    if (ExcelUtils.getCellData(count,0).isEmpty())
	                                                    {System.out.println("End of Test Data");}
	                                                    else{
	                                                    
	                                                    System.out.println("\n----------------------------------------------------\n");
	                                                                    System.out.println("FCMC Action Codes Add Comm- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
	                                                                    System.out.println("\n----------------------------------------------------\n");
	                                                                    Log.info("----------------------------------------------------");
	                                                                    Log.info("FCMC Action Codes Add Comm- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
	                                                                    Log.info("----------------------------------------------------");
	                                                                    addCommFCMCActionCodesMultiple(driver,fcmcactionCodesCode, fcmcactionCodesCommSubject, fcmcactionCodesCommNoteType, fcmcactionCodesCommNoteMedium, fcmcactionCodesCommDetails);
	                                                    }
	                                    }
	                                    }catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
	                    }
	                    
	                                    
	                                    public void addCommFCMCActionCodesMultiple(WebDriver driver,String fcmcactionCodesCode, String fcmcactionCodesCommSubject, String fcmcactionCodesCommNoteType, String fcmcactionCodesCommNoteMedium, String fcmcactionCodesCommDetails) throws Exception
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
	                                    
	                                    homePageObject.clickReferencegotoFCMCActionCodes();    

	                                    FCMCActionCodes FCMCActionCodesObject = new FCMCActionCodes(driver);
	                                    FCMCActionCodesObject.addCommFCMCActionCodes(fcmcactionCodesCode, fcmcactionCodesCommSubject, fcmcactionCodesCommNoteType, fcmcactionCodesCommNoteMedium, fcmcactionCodesCommDetails);
	                                    
	                                    }

	                                    @AfterMethod
	                            		public void afterMethod() throws Exception {
	                            		if (driver!=null) driver.quit();
	                            		System.out.println("Done with FCMC Action codes- add comm  \n\n");
	                            		if (fis != null)
	                            				fis.close();
	                            	}

	}


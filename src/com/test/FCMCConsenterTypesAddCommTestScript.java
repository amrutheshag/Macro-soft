package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.FCMCConsenterTypes;
import com.pages.HomePage;
import com.pages.LoginPage;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class FCMCConsenterTypesAddCommTestScript {
	 WebDriver driver;
	    FileInputStream fis;
	                    @Test
	                    public void FCMCConsenterTypesAddCommTestScriptTestScript() throws Exception{
	                                    DOMConfigurator.configure("log4j.xml");
	                                    System.out.println("\n*****************************************************\n");
	                                    Log.info("\n*****************************************************\n");
	                                    System.out.println("Executing FCMC Consenter Types- Add Comm");
	                                    Log.info("Executing  FCMC Consenter Types- Add Comm");
	                                    
	                                    
	                                    try{
	                                                    String Path=Constant.Path_TestData + Constant.File_Add_FCMCConsenterTypes;
	                                                    int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
	                                    for (int count=1; count<=rowCount; count++){
	                                                    String fcmcconsenterTypesCode= ExcelUtils.getCellData(count,1);
	                                                    String fcmcconsenterTypesName=ExcelUtils.getCellData(count,2); 
	                                                    String fcmcconsenterTypesNewCode= ExcelUtils.getCellData(count, 3);
	                                                    String fcmcconsenterTypesNewName= ExcelUtils.getCellData(count, 4);
	                                                    String fcmcconsenterTypesEditName= ExcelUtils.getCellData(count, 5);
	                                                    
	                                                                                    
	                                                                                                                    String fcmcconsenterTypesCommSubject= ExcelUtils.getCellData(count, 6);
	                                                                                                                    String  fcmcconsenterTypesCommNoteType = ExcelUtils.getCellData(count, 7);
	                                                                                                                    String  fcmcconsenterTypesCommNoteMedium = ExcelUtils.getCellData(count, 8);
	                                                                                                                    String  fcmcconsenterTypesCommDetails = ExcelUtils.getCellData(count, 9);
	                                                                                                                    
	                                                    if (ExcelUtils.getCellData(count,0).isEmpty())
	                                                    {System.out.println("End of Test Data");}
	                                                    else{
	                                                    
	                                                    System.out.println("\n----------------------------------------------------\n");
	                                                                    System.out.println("FCMC Consenter Types Add Comm- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
	                                                                    System.out.println("\n----------------------------------------------------\n");
	                                                                    Log.info("----------------------------------------------------");
	                                                                    Log.info("FCMC Consenter Types Add Comm- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
	                                                                    Log.info("----------------------------------------------------");
	                                                                    addCommFCMCConsenterTypesMultiple(driver,fcmcconsenterTypesCode, fcmcconsenterTypesCommSubject, fcmcconsenterTypesCommNoteType, fcmcconsenterTypesCommNoteMedium, fcmcconsenterTypesCommDetails);
	                                                    }
	                                    }
	                                    }catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
	                    }
	                    
	                                    
	                                    public void addCommFCMCConsenterTypesMultiple(WebDriver driver,String fcmcconsenterTypesCode, String fcmcconsenterTypesCommSubject, String fcmcconsenterTypesCommNoteType, String fcmcconsenterTypesCommNoteMedium, String fcmcconsenterTypesCommDetails) throws Exception
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
	                                    
	                                    homePageObject.clickReferencegotoFCMCConsenterTypes();    

	                                 
	                                    FCMCConsenterTypes FCMCConsenterTypesObject = new FCMCConsenterTypes(driver);
	                                    FCMCConsenterTypesObject.addCommFCMCConsenterTypes(fcmcconsenterTypesCode, fcmcconsenterTypesCommSubject, fcmcconsenterTypesCommNoteType, fcmcconsenterTypesCommNoteMedium, fcmcconsenterTypesCommDetails);
	                                    
	                                    }
	                                	@AfterMethod
	                            		public void afterMethod() throws Exception {
	                            		if (driver!=null) driver.quit();
	                            		System.out.println("Done with FCMC Consenter Types-Add Comm  \n\n");
	                            		Log.info("log4j -Done with FCMC Consenter Types-Add Comm  \n\n");
	                            		if (fis != null) 
	                            				fis.close();
	                            	}
	                            }


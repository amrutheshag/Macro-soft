package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.pages.FCMCRaceCodes;
import com.pages.HomePage;
import com.pages.LoginPage;
import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class FCMCRaceCodesAddCommTestScript {
	 WebDriver driver;
	    FileInputStream fis;
	                    @Test
	                    public void FCMCRaceCodesAddCommTestScriptTestScript() throws Exception{
	                                    DOMConfigurator.configure("log4j.xml");
	                                    System.out.println("\n*****************************************************\n");
	                                    Log.info("\n*****************************************************\n");
	                                    System.out.println("Executing FCMC Race Codes- Add Comm");
	                                    Log.info("Executing  FCMC Race Codes- Add Comm");
	                                    
	                                    
	                                    try{
	                                                    String Path=Constant.Path_TestData + Constant.File_Add_FCMCRaceCodes;
	                                                    int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
	                                    for (int count=1; count<=rowCount; count++){
	                                                    String fcmcraceCodesCode= ExcelUtils.getCellData(count,1);
	                                                    String fcmcraceCodesName=ExcelUtils.getCellData(count,2); 
	                                                    String fcmcraceCodesNewCode= ExcelUtils.getCellData(count, 3);
	                                                    String fcmcraceCodesNewName= ExcelUtils.getCellData(count, 4);
	                                                    String fcmcraceCodesEditName= ExcelUtils.getCellData(count, 5);
	                                                    
	                                                                                    
	                                                                                                                    String fcmcraceCodesCommSubject= ExcelUtils.getCellData(count, 6);
	                                                                                                                    String  fcmcraceCodesCommNoteType = ExcelUtils.getCellData(count, 7);
	                                                                                                                    String  fcmcraceCodesCommNoteMedium = ExcelUtils.getCellData(count, 8);
	                                                                                                                    String  fcmcraceCodesCommDetails = ExcelUtils.getCellData(count, 9);
	                                                                                                                    
	                                                    if (ExcelUtils.getCellData(count,0).isEmpty())
	                                                    {System.out.println("End of Test Data");}
	                                                    else{
	                                                    
	                                                    System.out.println("\n----------------------------------------------------\n");
	                                                                    System.out.println("FCMC Race Codes Add Comm- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
	                                                                    System.out.println("\n----------------------------------------------------\n");
	                                                                    Log.info("----------------------------------------------------");
	                                                                    Log.info("FCMC Race Codes Add Comm- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
	                                                                    Log.info("----------------------------------------------------");
	                                                                    addCommFCMCRaceCodesMultiple(driver,fcmcraceCodesCode, fcmcraceCodesCommSubject, fcmcraceCodesCommNoteType, fcmcraceCodesCommNoteMedium, fcmcraceCodesCommDetails);
	                                                    }
	                                    }
	                                    }catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
	                    }
	                    
	                                    
	                                    public void addCommFCMCRaceCodesMultiple(WebDriver driver,String fcmcraceCodesCode, String fcmcraceCodesCommSubject, String fcmcraceCodesCommNoteType, String fcmcraceCodesCommNoteMedium, String fcmcraceCodesCommDetails) throws Exception
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
	                                    
	                                    homePageObject.clickReferencegotoFCMCRaceCodes();    

	                                 
	                                    FCMCRaceCodes FCMCRaceCodesObject = new FCMCRaceCodes(driver);
	                                    FCMCRaceCodesObject.addCommFCMCRaceCodes(fcmcraceCodesCode, fcmcraceCodesCommSubject, fcmcraceCodesCommNoteType, fcmcraceCodesCommNoteMedium, fcmcraceCodesCommDetails);
	                                    
	                                    }
	                                    @AfterMethod
	                            		public void afterMethod() throws Exception {
	                            		if (driver!=null) driver.quit();
	                            		if (fis != null) fis.close();
	                            		System.out.println("Done with FCMC Race Codes-Add Comm  \n\n");
	                            		Log.info("log4j -Done with FCMC Race Codes-Add Comm  \n\n");
	                            				
	                            	}
	                            }

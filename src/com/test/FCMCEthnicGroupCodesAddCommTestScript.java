package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.pages.FCMCEthnicGroupCodes;
import com.pages.HomePage;
import com.pages.LoginPage;
import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class FCMCEthnicGroupCodesAddCommTestScript {
	 WebDriver driver;
	    FileInputStream fis;
	                    @Test
	                    public void FCMCEthnicGroupCodesAddCommTestScriptTestScript() throws Exception{
	                                    DOMConfigurator.configure("log4j.xml");
	                                    System.out.println("\n*****************************************************\n");
	                                    Log.info("\n*****************************************************\n");
	                                    System.out.println("Executing FCMC Ethnic Group Codes- Add Comm");
	                                    Log.info("Executing  FCMC Ethnic Group Codes- Add Comm");
	                                    
	                                    
	                                    try{
	                                                    String Path=Constant.Path_TestData + Constant.File_Add_FCMCEthnicGroupCodes;
	                                                    int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
	                                    for (int count=1; count<=rowCount; count++){
	                                                    String fcmcethnicgroupCodesCode= ExcelUtils.getCellData(count,1);
	                                                    String fcmcethnicgroupCodesName=ExcelUtils.getCellData(count,2); 
	                                                    String fcmcethnicgroupCodesNewCode= ExcelUtils.getCellData(count, 3);
	                                                    String fcmcethnicgroupCodesNewName= ExcelUtils.getCellData(count, 4);
	                                                    String fcmcethnicgroupCodesEditName= ExcelUtils.getCellData(count, 5);
	                                                    
	                                                                                    
	                                                                                                                    String fcmcethnicgroupCodesCommSubject= ExcelUtils.getCellData(count, 6);
	                                                                                                                    String  fcmcethnicgroupCodesCommNoteType = ExcelUtils.getCellData(count, 7);
	                                                                                                                    String  fcmcethnicgroupCodesCommNoteMedium = ExcelUtils.getCellData(count, 8);
	                                                                                                                    String  fcmcethnicgroupCodesCommDetails = ExcelUtils.getCellData(count, 9);
	                                                                                                                    
	                                                    if (ExcelUtils.getCellData(count,0).isEmpty())
	                                                    {System.out.println("End of Test Data");}
	                                                    else{
	                                                    
	                                                    System.out.println("\n----------------------------------------------------\n");
	                                                                    System.out.println("FCMC Ethnic Group Codes Add Comm- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
	                                                                    System.out.println("\n----------------------------------------------------\n");
	                                                                    Log.info("----------------------------------------------------");
	                                                                    Log.info("FCMC Ethnic Group Codes Add Comm- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
	                                                                    Log.info("----------------------------------------------------");
	                                                                    addCommFCMCEthnicGroupCodesMultiple(driver,fcmcethnicgroupCodesCode, fcmcethnicgroupCodesCommSubject, fcmcethnicgroupCodesCommNoteType, fcmcethnicgroupCodesCommNoteMedium, fcmcethnicgroupCodesCommDetails);
	                                                    }
	                                    }
	                                    }catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
	                    }
	                    
	                                    
	                                    public void addCommFCMCEthnicGroupCodesMultiple(WebDriver driver,String fcmcethnicgroupCodesCode, String fcmcethnicgroupCodesCommSubject, String fcmcethnicgroupCodesCommNoteType, String fcmcethnicgroupCodesCommNoteMedium, String fcmcethnicgroupCodesCommDetails) throws Exception
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
	                                    
	                                    homePageObject.clickReferencegotoFCMCEthnicGroupCodes();    

	                                    FCMCEthnicGroupCodes FCMCEthnicGroupCodesObject = new FCMCEthnicGroupCodes(driver);
	                                    FCMCEthnicGroupCodesObject.addCommFCMCEthnicGroupCodes(fcmcethnicgroupCodesCode, fcmcethnicgroupCodesCommSubject, fcmcethnicgroupCodesCommNoteType, fcmcethnicgroupCodesCommNoteMedium, fcmcethnicgroupCodesCommDetails);
	                                    
	                                    }
	                                    @AfterMethod
	                            		public void afterMethod() throws Exception {
	                            		if (driver!=null) driver.quit();
	                            		if (fis != null) 	fis.close();
	                            		System.out.println("Done with FCMC Ethnic Group Codes-Add Comm  \n\n");
	                            		Log.info("log4j -Done with FCMC Ethnic Group Codes-Add Comm  \n\n");
	                            		
	                            	}
	                            }

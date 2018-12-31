package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.pages.FCMCLevelofCareCodes;
import com.pages.HomePage;
import com.pages.LoginPage;
import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class FCMCLevelofCareCodesCopyTestScript {
	 WebDriver driver;
     FileInputStream fis;
                     @Test
                     public void FCMCLevelofCareCodesCopyTestScript1() throws Exception{
                                     DOMConfigurator.configure("log4j.xml");
                                     System.out.println("\n*****************************************************\n");
                                     Log.info("\n*****************************************************\n");
                                     System.out.println("Executing FCMC Level of Care Codes- Copy");
                                     Log.info("Executing  FCMC Level of Care Codes- Copy ");
                                     
                                     
                                     try{
                                                     String Path=Constant.Path_TestData + Constant.File_Add_FCMCLevelofCareCodes;
                                                     int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
                                     for (int count=1; count<=rowCount; count++){
                                                     String fcmclevelofcareCodesCode= ExcelUtils.getCellData(count,1);
                                                     String fcmclevelofcareCodesDescription=ExcelUtils.getCellData(count,2); 
                                                     String fcmclevelofcareCodesNewCode= ExcelUtils.getCellData(count, 3);
                                                     String fcmclevelofcareCodesNewDescription= ExcelUtils.getCellData(count, 4);
                                                     String fcmclevelofcareCodesEditDescription= ExcelUtils.getCellData(count, 5);
                                                     
                                                                                     
                                                                                                                     String fcmclevelofcareCodesCommSubject= ExcelUtils.getCellData(count, 6);
                                                                                                                     String fcmclevelofcareCodesCommNoteType = ExcelUtils.getCellData(count, 7);
                                                                                                                     String fcmclevelofcareCodesCommNoteMedium = ExcelUtils.getCellData(count, 8);
                                                                                                                     String fcmclevelofcareCodesCommDetails = ExcelUtils.getCellData(count, 9);
                                                                                                                     
                                                     if (ExcelUtils.getCellData(count,0).isEmpty())
                                                     {System.out.println("End of Test Data");}
                                                     else{
                                                     
                                                     System.out.println("\n----------------------------------------------------\n");
                                                                     System.out.println("FCMC Level of Care Codes Copy- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
                                                                     System.out.println("\n----------------------------------------------------\n");
                                                                     Log.info("----------------------------------------------------");
                                                                     Log.info("FCMC Level of Care Codes Copy- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
                                                                     Log.info("----------------------------------------------------");
                                     copyFCMCLevelofCareCodesMultiple(driver,fcmclevelofcareCodesCode, fcmclevelofcareCodesNewCode, fcmclevelofcareCodesNewDescription);
                                                     }
                                     }
                                     }catch (Exception e) {e.printStackTrace();System.out.println("Test Data File not found");e.printStackTrace();}
                     }
                     
                                     
                                     public void copyFCMCLevelofCareCodesMultiple(WebDriver driver,String fcmclevelofcareCodesCode, String fcmclevelofcareCodesNewCode, String fcmclevelofcareCodesNewDescription) throws Exception
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

                                     homePageObject.clickReferencegotoFCMCLevelofCareCodes();     
                                     
                                     
                                     
                                    FCMCLevelofCareCodes fcmclevelofcareCodesPageObject = new FCMCLevelofCareCodes(driver);
                                     fcmclevelofcareCodesPageObject.copyFCMCLevelofCareCodes( fcmclevelofcareCodesCode, fcmclevelofcareCodesNewCode, fcmclevelofcareCodesNewDescription);
                                     
                                     }

                                     @AfterMethod
	                            		public void afterMethod() throws Exception {
	                            		if (driver!=null) driver.quit();
	                            		System.out.println("Done with FCMC Level of Care Codes-Copy  \n\n");
	                            		Log.info("log4j -Done with FCMC Level of Care Codes-Copy  \n\n");
	                            		if (fis != null) 
	                            				fis.close();
	                            				
	                            	}
	                            }




package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.DiagnosisCodes;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class DiagnosisCodesCopyTestScript {
	 WebDriver driver;
	    FileInputStream fis;
	                    @Test
	                    public void DiagnosisCodesCopyTestScript1() throws Exception{
	                                    DOMConfigurator.configure("log4j.xml");
	                                    System.out.println("\n*****************************************************\n");
	                                    Log.info("\n*****************************************************\n");
	                                    System.out.println("Executing Diagnosis Codes- Copy");
	                                    Log.info("Executing  Diagnosis Codes- Copy ");
	                                    
	                                    
	                                    try{
	                                                    String Path=Constant.Path_TestData + Constant.File_Add_DiagnosisCodes;
	                                                    int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
	                                    for (int count=1; count<=rowCount; count++){
	                                    	 String diagnosisCodesCode= ExcelUtils.getCellData(count,1);
                                             String DiagnosisCodesDescriptionInput=ExcelUtils.getCellData(count,2); 
                                             String diagnosisCodesNewCode= ExcelUtils.getCellData(count, 4);
                                             String diagnosisCodesNewName= ExcelUtils.getCellData(count, 5);
                                             String diagnosisCodesEditName= ExcelUtils.getCellData(count, 6);
                                             String DiagnosticCategory=ExcelUtils.getCellData(count, 3);
                                             
                                                                             
                                                                                                             String diagnosisCodesCommSubject= ExcelUtils.getCellData(count, 7);
                                                                                                             String  diagnosisCodesCommNoteType = ExcelUtils.getCellData(count, 8);
                                                                                                             String  diagnosisCodesCommNoteMedium = ExcelUtils.getCellData(count, 9);
                                                                                                             String  diagnosisCodesCommDetails = ExcelUtils.getCellData(count, 10);
	                                                    if (ExcelUtils.getCellData(count,0).isEmpty())
	                                                    {System.out.println("End of Test Data");}
	                                                    else{
	                                                    
	                                                    System.out.println("\n----------------------------------------------------\n");
	                                                                    System.out.println("Diagnosis Codes Copy- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
	                                                                    System.out.println("\n----------------------------------------------------\n");
	                                                                    Log.info("----------------------------------------------------");
	                                                                    Log.info("Diagnosis Codes Copy- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
	                                                                    Log.info("----------------------------------------------------");
	                                    copyDiagnosisCodesMultiple(driver,diagnosisCodesCode, DiagnosisCodesDescriptionInput, diagnosisCodesNewCode, diagnosisCodesNewName);
	                                                    }
	                                    }
	                                    }catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
	                    }
	                    
	                                    
	                                    public void copyDiagnosisCodesMultiple(WebDriver driver,String DiagnosisCodesCode, String diagnosisCodesDescription, String diagnosisCodesNewCode, String diagnosisCodesNewDescription) throws Exception
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

	                        			homePageObject.clickReferencegotoDiagnosisCodes();	
	                                    
	                             
	                                    DiagnosisCodes diagnosisCodesPageObject = new DiagnosisCodes(driver);
	                                    diagnosisCodesPageObject.copyDiagnosisCodes( DiagnosisCodesCode, diagnosisCodesDescription, diagnosisCodesNewCode, diagnosisCodesNewDescription);
	                                    
	                                    }

	                                    @AfterMethod
	                             		public void afterMethod() throws Exception {
	                             		if (driver!=null) driver.quit();
	                             		System.out.println("Done with Diagnosis Codes-Copy  \n\n");
	                             		Log.info("Done with Diagnosis Codes-Copy  \n\n");
	                             		if (fis != null) 
	                             				fis.close();
	                             	}
	                             }






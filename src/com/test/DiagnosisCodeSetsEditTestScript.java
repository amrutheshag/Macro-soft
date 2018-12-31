package com.test;

import java.io.FileInputStream;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.DiagnosisCodeSets;
import com.pages.HomePage;
import com.pages.LoginPage;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class DiagnosisCodeSetsEditTestScript {
	WebDriver driver;
    FileInputStream fis;
                    @Test
                    public void DiagnosisCodeSetsEditTestScript1() throws Exception{
                                    DOMConfigurator.configure("log4j.xml");
                                    System.out.println("\n*****************************************************\n");
                                    Log.info("\n*****************************************************\n");
                                    System.out.println("Executing Diagnosis Code Sets- edit");
                                    Log.info("Executing  Diagnosis Code Sets-edit");
                                    
                                    
                                    try{
                                                    String Path=Constant.Path_TestData + Constant.File_Add_DiagnosisCodeSets;
                                                    int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
                                    for (int count=1; count<=rowCount; count++){
                                                    String diagnosisCodeSetsCode= ExcelUtils.getCellData(count,1);
                                                    String diagnosisCodeSetsName=ExcelUtils.getCellData(count,2); 
                                                    String newDiagnosisCodeSetsCode= ExcelUtils.getCellData(count, 3);
                                                    String newDiagnosisCodeSetsName= ExcelUtils.getCellData(count, 4);
                                                    String recordMark= ExcelUtils.getCellData(count, 5);
                                                    
                                                                                    
                                                                                                                    String diagnosiscodeSetsCommSubject= ExcelUtils.getCellData(count, 6);
                                                                                                                    String  diagnosiscodeSetsCommNoteType = ExcelUtils.getCellData(count, 7);
                                                                                                                    String  diagnosiscodeSetsCommNoteMedium = ExcelUtils.getCellData(count, 8);
                                                                                                                    String  diagnosiscodeSetsCommDetails = ExcelUtils.getCellData(count, 9);
                                                                                                                    
                                                    if (ExcelUtils.getCellData(count,0).isEmpty())
                                                    {System.out.println("End of Test Data");}
                                                    else{
                                                    
                                                    System.out.println("\n----------------------------------------------------\n");
                                                                    System.out.println("Diagnosis Code Sets edit Running Iteration No:  " + ExcelUtils.getCellData(count,0));
                                                                    System.out.println("\n----------------------------------------------------\n");
                                                                    Log.info("----------------------------------------------------");
                                                                    Log.info("Diagnosis Code Sets edit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
                                                                    Log.info("----------------------------------------------------");
                                                                    editDiagnosiscodeSetsMultiple(driver,  diagnosisCodeSetsCode,  diagnosisCodeSetsName, recordMark);
                                                    }
                                    }
                                    }catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
                    }
                    
                                    
                                    public void editDiagnosiscodeSetsMultiple(WebDriver driver, String DiagnosisCodeSetsCode, String DiagnosisCodeSetsName, String recordMark) throws Exception
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

                        			homePageObject.clickReferencegotoDiagnosisCodeSets();	
                        			   
                                    
                                    
                       /*          
                                    MemberSupportingCodes MemberSupportingCodesObject = new MemberSupportingCodes(driver);
                            		MemberSupportingCodesObject.clickOnDiagnosisCodeSets(); 
                                 
                          */          
                                 
                                    
                                    //edit
                                    DiagnosisCodeSets DiagnosisCodeSetsObject = new DiagnosisCodeSets(driver);
                                    DiagnosisCodeSetsObject.editDiagnosisCodeSets( DiagnosisCodeSetsCode,  DiagnosisCodeSetsName,  recordMark);
                                    
                                    }

                                    @AfterMethod
                            		public void afterMethod() throws Exception {
                            		if (driver!=null) driver.quit();
                            		System.out.println("Done with Diagnosis Code Sets-Edit  \n\n");
                            		if (fis != null) 
                            				fis.close();
                            	}

}



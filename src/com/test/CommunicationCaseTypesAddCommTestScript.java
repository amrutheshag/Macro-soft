package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.CommunicationCaseTypes;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class CommunicationCaseTypesAddCommTestScript {
	 WebDriver driver;
	    FileInputStream fis;
	                    @Test
	                    public void CommunicationCaseTypesAddCommTestScriptTestScript() throws Exception{
	                                    DOMConfigurator.configure("log4j.xml");
	                                    System.out.println("\n*****************************************************\n");
	                                    Log.info("\n*****************************************************\n");
	                                    System.out.println("Executing Communication Case Types- Add Comm");
	                                    Log.info("Executing  Communication Case Types- Add Comm");
	                                    
	                                    
	                                    try{
	                                                    String Path=Constant.Path_TestData + Constant.File_Add_CommunicationCaseTypes;
	                                                    int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
	                                    for (int count=1; count<=rowCount; count++){
	                                                    String communicationcaseTypesCode= ExcelUtils.getCellData(count,1);
	                                                    String communicationcaseTypesName=ExcelUtils.getCellData(count,2); 
	                                                    String communicationcaseTypesNewCode= ExcelUtils.getCellData(count, 3);
	                                                    String communicationcaseTypesNewName= ExcelUtils.getCellData(count, 4);
	                                                    String communicationcaseTypesEditName= ExcelUtils.getCellData(count, 5);
	                                                    
	                                                                                    
	                                                                                                                    String communicationcaseTypesCommSubject= ExcelUtils.getCellData(count, 6);
	                                                                                                                    String  communicationcaseTypesCommNoteType = ExcelUtils.getCellData(count, 7);
	                                                                                                                    String  communicationcaseTypesCommNoteMedium = ExcelUtils.getCellData(count, 8);
	                                                                                                                    String  communicationcaseTypesCommDetails = ExcelUtils.getCellData(count, 9);
	                                                                                                                    
	                                                    if (ExcelUtils.getCellData(count,0).isEmpty())
	                                                    {System.out.println("End of Test Data");}
	                                                    else{
	                                                    
	                                                    System.out.println("\n----------------------------------------------------\n");
	                                                                    System.out.println("Communication Case Types Add Comm- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
	                                                                    System.out.println("\n----------------------------------------------------\n");
	                                                                    Log.info("----------------------------------------------------");
	                                                                    Log.info("Communication Case Types Add Comm- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
	                                                                    Log.info("----------------------------------------------------");
	                                                                    addCommCommunicationCaseTypesMultiple(driver,communicationcaseTypesCode, communicationcaseTypesCommSubject, communicationcaseTypesCommNoteType, communicationcaseTypesCommNoteMedium, communicationcaseTypesCommDetails);
	                                                    }
	                                    }
	                                    }catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
	                    }
	                    
	                                    
	                                    public void addCommCommunicationCaseTypesMultiple(WebDriver driver,String communicationcaseTypesCode, String communicationcaseTypesCommSubject, String communicationcaseTypesCommNoteType, String communicationcaseTypesCommNoteMedium, String communicationcaseTypesCommDetails) throws Exception
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
	                                    
	                                    homePageObject.clickReferencegotoCommunicationCaseTypes();    

	                                    CommunicationCaseTypes CommunicationCaseTypesObject = new CommunicationCaseTypes(driver);
	                                    CommunicationCaseTypesObject.addCommCommunicationCaseTypes(communicationcaseTypesCode, communicationcaseTypesCommSubject, communicationcaseTypesCommNoteType, communicationcaseTypesCommNoteMedium, communicationcaseTypesCommDetails);
	                                    
	                                    }
	                                    @AfterMethod
	                            		public void afterMethod() throws Exception {
	                            		if (driver!=null) driver.quit();
	                            		System.out.println("Done with Communication Case Types-Add Comm  \n\n");
	                            		Log.info("log4j -Done with Communication Case Types-Add Comm  \n\n");
	                            		if (fis != null)
	                            				fis.close();
	                            	}
	                            }

	


package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.ContractTypes;
import com.pages.LoginPage;
import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class ContractTypesAddCommTestScript {
	 WebDriver driver;
	    FileInputStream fis;
	                    @Test
	                    public void ContractTypesAddCommTestScriptTestScript() throws Exception{
	                                    DOMConfigurator.configure("log4j.xml");
	                                    System.out.println("\n*****************************************************\n");
	                                    Log.info("\n*****************************************************\n");
	                                    System.out.println("Executing Contract Types- Add Comm");
	                                    Log.info("Executing  Contract Types- Add Comm");
	                                    
	                                    
	                                    try{
	                                                    String Path=Constant.Path_TestData + Constant.File_Add_ContractTypes;
	                                                    int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
	                                    for (int count=1; count<=rowCount; count++){
	                                                    String contractTypesCode= ExcelUtils.getCellData(count,1);
	                                                    String contractTypesName=ExcelUtils.getCellData(count,2); 
	                                                    String contractTypesNewCode= ExcelUtils.getCellData(count, 3);
	                                                    String contractTypesNewName= ExcelUtils.getCellData(count, 4);
	                                                    String contractTypesEditName= ExcelUtils.getCellData(count, 5);
	                                                    
	                                                                                    
	                                                                                                                    String contractTypesCommSubject= ExcelUtils.getCellData(count, 6);
	                                                                                                                    String  contractTypesCommNoteType = ExcelUtils.getCellData(count, 7);
	                                                                                                                    String  contractTypesCommNoteMedium = ExcelUtils.getCellData(count, 8);
	                                                                                                                    String  contractTypesCommDetails = ExcelUtils.getCellData(count, 9);
	                                                                                                                    
	                                                    if (ExcelUtils.getCellData(count,0).isEmpty())
	                                                    {System.out.println("End of Test Data");}
	                                                    else{
	                                                    
	                                                    System.out.println("\n----------------------------------------------------\n");
	                                                                    System.out.println("Contract Types Add Comm- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
	                                                                    System.out.println("\n----------------------------------------------------\n");
	                                                                    Log.info("----------------------------------------------------");
	                                                                    Log.info("Contract Types Add Comm- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
	                                                                    Log.info("----------------------------------------------------");
	                                                                    addCommContractTypesMultiple(driver,contractTypesCode, contractTypesCommSubject, contractTypesCommNoteType, contractTypesCommNoteMedium, contractTypesCommDetails);
	                                                    }
	                                    }
	                                    }catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
	                    }
	                    
	                                    
	                                    public void addCommContractTypesMultiple(WebDriver driver,String contractTypesCode, String contractTypesCommSubject, String contractTypesCommNoteType, String contractTypesCommNoteMedium, String contractTypesCommDetails) throws Exception
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
	                                    
	                                    homePageObject.clickReferencegotoContractTypes();    

	                                    ContractTypes ContractTypesObject = new ContractTypes(driver);
	                                    ContractTypesObject.addCommContractTypes(contractTypesCode, contractTypesCommSubject, contractTypesCommNoteType, contractTypesCommNoteMedium, contractTypesCommDetails);
	                                    
	                                    }

	                                    @AfterMethod
	                            		public void afterMethod() throws Exception {
	                            		if (driver!=null) driver.quit();
	                            		System.out.println("Done with Contract Types-Add Comm  \n\n");
	                            		Log.info("Done with Communication Contract Types-Add Comm  \n\n");
	                            		if (fis != null) 
	                            				fis.close();
	                            				
	                            	}
	                            }


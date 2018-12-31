package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.URCaseProblemTypes;
import com.pages.HomePage;
import com.pages.LoginPage;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class URCaseProblemTypesCopyTestScrip {
	 WebDriver driver;
	    FileInputStream fis;
	                    @Test
	                    public void JobStatusCategoriesCopyTestScript() throws Exception{
	                                    DOMConfigurator.configure("log4j.xml");
	                                    System.out.println("\n*****************************************************\n");
	                                    Log.info("\n*****************************************************\n");
	                                    System.out.println("Executing UR Case/Problem Types- Copy");
	                                    Log.info("Executing  UR Case/Problem Types- Copy ");
	                                    
	                                    
	                                    try{
	                                                    String Path=Constant.Path_TestData + Constant.File_Add_URCaseProblemTypes;
	                                                    int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
	                                    for (int count=1; count<=rowCount; count++){
	                                                    String urcaseproblemTypesCode= ExcelUtils.getCellData(count,1);
	                                                    String urcaseproblemTypesDescription=ExcelUtils.getCellData(count,2); 
	                                                    String urcaseproblemTypesNewCode= ExcelUtils.getCellData(count, 3);
	                                                    String urcaseproblemTypesNewDescription= ExcelUtils.getCellData(count, 4);
	                                                    String urcaseproblemTypesEditDescription= ExcelUtils.getCellData(count, 5);
	                                                    
	                                                                                    
	                                                                                                                    String urcaseproblemTypesCommSubject= ExcelUtils.getCellData(count, 6);
	                                                                                                                    String urcaseproblemTypesCommNoteType = ExcelUtils.getCellData(count, 7);
	                                                                                                                    String urcaseproblemTypesCommNoteMedium = ExcelUtils.getCellData(count, 8);
	                                                                                                                    String urcaseproblemTypesCommDetails = ExcelUtils.getCellData(count, 9);
	                                                                                                                    
	                                                    if (ExcelUtils.getCellData(count,0).isEmpty())
	                                                    {System.out.println("End of Test Data");}
	                                                    else{
	                                                    
	                                                    System.out.println("\n----------------------------------------------------\n");
	                                                                    System.out.println("UR Case/Problem Types Copy- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
	                                                                    System.out.println("\n----------------------------------------------------\n");
	                                                                    Log.info("----------------------------------------------------");
	                                                                    Log.info("UR Case/Problem Types Copy- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
	                                                                    Log.info("----------------------------------------------------");
	                                    copyURCaseProblemTypesMultiple(driver,urcaseproblemTypesCode, urcaseproblemTypesDescription, urcaseproblemTypesNewCode, urcaseproblemTypesNewDescription);
	                                                    }
	                                    }
	                                    }catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
	                    }
	                    
	                                    
	                                    public void copyURCaseProblemTypesMultiple(WebDriver driver,String URCaseProblemTypesCode, String urcaseproblemTypesDescription, String urcaseproblemTypesNewCode, String urcaseproblemTypesNewDescription) throws Exception
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

	                        			homePageObject.clickReferencegotoURCaseProblemTypes();	
	                                    
	                                    URCaseProblemTypes urcaseproblemTypesPageObject = new URCaseProblemTypes(driver);
	                                    urcaseproblemTypesPageObject.copyURCaseProblemTypes(URCaseProblemTypesCode, urcaseproblemTypesDescription, urcaseproblemTypesNewCode, urcaseproblemTypesNewDescription);
	                                    
	                                    }

	                                    @AfterMethod
	                    	      		public void afterMethod() throws Exception {
	                    	      		if (driver!=null) driver.quit();
	                    	      		System.out.println("Done with UR Case/Problem Types-Copy \n\n");
	                    	      		Log.info("log4j-Done with UR Case/Problem Types-Copy \n\n");
	                    	      		if (fis != null)	fis.close();
	                    	      	}
	                    	      }


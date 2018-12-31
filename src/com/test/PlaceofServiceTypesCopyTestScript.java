package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.PlaceofServiceTypes;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class PlaceofServiceTypesCopyTestScript {
	 WebDriver driver;
	    FileInputStream fis;
	                    @Test
	                    public void PlaceofServiceTypesCopyTestScript1() throws Exception{
	                                    DOMConfigurator.configure("log4j.xml");
	                                    System.out.println("\n*****************************************************\n");
	                                    Log.info("\n*****************************************************\n");
	                                    System.out.println("Executing Place of Service Types- Copy");
	                                    Log.info("Executing  Place of Service Types- Copy ");
	                                    
	                                    
	                                    try{
	                                                    String Path=Constant.Path_TestData + Constant.File_Add_PlaceofServiceTypes;
	                                                    int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
	                                    for (int count=1; count<=rowCount; count++){
	                                                    String placeofserviceTypesCode= ExcelUtils.getCellData(count,1);
	                                                    String placeofserviceTypesDescription=ExcelUtils.getCellData(count,2); 
	                                                    String placeofserviceTypesNewCode= ExcelUtils.getCellData(count, 3);
	                                                    String placeofserviceTypesNewDescription= ExcelUtils.getCellData(count, 4);
	                                                    String placeofserviceTypesEditDescription= ExcelUtils.getCellData(count, 5);
	                                                    
	                                                                                    
	                                                                                                                    String placeofserviceTypesCommSubject= ExcelUtils.getCellData(count, 6);
	                                                                                                                    String placeofserviceTypesCommNoteType = ExcelUtils.getCellData(count, 7);
	                                                                                                                    String placeofserviceTypesCommNoteMedium = ExcelUtils.getCellData(count, 8);
	                                                                                                                    String placeofserviceTypesCommDetails = ExcelUtils.getCellData(count, 9);
	                                                                                                                    
	                                                    if (ExcelUtils.getCellData(count,0).isEmpty())
	                                                    {System.out.println("End of Test Data");}
	                                                    else{
	                                                    
	                                                    System.out.println("\n----------------------------------------------------\n");
	                                                                    System.out.println("Place of Service Types Copy- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
	                                                                    System.out.println("\n----------------------------------------------------\n");
	                                                                    Log.info("----------------------------------------------------");
	                                                                    Log.info("Place of Service Types Copy- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
	                                                                    Log.info("----------------------------------------------------");
	                                    copyPlaceofServiceTypesMultiple(driver,placeofserviceTypesCode, placeofserviceTypesDescription, placeofserviceTypesNewCode, placeofserviceTypesNewDescription);
	                                                    }
	                                    }
	                                    }catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
	                    }
	                    
	                                    
	                                    public void copyPlaceofServiceTypesMultiple(WebDriver driver,String PlaceofServiceTypesCode, String placeofserviceTypesDescription, String placeofserviceTypesNewCode, String placeofserviceTypesNewDescription) throws Exception
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

	                        			homePageObject.clickReferencegotoPlaceofServiceTypes();	
	                                    
	                                    
	                                    
	                                    PlaceofServiceTypes placeofserviceTypesPageObject = new PlaceofServiceTypes(driver);
	                                    placeofserviceTypesPageObject.copyPlaceofServiceTypes( PlaceofServiceTypesCode, placeofserviceTypesDescription, placeofserviceTypesNewCode, placeofserviceTypesNewDescription);
	                                    
	                                    }

	                                    @AfterMethod
	                             		public void afterMethod() throws Exception {
	                             		if (driver!=null) driver.quit();
	                             		System.out.println("Done with Place of Service Types-Copy \n\n");
	                             		Log.info("log4j -Done with Place of Service Types-Copy \n\n");
	                             		if (fis != null)	fis.close();
	                             	}
	                             }







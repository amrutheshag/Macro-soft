package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.RVUGeographicMultipliers;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class RVUGeographicMultipliersAddTestScript {
	 WebDriver driver;
     FileInputStream fis;
                     @Test
                     public void RVUGeographicMultipliersAddTestScript1() throws Exception{
                                     DOMConfigurator.configure("log4j.xml");
                                     System.out.println("\n*****************************************************\n");
                                     Log.info("\n*****************************************************\n");
                                     System.out.println("Executing RVU Geographic Multipliers- Add");
                                     Log.info("Executing  RVU Geographic Multipliers- Add ");
                                     
                                     
                                     try{
                                                     String Path=Constant.Path_TestData + Constant.File_Add_RVUGeographicMultipliers;
                                                     int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
                                     for (int count=1; count<=rowCount; count++){
                                                     String rvugeographicMultipliersCode= ExcelUtils.getCellData(count,1);
                                                     String rvugeographicMultipliersName=ExcelUtils.getCellData(count,2); 
                                                     String rvugeographicMultipliersNewCode= ExcelUtils.getCellData(count, 3);
                                                     String rvugeographicMultipliersNewName= ExcelUtils.getCellData(count, 4);
                                                     String rvugeographicMultipliersEditName= ExcelUtils.getCellData(count, 5);
                                                     
                                                                                     
                                                                                                                     String rvugeographicMultipliersCommSubject= ExcelUtils.getCellData(count, 6);
                                                                                                                     String  rvugeographicMultipliersCommNoteType = ExcelUtils.getCellData(count, 7);
                                                                                                                     String  rvugeographicMultipliersCommNoteMedium = ExcelUtils.getCellData(count, 8);
                                                                                                                     String  rvugeographicMultipliersCommDetails = ExcelUtils.getCellData(count, 9);
                                                                                                                     
                                                     if (ExcelUtils.getCellData(count,0).isEmpty())
                                                     {System.out.println("End of Test Data");}
                                                     else{
                                                     
                                                     System.out.println("\n----------------------------------------------------\n");
                                                                     System.out.println("RVU Geographic Multipliers Add- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
                                                                     System.out.println("\n----------------------------------------------------\n");
                                                                     Log.info("----------------------------------------------------");
                                                                     Log.info("RVU Geographic Multipliers Add- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
                                                                     Log.info("----------------------------------------------------");
                                                                     addrvugeographicMultipliersMultiple(driver,rvugeographicMultipliersCode, rvugeographicMultipliersName);
                                                     }
                                     }
                                     }catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
                     }
                     
                                     
                                     public void addrvugeographicMultipliersMultiple(WebDriver driver,String rvugeographicMultipliersCode, String rvugeographicMultipliersName) throws Exception
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

                         			homePageObject.clickReferencegotoRVUGeographicMultipliers();	
                         			   
                                     
                                     
                                     RVUGeographicMultipliers RVUGeographicMultipliersObject = new RVUGeographicMultipliers(driver);
                                     RVUGeographicMultipliersObject.addRVUGeographicMultipliers(rvugeographicMultipliersCode, rvugeographicMultipliersName);
                                     
                                     }
                                     @AfterMethod
                             		public void afterMethod() throws Exception {
                             		if (driver!=null) driver.quit();
                             		System.out.println("Done with RVU Geographic Multipliers-Add \n\n");
                             		 Log.info("log4j - Done with RVU Geographic Multipliers-Add \n\n");
                             		if (fis != null)	fis.close();
                             	}
                             }


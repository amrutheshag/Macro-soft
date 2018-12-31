package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.ServiceCategories;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class ServiceCategoriesAddTestScript {
	 WebDriver driver;
     FileInputStream fis;
                     @Test
                     public void ServiceCategoriesAddTestScript1() throws Exception{
                                     DOMConfigurator.configure("log4j.xml");
                                     System.out.println("\n*****************************************************\n");
                                     Log.info("\n*****************************************************\n");
                                     System.out.println("Executing Service Categories- Add");
                                     Log.info("Executing  Service Categories- Add ");
                                     
                                     
                                     try{
                                                     String Path=Constant.Path_TestData + Constant.File_Add_ServiceCategories;
                                                     int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
                                     for (int count=1; count<=rowCount; count++){
                                                     String serviceCategoriesCode= ExcelUtils.getCellData(count,1);
                                                     String serviceCategoriesName=ExcelUtils.getCellData(count,2); 
                                                     String serviceCategoriesNewCode= ExcelUtils.getCellData(count, 3);
                                                     String serviceCategoriesNewName= ExcelUtils.getCellData(count, 4);
                                                     String serviceCategoriesEditName= ExcelUtils.getCellData(count, 5);
                                                     
                                                                                     
                                                                                                                     String serviceCategoriesCommSubject= ExcelUtils.getCellData(count, 6);
                                                                                                                     String  serviceCategoriesCommNoteType = ExcelUtils.getCellData(count, 7);
                                                                                                                     String  serviceCategoriesCommNoteMedium = ExcelUtils.getCellData(count, 8);
                                                                                                                     String  serviceCategoriesCommDetails = ExcelUtils.getCellData(count, 9);
                                                                                                                     
                                                     if (ExcelUtils.getCellData(count,0).isEmpty())
                                                     {System.out.println("End of Test Data");}
                                                     else{
                                                     
                                                     System.out.println("\n----------------------------------------------------\n");
                                                                     System.out.println("Service Categories Add- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
                                                                     System.out.println("\n----------------------------------------------------\n");
                                                                     Log.info("----------------------------------------------------");
                                                                     Log.info("Service Categories Add- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
                                                                     Log.info("----------------------------------------------------");
                                                                     addserviceCategoriesMultiple(driver,serviceCategoriesCode, serviceCategoriesName);
                                                     }
                                     }
                                     }catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
                     }
                     
                                     
                                     public void addserviceCategoriesMultiple(WebDriver driver,String serviceCategoriesCode, String serviceCategoriesName) throws Exception
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

                         			homePageObject.clickReferencegotoServiceCategories();	
                         			 ServiceCategories ServiceCategoriesObject = new ServiceCategories(driver);
                                     ServiceCategoriesObject.addServiceCategories(serviceCategoriesCode, serviceCategoriesName);
                                     
                                     }

                                     @AfterMethod
                             		public void afterMethod() throws Exception {
                             		if (driver!=null) driver.quit();
                             		System.out.println("Done with Service Categories-Add \n\n");
                             		Log.info("log4j-Done with Service Categories-Add \n\n");
                             		if (fis != null)	fis.close();
                             	}
                             }











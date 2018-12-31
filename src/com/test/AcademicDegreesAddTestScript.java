package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.AcademicDegrees;
import com.pages.HomePage;
import com.pages.LoginPage;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class AcademicDegreesAddTestScript {
	 WebDriver driver;
     FileInputStream fis;
                     @Test
                     public void AcademicDegreesAddTestScript1() throws Exception{
                                     DOMConfigurator.configure("log4j.xml");
                                     System.out.println("\n*****************************************************\n");
                                     Log.info("\n*****************************************************\n");
                                     System.out.println("Executing Academic Degrees- Add");
                                     Log.info("Executing  Academic Degrees- Add ");
                                     
                                     
                                     try{
                                                     String Path=Constant.Path_TestData + Constant.File_Add_AcademicDegrees;
                                                     int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
                                     for (int count=1; count<=rowCount; count++){
                                                     String academicDegreesCode= ExcelUtils.getCellData(count,1);
                                                     String academicDegreesName=ExcelUtils.getCellData(count,2); 
                                                     //String academicDegreesNewCode= ExcelUtils.getCellData(count, 3);
                                                     //String academicDegreesNewName= ExcelUtils.getCellData(count, 4);
                                                     //String academicDegreesEditName= ExcelUtils.getCellData(count, 5);
                                                     
                                                                                     
                                                                                                                   //  String academicDegreesCommSubject= ExcelUtils.getCellData(count, 6);
                                                                                                                     //String  academicDegreesCommNoteType = ExcelUtils.getCellData(count, 7);
                                                                                                                     //String  academicDegreesCommNoteMedium = ExcelUtils.getCellData(count, 8);
                                                                                                                     //String  academicDegreesCommDetails = ExcelUtils.getCellData(count, 9);
                                                                                                                     
                                                     if (ExcelUtils.getCellData(count,0).isEmpty())
                                                     {System.out.println("End of Test Data");}
                                                     else{
                                                     
                                                     System.out.println("\n----------------------------------------------------\n");
                                                                     System.out.println("Academic Degrees Add- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
                                                                     System.out.println("\n----------------------------------------------------\n");
                                                                     Log.info("----------------------------------------------------");
                                                                     Log.info("Academic Degrees Add- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
                                                                     Log.info("----------------------------------------------------");
                                                                     addacademicDegreesMultiple(driver, academicDegreesCode, academicDegreesName);
                                                     }
                                     }
                                     }catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
                     }
                     
                                     
                                     public void addacademicDegreesMultiple(WebDriver driver, String academicDegreesCode, String academicDegreesName) throws Exception
                                     {
                                     try{
                                     
                                     // Launch Chrome Browser
                                     driver= BrowserUtils.openChromeBrowser();
                                                                                     
                                     //open risk manager
                                     driver.get(Constant.URL);
                                     System.out.println("Browser Launched");
                                                                                     
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

                         			homePageObject.clickReferencegotoAcademicDegrees();	
                         			   
                                     
                                   
                                     AcademicDegrees AcademicDegreesObject = new AcademicDegrees(driver);
                                     AcademicDegreesObject.addAcademicDegrees(academicDegreesCode, academicDegreesName);
                                     
                                     }catch(Exception e){e.printStackTrace();}
                                     }

                                     @AfterMethod
                             		public void afterMethod() throws Exception {
                             	
                             			if (driver!=null) driver.quit();
                             		
                             			System.out.println("Done with Academic Degrees-Add  \n\n");
                             			Log.info("log4j - Done with Academic Degrees-Add  \n\n");
                             			if (fis != null)               				
                             					fis.close();
                             			}		
                             }







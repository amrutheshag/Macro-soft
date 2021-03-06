package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.Modifiers;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class ModifiersAddTestScript {
	 WebDriver driver;
     FileInputStream fis;
                     @Test
                     public void ModifiersAddTestScript1() throws Exception{
                                     DOMConfigurator.configure("log4j.xml");
                                     System.out.println("\n*****************************************************\n");
                                     Log.info("\n*****************************************************\n");
                                     System.out.println("Executing Modifiers- Add");
                                     Log.info("Executing  Modifiers- Add ");
                                     
                                     
                                     try{
                                                     String Path=Constant.Path_TestData + Constant.File_Add_Modifiers;
                                                     int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
                                     for (int count=1; count<=rowCount; count++){
                                                     String ModifiersCode= ExcelUtils.getCellData(count,1);
                                                     String ModifiersName=ExcelUtils.getCellData(count,2); 
                                                     String ModifiersNewCode= ExcelUtils.getCellData(count, 3);
                                                     String ModifiersNewName= ExcelUtils.getCellData(count, 4);
                                                     String ModifiersEditName= ExcelUtils.getCellData(count, 5);
                                                     
                                                                                     
                                                                                                                     String ModifiersCommSubject= ExcelUtils.getCellData(count, 6);
                                                                                                                     String  ModifiersCommNoteType = ExcelUtils.getCellData(count, 7);
                                                                                                                     String  ModifiersCommNoteMedium = ExcelUtils.getCellData(count, 8);
                                                                                                                     String  ModifiersCommDetails = ExcelUtils.getCellData(count, 9);
                                                                                                                     
                                                     if (ExcelUtils.getCellData(count,0).isEmpty())
                                                     {System.out.println("End of Test Data");}
                                                     else{
                                                     
                                                     System.out.println("\n----------------------------------------------------\n");
                                                                     System.out.println("Modifiers Add- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
                                                                     System.out.println("\n----------------------------------------------------\n");
                                                                     Log.info("----------------------------------------------------");
                                                                     Log.info("Modifiers Add- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
                                                                     Log.info("----------------------------------------------------");
                                                                     addModifiersMultiple(driver,ModifiersCode, ModifiersName);
                                                     }
                                     }
                                     }catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
                     }
                     
                                     
                                     public void addModifiersMultiple(WebDriver driver,String ModifiersCode, String ModifiersName) throws Exception
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

                         			homePageObject.clickReferencegotoModifiers();	
                         			   
                                     
                                     
                                   
                         
                                     Modifiers ModifiersObject = new Modifiers(driver);
                                     ModifiersObject.addModifiers(ModifiersCode, ModifiersName);
                                     
                                     }
                                     @AfterMethod
                     	      		public void afterMethod() throws Exception {
                     	      		if (driver!=null) driver.quit();
                     	      		System.out.println("Done with Modifiers-Add \n\n");
                     	      		Log.info("log4j -Done with Modifiers-Add \n\n");
                     	      		if (fis != null) 	fis.close();
                     	      	}
                     	      }


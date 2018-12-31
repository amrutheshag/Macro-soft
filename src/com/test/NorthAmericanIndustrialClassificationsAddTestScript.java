package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.NorthAmericanIndustrialClassifications;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.PayersPage;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class NorthAmericanIndustrialClassificationsAddTestScript {
                WebDriver driver;
                FileInputStream fis;
                                @Test
                                public void NorthAmericanIndustrialClassificationsAddTestScript1() throws Exception{
                                                DOMConfigurator.configure("log4j.xml");
                                                System.out.println("\n*****************************************************\n");
                                                Log.info("\n*****************************************************\n");
                                                System.out.println("Executing North American Industrial Classifications- Add");
                                                Log.info("Executing  North American Industrial Classifications- Add ");
                                                
                                                
                                                try{
                                                                String Path=Constant.Path_TestData + Constant.File_Add_NorthAmericanIndustrialClassifications;
                                                                int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
                                                for (int count=1; count<=rowCount; count++){
                                                                String northamericanIndustrialClassificationsCode= ExcelUtils.getCellData(count,1);
                                                                String northamericanindustrialClassificationsName=ExcelUtils.getCellData(count,2); 
                                                                String northamericanIndustrialClassificationsNewCode= ExcelUtils.getCellData(count, 3);
                                                                String northamericanIndustrialClassificationsNewName= ExcelUtils.getCellData(count, 4);
                                                                String northamericanIndustrialClassificationsEditName= ExcelUtils.getCellData(count, 5);
                                                                
                                                                                                
                                                                                                                                String northamericanIndustrialClassificationsCommSubject= ExcelUtils.getCellData(count, 6);
                                                                                                                                String  northamericanIndustrialClassificationsCommNoteType = ExcelUtils.getCellData(count, 7);
                                                                                                                                String  northamericanIndustrialClassificationsCommNoteMedium = ExcelUtils.getCellData(count, 8);
                                                                                                                                String  northamericanIndustrialClassificationsCommDetails = ExcelUtils.getCellData(count, 9);
                                                                                                                                
                                                                if (ExcelUtils.getCellData(count,0).isEmpty())
                                                                {System.out.println("End of Test Data");}
                                                                else{
                                                                
                                                                System.out.println("\n----------------------------------------------------\n");
                                                                                System.out.println("North American Industrial Classifications Add- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
                                                                                System.out.println("\n----------------------------------------------------\n");
                                                                                Log.info("----------------------------------------------------");
                                                                                Log.info("North American Industrial Classifications Add- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
                                                                                Log.info("----------------------------------------------------");
                                                                                addNorthAmericanIndustrialClassificationsMultiple(driver,northamericanIndustrialClassificationsCode, northamericanindustrialClassificationsName);
                                                                }
                                                }
                                                }catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
                                }
                                
                                                
                                                public void addNorthAmericanIndustrialClassificationsMultiple(WebDriver driver,String NorthAmericanIndustrialClassificationsCode, String NorthAmericanIndustrialClassificationsName) throws Exception
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
                                                                                                                                
                                                //click Payers-Emps
                                                HomePage homePageObject = new HomePage(driver);
                                                homePageObject.clickPayersEmps();     
                                                
                                                
                                             
                                                PayersPage PayersPageObject = new PayersPage(driver);
                                        		PayersPageObject.clickOnNorthAmericanIndustrialClassifications(); 
                                             
                                                
                                             
                                                
                                               
                                                NorthAmericanIndustrialClassifications NorthAmericanIndustrialClassificationsObject = new NorthAmericanIndustrialClassifications(driver);
                                                NorthAmericanIndustrialClassificationsObject.addNorthAmericanIndustrialClassifications(NorthAmericanIndustrialClassificationsCode, NorthAmericanIndustrialClassificationsName);
                                                
                                                }
                                                @AfterMethod
                                        		public void afterMethod() throws Exception {
                                        		if (driver!=null) driver.quit();
                                        		System.out.println("Done with North American Industrial Classifications-Add   \n\n");
                                        		if (fis != null)
                                        				fis.close();
                                        	}

                               

}

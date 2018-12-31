package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.CarrierCoverageTypes;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.PayersPage;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class CarrierCoverageTypesAddTestScript {
                WebDriver driver;
                FileInputStream fis;
                                @Test
                                public void CarrierCoverageTypesAddTestScriptTestScript() throws Exception{
                                                DOMConfigurator.configure("log4j.xml");
                                                System.out.println("\n*****************************************************\n");
                                                Log.info("\n*****************************************************\n");
                                                System.out.println("Executing Carrier Coverage Types- Add");
                                                Log.info("Executing  Carrier Coverage Types- Add ");
                                                
                                                
                                                try{
                                                                String Path=Constant.Path_TestData + Constant.File_Add_CarrierCoverageTypes;
                                                                int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
                                                for (int count=1; count<=rowCount; count++){
                                                                String carriercoverageTypeCode= ExcelUtils.getCellData(count,1);
                                                                String carriercoverageTypesName=ExcelUtils.getCellData(count,2); 
                                                                String carriercoverageTypeNewCode= ExcelUtils.getCellData(count, 3);
                                                                String carriercoverageTypeNewName= ExcelUtils.getCellData(count, 4);
                                                                String carriercoverageTypeEditName= ExcelUtils.getCellData(count, 5);
                                                                
                                                                                                
                                                                                                                                String carriercoverageTypeCommSubject= ExcelUtils.getCellData(count, 6);
                                                                                                                                String  carriercoverageTypeCommNoteType = ExcelUtils.getCellData(count, 7);
                                                                                                                                String  carriercoverageTypeCommNoteMedium = ExcelUtils.getCellData(count, 8);
                                                                                                                                String  carriercoverageTypeCommDetails = ExcelUtils.getCellData(count, 9);
                                                                                                                                
                                                                if (ExcelUtils.getCellData(count,0).isEmpty())
                                                                {System.out.println("End of Test Data");}
                                                                else{
                                                                
                                                                System.out.println("\n----------------------------------------------------\n");
                                                                                System.out.println("Carrier Coverage Types Add- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
                                                                                System.out.println("\n----------------------------------------------------\n");
                                                                                Log.info("----------------------------------------------------");
                                                                                Log.info("Carrier COverage Types Add- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
                                                                                Log.info("----------------------------------------------------");
                                                                                addCarrierCoverageTypesMultiple(driver,carriercoverageTypeCode, carriercoverageTypesName);
                                                                }
                                                }
                                                }catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
                                }
                                
                                                
                                                public void addCarrierCoverageTypesMultiple(WebDriver driver,String CarrierCoverageTypesCode, String CarrierCoverageTypesName) throws Exception
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
                                                
                                                homePageObject.clickPayersEmps();     
                                                
                                                PayersPage PayersPageObject = new PayersPage(driver);
                                        		PayersPageObject.clickOnCarrierCoverageTypes();    

                                             
                                                
                                                Thread.sleep(2000);
                                                
                                               
                                                CarrierCoverageTypes CarrierCoverageTypesObject = new CarrierCoverageTypes(driver);
                                                CarrierCoverageTypesObject.addCarrierCoverageTypes(CarrierCoverageTypesCode, CarrierCoverageTypesName);
                                                
                                                }
                                                
                                                @AfterMethod
                                        		public void afterMethod() throws Exception {
                                        		if (driver!=null) driver.quit();
                                        		System.out.println("Done with Carrier Coverage Types-Add   \n\n");
                                        		if (fis != null)
                                        				fis.close();
                                        				
                                        	}

                               

}

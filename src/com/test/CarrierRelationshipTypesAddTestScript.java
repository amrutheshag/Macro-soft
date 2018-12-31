package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.CarrierRelationshipTypes;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.PayersPage;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class CarrierRelationshipTypesAddTestScript {
                WebDriver driver;
                FileInputStream fis;
                                @Test
                                public void CarrierRelationshipTypesAddTestScriptTestScript() throws Exception{
                                                DOMConfigurator.configure("log4j.xml");
                                                System.out.println("\n*****************************************************\n");
                                                Log.info("\n*****************************************************\n");
                                                System.out.println("Executing Carrier Relationship Types- Add");
                                                Log.info("Executing  Carrier Relationship Types- Add ");
                                                
                                                
                                                try{
                                                                String Path=Constant.Path_TestData + Constant.File_Add_CarrierRelationshipTypes;
                                                                int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
                                                for (int count=1; count<=rowCount; count++){
                                                                String carrierrelationshipTypeCode= ExcelUtils.getCellData(count,1);
                                                                String carrierrelationshipTypesName=ExcelUtils.getCellData(count,2); 
                                                                String carrierrelationshipTypeNewCode= ExcelUtils.getCellData(count, 3);
                                                                String carrierrelationshipTypeNewName= ExcelUtils.getCellData(count, 4);
                                                                String carrierrelationshipTypeEditName= ExcelUtils.getCellData(count, 5);
                                                                
                                                                                                
                                                                                                                                String carrierrelationshipTypeCommSubject= ExcelUtils.getCellData(count, 6);
                                                                                                                                String  carrierrelationshipTypeCommNoteType = ExcelUtils.getCellData(count, 7);
                                                                                                                                String  carrierrelationshipTypeCommNoteMedium = ExcelUtils.getCellData(count, 8);
                                                                                                                                String  carrierrelationshipTypeCommDetails = ExcelUtils.getCellData(count, 9);
                                                                                                                                
                                                                if (ExcelUtils.getCellData(count,0).isEmpty())
                                                                {System.out.println("End of Test Data");}
                                                                else{
                                                                
                                                                System.out.println("\n----------------------------------------------------\n");
                                                                                System.out.println("Carrier Relationship Types Add- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
                                                                                System.out.println("\n----------------------------------------------------\n");
                                                                                Log.info("----------------------------------------------------");
                                                                                Log.info("Carrier Relationship Types Add- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
                                                                                Log.info("----------------------------------------------------");
                                                                                addCarrierRelationshipTypesMultiple(driver,carrierrelationshipTypeCode, carrierrelationshipTypesName);
                                                                }
                                                }
                                                }catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
                                }
                                
                                                
                                                public void addCarrierRelationshipTypesMultiple(WebDriver driver,String CarrierRelationshipTypesCode, String CarrierRelationshipTypesName) throws Exception
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
                                                try{
                                                    homePageObject.clickExitMyOpenCaseListing();
                                                }
                                                catch(Exception e){ 
                                                	System.out.println("Blank Home Page");
                                                	Log.info("log4j - msg -Blank Home Page");
                                                }

                                                homePageObject.clickPayersEmps();     
                                                
                                                PayersPage PayersPageObject = new PayersPage(driver);
                                        		PayersPageObject.clickOnCarrierRelationshipTypes(); 
                                             
                                                CarrierRelationshipTypes CarrierRelationshipTypesObject = new CarrierRelationshipTypes(driver);
                                                CarrierRelationshipTypesObject.addCarrierRelationshipTypes(CarrierRelationshipTypesCode, CarrierRelationshipTypesName);
                                                
                                                }
                                                @AfterMethod
                                        		public void afterMethod() throws Exception {
                                        		if (driver!=null) driver.quit();
                                        		System.out.println("Done with Carrier Relationship Types-Add   \n\n");
                                        		if (fis != null) 
                                        				fis.close();
                                        				
                                        	}

                               

}

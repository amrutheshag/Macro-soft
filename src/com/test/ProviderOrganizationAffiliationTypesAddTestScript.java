package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.ProviderOrganizationAffiliationTypes;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class ProviderOrganizationAffiliationTypesAddTestScript {
	 WebDriver driver;
	    FileInputStream fis;
	                    @Test
	                    public void ProviderOrganizationAffiliationTypesAddTestScript1() throws Exception{
	                                    DOMConfigurator.configure("log4j.xml");
	                                    System.out.println("\n*****************************************************\n");
	                                    Log.info("\n*****************************************************\n");
	                                    System.out.println("Executing Provider-Organization Affiliation Types- Add");
	                                    Log.info("Executing  Provider-Organization Affiliation Types- Add ");
	                                    
	                                    
	                                    try{
	                                                    String Path=Constant.Path_TestData + Constant.File_Add_ProviderOrganizationAffiliationTypes;
	                                                    int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
	                                    for (int count=1; count<=rowCount; count++){
	                                                    String providerorganizationaffiliationTypesCode= ExcelUtils.getCellData(count,1);
	                                                    String providerorganizationaffiliationTypesName=ExcelUtils.getCellData(count,2); 
	                                                    String providerorganizationaffiliationTypesNewCode= ExcelUtils.getCellData(count, 3);
	                                                    String providerorganizationaffiliationTypesNewName= ExcelUtils.getCellData(count, 4);
	                                                    String providerorganizationaffiliationTypesEditName= ExcelUtils.getCellData(count, 5);
	                                                    
	                                                                                    
	                                                                                                                    String providerorganizationaffiliationTypesCommSubject= ExcelUtils.getCellData(count, 6);
	                                                                                                                    String  providerorganizationaffiliationTypesCommNoteType = ExcelUtils.getCellData(count, 7);
	                                                                                                                    String  providerorganizationaffiliationTypesCommNoteMedium = ExcelUtils.getCellData(count, 8);
	                                                                                                                    String  providerorganizationaffiliationTypesCommDetails = ExcelUtils.getCellData(count, 9);
	                                                                                                                    
	                                                    if (ExcelUtils.getCellData(count,0).isEmpty())
	                                                    {System.out.println("End of Test Data");}
	                                                    else{
	                                                    
	                                                    System.out.println("\n----------------------------------------------------\n");
	                                                                    System.out.println("Provider-Organization Affiliation Types Add- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
	                                                                    System.out.println("\n----------------------------------------------------\n");
	                                                                    Log.info("----------------------------------------------------");
	                                                                    Log.info("Provider-Organization Affiliation Types Add- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
	                                                                    Log.info("----------------------------------------------------");
	                                                                    addproviderorganizationaffiliationTypesMultiple(driver,providerorganizationaffiliationTypesCode, providerorganizationaffiliationTypesName);
	                                                    }
	                                    }
	                                    }catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
	                    }
	                    
	                                    
	                                    public void addproviderorganizationaffiliationTypesMultiple(WebDriver driver,String providerorganizationaffiliationTypesCode, String providerorganizationaffiliationTypesName) throws Exception
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

	                        			homePageObject.clickReferencegotoProviderOrganizationAffiliationTypes();	
	                        			   
	                                    
	                                    
	                                       ProviderOrganizationAffiliationTypes ProviderOrganizationAffiliationTypesObject = new ProviderOrganizationAffiliationTypes(driver);
	                                    ProviderOrganizationAffiliationTypesObject.addProviderOrganizationAffiliationTypes(providerorganizationaffiliationTypesCode, providerorganizationaffiliationTypesName);
	                                    
	                                    }
	                                    @AfterMethod
	                            		public void afterMethod() throws Exception {
	                            		if (driver!=null) driver.quit();
	                            		System.out.println("Done with Provider-Organization Affiliation Types-Add \n\n");
	                            		Log.info("log4j -Done with Provider-Organization Affiliation Types-Add \n\n");
	                            		if (fis != null) 	fis.close();
	                            		} 
	                            	}
	                          



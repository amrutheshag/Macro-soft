package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.UMProviderRoles;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class UMProviderRolesAddTestScript {
	 WebDriver driver;
	    FileInputStream fis;
	                    @Test
	                    public void UMProviderRolesAddTestScriptTestScript() throws Exception{
	                                    DOMConfigurator.configure("log4j.xml");
	                                    System.out.println("\n*****************************************************\n");
	                                    Log.info("\n*****************************************************\n");
	                                    System.out.println("Executing UM Provider Roles- Add");
	                                    Log.info("Executing  UM Provider Roles- Add ");
	                                    
	                                    
	                                    try{
	                                                    String Path=Constant.Path_TestData + Constant.File_Add_UMProviderRoles;
	                                                    int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
	                                    for (int count=1; count<=rowCount; count++){
	                                                    String umproviderRolesCode= ExcelUtils.getCellData(count,1);
	                                                    String umproviderRolesName=ExcelUtils.getCellData(count,2); 
	                                                    String umproviderRolesNewCode= ExcelUtils.getCellData(count, 3);
	                                                    String umproviderRolesNewName= ExcelUtils.getCellData(count, 4);
	                                                    String umproviderRolesEditName= ExcelUtils.getCellData(count, 5);
	                                                    
	                                                                                    
	                                                                                                                    String umproviderRolesCommSubject= ExcelUtils.getCellData(count, 6);
	                                                                                                                    String  umproviderRolesCommNoteType = ExcelUtils.getCellData(count, 7);
	                                                                                                                    String  umproviderRolesCommNoteMedium = ExcelUtils.getCellData(count, 8);
	                                                                                                                    String  umproviderRolesCommDetails = ExcelUtils.getCellData(count, 9);
	                                                                                                                    
	                                                    if (ExcelUtils.getCellData(count,0).isEmpty())
	                                                    {System.out.println("End of Test Data");}
	                                                    else{
	                                                    
	                                                    System.out.println("\n----------------------------------------------------\n");
	                                                                    System.out.println("UM Provider Roles Add- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
	                                                                    System.out.println("\n----------------------------------------------------\n");
	                                                                    Log.info("----------------------------------------------------");
	                                                                    Log.info("UM Provider Roles Add- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
	                                                                    Log.info("----------------------------------------------------");
	                                                                    addUMProviderRolesMultiple(driver,umproviderRolesCode, umproviderRolesName);
	                                                    }
	                                    }
	                                    }catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
	                    }
	                    
	                                    
	                                    public void addUMProviderRolesMultiple(WebDriver driver,String UMProviderRolesCode, String UMProviderRolesName) throws Exception
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
	                                    
	                                    homePageObject.clickReferencegotoUMProviderRoles();    
	                    
	                   
	                                    UMProviderRoles UMProviderRolesObject = new UMProviderRoles(driver);
	                                    UMProviderRolesObject.addUMProviderRoles(UMProviderRolesCode, UMProviderRolesName);
	                                    
	                                    }
	                                    @AfterMethod
	                            		public void afterMethod() throws Exception {
	                            		if (driver!=null) driver.quit();
	                            		System.out.println("Done with UM Provider Roles-Add \n\n");
	                            		Log.info("log4j-Done with UM Provider Roles-Add \n\n");
	                            		if (fis != null) 	fis.close();
	                            	}
	                            }

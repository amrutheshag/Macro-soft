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

public class UMProviderRolesExitTestScript {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void UMProviderRolesExitTestScript1() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing UM Provider Roles- Exit");
			Log.info("Executing  UM Provider Roles- Exit ");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_Add_UMProviderRoles;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String umproviderRolesCode= ExcelUtils.getCellData(count,1);
		    		String umproviderRolesDescription=ExcelUtils.getCellData(count,2);	
		    		String umproviderRolesNewCode= ExcelUtils.getCellData(count, 3);
		    		String umproviderRolesNewDescription= ExcelUtils.getCellData(count, 4);
		    		String umproviderRolesEditDescription= ExcelUtils.getCellData(count, 5);
		    		
		    				
		    						String umproviderRolesCommSubject= ExcelUtils.getCellData(count, 6);
		    						String umproviderRolesCommNoteType = ExcelUtils.getCellData(count, 7);
		    						String umproviderRolesCommNoteMedium = ExcelUtils.getCellData(count, 8);
		    						String umproviderRolesCommDetails = ExcelUtils.getCellData(count, 9);
		    						
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("End of Test Data");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("UM Provider Roles Exit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("UM Provider Roles Exit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
   		 	exitumproviderRolesMultiple(driver,umproviderRolesCode);
		    		}
		    	}
			}catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void exitumproviderRolesMultiple(WebDriver driver,String umproviderRolesCode) throws Exception
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

			homePageObject.clickReferencegotoUMProviderRoles();	
			
			
			Thread.sleep(2000);
			
			UMProviderRoles umproviderRolesPageObject = new UMProviderRoles(driver);
			umproviderRolesPageObject.exitUMProviderRoles( umproviderRolesCode);
			
			}

			@AfterMethod
      		public void afterMethod() throws Exception {
      		if (driver!=null) driver.quit();
      		System.out.println("Done with UM Provider Roles-Exit \n\n");
      		Log.info("log4j-Done with UM Provider Roles-Exit \n\n");
      		if (fis != null) 		fis.close();
      	}
      }


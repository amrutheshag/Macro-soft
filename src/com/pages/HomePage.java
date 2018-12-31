package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import utility.BrowserUtils;
import utility.Log;


public class HomePage {
	
	WebDriver driver;
	WebDriverWait wait;

	By memberActivityLink=By.linkText("MemberActivity");
	
	By ReferenceLink=By.linkText("Reference");
	
	By ProvidersLink = By.linkText("Providers");
	
	By PayersEmpsLink = By.linkText("Payers-Emps");
	
	By EDILink = By.linkText("EDI");
	
	By ReportsLink = By.linkText("Reports");

	By ExitMyOpenCaseListingLink = By.linkText("Exit");
	
	By CommunicationsLink = By.linkText("Communications");
	
	By SetupLink = By.linkText("Setup");
	
	public HomePage(WebDriver driver){
		this.driver= driver;
		this.wait  = new WebDriverWait(driver, 25);
	
	}
	
	
	public void clickExitMyOpenCaseListing() throws Exception{
		try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(ExitMyOpenCaseListingLink));
			driver.findElement(ExitMyOpenCaseListingLink).click();
			Log.info("log4j msg- clicked on Exit in My Open Case Listing");
			System.out.println("clicked on Exit in My Open Case Listing");
		}catch(Exception e) {
			Log.info("log4j msg- Blank landing page  \n"); 
			System.out.println("Blank landing page \n"); 	}
	}
		
	
	
	public void clickMemberActivity() throws Exception{
			try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(memberActivityLink));
			driver.findElement(memberActivityLink).click();
			Log.info("log4j msg- clicked on Member Activity");
			System.out.println("clicked Member Activity");
		}catch(Exception e) {
			Log.info("log4j msg- Unable to click Member Activity\n");
			System.out.println("Unable to click Member Activity\n"); 	
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
			driver.quit();
	}
	}

	
	
	
	
	public void clickEDI() throws Exception{
			try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(EDILink));
			driver.findElement(EDILink).click();
			Log.info("log4j msg- clicked on EDI");
			System.out.println("clicked EDI");
		}catch(Exception e) {
			Log.info("log4j msg- Unable to click EDI\n");System.out.println("Unable to click EDI\n"); 
			System.out.println("Unable to click EDI\n");
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
	driver.quit();
	
	}}
	
	
	
	
	
	
	
	
	public void clickProviders() throws Exception{
		try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(ProvidersLink));
	
		driver.findElement(ProvidersLink).click();
		Log.info("log4j msg- clicked on Providers in home page");
		System.out.println("Clicked on Providers in home page");
		}catch (Exception e){
			Log.info("log4j msg- error in clicking providers\n");
			System.out.println("error in clicking providers\n"); 	
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit();
	}}

	
	public void clickPayersEmps() throws Exception{
		try{
			
		wait.until(ExpectedConditions.visibilityOfElementLocated(PayersEmpsLink));
	
		driver.findElement(PayersEmpsLink).click();
		
		Log.info("log4j msg- clicked on Payers-Emps in home page");
		System.out.println("Clicked on Payers-Emps in home page");
		}catch (Exception e){
			System.out.println("error in clicking Payers-Emps"); 
			Log.info("log4j msg- error in clicking Payers-Emps"); 
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
			driver.quit();}
	}
	
	public void clickReports() throws Exception{
			try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(ReportsLink));
	
		driver.findElement(ReportsLink).click();
		
		Log.info("log4j msg- clicked on Reports in home page");
		System.out.println("Clicked on Reports in home page");
		}catch (Exception e){
			System.out.println("error in clicking Reports"); 
			Log.info("log4j msg- error in clicking Reports"); 
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
			driver.quit();}
	}
	
	
	public void clickCommunications() throws Exception{
			try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(CommunicationsLink));
	
		driver.findElement(CommunicationsLink).click();
		
		Log.info("log4j msg- clicked on Communication in home page");
		System.out.println("Clicked on Communication in home page");
		}catch (Exception e){
			System.out.println("Error in clicking Communication"); 
			Log.info("log4j msg- Error in clicking Communication"); 
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
			driver.quit();}
	}
	
	
	
	public void clickReferencegotoEthnicCategories() throws Exception{
			try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(ReferenceLink));
			driver.findElement(ReferenceLink).click();
			Log.info("log4j msg- clicked on Reference");
			System.out.println("clicked on Reference");
			//driver.findElement(By.linkText("Reference"));
			Actions action=new Actions(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Member Supporting Codes")));
			action.moveToElement(driver.findElement(By.linkText("Member Supporting Codes"))).build().perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Ethnic Categories")));
			action.moveToElement(driver.findElement(By.linkText("Ethnic Categories"))).click().build().perform();
	
			}catch(Exception e){
				Log.info("log4j msg- Error in clicking reference- Ethnic Categories");
				System.out.println("Error in clicking reference - Ethnic Categories"); 	
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit();	}
	}

	public void clickReferencegotoDiagnosisCodeSets() throws Exception{
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(ReferenceLink));
			driver.findElement(ReferenceLink).click();
			Log.info("log4j msg- clicked on Reference");
			System.out.println("clicked on Reference");
			Actions action=new Actions(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Diagnostic Code Types")));
			action.moveToElement(driver.findElement(By.linkText("Diagnostic Code Types"))).build().perform();
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Diagnosis Code Sets")));
			action.moveToElement(driver.findElement(By.linkText("Diagnosis Code Sets"))).click().build().perform();
	Thread.sleep(1000);
			}catch(Exception e){Log.info("log4j msg- Error in clicking reference- Diagnosis Code Sets");
			System.out.println("Error in clicking reference- Diagnosis Code Sets"); 	
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 

		driver.quit();}
	}

	
	
	public void clickReferencegotoServiceCodes() throws Exception{
			try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(ReferenceLink));
			driver.findElement(ReferenceLink).click();
			Log.info("log4j msg- clicked on Reference");
			System.out.println("clicked on Reference");
			Actions action=new Actions(driver);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Procedural Code Types")));
			action.moveToElement(driver.findElement(By.linkText("Procedural Code Types"))).build().perform();
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Service Codes")));
			action.moveToElement(driver.findElement(By.linkText("Service Codes"))).click().build().perform();
	Thread.sleep(1000);
			}catch(Exception e){
				Log.info("log4j msg- Error in clicking reference- Service Codes");
				System.out.println("error in clicking reference- Service Codes"); 	
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
				driver.quit();}
	
	}

	public void clickReferencegotoRelativeValueUnits() throws Exception{
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(ReferenceLink));
			driver.findElement(ReferenceLink).click();
			Log.info("log4j msg- clicked on Reference");
			System.out.println("clicked on Reference");
			Actions action=new Actions(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Procedural Code Types")));
			action.moveToElement(driver.findElement(By.linkText("Procedural Code Types"))).build().perform();
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Relative Value Units")));
			action.moveToElement(driver.findElement(By.linkText("Relative Value Units"))).click().build().perform();
	Thread.sleep(1000);
			}catch(Exception e){
				Log.info("log4j msg- Error in clicking reference- Relative Value Units");
				System.out.println("error in clicking reference- Relative Value Units"); 	
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
				driver.quit();}
		
	}
	
	
	
	
	
	public void clickReferencegotoCoverageManualEntryReasons() throws Exception{
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(ReferenceLink));
			driver.findElement(ReferenceLink).click();
			Log.info("log4j msg- clicked on Reference");
			System.out.println("clicked on Reference");
			Actions action=new Actions(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Member Supporting Codes")));
			action.moveToElement(driver.findElement(By.linkText("Member Supporting Codes"))).build().perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Coverage Manual Entry Reasons")));
			action.moveToElement(driver.findElement(By.linkText("Coverage Manual Entry Reasons"))).click().build().perform();
	
			}catch(Exception e){
				Log.info("log4j msg- Error in clicking reference - Coverage Manual Entry Reasons");
				System.out.println("Error in clicking reference - Coverage Manual Entry Reasons"); 
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
				
		driver.quit();	}
	}
	public void clickReferencegotoJobStatusCategories() throws Exception{
	try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(ReferenceLink));
			driver.findElement(ReferenceLink).click();
			Log.info("log4j msg- clicked on Reference");
			System.out.println("clicked on Reference");
			
			Actions action=new Actions(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Member Supporting Codes")));
			action.moveToElement(driver.findElement(By.linkText("Member Supporting Codes"))).build().perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Member Supporting Codes")));
			action.moveToElement(driver.findElement(By.linkText("Job Status Categories"))).click().build().perform();
	
			}catch(Exception e){
				Log.info("log4j msg- error in clicking reference");
				System.out.println("error in clicking reference"); 	
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit();	}
	}
	
	public void clickReferencegotoOccupationalClasses() throws Exception{
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(ReferenceLink));
			driver.findElement(ReferenceLink).click();
			Log.info("log4j msg- clicked on Reference");
			System.out.println("clicked on Reference");
			
			Actions action=new Actions(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Member Supporting Codes")));
			action.moveToElement(driver.findElement(By.linkText("Member Supporting Codes"))).build().perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Occupational Classes")));
			action.moveToElement(driver.findElement(By.linkText("Occupational Classes"))).click().build().perform();
	
			}catch(Exception e){
				Log.info("log4j msg- Error in clicking reference - Occupational Classes"); 
				System.out.println("Error in clicking reference - Occupational Classes"); 	
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
		driver.quit();	}
	}
	
	public void clickReferencegotoMemberSubscriberRelationships() throws Exception{
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(ReferenceLink));
			driver.findElement(ReferenceLink).click();
			Log.info("log4j msg- clicked on Reference");
			System.out.println("clicked on Reference");
		
			Actions action=new Actions(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Member Supporting Codes")));
			action.moveToElement(driver.findElement(By.linkText("Member Supporting Codes"))).build().perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Member-Subscriber Relationships")));
			action.moveToElement(driver.findElement(By.linkText("Member-Subscriber Relationships"))).click().build().perform();
	
			}catch(Exception e){e.printStackTrace();
			Log.info("log4j msg- Error in clicking reference - Member-Subscriber Relationships");
			System.out.println("Error in clicking reference - Member-Subscriber Relationships"); 	
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
		driver.quit();	}
	}
	
	public void clickReferencegotoPayerTypes() throws Exception{
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(ReferenceLink));
			driver.findElement(ReferenceLink).click();
			Log.info("log4j msg- clicked on Reference");
			System.out.println("clicked on Reference");
		
			Actions action=new Actions(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Member Supporting Codes")));
			action.moveToElement(driver.findElement(By.linkText("Member Supporting Codes"))).build().perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Payer Types")));
			action.moveToElement(driver.findElement(By.linkText("Payer Types"))).click().build().perform();
	
			}catch(Exception e){
				Log.info("log4j msg- Error in clicking reference- Payer Types");
				System.out.println("Error in clicking reference- Payer Types"); 	
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
		driver.quit();	}
	}
	
	public void clickReferencegotoContractTypes() throws Exception{
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(ReferenceLink));
			driver.findElement(ReferenceLink).click();
			Log.info("log4j msg- clicked on Reference");
			System.out.println("clicked on Reference");
			Actions action=new Actions(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Member Supporting Codes")));
			action.moveToElement(driver.findElement(By.linkText("Member Supporting Codes"))).build().perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Contract Types")));
			action.moveToElement(driver.findElement(By.linkText("Contract Types"))).click().build().perform();
	
			}catch(Exception e){
				Log.info("log4j msg- Error in clicking reference - Contract Types");
				System.out.println("Error in clicking reference - Contract Types"); 	
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit();	}
	}
	
	public void clickReferencegotoInsuranceCoverageExtents() throws Exception{
			try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(ReferenceLink));
			driver.findElement(ReferenceLink).click();
			Log.info("log4j msg- clicked on Reference");
			System.out.println("clicked on Reference");
			Actions action=new Actions(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Member Supporting Codes")));
			action.moveToElement(driver.findElement(By.linkText("Member Supporting Codes"))).build().perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Insurance Coverage Extents")));
			action.moveToElement(driver.findElement(By.linkText("Insurance Coverage Extents"))).click().build().perform();
	
			}catch(Exception e){
				Log.info("log4j msg- Error in clicking reference - Insurance Coverage Extents"); 
				System.out.println("Error in clicking reference - Insurance Coverage Extents"); 	
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit();	}
	}
	
	public void clickReferencegotoBenefitPremiumPaymentModes() throws Exception{
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(ReferenceLink));
			driver.findElement(ReferenceLink).click();
			Log.info("log4j msg- clicked on Reference");
			System.out.println("clicked on Reference");
			Actions action=new Actions(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Member Supporting Codes")));
			action.moveToElement(driver.findElement(By.linkText("Member Supporting Codes"))).build().perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Benefit Premium Payment Modes")));
			action.moveToElement(driver.findElement(By.linkText("Benefit Premium Payment Modes"))).click().build().perform();
	
			}catch(Exception e){
				Log.info("log4j msg- Error in clicking reference - Benefit Premium Payment Modes");
				System.out.println("Error in clicking reference - Benefit Premium Payment Modes"); 
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit();	}
	}

	public void clickReferencegotoFCMCActionCodes() throws Exception{
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(ReferenceLink));
			driver.findElement(ReferenceLink).click();
			Log.info("log4j msg- clicked on Reference");
			System.out.println("clicked on Reference");
			Actions action=new Actions(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("FCMC-Specific Supporting Codes")));
			action.moveToElement(driver.findElement(By.linkText("FCMC-Specific Supporting Codes"))).build().perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("FCMC Action Codes")));
			action.moveToElement(driver.findElement(By.linkText("FCMC Action Codes"))).click().build().perform();
	
			}catch(Exception e){
				Log.info ("log4j msg- error in clicking reference"); 
				System.out.println("error in clicking reference"); 	
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit();	}
	}
	
	public void clickReferencegotoFCMCRaceCodes() throws Exception{
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(ReferenceLink));
			driver.findElement(ReferenceLink).click();
			Log.info("log4j msg- clicked on Reference");
			System.out.println("clicked on Reference");
			Actions action=new Actions(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("FCMC-Specific Supporting Codes")));
			action.moveToElement(driver.findElement(By.linkText("FCMC-Specific Supporting Codes"))).build().perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("FCMC Race Codes")));
			action.moveToElement(driver.findElement(By.linkText("FCMC Race Codes"))).click().build().perform();
	
			}catch(Exception e){Log.info("log4j msg- Error in clicking reference - FCMC Race Codes"); 
				System.out.println("Error in clicking reference - FCMC Race Codes"); 	
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit();	}
	}
	
	public void clickReferencegotoFCMCEthnicGroupCodes() throws Exception{
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(ReferenceLink));
			driver.findElement(ReferenceLink).click();
			Log.info("log4j msg- clicked on Reference");
			System.out.println("clicked on Reference");
			Actions action=new Actions(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("FCMC-Specific Supporting Codes")));
			action.moveToElement(driver.findElement(By.linkText("FCMC-Specific Supporting Codes"))).build().perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("FCMC Ethnic Group Codes")));
			action.moveToElement(driver.findElement(By.linkText("FCMC Ethnic Group Codes"))).click().build().perform();
	
			}catch(Exception e){
				Log.info("log4j msg- Error in clicking reference - FCMC Ethnic Group Codes");
				System.out.println("Error in clicking reference - FCMC Ethnic Group Codes"); 
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
		driver.quit();	}
	
	}
	
	public void clickReferencegotoFCMCRelationCodes() throws Exception{
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(ReferenceLink));
			driver.findElement(ReferenceLink).click();
			Log.info("log4j msg- clicked on Reference");
			System.out.println("clicked on Reference");
			Actions action=new Actions(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("FCMC-Specific Supporting Codes")));
			action.moveToElement(driver.findElement(By.linkText("FCMC-Specific Supporting Codes"))).build().perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("FCMC Relation Codes")));
			action.moveToElement(driver.findElement(By.linkText("FCMC Relation Codes"))).click().build().perform();
	
			}catch(Exception e){
				Log.info("log4j msg- Error in clicking reference- FCMC Relation Codes");
				System.out.println("error in clicking reference- FCMC Relation Codes"); 	
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit();	}
	}
	
	public void clickReferencegotoFCMCLevelofCareCodes() throws Exception{
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(ReferenceLink));
			driver.findElement(ReferenceLink).click();
			Log.info("log4j msg- clicked on Reference");
			System.out.println("clicked on Reference");
			Actions action=new Actions(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("FCMC-Specific Supporting Codes")));
			action.moveToElement(driver.findElement(By.linkText("FCMC-Specific Supporting Codes"))).build().perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("FCMC Level of Care Codes")));
			action.moveToElement(driver.findElement(By.linkText("FCMC Level of Care Codes"))).click().build().perform();
	
			}catch(Exception e){
				Log.info("log4j msg- Error in clicking reference - FCMC Level of Care Codes");
				System.out.println("Error in clicking reference - FCMC Level of Care Codes"); 	
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
		driver.quit();	}	
	}
	
	public void clickReferencegotoFCMCConsenterTypes() throws Exception{
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(ReferenceLink));
			driver.findElement(ReferenceLink).click();
			Log.info("log4j msg- clicked on Reference");
			System.out.println("clicked on Reference");
			Actions action=new Actions(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("FCMC-Specific Supporting Codes")));
			action.moveToElement(driver.findElement(By.linkText("FCMC-Specific Supporting Codes"))).build().perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("FCMC Consenter Types")));
			action.moveToElement(driver.findElement(By.linkText("FCMC Consenter Types"))).click().build().perform();
	
			}catch(Exception e){
				Log.info("log4j msg- Error in clicking reference - FCMC Consenter Types");
				System.out.println("Error in clicking reference - FCMC Consenter Types"); 
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
		driver.quit();	}	
	}
	
	public void clickReferencegotoAcademicDegrees() throws Exception{
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(ReferenceLink));
			driver.findElement(ReferenceLink).click();
			Log.info("log4j msg- clicked on Reference");
			System.out.println("clicked on Reference");
			Actions action=new Actions(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Provider Supporting Codes")));
			action.moveToElement(driver.findElement(By.linkText("Provider Supporting Codes"))).build().perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Academic Degrees")));
			action.moveToElement(driver.findElement(By.linkText("Academic Degrees"))).click().build().perform();
	
			}catch(Exception e){
				Log.info("log4j msg- Error in clicking reference - Academic Degrees"); 	
		
				System.out.println("Error in clicking reference - Academic Degrees"); 	
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
		driver.quit();	}
	}
	
	public void clickReferencegotoProviderTypes() throws Exception{
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(ReferenceLink));
			driver.findElement(ReferenceLink).click();
			Log.info("log4j msg- clicked on Reference");
			System.out.println("clicked on Reference");
			Actions action=new Actions(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Provider Supporting Codes")));
			action.moveToElement(driver.findElement(By.linkText("Provider Supporting Codes"))).build().perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Provider Types")));
			action.moveToElement(driver.findElement(By.linkText("Provider Types"))).click().build().perform();
	
			}catch(Exception e){
				Log.info("log4j msg- Error in clicking reference- Provider Types"); 
				System.out.println("Error in clicking reference- Provider Types"); 	
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit();	}
	}
	
	public void clickReferencegotoProviderOrganizationAffiliationTypes() throws Exception{
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(ReferenceLink));
			driver.findElement(ReferenceLink).click();
			Log.info("log4j msg- clicked on Reference");
			System.out.println("clicked on Reference");
			Actions action=new Actions(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Provider Supporting Codes")));
			action.moveToElement(driver.findElement(By.linkText("Provider Supporting Codes"))).build().perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Provider-Organization Affiliation Types")));
			action.moveToElement(driver.findElement(By.linkText("Provider-Organization Affiliation Types"))).click().build().perform();
	
			}catch(Exception e){
				e.printStackTrace();
			Log.info("log4j msg- Error in clicking reference -Provider- Organization Affiliation Types");
				System.out.println("Error in clicking reference -Provider- Organization Affiliation Types"); 	
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
			driver.quit();	
			}
		}
	
	public void clickReferencegotoOfficeTypes() throws Exception{
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(ReferenceLink));
			driver.findElement(ReferenceLink).click();
			Log.info("log4j msg- clicked on Reference");
			System.out.println("clicked on Reference");
			
			Actions action=new Actions(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Provider Supporting Codes")));
			action.moveToElement(driver.findElement(By.linkText("Provider Supporting Codes"))).build().perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Office Types")));
			action.moveToElement(driver.findElement(By.linkText("Office Types"))).click().build().perform();
	
			}catch(Exception e){
				Log.info("log4j msg- Error in clicking reference- Office Types");
				System.out.println("Error in clicking reference- Office Types"); 	
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit();	}
	}
	
	public void clickReferencegotoOtherCredentiallingSourceTypes() throws Exception{
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(ReferenceLink));
			driver.findElement(ReferenceLink).click();
			Log.info("log4j msg- clicked on Reference");
			System.out.println("clicked on Reference");
			Actions action=new Actions(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Provider Supporting Codes")));
			action.moveToElement(driver.findElement(By.linkText("Provider Supporting Codes"))).build().perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Other Credentialling Source Types")));
			action.moveToElement(driver.findElement(By.linkText("Other Credentialling Source Types"))).click().build().perform();
	
			}catch(Exception e){
				Log.info("log4j msg- Error in clicking reference - Other Credentialling Source Types");
				System.out.println("Error in clicking reference - Other Credentialling Source Types"); 
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
driver.quit();
			}
		
	}
	
	public void clickReferencegotoCredentiallingStatuses() throws Exception{
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(ReferenceLink));
			driver.findElement(ReferenceLink).click();
			Log.info("log4j msg- clicked on Reference");
			System.out.println("clicked on Reference");
			Actions action=new Actions(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Provider Supporting Codes")));
			action.moveToElement(driver.findElement(By.linkText("Provider Supporting Codes"))).build().perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Credentialling Statuses")));
			action.moveToElement(driver.findElement(By.linkText("Credentialling Statuses"))).click().build().perform();
	
			}catch(Exception e){
				Log.info("log4j msg- Error in clicking reference- Credentialling Statuses"); 
				System.out.println("Error in clicking reference- Credentialling Statuses"); 	
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
			driver.quit();	
			}
		
	}
	
	public void clickReferencegotoCommunicationCaseTypes() throws Exception{
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(ReferenceLink));
			driver.findElement(ReferenceLink).click();
			Log.info("log4j msg- clicked on Reference");
			System.out.println("clicked on Reference");
			Actions action=new Actions(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Communications Supporting Codes")));
			action.moveToElement(driver.findElement(By.linkText("Communications Supporting Codes"))).build().perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Communication Case Types")));
			action.moveToElement(driver.findElement(By.linkText("Communication Case Types"))).click().build().perform();
	
			}catch(Exception e){
				Log.info("log4j msg- Error in clicking reference- Communication Case Types"); 
				System.out.println("Error in clicking reference- Communication Case Types"); 	
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
				driver.quit();
			}
		
	}
	
	public void clickReferencegotoCommunicationCaseStatuses() throws Exception{
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(ReferenceLink));
			driver.findElement(ReferenceLink).click();
			Log.info("log4j msg- clicked on Reference");
			System.out.println("clicked on Reference");
			
			Actions action=new Actions(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Communications Supporting Codes")));
			action.moveToElement(driver.findElement(By.linkText("Communications Supporting Codes"))).build().perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Communication Case Statuses")));
			action.moveToElement(driver.findElement(By.linkText("Communication Case Statuses"))).click().build().perform();
	
			}catch(Exception e){
				Log.info("log4j msg- Error in clicking reference - Communication Case Statuses");
				System.out.println("Error in clicking reference - Communication Case Statuses"); 	
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
			driver.quit();
			}
		
	}
	
	public void clickReferencegotoCommunicationCasePriorities() throws Exception{
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(ReferenceLink));
			driver.findElement(ReferenceLink).click();
			Log.info("log4j msg- clicked on Reference");
			System.out.println("clicked on Reference");
		
			Actions action=new Actions(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Communications Supporting Codes")));
			action.moveToElement(driver.findElement(By.linkText("Communications Supporting Codes"))).build().perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Communication Case Priorities")));
			action.moveToElement(driver.findElement(By.linkText("Communication Case Priorities"))).click().build().perform();
	
			}catch(Exception e){
				Log.info("log4j msg- Error in clicking reference- Communication Case Priorities");
				System.out.println("Error in clicking reference- Communication Case Priorities"); 	
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
driver.quit();
			}
		
	}
	
	public void clickReferencegotoJournalContactMedias() throws Exception{
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(ReferenceLink));
			driver.findElement(ReferenceLink).click();
			Log.info("log4j msg- clicked on Reference");
			System.out.println("clicked on Reference");
			
			Actions action=new Actions(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Communications Supporting Codes")));
			action.moveToElement(driver.findElement(By.linkText("Communications Supporting Codes"))).build().perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Journal Contact Medias")));
			action.moveToElement(driver.findElement(By.linkText("Journal Contact Medias"))).click().build().perform();
	
			}catch(Exception e){
				Log.info("log4j msg- Error in clicking reference - Journal Contact Medias"); 	
				System.out.println("Error in clicking reference - Journal Contact Medias"); 	
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
			driver.quit();	
			}
		
	}
	
	public void clickReferencegotoJournalNoteTypes() throws Exception{
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(ReferenceLink));
			driver.findElement(ReferenceLink).click();
			Log.info("log4j msg- clicked on Reference");
			System.out.println("clicked on Reference");
			Actions action=new Actions(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Communications Supporting Codes")));
			action.moveToElement(driver.findElement(By.linkText("Communications Supporting Codes"))).build().perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Journal Note Types")));
			action.moveToElement(driver.findElement(By.linkText("Journal Note Types"))).click().build().perform();
	
			}catch(Exception e){
				Log.info("log4j msg- Error in clicking reference- Journal Note Types");
				System.out.println("Error in clicking reference- Journal Note Types"); 	
				
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
driver.quit();
			}
		
	}
	
	public void clickReferencegotoDiagnosticCategories() throws Exception{
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(ReferenceLink));
			driver.findElement(ReferenceLink).click();
			Log.info("log4j msg- clicked on Reference");
			System.out.println("clicked on Reference");
			Actions action=new Actions(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Diagnostic Code Types")));
			action.moveToElement(driver.findElement(By.linkText("Diagnostic Code Types"))).build().perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Diagnostic Categories")));
			action.moveToElement(driver.findElement(By.linkText("Diagnostic Categories"))).click().build().perform();
	
			}catch(Exception e){
				Log.info("log4j msg- Error in clicking reference- Diagnostic Categories");
				System.out.println("Error in clicking reference- Diagnostic Categories"); 	
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
			driver.quit();	
			}
		
	}
	
	public void clickReferencegotoDiagnosisCodes() throws Exception{
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(ReferenceLink));
			driver.findElement(ReferenceLink).click();
			Log.info("log4j msg- clicked on Reference");
			System.out.println("clicked on Reference");
			Actions action=new Actions(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Diagnostic Code Types")));
			action.moveToElement(driver.findElement(By.linkText("Diagnostic Code Types"))).build().perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Diagnosis Codes")));
			action.moveToElement(driver.findElement(By.linkText("Diagnosis Codes"))).click().build().perform();
	
			}catch(Exception e){
				System.out.println("Error in clicking reference - Diagnosis Codes"); 
				Log.info("log4j msg- Error in clicking reference - Diagnosis Codes"); 
			
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
			driver.quit();
			}
		
	}
	
	
	public void clickReferencegotoURCaseProblemTypes() throws Exception{
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(ReferenceLink));
			driver.findElement(ReferenceLink).click();
			Log.info("log4j msg- clicked on Reference");
			System.out.println("clicked on Reference");
			Actions action=new Actions(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Diagnostic Code Types")));
			action.moveToElement(driver.findElement(By.linkText("Diagnostic Code Types"))).build().perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("UR Case/Problem Types")));
			action.moveToElement(driver.findElement(By.linkText("UR Case/Problem Types"))).click().build().perform();
	
			}catch(Exception e){
				Log.info("log4j msg- Error in clicking reference- UR Case/Problem Types");
				System.out.println("Error in clicking reference- UR Case/Problem Types"); 	
				
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
				driver.quit();
			}
		
	}
	
	public void clickReferencegotoHCFAServiceTypes() throws Exception{
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(ReferenceLink));
			driver.findElement(ReferenceLink).click();
			Log.info("log4j msg- clicked on Reference");
			System.out.println("clicked on Reference");
			Actions action=new Actions(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Procedural Code Types")));
			action.moveToElement(driver.findElement(By.linkText("Procedural Code Types"))).build().perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("HCFA Service Types")));
			action.moveToElement(driver.findElement(By.linkText("HCFA Service Types"))).click().build().perform();
	
			}catch(Exception e){
				Log.info("log4j msg- Error in clicking reference- HCFA Service Types"); 
				System.out.println("Error in clicking reference- HCFA Service Types"); 	
				
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
			driver.quit();	
			}
		
	}
	
	public void clickReferencegotoServiceCategories() throws Exception{
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(ReferenceLink));
			driver.findElement(ReferenceLink).click();
			Log.info("log4j msg- clicked on Reference");
			System.out.println("clicked on Reference");
			Actions action=new Actions(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Procedural Code Types")));
			action.moveToElement(driver.findElement(By.linkText("Procedural Code Types"))).build().perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Service Categories")));
			action.moveToElement(driver.findElement(By.linkText("Service Categories"))).click().build().perform();
	
			}catch(Exception e){
				Log.info("log4j msg- Error in clicking reference - Procedural Code Types - Service Categories");
				System.out.println("Error in clicking reference - Procedural Code Types - Service Categories"); 	
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
				driver.quit();
			}
		
	}
	
	public void clickReferencegotoModifiers() throws Exception{
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(ReferenceLink));
			driver.findElement(ReferenceLink).click();
			Log.info("log4j msg- clicked on Reference");
			System.out.println("clicked on Reference");
			Actions action=new Actions(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Procedural Code Types")));
			action.moveToElement(driver.findElement(By.linkText("Procedural Code Types"))).build().perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Modifiers")));
			action.moveToElement(driver.findElement(By.linkText("Modifiers"))).click().build().perform();
	
			}catch(Exception e){
				Log.info("log4j msg- Error in clicking reference- Procedural Code Types- Modifiers"); 
				System.out.println("Error in clicking reference- Procedural Code Types- Modifiers"); 	
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
			driver.quit();	
			}
		
	}
	
	public void clickReferencegotoServiceSets() throws Exception{
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(ReferenceLink));
			driver.findElement(ReferenceLink).click();
			Log.info("log4j msg- clicked on Reference");
			System.out.println("clicked on Reference");
			Actions action=new Actions(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Procedural Code Types")));
			action.moveToElement(driver.findElement(By.linkText("Procedural Code Types"))).build().perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Service Sets")));
			action.moveToElement(driver.findElement(By.linkText("Service Sets"))).click().build().perform();
	
			}catch(Exception e){
				Log.info("log4j msg- Error in clicking reference- Procedural Code Types- Service Sets"); 
				System.out.println("Error in clicking reference- Procedural Code Types- Service Sets"); 	
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
			driver.quit();	
			}
		
	}
	
	
	
	public void clickReferencegotoRVUGeographicMultipliers() throws Exception{
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(ReferenceLink));
			driver.findElement(ReferenceLink).click();
			Log.info("log4j msg- clicked on Reference");
			System.out.println("clicked on Reference");

			Actions action=new Actions(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Procedural Code Types")));
			action.moveToElement(driver.findElement(By.linkText("Procedural Code Types"))).build().perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("RVU Geographic Multipliers")));
			action.moveToElement(driver.findElement(By.linkText("RVU Geographic Multipliers"))).click().build().perform();
	
			}catch(Exception e){
				Log.info("log4j msg-  Error in clicking reference- RVU Geographic Multipliers"); 
				System.out.println("Error in clicking reference- RVU Geographic Multipliers"); 
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
				driver.quit();
			}
		
	}
	
	public void clickReferencegotoUMCaseStatusCodes() throws Exception{
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(ReferenceLink));
			driver.findElement(ReferenceLink).click();
			Log.info("log4j msg- clicked on Reference");
			System.out.println("clicked on Reference");
			Actions action=new Actions(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("UM Supporting Codes")));
			action.moveToElement(driver.findElement(By.linkText("UM Supporting Codes"))).build().perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("UM Case Status Codes")));
			action.moveToElement(driver.findElement(By.linkText("UM Case Status Codes"))).click().build().perform();
	
			}catch(Exception e){
				Log.info("log4j msg- Error in clicking reference - UM Case Status Codes"); 
				System.out.println("Error in clicking reference - UM Case Status Codes"); 	
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
				driver.quit();
			}
		
	}
	
	public void clickReferencegotoUMReasonsforReferral() throws Exception{
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(ReferenceLink));
			driver.findElement(ReferenceLink).click();
			Log.info("log4j msg-clicked on Reference");
			System.out.println("clicked on Reference");
			Actions action=new Actions(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("UM Supporting Codes")));
			action.moveToElement(driver.findElement(By.linkText("UM Supporting Codes"))).build().perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("UM Reasons for Referral")));
			action.moveToElement(driver.findElement(By.linkText("UM Reasons for Referral"))).click().build().perform();
	
			}catch(Exception e){
				Log.info("log4j msg- Error in clicking reference- UM Reasons for Referral");
				System.out.println("Error in clicking reference- UM Reasons for Referral"); 	
				
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
			driver.quit();	
			}
		
	}
	
	public void clickReferencegotoUMCaseReferralSources() throws Exception{
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(ReferenceLink));
			driver.findElement(ReferenceLink).click();
			Log.info("log4j msg- clicked on Reference");
			System.out.println("clicked on Reference");
			Actions action=new Actions(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("UM Supporting Codes")));
			action.moveToElement(driver.findElement(By.linkText("UM Supporting Codes"))).build().perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("UM Case Referral Sources")));
			action.moveToElement(driver.findElement(By.linkText("UM Case Referral Sources"))).click().build().perform();
	
			}catch(Exception e){
				Log.info("log4j msg- Error in clicking reference - UM Case Referral Sources");
				System.out.println("Error in clicking reference - UM Case Referral Sources"); 	
				
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
				driver.quit();
			}
		
	}
	
	public void clickReferencegotoUMDegreesofClinicalUrgency() throws Exception{
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(ReferenceLink));
			driver.findElement(ReferenceLink).click();
			Log.info("log4j msg- clicked on Reference");
			System.out.println("clicked on Reference");
		Actions action=new Actions(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("UM Supporting Codes")));
			action.moveToElement(driver.findElement(By.linkText("UM Supporting Codes"))).build().perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("UM Degrees of Clinical Urgency")));
			action.moveToElement(driver.findElement(By.linkText("UM Degrees of Clinical Urgency"))).click().build().perform();
	
			}catch(Exception e){
				Log.info("log4j msg- Error in clicking reference- UM Degrees of Clinical Urgency"); 
				System.out.println("Error in clicking reference- UM Degrees of Clinical Urgency"); 	
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
				driver.quit();
			}
		
	}
	
	public void clickReferencegotoInitialResponseatIntakes() throws Exception{
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(ReferenceLink));
			driver.findElement(ReferenceLink).click();
			Log.info("log4j msg- clicked on Reference");
			System.out.println("clicked on Reference");
			Actions action=new Actions(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("UM Supporting Codes")));
			action.moveToElement(driver.findElement(By.linkText("UM Supporting Codes"))).build().perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Initial Response at Intakes")));
			action.moveToElement(driver.findElement(By.linkText("Initial Response at Intakes"))).click().build().perform();
	
			
			}catch(Exception e){
				Log.info("log4j msg- Error in clicking reference - Initial Response at Intakes"); 
				System.out.println("Error in clicking reference - Initial Response at Intakes"); 	
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
				driver.quit();
			}
		
	}
	
	public void clickReferencegotoUMProviderRoles() throws Exception{
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(ReferenceLink));
			driver.findElement(ReferenceLink).click();
			Log.info("log4j msg- clicked on Reference");
			System.out.println("clicked on Reference");
			Actions action=new Actions(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("UM Supporting Codes")));
			action.moveToElement(driver.findElement(By.linkText("UM Supporting Codes"))).build().perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("UM Provider Roles")));
			action.moveToElement(driver.findElement(By.linkText("UM Provider Roles"))).click().build().perform();
	
			}catch(Exception e){
				Log.info("log4j msg- Error in clicking reference - UM Provider Roles");
				System.out.println("Error in clicking reference - UM Provider Roles"); 	
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
driver.quit();
			}
		
	}
	public void clickReferencegotoInpatientWardsUnits() throws Exception{
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(ReferenceLink));
			driver.findElement(ReferenceLink).click();
			Log.info("log4j msg- clicked on Reference");
			System.out.println("clicked on Reference");
			Actions action=new Actions(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("UM Supporting Codes")));
			action.moveToElement(driver.findElement(By.linkText("UM Supporting Codes"))).build().perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Inpatient Wards/Units")));
			action.moveToElement(driver.findElement(By.linkText("Inpatient Wards/Units"))).click().build().perform();
	
			}catch(Exception e){
				Log.info("log4j msg- Error in clicking reference - Inpatient Wards/Units"); 
				System.out.println("Error in clicking reference - Inpatient Wards/Units"); 
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
				driver.quit();
			}
		
	}
	
	public void clickReferencegotoTreatmentFollowupActions() throws Exception{
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(ReferenceLink));
			driver.findElement(ReferenceLink).click();
			Log.info("log4j msg- clicked on Reference");
			System.out.println("clicked on Reference");

			Actions action=new Actions(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("UM Supporting Codes")));
			action.moveToElement(driver.findElement(By.linkText("UM Supporting Codes"))).build().perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Treatment Followup Actions")));
			action.moveToElement(driver.findElement(By.linkText("Treatment Followup Actions"))).click().build().perform();
	
			}catch(Exception e){
				Log.info("log4j msg- Error in clicking reference- Treatment Followup Actions"); 
				System.out.println("Error in clicking reference- Treatment Followup Actions"); 	
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
			driver.quit();	
			}
		
	}
	

	
	public void clickReferencegotoPlaceofServiceTypes() throws Exception{
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(ReferenceLink));
			driver.findElement(ReferenceLink).click();
			Log.info("log4j msg- clicked on Reference");
			System.out.println("clicked on Reference");
		
			Actions action=new Actions(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Claims Processing Supporting Codes")));
			action.moveToElement(driver.findElement(By.linkText("Claims Processing Supporting Codes"))).build().perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Place of Service Types")));
			action.moveToElement(driver.findElement(By.linkText("Place of Service Types"))).click().build().perform();
	
			}catch(Exception e){
				Log.info("log4j msg- Error in clicking reference - Service Types"); 
				System.out.println("Error in clicking reference - Service Types"); 	
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
driver.quit();
			}
		
	}
	
	public void clickReferencegotoDispositionCodes() throws Exception{
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(ReferenceLink));
			driver.findElement(ReferenceLink).click();
			Log.info("log4j msg- clicked on Reference");
			System.out.println("clicked on Reference");
			Actions action=new Actions(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Claims Processing Supporting Codes")));
			action.moveToElement(driver.findElement(By.linkText("Claims Processing Supporting Codes"))).build().perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Disposition Codes")));
			action.moveToElement(driver.findElement(By.linkText("Disposition Codes"))).click().build().perform();
	
			}catch(Exception e){
				Log.info("log4j msg- Error in clicking reference - Disposition Codes"); 
				System.out.println("Error in clicking reference - Disposition Codes"); 
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
				driver.quit();
			}
		
	}
	
	
	
	
	
	
	
	
	public void clickReferencegotoAdjustmentTypes() throws Exception{
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(ReferenceLink));
			driver.findElement(ReferenceLink).click();
			Log.info("log4j msg- clicked on Reference");
			System.out.println("clicked on Reference");
			Actions action=new Actions(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Claims Processing Supporting Codes")));
			action.moveToElement(driver.findElement(By.linkText("Claims Processing Supporting Codes"))).build().perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Adjustment Types")));
			action.moveToElement(driver.findElement(By.linkText("Adjustment Types"))).click().build().perform();
	
			}catch(Exception e){
				Log.info("log4j msg- Error in clicking reference-Adjustment Types ");
				System.out.println("Error in clicking reference-Adjustment Types "); 	
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
				driver.quit();
			}
		
	}
	
	public void clickSetup() throws Exception{
		try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(SetupLink));
			driver.findElement(SetupLink).click();
			Log.info("log4j msg- clicked on Setup");
			System.out.println("clicked on Setup");
		}catch(Exception e) {
			Log.info("log4j msg- Error in clicking Setup  \n"); 
			System.out.println("Error in clicking Setup \n"); 	}
	}
		

	
}



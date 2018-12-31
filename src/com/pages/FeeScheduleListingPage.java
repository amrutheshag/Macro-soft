package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BrowserUtils;
import utility.Log;

public class FeeScheduleListingPage {

WebDriver driver;
WebDriverWait wait ;

By FeeScheduleCodeBeginsInput = By.xpath("//input[@data-ng-model='filterOptions.schedule']");

By FeeScheduleNameBeginsInput = By.xpath("//input[@data-ng-model='filterOptions.name']");

By FeeScheduleSearchButton = By.xpath("//button[text()='Search']");

By FeeScheduleCodeAddInput = By.xpath("//input[@data-ng-model='schedule.schedule']");

By FeeScheduleNameAddInput = By.xpath("//input[@data-ng-model='schedule.name']");

By AddLink = By.linkText("Add");

By AddLinkInComm= By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/img[1]");

By SaveLink = By.linkText("Save");

By ExitLink = By.linkText("Exit");

By DeleteLink = By.linkText("Delete");

By CommLink = By.linkText("Commun.");

By EditLink = By.linkText("Edit");

By CopyLink = By.linkText("Copy");

By ValidateLink = By.linkText("Validate");

By FeeScheduleNotes = By.xpath("//textarea[@data-ng-model='schedule.notes']");

By ValidateSaveOKButton= By.xpath("//button[text()='OK']");

By ConfirmDeleteYesButton = By.xpath("//button[text()='Yes']");

By ReturnSelection= By.linkText("ReturnSelection");

By AddCommSubjectInput = By.id("txtSubject");

By AddCommType = By.id("ddlCaseType");

By AddCommFollowupDateInput = By.id("txtFollowup");

By AddCommPriority = By.id("ddlCasePriority");
		
By AddCommAddDetailsButton = By.xpath("//button[@data-ng-click='addChildRecord()']");
	
By AddCommNoteType = By.id("ddlNoteType");

By AddCommMedium = By.id("ddlMedium");

By AddCommDetails = By.id("txtNotes");	

By AddCommHideButton = By.xpath("//button[@data-ng-click='closeMe()']");

By ServiceRateAndRulesButton= By.xpath("//button[text()='Service Rate & Rules']");

By AddlinkInFeeScheduleServiceRuleListing = By.xpath("id('modalContentScheduleService')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/div[1]/ul[@class='ng-scope']/li[2]/a[@id='add']/span[1]");

By ServiceModifierInputbox = By.xpath("//input[@data-ng-model='scheduleService.servcode']");

By ClaimTypeButton =By.xpath("//button[@data-ng-click='openClaimFilter()']");

By ServiceTypeButton= By.xpath("//button[@data-ng-click='openServiceFilter()']");

By AddLinkInFileQueryTerm = By.xpath("id('modalContentQuery')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[@class='active']/span[1]");

By QueryNameInput = By.xpath("//input[@data-ng-model='query.name']");

By AddQueryButton = By.xpath("//button[@ng-click='addTerm()']");

By RequirementSelect= By.xpath("//select[@data-ng-model='queryTerm.conjun']");	

By FieldSelect = By.xpath("//select[@data-ng-change='onQueryTermFieldChanged()']");

By RelateSelect= By.xpath("//select[@data-ng-change='onOpertaorChanged()']");

By ToValues = By.xpath("//textarea[@id='data']");

By IgnoreCaseCheckbox = By.xpath("//input[@data-ng-model='queryTerm.ignorecase']");

By ReturnSelectionInAddQuery = By.xpath("id('modalContentQuery')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[@class='ng-scope']/a[1]/span[1]");

By SaveLinkInAddQuery= By.xpath("id('modalContentQuery')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[2]/li[2]/a[1]/span[1]");

	public FeeScheduleListingPage(WebDriver driver){
		this.driver= driver;
		this.wait= new WebDriverWait(driver, 20);
	}
	

	public int searchFeeScheduleListing( String feeScheduleCode, String feeScheduleName) throws Exception{
			try{
		//enter  InsurerPayer code
		wait.until(ExpectedConditions.visibilityOfElementLocated(FeeScheduleCodeBeginsInput));
		driver.findElement(FeeScheduleCodeBeginsInput).clear();
		driver.findElement(FeeScheduleCodeBeginsInput).sendKeys(feeScheduleCode);
		System.out.println("entered fee schedule code");
		Log.info("log4j msg- entered fee schedule code");
	
	
		//enter  InsurerPayer name
		wait.until(ExpectedConditions.visibilityOfElementLocated(FeeScheduleNameBeginsInput));
		driver.findElement(FeeScheduleNameBeginsInput).clear();
		driver.findElement(FeeScheduleNameBeginsInput).sendKeys(feeScheduleName);
		System.out.println("entered fee schedule name");
		Log.info("log4j msg- entered fee schedule  name");
		
		//click search
		wait.until(ExpectedConditions.visibilityOfElementLocated(FeeScheduleSearchButton));
		driver.findElement(FeeScheduleSearchButton).click();
		System.out.println("clicked Search");
		Log.info("log4j msg- clicked Search");
				
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+feeScheduleCode+"']")));
		WebElement e = driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+feeScheduleCode+"']"));
		e.click();
		System.out.println("Found fee schedule");
		Log.info("log4j msg- Found fee schedule");
	
		return 1;
		}
		
	catch(Exception e){System.out.println(" Fee schedule not found"); Log.info("log4j msg-Fee schedule not found"); return 0;}
		
	}
	

	public void addFeeSchedule( String feeScheduleCode, String feeScheduleName) throws Exception{
		try{
		int i= searchFeeScheduleListing( feeScheduleCode, feeScheduleName);
		
		if (i==0){
			System.out.println("Fee Schedule not found, Continue with Add");
			Log.info("log4j msg- FeeSchedule not found, Continue with Add");
		
			//click add
			wait.until(ExpectedConditions.visibilityOfElementLocated(AddLink));
			driver.findElement(AddLink).click();
			Thread.sleep(1000);
			System.out.println("clicked add");
			Log.info("log4j msg- clicked add");
			
			
			
			//enter code
			wait.until(ExpectedConditions.visibilityOfElementLocated(FeeScheduleCodeAddInput));
			driver.findElement(FeeScheduleCodeAddInput).sendKeys(feeScheduleCode);
			Thread.sleep(1000);
			System.out.println("Entered code");
			Log.info("log4j msg- Entered code");
			
			
			//enter name
			wait.until(ExpectedConditions.visibilityOfElementLocated(FeeScheduleNameAddInput));
			driver.findElement(FeeScheduleNameAddInput).sendKeys(feeScheduleName);
			Thread.sleep(1000);
			System.out.println("Entered name");
			Log.info("log4j msg- Entered name");
		
			
			//click validate
		
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(ValidateLink));
			driver.findElement(ValidateLink).click();
			System.out.println("clicked validate");
			Log.info("log4j msg- clicked validate");
			Thread.sleep(1000);
			//click ok
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(ValidateSaveOKButton));
			driver.findElement(ValidateSaveOKButton).click();
			System.out.println("clicked validate ok to save button");
			Log.info("log4j msg- clicked validate ok to save button");
			Thread.sleep(1000);
			
			//click save
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(SaveLink));
			driver.findElement(SaveLink).click();
			System.out.println("clicked save ");
			Log.info("log4j msg- clicked  save ");
			Thread.sleep(1000);
			
			
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
			driver.quit();
			
			}
		else { System.out.println("Fee Schedule Already present"); Log.info("log4j msg - FeeSchedule Already present"); 
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
		driver.quit(); }
		
		}catch (Exception e)
		{e.printStackTrace();System.out.println("Error in Adding fee schedule ");
		Log.info("log4j msg- Error in Adding fee schedule "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
		driver.quit();
		}
			
		}

	
	public void addClaimQueryFeeSchedules(String code, String name, String serviceModifier, String claimQueryName, String serviceQueryName, String claimRequired, String claimField, String claimRelates, String claimToValues, String claimIgnoreCase, String serviceRequired, String serviceField, String serviceRelates, String serviceToValues, String serviceIgnoreCase) throws Exception
	{
		try{
		int i= searchFeeScheduleListing( code, name);
		
		if (i==1){
			System.out.println("Fee Schedule found, Continue with add Query");
			Log.info("log4j msg- FeeSchedule found, Continue with add Query");
		
		
			//click service rate and rules button
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceRateAndRulesButton));
			driver.findElement(ServiceRateAndRulesButton).click();
			Thread.sleep(1000);
			System.out.println("clicked service rates and rules button");
			Log.info("log4j msg- clicked service rates and rules button");
			
			
			
			//click add
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(AddlinkInFeeScheduleServiceRuleListing));
			driver.findElement(AddlinkInFeeScheduleServiceRuleListing).click();
			Thread.sleep(1000);
			System.out.println("clicked add");
			Log.info("log4j msg- clicked add");
			
			
			
			//enter service modifier
			wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceModifierInputbox));
			driver.findElement(ServiceModifierInputbox).sendKeys(serviceModifier);
			Thread.sleep(1000);
			System.out.println("entered service modifier");
			Log.info("log4j msg- entered service modifier");
			
			//click claim type button
			wait.until(ExpectedConditions.visibilityOfElementLocated(ClaimTypeButton));
			driver.findElement(ClaimTypeButton).click();
			Thread.sleep(1000);
			System.out.println("clicked claim type");
			Log.info("log4j msg- clicked claim type");
			
			Thread.sleep(1000);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(AddLinkInFileQueryTerm));
			driver.findElement(AddLinkInFileQueryTerm).click();
			Thread.sleep(1000);
			System.out.println("clicked AddLinkInFileQueryTerm");
			Log.info("log4j msg- clicked AddLinkInFileQueryTerm");

			//enter query name
			wait.until(ExpectedConditions.visibilityOfElementLocated(QueryNameInput));
			driver.findElement(QueryNameInput).sendKeys(claimQueryName);
			Thread.sleep(1000);
			System.out.println("entered claim query name");
			Log.info("log4j msg- entered claim query name");
			
			
			//click add query button
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(AddQueryButton));
			driver.findElement(AddQueryButton).click();
			Thread.sleep(1000);
			System.out.println("clicked add query");
			Log.info("log4j msg- clicked add query");
			

			//select required 
			wait.until(ExpectedConditions.visibilityOfElementLocated(RequirementSelect));
			Select reqSelect = new Select(driver.findElement(RequirementSelect));
			reqSelect.selectByVisibleText(claimRequired);
			Thread.sleep(1000);
			System.out.println("selected required");
			Log.info("log4j msg- selected required");
					

			//FieldSelect
			wait.until(ExpectedConditions.visibilityOfElementLocated(FieldSelect));
			Select fieldSelect = new Select(driver.findElement(FieldSelect));
			fieldSelect.selectByVisibleText(claimField);
			Thread.sleep(1000);
			System.out.println("selected field");
			Log.info("log4j msg- selected field");
					

			//RelateSelect
			wait.until(ExpectedConditions.visibilityOfElementLocated(RelateSelect));
			Select relateSelect = new Select(driver.findElement(RelateSelect));
			relateSelect.selectByVisibleText(claimRelates);
			Thread.sleep(1000);
			System.out.println("selected relates");
			Log.info("log4j msg- selected relates");
			
			//ToValues
			wait.until(ExpectedConditions.visibilityOfElementLocated(ToValues));
			driver.findElement(ToValues).sendKeys(claimToValues);
			Thread.sleep(1000);
			System.out.println("entered to values");
			Log.info("log4j msg- entered to values");
			
			
			//IgnoreCaseCheckbox
			
			if (claimIgnoreCase.equalsIgnoreCase("yes")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(IgnoreCaseCheckbox));
			driver.findElement(IgnoreCaseCheckbox).click();
			Thread.sleep(1000);
			System.out.println("clicked check box");
			Log.info("log4j msg- clicked check box");
			}
			 
			//pageup
			 
			driver.findElement(QueryNameInput).sendKeys(Keys.PAGE_UP);
					 
					 
			//savelink
			wait.until(ExpectedConditions.visibilityOfElementLocated(SaveLink));
			driver.findElement(SaveLinkInAddQuery).click();
			Thread.sleep(1000);
			System.out.println("clicked save");
			Log.info("log4j msg- clicked save");
			 
			//return selection
			 wait.until(ExpectedConditions.visibilityOfElementLocated(ReturnSelectionInAddQuery));
			driver.findElement(ReturnSelectionInAddQuery).click();
			Thread.sleep(1000);
			System.out.println("clicked return selection");
			Log.info("log4j msg- clicked return selection");
				
			//save link
					
			wait.until(ExpectedConditions.visibilityOfElementLocated(SaveLink));
			driver.findElement(SaveLink).click();
			Thread.sleep(1000);
			System.out.println("clicked save");
			Log.info("log4j msg- clicked save");
					
					
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
			driver.quit();
			
			
		}
		
			else { System.out.println("Fee Schedule Not present"); Log.info("log4j msg - Fee Schedule Not present"); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
			driver.quit();
			}
		}
		catch (Exception e){e.printStackTrace();System.out.println("Error in adding claim query in fee schedule ");
		Log.info("log4j msg- Error in adding claim query in fee schedule "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
		driver.quit();
		}
			
		}
		
		
		
		
		

	public void addServiceQueryFeeSchedules(String code, String name, String serviceModifier, String claimQueryName, String serviceQueryName, String claimRequired, String claimField, String claimRelates, String claimToValues, String claimIgnoreCase, String serviceRequired, String serviceField, String serviceRelates, String serviceToValues, String serviceIgnoreCase) throws Exception
	{
		try{
		int i= searchFeeScheduleListing( code, name);
		
		if (i==1){
			System.out.println("Fee Schedule found, Continue with add Query");
			Log.info("log4j msg- FeeSchedule found, Continue with add Query");
		
		
			//click service rate and rules button
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceRateAndRulesButton));
			driver.findElement(ServiceRateAndRulesButton).click();
			Thread.sleep(1000);
			System.out.println("clicked service rates and rules button");
			Log.info("log4j msg- clicked service rates and rules button");
			
			
			
			//click add
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(AddlinkInFeeScheduleServiceRuleListing));
			driver.findElement(AddlinkInFeeScheduleServiceRuleListing).click();
			Thread.sleep(1000);
			System.out.println("clicked add");
			Log.info("log4j msg- clicked add");
			
			
			
			//enter service modifier
			wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceModifierInputbox));
			driver.findElement(ServiceModifierInputbox).sendKeys(serviceModifier);
			Thread.sleep(1000);
			System.out.println("entered service modifier");
			Log.info("log4j msg- entered service modifier");
			
				
					
					//service type add query
					
					wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceTypeButton));
					driver.findElement(ServiceTypeButton).click();
					Thread.sleep(1000);
					System.out.println("clicked Service type");
					Log.info("log4j msg- clicked service type");
					
					Thread.sleep(1000);
					
					wait.until(ExpectedConditions.visibilityOfElementLocated(AddLinkInFileQueryTerm));
					driver.findElement(AddLinkInFileQueryTerm).click();
					Thread.sleep(1000);
					System.out.println("clicked AddLinkInFileQueryTerm");
					Log.info("log4j msg- clicked AddLinkInFileQueryTerm");
					
					
					
					//enter query name
					wait.until(ExpectedConditions.visibilityOfElementLocated(QueryNameInput));
					driver.findElement(QueryNameInput).sendKeys(serviceQueryName);
					Thread.sleep(1000);
					System.out.println("entered service query name");
					Log.info("log4j msg- entered service query name");
					
					
					//click add query button
					
					wait.until(ExpectedConditions.visibilityOfElementLocated(AddQueryButton));
					driver.findElement(AddQueryButton).click();
					Thread.sleep(1000);
					System.out.println("clicked add query");
					Log.info("log4j msg- clicked add query");
					

					//select required 
					wait.until(ExpectedConditions.visibilityOfElementLocated(RequirementSelect));
					Select reqSelect1 = new Select(driver.findElement(RequirementSelect));
					reqSelect1.selectByVisibleText(serviceRequired);
					Thread.sleep(1000);
					System.out.println("selected required");
					Log.info("log4j msg- selected required");
							

					//FieldSelect
						System.out.println(serviceField);
					
					wait.until(ExpectedConditions.visibilityOfElementLocated(FieldSelect));
					Select fieldSelect1 = new Select(driver.findElement(FieldSelect));
					fieldSelect1.selectByVisibleText(serviceField);
					Thread.sleep(1000);
					System.out.println("selected field");
					Log.info("log4j msg- selected field");
							

					//RelateSelect
					wait.until(ExpectedConditions.visibilityOfElementLocated(RelateSelect));
					Select relateSelect1 = new Select(driver.findElement(RelateSelect));
					relateSelect1.selectByVisibleText(serviceRelates);
					Thread.sleep(1000);
					System.out.println("selected relates");
					Log.info("log4j msg- selected relates");
					
					//ToValues
					wait.until(ExpectedConditions.visibilityOfElementLocated(ToValues));
					driver.findElement(ToValues).sendKeys(serviceToValues);
					Thread.sleep(1000);
					System.out.println("entered to values");
					Log.info("log4j msg- entered to values");
					
					
					//IgnoreCaseCheckbox
					
					 if (serviceIgnoreCase.equalsIgnoreCase("yes")) {
					wait.until(ExpectedConditions.visibilityOfElementLocated(IgnoreCaseCheckbox));
					driver.findElement(IgnoreCaseCheckbox).click();
					Thread.sleep(1000);
					System.out.println("clicked check box");
					Log.info("log4j msg- clicked check box");
					 }
					 
					 //pageup
					 
					 driver.findElement(QueryNameInput).sendKeys(Keys.PAGE_UP);
							 
							 
					//savelink
					 wait.until(ExpectedConditions.visibilityOfElementLocated(SaveLink));
						driver.findElement(SaveLinkInAddQuery).click();
						Thread.sleep(1000);
						System.out.println("clicked save");
						Log.info("log4j msg- clicked save");
					 
					//return selection
					wait.until(ExpectedConditions.visibilityOfElementLocated(ReturnSelectionInAddQuery));
					driver.findElement(ReturnSelectionInAddQuery).click();
					Thread.sleep(1000);
					System.out.println("clicked return selection");
					Log.info("log4j msg- clicked return selection");
						
					//save link
					
					wait.until(ExpectedConditions.visibilityOfElementLocated(SaveLink));
					driver.findElement(SaveLink).click();
					Thread.sleep(1000);
					System.out.println("clicked save");
					Log.info("log4j msg- clicked save");
							
							
					BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
					driver.quit();
			
			
		}
		
			else { System.out.println("Fee Schedule Not present"); Log.info("log4j msg - Fee Schedule Not present"); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
			driver.quit();
			}
		}
		catch (Exception e){e.printStackTrace();System.out.println("Error in adding service query in fee schedule ");
		Log.info("log4j msg- Error in adding service query in fee schedule "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
		driver.quit();
		}
			
		}
		
		
	
	
public void copyFeeSchedule( String feeScheduleCode, String feeScheduleName, String newCode, String newName) throws Exception{
	
	try{
	int i= searchFeeScheduleListing( feeScheduleCode, feeScheduleName);
	
	if (i==1){
		System.out.println("Fee Schedule found, Continue with Copy");
		Log.info("log4j msg- FeeSchedule found, Continue with Copy");
	
		//click copy
		wait.until(ExpectedConditions.visibilityOfElementLocated(CopyLink));
		driver.findElement(CopyLink).click();
		Thread.sleep(1000);
		System.out.println("clicked copy");
		Log.info("log4j msg- clicked copy");
		
		
		//enter code
		wait.until(ExpectedConditions.visibilityOfElementLocated(FeeScheduleCodeAddInput));
		driver.findElement(FeeScheduleCodeAddInput).clear();
		driver.findElement(FeeScheduleCodeAddInput).sendKeys(newCode);
		Thread.sleep(1000);
		System.out.println("Entered new code");
		Log.info("log4j msg- Entered new code");
		
		
		//enter name
		wait.until(ExpectedConditions.visibilityOfElementLocated(FeeScheduleNameAddInput));
		driver.findElement(FeeScheduleNameAddInput).clear();
		driver.findElement(FeeScheduleNameAddInput).sendKeys(newName);
		Thread.sleep(1000);
		System.out.println("Entered new name");
		Log.info("log4j msg- Entered new  name");
	
		
		//click validate
	
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(ValidateLink));
		driver.findElement(ValidateLink).click();
		System.out.println("clicked validate");
		Log.info("log4j msg- clicked validate");
		
		//click ok
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(ValidateSaveOKButton));
		driver.findElement(ValidateSaveOKButton).click();
		System.out.println("clicked validate ok to save button");
		Log.info("log4j msg- clicked validate ok to save button");
		
		
		//click save
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(SaveLink));
		driver.findElement(SaveLink).click();
		System.out.println("clicked save ");
		Log.info("log4j msg- clicked  save ");
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
		
		}
	else { System.out.println("Not present"); Log.info("log4j msg - Not present");}
	}
	catch (Exception e){e.printStackTrace();System.out.println("Error in Copying fee schedule ");
	Log.info("log4j msg- Error in Copying fee schedule "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}
		
	}


public void editFeeSchedule( String feeScheduleCode, String feeScheduleName, String editField) throws Exception{
	
	try{
	int i= searchFeeScheduleListing( feeScheduleCode, feeScheduleName);
	
	if (i==1){
		System.out.println("Fee Schedule found, Continue with Edit");
		Log.info("log4j msg- FeeSchedule found, Continue with Edit");
	
		//click edit
		wait.until(ExpectedConditions.visibilityOfElementLocated(EditLink));
		driver.findElement(EditLink).click();
		Thread.sleep(1000);
		System.out.println("clicked Edit");
		Log.info("log4j msg- clicked Edit");
		
		
		//enter notes
		wait.until(ExpectedConditions.visibilityOfElementLocated(FeeScheduleNotes));
		driver.findElement(FeeScheduleNotes).clear();
		driver.findElement(FeeScheduleNotes).sendKeys(editField);
		Thread.sleep(1000);
		System.out.println("Entered notes");
		Log.info("log4j msg- Entered notes");
		
		
		
		
		//click validate
		wait.until(ExpectedConditions.visibilityOfElementLocated(ValidateLink));
		driver.findElement(ValidateLink).click();
		System.out.println("clicked validate");
		Log.info("log4j msg- clicked validate");
		
		//click ok
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(ValidateSaveOKButton));
		driver.findElement(ValidateSaveOKButton).click();
		System.out.println("clicked validate ok to save button");
		Log.info("log4j msg- clicked validate ok to save button");
		
		
		//click save
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(SaveLink));
		driver.findElement(SaveLink).click();
		System.out.println("clicked save ");
		Log.info("log4j msg- clicked  save ");
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
		
		}
	else { System.out.println("Fee Schedule Not present"); Log.info("log4j msg - Fee Schedule Not present"); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}
	}
	catch (Exception e){e.printStackTrace();System.out.println("Error in Editing fee schedule ");
	Log.info("log4j msg- Error in Editing fee schedule "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}
		
	}


public void addCommFeeSchedule( String feeScheduleCode, String feeScheduleName, String subject, String type, String followupDate, String priority, String notetype, String medium, String details) throws Exception{
	try{
	int i= searchFeeScheduleListing( feeScheduleCode, feeScheduleName);
	
	if (i==1){
		System.out.println("Found fee schedule, continue with commun.");
		Log.info("log4j msg- Found fee schedule, continue with commun.");
	
		//click comm
		wait.until(ExpectedConditions.visibilityOfElementLocated(CommLink));
		driver.findElement(CommLink).click();
		System.out.println("clicked commun.");
		Log.info("log4j msg- clicked commun.");	
		
		
		//click add comm
		wait.until(ExpectedConditions.visibilityOfElementLocated(AddLinkInComm));
		Thread.sleep(1000);
		driver.findElement(AddLinkInComm).click();
		System.out.println("clicked  add  in commun.");
		Log.info("log4j msg- clicked add in commun.");	
		
		//enter  comm subject
		wait.until(ExpectedConditions.visibilityOfElementLocated(AddCommSubjectInput));
		driver.findElement(AddCommSubjectInput).sendKeys(subject);
		System.out.println("entered subject.");
		Log.info("log4j msg- clicked add in commun.");	
		
		//enter comm type
		wait.until(ExpectedConditions.visibilityOfElementLocated(AddCommType));
		Select commType = new Select(driver.findElement(AddCommType));
		commType.selectByVisibleText(type);
		System.out.println("selected comm type.");
		Log.info("log4j msg- selected comm type.");	
		
		
		//enter comm followup date
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(AddCommFollowupDateInput));
		driver.findElement(AddCommFollowupDateInput).sendKeys(followupDate);
		System.out.println("entered followup date");
		Log.info("log4j msg- entered followup date");	
		
		//enter comm priority
		wait.until(ExpectedConditions.visibilityOfElementLocated(AddCommPriority));
		Select priorityLevel = new Select(driver.findElement(AddCommPriority));
		priorityLevel.selectByVisibleText(priority);
		System.out.println("selected priority");
		Log.info("log4j msg- selected priority");	
		
		//page down
		wait.until(ExpectedConditions.visibilityOfElementLocated(AddCommFollowupDateInput));
		driver.findElement(AddCommFollowupDateInput).sendKeys(Keys.PAGE_DOWN);
		System.out.println("page down");
		Log.info("log4j msg- page down");	
		
		
		//click comm details add
		wait.until(ExpectedConditions.visibilityOfElementLocated(AddCommAddDetailsButton));
		driver.findElement(AddCommAddDetailsButton).click();
		System.out.println("clicked add button");
		Log.info("log4j msg- clicked add button");		
		
		//enter comm details note type
		wait.until(ExpectedConditions.visibilityOfElementLocated(AddCommNoteType));
		Select detailsNotetype = new Select(driver.findElement(AddCommNoteType));
		detailsNotetype.selectByVisibleText(notetype);
		System.out.println("selected note type");
		Log.info("log4j msg- selected note type");	
		
		//enter comm details medium
		wait.until(ExpectedConditions.visibilityOfElementLocated(AddCommMedium));
		Select detailsMedium = new Select(driver.findElement(AddCommMedium));
		detailsMedium.selectByVisibleText(medium);
		System.out.println("selected medium");
		Log.info("log4j msg- selected medium");	
		
		//enter comm details
		wait.until(ExpectedConditions.visibilityOfElementLocated(AddCommDetails));
		driver.findElement(AddCommDetails).sendKeys(details);
		System.out.println("entered details");
		Log.info("log4j msg- entered details");		
		
		//click comm details hide
		wait.until(ExpectedConditions.visibilityOfElementLocated(AddCommHideButton));
		driver.findElement(AddCommHideButton).click();
		System.out.println("clicked hide");
		Log.info("log4j msg- clicked hide");		
		
		//click comm validate
		wait.until(ExpectedConditions.visibilityOfElementLocated(ValidateLink));
		driver.findElement(ValidateLink).click();
		System.out.println("clicked validate");
		Log.info("log4j msg- clicked validate");		
		
		//click ok
		wait.until(ExpectedConditions.visibilityOfElementLocated(ValidateSaveOKButton));
		driver.findElement(ValidateSaveOKButton).click();
		System.out.println("clicked ok to save");
		Log.info("log4j msg- clicked ok to save");		
		
		
		
		//click comm save
		wait.until(ExpectedConditions.visibilityOfElementLocated(SaveLink));
		driver.findElement(SaveLink).click();
		System.out.println("clicked save");
		Log.info("log4j msg- clicked save");	
	
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit();
	
	} else{
		System.out.println("cannot find fee schedule");
		Log.info("log4j msg- cannot find fee schedule");
		wait.until(ExpectedConditions.visibilityOfElementLocated(ExitLink));
		driver.findElement(ExitLink).click();
		System.out.println("clicked Exit");
		Log.info("log4j msg- clicked Exit");
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit();
	} 
	}catch(Exception e){ e.printStackTrace(); System.out.println("error in Fee Schedule add comm");
	Log.info("log4j msg- error in Fee Schedule add comm"); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
	driver.quit();
	}
}

public void exitFeeSchedule( String feeScheduleCode, String feeScheduleName) throws Exception{
	try{
	int i= searchFeeScheduleListing( feeScheduleCode, feeScheduleName);
	
	if (i==1){
		System.out.println("Found fee schedule, continue with exit");
		Log.info("log4j msg-Found fee schedule, continue with exit");
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(ExitLink));
	driver.findElement(ExitLink).click();
	System.out.println("clicked Exit");
	Log.info("log4j msg- clicked Exit");
	BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
	driver.quit();
	
	} else{
		System.out.println("cannot find fee schedule");
		Log.info("log4j msg- cannot find fee schedule");
		wait.until(ExpectedConditions.visibilityOfElementLocated(ExitLink));
		driver.findElement(ExitLink).click();
		System.out.println("clicked Exit");
		Log.info("log4j msg- clicked Exit");
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit();
	} }catch(Exception e){ System.out.println("error in Fee Schedule exit");
	Log.info("log4j msg- error in Fee Schedule exit"); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
	driver.quit();}
}	

public void deleteFeeSchedule( String feeScheduleCode, String feeScheduleName) throws Exception{
	try{
	int i= searchFeeScheduleListing( feeScheduleCode, feeScheduleName);
	
	if (i==1){
		System.out.println("Found fee schedule, continue with delete");
		Log.info("log4j msg- Found fee schedule, continue with delete");
	//delete
	wait.until(ExpectedConditions.visibilityOfElementLocated(DeleteLink));
	driver.findElement(DeleteLink).click();
	System.out.println("clicked Delete");
	Log.info("log4j msg- clicked Delete");
	
	
	//confirm delete
	wait.until(ExpectedConditions.visibilityOfElementLocated(ConfirmDeleteYesButton));
	driver.findElement(ConfirmDeleteYesButton).click();
	System.out.println("clicked ok to confirm Delete");
	Log.info("log4j msg- clicked ok to confirm Delete");
	BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
	driver.quit();
	
	} else{
		System.out.println("cannot find fee schedule");
		Log.info("log4j msg- cannot find fee schedule");
		wait.until(ExpectedConditions.visibilityOfElementLocated(ExitLink));
		driver.findElement(ExitLink).click();
		System.out.println("clicked Exit");
		Log.info("log4j msg- clicked Exit");
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit();
	}	}catch(Exception e){ System.out.println("error in Fee Schedule delete");
	Log.info("log4j msg- error in Fee Schedule delete"); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
	driver.quit();}
}

}




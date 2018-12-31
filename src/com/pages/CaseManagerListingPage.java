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

public class CaseManagerListingPage {
	
	WebDriver driver;
	WebDriverWait wait ;
	
	By CaseManagerCodeBeginsInput = By.xpath("//input[@data-ng-model='filterOptions.casemgr']");

	By CaseManagerNameBeginsInput = By.id("txtSearchCode");

	By CaseManagerSearchButton = By.xpath("//button[text()='Search']");

	By CaseManagerCodeAddInput = By.xpath("//input[@data-ng-model='caseManager.casemgr']");

	By CaseManagerNameAddInput = By.xpath("//input[@data-ng-model='caseManager.name']");

	By CaseManagerStartDateInput= By.id("hireddate");
			
	By CaseManagerEndDateInput=By.id("terminatedate");
			
	By CaseManagerActiveCheckbox= By.xpath("//input[@data-ng-model='caseManager.active']");

	By AddLink = By.linkText("Add");
	
	By AddLinkInComm= By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/img[1]");

	By SaveLink = By.linkText("Save");

	By ExitLink = By.linkText("Exit");

	By DeleteLink = By.linkText("Delete");

	By CommLink = By.linkText("Commun.");

	By EditLink = By.linkText("Edit");

	By CopyLink = By.linkText("Copy");

	By ValidateLink = By.linkText("Validate");

	By CaseManagerCity = By.xpath("//input[@data-ng-model='caseManager.city']");

	By ValidateSaveOKButton= By.xpath("//button[text()='OK']");

	By ConfirmDeleteYesButton = By.xpath("//button[text()='Yes']");

	By AddCommSubjectInput = By.id("txtSubject");

	By AddCommType = By.id("ddlCaseType");
			
	By AddCommFollowupDateInput = By.id("txtFollowup");

	By AddCommPriority = By.id("ddlCasePriority");
			
	By AddCommAddDetailsButton = By.xpath("//button[@data-ng-click='addChildRecord()']");
			
	By AddCommNoteType = By.id("ddlNoteType");
			
	By AddCommMedium = By.id("ddlMedium");
			
	By AddCommDetails = By.id("txtNotes");	
			
	By AddCommHideButton = By.xpath("//button[@data-ng-click='closeMe()']");
		
		public CaseManagerListingPage(WebDriver driver){
			this.driver= driver;
			this.wait= new WebDriverWait(driver, 40);
		}
		

		public int searchCaseManagerListing(String CaseManagerCode, String CaseManagerName) throws Exception{
	
			
			try{
			//enter  InsurerPayer code
			wait.until(ExpectedConditions.visibilityOfElementLocated(CaseManagerCodeBeginsInput));
			driver.findElement(CaseManagerCodeBeginsInput).clear();
			driver.findElement(CaseManagerCodeBeginsInput).sendKeys(CaseManagerCode);
			System.out.println("entered case manager code");
			Log.info("log4j msg- entered case manager code");
		
		
			//enter  InsurerPayer name
			wait.until(ExpectedConditions.visibilityOfElementLocated(CaseManagerNameBeginsInput));
			driver.findElement(CaseManagerNameBeginsInput).clear();
			driver.findElement(CaseManagerNameBeginsInput).sendKeys(CaseManagerName);
			System.out.println("entered case manager name");
			Log.info("log4j msg- entered case manager  name");
			
			//click search
			wait.until(ExpectedConditions.visibilityOfElementLocated(CaseManagerSearchButton));
			driver.findElement(CaseManagerSearchButton).click();
			System.out.println("clicked Search");
			Log.info("log4j msg- clicked Search");
					
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+CaseManagerCode+"']")));
			WebElement e = driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+CaseManagerCode+"']"));
			e.click();
			System.out.println("Found case manager");
			Log.info("log4j msg- Found case manager");
		
			return 1;
			}
			
		catch(Exception e){
			System.out.println("case manager not found"); 
			Log.info("log4j msg-case manager not found"); return 0;}
			
		}
		

		public void addCaseManager( String CaseManagerCode, String CaseManagerName, String startDate, String endDate, String active) throws Exception{
			try{
			int i= searchCaseManagerListing( CaseManagerCode, CaseManagerName);
			
			if (i==0){
				System.out.println("case manager not found, Continue with Add");
				Log.info("log4j msg- CaseManager not found, Continue with Add");
			
				//click add
				wait.until(ExpectedConditions.visibilityOfElementLocated(AddLink));
				driver.findElement(AddLink).click();
				Thread.sleep(1000);
				System.out.println("clicked add");
				Log.info("log4j msg- clicked add");
				
				
				
				//enter code
				wait.until(ExpectedConditions.visibilityOfElementLocated(CaseManagerCodeAddInput));
				driver.findElement(CaseManagerCodeAddInput).sendKeys(CaseManagerCode);
				Thread.sleep(1000);
				System.out.println("Entered code");
				Log.info("log4j msg- Entered code");
				
				
				//enter name
				wait.until(ExpectedConditions.visibilityOfElementLocated(CaseManagerNameAddInput));
				driver.findElement(CaseManagerNameAddInput).sendKeys(CaseManagerName);
				Thread.sleep(1000);
				System.out.println("Entered name");
				Log.info("log4j msg- Entered name");
				
				//enter start date
				wait.until(ExpectedConditions.visibilityOfElementLocated(CaseManagerStartDateInput));
				driver.findElement(CaseManagerStartDateInput).sendKeys(startDate);
				Thread.sleep(1000);
				System.out.println("Entered start date");
				Log.info("log4j msg- Entered start date");
				
				//enter end date
				wait.until(ExpectedConditions.visibilityOfElementLocated(CaseManagerEndDateInput));
				driver.findElement(CaseManagerEndDateInput).sendKeys(endDate);
				Thread.sleep(1000);
				System.out.println("Entered end date");
				Log.info("log4j msg- Entered end date");
				
				//enter current status- active ?
				if (active.equalsIgnoreCase("yes")){
					
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(CaseManagerActiveCheckbox));
				driver.findElement(CaseManagerActiveCheckbox).click();
				Thread.sleep(1000);
				System.out.println("clicked active");
				Log.info("log4j msg- clicked active");
				}
				else{
					System.out.println("not active");
					Log.info("log4j msg- not active");
				}
				
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
				
				
				
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit(); 
				}
			else { System.out.println("Already present"); Log.info("log4j msg - Already present");}
			}
			catch (Exception e){e.printStackTrace();System.out.println("Error in Adding case manager ");
			Log.info("log4j msg- Error in Adding case manager "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit(); 
		
			}
				
			}

	public void copyCaseManager( String CaseManagerCode, String CaseManagerName, String newCode, String newName) throws Exception{
		
		try{
		int i= searchCaseManagerListing( CaseManagerCode, CaseManagerName);
		
		if (i==1){
			System.out.println("case manager found, Continue with Copy");
			Log.info("log4j msg- CaseManager found, Continue with Copy");
		
			//click copy
			wait.until(ExpectedConditions.visibilityOfElementLocated(CopyLink));
			driver.findElement(CopyLink).click();
			Thread.sleep(1000);
			System.out.println("clicked copy");
			Log.info("log4j msg- clicked copy");
			
			
			//enter code
			wait.until(ExpectedConditions.visibilityOfElementLocated(CaseManagerCodeAddInput));
			driver.findElement(CaseManagerCodeAddInput).clear();
			driver.findElement(CaseManagerCodeAddInput).sendKeys(newCode);
			Thread.sleep(1000);
			System.out.println("Entered new code");
			Log.info("log4j msg- Entered new code");
			
			
			//enter name
			wait.until(ExpectedConditions.visibilityOfElementLocated(CaseManagerNameAddInput));
			driver.findElement(CaseManagerNameAddInput).clear();
			driver.findElement(CaseManagerNameAddInput).sendKeys(newName);
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
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit(); 
			
			}
		else { System.out.println("Not present"); Log.info("log4j msg - Not present");}
		}
		catch (Exception e){e.printStackTrace();System.out.println("Error in Copying case manager ");
		Log.info("log4j msg- Error in Copying case manager "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();}
			
		}


	public void editCaseManager( String CaseManagerCode, String CaseManagerName, String city) throws Exception{
		
		try{
		int i= searchCaseManagerListing( CaseManagerCode, CaseManagerName);
		
		if (i==1){
			System.out.println("case manager found, Continue with Edit");
			Log.info("log4j msg- CaseManager found, Continue with Edit");
		
			//click edit
			wait.until(ExpectedConditions.visibilityOfElementLocated(EditLink));
			driver.findElement(EditLink).click();
			Thread.sleep(1000);
			System.out.println("clicked Edit");
			Log.info("log4j msg- clicked Edit");
			
			
			//enter notes
			wait.until(ExpectedConditions.visibilityOfElementLocated(CaseManagerCity));
			driver.findElement(CaseManagerCity).clear();
			driver.findElement(CaseManagerCity).sendKeys(city);
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
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit(); 
			}
		else { System.out.println("Not present"); Log.info("log4j msg - Not present");}
		}
		catch (Exception e){e.printStackTrace();System.out.println("Error in Editing case manager ");
		Log.info("log4j msg- Error in Editing case manager "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit(); }
			
		}


	public void addCommCaseManager(String CaseManagerCode, String CaseManagerName, String subject, String type, String followupDate, String priority, String notetype, String medium, String details) throws Exception{
	
		try{
		int i= searchCaseManagerListing( CaseManagerCode, CaseManagerName);
		
		if (i==1){
			System.out.println("Found case manager, continue with commun.");
			Log.info("log4j msg- Found case manager, continue with commun.");
		
			//click comm
			wait.until(ExpectedConditions.visibilityOfElementLocated(CommLink));
			driver.findElement(CommLink).click();
			System.out.println("clicked commun.");
			Log.info("log4j msg- clicked commun.");	
			
			//click add comm
			wait.until(ExpectedConditions.visibilityOfElementLocated(AddLinkInComm));
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
			
			
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();
		
		
		} else{
			System.out.println("cannot find case manager");
			Log.info("log4j msg- cannot find case manager");
			wait.until(ExpectedConditions.visibilityOfElementLocated(ExitLink));
			driver.findElement(ExitLink).click();
			System.out.println("clicked Exit");
			Log.info("log4j msg- clicked Exit");
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();
			
		} 
		}catch(Exception e){ e.printStackTrace(); System.out.println("error in case manager add comm");
		Log.info("log4j msg- error in case manager add comm"); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();
	
		}
	}

	public void exitCaseManager( String CaseManagerCode, String CaseManagerName) throws Exception{
		try{
		int i= searchCaseManagerListing( CaseManagerCode, CaseManagerName);
		
		if (i==1){
			System.out.println("Found case manager");
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(ExitLink));
		driver.findElement(ExitLink).click();
		System.out.println("clicked Exit");
		Log.info("log4j msg- clicked Exit");
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();
		} else{
			System.out.println("cannot find case manager");
			Log.info("log4j msg- cannot find case manager");
			wait.until(ExpectedConditions.visibilityOfElementLocated(ExitLink));
			driver.findElement(ExitLink).click();
			System.out.println("clicked Exit");
			Log.info("log4j msg- clicked Exit");
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();
			
		} }catch(Exception e){ System.out.println("error in case manager exit");
		Log.info("log4j msg- error in case manager exit"); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();
	}
	}	

	public void deleteCaseManager( String CaseManagerCode, String CaseManagerName) throws Exception{
		try{
		int i= searchCaseManagerListing( CaseManagerCode, CaseManagerName);
		
		if (i==1){
			System.out.println("Found case manager");
		
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
		Thread.sleep(1000);
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();

		
		} else{
			System.out.println("cannot find case manager");
			Log.info("log4j msg- cannot find case manager");
			wait.until(ExpectedConditions.visibilityOfElementLocated(ExitLink));
			driver.findElement(ExitLink).click();
			System.out.println("clicked Exit");
			Log.info("log4j msg- clicked Exit");
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();
	
		}	}catch(Exception e){ System.out.println("error in case manager delete");
		Log.info("log4j msg- error in case manager delete"); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();
		}
	}

	}


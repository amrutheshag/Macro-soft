package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BrowserUtils;
import utility.Log;

public class MyOpenCasesForFollowUpListingPage {

	WebDriver driver;
	WebDriverWait wait ;
	
	By AddLink = By.linkText("Add");
	
	By EditLink = By.linkText("Edit");
	
	By CopyLink= By.linkText("Copy");
	
	By ExitLink= By.linkText("Exit");
	
	By DeleteLink= By.linkText("Delete");
	
	By ValidateLink = By.linkText("Validate");
	
	By ValidateSaveOKButton = By.xpath("//button[text()='OK']");
	
	By SaveLink = By.linkText("Save");
	
	By priority = By.xpath("//select[@id='ddlCasePriority']");
	
	By ConfirmYesButton = By.xpath("//button[text()='Yes']");
	
	By AddCommSubjectInput = By.id("txtSubject");

	By AddCommType = By.id("ddlCaseType");
				
	By AddCommFollowupDateInput = By.id("txtFollowup");

	By AddCommPriority = By.id("ddlCasePriority");
				
	By AddCommAddDetailsButton = By.xpath("//button[@data-ng-click='addChildRecord()']");
				
	By AddCommNoteType = By.id("ddlNoteType");
				
	By AddCommMedium = By.id("ddlMedium");
	
	By AddCommDetails = By.id("txtNotes");	
				
	By AddCommHideButton = By.xpath("//button[@data-ng-click='closeMe()']");


	
	
	public MyOpenCasesForFollowUpListingPage(WebDriver driver){
		this.driver= driver;
		this.wait= new WebDriverWait(driver, 35);    
	}
	
	public void exitMyOpenCasesForFollowUp() throws Exception{
		try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(ExitLink));
		driver.findElement(ExitLink).click();
		System.out.println("clicked on exit in my open cases for followup listing");
		Log.info("Log4j msg- clicked on exit in my open cases for followup  listing");
		
		}catch(Exception e){ e.printStackTrace(); System.out.println("error in exit my open cases for followup"); Log.info("error in exit my open cases for followup"); }
		
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit();
	}
	
	
	public void addMyOpenCasesForFollowUp(String subject, String type,  String status, String priority, String followupDate, String notetype, String medium, String details) throws Exception{
		
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(AddLink));
		
		driver.findElement(AddLink).click();
		System.out.println("clicked on add in my open cases listing");
		Log.info("Log4j msg- clicked on add in my open cases listing");
		
		System.out.println("subject:"+subject);
		//enter  comm subject
		wait.until(ExpectedConditions.visibilityOfElementLocated(AddCommSubjectInput));
		driver.findElement(AddCommSubjectInput).sendKeys(subject);
		System.out.println("entered subject.");
		Log.info("log4j msg- entered subject in commun.");	
		
		
		System.out.println("type:"+type);
		//enter comm type
		wait.until(ExpectedConditions.visibilityOfElementLocated(AddCommType));
		Select commType = new Select(driver.findElement(AddCommType));
		commType.selectByVisibleText(type);
		System.out.println("selected comm type.");
		Log.info("log4j msg- selected comm type.");	
		
		System.out.println("followupDate:"+followupDate);
		
		//enter comm followup date
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(AddCommFollowupDateInput));
		driver.findElement(AddCommFollowupDateInput).sendKeys(followupDate);
		System.out.println("entered followup date");
		Log.info("log4j msg- entered followup date");	
		
		System.out.println("priority:"+priority);
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
		
		System.out.println("notetype:"+notetype);
		//enter comm details note type
		wait.until(ExpectedConditions.visibilityOfElementLocated(AddCommNoteType));
		Select detailsNotetype = new Select(driver.findElement(AddCommNoteType));
		detailsNotetype.selectByVisibleText(notetype);
		System.out.println("selected note type");
		Log.info("log4j msg- selected note type");	
		
		System.out.println("medium:"+medium);
		//enter comm details medium
		wait.until(ExpectedConditions.visibilityOfElementLocated(AddCommMedium));
		Select detailsMedium = new Select(driver.findElement(AddCommMedium));
		detailsMedium.selectByVisibleText(medium);
		System.out.println("selected medium");
		Log.info("log4j msg- selected medium");	
		
		System.out.println("details:"+details);
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
		Thread.sleep(2000);
		
		}catch(Exception e){
			e.printStackTrace(); 
			System.out.println("error in adding open cases for followup today");
		Log.info("log4j msg- error in adding open cases for followup today");}
		
	BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
	driver.quit();
	
		
	}
	
	
	public void editMyOpenCasesForFollowUp( String subject, String followUpDate, String newPriority) throws Exception{
	
		try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+subject+"']")));
		driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+subject+"']")).click();
		System.out.println("clicked on  my open case  for followup to be edited");
		Log.info("Log4j msg- clicked on edit in my open case for follow up to be edited");
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(EditLink));
		driver.findElement(EditLink).click();
		System.out.println("clicked on edit in my open cases  for followup listing");
		Log.info("Log4j msg- clicked on edit in my open cases for followup listing");
		
		
		/*
		//enter comm followup date
		
				wait.until(ExpectedConditions.visibilityOfElementLocated(AddCommFollowupDateInput));
				driver.findElement(AddCommFollowupDateInput).clear();
				driver.findElement(AddCommFollowupDateInput).sendKeys(newFollowUpDate);
				System.out.println("entered  new followup date");
				Log.info("log4j msg- entered  new followup date");	
				
		*/
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(priority));
		Select prioritySelect = new Select(driver.findElement(priority));
		prioritySelect.selectByVisibleText(newPriority);
		System.out.println("Edited Priority");
		Log.info("log4j msg- Edited Priority");	
		
		
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
				Thread.sleep(2000);
				
		} catch(Exception e){
			e.printStackTrace(); 
			System.out.println("error in editing open cases for followup");
		Log.info("log4j msg- error in editing open cases for followup ");}
			
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
			driver.quit();
		
	}
	
	
	public void copyMyOpenCasesForFollowUp( String subject, String newSubject) throws Exception{
		
		try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and contains(text(),'"+subject+"')]")));
		driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+subject+"']")).click();
		System.out.println("clicked on  my open case to be copied");
		Log.info("Log4j msg- clicked on edit in my open caseto be copied");
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(CopyLink));
		driver.findElement(CopyLink).click();
		System.out.println("clicked on copy in my open cases listing");
		Log.info("Log4j msg- clicked on copy in my open cases listing");
		
		
		System.out.println("subject:"+subject);
		//enter  comm subject
		wait.until(ExpectedConditions.visibilityOfElementLocated(AddCommSubjectInput));
		driver.findElement(AddCommSubjectInput).clear();
		driver.findElement(AddCommSubjectInput).sendKeys(newSubject);
		System.out.println("entered new subject.");
		Log.info("log4j msg- entered new subject in commun.");	
		
		
				
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
				Thread.sleep(2000);
				
				
		}catch(Exception e)		{
			e.printStackTrace(); 
			System.out.println("error in copying my open cases for followup");
		Log.info("log4j msg- error in copying my open cases for followup");	}
			
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
			driver.quit();
		
	}

	
public void deleteMyOpenCasesForFollowUp( String subject) throws Exception{
		
		try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+subject+"']")));
		driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+subject+"']")).click();
		System.out.println("clicked on  my case to be deleted");
		Log.info("Log4j msg- clicked on my case to be deleted");
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(DeleteLink));
		driver.findElement(DeleteLink).click();
		System.out.println("clicked on delete");
		Log.info("Log4j msg- clicked on delete");
		
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(ConfirmYesButton));
		driver.findElement(ConfirmYesButton).click();
		System.out.println("clicked yes to confirm delete");
		Log.info("Log4j msg- clicked yes to confirm delete");
		
		}catch(Exception e)		{
			e.printStackTrace(); 
			System.out.println("error in deleting open case for followup");
			Log.info("error in deleting open case for followup");
			}
			
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
			driver.quit();
		
	}
	
	
	
	
	
}



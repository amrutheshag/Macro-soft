package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BrowserUtils;
import utility.Log;

public class MyCaseHistoryPage {

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
	
	By ConfirmYesButton = By.xpath("//button[text()= 'Yes']");
	
	By AddCommSubjectInput = By.id("txtSubject");

	By AddCommType = By.id("ddlCaseType");
				
	By AddCommFollowupDateInput = By.id("txtFollowup");

	By AddCommPriority = By.id("ddlCasePriority");
				
	By AddCommAddDetailsButton = By.xpath("//button[@data-ng-click='addChildRecord()']");
				
	By AddCommNoteType = By.id("ddlNoteType");
				
	By AddCommMedium = By.id("ddlMedium");
				
	By AddCommDetails = By.id("txtNotes");	
				
	By AddCommHideButton = By.xpath("//button[@data-ng-click='closeMe()']");


	
	
	public MyCaseHistoryPage(WebDriver driver){
		this.driver= driver;
		this.wait= new WebDriverWait(driver, 50);
	}
	
	public void exitMyCaseHistory() throws Exception{
		try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(ExitLink));
		driver.findElement(ExitLink).click();
		System.out.println("clicked on exit in my case history listing");
		Log.info("Log4j msg- clicked on exit in my case history listing");
		} catch(Exception e){e.printStackTrace(); System.out.println("Error in exit My Case History"); Log.info("Error in exit My Case History");}
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit();
	}
	
	
	public void addMyCaseHistory(String subject, String type,  String status, String priority, String followupDate, String notetype, String medium, String details) throws Exception{
		try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(AddLink));
		driver.findElement(AddLink).click();
		System.out.println("clicked on add in my case history listing");
		Log.info("Log4j msg- clicked on add in my case history listing");
		
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
		
		
		
		//click close
		
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-ng-click='closeCase()']")));
				driver.findElement(By.xpath("//button[@data-ng-click='closeCase()']")).click();

				System.out.println("clicked on close case");
				Log.info("log4j msg-clicked on close case");
		
		
		
		
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
		
		}catch(Exception e){e.printStackTrace();System.out.println("Error in Add My case History");}
		
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit();
	
		
	}
	
	
	public void editMyCaseHistory( String subject, String followUpDate, String newFollowUpDate) throws Exception{
	
		try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+subject+"']")));
		driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+subject+"']")).click();
		System.out.println("clicked on  my case history to be edited");
		Log.info("Log4j msg- clicked on my case history to be edited");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(EditLink));
		driver.findElement(EditLink).click();
		System.out.println("clicked on edit in my case history listing");
		Log.info("Log4j msg- clicked on edit in my case history listing");
		
		
		
		//enter comm followup date
		
				wait.until(ExpectedConditions.visibilityOfElementLocated(AddCommFollowupDateInput));
				driver.findElement(AddCommFollowupDateInput).clear();
				driver.findElement(AddCommFollowupDateInput).sendKeys(newFollowUpDate);
				System.out.println("entered  new followup date");
				Log.info("log4j msg- entered  new followup date");	
				
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
	} catch(Exception e){e.printStackTrace();System.out.println("Error in Add- My Case History");
	Log.info("Error in Add- My Case History");}
				
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
			driver.quit();
		
	}
	
	
	public void copyMyCaseHistory( String subject, String newSubject) throws Exception{
		
		try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+subject+"']")));
		driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+subject+"']")).click();
		System.out.println("clicked on  my case history to be copied");
		Log.info("Log4j msg- clicked on  my case history be copied");
		
		

		
		
		
		
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(CopyLink));
		driver.findElement(CopyLink).click();
		System.out.println("clicked on copy in my case history listing");
		Log.info("Log4j msg- clicked on copy in my case history listing");
		
		
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
				
		}catch(Exception e){e.printStackTrace();
		System.out.println("Error in Copy My Case History");
		Log.info("Error in Copy My Case History");}
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
			driver.quit();
		
	}

	
public void deleteMyCaseHistory( String subject) throws Exception{
		
		try{
		
			
			try{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+subject+"']")));
			
		driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+subject+"']")).click();
		System.out.println("clicked on  my case  to be deleted");
		Log.info("Log4j msg- clicked on case to be deleted");
			}catch(Exception e) {System.out.println("Delete");}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(DeleteLink));
		driver.findElement(DeleteLink).click();
		System.out.println("clicked on delete");
		Log.info("Log4j msg- clicked on delete");
		
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(ConfirmYesButton));
		driver.findElement(ConfirmYesButton).click();
		System.out.println("clicked yes to confirm delete");
		Log.info("Log4j msg- clicked yes to confirm delete");
		}catch(Exception e){
			e.printStackTrace(); 
			System.out.println("Error in Delete My Case History");
			Log.info("Error in Delete My Case History");}
				
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
			driver.quit();
		
	}
	
	
	
	
	
	
}


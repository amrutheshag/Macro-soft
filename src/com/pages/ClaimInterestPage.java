package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BrowserUtils;
import utility.Log;

public class ClaimInterestPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	By InterestRateAddLink = By.linkText("Add");
	
	By InterestRateEditLink = By.linkText("Edit");
	
	By InterestRateCopyLink = By.linkText("Copy"); 
	
	By InterestRateDeleteLink = By.linkText("Delete");
	
	By InterestRateExitLink = By.linkText("Exit");
	
	By InterestRateCommLink = By.linkText("Commun.");
	
	By InterestRateSaveLink = By.linkText("Save");
	
	By EffectiveDateInputForSearch = By.xpath("//input[@id='txtDob']");
	
	By StateSelectForSearch = By.xpath("//select[@data-ng-model='filterOptions.state']");
	
	By BenefitProductBeginsSelectForSearch  = By.xpath("//select[@data-ng-model='filterOptions.benefit_product']");
	
	By InterestRateSearchButton = By.xpath("//button[@ng-click='search()']");
	
	By InterestRateConfirmDeleteButton = By.xpath("//button[text()='Yes']");
	
	By EffectiveDateInputForAdd= By.xpath("//input[@id='txtDobb']");
	
	By TermDateInputforAdd = By.xpath("//input[@data-ng-model='ClaimInterestScheduleListing.terminates']");
	
	By StateSelectForAdd = By.xpath("//select[@data-ng-model='ClaimInterestScheduleListing.service_state']");
	
	By BenefitProductBeginsSelectForAdd = By.xpath("//select[@data-ng-model='ClaimInterestScheduleListing.benefit_product']");
	
	By AddDetailsButton = By.xpath("//button[@data-ng-click='addFormThree()']");
	
	By SubmissionMethodSelectForAdd  = By.xpath("//select[@data-ng-disabled='grid.appScope.isAuditing']");
	
	By AgeLoInput = By.xpath("(//div[@class='ui-grid-cell-contents ng-binding ng-scope'])[6]");
	//By AgeLoInput = By.xpath("id('1541696390175-0-uiGrid-000J-cell')/div[@class='ng-scope']/form[@class='ng-pristine ng-valid ng-valid-maxlength']/input[@class='ng-pristine ng-untouched ng-valid ng-scope ng-not-empty ng-valid-maxlength coltuiGrid-000J']");
	
	
	By AgeHiInput   = By.xpath("(//div[@class='ui-grid-cell-contents ng-binding ng-scope'])[7]");
	//By AgeHiInput   = By.xpath("id('1541696390175-0-uiGrid-000K-cell')/div[@class='ng-scope']/form[@class='ng-pristine ng-valid ng-valid-maxlength']/input[@class='ng-pristine ng-untouched ng-valid ng-scope ng-not-empty ng-valid-maxlength coltuiGrid-000K']");
	
	
	
	By AnnualInterestRateInput    = By.xpath("(//div[@class='ui-grid-cell-contents ng-binding ng-scope'])[8]");
	//By AnnualInterestRateInput    = By.xpath("id('1541696390175-0-uiGrid-000L-cell')/div[@class='ng-scope']/form[@class='ng-pristine ng-valid ng-valid-maxlength']/input[@class='ng-pristine ng-untouched ng-valid ng-scope ng-not-empty ng-valid-maxlength coltuiGrid-000L']");
	
			
	By AnnualPenaltyRateInput   = By.xpath("(//div[@class='ui-grid-cell-contents ng-binding ng-scope'])[9]");
	//By AnnualPenaltyRateInput   = By.xpath("id('1541696390175-0-uiGrid-000M-cell')/div[@class='ng-scope']/form[@class='ng-pristine ng-valid ng-valid-maxlength']/input[@class='ng-pristine ng-untouched ng-valid ng-scope ng-not-empty ng-valid-maxlength coltuiGrid-000M']");
	
			
	By MinimumTotalToBeMet  = By.xpath("//input[@data-ng-model='ClaimInterestScheduleListing.minimum_net']");
	
		
	By AssessedOnClaimesOnlyCheckbox = By.xpath("//input[@data-ng-model='ClaimInterestScheduleListing.clean_only']");
	
	By BusinessDaysOnlyCheckBox  = By.xpath("//input[@data-ng-model='ClaimInterestScheduleListing.business_days_only']");
	
	By NotesTextArea = By.xpath("//textarea[@data-ng-model='ClaimInterestScheduleListing.notes']");
	
	By NoEditCheckBox = By.xpath("//input[@data-ng-model='noEdit']");
	
	By NoDeleteCheckBox = By.xpath("//input[@data-ng-model='noDelete']");
	
	By RecordMarkInput  = By.xpath("//input[@data-ng-model='ClaimInterestScheduleListing.mark']");
	
	By InterestRateCommAddLink = By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]");
	
	By AddCommSubjectInput = By.id("txtSubject");
	
	By AddCommAddButton = By.xpath("//button[@data-ng-click='addChildRecord()']");
	
	By AddCommNoteTypeSelect = By.id("ddlNoteType");
	
	By AddCommNotesTextArea = By.xpath("//textarea[@data-ng-model='currentJournalRecord.notes']");
	
	By AddCommHideButton = By.xpath("//button[@data-dismiss='modal' and text()='Hide']");
	
	By AddCommValidateLink = By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[2]/li[1]/a[1]");
	
	By AddCommOkButton = By.xpath("//button[text()='OK']");
	
	By OKButton=  By.xpath("//button[text()='OK']");
	
	By AddCommSaveLink = By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[2]/li[2]/a[1]");
	
	
	public ClaimInterestPage(WebDriver driver){
		this.driver= driver;
		this.wait = new WebDriverWait(driver, 60);
	}

	public int searchInterestRate( String effectiveDate, String state, String benefitProduct) throws Exception
	{
	try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(EffectiveDateInputForSearch));
		driver.findElement(EffectiveDateInputForSearch).sendKeys(effectiveDate);
		System.out.println("Entered effective date");
		Log.info("log4j- msg- Entered effective date");
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(StateSelectForSearch));
		Select stateSearch=new Select(driver.findElement(StateSelectForSearch));
		stateSearch.selectByVisibleText(state);
		System.out.println("selected state");
		Log.info("log4j msg- selected state");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitProductBeginsSelectForSearch));
		Select benefitProductSearch=new Select(driver.findElement(BenefitProductBeginsSelectForSearch));
		benefitProductSearch.selectByVisibleText(benefitProduct);
		System.out.println("selected Benefit product");
		Log.info("log4j msg- selected Benefit product");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(InterestRateSearchButton));
		driver.findElement(InterestRateSearchButton).click();
		System.out.println("clicked search");
		Log.info("log4j- msg- clicked search");
		
		System.out.println("effectiveDate: "+effectiveDate);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+effectiveDate+"'])[1]")));
		
		driver.findElement(By.xpath("(//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+effectiveDate+"'])[1]")).click();
		return 1;	
	}catch(Exception e){Log.info("log4j - msg -Interest Rate Record not found");
	System.out.println("Interest Rate Record not found"); return 0;}
	}
	
	
	
	
	public void InterestRateAdd( String effectiveDate,  String state, String benefitProduct, String termDate, String submissionMethod, String ageLo, String ageHi, String annualInterestRate, String annualPenaltyRate, String minTotalToBeMet, String assessedOnCleanClaimsOnly, String countBusinessDaysOnly, String notes) throws Exception {
	try{
			int j=searchInterestRate( effectiveDate, state, benefitProduct);
			if (j==0){
				Log.info("log4j - msg -Interest Rate Record not found, continue with add");
				System.out.println("Interest Rate Record not found, continue with add");
				
				//click ok
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(OKButton));
				driver.findElement(OKButton).click();
				System.out.println("clicked ok");
				Log.info("log4j - msg- clicked ok");
				
				//click add
				wait.until(ExpectedConditions.visibilityOfElementLocated(InterestRateAddLink));
				driver.findElement(InterestRateAddLink).click();
				System.out.println("clicked add");
				Log.info("log4j - msg- clicked add");
				
				
				//enter effective date
			
				wait.until(ExpectedConditions.visibilityOfElementLocated(EffectiveDateInputForAdd));
				driver.findElement(EffectiveDateInputForAdd).sendKeys(effectiveDate);
				System.out.println("entered effective date");
				Log.info("log4j - msg- entered effective date");
				
				//enter term date
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(TermDateInputforAdd ));
				driver.findElement(TermDateInputforAdd).sendKeys(termDate);
				System.out.println("entered term date");
				Log.info("log4j - msg- entered term date");
				
				//select state
								
				wait.until(ExpectedConditions.visibilityOfElementLocated(StateSelectForAdd));
				Select stateSelect=new Select(driver.findElement(StateSelectForAdd));
				stateSelect.selectByVisibleText(state);
				System.out.println("selected state");
				Log.info("log4j msg- selected state");
				
				//select Benefit product
				wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitProductBeginsSelectForAdd));
				Select benefitProductSelect=new Select(driver.findElement(BenefitProductBeginsSelectForAdd));
				benefitProductSelect.selectByVisibleText(benefitProduct);
				System.out.println("selected Benefit product");
				Log.info("log4j msg- selected Benefit product");
				
				driver.findElement(MinimumTotalToBeMet).sendKeys(Keys.PAGE_DOWN);	
				
				
				//click add
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(AddDetailsButton));
				driver.findElement(AddDetailsButton).click();
				
				System.out.println("clicked add");
				Log.info("log4j msg- clicked add");
				
				
				//select submission method
				wait.until(ExpectedConditions.visibilityOfElementLocated(SubmissionMethodSelectForAdd));
				Select submissionSelect=new Select(driver.findElement(SubmissionMethodSelectForAdd));
				submissionSelect.selectByVisibleText(submissionMethod);
				System.out.println("selected submission method");
				Log.info("log4j msg- selected submission method");
				
				
				Actions action = new Actions(driver);
				
				System.out.println("AgeLo: "+ ageLo);
				Log.info("AgeLo: "+ ageLo);
				//enter age lo
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(AgeLoInput));
				WebElement element1 = driver.findElement(AgeLoInput);
				element1.click();
				action.doubleClick(element1).sendKeys(ageLo).perform();
				System.out.println("entered age lo");
				Log.info("log4j - msg- entered age lo");
				
				
				/* Thread.sleep(5000);
				
				System.out.println("AgeHi: "+ ageHi);
				Log.info("AgeHi: "+ ageHi);
				//enter age hi
				wait.until(ExpectedConditions.visibilityOfElementLocated(AgeHiInput));
				WebElement element2 = driver.findElement(AgeHiInput);
				element2.click();
				action.doubleClick(element2).sendKeys(ageHi).perform();
				System.out.println("entered age Hi");
				Log.info("log4j - msg- entered age Hi");
				*/
				
				Thread.sleep(5000);
				
				
				
				Thread.sleep(5000);
				System.out.println("Annual Penalty rate: "+ annualPenaltyRate);
				Log.info("Annual Penalty rate: "+ annualPenaltyRate);
				//enter annual penalty rate
				wait.until(ExpectedConditions.visibilityOfElementLocated(AnnualPenaltyRateInput));
				WebElement element4 = driver.findElement(AnnualPenaltyRateInput);
				element4.click();
				action.doubleClick(element4).sendKeys(annualPenaltyRate).perform();
				System.out.println("entered annual penalty rate input");
				Log.info("log4j - msg- entered annual penalty rate input");
				
				Thread.sleep(2000);
				//enter min total amt to be met
				wait.until(ExpectedConditions.visibilityOfElementLocated(MinimumTotalToBeMet));
				WebElement element5 = driver.findElement(MinimumTotalToBeMet);
				element5.sendKeys(minTotalToBeMet);
				//action.doubleClick(element5).sendKeys(minTotalToBeMet).perform();
				System.out.println("entered min");
				Log.info("log4j - msg- entered min");
				
				
				//enter annual interest rate
				System.out.println("Annual Interest rate: "+ annualInterestRate);
				Log.info("Annual Interest rate: "+ annualInterestRate);
				//enter annual interest rate
				wait.until(ExpectedConditions.visibilityOfElementLocated(AnnualInterestRateInput));
				WebElement element3 = driver.findElement(AnnualInterestRateInput);
				element3.click();
				action.doubleClick(element3).sendKeys(annualInterestRate).perform();
				System.out.println("entered annual interest rate input");
				Log.info("log4j - msg-entered  annual interest rate input");
				
				
				
				
				//enter notes
				wait.until(ExpectedConditions.visibilityOfElementLocated(NotesTextArea));
				driver.findElement(NotesTextArea).sendKeys(notes);
				System.out.println("entered notes");
				Log.info("log4j - msg- entered notes");
			
				
				
				
				//enter age Hi
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(AgeHiInput));
				WebElement element2 = driver.findElement(AgeHiInput);
				element2.click();
				action.doubleClick(element2).sendKeys(ageHi).perform();
				System.out.println("entered age Hi");
				Log.info("log4j - msg- entered age Hi");//click save
				wait.until(ExpectedConditions.visibilityOfElementLocated(InterestRateSaveLink));
				driver.findElement(InterestRateSaveLink).click();
				System.out.println("clicked save");
				Log.info("log4j - msg- clicked save");
			
				
				try{
					
				
					
					wait.until(ExpectedConditions.visibilityOfElementLocated(OKButton));
					driver.findElement(OKButton).click();
					System.out.println("clicked ok");
					Log.info("log4j - msg- clicked ok");
				
					
					
					
					
					
					
					
				} catch( Exception e) {}
				
			}else
			{
				System.out.println("Interest Rate Record already present");
				Log.info("log4j - msg- Interest Rate Record already present");
				
			}
	}catch(Exception e){
		e.printStackTrace(); 
		System.out.println("error in add interest rate");
		Log.info("log4j - msg- error in add interest rate"); 
	}		
	
	
	BrowserUtils. takeScreenshot( driver,Thread.currentThread().getStackTrace()[2].getMethodName()); 
	driver.quit(); 
}

	public void InterestRateEdit( String effectiveDate, String state, String benefitProduct, String newAnnualInterestRate, String newAnnualPenaltyRate) throws Exception {
	try{
			int j=searchInterestRate( effectiveDate, state, benefitProduct);
			if (j==1){
				Log.info("log4j - msg -Interest Rate Record found, continue with edit");
				System.out.println("Interest Rate Record found, continue with edit");
				
				
				//click Edit
				wait.until(ExpectedConditions.visibilityOfElementLocated(InterestRateEditLink));
				driver.findElement(InterestRateEditLink).click();
				System.out.println("clicked Edit");
				Log.info("log4j - msg- clicked Edit");
				
				
				//enter effective date
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(EffectiveDateInputForAdd));
				driver.findElement(EffectiveDateInputForAdd).sendKeys(effectiveDate);
				System.out.println("entered effective date");
				Log.info("log4j - msg- entered effective date");
				
				//enter new annual interest rate
				
				/*
				wait.until(ExpectedConditions.visibilityOfElementLocated(AnnualInterestRateInput));
				driver.findElement(AnnualInterestRateInput).clear();
				driver.findElement(AnnualInterestRateInput).sendKeys(newAnnualInterestRate);
				System.out.println("entered annual interest rate");
				Log.info("log4j - msg- entered annual interest rate");
				*/
				
				
				Actions action = new Actions(driver);
				//enter annual interest rate
				System.out.println("New Annual Interest rate: "+ newAnnualInterestRate);
				Log.info("Annual Interest rate: "+ newAnnualInterestRate);
				//enter annual interest rate
				wait.until(ExpectedConditions.visibilityOfElementLocated(AnnualInterestRateInput));
				WebElement elementA = driver.findElement(AnnualInterestRateInput);
				elementA.click();
				action.doubleClick(elementA).sendKeys(newAnnualInterestRate).perform();
				System.out.println("entered new annual interest rate input");
				Log.info("log4j - msg-entered new  annual interest rate input");
			
				
				
				
				
				
				/*
				//enter annual penalty rate
				wait.until(ExpectedConditions.visibilityOfElementLocated(AnnualPenaltyRateInput));
				driver.findElement(AnnualPenaltyRateInput).clear();
				driver.findElement(AnnualPenaltyRateInput).sendKeys(newAnnualPenaltyRate);
				System.out.println("entered annual penalty rate");
				Log.info("log4j - msg- entered annual penalty rate");
				
				*/
				//click save
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(InterestRateSaveLink));
				driver.findElement(InterestRateSaveLink).click();
				System.out.println("clicked save");
				Log.info("log4j - msg- clicked save");
			
				Thread.sleep(1000);
				
				
			}else
			{
				System.out.println("Interest Rate Record not present");
				Log.info("log4j - msg- Interest Rate Record not present");
				
			}
	}catch(Exception e){
		e.printStackTrace();
		System.out.println("error in edit interest rate");
	Log.info("log4j - msg- error in edit interest rate"); }		
	
	
	BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit(); 
}


	
	public void InterestRateCopy( String effectiveDate, String state, String benefitProduct, String newNotes ) throws Exception {
	try{
			int j=searchInterestRate(effectiveDate, state, benefitProduct);
			if (j==1){
				Log.info("log4j - msg -Interest Rate Record found, continue with copy");
				System.out.println("Interest Rate Record found, continue with copy");
				
				
				//click copy
				wait.until(ExpectedConditions.visibilityOfElementLocated(InterestRateCopyLink));
				driver.findElement(InterestRateCopyLink).click();
				System.out.println("clicked copy");
				Log.info("log4j - msg- clicked copy");
				
				Thread.sleep(2000);
				
				//enter effective date
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(EffectiveDateInputForAdd));
				driver.findElement(EffectiveDateInputForAdd).sendKeys(effectiveDate);
				System.out.println("entered effective date");
				Log.info("log4j - msg- entered effective date");
				
				Thread.sleep(2000);
				//enter new notes
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(NotesTextArea));
				driver.findElement(NotesTextArea).sendKeys(newNotes);
				System.out.println("entered notes");
				Log.info("log4j - msg- entered notes");
				
				//click save
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(InterestRateSaveLink));
				driver.findElement(InterestRateSaveLink).click();
				System.out.println("clicked save");
				Log.info("log4j - msg- clicked save");
			
				
				
				
			}else
			{
				System.out.println("Interest Rate Record not present");
				Log.info("log4j - msg- Interest Rate Record not present");
				
			}
	}catch(Exception e){System.out.println("error in copy interest rate");
	Log.info("log4j - msg- error in copy interest rate"); }		
	
	
	BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit(); 
}
	
	
	
	
	public void InterestRateExit( String effectiveDate, String state, String benefitProduct) throws Exception {
	try{
			int j=searchInterestRate( effectiveDate, state, benefitProduct);
			if (j==1){
				Log.info("log4j - msg -Interest Rate Record found, continue with exit");
				System.out.println("Interest Rate Record found, continue with exit");
				
				
				//click exit
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(InterestRateExitLink));
				driver.findElement(InterestRateExitLink).click();
				System.out.println("clicked exit");
				Log.info("log4j - msg- clicked exit");
			
				
				
				
			}else
			{
				System.out.println("Interest Rate Record not present");
				Log.info("log4j - msg- Interest Rate Record not present");
				
				
	//click exit
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(InterestRateExitLink));
				driver.findElement(InterestRateExitLink).click();
				System.out.println("clicked exit");
				Log.info("log4j - msg- clicked exit");
				
			}
	}catch(Exception e){System.out.println("error in exit interest rate");
	Log.info("log4j - msg- error in exit interest rate"); }		
	
	
	BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit(); 
}
	
	
	
	public void InterestRateDelete( String effectiveDate,  String state, String benefitProduct) throws Exception {
	try{
			int j=searchInterestRate( effectiveDate, state, benefitProduct);
			if (j==1){
				Log.info("log4j - msg -Interest Rate Record found, continue with delete");
				System.out.println("Interest Rate Record found, continue with delete");
				
				
				//click delete
				wait.until(ExpectedConditions.visibilityOfElementLocated(InterestRateDeleteLink));
				driver.findElement(InterestRateDeleteLink).click();
				System.out.println("clicked delete");
				Log.info("log4j - msg- clicked delete");
				
				//click Yes to confirm
				wait.until(ExpectedConditions.visibilityOfElementLocated(InterestRateConfirmDeleteButton));
				driver.findElement(InterestRateConfirmDeleteButton).click();
				System.out.println("clicked confirm delete");
				Log.info("log4j - msg- clicked confirm delete");
				
				
			}else
			{
				System.out.println("Interest Rate Record not present");
				Log.info("log4j - msg- Interest Rate Record not present");
				
				
	//click exit
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(InterestRateExitLink));
				driver.findElement(InterestRateExitLink).click();
				System.out.println("clicked exit");
				Log.info("log4j - msg- clicked exit");
				
			}
	
	
	
	
	
	}catch(Exception e){System.out.println("error in delete interest rate");
	Log.info("log4j - msg- error in delete interest rate"); }		
	
	
	BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit(); 
}
	
	
	public void InterestRateAddComm( String effectiveDate,  String state, String benefitProduct, String subject, String noteType, String details) throws Exception {
	try{
			int j=searchInterestRate( effectiveDate, state, benefitProduct);
			if (j==1){
				Log.info("log4j - msg -Interest Rate Record found, continue with add Comm");
				System.out.println("Interest Rate Record found, continue with add Comm");
				
				
				//click Comm
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(InterestRateCommLink));
				driver.findElement(InterestRateCommLink).click();
				System.out.println("clicked Comm");
				Log.info("log4j - msg- clicked Comm");
			
				
				//click add
						
						wait.until(ExpectedConditions.visibilityOfElementLocated(InterestRateCommAddLink));
						driver.findElement(InterestRateCommAddLink).click();
						System.out.println("clicked Add Comm");
						Log.info("log4j - msg- clicked Add Comm");
				
				//enter subject	
						wait.until(ExpectedConditions.visibilityOfElementLocated(AddCommSubjectInput));
						driver.findElement(AddCommSubjectInput).sendKeys(subject);
						System.out.println("entered subject");
						Log.info("log4j - msg- entered subject");
							
				//click add button
								
						wait.until(ExpectedConditions.visibilityOfElementLocated(AddCommAddButton));
						driver.findElement(AddCommAddButton).click();
						System.out.println("clicked Add button");
						Log.info("log4j - msg- clicked Add button");
									
				//select notetype
												
						wait.until(ExpectedConditions.visibilityOfElementLocated(AddCommNoteTypeSelect));
						Select noteTypeSelect=new Select(driver.findElement(AddCommNoteTypeSelect));
						noteTypeSelect.selectByVisibleText(noteType);
						System.out.println("selected note type");
						Log.info("log4j msg- selected note type");
							
								
								//enter notes
						
						wait.until(ExpectedConditions.visibilityOfElementLocated(AddCommNotesTextArea));
						driver.findElement(AddCommNotesTextArea).sendKeys(details);
						System.out.println("entered notes details");
						Log.info("log4j - msg- entered notes details");
								
								//click hide

						wait.until(ExpectedConditions.visibilityOfElementLocated(AddCommHideButton));
						driver.findElement(AddCommHideButton).click();
						System.out.println("clicked hide");
						Log.info("log4j - msg- clicked hide");								
								
					/*	//validate
						wait.until(ExpectedConditions.visibilityOfElementLocated(AddCommValidateLink));
						driver.findElement(AddCommValidateLink).click();
						System.out.println("clicked validate");
						Log.info("log4j - msg- clicked validate");											
								
						//click ok
						wait.until(ExpectedConditions.visibilityOfElementLocated(AddCommOkButton));
						driver.findElement(AddCommOkButton).click();
						System.out.println("clicked ok");
						Log.info("log4j - msg- clicked ok");									
					*/			
						//click save
						wait.until(ExpectedConditions.visibilityOfElementLocated(AddCommSaveLink));
						driver.findElement(AddCommSaveLink).click();
						System.out.println("clicked save");
						Log.info("log4j - msg- clicked save");																					
							Thread.sleep(1000);		
								
								
			}else
			{
				System.out.println("Interest Rate Record not present");
				Log.info("log4j - msg- Interest Rate Record not present");
				
				
	//click exit
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(InterestRateExitLink));
				driver.findElement(InterestRateExitLink).click();
				System.out.println("clicked exit");
				Log.info("log4j - msg- clicked exit");
				
			}
	}catch(Exception e){e.printStackTrace(); System.out.println("error in add comm interest rate");
	Log.info("log4j - msg- error in add comm interest rate"); }		
	
	
	BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit(); 
}
	
	
	
	
}
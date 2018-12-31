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

public class PayerListingPage {

	
	WebDriver driver;
	WebDriverWait wait ;    
	
	By InsurerPayerCodeBeginsInput = By.xpath("//input[@id='txtSearchCode']");
	
	By InsurerPayerNameDescriptionBeginsInput = By.xpath("//input[@id='txtSearchName']");
	
	By InsurerPayerSearchButton= By.xpath("//button[@data-ng-click='search()']");
	
	By InsurerPayerAddLink= By.linkText("Add");
	
	By InsurerPayerEditLink = By.linkText("Edit");
	
	By InsurerPayerCopyLink = By.linkText("Copy");
	
	By InsurerPayerDeleteLink = By.linkText("Delete");
	
	By InsurerPayerAddCommunicationLink = By.linkText("Commun.");
	
	By InsurerPayerExitLink = By.linkText("Exit");
	
	By confirmPayerDeleteButton= By.xpath("//button[@data-bb-handler='Success' and @class='btn btn-primary btn-bottom02' and text()='Yes']");
	
	By payerPhoneNumberInput= By.xpath("//input[@id='txtPhone']");
	
	
	
	
	
	
	public PayerListingPage(WebDriver driver){
		this.driver= driver;
		this.wait= new WebDriverWait(driver, 35);
	}
	
	public int searchInsurerPayer( String InsurerPayerCode, String InsurerPayerName) throws Exception{
		try{
		//enter  InsurerPayer code
		wait.until(ExpectedConditions.visibilityOfElementLocated(InsurerPayerCodeBeginsInput));
		driver.findElement(InsurerPayerCodeBeginsInput).clear();
		driver.findElement(InsurerPayerCodeBeginsInput).sendKeys(InsurerPayerCode);
		System.out.println("entered insurer/payer code");
		Log.info("log4j msg- entered insurer/payer code");
	
	
		//enter  InsurerPayer name
		wait.until(ExpectedConditions.visibilityOfElementLocated(InsurerPayerNameDescriptionBeginsInput));
		driver.findElement(InsurerPayerNameDescriptionBeginsInput).clear();
		driver.findElement(InsurerPayerNameDescriptionBeginsInput).sendKeys(InsurerPayerName);
		System.out.println("entered insurer/payer name");
		Log.info("log4j msg- entered insurer/payer name");
		
		//click search
		wait.until(ExpectedConditions.visibilityOfElementLocated(InsurerPayerSearchButton));
		driver.findElement(InsurerPayerSearchButton).click();
		System.out.println("clicked Search");
		Log.info("log4j msg- clicked Search");
				

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+InsurerPayerCode+"']")));
		WebElement e = driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+InsurerPayerCode+"']"));
		e.click();
		System.out.println("Found Insurer/Payer");
		Log.info("log4j msg- Found Insurer/Payer");
	
		return 1;
		}
		
	catch(Exception e){System.out.println("Cannot find  Insurer/Payer"); 
	Log.info("Cannot find  Insurer/Payer"); 
	return 0;}
		
	}
	
	
	
	public void insurerPayerExit( String code, String name) throws Exception{
			int i= searchInsurerPayer( code, name);
		
		if (i==1){
			System.out.println("Found Payer");
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(InsurerPayerExitLink));
		driver.findElement(InsurerPayerExitLink).click();
		System.out.println("clicked Exit");
		Log.info("log4j msg- clicked Exit");
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit();
		
		} else{
			System.out.println("cannot find Payer");
			wait.until(ExpectedConditions.visibilityOfElementLocated(InsurerPayerExitLink));
			driver.findElement(InsurerPayerExitLink).click();
			System.out.println("clicked Exit");
			Log.info("log4j msg- clicked Exit");
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
			driver.quit();
		}
	}
	
	public void insurerPayerAdd( String code, String name, String payerContact, String payerMainAddress, String payerCity, String payerState, String payerZIP, String payerPhone, String payerFAX, String payerBusinessUnitNumber, String payerContractNumber, String payerType, String payerExclusiveProviderNetwork, String payerUserField) throws Exception{
		int i= searchInsurerPayer( code, name);
		
		if (i==0){
			System.out.println("Payer not found, Continue with Add");
			Log.info("log4j msg- Payer not found, Continue with Add");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(InsurerPayerAddLink));
		driver.findElement(InsurerPayerAddLink).click();
		System.out.println("clicked Add");
		Log.info("log4j msg- clicked Add");
		
		
		
		
		
		//enter payer code
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtCode']")));
		driver.findElement(By.xpath("//input[@id='txtCode']")).sendKeys(code);
		System.out.println("entered Payer code");	
		Log.info("log4j msg- entered Payer code");
		Thread.sleep(1000);
		//enter payer name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtName']")));
		driver.findElement(By.xpath("//input[@id='txtName']")).sendKeys(name);
		System.out.println("entered Payer Name");	
		Log.info("log4j msg- entered Payer Name");
		Thread.sleep(1000);
		
		//enter address	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtAddressLine1']")));
		driver.findElement(By.xpath("//input[@id='txtAddressLine1']")).sendKeys(payerMainAddress);
		System.out.println("entered Payer address");	
		Log.info("log4j msg- entered Payer address");
	
		
		//enter business unit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtBusinessUnit']")));
		driver.findElement(By.xpath("//input[@id='txtBusinessUnit']")).sendKeys(payerBusinessUnitNumber);
		System.out.println("entered Business unit");
		Log.info("log4j msg- entered Business unit");
		
		//enter contract
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtContract']")));
		driver.findElement(By.xpath("//input[@id='txtContract']")).sendKeys(payerContractNumber);
		System.out.println("entered Business contract");
		Log.info("log4j msg- entered Business contract");
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlPayerType")));
		Select payerType1=new Select(driver.findElement(By.id("ddlPayerType")));
		payerType1.selectByVisibleText(payerType);
		System.out.println("selected payer type");
		Log.info("log4j msg- selected payer type");
		
		
		//click checkbox
		if (payerExclusiveProviderNetwork.equals("yes"))
		{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-ng-model='currentRecord.epoprovs']")));
		driver.findElement(By.xpath("//input[@data-ng-model='currentRecord.epoprovs']")).click();
		System.out.println("clicked Exclusive Provider n/w checkbox");
		Log.info("log4j msg- clicked Exclusive Provider n/w checkbox");
		
		}
		
		Thread.sleep(2000);
		//click save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Save")));
		driver.findElement(By.linkText("Save")).click();
		System.out.println("clicked Save");	
		Log.info("log4j msg- clicked Save");	
		Thread.sleep(2000);
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit();
		
		} else{
			System.out.println("Payer is already present, cannot add payer");
			wait.until(ExpectedConditions.visibilityOfElementLocated(InsurerPayerExitLink));
			driver.findElement(InsurerPayerExitLink).click();
			System.out.println("clicked Exit");
			Log.info("log4j msg- clicked Exit");
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
			driver.quit();
		}
	}
	
	
	
	public void insurerPayerDelete( String code, String name) throws Exception{
		int i= searchInsurerPayer( code, name);
		
		if (i==1){
			System.out.println("Found Payer");
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(InsurerPayerDeleteLink));
		driver.findElement(InsurerPayerDeleteLink).click();
		System.out.println("clicked Delete");
		Log.info("log4j msg- clicked Delete");
		
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(confirmPayerDeleteButton));
		driver.findElement(confirmPayerDeleteButton).click();
		System.out.println("clicked Yes to confirm Delete");
		Log.info("log4j msg- clicked Yes to confirm Delete");
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit();
		
		
		
		} else{
			System.out.println("cannot find Payer");
			Log.info("log4j msg-cannot find Payer");
			wait.until(ExpectedConditions.visibilityOfElementLocated(InsurerPayerExitLink));
			driver.findElement(InsurerPayerExitLink).click();
			System.out.println("clicked Exit");
			Log.info("log4j msg- clicked Exit");
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
			driver.quit();
		}
	}
	
	
	
	
	public void insurerPayerEdit( String code, String name, String payerPhone) throws Exception{
		int i= searchInsurerPayer( code, name);
		
		if (i==1){
			System.out.println("Found Payer");
			Log.info("log4j msg- Found Payer");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(InsurerPayerEditLink));
		driver.findElement(InsurerPayerEditLink).click();
		System.out.println("clicked Edit");
		Log.info("log4j msg- clicked Edit");
		
		
		//enter payer phone number
		wait.until(ExpectedConditions.visibilityOfElementLocated(payerPhoneNumberInput));
		driver.findElement(payerPhoneNumberInput).sendKeys(payerPhone);
		System.out.println("entered phone number");
		Log.info("log4j msg- entered phone number");
		
		//click save
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Save")));
				driver.findElement(By.linkText("Save")).click();
				System.out.println("clicked Save");	
				Log.info("log4j msg- clicked Save");	
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
				driver.quit();
		
		} else{
			System.out.println("cannot find Payer");
			Log.info("log4j msg- cannot find payer");
			wait.until(ExpectedConditions.visibilityOfElementLocated(InsurerPayerExitLink));
			driver.findElement(InsurerPayerExitLink).click();
			System.out.println("clicked Exit");
			Log.info("log4j msg- clicked Exit");
			
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
			driver.quit();
			
		}
	}
	
	
	public void insurerPayerCopy( String code, String name, String newName, String newCode, String newBusinessUnitNumber, String newContractNumber, String newAddress) throws Exception{
		int i= searchInsurerPayer( code, name);
		
		if (i==1){
			System.out.println("Payer found, continue with copy");
			Log.info("log4j msg-Payer found, continue with copy");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(InsurerPayerCopyLink));
		driver.findElement(InsurerPayerCopyLink).click();
		System.out.println("clicked Copy");
		Log.info("log4j msg- clicked Copy");
		
		
		
		
		
		//enter payer code
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtCode']")));
		driver.findElement(By.xpath("//input[@id='txtCode']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='txtCode']")).sendKeys(newCode);
		Thread.sleep(1000);
		System.out.println("enterd new Payer code");	
		Log.info("log4j msg- enterd new Payer code");
				
		//enter payer name
		//<input class="form-control ng-valid ng-valid-maxlength ng-touched ng-dirty ng-empty" id="txtName" placeholder="" maxlength="30" data-ng-model="currentRecord.name" data-ng-disabled="isAuditing">
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtName']")));
		driver.findElement(By.xpath("//input[@id='txtName']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='txtName']")).sendKeys(newName);
		Thread.sleep(1000);
		System.out.println("entered new Payer Name");	
		Log.info("log4j msg- entered new Payer Name");
		
		//enter address	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtAddressLine1']")));
		driver.findElement(By.xpath("//input[@id='txtAddressLine1']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='txtAddressLine1']")).sendKeys(newAddress);
		Thread.sleep(1000);
		System.out.println("entered new Payer address");	
		Log.info("log4j msg- entered new Payer address");
				
		
		//enter business unit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtBusinessUnit']")));
		driver.findElement(By.xpath("//input[@id='txtBusinessUnit']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='txtBusinessUnit']")).sendKeys(newBusinessUnitNumber);
		Thread.sleep(1000);
		System.out.println("entered new Business unit number");
		Log.info("log4j msg- entered new Business unit number");
		
		//enter contract
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtContract']")));
		driver.findElement(By.xpath("//input[@id='txtContract']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='txtContract']")).sendKeys(newContractNumber);
		Thread.sleep(1000);
		System.out.println("entered new Business contract");
		Log.info("log4j msg- entered new Business contract");
		
		
		
		
		
		
		//click save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Save")));
		driver.findElement(By.linkText("Save")).click();
		System.out.println("clicked Save");	
		Log.info("log4j msg- clicked Save");	
				
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit();
		
		} else{
			System.out.println("Payer is not present, cannot copy payer");
			wait.until(ExpectedConditions.visibilityOfElementLocated(InsurerPayerExitLink));
			driver.findElement(InsurerPayerExitLink).click();
			System.out.println("clicked Exit");
			Log.info("log4j msg- clicked Exit");
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
			driver.quit();
		}
	}
	
	
	public void insurerPayerAddComm( String code, String name, String subject, String type, String noteType, String medium, String details) throws Exception{
		try{	
		int i= searchInsurerPayer( code, name);
		
		if (i==1){
			System.out.println("Found Payer");
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(InsurerPayerAddCommunicationLink));
		driver.findElement(InsurerPayerAddCommunicationLink).click();
		System.out.println("clicked Add Communication");
		Log.info("log4j msg- clicked Add Communication");
		
		//click add
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")));
		driver.findElement(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")).click();
		System.out.println("clicked Add");
		Log.info("log4j msg- clicked Add");
		
		//enter subject
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtSubject' and @data-ng-model='currentRecord.subject']")));
		driver.findElement(By.xpath("//input[@id='txtSubject' and @data-ng-model='currentRecord.subject']")).sendKeys(subject);
		System.out.println("entered subject");
		Log.info("log4j msg-entered subject");
		
		//select case type
		
		//page down
		driver.findElement(By.xpath("//input[@id='txtFollowup']")).sendKeys(Keys.PAGE_DOWN);
		
		
		
		//click add
		//id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 col-md-6 col-lg-7 tab-container']/div[@class='tab-content']/div[@id='tabGeneral']/div[@class='row']/div[@class='col-lg-12 col-md-12 col-sm-12 col-xs-12 button-wrap']/div[@class='col-lg-10 col-md-10 col-sm-12 col-xs-12 no-padding text-right pull-right']/button[@class='btn btn-primary btn-bottom01']
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 col-md-6 col-lg-7 tab-container']/div[@class='tab-content']/div[@id='tabGeneral']/div[@class='row']/div[@class='col-lg-12 col-md-12 col-sm-12 col-xs-12 button-wrap']/div[@class='col-lg-10 col-md-10 col-sm-12 col-xs-12 no-padding text-right pull-right']/button[@class='btn btn-primary btn-bottom01' and text()='Add']")));
		driver.findElement(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 col-md-6 col-lg-7 tab-container']/div[@class='tab-content']/div[@id='tabGeneral']/div[@class='row']/div[@class='col-lg-12 col-md-12 col-sm-12 col-xs-12 button-wrap']/div[@class='col-lg-10 col-md-10 col-sm-12 col-xs-12 no-padding text-right pull-right']/button[@class='btn btn-primary btn-bottom01' and text()='Add']")).click();
		System.out.println("clicked add button");
		Log.info("log4j msg-clicked add button");
		
		//select note type
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlNoteType")));
		Select notetypes=new Select(driver.findElement(By.id("ddlNoteType")));
		Thread.sleep(3000);
		System.out.println("note type:"+ noteType);
		notetypes.selectByVisibleText(noteType);
		System.out.println("selected notetype");
		Log.info("log4j msg-selected notetype");
		
		//enter details
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='txtNotes']")));
		driver.findElement(By.xpath("//textarea[@id='txtNotes']")).sendKeys(details);

		System.out.println("entered comm details");
		Log.info("log4j msg-entered communication details");
		
		//click hide
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-ng-click='closeMe()']")));
		driver.findElement(By.xpath("//button[@data-ng-click='closeMe()']")).click();
		
		System.out.println("clicked on hide");
		Log.info("log4j msg-clicked on hide");
		
		//click close case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-ng-click='closeCase()']")));
		driver.findElement(By.xpath("//button[@data-ng-click='closeCase()']")).click();

		System.out.println("clicked on close case");
		Log.info("log4j msg-clicked on close case");
		
		//click validate
		
		//click save
		
		driver.findElement(By.linkText("Save")).click();
		System.out.println("clicked on save");
		Log.info("log4j msg- clicked on save");

		
		Thread.sleep(2000);BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit();
	}
		
		
	else{
			System.out.println("cannot find Payer");
			wait.until(ExpectedConditions.visibilityOfElementLocated(InsurerPayerExitLink));
			driver.findElement(InsurerPayerExitLink).click();
			System.out.println("clicked Exit");
			Log.info("log4j msg- clicked Exit"); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
			driver.quit();
		}
	
	}catch(Exception e){ System.out.println("error in Payor add comm");
	Log.info("log4j msg- error in Payor add comm"); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
	driver.quit();}
	}
	
	
	
	}


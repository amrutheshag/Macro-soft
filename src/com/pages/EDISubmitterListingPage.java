package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BrowserUtils;
import utility.Log;

public class EDISubmitterListingPage {
	
	WebDriver driver;
	WebDriverWait wait;

	By EDISubmittersNameBeginsSearchInput = By.id("txtSearchCode");
	
	By EDISubmitterCodeBeginsSearchInput = By.xpath("//input[@data-ng-model='filterOptions.edi_submitter']");

	By EDISubmitterSearchButton = By.xpath("//button[@class='btn btn-primary']");
	
	By EDISubmitterAddLink = By.linkText("Add");
	
	By EDISubmittersEditLink =  By.linkText("Edit");
	
	By EDISubmittersCopyLink = By.linkText("Copy");
	
	By EDISubmittersExitLink =  By.linkText("Exit");
	
	By EDISubmittersCommLink =  By.linkText("Commun.");
	
	By EDISubmittersDeleteLink =  By.linkText("Delete");
	
	By EDISubmittersSaveLink = By.linkText("Save");
	
	By EDISubmittersAddNameInput = By.id("name");
			
	By EDISUbmittersAddUniqueIDInput = By.xpath("//input[@data-ng-model='CredentialsListing.edi_submitter']");
		
	By EDISubmittersAddDetailsButton = By.xpath("//button[@data-ng-click='addFormTwo()' and text()='Add']");
	
	By EDISubmittersAddEDIDefinitionInput = By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope']");
			
	By EDISubmittersAddMappingFormatInput = By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope']");
			
	By EDISubmittersSplitServiceCode = By.xpath("//div[@class='ui-grid-cell ng-scope ui-grid-disable-selection ui-grid-coluiGrid-000D']");
	
	By EDISubmittersConfirmDeleteButton = By.xpath("//button[text()='Yes']");
	
			
	public EDISubmitterListingPage(WebDriver driver){
		this.driver= driver;
		this.wait = new WebDriverWait(driver, 20);
	}



	public int searchEDISubmitter( String name, String submitterCode) throws Exception{
		
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(EDISubmittersNameBeginsSearchInput));
			driver.findElement(EDISubmittersNameBeginsSearchInput).sendKeys(name);
			System.out.println("entered name");
			Log.info("log4j - msg- entered name");
		
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(EDISubmitterCodeBeginsSearchInput));
			driver.findElement(EDISubmitterCodeBeginsSearchInput).sendKeys(submitterCode);
			System.out.println("entered code");
			Log.info("log4j - msg- entered code");
		Thread.sleep(1000);
			
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(EDISubmitterSearchButton));
			driver.findElement(EDISubmitterSearchButton).click();
			System.out.println("click search");
			Log.info("log4j - msg- click search");
			
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and contains(text(),'"+submitterCode+"')]")));
			driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and contains(text(),'"+submitterCode+"')]")).click();
			System.out.println("submitter found ");
			Log.info("log4j - msg- submitter found");
			
		return 1;
		}
		catch(Exception e){  System.out.println("cannot find Submitter"); Log.info("cannot find Submitter");
		return 0;
		}
	}
	
	
	
public void addEDISubmitter( String name, String id, String definition, String format, String splitServiceCode) throws Exception{
	try{
		
		int i= searchEDISubmitter( name, id); 
		
		if (i==0){
		wait.until(ExpectedConditions.visibilityOfElementLocated(EDISubmitterAddLink));
		driver.findElement(EDISubmitterAddLink).click();
		System.out.println("clicked add");
		Log.info("log4j - msg- clicked add");

		
		wait.until(ExpectedConditions.visibilityOfElementLocated(EDISubmittersAddNameInput));
		driver.findElement(EDISubmittersAddNameInput).sendKeys(name);
		System.out.println("entered name");
		Log.info("log4j - msg- entered name");
	 Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(EDISUbmittersAddUniqueIDInput));
		driver.findElement(EDISUbmittersAddUniqueIDInput).sendKeys(id);
		System.out.println("entered unique id");
		Log.info("log4j - msg- entered unique id");
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(EDISubmittersSaveLink));
		driver.findElement(EDISubmittersSaveLink).click();
		System.out.println("clicked Save");
		Log.info("log4j - msg- clicked Save");
		Thread.sleep(1000);
		
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit();
		
		
		} else{System.out.println("Submitter already present"); Log.info("Submitter already present"); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit(); 

		}
		
		}
catch(Exception e){System.out.println("error in add EDI Submitters"); Log.info("error in add EDI Submitters"); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
driver.quit();

}
}





public void editEDISubmitter( String name, String id, String definition, String format, String splitServiceCode) throws Exception{
	try{
		
		int i= searchEDISubmitter( name, id); 
		
		if (i==1){
		wait.until(ExpectedConditions.visibilityOfElementLocated(EDISubmittersEditLink));
		driver.findElement(EDISubmittersEditLink).click();
		System.out.println("clicked edit");
		Log.info("log4j - msg- clicked edit");
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(EDISubmittersAddDetailsButton));
		driver.findElement(EDISubmittersAddDetailsButton).click();
		System.out.println("clicked add details");
		Log.info("log4j - msg- clicked add details");
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(EDISubmittersSaveLink));
		driver.findElement(EDISubmittersSaveLink).click();
		System.out.println("clicked save");
		Log.info("log4j - msg- clicked save");
		Thread.sleep(1000);
		 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		 driver.quit(); 
		
		
		}
		else{
			System.out.println("Submitter not found"); Log.info("Submitter not found");
			
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
			driver.quit();
			
			}
		
	}
catch(Exception e){System.out.println("error in edit EDI Submitters"); Log.info("error in edit EDI Submitters");BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
driver.quit(); 

}
}

public void copyEDISubmitter( String name, String id, String newName ,String newID) throws Exception{
	try{
		
int i= searchEDISubmitter( name, id); 
		
		if (i==1){
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(EDISubmittersCopyLink));
		driver.findElement(EDISubmittersCopyLink).click();
		System.out.println("clicked copy");
		Log.info("log4j - msg- clicked copy");
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(EDISubmittersAddNameInput));
		driver.findElement(EDISubmittersAddNameInput).clear();
		driver.findElement(EDISubmittersAddNameInput).sendKeys(newName);
		System.out.println("entered new name");
		Log.info("log4j - msg- entered  new name");
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(EDISUbmittersAddUniqueIDInput));
		driver.findElement(EDISUbmittersAddUniqueIDInput).clear();
		driver.findElement(EDISUbmittersAddUniqueIDInput).sendKeys(newID);
		System.out.println("entered new unique id");
		Log.info("log4j - msg- entered new unique id");
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(EDISubmittersSaveLink));
		driver.findElement(EDISubmittersSaveLink).click();
		System.out.println("clicked Save");
		Log.info("log4j - msg- clicked Save");
		Thread.sleep(1000);
		
		 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
		 driver.quit(); 
		
		
		
}else{
	System.out.println("Submitter not found"); Log.info("Submitter not found");
	
	BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
	driver.quit();

	}
	}
	
catch(Exception e){System.out.println("error in copy  EDI Submitters"); Log.info("error in copy EDI Submitters"); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
driver.quit(); 
}
}






public void deleteEDISubmitter( String name, String id) throws Exception{	try{
		
int i= searchEDISubmitter(name, id); 
		
		if (i==1){
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(EDISubmittersDeleteLink));
		driver.findElement(EDISubmittersDeleteLink).click();
		System.out.println("clicked delete");
		Log.info("log4j - msg- clicked delete");

		wait.until(ExpectedConditions.visibilityOfElementLocated(EDISubmittersConfirmDeleteButton));
		driver.findElement(EDISubmittersConfirmDeleteButton).click();
		System.out.println("clicked confirm delete");
		Log.info("log4j - msg- clicked confirm delete");
Thread.sleep(1000);
		
		
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit();
		
		
		} else{
			System.out.println("Submitter not found"); Log.info("Submitter not found");
			
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
			driver.quit();
		
			}
		
		}
catch(Exception e){System.out.println("error in delete EDI Submitters"); Log.info("error in delete EDI Submitters");  BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
driver.quit(); 

}
}




public void addCommEDISubmitter( String name, String id, String subject, String noteType, String details) throws Exception{
	try{
		
int i= searchEDISubmitter( name, id); 
		
		if (i==1){
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(EDISubmittersCommLink));
		driver.findElement(EDISubmittersCommLink).click();
		System.out.println("clicked Comm");
		Log.info("log4j - msg- clicked Comm");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")));
        driver.findElement(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")).click();
                                        
        System.out.println("clicked Add");
        Log.info("log4j msg- clicked Add");
                                        
        //enter subject
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtSubject']")));
        driver.findElement(By.xpath("//input[@id='txtSubject']")).sendKeys(subject);
        System.out.println("entered subject");
        Log.info("log4j msg- entered subject");
                                        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtFollowup']")));
        driver.findElement(By.xpath("//input[@id='txtFollowup']")).sendKeys(Keys.PAGE_DOWN);
        System.out.println("clicked page down");
        Log.info("log4j msg- clicked page down");
                                        
        //click add details
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-ng-click='addChildRecord()']")));
        driver.findElement(By.xpath("//button[@data-ng-click='addChildRecord()']")).click();
        System.out.println("clicked add details");
        Log.info("log4j msg- clicked add details");
        Thread.sleep(1000);
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlNoteType"))); 
        Select type = new Select(driver.findElement(By.xpath("//select[@id='ddlNoteType']")));
        type.selectByVisibleText(noteType);
        System.out.println("selected note type");
        Log.info("log4j msg-selected note type");
                                        
        Thread.sleep(1000);
        //enter note details
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='txtNotes']")));
        driver.findElement(By.xpath("//textarea[@id='txtNotes']")).sendKeys(details);
        System.out.println("entered notes details");
        Log.info("log4j msg- entered notes details");
        Thread.sleep(1000);
                                        
                                        
        //click hide
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-ng-click='closeMe()']")));
        driver.findElement(By.xpath("//button[@data-ng-click='closeMe()']")).click();
        System.out.println("clicked hide");
        Log.info("log4j msg- clicked hide");
                                        
        //click close case
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-ng-click='closeCase()']")));
        driver.findElement(By.xpath("//button[@data-ng-click='closeCase()']")).click();
        System.out.println("clicked close case");
        Log.info("log4j msg- clicked close case");
                                        
        //click save
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Save")));
        driver.findElement(By.linkText("Save")).click();
        System.out.println("clicked save");
        Log.info("log4j msg- clicked save");
        Thread.sleep(2000);
                                        
        BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
        driver.quit(); 
 	
		}
		else{
			System.out.println("Submitter not found"); Log.info("Submitter not found");
			
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
			driver.quit();
	
			}
	}
catch(Exception e){e.printStackTrace(); System.out.println("error in Add Comm EDI Submitters"); Log.info("error in Add Comm EDI Submitters");  BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
driver.quit(); 

}
}


public void exitEDISubmitter( String name, String id) throws Exception{
	try{
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(EDISubmittersExitLink));
		driver.findElement(EDISubmittersExitLink).click();
		System.out.println("clicked exit");
		Log.info("log4j - msg- clicked exit");
		Thread.sleep(1000);
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit(); 
		
}
catch(Exception e){ System.out.println("error in exit EDI Submitters"); Log.info("error in exit EDI Submitters");  BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
driver.quit();

}
}





}

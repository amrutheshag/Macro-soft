package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BrowserUtils;
import utility.Log;

public class UMDegreesofClinicalUrgency {

	WebDriver driver;
	WebDriverWait wait ;  
	
   	By UMDegreesofClinicalUrgencyAddLink= By.linkText("Add");

	By UMDegreesofClinicalUrgencyCodeInput = By.xpath("//input[@id='code']");

	By UMDegreesofClinicalUrgencyDescriptionInput= By.xpath("//input[@id='name']");

	By UMDegreesofClinicalUrgencyRecordMark= By.xpath("//input[@style='width:20px;']");

	By UMDegreesofClinicalUrgencyValidateLink =By.linkText("Validate");

	By UMDegreesofClinicalUrgencyValidateSaveOKButton= By.xpath("//button[@data-bb-handler='Success']");

	By UMDegreesofClinicalUrgencySaveLink =  By.linkText("Save");

	By UMDegreesofClinicalUrgencyEditLink = By.linkText("Edit");

	By UMDegreesofClinicalUrgencyCopyLink = By.linkText("Copy");

	By UMDegreesofClinicalUrgencyDeleteLink= By.linkText("Delete");
	
	By confirmDeleteButton= By.xpath("//button[@data-bb-handler='Success']");

	By UMDegreesofClinicalUrgencyCommLink= By.linkText("Commun.");

	By UMDegreesofClinicalUrgencyExitLink=  By.linkText("Exit");




	public UMDegreesofClinicalUrgency(WebDriver driver){
        this.driver= driver;
        this.wait= new WebDriverWait(driver, 35);  
}



	 //add function
	    public void addUMDegreesofClinicalUrgency( String umdegreesofclinicalUrgencyCode, String umdegreesofclinicalUrgencyDescription)throws Exception{
	    
	                    try{ 
	                    wait.until(ExpectedConditions.visibilityOfElementLocated(UMDegreesofClinicalUrgencyAddLink));
	                    driver.findElement(UMDegreesofClinicalUrgencyAddLink).click();
	                    System.out.println("clicked Add");
	                    Log.info("log4j msg- clicked Add");
	                    
	                    
	                    System.out.println("um degrees of clinical urgency code: "+umdegreesofclinicalUrgencyCode);
	                    Log.info("log4j msg- um degrees of clinical urgency code: "+umdegreesofclinicalUrgencyCode);
	                    //enter code
	                    wait.until(ExpectedConditions.visibilityOfElementLocated(UMDegreesofClinicalUrgencyCodeInput));
	                    driver.findElement(UMDegreesofClinicalUrgencyCodeInput).sendKeys(umdegreesofclinicalUrgencyCode);
	                    Thread.sleep(1000);
	                    System.out.println("Entered code");
	                    Log.info("log4j msg- Entered code");
	                    
	                    System.out.println("um degrees of clinical urgency description"+umdegreesofclinicalUrgencyDescription);
	                    Log.info("log4j msg- um degrees of clinical urgency description"+umdegreesofclinicalUrgencyDescription);
	                    //enter Description
	                    wait.until(ExpectedConditions.visibilityOfElementLocated(UMDegreesofClinicalUrgencyDescriptionInput));
	                    driver.findElement(UMDegreesofClinicalUrgencyDescriptionInput).sendKeys(umdegreesofclinicalUrgencyDescription);
	                    Thread.sleep(1000);
	                    System.out.println("Entered description");
	                    Log.info("log4j msg- Entered description");
	    
	                    
	                    //click validate
	    
	                    
	                    wait.until(ExpectedConditions.visibilityOfElementLocated(UMDegreesofClinicalUrgencyValidateLink));
	                    driver.findElement(UMDegreesofClinicalUrgencyValidateLink).click();
	                    System.out.println("clicked validate");
	                    Log.info("log4j msg- clicked validate");
	                    
	                    //click ok
	                    
	                    wait.until(ExpectedConditions.visibilityOfElementLocated(UMDegreesofClinicalUrgencyValidateSaveOKButton));
	                    driver.findElement(UMDegreesofClinicalUrgencyValidateSaveOKButton).click();
	                    System.out.println("clicked validate ok to save button");
	                    Log.info("log4j msg- clicked validate ok to save button");
	                    
	                    
	                    //click save
	                    Thread.sleep(1000);
	                    
	                    wait.until(ExpectedConditions.visibilityOfElementLocated(UMDegreesofClinicalUrgencySaveLink));
	                    driver.findElement(UMDegreesofClinicalUrgencySaveLink).click();
	                    System.out.println("clicked save ");
	                    Log.info("log4j msg- clicked  save ");
	                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
	                    
	                    }catch (Exception e){e.printStackTrace();System.out.println("Error in Adding UM Degrees of Clinical Urgency ");
	                    Log.info("log4j msg- Error in Adding UM Degrees of Clinical Urgency "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}
	                    
	    }
	    
	    //copy function
	    
	    public void copyUMDegreesofClinicalUrgency( String umdegreesofclinicalUrgencyCode, String newumdegreesofclinicalUrgencyCode, String newUMDegreesofClinicalUrgencyDescription)throws Exception{
	                    
	                    try{ 
	                    System.out.println("um degrees of clinical urgency code"+umdegreesofclinicalUrgencyCode);
	                    Log.info("log4j msg- um degrees of clinical urgency code"+umdegreesofclinicalUrgencyCode);
	                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+umdegreesofclinicalUrgencyCode+"']")));
	                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+umdegreesofclinicalUrgencyCode+"']")).click();
	                    System.out.println("clicked um degrees of clinical urgency Code");
	                    Log.info("log4j msg- clicked um degrees of clinical urgency code");
	                    
	                    
	                    
	                    wait.until(ExpectedConditions.visibilityOfElementLocated(UMDegreesofClinicalUrgencyCopyLink));
	                    driver.findElement(UMDegreesofClinicalUrgencyCopyLink).click();
	                    System.out.println("clicked Copy");
	                    Log.info("log4j msg- clicked Copy");
	                    
	                    System.out.println("um degrees of clinical urgency new code"+newumdegreesofclinicalUrgencyCode);
	                    Log.info("log4j msg- um degrees of clinical urgency new code"+newumdegreesofclinicalUrgencyCode);
	                    //enter new code
	                    wait.until(ExpectedConditions.visibilityOfElementLocated(UMDegreesofClinicalUrgencyCodeInput));
	                    driver.findElement(UMDegreesofClinicalUrgencyCodeInput).clear();
	                    driver.findElement(UMDegreesofClinicalUrgencyCodeInput).sendKeys(newumdegreesofclinicalUrgencyCode);
	                    System.out.println("Entered new code");
	                    Log.info("log4j msg- Entered new code");
	    
	                    System.out.println("um degrees of clinical urgency new description"+newUMDegreesofClinicalUrgencyDescription);
	                    Log.info("log4j msg- um degrees of clinical urgency new description"+newUMDegreesofClinicalUrgencyDescription);
	    //enter new description
	                    Thread.sleep(1000);
	                    wait.until(ExpectedConditions.visibilityOfElementLocated(UMDegreesofClinicalUrgencyDescriptionInput));
	                    driver.findElement(UMDegreesofClinicalUrgencyDescriptionInput).clear();
	                    driver.findElement(UMDegreesofClinicalUrgencyDescriptionInput).sendKeys(newUMDegreesofClinicalUrgencyDescription);
	                    System.out.println("Entered new description");
	                    Log.info("log4j msg- Entered new description");
	                    
	                    
	                    
	                    
	                    Thread.sleep(1000);
	                    
	                    //click save
	                    wait.until(ExpectedConditions.visibilityOfElementLocated(UMDegreesofClinicalUrgencySaveLink));
	                    driver.findElement(UMDegreesofClinicalUrgencySaveLink).click();
	                    
	                    Thread.sleep(1000);

	                    System.out.println("Clicked save");
	                    Log.info("log4j msg- clicked save");
	                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
	                    
	                    Thread.sleep(1000);
	                      }catch (Exception e){ e.printStackTrace();System.out.println("Error in Copying UM Degrees of Clinical Urgency ");
	                    Log.info("log4j msg- Error in Copying UM Degrees of Clinical Urgency "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}
	    
	    
	    }
	    
	    
	    
	    //edit function
	public void editUMDegreesofClinicalUrgency( String umdegreesofclinicalUrgencyCode,String UMDegreesofClinicalUrgencyDescription, String recordMark)throws Exception{
	                    
	                    try{
	                    System.out.println("um degrees of clinical urgency code"+umdegreesofclinicalUrgencyCode);
	                    Log.info("log4j msg- um degrees of clinical urgency code"+umdegreesofclinicalUrgencyCode);
	                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+umdegreesofclinicalUrgencyCode+"']")));
	                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+umdegreesofclinicalUrgencyCode+"']")).click();
	                    System.out.println("clicked UM Degrees of Clinical Urgency");
	                    Log.info("log4j msg- clicked UM Degrees of Clinical Urgency");
	                    
	                    
	                    
	                    wait.until(ExpectedConditions.visibilityOfElementLocated(UMDegreesofClinicalUrgencyEditLink));
	                    driver.findElement(UMDegreesofClinicalUrgencyEditLink).click();
	                    System.out.println("clicked Edit");
	                    Log.info("log4j msg- clicked Edit");
	                    
	                    System.out.println("um degrees of clinical urgency Record Mark"+recordMark);
	                    Log.info("log4j msg- um degrees of clinical urgency Record Mark"+recordMark);
	                    		          
	    //enter new Record Mark
	                    
	                    wait.until(ExpectedConditions.visibilityOfElementLocated(UMDegreesofClinicalUrgencyRecordMark));
	                   driver.findElement(UMDegreesofClinicalUrgencyRecordMark).clear();
	                    Thread.sleep(1000);
	                    driver.findElement(UMDegreesofClinicalUrgencyRecordMark).sendKeys(recordMark);
	                    System.out.println("Entered new Record Mark");
	                    Log.info("log4j msg- Entered new Record Mark");
	                    
	                    
	                    
	                    
	                    
	                    //click save
	                    wait.until(ExpectedConditions.visibilityOfElementLocated(UMDegreesofClinicalUrgencySaveLink));
	                    driver.findElement(UMDegreesofClinicalUrgencySaveLink).click();
	                    System.out.println("Clicked save");
	                    Log.info("log4j msg- clicked save");
	                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
	                    
	                    
	                    }catch (Exception e){ e.printStackTrace();System.out.println("Error in Editing UM Degrees of Clinical Urgency ");
	                    Log.info("log4j msg- Error in Editing UM Degrees of Clinical Urgency "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}
	    
	    
	    }
	    //exit function
	    public void exitUMDegreesofClinicalUrgency( String umdegreesofclinicalUrgencyCode) throws Exception{
	    try{
	                    System.out.println("um degrees of clinical urgency code"+umdegreesofclinicalUrgencyCode);
	                    Log.info("log4j msg- um degrees of clinical urgency code"+umdegreesofclinicalUrgencyCode);
	                                    Thread.sleep(1000);
	                                    driver.findElement(UMDegreesofClinicalUrgencyExitLink).click();
	                                    Thread.sleep(1000);
	                                    System.out.println("Clicked exit in  UM Degrees of Clinical Urgency ");
	                                    Log.info("log4j msg- clicked exit in  UM Degrees of Clinical Urgency "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
	                                  
	    }catch (Exception e){ e.printStackTrace();System.out.println("Error in Exiting UM Degrees of Clinical Urgency ");
	    Log.info("log4j msg- Error in Exiting UM Degrees of Clinical Urgency "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}
	    }
	    
	    
	    //add comm function
	    public void addCommUMDegreesofClinicalUrgency( String umdegreesofclinicalUrgencyCode, String subject, String NoteType, String medium, String notes) throws Exception{
	                    
	                    try{ System.out.println("um degrees of clinical urgency code"+umdegreesofclinicalUrgencyCode);
	                    Log.info("log4j msg- um degrees of clinical urgency code"+umdegreesofclinicalUrgencyCode);
	                                    //find um degrees of clinical urgency
	                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+umdegreesofclinicalUrgencyCode+"']")));
	                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+umdegreesofclinicalUrgencyCode+"']")).click();
	                    System.out.println("clicked UM Degrees of Clinical Urgency Code");
	                    Log.info("log4j msg- clicked UM Degrees of Clinical Urgency code");
	                    
	                                                    //click comm
	                                                    
	                    wait.until(ExpectedConditions.visibilityOfElementLocated(UMDegreesofClinicalUrgencyCommLink));
	                    driver.findElement(UMDegreesofClinicalUrgencyCommLink).click();
	                    System.out.println("clicked Comm");
	                    Log.info("log4j msg- clicked Comm");

	                                                    
	                                                    
	                                                    //click add
	                                                    
	                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")));
	                                                    driver.findElement(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")).click();
	                                                    
	                                                      System.out.println("clicked Add");
	                                                    Log.info("log4j msg- clicked Add");
	                                                    
	                                                    //enter subject
	                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtSubject']")));
	                                                    driver.findElement(By.xpath("//input[@id='txtSubject']")).sendKeys(subject);
	                                                    System.out.println("entered subject");
	                                                    Log.info("log4j msg- entered subject");
	                                                    
	                                                    
	                                                    //page down
	                                                   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtFollowup']")));
	                                                    driver.findElement(By.xpath("//input[@id='txtFollowup']")).sendKeys(Keys.PAGE_DOWN);
	                                                    System.out.println("clicked page down");
	                                                    Log.info("log4j msg- clicked page down");
	                                                    
	                                                    
	                                                    
	                                                    
	                                                    //click add details
	                                                   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-ng-click='addChildRecord()']")));
	                                                    driver.findElement(By.xpath("//button[@data-ng-click='addChildRecord()']")).click();
	                                                    System.out.println("clicked add details");
	                                                    Log.info("log4j msg- clicked add details");
	                                                    
	                                                    Thread.sleep(5000);
	                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='ddlNoteType']")));
	                                                    
	                                                    Thread.sleep(3000);
	                                                    Select placeOfService = new Select(driver.findElement(By.xpath("//select[@id='ddlNoteType']")));
	                                                   
	                                                    Thread.sleep(4000);
	                                                    placeOfService.selectByVisibleText(NoteType);
	                                                    System.out.println("selected note type");
	                                                    Log.info("log4j msg-selected note type");
	                                                    
	                                                    Thread.sleep(1000);
	                                                    //enter note details
	                                                   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='txtNotes']")));
	                                                    driver.findElement(By.xpath("//textarea[@id='txtNotes']")).sendKeys(notes);
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
	                                                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
	                                                    driver.quit();
	                                                    
	                                    } catch (Exception e){
	                                    	e.printStackTrace();
	                                    	System.out.println("Error in adding Comm to UM Degrees of Clinical Urgency");
	                                        Log.info("log4j msg - Error in adding Comm to  UM Degrees of Clinical Urgency"); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
	                    driver.quit();      
	                    }
	    }

	    
	    
	
	    //delete function
	    public void deleteUMDegreesofClinicalUrgency( String umdegreesofclinicalUrgencyCode) throws Exception{
	                    
	                    try{
	                    //find UM Degrees of Clinical Urgency
	                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+umdegreesofclinicalUrgencyCode+"']")));
	                                                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+umdegreesofclinicalUrgencyCode+"']")).click();
	                                                    System.out.println("clicked UM Degrees of Clinical Urgency Code");
	                                                    Log.info("log4j msg- clicked UM Degrees of Clinical Urgency code");
	                                    
	                                                    //click delete
	                                                    
	                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(UMDegreesofClinicalUrgencyDeleteLink));
	                                                    driver.findElement(UMDegreesofClinicalUrgencyDeleteLink).click();
	                                                    System.out.println("clicked Delete");
	                                                    Log.info("log4j msg- clicked Delete");
	                                                    
	                    
	                                                    //click confirm delete
	                                                    
	                                                    
	                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(confirmDeleteButton));
	                                                    driver.findElement(confirmDeleteButton).click();
	                                                    System.out.println("clicked confirm Delete");
	                                                    Log.info("log4j msg- clicked confirm Delete");
	                                                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
	                                                    
	                                                    
	                    
	    } catch (Exception e){System.out.println("Error in deleting UM Degrees of Clinical Urgency");
	                         Log.info("log4j msg - Error in deleting UM Degrees of Clinical Urgency"); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
	                    }
	}

	    
	    
	    
	    
	    
	    
	    
	    
	    
	 
	}


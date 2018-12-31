package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BrowserUtils;
import utility.Log;

public class OfficeTypes {
	
	WebDriver driver;
	WebDriverWait wait ;  
	
  	By OfficeTypesAddLink= By.linkText("Add");
	
	By OfficeTypesCodeInput = By.xpath("//input[@id='code']");
	
	By OfficeTypesDescriptionInput= By.xpath("//input[@id='name']");

	By OfficeTypesRecordMark= By.xpath("//input[@style='width:20px;']");

	By OfficeTypesValidateLink =By.linkText("Validate");

	By OfficeTypesValidateSaveOKButton= By.xpath("//button[@data-bb-handler='Success']");

	By OfficeTypesSaveLink =  By.linkText("Save");

	By OfficeTypesEditLink = By.linkText("Edit");

	By OfficeTypesCopyLink = By.linkText("Copy");

	By OfficeTypesDeleteLink= By.linkText("Delete");
	
	By confirmDeleteButton= By.xpath("//button[@data-bb-handler='Success']");

	By OfficeTypesCommLink= By.linkText("Commun.");

	

	By OfficeTypesExitLink=  By.linkText("Exit");




	 public OfficeTypes(WebDriver driver){
         this.driver= driver;
         this.wait= new WebDriverWait(driver, 35);  
}



	 //add function
	    public void addOfficeTypes( String officeTypesCode, String officeTypesDescription)throws Exception{
	    
	                    try{ 
	                    
	                    wait.until(ExpectedConditions.visibilityOfElementLocated(OfficeTypesAddLink));
	                    driver.findElement(OfficeTypesAddLink).click();
	                    System.out.println("clicked Add");
	                    Log.info("log4j msg- clicked Add");
	                    
	                    
	                    System.out.println("office types code: "+officeTypesCode);
	                    Log.info("log4j msg- office types code: "+officeTypesCode);
	                    //enter code
	                    wait.until(ExpectedConditions.visibilityOfElementLocated(OfficeTypesCodeInput));
	                    driver.findElement(OfficeTypesCodeInput).sendKeys(officeTypesCode);
	                    Thread.sleep(1000);
	                    System.out.println("Entered code");
	                    Log.info("log4j msg- Entered code");
	                    
	                    System.out.println("office types description: "+officeTypesDescription);
	                    Log.info("log4j msg- office types description: "+officeTypesDescription);
	                    //enter Description
	                    wait.until(ExpectedConditions.visibilityOfElementLocated(OfficeTypesDescriptionInput));
	                    driver.findElement(OfficeTypesDescriptionInput).sendKeys(officeTypesDescription);
	                    Thread.sleep(1000);
	                    System.out.println("Entered description");
	                    Log.info("log4j msg- Entered description");
	    
	                    
	                    //click validate
	    
	                    
	                    wait.until(ExpectedConditions.visibilityOfElementLocated(OfficeTypesValidateLink));
	                    driver.findElement(OfficeTypesValidateLink).click();
	                    System.out.println("clicked validate");
	                    Log.info("log4j msg- clicked validate");
	                    
	                    //click ok
	                    
	                    wait.until(ExpectedConditions.visibilityOfElementLocated(OfficeTypesValidateSaveOKButton));
	                    driver.findElement(OfficeTypesValidateSaveOKButton).click();
	                    System.out.println("clicked validate ok to save button");
	                    Log.info("log4j msg- clicked validate ok to save button");
	                    
	                    
	                    //click save
	                    Thread.sleep(1000);
	                    
	                    wait.until(ExpectedConditions.visibilityOfElementLocated(OfficeTypesSaveLink));
	                    driver.findElement(OfficeTypesSaveLink).click();
	                    System.out.println("clicked save ");
	                    Log.info("log4j msg- clicked  save ");
	                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
	                    
	                    }catch (Exception e){e.printStackTrace();System.out.println("Error in Adding Office Types ");
	                    Log.info("log4j msg- Error in Adding Office Types "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}
	                    
	    }
	    
	    //copy function
	    
	    public void copyOfficeTypes( String officeTypesCode, String newofficeTypesCode, String newOfficeTypesDescription)throws Exception{
	                    
	                    try{ 
	                    System.out.println("office types code"+officeTypesCode);
	                    Log.info("log4j msg- office types code"+officeTypesCode);
	                   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+officeTypesCode+"']")));
	                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+officeTypesCode+"']")).click();
	                    System.out.println("clicked office types Code");
	                    Log.info("log4j msg- clicked office types code");
	                    
	                    
	                    
	                    wait.until(ExpectedConditions.visibilityOfElementLocated(OfficeTypesCopyLink));
	                    driver.findElement(OfficeTypesCopyLink).click();
	                    System.out.println("clicked Copy");
	                    Log.info("log4j msg- clicked Copy");
	                    
	                    System.out.println("office types new code: "+newofficeTypesCode);
	                    Log.info("log4j msg- office types new code: "+newofficeTypesCode);
	                    //enter new code
	                    wait.until(ExpectedConditions.visibilityOfElementLocated(OfficeTypesCodeInput));
	                    driver.findElement(OfficeTypesCodeInput).clear();
	                    driver.findElement(OfficeTypesCodeInput).sendKeys(newofficeTypesCode);
	                    System.out.println("Entered new code");
	                    Log.info("log4j msg- Entered new code");
	    
	                    System.out.println("office types new description: "+newOfficeTypesDescription);
	                    Log.info("log4j msg- office types new description: "+newOfficeTypesDescription);
	    //enter new description
	                    Thread.sleep(1000);
	                    wait.until(ExpectedConditions.visibilityOfElementLocated(OfficeTypesDescriptionInput));
	                    driver.findElement(OfficeTypesDescriptionInput).clear();
	                    driver.findElement(OfficeTypesDescriptionInput).sendKeys(newOfficeTypesDescription);
	                    System.out.println("Entered new description");
	                    Log.info("log4j msg- Entered new description");
	                    
	                    
	                    
	                    
	                    Thread.sleep(1000);
	                    
	                    //click save
	                    wait.until(ExpectedConditions.visibilityOfElementLocated(OfficeTypesSaveLink));
	                    driver.findElement(OfficeTypesSaveLink).click();
	                    
	                    Thread.sleep(1000);

	                    System.out.println("Clicked save");
	                    Log.info("log4j msg- clicked save");
	                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
	                    
	                    Thread.sleep(1000);
	                    
	                    
	                    
	                    
	                    
	                    
	                    }catch (Exception e){ e.printStackTrace();System.out.println("Error in Copying Office Types ");
	                    Log.info("log4j msg- Error in Copying Office Types "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}
	    
	    
	    }
	    
	    
	    
	    //edit function
	public void editOfficeTypes( String officeTypesCode,String OfficeTypesDescription, String recordMark)throws Exception{
	                    
	                    try{ 
	                    System.out.println("office types code: "+officeTypesCode);
	                    Log.info("log4j msg- office types code: "+officeTypesCode);
	                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+officeTypesCode+"']")));
	                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+officeTypesCode+"']")).click();
	                    System.out.println("clicked Office Types");
	                    Log.info("log4j msg- clicked Office Types");
	                    
	                    
	                    
	                    wait.until(ExpectedConditions.visibilityOfElementLocated(OfficeTypesEditLink));
	                    driver.findElement(OfficeTypesEditLink).click();
	                    System.out.println("clicked Edit");
	                    Log.info("log4j msg- clicked Edit");
	                    
	                    System.out.println("office types Record Mark: "+recordMark);
	                    Log.info("log4j msg- office types Record Mark: "+recordMark);
	                    		          
	    //enter new Record Mark
	                    
	                    wait.until(ExpectedConditions.visibilityOfElementLocated(OfficeTypesRecordMark));
	                   driver.findElement(OfficeTypesRecordMark).clear();
	                    Thread.sleep(1000);
	                    driver.findElement(OfficeTypesRecordMark).sendKeys(recordMark);
	                    System.out.println("Entered new Record Mark");
	                    Log.info("log4j msg- Entered new Record Mark");
	                    
	                    
	                    
	                    
	                    
	                    //click save
	                    wait.until(ExpectedConditions.visibilityOfElementLocated(OfficeTypesSaveLink));
	                    driver.findElement(OfficeTypesSaveLink).click();
	                    System.out.println("Clicked save");
	                    Log.info("log4j msg- clicked save");
	                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
	                    
	                    
	                    }catch (Exception e){ e.printStackTrace();System.out.println("Error in Editing Office Types ");
	                    Log.info("log4j msg- Error in Editing Office Types "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}
	    
	    
	    }
	    //exit function
	    public void exitOfficeTypes( String officeTypesCode) throws Exception{
	    try{System.out.println("office types code"+officeTypesCode);
	                    Log.info("log4j msg- office types code"+officeTypesCode);
	                                    Thread.sleep(1000);
	                                    driver.findElement(OfficeTypesExitLink).click();
	                                    Thread.sleep(1000);
	                                    System.out.println("Clicked exit in  Office Types ");
	                                    Log.info("log4j msg- clicked exit in  Office Types "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
	                                
	    }catch (Exception e){ e.printStackTrace();System.out.println("Error in Exiting Office Types ");
	    Log.info("log4j msg- Error in Exiting Office Types "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}
	    }
	    
	    
	    //add comm function
	    public void addCommOfficeTypes( String officeTypesCode, String subject, String NoteType, String medium, String notes) throws Exception{
	                    
	                    try{    
	                    System.out.println("office types code: "+officeTypesCode);
	                    Log.info("log4j msg- office types code: "+officeTypesCode);
	                                    //find office types
	                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+officeTypesCode+"']")));
	                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+officeTypesCode+"']")).click();
	                    System.out.println("clicked Office Types Code");
	                    Log.info("log4j msg- clicked Office Types code");
	                    
	                                                    //click comm
	                                                    
	                    wait.until(ExpectedConditions.visibilityOfElementLocated(OfficeTypesCommLink));
	                    driver.findElement(OfficeTypesCommLink).click();
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
	                                                    
	                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='ddlNoteType']")));
	                                                    Select placeOfService = new Select(driver.findElement(By.xpath("//select[@id='ddlNoteType']")));
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
	                                                    
	                                    } catch (Exception e){e.printStackTrace();System.out.println("Error in adding Comm to Office Types");
	                                                                                                                    Log.info("log4j msg - Error in adding Comm to  Office Types"); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
	                    driver.quit();      
	                    }
	    }

	    
	    
	    
	    
	    //delete function
	    public void deleteOfficeTypes( String officeTypesCode) throws Exception{
	                    
	                    try{         
	                    //find Office Types
	                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+officeTypesCode+"']")));
	                                                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+officeTypesCode+"']")).click();
	                                                    System.out.println("clicked Office Types Code");
	                                                    Log.info("log4j msg- clicked Office Types code");
	                                    
	                                                    //click delete
	                                                    
	                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(OfficeTypesDeleteLink));
	                                                    driver.findElement(OfficeTypesDeleteLink).click();
	                                                    System.out.println("clicked Delete");
	                                                    Log.info("log4j msg- clicked Delete");
	                                                    
	                    
	                                                    //click confirm delete
	                                                    
	                                                    
	                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(confirmDeleteButton));
	                                                    driver.findElement(confirmDeleteButton).click();
	                                                    System.out.println("clicked confirm Delete");
	                                                    Log.info("log4j msg- clicked confirm Delete");
	                                                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
	                                                    
	                                                    
	                    
	    } catch (Exception e){
	    	System.out.println("Error in deleting Office Types");
	    	Log.info("log4j msg - Error in deleting Office Types"); 
	    	BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
	    	driver.quit();
            }
	}

	    
	}


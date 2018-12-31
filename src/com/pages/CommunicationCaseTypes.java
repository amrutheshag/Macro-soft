package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BrowserUtils;
import utility.Log;

public class CommunicationCaseTypes {

	WebDriver driver;
	WebDriverWait wait;
    
	By CommunicationCaseTypesAddLink= By.linkText("Add");
	
	By CommunicationCaseTypesCodeInput = By.xpath("//input[@id='code']");

	By CommunicationCaseTypesDescriptionInput= By.xpath("//input[@id='name']");

	By CommunicationCaseTypesRecordMark= By.xpath("//input[@style='width:20px;']");

	By CommunicationCaseTypesValidateLink =By.linkText("Validate");

	By CommunicationCaseTypesValidateSaveOKButton= By.xpath("//button[@data-bb-handler='Success']");

	By CommunicationCaseTypesSaveLink =  By.linkText("Save");

	By CommunicationCaseTypesEditLink = By.linkText("Edit");

	By CommunicationCaseTypesCopyLink = By.linkText("Copy");

	By CommunicationCaseTypesDeleteLink= By.linkText("Delete");
	
	By confirmDeleteButton= By.xpath("//button[@data-bb-handler='Success']");

	By CommunicationCaseTypesCommLink= By.linkText("Commun.");

	By CommunicationCaseTypesExitLink=  By.linkText("Exit");




	public CommunicationCaseTypes(WebDriver driver){
        this.driver= driver;
        this.wait = new WebDriverWait(driver, 45);
}



	 //add function
    public void addCommunicationCaseTypes( String ommunicationcaseTypesCode, String ommunicationcaseTypesDescription)throws Exception{
    
                    try{ 
                    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(CommunicationCaseTypesAddLink));
                    driver.findElement(CommunicationCaseTypesAddLink).click();
                    System.out.println("clicked Add");
                    Log.info("log4j msg- clicked Add");
                    
                    
                    System.out.println("communication case types code: "+ommunicationcaseTypesCode);
                    Log.info("log4j msg- communication case types code: "+ommunicationcaseTypesCode);
                    //enter code
                    wait.until(ExpectedConditions.visibilityOfElementLocated(CommunicationCaseTypesCodeInput));
                    driver.findElement(CommunicationCaseTypesCodeInput).sendKeys(ommunicationcaseTypesCode);
                    Thread.sleep(1000);
                    System.out.println("Entered code");
                    Log.info("log4j msg- Entered code");
                    
                    System.out.println("communication case types description"+ommunicationcaseTypesDescription);
                    Log.info("log4j msg- communication case types description"+ommunicationcaseTypesDescription);
                    //enter Description
                    wait.until(ExpectedConditions.visibilityOfElementLocated(CommunicationCaseTypesDescriptionInput));
                    driver.findElement(CommunicationCaseTypesDescriptionInput).sendKeys(ommunicationcaseTypesDescription);
                    Thread.sleep(1000);
                    System.out.println("Entered description");
                    Log.info("log4j msg- Entered description");
    
                    
                    //click validate
    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(CommunicationCaseTypesValidateLink));
                    driver.findElement(CommunicationCaseTypesValidateLink).click();
                    System.out.println("clicked validate");
                    Log.info("log4j msg- clicked validate");
                    
                    //click ok
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(CommunicationCaseTypesValidateSaveOKButton));
                    driver.findElement(CommunicationCaseTypesValidateSaveOKButton).click();
                    System.out.println("clicked validate ok to save button");
                    Log.info("log4j msg- clicked validate ok to save button");
                    
                    
                    //click save
                    Thread.sleep(1000);
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(CommunicationCaseTypesSaveLink));
                    driver.findElement(CommunicationCaseTypesSaveLink).click();
                    System.out.println("clicked save ");
                    Log.info("log4j msg- clicked  save ");
                    Thread.sleep(1000);
                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
                    driver.quit();
                    
                    }catch (Exception e){e.printStackTrace();System.out.println("Error in Adding Communication Case Types ");
                    Log.info("log4j msg- Error in Adding Communication Case Types ");
                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
                    driver.quit();}
                    
    }
    
    //copy function
    
    public void copyCommunicationCaseTypes( String ommunicationcaseTypesCode, String newommunicationcaseTypesCode, String newCommunicationCaseTypesDescription)throws Exception{
                    
                    try{ 
                    
                    System.out.println("communication case types code"+ommunicationcaseTypesCode);
                    Log.info("log4j msg- communication case types code"+ommunicationcaseTypesCode);
                     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ommunicationcaseTypesCode+"']")));
                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ommunicationcaseTypesCode+"']")).click();
                    System.out.println("clicked communication case types Code");
                    Log.info("log4j msg- clicked communication case types code");
                    
                    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(CommunicationCaseTypesCopyLink));
                    driver.findElement(CommunicationCaseTypesCopyLink).click();
                    System.out.println("clicked Copy");
                    Log.info("log4j msg- clicked Copy");
                    
                    System.out.println("communication case types new code"+newommunicationcaseTypesCode);
                    Log.info("log4j msg- communication case types new code"+newommunicationcaseTypesCode);
                    //enter new code
                    wait.until(ExpectedConditions.visibilityOfElementLocated(CommunicationCaseTypesCodeInput));
                    driver.findElement(CommunicationCaseTypesCodeInput).clear();
                    driver.findElement(CommunicationCaseTypesCodeInput).sendKeys(newommunicationcaseTypesCode);
                    System.out.println("Entered new code");
                    Log.info("log4j msg- Entered new code");
    
                    System.out.println("communication case types new description"+newCommunicationCaseTypesDescription);
                    Log.info("log4j msg- communication case types new description"+newCommunicationCaseTypesDescription);
    //enter new description
                    Thread.sleep(1000);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(CommunicationCaseTypesDescriptionInput));
                    driver.findElement(CommunicationCaseTypesDescriptionInput).clear();
                    driver.findElement(CommunicationCaseTypesDescriptionInput).sendKeys(newCommunicationCaseTypesDescription);
                    System.out.println("Entered new description");
                    Log.info("log4j msg- Entered new description");
                    
                    
                    
                    
                    Thread.sleep(1000);
                    
                    //click save
                    wait.until(ExpectedConditions.visibilityOfElementLocated(CommunicationCaseTypesSaveLink));
                    driver.findElement(CommunicationCaseTypesSaveLink).click();
                    
                    Thread.sleep(1000);

                    System.out.println("Clicked save");
                    Log.info("log4j msg- clicked save");
                    Thread.sleep(1000);
                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
                    driver.quit();
                    
                    Thread.sleep(1000);
                    
                    
                    
                    
                    
                    
                    }catch (Exception e){ e.printStackTrace();System.out.println("Error in Copying Communication Case Types ");
                    Log.info("log4j msg- Error in Copying Communication Case Types ");
                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                    driver.quit();
                    }
    
    
    }
    
    
    
    //edit function
public void editCommunicationCaseTypes( String communicationcaseTypesCode,String CommunicationCaseTypesDescription, String recordMark)throws Exception{
                    
                    try{ 
                    
                    System.out.println("communication case types code"+communicationcaseTypesCode);
                    Log.info("log4j msg- communication case types code"+communicationcaseTypesCode);
                     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+communicationcaseTypesCode+"']")));
                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+communicationcaseTypesCode+"']")).click();
                    System.out.println("clicked Communication Case Types");
                    Log.info("log4j msg- clicked Communication Case Types");
                    
                    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(CommunicationCaseTypesEditLink));
                    driver.findElement(CommunicationCaseTypesEditLink).click();
                    System.out.println("clicked Edit");
                    Log.info("log4j msg- clicked Edit");
                    
                    System.out.println("communication case types Record Mark: "+recordMark);
                    Log.info("log4j msg- communication case types Record Mark: "+recordMark);
                    		          
    //enter new Record Mark
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(CommunicationCaseTypesRecordMark));
                   driver.findElement(CommunicationCaseTypesRecordMark).clear();
                    Thread.sleep(1000);
                    driver.findElement(CommunicationCaseTypesRecordMark).sendKeys(recordMark);
                    System.out.println("Entered new Record Mark");
                    Log.info("log4j msg- Entered new Record Mark");
                    
                    
                    
                    
                    
                    //click save
                    wait.until(ExpectedConditions.visibilityOfElementLocated(CommunicationCaseTypesSaveLink));
                    driver.findElement(CommunicationCaseTypesSaveLink).click();
                    System.out.println("Clicked save");
                    Log.info("log4j msg- clicked save");
                    Thread.sleep(1000);
                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                    driver.quit();
                    
                    
                    }catch (Exception e){ e.printStackTrace();System.out.println("Error in Editing Communication Case Types ");
                    Log.info("log4j msg- Error in Editing Communication Case Types "); 
                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
                    driver.quit();
                    }
    
    
    }
    //exit function
    public void exitCommunicationCaseTypes( String ommunicationcaseTypesCode) throws Exception{
    try{
                   
                    System.out.println("communication case types code"+ommunicationcaseTypesCode);
                    Log.info("log4j msg- communication case types code"+ommunicationcaseTypesCode);
                            Thread.sleep(1000);
                                    driver.findElement(CommunicationCaseTypesExitLink).click();
                                    Thread.sleep(1000);
                                    System.out.println("Clicked exit in  Communication Case Types ");
                                    Log.info("log4j msg- clicked exit in  Communication Case Types ");
                                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
                                    driver.quit();
                   
    }catch (Exception e){ e.printStackTrace();System.out.println("Error in Exiting Communication Case Types ");
    Log.info("log4j msg- Error in Exiting Communication Case Types "); 
    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
    driver.quit();
    }
    }
    
    
    //add comm function
    public void addCommCommunicationCaseTypes( String ommunicationcaseTypesCode, String subject, String NoteType, String medium, String notes) throws Exception{
                    
                    try{       
                    System.out.println("communication case types code"+ommunicationcaseTypesCode);
                    Log.info("log4j msg- communication case types code"+ommunicationcaseTypesCode);
                                    //find communication case types
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ommunicationcaseTypesCode+"']")));
                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ommunicationcaseTypesCode+"']")).click();
                    System.out.println("clicked Communication Case Types Code");
                    Log.info("log4j msg- clicked Communication Case Types code");
                    
                                                    //click comm
                                                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(CommunicationCaseTypesCommLink));
                    driver.findElement(CommunicationCaseTypesCommLink).click();
                    System.out.println("clicked Comm");
                    Log.info("log4j msg- clicked Comm");

                                                    
                                                    
                                                  
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
                                                    Thread.sleep(1000);
                                                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
                                                    driver.quit();
                                    
                                                    
                                    } catch (Exception e){e.printStackTrace();System.out.println("Error in adding Comm to Communication Case Types");
                                      Log.info("log4j msg - Error in adding Comm to  Communication Case Types"); 
                                      BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                                      driver.quit();
                           }
    }

    
    
    
    
    //delete function
    public void deleteCommunicationCaseTypes( String ommunicationcaseTypesCode) throws Exception{
                    
                    try{         
                    	
                                    
                    
                    //find Communication Case Types
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ommunicationcaseTypesCode+"']")));
                                                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ommunicationcaseTypesCode+"']")).click();
                                                    System.out.println("clicked Communication Case Types Code");
                                                    Log.info("log4j msg- clicked Communication Case Types code");
                                    
                                                    //click delete
                                                    
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(CommunicationCaseTypesDeleteLink));
                                                    driver.findElement(CommunicationCaseTypesDeleteLink).click();
                                                    System.out.println("clicked Delete");
                                                    Log.info("log4j msg- clicked Delete");
                                                    
                    
                                                    //click confirm delete
                                                    
                                                    
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(confirmDeleteButton));
                                                    driver.findElement(confirmDeleteButton).click();
                                                    System.out.println("clicked confirm Delete");
                                                    Log.info("log4j msg- clicked confirm Delete");
                                                    Thread.sleep(1000);
                                                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
                                                    driver.quit();
                                                    
                    
    } catch (Exception e){System.out.println("Error in deleting Communication Case Types");
      Log.info("log4j msg - Error in deleting Communication Case Types"); 
      BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
      driver.quit();
       }
}

    
    
    
    
    
    
    
    
    
    
 

}


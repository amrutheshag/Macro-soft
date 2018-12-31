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

public class UMReasonsforReferral {

	WebDriver driver;
	WebDriverWait wait;
	
	By UMReasonsforReferralCodeBeginsInput = By.xpath("//input[@id='txtCode']");
	
	By UMReasonsforReferralNameDescriptionBeginsInput = By.xpath("//input[@id='txtName']");
	
	By UMReasonsforReferralSearchButton= By.xpath("//button[@data-ng-click='search(0)']");
    
    By UMReasonsforReferralAddLink= By.linkText("Add");
    
    By UMReasonsforReferralCodeInput = By.xpath("//input[@id='code']");
    
    By UMReasonsforReferralDescriptionInput= By.xpath("//input[@id='name']");
    
    By UMReasonsforReferralRecordMark= By.xpath("//input[@style='width:20px;']");
    
    By UMReasonsforReferralValidateLink =By.linkText("Validate");
    
    By UMReasonsforReferralValidateSaveOKButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By UMReasonsforReferralSaveLink =  By.linkText("Save");
    
    By UMReasonsforReferralEditLink = By.linkText("Edit");
    
    By UMReasonsforReferralCopyLink = By.linkText("Copy");
    
    By UMReasonsforReferralDeleteLink= By.linkText("Delete");
    
    By confirmDeleteButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By UMReasonsforReferralCommLink= By.linkText("Commun.");
    
    By UMReasonsforReferralExitLink=  By.linkText("Exit");
    
    
    
    
    public UMReasonsforReferral(WebDriver driver){
        this.driver= driver;
        this.wait = new WebDriverWait(driver, 35);    
}


public int searchUMReasonsforReferral( String UMReasonsforReferralCode, String UMReasonsforReferralName) throws Exception{

try{
//enter  UM Reasons for Referral code
wait.until(ExpectedConditions.visibilityOfElementLocated(UMReasonsforReferralCodeBeginsInput));
driver.findElement(UMReasonsforReferralCodeBeginsInput).clear();
driver.findElement(UMReasonsforReferralCodeBeginsInput).sendKeys(UMReasonsforReferralCode);
System.out.println("entered UM Reasons for Referral  Representivescode");
Log.info("log4j msg- entered UM Reasons for Referral code");


//enter  UM Reasons for Referral name
wait.until(ExpectedConditions.visibilityOfElementLocated(UMReasonsforReferralNameDescriptionBeginsInput));
driver.findElement(UMReasonsforReferralNameDescriptionBeginsInput).clear();
driver.findElement(UMReasonsforReferralNameDescriptionBeginsInput).sendKeys(UMReasonsforReferralName);
System.out.println("entered UM Reasons for Referral name");
Log.info("log4j msg- entered UM Reasons for Referral name");

//click search
wait.until(ExpectedConditions.visibilityOfElementLocated(UMReasonsforReferralSearchButton));
driver.findElement(UMReasonsforReferralSearchButton).click();
System.out.println("clicked Search");
Log.info("log4j msg- clicked Search");
	
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+UMReasonsforReferralCode+"']")));
WebElement e = driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+UMReasonsforReferralCode+"']"));
e.click();
System.out.println("Found UMReasonsforReferral");
Log.info("log4j msg- Found UMReasonsforReferral");

return 1;
}

catch(Exception e){System.out.println("UM Reasons for Referral not found"); Log.info("log4j msg- UM Reasons for Referral not found");return 0;}

}

//add function
public void addUMReasonsforReferral( String UMReasonsforReferralCode, String UMReasonsforReferralDescription)throws Exception{

        try{ 
        int i= searchUMReasonsforReferral( UMReasonsforReferralCode, UMReasonsforReferralDescription);
		
		if (i==0){
			System.out.println("UM Reasons for Referral not found, Continue with Add");
			Log.info("log4j msg- UM Reasons for Referral not found, Continue with Add");
		
		
        wait.until(ExpectedConditions.visibilityOfElementLocated(UMReasonsforReferralAddLink));
        driver.findElement(UMReasonsforReferralAddLink).click();
        System.out.println("clicked Add");
        Log.info("log4j msg- clicked Add");
        
        
        System.out.println("UM Reasons for Referral code: "+UMReasonsforReferralCode);
        Log.info("log4j msg- UM Reasons for Referral code: "+UMReasonsforReferralCode);
        //enter code
        wait.until(ExpectedConditions.visibilityOfElementLocated(UMReasonsforReferralCodeInput));
        driver.findElement(UMReasonsforReferralCodeInput).sendKeys(UMReasonsforReferralCode);
        Thread.sleep(1000);
        System.out.println("Entered code");
        Log.info("log4j msg- Entered code");
        
        System.out.println("UM Reasons for Referral description"+UMReasonsforReferralDescription);
        Log.info("log4j msg- UM Reasons for Referral code: "+UMReasonsforReferralDescription);
        //enter Description
        wait.until(ExpectedConditions.visibilityOfElementLocated(UMReasonsforReferralDescriptionInput));
        driver.findElement(UMReasonsforReferralDescriptionInput).sendKeys(UMReasonsforReferralDescription);
        Thread.sleep(1000);
        System.out.println("Entered description");
        Log.info("log4j msg- Entered description");

        
        //click validate

        
        wait.until(ExpectedConditions.visibilityOfElementLocated(UMReasonsforReferralValidateLink));
        driver.findElement(UMReasonsforReferralValidateLink).click();
        System.out.println("clicked validate");
        Log.info("log4j msg- clicked validate");
        
        //click ok
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(UMReasonsforReferralValidateSaveOKButton));
        driver.findElement(UMReasonsforReferralValidateSaveOKButton).click();
        System.out.println("clicked validate ok to save button");
        Log.info("log4j msg- clicked validate ok to save button");
        
		
        //click save
        Thread.sleep(1000);
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(UMReasonsforReferralSaveLink));
        driver.findElement(UMReasonsforReferralSaveLink).click();
        System.out.println("clicked save ");
        Log.info("log4j msg- clicked  save ");
          BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
        
        } else{
			System.out.println("UM Reasons for Referral is already present, cannot add UM Reasons for Referral");
			Log.info("log4j msg- UM Reasons for Referral is already present, cannot add UM Reasons for Referral");
			wait.until(ExpectedConditions.visibilityOfElementLocated(UMReasonsforReferralExitLink));
			driver.findElement(UMReasonsforReferralExitLink).click();
			System.out.println("clicked Exit");
			Log.info("log4j msg- clicked Exit");
			
			 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
		}

        }catch (Exception e){System.out.println("Error in adding UM Reasons for Referral");Log.info("log4j msg- Error in adding UM Reasons for Referral"); }
		}
        
//copy function

public void copyUMReasonsforReferral( String UMReasonsforReferralCode, String UMReasonsforReferralName, String newUMReasonsforReferralCode, String newUMReasonsforReferralDescription)throws Exception{
        
        try{
        int i= searchUMReasonsforReferral( UMReasonsforReferralCode, UMReasonsforReferralName);
		
		if (i==1){
			System.out.println("UM Reasons for Referral found, continue with copy");
			Log.info("log4j msg-UM Reasons for Referral found, continue with copy");
		
        
        System.out.println("UM Reasons for Referral code"+UMReasonsforReferralCode);
        Log.info("log4j msg-UM Reasons for Referral code"+UMReasonsforReferralCode);
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+UMReasonsforReferralCode+"']")));
        driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+UMReasonsforReferralCode+"']")).click();
        System.out.println("clicked UM Reasons for Referral Code");
        Log.info("log4j msg- clicked UM Reasons for Referral code");
        
        
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(UMReasonsforReferralCopyLink));
        driver.findElement(UMReasonsforReferralCopyLink).click();
        System.out.println("clicked Copy");
        Log.info("log4j msg- clicked Copy");
        
        System.out.println("UM Reasons for Referral new code"+newUMReasonsforReferralCode);
        Log.info("log4j msg- UM Reasons for Referral new code"+newUMReasonsforReferralCode);
        //enter new code
        wait.until(ExpectedConditions.visibilityOfElementLocated(UMReasonsforReferralCodeInput));
        driver.findElement(UMReasonsforReferralCodeInput).clear();
        driver.findElement(UMReasonsforReferralCodeInput).sendKeys(newUMReasonsforReferralCode);
        System.out.println("Entered new code");
        Log.info("log4j msg- Entered new code");

        System.out.println("UM Reasons for Referral new description"+newUMReasonsforReferralDescription);
        Log.info("log4j msg- UM Reasons for Referral new description"+newUMReasonsforReferralDescription);
//enter new description
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(UMReasonsforReferralDescriptionInput));
        driver.findElement(UMReasonsforReferralDescriptionInput).clear();
        driver.findElement(UMReasonsforReferralDescriptionInput).sendKeys(newUMReasonsforReferralDescription);
        System.out.println("Entered new description");
        Log.info("log4j msg- Entered new description");
        
        
        
        
        
        //click save
        wait.until(ExpectedConditions.visibilityOfElementLocated(UMReasonsforReferralSaveLink));
        driver.findElement(UMReasonsforReferralSaveLink).click();

        System.out.println("Clicked save");
        Log.info("log4j msg- clicked save");
          BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
		
        
		
        } else{
			System.out.println("UM Reasons for Referral is not present, cannot copy UM Reasons for Referral");
			Log.info("log4j msg- UM Reasons for Referral is not present, cannot copy UM Reasons for Referral");
			wait.until(ExpectedConditions.visibilityOfElementLocated(UMReasonsforReferralExitLink));
			driver.findElement(UMReasonsforReferralExitLink).click();
			System.out.println("clicked Exit");
			Log.info("log4j msg- clicked Exit");
			
			 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
		}

        }catch (Exception e){System.out.println("Error in copying UM Reasons for Referral");Log.info("log4j msg- Error in copying UM Reasons for Referral"); }
		}
		
		





//edit function
public void editUMReasonsforReferral( String UMReasonsforReferralCode, String umreasonsforReferralDescription, String recordMark)throws Exception{
        
        try{
        int i= searchUMReasonsforReferral( UMReasonsforReferralCode, umreasonsforReferralDescription);
		
		if (i==1){
			System.out.println("UM Reasons for Referral  found, Continue with Edit");
			Log.info("log4j msg- UM Reasons for Referral  found, Continue with Edit");
		
		
        System.out.println("UM Reasons for Referral code"+UMReasonsforReferralCode);
        Log.info("log4j msg- UM Reasons for Referral code"+UMReasonsforReferralCode);
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+UMReasonsforReferralCode+"']")));
        driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+UMReasonsforReferralCode+"']")).click();
        System.out.println("clicked UM Reasons for Referral Record Mark");
        Log.info("log4j msg- clicked UM Reasons for Referral Record Mark");
        
        
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(UMReasonsforReferralEditLink));
        driver.findElement(UMReasonsforReferralEditLink).click();
        System.out.println("clicked Edit");
        Log.info("log4j msg- clicked Edit");
        
        System.out.println("UM Reasons for Referral Record Mark"+recordMark);
        Log.info("log4j msg-UM Reasons for Referral Record Mark"+recordMark);
                                       
//enter new description
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(UMReasonsforReferralRecordMark));
       driver.findElement(UMReasonsforReferralRecordMark).clear();
        Thread.sleep(1000);
        driver.findElement(UMReasonsforReferralRecordMark).sendKeys(recordMark);
        System.out.println("Entered new Record Mark");
        Log.info("log4j msg- Entered new Record Mark");
        
        
        
        
        //click save
        wait.until(ExpectedConditions.visibilityOfElementLocated(UMReasonsforReferralSaveLink));
        driver.findElement(UMReasonsforReferralSaveLink).click();
        System.out.println("Clicked save");
        Log.info("log4j msg- clicked save");
          BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
		}
        
		else{System.out.println("UM Reasons for Referral not found, cannot edit UM Reasons for Referral");
        Log.info("log4j msg- UM Reasons for Referral not found, cannot edit UM Reasons for Referral");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}
		
		}catch (Exception e){ e.printStackTrace();System.out.println("Error in Editing UM Reasons for Referral ");
        Log.info("log4j msg- Error in Editing UM Reasons for Referral ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}


        }
//exit function
public void exitUMReasonsforReferral( String UMReasonsforReferralCode) throws Exception{
try{
        System.out.println("UM Reasons for Referral code"+UMReasonsforReferralCode);
        Log.info("log4j msg- UM Reasons for Referral code"+UMReasonsforReferralCode);
                         Thread.sleep(1000);
                        driver.findElement(UMReasonsforReferralExitLink).click();
                        Thread.sleep(1000);
                        System.out.println("Clicked exit in  UM Reasons for Referral ");
                        Log.info("log4j msg- clicked exit in  UM Reasons for Referral ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                       
}catch (Exception e){ e.printStackTrace();System.out.println("Error in Exiting UM Reasons for Referral ");
Log.info("log4j msg- Error in Exiting UM Reasons for Referral ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}}

//add comm function
public void addCommUMReasonsforReferral( String UMReasonsforReferralCode, String UMReasonsforReferralName, String UMReasonsforReferralCommsubject, String UMReasonsforReferralCommNoteType, String UMReasonsforReferralCommMedium, String UMReasonsforReferralCommDetails) throws Exception{
        
        try{ 
        int i= searchUMReasonsforReferral( UMReasonsforReferralCode, UMReasonsforReferralName);
		
		if (i==1){
			System.out.println("UM Reasons for Referral  found, Continue with Add Communication");
			Log.info("log4j msg- UM Reasons for Referral  found, Continue with Add Communication");
		
		
        System.out.println("UM Reasons for Referral code"+UMReasonsforReferralCode);
        Log.info("log4j msg- UM Reasons for Referral code"+UMReasonsforReferralCode);
                        //find UMReasonsforReferral
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+UMReasonsforReferralCode+"']")));
        driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+UMReasonsforReferralCode+"']")).click();
        System.out.println("clicked UM Reasons for Referral Code");
        Log.info("log4j msg- clicked UM Reasons for Referral code");
        
                                        //click comm
                                        
        wait.until(ExpectedConditions.visibilityOfElementLocated(UMReasonsforReferralCommLink));
        driver.findElement(UMReasonsforReferralCommLink).click();
        System.out.println("clicked Comm");
        Log.info("log4j msg- clicked Comm");

                                        
                                        
                                        //click add
                                         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")));
                                        driver.findElement(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")).click();
                                        
                                         System.out.println("clicked Add");
                                        Log.info("log4j msg- clicked Add");
                                        
                                        //enter subject
                                         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtSubject']")));
                                        driver.findElement(By.xpath("//input[@id='txtSubject']")).sendKeys(UMReasonsforReferralCommsubject);
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
                                        
                                        Thread.sleep(1000);
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlNoteType"))); 
                                        Select umreasonsforReferral = new Select(driver.findElement(By.xpath("//select[@id='ddlNoteType']")));
                                        umreasonsforReferral.selectByVisibleText(UMReasonsforReferralCommNoteType);
                                        System.out.println("selected note type");
                                        Log.info("log4j msg-selected note type");
                                        
                                        Thread.sleep(1000);
                                        //enter note details
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='txtNotes']")));
                                        driver.findElement(By.xpath("//textarea[@id='txtNotes']")).sendKeys(UMReasonsforReferralCommDetails);
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
                                        
                         BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}}
                                        
                         catch (Exception e){
                        	 e.printStackTrace();
                        	 System.out.println("Error in adding Comm to UM Reasons for Referral");
                             Log.info("log4j msg - Error in adding Comm to  UM Reasons for Referral"); 
         BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
         driver.quit();   
         }   
                         
                         }
        


//delete function
public void deleteUMReasonsforReferral( String UMReasonsforReferralCode, String UMReasonsforReferralDescription) throws Exception{
        
        try{            
        int i= searchUMReasonsforReferral(UMReasonsforReferralCode, UMReasonsforReferralDescription);
		
		if (i==1){
			System.out.println("UM Reasons for Referral found, continue with delete");
			Log.info("log4j msg-UM Reasons for Referral found, continue with delete");
			
        //find UMReasonsforReferral
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+UMReasonsforReferralCode+"']")));
                                        driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+UMReasonsforReferralCode+"']")).click();
                                        System.out.println("clicked UM Reasons for Referral Code");
                                        Log.info("log4j msg- clicked UM Reasons for Referral code");
                        
                                        //click delete
                                        
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(UMReasonsforReferralDeleteLink));
                                        driver.findElement(UMReasonsforReferralDeleteLink).click();
                                        System.out.println("clicked Delete");
                                        Log.info("log4j msg- clicked Delete");
                                        
        
                                        //click confirm delete
                                        
                                        
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmDeleteButton));
                                        driver.findElement(confirmDeleteButton).click();
                                        System.out.println("clicked confirm Delete");
                                        Log.info("log4j msg- clicked confirm Delete");
                                         BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                                        
                                        
        




} else{
System.out.println("cannot find UM Reasons for Referral, cannot delete UM Reasons for Referral ");
Log.info("log4j msg- cannot find UM Reasons for Referral, cannot delete UM Reasons for Referral ");
wait.until(ExpectedConditions.visibilityOfElementLocated(UMReasonsforReferralExitLink));
driver.findElement(UMReasonsforReferralExitLink).click();
System.out.println("clicked Exit");
Log.info("log4j msg- clicked Exit");


BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();

}} catch (Exception e){System.out.println("Error in deleting UM Reasons for Referral ");
Log.info("log4j msg - Error in deleting UM Reasons for Referral "); 

}   
}

}





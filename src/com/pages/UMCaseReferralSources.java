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

public class UMCaseReferralSources {
	
	WebDriver driver;
	WebDriverWait wait ;  
	
	By UMCaseReferralSourcesCodeBeginsInput = By.xpath("//input[@id='txtCode']");
	
	By UMCaseReferralSourcesNameDescriptionBeginsInput = By.xpath("//input[@id='txtName']");
	
	By UMCaseReferralSourcesSearchButton= By.xpath("//button[@data-ng-click='search(0)']");
    
	By UMCaseReferralSourcesAddLink= By.linkText("Add");
   
	By UMCaseReferralSourcesCodeInput = By.xpath("//input[@id='code']");
    
	By UMCaseReferralSourcesDescriptionInput= By.xpath("//input[@id='name']");
    
    By UMCaseReferralSourcesRecordMark= By.xpath("//input[@style='width:20px;']");
    
    By UMCaseReferralSourcesValidateLink =By.linkText("Validate");
    
    By UMCaseReferralSourcesValidateSaveOKButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By UMCaseReferralSourcesSaveLink =  By.linkText("Save");
    
    By UMCaseReferralSourcesEditLink = By.linkText("Edit");
    
    By UMCaseReferralSourcesCopyLink = By.linkText("Copy");
    
    By UMCaseReferralSourcesDeleteLink= By.linkText("Delete");
    
    By confirmDeleteButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By UMCaseReferralSourcesCommLink= By.linkText("Commun.");
    
    By UMCaseReferralSourcesExitLink=  By.linkText("Exit");
    
    
    
    
    public UMCaseReferralSources(WebDriver driver){
        this.driver= driver;
        this.wait= new WebDriverWait(driver, 35);  
}



public int searchUMCaseReferralSources( String UMCaseReferralSourcesCode, String UMCaseReferralSourcesName) throws Exception{

try{
//enter  UM Case Referral Sources code
wait.until(ExpectedConditions.visibilityOfElementLocated(UMCaseReferralSourcesCodeBeginsInput));
driver.findElement(UMCaseReferralSourcesCodeBeginsInput).clear();
driver.findElement(UMCaseReferralSourcesCodeBeginsInput).sendKeys(UMCaseReferralSourcesCode);
System.out.println("entered UM Case Referral Sources  code");
Log.info("log4j msg- entered UM Case Referral Sources code");


//enter  UM Case Referral Sources name
wait.until(ExpectedConditions.visibilityOfElementLocated(UMCaseReferralSourcesNameDescriptionBeginsInput));
driver.findElement(UMCaseReferralSourcesNameDescriptionBeginsInput).clear();
driver.findElement(UMCaseReferralSourcesNameDescriptionBeginsInput).sendKeys(UMCaseReferralSourcesName);
System.out.println("entered UM Case Referral Sources name");
Log.info("log4j msg- entered UM Case Referral Sources name");

//click search
wait.until(ExpectedConditions.visibilityOfElementLocated(UMCaseReferralSourcesSearchButton));
driver.findElement(UMCaseReferralSourcesSearchButton).click();
System.out.println("clicked Search");
Log.info("log4j msg- clicked Search");
	
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+UMCaseReferralSourcesCode+"']")));
WebElement e = driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+UMCaseReferralSourcesCode+"']"));
e.click();
System.out.println("Found UMCaseReferralSources");
Log.info("log4j msg- Found UMCaseReferralSources");

return 1;
}

catch(Exception e){System.out.println("UM Case Referral Sources not found"); Log.info("log4j msg- UM Case Referral Sources not found");return 0;}

}

//add function
public void addUMCaseReferralSources( String UMCaseReferralSourcesCode, String UMCaseReferralSourcesDescription)throws Exception{

        try{ 
        int i= searchUMCaseReferralSources( UMCaseReferralSourcesCode, UMCaseReferralSourcesDescription);
		
		if (i==0){
			System.out.println("UM Case Referral Sources not found, Continue with Add");
			Log.info("log4j msg- UM Case Referral Sources not found, Continue with Add");
		
		
        wait.until(ExpectedConditions.visibilityOfElementLocated(UMCaseReferralSourcesAddLink));
        driver.findElement(UMCaseReferralSourcesAddLink).click();
        System.out.println("clicked Add");
        Log.info("log4j msg- clicked Add");
        
        
        System.out.println("UM Case Referral Sources code: "+UMCaseReferralSourcesCode);
        Log.info("log4j msg- UM Case Referral Sources code: "+UMCaseReferralSourcesCode);
        //enter code
        wait.until(ExpectedConditions.visibilityOfElementLocated(UMCaseReferralSourcesCodeInput));
        driver.findElement(UMCaseReferralSourcesCodeInput).sendKeys(UMCaseReferralSourcesCode);
        Thread.sleep(1000);
        System.out.println("Entered code");
        Log.info("log4j msg- Entered code");
        
        System.out.println("UM Case Referral Sources description"+UMCaseReferralSourcesDescription);
        Log.info("log4j msg- UM Case Referral Sources code: "+UMCaseReferralSourcesDescription);
        //enter Description
        wait.until(ExpectedConditions.visibilityOfElementLocated(UMCaseReferralSourcesDescriptionInput));
        driver.findElement(UMCaseReferralSourcesDescriptionInput).sendKeys(UMCaseReferralSourcesDescription);
        Thread.sleep(1000);
        System.out.println("Entered description");
        Log.info("log4j msg- Entered description");

        
        //click validate

        
        wait.until(ExpectedConditions.visibilityOfElementLocated(UMCaseReferralSourcesValidateLink));
        driver.findElement(UMCaseReferralSourcesValidateLink).click();
        System.out.println("clicked validate");
        Log.info("log4j msg- clicked validate");
        
        //click ok
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(UMCaseReferralSourcesValidateSaveOKButton));
        driver.findElement(UMCaseReferralSourcesValidateSaveOKButton).click();
        System.out.println("clicked validate ok to save button");
        Log.info("log4j msg- clicked validate ok to save button");
        
		
        //click save
        Thread.sleep(1000);
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(UMCaseReferralSourcesSaveLink));
        driver.findElement(UMCaseReferralSourcesSaveLink).click();
        System.out.println("clicked save ");
        Log.info("log4j msg- clicked  save ");
          BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
        
        } else{
			System.out.println("UM Case Referral Sources is already present, cannot add UM Case Referral Sources");
			Log.info("log4j msg- UM Case Referral Sources is already present, cannot add UM Case Referral Sources");
			wait.until(ExpectedConditions.visibilityOfElementLocated(UMCaseReferralSourcesExitLink));
			driver.findElement(UMCaseReferralSourcesExitLink).click();
			System.out.println("clicked Exit");
			Log.info("log4j msg- clicked Exit");
			
			 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
		}

        }catch (Exception e){System.out.println("Error in adding UM Case Referral Sources");Log.info("log4j msg- Error in adding UM Case Referral Sources"); }
		}
        
//copy function

public void copyUMCaseReferralSources( String UMCaseReferralSourcesCode, String UMCaseReferralSourcesName, String newUMCaseReferralSourcesCode, String newUMCaseReferralSourcesDescription)throws Exception{
        
        try{ 
        int i= searchUMCaseReferralSources( UMCaseReferralSourcesCode, UMCaseReferralSourcesName);
		
		if (i==1){
			System.out.println("UM Case Referral Sources found, continue with copy");
			Log.info("log4j msg-UM Case Referral Sources found, continue with copy");
		
        
        System.out.println("UM Case Referral Sources code"+UMCaseReferralSourcesCode);
        Log.info("log4j msg-UM Case Referral Sources code"+UMCaseReferralSourcesCode);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+UMCaseReferralSourcesCode+"']")));
        driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+UMCaseReferralSourcesCode+"']")).click();
        System.out.println("clicked UM Case Referral Sources Code");
        Log.info("log4j msg- clicked UM Case Referral Sources code");
        
        
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(UMCaseReferralSourcesCopyLink));
        driver.findElement(UMCaseReferralSourcesCopyLink).click();
        System.out.println("clicked Copy");
        Log.info("log4j msg- clicked Copy");
        
        System.out.println("UM Case Referral Sources new code"+newUMCaseReferralSourcesCode);
        Log.info("log4j msg- UM Case Referral Sources new code"+newUMCaseReferralSourcesCode);
        //enter new code
        wait.until(ExpectedConditions.visibilityOfElementLocated(UMCaseReferralSourcesCodeInput));
        driver.findElement(UMCaseReferralSourcesCodeInput).clear();
        driver.findElement(UMCaseReferralSourcesCodeInput).sendKeys(newUMCaseReferralSourcesCode);
        System.out.println("Entered new code");
        Log.info("log4j msg- Entered new code");

        System.out.println("UM Case Referral Sources new description"+newUMCaseReferralSourcesDescription);
        Log.info("log4j msg- UM Case Referral Sources new description"+newUMCaseReferralSourcesDescription);
//enter new description
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(UMCaseReferralSourcesDescriptionInput));
        driver.findElement(UMCaseReferralSourcesDescriptionInput).clear();
        driver.findElement(UMCaseReferralSourcesDescriptionInput).sendKeys(newUMCaseReferralSourcesDescription);
        System.out.println("Entered new description");
        Log.info("log4j msg- Entered new description");
        
        
        
        
        
        //click save
        wait.until(ExpectedConditions.visibilityOfElementLocated(UMCaseReferralSourcesSaveLink));
        driver.findElement(UMCaseReferralSourcesSaveLink).click();

        System.out.println("Clicked save");
        Log.info("log4j msg- clicked save");
          BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
		
        
		
        } else{
			System.out.println("UM Case Referral Sources is not present, cannot copy UM Case Referral Sources");
			Log.info("log4j msg- UM Case Referral Sources is not present, cannot copy UM Case Referral Sources");
			wait.until(ExpectedConditions.visibilityOfElementLocated(UMCaseReferralSourcesExitLink));
			driver.findElement(UMCaseReferralSourcesExitLink).click();
			System.out.println("clicked Exit");
			Log.info("log4j msg- clicked Exit");
			
			 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
		}

        }catch (Exception e){System.out.println("Error in copying UM Case Referral Sources");Log.info("log4j msg- Error in copying UM Case Referral Sources"); }
		}
		
		





//edit function
public void editUMCaseReferralSources( String UMCaseReferralSourcesCode, String umcasereferralSourcesDescription, String recordMark)throws Exception{
        
        try{ 
        int i= searchUMCaseReferralSources( UMCaseReferralSourcesCode, umcasereferralSourcesDescription);
		
		if (i==1){
			System.out.println("UM Case Referral Sources  found, Continue with Edit");
			Log.info("log4j msg- UM Case Referral Sources  found, Continue with Edit");
		
		
        System.out.println("UM Case Referral Sources code"+UMCaseReferralSourcesCode);
        Log.info("log4j msg- UM Case Referral Sources code"+UMCaseReferralSourcesCode);
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+UMCaseReferralSourcesCode+"']")));
        driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+UMCaseReferralSourcesCode+"']")).click();
        System.out.println("clicked UM Case Referral Sources Record Mark");
        Log.info("log4j msg- clicked UM Case Referral Sources Record Mark");
        
        
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(UMCaseReferralSourcesEditLink));
        driver.findElement(UMCaseReferralSourcesEditLink).click();
        System.out.println("clicked Edit");
        Log.info("log4j msg- clicked Edit");
        
        System.out.println("UM Case Referral Sources Record Mark"+recordMark);
        Log.info("log4j msg-UM Case Referral Sources Record Mark"+recordMark);
                                       
//enter new description
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(UMCaseReferralSourcesRecordMark));
        driver.findElement(UMCaseReferralSourcesRecordMark).clear();
        Thread.sleep(1000);
        driver.findElement(UMCaseReferralSourcesRecordMark).sendKeys(recordMark);
        System.out.println("Entered new Record Mark");
        Log.info("log4j msg- Entered new Record Mark");
        
        
        
        
        //click save
        wait.until(ExpectedConditions.visibilityOfElementLocated(UMCaseReferralSourcesSaveLink));
        driver.findElement(UMCaseReferralSourcesSaveLink).click();
        System.out.println("Clicked save");
        Log.info("log4j msg- clicked save");
          BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
		}
        
		else{System.out.println("UM Case Referral Sources not found, cannot edit UM Case Referral Sources");
        Log.info("log4j msg- UM Case Referral Sources not found, cannot edit UM Case Referral Sources");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}
		
		}catch (Exception e){ e.printStackTrace();System.out.println("Error in Editing UM Case Referral Sources ");
        Log.info("log4j msg- Error in Editing UM Case Referral Sources ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}


        }
//exit function
public void exitUMCaseReferralSources( String UMCaseReferralSourcesCode) throws Exception{
try{
        System.out.println("UM Case Referral Sources code"+UMCaseReferralSourcesCode);
        Log.info("log4j msg- UM Case Referral Sources code"+UMCaseReferralSourcesCode);
                        Thread.sleep(1000);
                        driver.findElement(UMCaseReferralSourcesExitLink).click();
                        Thread.sleep(1000);
                        System.out.println("Clicked exit in  UM Case Referral Sources ");
                        Log.info("log4j msg- clicked exit in  UM Case Referral Sources ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                       
}catch (Exception e){ e.printStackTrace();System.out.println("Error in Exiting UM Case Referral Sources ");
Log.info("log4j msg- Error in Exiting UM Case Referral Sources ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}}

//add comm function
public void addCommUMCaseReferralSources( String UMCaseReferralSourcesCode, String UMCaseReferralSourcesName, String UMCaseReferralSourcesCommsubject, String UMCaseReferralSourcesCommNoteType, String UMCaseReferralSourcesCommMedium, String UMCaseReferralSourcesCommDetails) throws Exception{
        
        try{ 
        int i= searchUMCaseReferralSources( UMCaseReferralSourcesCode, UMCaseReferralSourcesName);
		
		if (i==1){
			System.out.println("UM Case Referral Sources  found, Continue with Add Communication");
			Log.info("log4j msg- UM Case Referral Sources  found, Continue with Add Communication");
		
		
        System.out.println("UM Case Referral Sources code"+UMCaseReferralSourcesCode);
        Log.info("log4j msg- UM Case Referral Sources code"+UMCaseReferralSourcesCode);
                        //find UMCaseReferralSources
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+UMCaseReferralSourcesCode+"']")));
        driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+UMCaseReferralSourcesCode+"']")).click();
        System.out.println("clicked UM Case Referral Sources Code");
        Log.info("log4j msg- clicked UM Case Referral Sources code");
        
                                        //click comm
                                        
        wait.until(ExpectedConditions.visibilityOfElementLocated(UMCaseReferralSourcesCommLink));
        driver.findElement(UMCaseReferralSourcesCommLink).click();
        System.out.println("clicked Comm");
        Log.info("log4j msg- clicked Comm");

                                        
                                        
                                        //click add
                                         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")));
                                        driver.findElement(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")).click();
                                          System.out.println("clicked Add");
                                        Log.info("log4j msg- clicked Add");
                                        
                                        //enter subject
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtSubject']")));
                                        driver.findElement(By.xpath("//input[@id='txtSubject']")).sendKeys(UMCaseReferralSourcesCommsubject);
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
                                        Select umcasereferralSources = new Select(driver.findElement(By.xpath("//select[@id='ddlNoteType']")));
                                        umcasereferralSources.selectByVisibleText(UMCaseReferralSourcesCommNoteType);
                                        System.out.println("selected note type");
                                        Log.info("log4j msg-selected note type");
                                        
                                        Thread.sleep(1000);
                                        //enter note details
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='txtNotes']")));
                                        driver.findElement(By.xpath("//textarea[@id='txtNotes']")).sendKeys(UMCaseReferralSourcesCommDetails);
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
                                        
                         catch (Exception e){e.printStackTrace();System.out.println("Error in adding Comm to UM Case Referral Sources");
                                                                                                        Log.info("log4j msg - Error in adding Comm to  UM Case Referral Sources"); 
         BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();   }   
                         
                         }
        


//delete function
public void deleteUMCaseReferralSources( String UMCaseReferralSourcesCode, String UMCaseReferralSourcesDescription) throws Exception{
        
        try{            
        int i= searchUMCaseReferralSources(UMCaseReferralSourcesCode, UMCaseReferralSourcesDescription);
		
		if (i==1){
			System.out.println("UM Case Referral Sources found, continue with delete");
			Log.info("log4j msg-UM Case Referral Sources found, continue with delete");
			
        //find UMCaseReferralSources
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+UMCaseReferralSourcesCode+"']")));
                                        driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+UMCaseReferralSourcesCode+"']")).click();
                                        System.out.println("clicked UM Case Referral Sources Code");
                                        Log.info("log4j msg- clicked UM Case Referral Sources code");
                        
                                        //click delete
                                        
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(UMCaseReferralSourcesDeleteLink));
                                        driver.findElement(UMCaseReferralSourcesDeleteLink).click();
                                        System.out.println("clicked Delete");
                                        Log.info("log4j msg- clicked Delete");
                                        
        
                                        //click confirm delete
                                        
                                        
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmDeleteButton));
                                        driver.findElement(confirmDeleteButton).click();
                                        System.out.println("clicked confirm Delete");
                                        Log.info("log4j msg- clicked confirm Delete");
                                         BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                                        
                                        
        




} else{
System.out.println("cannot find UM Case Referral Sources, cannot delete UM Case Referral Sources ");
Log.info("log4j msg- cannot find UM Case Referral Sources, cannot delete UM Case Referral Sources ");
wait.until(ExpectedConditions.visibilityOfElementLocated(UMCaseReferralSourcesExitLink));
driver.findElement(UMCaseReferralSourcesExitLink).click();
System.out.println("clicked Exit");
Log.info("log4j msg- clicked Exit");


BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();

}} catch (Exception e){System.out.println("Error in deleting UM Case Referral Sources ");
Log.info("log4j msg - Error in deleting UM Case Referral Sources "); 

}   
}

}





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

public class UMCaseStatusCodes {

	WebDriver driver;
	WebDriverWait wait;  
	
	By UMCaseStatusCodesCodeBeginsInput = By.xpath("//input[@id='txtCode']");
	
	By UMCaseStatusCodesNameDescriptionBeginsInput = By.xpath("//input[@id='txtName']");
	
	By UMCaseStatusCodesSearchButton= By.xpath("//button[@data-ng-click='search(0)']");
    
    By UMCaseStatusCodesAddLink= By.linkText("Add");
    
    By UMCaseStatusCodesCodeInput = By.xpath("//input[@id='code']");
    
    By UMCaseStatusCodesDescriptionInput= By.xpath("//input[@id='name']");
    
    By UMCaseStatusCodesRecordMark= By.xpath("//input[@style='width:20px;']");
    
    By UMCaseStatusCodesValidateLink =By.linkText("Validate");
    
    By UMCaseStatusCodesValidateSaveOKButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By UMCaseStatusCodesSaveLink =  By.linkText("Save");
    
    By UMCaseStatusCodesEditLink = By.linkText("Edit");
    
    By UMCaseStatusCodesCopyLink = By.linkText("Copy");
    
    By UMCaseStatusCodesDeleteLink= By.linkText("Delete");
    
    By confirmDeleteButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By UMCaseStatusCodesCommLink= By.linkText("Commun.");
    
    By UMCaseStatusCodesExitLink=  By.linkText("Exit");
    
    
    
    
    public UMCaseStatusCodes(WebDriver driver){
        this.driver= driver;
        this.wait = new WebDriverWait(driver, 35);  
}


public int searchUMCaseStatusCodes( String UMCaseStatusCodesCode, String UMCaseStatusCodesName) throws Exception{

try{
//enter  UM Case Status Codes code
wait.until(ExpectedConditions.visibilityOfElementLocated(UMCaseStatusCodesCodeBeginsInput));
driver.findElement(UMCaseStatusCodesCodeBeginsInput).clear();
driver.findElement(UMCaseStatusCodesCodeBeginsInput).sendKeys(UMCaseStatusCodesCode);
System.out.println("entered UM Case Status Codes  Representivescode");
Log.info("log4j msg- entered UM Case Status Codes code");


//enter  UM Case Status Codes name
wait.until(ExpectedConditions.visibilityOfElementLocated(UMCaseStatusCodesNameDescriptionBeginsInput));
driver.findElement(UMCaseStatusCodesNameDescriptionBeginsInput).clear();
driver.findElement(UMCaseStatusCodesNameDescriptionBeginsInput).sendKeys(UMCaseStatusCodesName);
System.out.println("entered UM Case Status Codes name");
Log.info("log4j msg- entered UM Case Status Codes name");

//click search
wait.until(ExpectedConditions.visibilityOfElementLocated(UMCaseStatusCodesSearchButton));
driver.findElement(UMCaseStatusCodesSearchButton).click();
System.out.println("clicked Search");
Log.info("log4j msg- clicked Search");
	

wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+UMCaseStatusCodesCode+"']")));
WebElement e = driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+UMCaseStatusCodesCode+"']"));
e.click();
System.out.println("Found UMCaseStatusCodes");
Log.info("log4j msg- Found UMCaseStatusCodes");

return 1;
}

catch(Exception e){System.out.println("UM Case Status Codes not found"); Log.info("log4j msg-  UM Case Status Codes not found");return 0;}

}

//add function
public void addUMCaseStatusCodes( String UMCaseStatusCodesCode, String UMCaseStatusCodesDescription)throws Exception{

        try{ 
        int i= searchUMCaseStatusCodes( UMCaseStatusCodesCode, UMCaseStatusCodesDescription);
		
		if (i==0){
			System.out.println("UM Case Status Codes not found, Continue with Add");
			Log.info("log4j msg- UM Case Status Codes not found, Continue with Add");
		
		
        wait.until(ExpectedConditions.visibilityOfElementLocated(UMCaseStatusCodesAddLink));
        driver.findElement(UMCaseStatusCodesAddLink).click();
        System.out.println("clicked Add");
        Log.info("log4j msg- clicked Add");
        
        
        System.out.println("UM Case Status Codes code: "+UMCaseStatusCodesCode);
        Log.info("log4j msg- UM Case Status Codes code: "+UMCaseStatusCodesCode);
        //enter code
        wait.until(ExpectedConditions.visibilityOfElementLocated(UMCaseStatusCodesCodeInput));
        driver.findElement(UMCaseStatusCodesCodeInput).sendKeys(UMCaseStatusCodesCode);
        Thread.sleep(1000);
        System.out.println("Entered code");
        Log.info("log4j msg- Entered code");
        
        System.out.println("UM Case Status Codes description"+UMCaseStatusCodesDescription);
        Log.info("log4j msg- UM Case Status Codes code: "+UMCaseStatusCodesDescription);
        //enter Description
        wait.until(ExpectedConditions.visibilityOfElementLocated(UMCaseStatusCodesDescriptionInput));
        driver.findElement(UMCaseStatusCodesDescriptionInput).sendKeys(UMCaseStatusCodesDescription);
        Thread.sleep(1000);
        System.out.println("Entered description");
        Log.info("log4j msg- Entered description");

        
        //click validate

        
        wait.until(ExpectedConditions.visibilityOfElementLocated(UMCaseStatusCodesValidateLink));
        driver.findElement(UMCaseStatusCodesValidateLink).click();
        System.out.println("clicked validate");
        Log.info("log4j msg- clicked validate");
        
        //click ok
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(UMCaseStatusCodesValidateSaveOKButton));
        driver.findElement(UMCaseStatusCodesValidateSaveOKButton).click();
        System.out.println("clicked validate ok to save button");
        Log.info("log4j msg- clicked validate ok to save button");
        
		
        //click save
        Thread.sleep(1000);
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(UMCaseStatusCodesSaveLink));
        driver.findElement(UMCaseStatusCodesSaveLink).click();
        System.out.println("clicked save ");
        Log.info("log4j msg- clicked  save ");
          BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
        
        } else{
			System.out.println("UM Case Status Codes is already present, cannot add UM Case Status Codes");
			Log.info("log4j msg- UM Case Status Codes is already present, cannot add UM Case Status Codes");
			wait.until(ExpectedConditions.visibilityOfElementLocated(UMCaseStatusCodesExitLink));
			driver.findElement(UMCaseStatusCodesExitLink).click();
			System.out.println("clicked Exit");
			Log.info("log4j msg- clicked Exit");
			
			 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
		}

        }catch (Exception e){System.out.println("Error in adding UM Case Status Codes");Log.info("log4j msg- Error in adding UM Case Status Codes"); }
		}
        
//copy function

public void copyUMCaseStatusCodes( String UMCaseStatusCodesCode, String UMCaseStatusCodesName, String newUMCaseStatusCodesCode, String newUMCaseStatusCodesDescription)throws Exception{
        
        try{  
        int i= searchUMCaseStatusCodes( UMCaseStatusCodesCode, UMCaseStatusCodesName);
		
		if (i==1){
			System.out.println("UM Case Status Codes found, continue with copy");
			Log.info("log4j msg-UM Case Status Codes found, continue with copy");
		
        
        System.out.println("UM Case Status Codes code"+UMCaseStatusCodesCode);
        Log.info("log4j msg-UM Case Status Codes code"+UMCaseStatusCodesCode);
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+UMCaseStatusCodesCode+"']")));
        driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+UMCaseStatusCodesCode+"']")).click();
        System.out.println("clicked UM Case Status Codes Code");
        Log.info("log4j msg- clicked UM Case Status Codes code");
        
        
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(UMCaseStatusCodesCopyLink));
        driver.findElement(UMCaseStatusCodesCopyLink).click();
        System.out.println("clicked Copy");
        Log.info("log4j msg- clicked Copy");
        
        System.out.println("UM Case Status Codes new code"+newUMCaseStatusCodesCode);
        Log.info("log4j msg- UM Case Status Codes new code"+newUMCaseStatusCodesCode);
        //enter new code
        wait.until(ExpectedConditions.visibilityOfElementLocated(UMCaseStatusCodesCodeInput));
        driver.findElement(UMCaseStatusCodesCodeInput).clear();
        driver.findElement(UMCaseStatusCodesCodeInput).sendKeys(newUMCaseStatusCodesCode);
        System.out.println("Entered new code");
        Log.info("log4j msg- Entered new code");

        System.out.println("UM Case Status Codes new description"+newUMCaseStatusCodesDescription);
        Log.info("log4j msg- UM Case Status Codes new description"+newUMCaseStatusCodesDescription);
//enter new description
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(UMCaseStatusCodesDescriptionInput));
        driver.findElement(UMCaseStatusCodesDescriptionInput).clear();
        driver.findElement(UMCaseStatusCodesDescriptionInput).sendKeys(newUMCaseStatusCodesDescription);
        System.out.println("Entered new description");
        Log.info("log4j msg- Entered new description");
        
        
        
        
        
        //click save
        wait.until(ExpectedConditions.visibilityOfElementLocated(UMCaseStatusCodesSaveLink));
        driver.findElement(UMCaseStatusCodesSaveLink).click();

        System.out.println("Clicked save");
        Log.info("log4j msg- clicked save");
          BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
		
        
		
        } else{
			System.out.println("UM Case Status Codes is not present, cannot copy UM Case Status Codes");
			Log.info("log4j msg- UM Case Status Codes is not present, cannot copy UM Case Status Codes");
			wait.until(ExpectedConditions.visibilityOfElementLocated(UMCaseStatusCodesExitLink));
			driver.findElement(UMCaseStatusCodesExitLink).click();
			System.out.println("clicked Exit");
			Log.info("log4j msg- clicked Exit");
			
			 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
		}

        }catch (Exception e){System.out.println("Error in copying UM Case Status Codes");Log.info("log4j msg- Error in copying UM Case Status Codes"); }
		}
		
		





//edit function
public void editUMCaseStatusCodes( String UMCaseStatusCodesCode, String umcasestatusCodesDescription, String recordMark)throws Exception{
        
        try{ 
        int i= searchUMCaseStatusCodes( UMCaseStatusCodesCode, umcasestatusCodesDescription);
		
		if (i==1){
			System.out.println("UM Case Status Codes  found, Continue with Edit");
			Log.info("log4j msg- UM Case Status Codes  found, Continue with Edit");
		
		
        System.out.println("UM Case Status Codes code"+UMCaseStatusCodesCode);
        Log.info("log4j msg- UM Case Status Codes code"+UMCaseStatusCodesCode);
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+UMCaseStatusCodesCode+"']")));
        driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+UMCaseStatusCodesCode+"']")).click();
        System.out.println("clicked UM Case Status Codes Record Mark");
        Log.info("log4j msg- clicked UM Case Status Codes Record Mark");
        
        
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(UMCaseStatusCodesEditLink));
        driver.findElement(UMCaseStatusCodesEditLink).click();
        System.out.println("clicked Edit");
        Log.info("log4j msg- clicked Edit");
        
        System.out.println("UM Case Status Codes Record Mark"+recordMark);
        Log.info("log4j msg-UM Case Status Codes Record Mark"+recordMark);
                                       
//enter new description
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(UMCaseStatusCodesRecordMark));
       driver.findElement(UMCaseStatusCodesRecordMark).clear();
        Thread.sleep(1000);
        driver.findElement(UMCaseStatusCodesRecordMark).sendKeys(recordMark);
        System.out.println("Entered new Record Mark");
        Log.info("log4j msg- Entered new Record Mark");
        
        
        
        
        //click save
        wait.until(ExpectedConditions.visibilityOfElementLocated(UMCaseStatusCodesSaveLink));
        driver.findElement(UMCaseStatusCodesSaveLink).click();
        System.out.println("Clicked save");
        Log.info("log4j msg- clicked save");
          BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
		}
        
		else{System.out.println("UM Case Status Codes not found, cannot edit UM Case Status Codes");
        Log.info("log4j msg- UM Case Status Codes not found, cannot edit UM Case Status Codes");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}
		
		}catch (Exception e){ e.printStackTrace();System.out.println("Error in Editing UM Case Status Codes ");
        Log.info("log4j msg- Error in Editing UM Case Status Codes ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}


        }
//exit function
public void exitUMCaseStatusCodes( String UMCaseStatusCodesCode) throws Exception{
try{  System.out.println("UM Case Status Codes code"+UMCaseStatusCodesCode);
        Log.info("log4j msg- UM Case Status Codes code"+UMCaseStatusCodesCode);
                         Thread.sleep(1000);
                        driver.findElement(UMCaseStatusCodesExitLink).click();
                        Thread.sleep(1000);
                        System.out.println("Clicked exit in  UM Case Status Codes ");
                        Log.info("log4j msg- clicked exit in  UM Case Status Codes ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                          
}catch (Exception e){ e.printStackTrace();System.out.println("Error in Exiting UM Case Status Codes ");
Log.info("log4j msg- Error in Exiting UM Case Status Codes ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}}

//add comm function
public void addCommUMCaseStatusCodes( String UMCaseStatusCodesCode, String UMCaseStatusCodesName, String UMCaseStatusCodesCommsubject, String UMCaseStatusCodesCommNoteType, String UMCaseStatusCodesCommMedium, String UMCaseStatusCodesCommDetails) throws Exception{
        
        try{ 
        int i= searchUMCaseStatusCodes( UMCaseStatusCodesCode, UMCaseStatusCodesName);
		
		if (i==1){
			System.out.println("UM Case Status Codes  found, Continue with Add Communication");
			Log.info("log4j msg- UM Case Status Codes  found, Continue with Add Communication");
		
		
        System.out.println("UM Case Status Codes code"+UMCaseStatusCodesCode);
        Log.info("log4j msg- UM Case Status Codes code"+UMCaseStatusCodesCode);
                        //find UMCaseStatusCodes
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+UMCaseStatusCodesCode+"']")));
        driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+UMCaseStatusCodesCode+"']")).click();
        System.out.println("clicked UM Case Status Codes Code");
        Log.info("log4j msg- clicked UM Case Status Codes code");
        
                                        //click comm
                                        
        wait.until(ExpectedConditions.visibilityOfElementLocated(UMCaseStatusCodesCommLink));
        driver.findElement(UMCaseStatusCodesCommLink).click();
        System.out.println("clicked Comm");
        Log.info("log4j msg- clicked Comm");

                                        
                                        
                                        //click add
                                         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")));
                                        driver.findElement(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")).click();
                                        
                                        System.out.println("clicked Add");
                                        Log.info("log4j msg- clicked Add");
                                        
                                        //enter subject
                                        //<input type="text" id="txtSubject" tabindex="1" class="form-control ng-pristine ng-valid ng-empty ng-valid-maxlength ng-touched" maxlength="70" data-ng-model="currentRecord.subject" data-ng-disabled="isAuditing" style="width: 100%;">
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtSubject']")));
                                        driver.findElement(By.xpath("//input[@id='txtSubject']")).sendKeys(UMCaseStatusCodesCommsubject);
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
                                        Select umcasestatusCodes = new Select(driver.findElement(By.xpath("//select[@id='ddlNoteType']")));
                                        umcasestatusCodes.selectByVisibleText(UMCaseStatusCodesCommNoteType);
                                        System.out.println("selected note type");
                                        Log.info("log4j msg-selected note type");
                                        
                                        Thread.sleep(1000);
                                        //enter note details
                                          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='txtNotes']")));
                                        driver.findElement(By.xpath("//textarea[@id='txtNotes']")).sendKeys(UMCaseStatusCodesCommDetails);
                                        System.out.println("entered notes details");
                                        Log.info("log4j msg- entered notes details");
                                        Thread.sleep(1000);
                                        
                                        
                                        //click hide
                                        //<button class="btn btn-secondary btn-bottom01 pull-right" type="button" data-dismiss="modal" aria-hidden="true" data-ng-click="closeMe()">Hide</button>
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
                                        
                         catch (Exception e){e.printStackTrace();System.out.println("Error in adding Comm to UM Case Status Codes");
                                                                                                        Log.info("log4j msg - Error in adding Comm to  UM Case Status Codes"); 
         BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();   }   
                         
                         }
        


//delete function
public void deleteUMCaseStatusCodes( String UMCaseStatusCodesCode, String UMCaseStatusCodesDescription) throws Exception{
        
        try{            
        int i= searchUMCaseStatusCodes( UMCaseStatusCodesCode, UMCaseStatusCodesDescription);
		
		if (i==1){
			System.out.println("UM Case Status Codes found, continue with delete");
			Log.info("log4j msg-UM Case Status Codes found, continue with delete");
			
        //find UMCaseStatusCodes
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+UMCaseStatusCodesCode+"']")));
                                        driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+UMCaseStatusCodesCode+"']")).click();
                                        System.out.println("clicked UM Case Status Codes Code");
                                        Log.info("log4j msg- clicked UM Case Status Codes code");
                        
                                        //click delete
                                        
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(UMCaseStatusCodesDeleteLink));
                                        driver.findElement(UMCaseStatusCodesDeleteLink).click();
                                        System.out.println("clicked Delete");
                                        Log.info("log4j msg- clicked Delete");
                                        
        
                                        //click confirm delete
                                        
                                        
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmDeleteButton));
                                        driver.findElement(confirmDeleteButton).click();
                                        System.out.println("clicked confirm Delete");
                                        Log.info("log4j msg- clicked confirm Delete");
                                         BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                                        
                                        
        




} else{
System.out.println("cannot find UM Case Status Codes, cannot delete UM Case Status Codes ");
Log.info("log4j msg- cannot find UM Case Status Codes, cannot delete UM Case Status Codes ");
wait.until(ExpectedConditions.visibilityOfElementLocated(UMCaseStatusCodesExitLink));
driver.findElement(UMCaseStatusCodesExitLink).click();
System.out.println("clicked Exit");
Log.info("log4j msg- clicked Exit");


BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();

}} catch (Exception e){System.out.println("Error in deleting UM Case Status Codes ");
Log.info("log4j msg - Error in deleting UM Case Status Codes "); 

}   
}


}





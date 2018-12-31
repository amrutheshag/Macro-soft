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

public class TreatmentFollowupActions {
	
	WebDriver driver;
	WebDriverWait wait ;   
	
	By TreatmentFollowupActionsCodeBeginsInput = By.xpath("//input[@id='txtCode']");
	
	By TreatmentFollowupActionsNameDescriptionBeginsInput = By.xpath("//input[@id='txtName']");
	
	By TreatmentFollowupActionsSearchButton= By.xpath("//button[@data-ng-click='search(0)']");
    
	By TreatmentFollowupActionsAddLink= By.linkText("Add");
    
    By TreatmentFollowupActionsCodeInput = By.xpath("//input[@id='code']");
    
    By TreatmentFollowupActionsDescriptionInput= By.xpath("//input[@id='name']");
    
    By TreatmentFollowupActionsRecordMark= By.xpath("//input[@style='width:20px;']");
    
    By TreatmentFollowupActionsValidateLink =By.linkText("Validate");
    
    By TreatmentFollowupActionsValidateSaveOKButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By TreatmentFollowupActionsSaveLink =  By.linkText("Save");
    
    By TreatmentFollowupActionsEditLink = By.linkText("Edit");
    
    By TreatmentFollowupActionsCopyLink = By.linkText("Copy");
    
    By TreatmentFollowupActionsDeleteLink= By.linkText("Delete");
    
    By confirmDeleteButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By TreatmentFollowupActionsCommLink= By.linkText("Commun.");
    
    By TreatmentFollowupActionsExitLink=  By.linkText("Exit");
    
    
    
    
    public TreatmentFollowupActions(WebDriver driver){
        this.driver= driver;
        this.wait= new WebDriverWait(driver, 35); 
}



public int searchTreatmentFollowupActions( String TreatmentFollowupActionsCode, String TreatmentFollowupActionsName) throws Exception{

try{
//enter  Initial Response at Intakes code
wait.until(ExpectedConditions.visibilityOfElementLocated(TreatmentFollowupActionsCodeBeginsInput));
driver.findElement(TreatmentFollowupActionsCodeBeginsInput).clear();
driver.findElement(TreatmentFollowupActionsCodeBeginsInput).sendKeys(TreatmentFollowupActionsCode);
System.out.println("entered Initial Response at Intakes  code");
Log.info("log4j msg- entered Initial Response at Intakes code");


//enter  Initial Response at Intakes name
wait.until(ExpectedConditions.visibilityOfElementLocated(TreatmentFollowupActionsNameDescriptionBeginsInput));
driver.findElement(TreatmentFollowupActionsNameDescriptionBeginsInput).clear();
driver.findElement(TreatmentFollowupActionsNameDescriptionBeginsInput).sendKeys(TreatmentFollowupActionsName);
System.out.println("entered Initial Response at Intakes name");
Log.info("log4j msg- entered Initial Response at Intakes name");

//click search
wait.until(ExpectedConditions.visibilityOfElementLocated(TreatmentFollowupActionsSearchButton));
driver.findElement(TreatmentFollowupActionsSearchButton).click();
System.out.println("clicked Search");
Log.info("log4j msg- clicked Search");
	
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+TreatmentFollowupActionsCode+"']")));
WebElement e = driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+TreatmentFollowupActionsCode+"']"));
e.click();
System.out.println("Found TreatmentFollowupActions");
Log.info("log4j msg- Found TreatmentFollowupActions");

return 1;
}

catch(Exception e){System.out.println("Treatment Followup actions not found"); Log.info("log4j msg- Treatment Followup actions not found");return 0;}

}

//add function
public void addTreatmentFollowupActions( String TreatmentFollowupActionsCode, String TreatmentFollowupActionsDescription)throws Exception{

        try{ 
        int i= searchTreatmentFollowupActions(TreatmentFollowupActionsCode, TreatmentFollowupActionsDescription);
		
		if (i==0){
			System.out.println("Initial Response at Intakes not found, Continue with Add");
			Log.info("log4j msg- Initial Response at Intakes not found, Continue with Add");
		
		
        wait.until(ExpectedConditions.visibilityOfElementLocated(TreatmentFollowupActionsAddLink));
        driver.findElement(TreatmentFollowupActionsAddLink).click();
        System.out.println("clicked Add");
        Log.info("log4j msg- clicked Add");
        
        
        System.out.println("Initial Response at Intakes code: "+TreatmentFollowupActionsCode);
        Log.info("log4j msg- Initial Response at Intakes code: "+TreatmentFollowupActionsCode);
        //enter code
        wait.until(ExpectedConditions.visibilityOfElementLocated(TreatmentFollowupActionsCodeInput));
        driver.findElement(TreatmentFollowupActionsCodeInput).sendKeys(TreatmentFollowupActionsCode);
        Thread.sleep(1000);
        System.out.println("Entered code");
        Log.info("log4j msg- Entered code");
        
        System.out.println("Initial Response at Intakes description"+TreatmentFollowupActionsDescription);
        Log.info("log4j msg- Initial Response at Intakes code: "+TreatmentFollowupActionsDescription);
        //enter Description
        wait.until(ExpectedConditions.visibilityOfElementLocated(TreatmentFollowupActionsDescriptionInput));
        driver.findElement(TreatmentFollowupActionsDescriptionInput).sendKeys(TreatmentFollowupActionsDescription);
        Thread.sleep(1000);
        System.out.println("Entered description");
        Log.info("log4j msg- Entered description");

        
        //click validate

        
        wait.until(ExpectedConditions.visibilityOfElementLocated(TreatmentFollowupActionsValidateLink));
        driver.findElement(TreatmentFollowupActionsValidateLink).click();
        System.out.println("clicked validate");
        Log.info("log4j msg- clicked validate");
        
        //click ok
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(TreatmentFollowupActionsValidateSaveOKButton));
        driver.findElement(TreatmentFollowupActionsValidateSaveOKButton).click();
        System.out.println("clicked validate ok to save button");
        Log.info("log4j msg- clicked validate ok to save button");
        
		
        //click save
        Thread.sleep(1000);
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(TreatmentFollowupActionsSaveLink));
        driver.findElement(TreatmentFollowupActionsSaveLink).click();
        System.out.println("clicked save ");
        Log.info("log4j msg- clicked  save ");
          BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
        
        } else{
			System.out.println("Initial Response at Intakes is already present, cannot add Initial Response at Intakes");
			Log.info("log4j msg- Initial Response at Intakes is already present, cannot add Initial Response at Intakes");
			wait.until(ExpectedConditions.visibilityOfElementLocated(TreatmentFollowupActionsExitLink));
			driver.findElement(TreatmentFollowupActionsExitLink).click();
			System.out.println("clicked Exit");
			Log.info("log4j msg- clicked Exit");
			
			 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
		}

        }catch (Exception e){System.out.println("Error in adding Initial Response at Intakes");Log.info("log4j msg- Error in adding Initial Response at Intakes"); }
		}
        
//copy function

public void copyTreatmentFollowupActions( String TreatmentFollowupActionsCode, String TreatmentFollowupActionsName, String newTreatmentFollowupActionsCode, String newTreatmentFollowupActionsDescription)throws Exception{
        
        try{  
        int i= searchTreatmentFollowupActions( TreatmentFollowupActionsCode, TreatmentFollowupActionsName);
		
		if (i==1){
			System.out.println("Initial Response at Intakes found, continue with copy");
			Log.info("log4j msg-Initial Response at Intakes found, continue with copy");
		
        
        System.out.println("Initial Response at Intakes code"+TreatmentFollowupActionsCode);
        Log.info("log4j msg-Initial Response at Intakes code"+TreatmentFollowupActionsCode);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+TreatmentFollowupActionsCode+"']")));
        driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+TreatmentFollowupActionsCode+"']")).click();
        System.out.println("clicked Initial Response at Intakes Code");
        Log.info("log4j msg- clicked Initial Response at Intakes code");
        
        
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(TreatmentFollowupActionsCopyLink));
        driver.findElement(TreatmentFollowupActionsCopyLink).click();
        System.out.println("clicked Copy");
        Log.info("log4j msg- clicked Copy");
        
        System.out.println("Initial Response at Intakes new code"+newTreatmentFollowupActionsCode);
        Log.info("log4j msg- Initial Response at Intakes new code"+newTreatmentFollowupActionsCode);
        //enter new code
        wait.until(ExpectedConditions.visibilityOfElementLocated(TreatmentFollowupActionsCodeInput));
        driver.findElement(TreatmentFollowupActionsCodeInput).clear();
        driver.findElement(TreatmentFollowupActionsCodeInput).sendKeys(newTreatmentFollowupActionsCode);
        System.out.println("Entered new code");
        Log.info("log4j msg- Entered new code");

        System.out.println("Initial Response at Intakes new description"+newTreatmentFollowupActionsDescription);
        Log.info("log4j msg- Initial Response at Intakes new description"+newTreatmentFollowupActionsDescription);
//enter new description
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(TreatmentFollowupActionsDescriptionInput));
        driver.findElement(TreatmentFollowupActionsDescriptionInput).clear();
        driver.findElement(TreatmentFollowupActionsDescriptionInput).sendKeys(newTreatmentFollowupActionsDescription);
        System.out.println("Entered new description");
        Log.info("log4j msg- Entered new description");
        
        
        
        
        
        //click save
        wait.until(ExpectedConditions.visibilityOfElementLocated(TreatmentFollowupActionsSaveLink));
        driver.findElement(TreatmentFollowupActionsSaveLink).click();

        System.out.println("Clicked save");
        Log.info("log4j msg- clicked save");
          BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
		
        
		
        } else{
			System.out.println("Initial Response at Intakes is not present, cannot copy Initial Response at Intakes");
			Log.info("log4j msg- Initial Response at Intakes is not present, cannot copy Initial Response at Intakes");
			wait.until(ExpectedConditions.visibilityOfElementLocated(TreatmentFollowupActionsExitLink));
			driver.findElement(TreatmentFollowupActionsExitLink).click();
			System.out.println("clicked Exit");
			Log.info("log4j msg- clicked Exit");
			
			 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
		}

        }catch (Exception e){System.out.println("Error in copying Initial Response at Intakes");Log.info("log4j msg- Error in copying Initial Response at Intakes"); }
		}
		
		





//edit function
public void editTreatmentFollowupActions( String TreatmentFollowupActionsCode, String treatmentfollowupActionsDescription, String recordMark)throws Exception{
        
        try{ 
        int i= searchTreatmentFollowupActions( TreatmentFollowupActionsCode, treatmentfollowupActionsDescription);
		
		if (i==1){
			System.out.println("Initial Response at Intakes  found, Continue with Edit");
			Log.info("log4j msg- Initial Response at Intakes  found, Continue with Edit");
		
		
        System.out.println("Initial Response at Intakes code"+TreatmentFollowupActionsCode);
        Log.info("log4j msg- Initial Response at Intakes code"+TreatmentFollowupActionsCode);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+TreatmentFollowupActionsCode+"']")));
        driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+TreatmentFollowupActionsCode+"']")).click();
        System.out.println("clicked Initial Response at Intakes Record Mark");
        Log.info("log4j msg- clicked Initial Response at Intakes Record Mark");
        
        
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(TreatmentFollowupActionsEditLink));
        driver.findElement(TreatmentFollowupActionsEditLink).click();
        System.out.println("clicked Edit");
        Log.info("log4j msg- clicked Edit");
        
        System.out.println("Initial Response at Intakes Record Mark"+recordMark);
        Log.info("log4j msg-Initial Response at Intakes Record Mark"+recordMark);
                                       
//enter new description
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(TreatmentFollowupActionsRecordMark));
       driver.findElement(TreatmentFollowupActionsRecordMark).clear();
        Thread.sleep(1000);
        driver.findElement(TreatmentFollowupActionsRecordMark).sendKeys(recordMark);
        System.out.println("Entered new Record Mark");
        Log.info("log4j msg- Entered new Record Mark");
        
        
        
        
        //click save
        wait.until(ExpectedConditions.visibilityOfElementLocated(TreatmentFollowupActionsSaveLink));
        driver.findElement(TreatmentFollowupActionsSaveLink).click();
        System.out.println("Clicked save");
        Log.info("log4j msg- clicked save");
          BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
		}
        
		else{System.out.println("Initial Response at Intakes not found, cannot edit Initial Response at Intakes");
        Log.info("log4j msg- Initial Response at Intakes not found, cannot edit Initial Response at Intakes");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}
		
		}catch (Exception e){ e.printStackTrace();System.out.println("Error in Editing Initial Response at Intakes ");
        Log.info("log4j msg- Error in Editing Initial Response at Intakes ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}


        }
//exit function
public void exitTreatmentFollowupActions( String TreatmentFollowupActionsCode) throws Exception{
try{
        System.out.println("Initial Response at Intakes code"+TreatmentFollowupActionsCode);
        Log.info("log4j msg- Initial Response at Intakes code"+TreatmentFollowupActionsCode);
                        Thread.sleep(1000);
                        driver.findElement(TreatmentFollowupActionsExitLink).click();
                        Thread.sleep(1000);
                        System.out.println("Clicked exit in  Initial Response at Intakes ");
                        Log.info("log4j msg- clicked exit in  Initial Response at Intakes ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                        
}catch (Exception e){ e.printStackTrace();System.out.println("Error in Exiting Initial Response at Intakes ");
Log.info("log4j msg- Error in Exiting Initial Response at Intakes ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}}

//add comm function
public void addCommTreatmentFollowupActions( String TreatmentFollowupActionsCode, String TreatmentFollowupActionsName, String TreatmentFollowupActionsCommsubject, String TreatmentFollowupActionsCommNoteType, String TreatmentFollowupActionsCommMedium, String TreatmentFollowupActionsCommDetails) throws Exception{
        
        try{
        int i= searchTreatmentFollowupActions(TreatmentFollowupActionsCode, TreatmentFollowupActionsName);
		
		if (i==1){
			System.out.println("Initial Response at Intakes  found, Continue with Add Communication");
			Log.info("log4j msg- Initial Response at Intakes  found, Continue with Add Communication");
		
		
        System.out.println("Initial Response at Intakes code"+TreatmentFollowupActionsCode);
        Log.info("log4j msg- Initial Response at Intakes code"+TreatmentFollowupActionsCode);
                        //find TreatmentFollowupActions
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+TreatmentFollowupActionsCode+"']")));
        driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+TreatmentFollowupActionsCode+"']")).click();
        System.out.println("clicked Initial Response at Intakes Code");
        Log.info("log4j msg- clicked Initial Response at Intakes code");
        
                                        //click comm
                                        
        wait.until(ExpectedConditions.visibilityOfElementLocated(TreatmentFollowupActionsCommLink));
        driver.findElement(TreatmentFollowupActionsCommLink).click();
        System.out.println("clicked Comm");
        Log.info("log4j msg- clicked Comm");

                                        
                                        
                                        //click add
                                         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")));
                                        driver.findElement(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")).click();
                                        
                                          System.out.println("clicked Add");
                                        Log.info("log4j msg- clicked Add");
                                        
                                        //enter subject
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtSubject']")));
                                        driver.findElement(By.xpath("//input[@id='txtSubject']")).sendKeys(TreatmentFollowupActionsCommsubject);
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
                                        
                                        Thread.sleep(3000);
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlNoteType"))); 
                                        Thread.sleep(3000);

                                        Select treatmentfollowupActions = new Select(driver.findElement(By.xpath("//select[@id='ddlNoteType']")));
                                        Thread.sleep(5000);
                                        treatmentfollowupActions.selectByVisibleText(TreatmentFollowupActionsCommNoteType);
                                        System.out.println("selected note type");
                                        Log.info("log4j msg-selected note type");
                                        
                                        Thread.sleep(1000);
                                        //enter note details
                                         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='txtNotes']")));
                                        driver.findElement(By.xpath("//textarea[@id='txtNotes']")).sendKeys(TreatmentFollowupActionsCommDetails);
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
                                        
                         catch (Exception e){e.printStackTrace();System.out.println("Error in adding Comm to Initial Response at Intakes");
                                                                                                        Log.info("log4j msg - Error in adding Comm to  Initial Response at Intakes"); 
         BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();   }   
                         
                         }
        


//delete function
public void deleteTreatmentFollowupActions( String TreatmentFollowupActionsCode, String TreatmentFollowupActionsDescription) throws Exception{
        
        try{            
        int i= searchTreatmentFollowupActions( TreatmentFollowupActionsCode, TreatmentFollowupActionsDescription);
		
		if (i==1){
			System.out.println("Initial Response at Intakes found, continue with delete");
			Log.info("log4j msg-Initial Response at Intakes found, continue with delete");
			
        //find TreatmentFollowupActions
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+TreatmentFollowupActionsCode+"']")));
                                        driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+TreatmentFollowupActionsCode+"']")).click();
                                        System.out.println("clicked Initial Response at Intakes Code");
                                        Log.info("log4j msg- clicked Initial Response at Intakes code");
                        
                                        //click delete
                                        
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(TreatmentFollowupActionsDeleteLink));
                                        driver.findElement(TreatmentFollowupActionsDeleteLink).click();
                                        System.out.println("clicked Delete");
                                        Log.info("log4j msg- clicked Delete");
                                        
        
                                        //click confirm delete
                                        
                                        
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmDeleteButton));
                                        driver.findElement(confirmDeleteButton).click();
                                        System.out.println("clicked confirm Delete");
                                        Log.info("log4j msg- clicked confirm Delete");
                                         BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                                        
                                        
        




} else{
System.out.println("cannot find Initial Response at Intakes, cannot delete Initial Response at Intakes ");
Log.info("log4j msg- cannot find Initial Response at Intakes, cannot delete Initial Response at Intakes ");
wait.until(ExpectedConditions.visibilityOfElementLocated(TreatmentFollowupActionsExitLink));
driver.findElement(TreatmentFollowupActionsExitLink).click();
System.out.println("clicked Exit");
Log.info("log4j msg- clicked Exit");


BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();

}} catch (Exception e){System.out.println("Error in deleting Initial Response at Intakes ");
Log.info("log4j msg - Error in deleting Initial Response at Intakes "); 

}   
}


}





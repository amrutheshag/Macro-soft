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

public class CommunicationCasePriorities {

	WebDriver driver;
	WebDriverWait wait;
	
	By CommunicationCasePrioritiesCodeBeginsInput = By.xpath("//input[@id='txtCode']");
	
	By CommunicationCasePrioritiesNameDescriptionBeginsInput = By.xpath("//input[@id='txtName']");
	
	By CommunicationCasePrioritiesSearchButton= By.xpath("//button[@data-ng-click='search(0)']");
    
    By CommunicationCasePrioritiesAddLink= By.linkText("Add");
    
    By CommunicationCasePrioritiesCodeInput = By.xpath("//input[@id='code']");
    
    By CommunicationCasePrioritiesDescriptionInput= By.xpath("//input[@id='name']");
    
    By CommunicationCasePrioritiesRecordMark= By.xpath("//input[@style='width:20px;']");
    
    By CommunicationCasePrioritiesValidateLink =By.linkText("Validate");
    
    By CommunicationCasePrioritiesValidateSaveOKButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By CommunicationCasePrioritiesSaveLink =  By.linkText("Save");
    
    By CommunicationCasePrioritiesEditLink = By.linkText("Edit");
    
    By CommunicationCasePrioritiesCopyLink = By.linkText("Copy");
    
    By CommunicationCasePrioritiesDeleteLink= By.linkText("Delete");
    
    By confirmDeleteButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By CommunicationCasePrioritiesCommLink= By.linkText("Commun.");
  
    By CommunicationCasePrioritiesExitLink=  By.linkText("Exit");
    
    
    
    
    public CommunicationCasePriorities(WebDriver driver){
        this.driver= driver;
        this.wait = new WebDriverWait(driver, 25);
}


public int searchCommunicationCasePriorities( String CommunicationCasePrioritiesCode, String CommunicationCasePrioritiesName) throws Exception{

try{
//enter  Communication Case Priorities code
wait.until(ExpectedConditions.visibilityOfElementLocated(CommunicationCasePrioritiesCodeBeginsInput));
driver.findElement(CommunicationCasePrioritiesCodeBeginsInput).clear();
driver.findElement(CommunicationCasePrioritiesCodeBeginsInput).sendKeys(CommunicationCasePrioritiesCode);
System.out.println("entered Communication Case Priorities  code");
Log.info("log4j msg- entered Communication Case Priorities code");


//enter  Communication Case Priorities name
wait.until(ExpectedConditions.visibilityOfElementLocated(CommunicationCasePrioritiesNameDescriptionBeginsInput));
driver.findElement(CommunicationCasePrioritiesNameDescriptionBeginsInput).clear();
driver.findElement(CommunicationCasePrioritiesNameDescriptionBeginsInput).sendKeys(CommunicationCasePrioritiesName);
System.out.println("entered Communication Case Priorities name");
Log.info("log4j msg- entered Communication Case Priorities name");

//click search
wait.until(ExpectedConditions.visibilityOfElementLocated(CommunicationCasePrioritiesSearchButton));
driver.findElement(CommunicationCasePrioritiesSearchButton).click();
System.out.println("clicked Search");
Log.info("log4j msg- clicked Search");
	
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+CommunicationCasePrioritiesCode+"']")));
WebElement e = driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+CommunicationCasePrioritiesCode+"']"));
e.click();
System.out.println("Found CommunicationCasePriorities");
Log.info("log4j msg- Found CommunicationCasePriorities");

return 1;
}

catch(Exception e){System.out.println("Communication Case Priorities not found"); Log.info("log4j msg- Communication Case Priorities not found");return 0;}

}

//add function
public void addCommunicationCasePriorities( String CommunicationCasePrioritiesCode, String CommunicationCasePrioritiesDescription)throws Exception{

        try{ 
        
        int i= searchCommunicationCasePriorities(CommunicationCasePrioritiesCode, CommunicationCasePrioritiesDescription);
		
		if (i==0){
			System.out.println("Communication Case Priorities not found, Continue with Add");
			Log.info("log4j msg- Communication Case Priorities not found, Continue with Add");
		
		
        wait.until(ExpectedConditions.visibilityOfElementLocated(CommunicationCasePrioritiesAddLink));
        driver.findElement(CommunicationCasePrioritiesAddLink).click();
        System.out.println("clicked Add");
        Log.info("log4j msg- clicked Add");
        
        
        System.out.println("Communication Case Priorities code: "+CommunicationCasePrioritiesCode);
        Log.info("log4j msg- Communication Case Priorities code: "+CommunicationCasePrioritiesCode);
        //enter code
        wait.until(ExpectedConditions.visibilityOfElementLocated(CommunicationCasePrioritiesCodeInput));
        driver.findElement(CommunicationCasePrioritiesCodeInput).sendKeys(CommunicationCasePrioritiesCode);
        Thread.sleep(1000);
        System.out.println("Entered code");
        Log.info("log4j msg- Entered code");
        
        System.out.println("Communication Case Priorities description"+CommunicationCasePrioritiesDescription);
        Log.info("log4j msg- Communication Case Priorities code: "+CommunicationCasePrioritiesDescription);
        //enter Description
        wait.until(ExpectedConditions.visibilityOfElementLocated(CommunicationCasePrioritiesDescriptionInput));
        driver.findElement(CommunicationCasePrioritiesDescriptionInput).sendKeys(CommunicationCasePrioritiesDescription);
        Thread.sleep(1000);
        System.out.println("Entered description");
        Log.info("log4j msg- Entered description");

        
        //click validate

        
        wait.until(ExpectedConditions.visibilityOfElementLocated(CommunicationCasePrioritiesValidateLink));
        driver.findElement(CommunicationCasePrioritiesValidateLink).click();
        System.out.println("clicked validate");
        Log.info("log4j msg- clicked validate");
        
        //click ok
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(CommunicationCasePrioritiesValidateSaveOKButton));
        driver.findElement(CommunicationCasePrioritiesValidateSaveOKButton).click();
        System.out.println("clicked validate ok to save button");
        Log.info("log4j msg- clicked validate ok to save button");
        
		
        //click save
        Thread.sleep(1000);
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(CommunicationCasePrioritiesSaveLink));
        driver.findElement(CommunicationCasePrioritiesSaveLink).click();
        System.out.println("clicked save ");
        Log.info("log4j msg- clicked  save ");
        Thread.sleep(1000);
          BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
          driver.quit(); 

        
        } else{
			System.out.println("Communication Case Priorities is already present, cannot add Communication Case Priorities");
			Log.info("log4j msg- Communication Case Priorities is already present, cannot add Communication Case Priorities");
			wait.until(ExpectedConditions.visibilityOfElementLocated(CommunicationCasePrioritiesExitLink));
			driver.findElement(CommunicationCasePrioritiesExitLink).click();
			System.out.println("clicked Exit");
			Log.info("log4j msg- clicked Exit");
			 Thread.sleep(1000);
			
			 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
			 driver.quit(); 
		}

        }catch (Exception e){System.out.println("Error in adding Communication Case Priorities");Log.info("log4j msg- Error in adding Communication Case Priorities"); }
		}
        
//copy function

public void copyCommunicationCasePriorities( String CommunicationCasePrioritiesCode, String CommunicationCasePrioritiesName, String newCommunicationCasePrioritiesCode, String newCommunicationCasePrioritiesDescription)throws Exception{
        
        try{ 
        
        int i= searchCommunicationCasePriorities( CommunicationCasePrioritiesCode, CommunicationCasePrioritiesName);
		
		if (i==1){
			System.out.println("Communication Case Priorities found, continue with copy");
			Log.info("log4j msg-Communication Case Priorities found, continue with copy");
		
        
        System.out.println("Communication Case Priorities code"+CommunicationCasePrioritiesCode);
        Log.info("log4j msg-Communication Case Priorities code"+CommunicationCasePrioritiesCode);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+CommunicationCasePrioritiesCode+"']")));
        driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+CommunicationCasePrioritiesCode+"']")).click();
        System.out.println("clicked Communication Case Priorities Code");
        Log.info("log4j msg- clicked Communication Case Priorities code");
        
        
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(CommunicationCasePrioritiesCopyLink));
        driver.findElement(CommunicationCasePrioritiesCopyLink).click();
        System.out.println("clicked Copy");
        Log.info("log4j msg- clicked Copy");
        
        System.out.println("Communication Case Priorities new code"+newCommunicationCasePrioritiesCode);
        Log.info("log4j msg- Communication Case Priorities new code"+newCommunicationCasePrioritiesCode);
        //enter new code
        wait.until(ExpectedConditions.visibilityOfElementLocated(CommunicationCasePrioritiesCodeInput));
        driver.findElement(CommunicationCasePrioritiesCodeInput).clear();
        driver.findElement(CommunicationCasePrioritiesCodeInput).sendKeys(newCommunicationCasePrioritiesCode);
        System.out.println("Entered new code");
        Log.info("log4j msg- Entered new code");

        System.out.println("Communication Case Priorities new description"+newCommunicationCasePrioritiesDescription);
        Log.info("log4j msg- Communication Case Priorities new description"+newCommunicationCasePrioritiesDescription);
//enter new description
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(CommunicationCasePrioritiesDescriptionInput));
        driver.findElement(CommunicationCasePrioritiesDescriptionInput).clear();
        driver.findElement(CommunicationCasePrioritiesDescriptionInput).sendKeys(newCommunicationCasePrioritiesDescription);
        System.out.println("Entered new description");
        Log.info("log4j msg- Entered new description");
        
        
        
        
        
        //click save
        wait.until(ExpectedConditions.visibilityOfElementLocated(CommunicationCasePrioritiesSaveLink));
        driver.findElement(CommunicationCasePrioritiesSaveLink).click();

        System.out.println("Clicked save");
        Log.info("log4j msg- clicked save");
        Thread.sleep(1000);
          BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
          driver.quit(); 
		
        
		
        } else{
			System.out.println("Communication Case Priorities is not present, cannot copy Communication Case Priorities");
			Log.info("log4j msg- Communication Case Priorities is not present, cannot copy Communication Case Priorities");
			wait.until(ExpectedConditions.visibilityOfElementLocated(CommunicationCasePrioritiesExitLink));
			driver.findElement(CommunicationCasePrioritiesExitLink).click();
			System.out.println("clicked Exit");
			Log.info("log4j msg- clicked Exit");
			 Thread.sleep(1000);
			
			 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
			 driver.quit(); 
		}

        }catch (Exception e){System.out.println("Error in copying Communication Case Priorities");Log.info("log4j msg- Error in copying Communication Case Priorities"); }
		}
		
		





//edit function
public void editCommunicationCasePriorities( String CommunicationCasePrioritiesCode, String communicationcasePrioritiesDescription, String recordMark)throws Exception{
        
        try{ 
        
        int i= searchCommunicationCasePriorities( CommunicationCasePrioritiesCode, communicationcasePrioritiesDescription);
		
		if (i==1){
			System.out.println("Communication Case Priorities  found, Continue with Edit");
			Log.info("log4j msg- Communication Case Priorities  found, Continue with Edit");
		
		
        System.out.println("Communication Case Priorities code"+CommunicationCasePrioritiesCode);
        Log.info("log4j msg- Communication Case Priorities code"+CommunicationCasePrioritiesCode);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+CommunicationCasePrioritiesCode+"']")));
        driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+CommunicationCasePrioritiesCode+"']")).click();
        System.out.println("clicked Communication Case Priorities Record Mark");
        Log.info("log4j msg- clicked Communication Case Priorities Record Mark");
        
        
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(CommunicationCasePrioritiesEditLink));
        driver.findElement(CommunicationCasePrioritiesEditLink).click();
        System.out.println("clicked Edit");
        Log.info("log4j msg- clicked Edit");
        
        System.out.println("Communication Case Priorities Record Mark"+recordMark);
        Log.info("log4j msg-Communication Case Priorities Record Mark"+recordMark);
                                       
//enter new description
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(CommunicationCasePrioritiesRecordMark));
       driver.findElement(CommunicationCasePrioritiesRecordMark).clear();
        Thread.sleep(1000);
        driver.findElement(CommunicationCasePrioritiesRecordMark).sendKeys(recordMark);
        System.out.println("Entered new Record Mark");
        Log.info("log4j msg- Entered new Record Mark");
        
        
        
        
        //click save
        wait.until(ExpectedConditions.visibilityOfElementLocated(CommunicationCasePrioritiesSaveLink));
        driver.findElement(CommunicationCasePrioritiesSaveLink).click();
        System.out.println("Clicked save");
        Log.info("log4j msg- clicked save");
        Thread.sleep(1000);
          BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
          driver.quit();
		}
        
		else{System.out.println("Communication Case Priorities not found, cannot edit Communication Case Priorities");
        Log.info("log4j msg- Communication Case Priorities not found, cannot edit Communication Case Priorities");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
        driver.quit(); }
		
		}catch (Exception e){ e.printStackTrace();System.out.println("Error in Editing Communication Case Priorities ");
        Log.info("log4j msg- Error in Editing Communication Case Priorities ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
        driver.quit();}


        }
//exit function
public void exitCommunicationCasePriorities( String CommunicationCasePrioritiesCode) throws Exception{
try{
         System.out.println("Communication Case Priorities code"+CommunicationCasePrioritiesCode);
        Log.info("log4j msg- Communication Case Priorities code"+CommunicationCasePrioritiesCode);
                         Thread.sleep(1000);
                        driver.findElement(CommunicationCasePrioritiesExitLink).click();
                        Thread.sleep(1000);
                        System.out.println("Clicked exit in  Communication Case Priorities ");
                        Log.info("log4j msg- clicked exit in  Communication Case Priorities ");  
                        Thread.sleep(1000);
                        BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                        driver.quit(); 
                          
}catch (Exception e){ e.printStackTrace();System.out.println("Error in Exiting Communication Case Priorities ");
Log.info("log4j msg- Error in Exiting Communication Case Priorities ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
driver.quit(); }}

//add comm function
public void addCommCommunicationCasePriorities( String CommunicationCasePrioritiesCode, String CommunicationCasePrioritiesName, String CommunicationCasePrioritiesCommsubject, String CommunicationCasePrioritiesCommNoteType, String CommunicationCasePrioritiesCommMedium, String CommunicationCasePrioritiesCommDetails) throws Exception{
        
        try{         
        
        int i= searchCommunicationCasePriorities( CommunicationCasePrioritiesCode, CommunicationCasePrioritiesName);
		
		if (i==1){
			System.out.println("Communication Case Priorities  found, Continue with Add Communication");
			Log.info("log4j msg- Communication Case Priorities  found, Continue with Add Communication");
		
		
        System.out.println("Communication Case Priorities code"+CommunicationCasePrioritiesCode);
        Log.info("log4j msg- Communication Case Priorities code"+CommunicationCasePrioritiesCode);
                        //find CommunicationCasePriorities
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+CommunicationCasePrioritiesCode+"']")));
        driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+CommunicationCasePrioritiesCode+"']")).click();
        System.out.println("clicked Communication Case Priorities Code");
        Log.info("log4j msg- clicked Communication Case Priorities code");
        
                                        //click comm
                                        
        wait.until(ExpectedConditions.visibilityOfElementLocated(CommunicationCasePrioritiesCommLink));
        driver.findElement(CommunicationCasePrioritiesCommLink).click();
        System.out.println("clicked Comm");
        Log.info("log4j msg- clicked Comm");

                                        
                                        
                                      
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")));
                                        driver.findElement(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")).click();
                                        
                                        
                                        System.out.println("clicked Add");
                                        Log.info("log4j msg- clicked Add");
                                        
                                        //enter subject
                                         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtSubject']")));
                                        driver.findElement(By.xpath("//input[@id='txtSubject']")).sendKeys(CommunicationCasePrioritiesCommsubject);
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
                                        Select communicationcasePriorities = new Select(driver.findElement(By.xpath("//select[@id='ddlNoteType']")));
                                        communicationcasePriorities.selectByVisibleText(CommunicationCasePrioritiesCommNoteType);
                                        System.out.println("selected note type");
                                        Log.info("log4j msg-selected note type");
                                        
                                        Thread.sleep(1000);
                                        //enter note details
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='txtNotes']")));
                                        driver.findElement(By.xpath("//textarea[@id='txtNotes']")).sendKeys(CommunicationCasePrioritiesCommDetails);
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
                         driver.quit(); }}
                                        
                         catch (Exception e){e.printStackTrace();
                         System.out.println("Error in adding Comm to Communication Case Priorities");
         Log.info("log4j msg - Error in adding Comm to  Communication Case Priorities"); 
         BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
         driver.quit();    }   
                         
                         }
        


//delete function
public void deleteCommunicationCasePriorities( String CommunicationCasePrioritiesCode, String CommunicationCasePrioritiesDescription) throws Exception{
        
        try{         
                        
        int i= searchCommunicationCasePriorities( CommunicationCasePrioritiesCode, CommunicationCasePrioritiesDescription);
		
		if (i==1){
			System.out.println("Communication Case Priorities found, continue with delete");
			Log.info("log4j msg-Communication Case Priorities found, continue with delete");
			
        //find CommunicationCasePriorities
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+CommunicationCasePrioritiesCode+"']")));
                                        driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+CommunicationCasePrioritiesCode+"']")).click();
                                        System.out.println("clicked Communication Case Priorities Code");
                                        Log.info("log4j msg- clicked Communication Case Priorities code");
                        
                                        //click delete
                                        
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(CommunicationCasePrioritiesDeleteLink));
                                        driver.findElement(CommunicationCasePrioritiesDeleteLink).click();
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
    } else{
System.out.println("cannot find Communication Case Priorities, cannot delete Communication Case Priorities ");
Log.info("log4j msg- cannot find Communication Case Priorities, cannot delete Communication Case Priorities ");
wait.until(ExpectedConditions.visibilityOfElementLocated(CommunicationCasePrioritiesExitLink));
driver.findElement(CommunicationCasePrioritiesExitLink).click();
System.out.println("clicked Exit");
Log.info("log4j msg- clicked Exit");
Thread.sleep(1000);


BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
driver.quit(); 

}} catch (Exception e){System.out.println("Error in deleting Communication Case Priorities ");
Log.info("log4j msg - Error in deleting Communication Case Priorities "); 

}   
}


}





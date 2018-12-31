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

public class CredentiallingStatuses {

	WebDriver driver;
	WebDriverWait wait ;

	
	By CredentiallingStatusesCodeBeginsInput = By.xpath("//input[@id='txtCode']");
	
	By CredentiallingStatusesNameDescriptionBeginsInput = By.xpath("//input[@id='txtName']");
	
	By CredentiallingStatusesSearchButton= By.xpath("//button[@data-ng-click='search(0)']");
     
    By CredentiallingStatusesAddLink= By.linkText("Add");
    
    By CredentiallingStatusesCodeInput = By.xpath("//input[@id='code']");
    
    By CredentiallingStatusesDescriptionInput= By.xpath("//input[@id='name']");
    
    By CredentiallingStatusesRecordMark= By.xpath("//input[@style='width:20px;']");
    
    By CredentiallingStatusesValidateLink =By.linkText("Validate");
    
    By CredentiallingStatusesValidateSaveOKButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By CredentiallingStatusesSaveLink =  By.linkText("Save");
    
    By CredentiallingStatusesEditLink = By.linkText("Edit");
    
    By CredentiallingStatusesCopyLink = By.linkText("Copy");
    
    By CredentiallingStatusesDeleteLink= By.linkText("Delete");
    
    By confirmDeleteButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By CredentiallingStatusesCommLink= By.linkText("Commun.");
    
    By CredentiallingStatusesExitLink=  By.linkText("Exit");
    
    
    
    
    public CredentiallingStatuses(WebDriver driver){
                    this.driver= driver;
                    this.wait= new WebDriverWait(driver, 20);
    }
    

public int searchCredentiallingStatuses( String CredentiallingStatusesCode, String CredentiallingStatusesName) throws Exception{

try{
//enter  Credentialling Statuses code
wait.until(ExpectedConditions.visibilityOfElementLocated(CredentiallingStatusesCodeBeginsInput));
driver.findElement(CredentiallingStatusesCodeBeginsInput).clear();
driver.findElement(CredentiallingStatusesCodeBeginsInput).sendKeys(CredentiallingStatusesCode);
System.out.println("entered Credentialling Statuses  code");
Log.info("log4j msg- entered Credentialling Statuses code");


//enter  Credentialling Statuses name
wait.until(ExpectedConditions.visibilityOfElementLocated(CredentiallingStatusesNameDescriptionBeginsInput));
driver.findElement(CredentiallingStatusesNameDescriptionBeginsInput).clear();
driver.findElement(CredentiallingStatusesNameDescriptionBeginsInput).sendKeys(CredentiallingStatusesName);
System.out.println("entered Credentialling Statuses name");
Log.info("log4j msg- entered Credentialling Statuses name");

//click search
wait.until(ExpectedConditions.visibilityOfElementLocated(CredentiallingStatusesSearchButton));
driver.findElement(CredentiallingStatusesSearchButton).click();
System.out.println("clicked Search");
Log.info("log4j msg- clicked Search");
	
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+CredentiallingStatusesCode+"']")));
WebElement e = driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+CredentiallingStatusesCode+"']"));
e.click();
System.out.println("Found CredentiallingStatuses");
Log.info("log4j msg- Found CredentiallingStatuses");

return 1;
}

catch(Exception e){System.out.println("Credentialling Statuses not found"); Log.info("log4j msg- Credentialling Statuses not found");return 0;}

}

//add function
public void addCredentiallingStatuses( String CredentiallingStatusesCode, String CredentiallingStatusesDescription)throws Exception{

        try{ 
        
        int i= searchCredentiallingStatuses(CredentiallingStatusesCode, CredentiallingStatusesDescription);
		
		if (i==0){
			System.out.println("Credentialling Statuses not found, Continue with Add");
			Log.info("log4j msg- Credentialling Statuses not found, Continue with Add");
		
		
        wait.until(ExpectedConditions.visibilityOfElementLocated(CredentiallingStatusesAddLink));
        driver.findElement(CredentiallingStatusesAddLink).click();
        System.out.println("clicked Add");
        Log.info("log4j msg- clicked Add");
        
        
        System.out.println("Credentialling Statuses code: "+CredentiallingStatusesCode);
        Log.info("log4j msg- Credentialling Statuses code: "+CredentiallingStatusesCode);
        //enter code
        wait.until(ExpectedConditions.visibilityOfElementLocated(CredentiallingStatusesCodeInput));
        driver.findElement(CredentiallingStatusesCodeInput).sendKeys(CredentiallingStatusesCode);
        Thread.sleep(1000);
        System.out.println("Entered code");
        Log.info("log4j msg- Entered code");
        
        System.out.println("Credentialling Statuses description"+CredentiallingStatusesDescription);
        Log.info("log4j msg- Credentialling Statuses code: "+CredentiallingStatusesDescription);
        //enter Description
        wait.until(ExpectedConditions.visibilityOfElementLocated(CredentiallingStatusesDescriptionInput));
        driver.findElement(CredentiallingStatusesDescriptionInput).sendKeys(CredentiallingStatusesDescription);
        Thread.sleep(1000);
        System.out.println("Entered description");
        Log.info("log4j msg- Entered description");

        
        //click validate

        
        wait.until(ExpectedConditions.visibilityOfElementLocated(CredentiallingStatusesValidateLink));
        driver.findElement(CredentiallingStatusesValidateLink).click();
        System.out.println("clicked validate");
        Log.info("log4j msg- clicked validate");
        
        //click ok
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(CredentiallingStatusesValidateSaveOKButton));
        driver.findElement(CredentiallingStatusesValidateSaveOKButton).click();
        System.out.println("clicked validate ok to save button");
        Log.info("log4j msg- clicked validate ok to save button");
        
		
        //click save
        Thread.sleep(1000);
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(CredentiallingStatusesSaveLink));
        driver.findElement(CredentiallingStatusesSaveLink).click();
        System.out.println("clicked save ");
        Log.info("log4j msg- clicked  save ");
        Thread.sleep(1000);
          BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
          driver.quit(); 
        
        } else{
			System.out.println("Credentialling Statuses is already present, cannot add Credentialling Statuses");
			Log.info("log4j msg- Credentialling Statuses is already present, cannot add Credentialling Statuses");
			wait.until(ExpectedConditions.visibilityOfElementLocated(CredentiallingStatusesExitLink));
			driver.findElement(CredentiallingStatusesExitLink).click();
			System.out.println("clicked Exit");
			Log.info("log4j msg- clicked Exit"); Thread.sleep(1000);
			
			 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
			 driver.quit(); 
		}

        }catch (Exception e){System.out.println("Error in adding Credentialling Statuses");Log.info("log4j msg- Error in adding Credentialling Statuses"); }
		}
        
//copy function

public void copyCredentiallingStatuses( String CredentiallingStatusesCode, String CredentiallingStatusesName, String newCredentiallingStatusesCode, String newCredentiallingStatusesDescription)throws Exception{
        
        try{ 
        
        int i= searchCredentiallingStatuses( CredentiallingStatusesCode, CredentiallingStatusesName);
		
		if (i==1){
			System.out.println("Credentialling Statuses found, continue with copy");
			Log.info("log4j msg-Credentialling Statuses found, continue with copy");
		
        
        System.out.println("Credentialling Statuses code"+CredentiallingStatusesCode);
        Log.info("log4j msg-Credentialling Statuses code"+CredentiallingStatusesCode);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+CredentiallingStatusesCode+"']")));
        driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+CredentiallingStatusesCode+"']")).click();
        System.out.println("clicked Credentialling Statuses Code");
        Log.info("log4j msg- clicked Credentialling Statuses code");
        
        
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(CredentiallingStatusesCopyLink));
        driver.findElement(CredentiallingStatusesCopyLink).click();
        System.out.println("clicked Copy");
        Log.info("log4j msg- clicked Copy");
        
        System.out.println("Credentialling Statuses new code"+newCredentiallingStatusesCode);
        Log.info("log4j msg- Credentialling Statuses new code"+newCredentiallingStatusesCode);
        //enter new code
        wait.until(ExpectedConditions.visibilityOfElementLocated(CredentiallingStatusesCodeInput));
        driver.findElement(CredentiallingStatusesCodeInput).clear();
        driver.findElement(CredentiallingStatusesCodeInput).sendKeys(newCredentiallingStatusesCode);
        System.out.println("Entered new code");
        Log.info("log4j msg- Entered new code");

        System.out.println("Credentialling Statuses new description"+newCredentiallingStatusesDescription);
        Log.info("log4j msg- Credentialling Statuses new description"+newCredentiallingStatusesDescription);
//enter new description
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(CredentiallingStatusesDescriptionInput));
        driver.findElement(CredentiallingStatusesDescriptionInput).clear();
        driver.findElement(CredentiallingStatusesDescriptionInput).sendKeys(newCredentiallingStatusesDescription);
        System.out.println("Entered new description");
        Log.info("log4j msg- Entered new description");
        
        
        
        
        
        //click save
        wait.until(ExpectedConditions.visibilityOfElementLocated(CredentiallingStatusesSaveLink));
        driver.findElement(CredentiallingStatusesSaveLink).click();

        System.out.println("Clicked save");
        Log.info("log4j msg- clicked save");
        Thread.sleep(1000);
          BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
          driver.quit(); 
		
        
		
        } else{
			System.out.println("Credentialling Statuses is not present, cannot copy Credentialling Statuses");
			Log.info("log4j msg- Credentialling Statuses is not present, cannot copy Credentialling Statuses");
			wait.until(ExpectedConditions.visibilityOfElementLocated(CredentiallingStatusesExitLink));
			driver.findElement(CredentiallingStatusesExitLink).click();
			System.out.println("clicked Exit");
			Log.info("log4j msg- clicked Exit");
			 Thread.sleep(1000);
			
			 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
			 driver.quit(); 
		}

        }catch (Exception e){System.out.println("Error in copying Credentialling Statuses");Log.info("log4j msg- Error in copying Credentialling Statuses"); }
		}
		
		





//edit function
public void editCredentiallingStatuses( String CredentiallingStatusesCode, String credentiallingStatusesDescription, String recordMark)throws Exception{
        
        try{
        
        int i= searchCredentiallingStatuses(CredentiallingStatusesCode, credentiallingStatusesDescription);
		
		if (i==1){
			System.out.println("Credentialling Statuses  found, Continue with Edit");
			Log.info("log4j msg- Credentialling Statuses  found, Continue with Edit");
		
		
        System.out.println("Credentialling Statuses code"+CredentiallingStatusesCode);
        Log.info("log4j msg- Credentialling Statuses code"+CredentiallingStatusesCode);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+CredentiallingStatusesCode+"']")));
        driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+CredentiallingStatusesCode+"']")).click();
        System.out.println("clicked Credentialling Statuses Record Mark");
        Log.info("log4j msg- clicked Credentialling Statuses Record Mark");
        
        
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(CredentiallingStatusesEditLink));
        driver.findElement(CredentiallingStatusesEditLink).click();
        System.out.println("clicked Edit");
        Log.info("log4j msg- clicked Edit");
        
        System.out.println("Credentialling Statuses Record Mark: "+recordMark);
        Log.info("log4j msg-Credentialling Statuses Record Mark: "+recordMark);
                                       
//enter new description
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(CredentiallingStatusesRecordMark));
        driver.findElement(CredentiallingStatusesRecordMark).clear();
        Thread.sleep(1000);
        driver.findElement(CredentiallingStatusesRecordMark).sendKeys(recordMark);
        System.out.println("Entered new Record Mark");
        Log.info("log4j msg- Entered new Record Mark");
        
        
        
        
        //click save
        wait.until(ExpectedConditions.visibilityOfElementLocated(CredentiallingStatusesSaveLink));
        driver.findElement(CredentiallingStatusesSaveLink).click();
        System.out.println("Clicked save");
        Log.info("log4j msg- clicked save");
        Thread.sleep(1000);
          BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit(); 
         
		}
        
		else{System.out.println("Credentialling Statuses not found, cannot edit Credentialling Statuses");
        Log.info("log4j msg- Credentialling Statuses not found, cannot edit Credentialling Statuses");  
        BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
        driver.quit(); }
		
		}catch (Exception e){ e.printStackTrace();System.out.println("Error in Editing Credentialling Statuses ");
        Log.info("log4j msg- Error in Editing Credentialling Statuses ");   
        BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
        driver.quit(); }


        }
//exit function
public void exitCredentiallingStatuses( String CredentiallingStatusesCode) throws Exception{
try{  System.out.println("Credentialling Statuses code"+CredentiallingStatusesCode);
        Log.info("log4j msg- Credentialling Statuses code"+CredentiallingStatusesCode);
                       Thread.sleep(1000);
                        driver.findElement(CredentiallingStatusesExitLink).click();
                        Thread.sleep(1000);
                        System.out.println("Clicked exit in  Credentialling Statuses ");
                        Log.info("log4j msg- clicked exit in  Credentialling Statuses ");   
                        BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
                        driver.quit(); 
                      
}catch (Exception e){ e.printStackTrace();System.out.println("Error in Exiting Credentialling Statuses ");
Log.info("log4j msg- Error in Exiting Credentialling Statuses ");   
BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
driver.quit(); }}

//add comm function
public void addCommCredentiallingStatuses( String CredentiallingStatusesCode, String CredentiallingStatusesName, String CredentiallingStatusesCommsubject, String CredentiallingStatusesCommNoteType, String CredentiallingStatusesCommMedium, String CredentiallingStatusesCommDetails) throws Exception{
        
        try{         
        
        int i= searchCredentiallingStatuses(CredentiallingStatusesCode, CredentiallingStatusesName);
		
		if (i==1){
			System.out.println("Credentialling Statuses  found, Continue with Add Communication");
			Log.info("log4j msg- Credentialling Statuses  found, Continue with Add Communication");
		
		
        System.out.println("Credentialling Statuses code"+CredentiallingStatusesCode);
        Log.info("log4j msg- Credentialling Statuses code"+CredentiallingStatusesCode);
                        //find CredentiallingStatuses
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+CredentiallingStatusesCode+"']")));
        driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+CredentiallingStatusesCode+"']")).click();
        System.out.println("clicked Credentialling Statuses Code");
        Log.info("log4j msg- clicked Credentialling Statuses code");
        
                                        //click comm
                                        
        wait.until(ExpectedConditions.visibilityOfElementLocated(CredentiallingStatusesCommLink));
        driver.findElement(CredentiallingStatusesCommLink).click();
        System.out.println("clicked Comm");
        Log.info("log4j msg- clicked Comm");

                                        
                                        
                                        //click add
                                        
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")));
                                        driver.findElement(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")).click();
                                        
                                          System.out.println("clicked Add");
                                        Log.info("log4j msg- clicked Add");
                                        
                                        //enter subject
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtSubject']")));
                                        driver.findElement(By.xpath("//input[@id='txtSubject']")).sendKeys(CredentiallingStatusesCommsubject);
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
                                        Select credentiallingStatuses = new Select(driver.findElement(By.xpath("//select[@id='ddlNoteType']")));
                                        credentiallingStatuses.selectByVisibleText(CredentiallingStatusesCommNoteType);
                                        System.out.println("selected note type");
                                        Log.info("log4j msg-selected note type");
                                        
                                        Thread.sleep(1000);
                                        //enter note details
                                         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='txtNotes']")));
                                        driver.findElement(By.xpath("//textarea[@id='txtNotes']")).sendKeys(CredentiallingStatusesCommDetails);
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
                                        
                         catch (Exception e){
                        	 e.printStackTrace();
                        	 System.out.println("Error in adding Comm to Credentialling Statuses");
                             Log.info("log4j msg - Error in adding Comm to  Credentialling Statuses"); 
         BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
         driver.quit();
  }   
                         
 }
        


//delete function
public void deleteCredentiallingStatuses( String CredentiallingStatusesCode, String CredentiallingStatusesDescription) throws Exception{
        
        try{         
                        
        int i= searchCredentiallingStatuses( CredentiallingStatusesCode, CredentiallingStatusesDescription);
		
		if (i==1){
			System.out.println("Credentialling Statuses found, continue with delete");
			Log.info("log4j msg-Credentialling Statuses found, continue with delete");
			
        //find CredentiallingStatuses
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+CredentiallingStatusesCode+"']")));
                                        driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+CredentiallingStatusesCode+"']")).click();
                                        System.out.println("clicked Credentialling Statuses Code");
                                        Log.info("log4j msg- clicked Credentialling Statuses code");
                        
                                        //click delete
                                        
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(CredentiallingStatusesDeleteLink));
                                        driver.findElement(CredentiallingStatusesDeleteLink).click();
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
System.out.println("cannot find Credentialling Statuses, cannot delete Credentialling Statuses ");
Log.info("log4j msg- cannot find Credentialling Statuses, cannot delete Credentialling Statuses ");
wait.until(ExpectedConditions.visibilityOfElementLocated(CredentiallingStatusesExitLink));
driver.findElement(CredentiallingStatusesExitLink).click();
System.out.println("clicked Exit");
Log.info("log4j msg- clicked Exit");
Thread.sleep(1000);


BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit(); 

}} catch (Exception e){System.out.println("Error in deleting Credentialling Statuses ");
Log.info("log4j msg - Error in deleting Credentialling Statuses "); 

}   
}

}





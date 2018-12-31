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

public class ServiceSets {
 
	WebDriver driver;
	WebDriverWait wait;  
	
	By ServiceSetsCodeBeginsInput = By.xpath("//input[@id='txtName']");
	
	By ServiceSetsNameDescriptionBeginsInput = By.xpath("//input[@id='txtServSet']");
	
	By ServiceSetsSearchButton= By.xpath("//button[@data-ng-click='search()']");
  
    By ServiceSetsAddLink= By.linkText("Add");
  
    By ServiceSetsCodeInput = By.xpath("//input[@id='txtCodeSetName']");
   
    By ServiceSetsDescriptionInput= By.xpath("//input[@id='txtServSetName']");
    
    By ServiceSetsRecordMark= By.xpath("//input[@style='width:20px;']");
    
    By ServiceSetsValidateLink =By.linkText("Validate");
    
    By ServiceSetsValidateSaveOKButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By ServiceSetsSaveLink =  By.linkText("Save");
    
    By ServiceSetsEditLink = By.linkText("Edit");
    
    By ServiceSetsCopyLink = By.linkText("Copy");
    
    By ServiceSetsDeleteLink= By.linkText("Delete");
    
    By confirmDeleteButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By ServiceSetsCommLink= By.linkText("Commun.");
       
    By ServiceSetsExitLink=  By.linkText("Exit");
    
    
    
    
    public ServiceSets(WebDriver driver){
                    this.driver= driver;
                    this.wait = new WebDriverWait(driver, 40);  
    }
    
    
	public int searchServiceSets( String ServiceSetsCode, String ServiceSetsName) throws Exception{
		
		try{
		//enter  Service Sets code
		wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceSetsCodeBeginsInput));
		driver.findElement(ServiceSetsCodeBeginsInput).clear();
		driver.findElement(ServiceSetsCodeBeginsInput).sendKeys(ServiceSetsCode);
		System.out.println("entered Service Sets  code");
		Log.info("log4j msg- entered Service Sets code");
	
	
		//enter  Service Sets name
		wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceSetsNameDescriptionBeginsInput));
		driver.findElement(ServiceSetsNameDescriptionBeginsInput).clear();
		driver.findElement(ServiceSetsNameDescriptionBeginsInput).sendKeys(ServiceSetsName);
		System.out.println("entered Service Sets name");
		Log.info("log4j msg- entered Service Sets name");
		
		//click search
		wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceSetsSearchButton));
		driver.findElement(ServiceSetsSearchButton).click();
		System.out.println("clicked Search");
		Log.info("log4j msg- clicked Search");
				
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ServiceSetsCode+"']")));
		WebElement e = driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ServiceSetsCode+"']"));
		e.click();
		System.out.println("Found ServiceSets");
		Log.info("log4j msg- Found ServiceSets");
	
		return 1;
		}
		
	catch(Exception e){System.out.println("Service Sets Not found");Log.info("log4j msg- Service Sets not found"); return 0;}
		
	}

    //add function
    public void addServiceSets( String ServiceSetsCode, String ServiceSetsDescription)throws Exception{
    
                    try{ 
                    int i= searchServiceSets(ServiceSetsCode, ServiceSetsDescription);
            		
            		if (i==0){
            			System.out.println("Service Sets not found, Continue with Add");
            			Log.info("log4j msg- Service Sets not found, Continue with Add");
            		
            		
                    wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceSetsAddLink));
                    driver.findElement(ServiceSetsAddLink).click();
                    System.out.println("clicked Add");
                    Log.info("log4j msg- clicked Add");
                    
                    
                    System.out.println("Service Sets code: "+ServiceSetsCode);
                    Log.info("log4j msg- Service Sets code: "+ServiceSetsCode);
                    //enter code
                    wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceSetsCodeInput));
                    driver.findElement(ServiceSetsCodeInput).sendKeys(ServiceSetsCode);
                    Thread.sleep(1000);
                    System.out.println("Entered code");
                    Log.info("log4j msg- Entered code");
                    
                    System.out.println("Service Sets Name"+ServiceSetsDescription);
                    Log.info("log4j msg- Service Sets Name"+ServiceSetsDescription);
                    //enter Description
                    wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceSetsDescriptionInput));
                    driver.findElement(ServiceSetsDescriptionInput).sendKeys(ServiceSetsDescription);
                    Thread.sleep(1000);
                    System.out.println("Entered Name");
                    Log.info("log4j msg- Entered Name");
    
                    
                    //click validate
    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceSetsValidateLink));
                    driver.findElement(ServiceSetsValidateLink).click();
                    System.out.println("clicked validate");
                    Log.info("log4j msg- clicked validate");
                    
                    //click ok
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceSetsValidateSaveOKButton));
                    driver.findElement(ServiceSetsValidateSaveOKButton).click();
                    System.out.println("clicked validate ok to save button");
                    Log.info("log4j msg- clicked validate ok to save button");
                    
            		
                    //click save
                    Thread.sleep(1000);
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceSetsSaveLink));
                    driver.findElement(ServiceSetsSaveLink).click();
                    System.out.println("clicked save ");
                    Log.info("log4j msg- clicked  save ");
                      BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                    
                    } else{
            			System.out.println("Service Sets is already present, cannot add Service Sets");
            			Log.info("log4j msg- Service Sets is already present, cannot add Service Sets");
            			wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceSetsExitLink));
            			driver.findElement(ServiceSetsExitLink).click();
            			System.out.println("clicked Exit");
            			Log.info("log4j msg- clicked Exit");
            			
            			 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
            		}
    
                    }catch (Exception e){System.out.println("Error in adding Service Sets");Log.info("log4j msg- Error in adding Service Sets"); }
            		}
                    
    //copy function
    
    public void copyServiceSets( String ServiceSetsCode, String ServiceSetsName, String newServiceSetsCode, String newServiceSetsDescription)throws Exception{
                    
                    try{
                    int i= searchServiceSets( ServiceSetsCode, ServiceSetsName);
            		
            		if (i==1){
            			System.out.println("Service Sets found, continue with copy");
            			Log.info("log4j msg-Service Sets found, continue with copy");
            		
                    
                    System.out.println("Service Sets code"+ServiceSetsCode);
                    Log.info("log4j msg-Service Sets code"+ServiceSetsCode);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ServiceSetsCode+"']")));
                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ServiceSetsCode+"']")).click();
                    System.out.println("clicked Service Sets Code");
                    Log.info("log4j msg- clicked Service Sets code");
                    
                    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceSetsCopyLink));
                    driver.findElement(ServiceSetsCopyLink).click();
                    System.out.println("clicked Copy");
                    Log.info("log4j msg- clicked Copy");
                    
                    System.out.println("Service Sets newcode"+newServiceSetsCode);
                    Log.info("log4j msg- Service Sets newcode"+newServiceSetsCode);
                    //enter new code
                    wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceSetsCodeInput));
                    driver.findElement(ServiceSetsCodeInput).clear();
                    driver.findElement(ServiceSetsCodeInput).sendKeys(newServiceSetsCode);
                    System.out.println("Entered new code");
                    Log.info("log4j msg- Entered new code");
    
                    System.out.println("Service Sets new Name"+newServiceSetsDescription);
                    Log.info("log4j msg- Service Sets new Name"+newServiceSetsDescription);
    //enter new Record Mark
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceSetsDescriptionInput));
                    driver.findElement(ServiceSetsDescriptionInput).clear();
                    driver.findElement(ServiceSetsDescriptionInput).sendKeys(newServiceSetsDescription);
                    System.out.println("Entered new Name");
                    Log.info("log4j msg- Entered new Name");
                    
                    
                    
                    
                    
                    //click save
                    wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceSetsSaveLink));
                    driver.findElement(ServiceSetsSaveLink).click();

                    System.out.println("Clicked save");
                    Log.info("log4j msg- clicked save");
                      BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
            		
                    
            		
                    } else{
            			System.out.println("Service Sets is not present, cannot copy Service Sets");
            			  Log.info("log4j msg- Service Sets is not present, cannot copy Service Sets");
            			wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceSetsExitLink));
            			driver.findElement(ServiceSetsExitLink).click();
            			System.out.println("clicked Exit");
            			Log.info("log4j msg- clicked Exit");
            			
            			 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
            		}
    
                    }catch (Exception e){System.out.println("Error in copying Service Sets");  Log.info("log4j msg- Error in copying Service Sets"); }
            		}
            		
            		
    
    
    

    
    //edit function
public void editServiceSets( String ServiceSetsCode, String serviceSetsDescription, String recordMark)throws Exception{
                    
                    try{ 
                    int i= searchServiceSets(ServiceSetsCode, serviceSetsDescription);
            		
            		if (i==1){
            			System.out.println("Service Sets  found, Continue with Edit");
            			Log.info("log4j msg- Service Sets  found, Continue with Edit");
            		
            		
                    System.out.println("Service Sets code"+ServiceSetsCode);
                    Log.info("log4j msg- Service Sets code"+ServiceSetsCode);
                     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ServiceSetsCode+"']")));
                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ServiceSetsCode+"']")).click();
                    System.out.println("clicked Service Sets Record Mark");
                    Log.info("log4j msg- clicked Service Sets Record Mark");
                    
                    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceSetsEditLink));
                    driver.findElement(ServiceSetsEditLink).click();
                    System.out.println("clicked Edit");
                    Log.info("log4j msg- clicked Edit");
                    
                    System.out.println("Service Sets Record Mark: "+recordMark);
                    Log.info("log4j msg- Service Sets Record Mark: "+recordMark);                  
    //enter new Record Mark
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceSetsRecordMark));
                  driver.findElement(ServiceSetsRecordMark).clear();
                    Thread.sleep(1000);
                    driver.findElement(ServiceSetsRecordMark).sendKeys(recordMark);
                    System.out.println("Entered new Record Mark");
                    Log.info("log4j msg- Entered new Record Mark");
                    
                    
                    
                    
                    //click save
                    wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceSetsSaveLink));
                    driver.findElement(ServiceSetsSaveLink).click();
                    System.out.println("Clicked save");
                    Log.info("log4j msg- clicked save");
                      BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
            		}
                    
            		else{System.out.println("Service Sets not found, cannot edit Service Sets");
                    Log.info("log4j msg- Service Sets not found, cannot edit Service Sets ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}
            		
            		}catch (Exception e){ e.printStackTrace();System.out.println("Error in Editing Service Sets ");
                    Log.info("log4j msg- Error in Editing Service Sets ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}
    
    
                    }
    //exit function
    public void exitServiceSets( String ServiceSetsCode) throws Exception{
    try{
                    System.out.println("Service Sets code"+ServiceSetsCode);
                    Log.info("log4j msg- Service Sets code"+ServiceSetsCode); 
                                    Thread.sleep(1000);
                                    driver.findElement(ServiceSetsExitLink).click();
                                    Thread.sleep(1000);
                                    System.out.println("Clicked exit in  Service Sets ");
                                    Log.info("log4j msg- clicked exit in  Service Sets ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                                    
    	}catch (Exception e){ e.printStackTrace();System.out.println("Error in exiting Service Sets ");
    Log.info("log4j msg- Error in exiting Service Sets ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}}
    
    //add comm function
    public void addCommServiceSets( String ServiceSetsCode, String ServiceSetsName, String ServiceSetsCommsubject, String ServiceSetsCommNoteType, String ServiceSetsCommMedium, String ServiceSetsCommDetails) throws Exception{
                    
                    try{ 
                    int i= searchServiceSets(ServiceSetsCode, ServiceSetsName);
            		
            		if (i==1){
            			System.out.println("Service Sets  found, Continue with Add Communication");
            			Log.info("log4j msg- Service Sets  found, Continue with Add Communication");
            		
            		
                    System.out.println("Service Sets code"+ServiceSetsCode);
                    Log.info("log4j msg- Service Sets code"+ServiceSetsCode);
                                    //find ServiceSets
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ServiceSetsCode+"']")));
                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ServiceSetsCode+"']")).click();
                    System.out.println("clicked Service Sets Code");
                    Log.info("log4j msg- clicked Service Sets code");
                    
                                                    //click comm
                                                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceSetsCommLink));
                    driver.findElement(ServiceSetsCommLink).click();
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
                                                    driver.findElement(By.xpath("//input[@id='txtSubject']")).sendKeys(ServiceSetsCommsubject);
                                                    System.out.println("entered subject");
                                                    Log.info("log4j msg- entered subject");
                                                    
                                                    
                                                    //page down
                                                    
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-ng-model='currentRecord.followup']")));
                                                    driver.findElement(By.xpath("//input[@data-ng-model='currentRecord.followup']")).sendKeys(Keys.PAGE_DOWN);
                                                    System.out.println("clicked page down");
                                                    Log.info("log4j msg- clicked page down");
                                                    
                                                    
                                                    
                                                    
                                                    //click add details
                                                      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@data-ng-click='addChildRecord()'])[2]")));
                                                    driver.findElement(By.xpath("(//button[@data-ng-click='addChildRecord()'])[2]")).click();
                                                    System.out.println("clicked add details");
                                                    Log.info("log4j msg- clicked add details");
                                                    
                                                    
                                                   
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='ddlNoteType']")));
                                                    Select placeOfService = new Select(driver.findElement(By.xpath("//select[@id='ddlNoteType']")));
                                                    placeOfService.selectByVisibleText(ServiceSetsCommNoteType);
                                                    System.out.println("selected note type");
                                                    Log.info("log4j msg-selected note type");
                                                    
                                                   
                                                    //enter note details
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='txtNotes']")));
                                                    driver.findElement(By.xpath("//textarea[@id='txtNotes']")).sendKeys(ServiceSetsCommDetails);
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
                                                    
            		
            			
                                     BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}
                    
            		
                                                    
                    } catch (Exception e){e.printStackTrace();System.out.println("Error in adding Comm to Service Sets");
                                                                                                                    Log.info("log4j msg - Error in adding Comm to  Service Sets"); 
                     BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();   }   
                                     
                                     }
    
    
    //delete function
    public void deleteServiceSets( String ServiceSetsCode, String ServiceSetsDescription) throws Exception{
                    
                    try{            
                    int i= searchServiceSets( ServiceSetsCode, ServiceSetsDescription);
            		
            		if (i==1){
            			System.out.println("Service Sets found, continue with delete");
            			Log.info("log4j msg-Service Sets found, continue with delete");
            			
                    //find ServiceSets
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ServiceSetsCode+"']")));
                                                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ServiceSetsCode+"']")).click();
                                                    System.out.println("clicked Service Sets Code");
                                                    Log.info("log4j msg- clicked Service Sets code");
                                    
                                                    //click delete
                                                    
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceSetsDeleteLink));
                                                    driver.findElement(ServiceSetsDeleteLink).click();
                                                    System.out.println("clicked Delete");
                                                    Log.info("log4j msg- clicked Delete");
                                                    
                    
                                                    //click confirm delete
                                                    
                                                    
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(confirmDeleteButton));
                                                    driver.findElement(confirmDeleteButton).click();
                                                    System.out.println("clicked confirm Delete");
                                                    Log.info("log4j msg- clicked confirm Delete");
                                                     BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                                                    
                                                    
                    


    
    
} else{
	System.out.println("cannot find Service Sets, cannot delete Service Sets  ");
	Log.info("log4j msg- cannot find Service Sets, cannot delete Service Sets  ");
	wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceSetsExitLink));
	driver.findElement(ServiceSetsExitLink).click();
	System.out.println("clicked Exit");
	Log.info("log4j msg- clicked Exit");
	
	
	 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
	
}} catch (Exception e){System.out.println("Error in deleting Service Sets ");
Log.info("log4j msg - Error in deleting Service Sets "); 

}   
    }


}
  



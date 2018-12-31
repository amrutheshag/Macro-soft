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

public class MemberSubscriberRelationships {
    
	WebDriver driver;
	WebDriverWait wait ;   
	
	By MemberSubscriberRelationshipsCodeBeginsInput = By.xpath("//input[@id='txtCode']");
	
	By MemberSubscriberRelationshipsNameDescriptionBeginsInput = By.xpath("//input[@id='txtName']");
	
	By MemberSubscriberRelationshipsSearchButton= By.xpath("//button[@data-ng-click='search(0)']");
    
    By MemberSubscriberRelationshipsAddLink= By.linkText("Add");
    
    By MemberSubscriberRelationshipsCodeInput = By.xpath("//input[@id='code']");
    
    By MemberSubscriberRelationshipsDescriptionInput= By.xpath("//input[@id='name']");
    
    By MemberSubscriberRelationshipsRecordMark= By.xpath("//input[@style='width:20px;']");
    
    By MemberSubscriberRelationshipsValidateLink =By.linkText("Validate");
    
    By MemberSubscriberRelationshipsValidateSaveOKButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By MemberSubscriberRelationshipsSaveLink =  By.linkText("Save");
    
    By MemberSubscriberRelationshipsEditLink = By.linkText("Edit");
    
    By MemberSubscriberRelationshipsCopyLink = By.linkText("Copy");
    
    By MemberSubscriberRelationshipsDeleteLink= By.linkText("Delete");
    
    By confirmDeleteButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By MemberSubscriberRelationshipsCommLink= By.linkText("Commun.");
    
    By MemberSubscriberRelationshipsExitLink=  By.linkText("Exit");
    
    
    
    
    public MemberSubscriberRelationships(WebDriver driver){
                    this.driver= driver;
                    this.wait= new WebDriverWait(driver, 50); 
    }
    
    
	public int searchMemberSubscriberRelationships( String MemberSubscriberRelationshipsCode, String MemberSubscriberRelationshipsName) throws Exception{
		
		try{
		//enter  Member-Subscriber Relationships code
		wait.until(ExpectedConditions.visibilityOfElementLocated(MemberSubscriberRelationshipsCodeBeginsInput));
		driver.findElement(MemberSubscriberRelationshipsCodeBeginsInput).clear();
		driver.findElement(MemberSubscriberRelationshipsCodeBeginsInput).sendKeys(MemberSubscriberRelationshipsCode);
		System.out.println("entered Member-Subscriber Relationships code");
		Log.info("log4j msg- entered Member-Subscriber Relationships code");
	
	
		//enter  Member-Subscriber Relationships name
		wait.until(ExpectedConditions.visibilityOfElementLocated(MemberSubscriberRelationshipsNameDescriptionBeginsInput));
		driver.findElement(MemberSubscriberRelationshipsNameDescriptionBeginsInput).clear();
		driver.findElement(MemberSubscriberRelationshipsNameDescriptionBeginsInput).sendKeys(MemberSubscriberRelationshipsName);
		System.out.println("entered Member-Subscriber Relationships name");
		Log.info("log4j msg- entered Member-Subscriber Relationships name");
		
		//click search
		wait.until(ExpectedConditions.visibilityOfElementLocated(MemberSubscriberRelationshipsSearchButton));
		driver.findElement(MemberSubscriberRelationshipsSearchButton).click();
		System.out.println("clicked Search");
		Log.info("log4j msg- clicked Search");
				
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+MemberSubscriberRelationshipsCode+"']")));
		WebElement e = driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+MemberSubscriberRelationshipsCode+"']"));
		e.click();
		System.out.println("Found MemberSubscriberRelationships");
		Log.info("log4j msg- Found MemberSubscriberRelationships");
	
		return 1;
		}
		
	catch(Exception e){System.out.println("MemberSubscriberRelationships not found");
	Log.info("MemberSubscriberRelationships not found");
	return 0;}
		
	}

    //add function
    public void addMemberSubscriberRelationships( String MemberSubscriberRelationshipsCode, String MemberSubscriberRelationshipsDescription)throws Exception{
    
                    try{ 
                    int i= searchMemberSubscriberRelationships( MemberSubscriberRelationshipsCode, MemberSubscriberRelationshipsDescription);
            		
            		if (i==0){
            			System.out.println("Member-Subscriber Relationships not found, Continue with Add");
            			Log.info("log4j msg- Member-Subscriber Relationships not found, Continue with Add");
            		
            		
                    wait.until(ExpectedConditions.visibilityOfElementLocated(MemberSubscriberRelationshipsAddLink));
                    driver.findElement(MemberSubscriberRelationshipsAddLink).click();
                    System.out.println("clicked Add");
                    Log.info("log4j msg- clicked Add");
                    
                    
                    System.out.println("Member-Subscriber Relationships code: "+MemberSubscriberRelationshipsCode);
                    //enter code
                    wait.until(ExpectedConditions.visibilityOfElementLocated(MemberSubscriberRelationshipsCodeInput));
                    driver.findElement(MemberSubscriberRelationshipsCodeInput).sendKeys(MemberSubscriberRelationshipsCode);
                    Thread.sleep(1000);
                    System.out.println("Entered code");
                    Log.info("log4j msg- Entered code");
                    
                    System.out.println("Member-Subscriber Relationships description"+MemberSubscriberRelationshipsDescription);
                    //enter Description
                    wait.until(ExpectedConditions.visibilityOfElementLocated(MemberSubscriberRelationshipsDescriptionInput));
                    driver.findElement(MemberSubscriberRelationshipsDescriptionInput).sendKeys(MemberSubscriberRelationshipsDescription);
                    Thread.sleep(1000);
                    System.out.println("Entered description");
                    Log.info("log4j msg- Entered description");
    
                    
                    //click validate
    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(MemberSubscriberRelationshipsValidateLink));
                    driver.findElement(MemberSubscriberRelationshipsValidateLink).click();
                    System.out.println("clicked validate");
                    Log.info("log4j msg- clicked validate");
                    
                    //click ok
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(MemberSubscriberRelationshipsValidateSaveOKButton));
                    driver.findElement(MemberSubscriberRelationshipsValidateSaveOKButton).click();
                    System.out.println("clicked validate ok to save button");
                    Log.info("log4j msg- clicked validate ok to save button");
                    
            		
                    //click save
                    Thread.sleep(1000);
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(MemberSubscriberRelationshipsSaveLink));
                    driver.findElement(MemberSubscriberRelationshipsSaveLink).click();
                    System.out.println("clicked save ");
                    Log.info("log4j msg- clicked  save ");
                    Thread.sleep(1000);
                      BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                    
                    } else{
            			System.out.println("Member-Subscriber Relationships is already present, cannot add MemberSubscriberRelationships");
            			wait.until(ExpectedConditions.visibilityOfElementLocated(MemberSubscriberRelationshipsExitLink));
            			driver.findElement(MemberSubscriberRelationshipsExitLink).click();
            			System.out.println("clicked Exit");
            			Log.info("log4j msg- clicked Exit");
            			Thread.sleep(1000);
            			 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
            		}
    
                    }catch (Exception e){System.out.println("error in adding MemberSubscriberRelationships"); 
                    Log.info("error in adding MemberSubscriberRelationships");
                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                    }
            		}
                    
    //copy function
    
    public void copyMemberSubscriberRelationships( String MemberSubscriberRelationshipsCode, String MemberSubscriberRelationshipsName, String newMemberSubscriberRelationshipsCode, String newMemberSubscriberRelationshipsDescription)throws Exception{
                    
                    try{ 
                    int i= searchMemberSubscriberRelationships( MemberSubscriberRelationshipsCode, MemberSubscriberRelationshipsName);
            		
            		if (i==1){
            			System.out.println("Member-Subscriber Relationships found, continue with copy");
            			Log.info("log4j msg-Member-Subscriber Relationships found, continue with copy");
            		
                    
                    System.out.println("Member-Subscriber Relationships code"+MemberSubscriberRelationshipsCode);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+MemberSubscriberRelationshipsCode+"']")));
                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+MemberSubscriberRelationshipsCode+"']")).click();
                    System.out.println("clicked Member-Subscriber Relationships Code");
                    Log.info("log4j msg- clicked Member-Subscriber Relationships code");
                    
                    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(MemberSubscriberRelationshipsCopyLink));
                    driver.findElement(MemberSubscriberRelationshipsCopyLink).click();
                    System.out.println("clicked Copy");
                    Log.info("log4j msg- clicked Copy");
                    
                    System.out.println("Member-Subscriber Relationships newcode"+newMemberSubscriberRelationshipsCode);
                    
                    //enter new code
                    wait.until(ExpectedConditions.visibilityOfElementLocated(MemberSubscriberRelationshipsCodeInput));
                    driver.findElement(MemberSubscriberRelationshipsCodeInput).clear();
                    driver.findElement(MemberSubscriberRelationshipsCodeInput).sendKeys(newMemberSubscriberRelationshipsCode);
                    System.out.println("Entered new code");
                    Log.info("log4j msg- Entered new code");
    
                    System.out.println("Member-Subscriber Relationships new description"+newMemberSubscriberRelationshipsDescription);
                    	//enter new description
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(MemberSubscriberRelationshipsDescriptionInput));
                    driver.findElement(MemberSubscriberRelationshipsDescriptionInput).clear();
                    driver.findElement(MemberSubscriberRelationshipsDescriptionInput).sendKeys(newMemberSubscriberRelationshipsDescription);
                    System.out.println("Entered new description");
                    Log.info("log4j msg- Entered new description");
                    
                    
                    
                    
                    
                    //click save
                    wait.until(ExpectedConditions.visibilityOfElementLocated(MemberSubscriberRelationshipsSaveLink));
                    driver.findElement(MemberSubscriberRelationshipsSaveLink).click();

                    System.out.println("Clicked save");
                    Log.info("log4j msg- clicked save");
                    Thread.sleep(1000);
                      BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
            		
                    
            		
                    } else{
            			System.out.println("Member-Subscriber Relationships is not present, cannot copy MemberSubscriberRelationships");
            			Log.info("Member-Subscriber Relationships is not present, cannot copy MemberSubscriberRelationships");
            			
            			wait.until(ExpectedConditions.visibilityOfElementLocated(MemberSubscriberRelationshipsExitLink));
            			driver.findElement(MemberSubscriberRelationshipsExitLink).click();
            			System.out.println("clicked Exit");
            			Log.info("log4j msg- clicked Exit");
            			Thread.sleep(1000);
            			 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
            		}
    
                    }catch (Exception e){System.out.println("error in copying MemberSubscriberRelationships"); 
                    Log.info("error in copying MemberSubscriberRelationships"); 
                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                    }
            		}
            		
            		
    
    
    

    
    //edit function
public void editMemberSubscriberRelationships( String MemberSubscriberRelationshipsCode, String membersubscriberRelationshipsDescription, String recordMark)throws Exception{
                    
                    try{ 
                    int i= searchMemberSubscriberRelationships( MemberSubscriberRelationshipsCode, membersubscriberRelationshipsDescription);
            		
            		if (i==1){
            			System.out.println("Member-Subscriber Relationships  found, Continue with Edit");
            			Log.info("log4j msg- Member-Subscriber Relationships  found, Continue with Edit");
            		
            		
                    System.out.println("Member-Subscriber Relationships code"+MemberSubscriberRelationshipsCode);
                   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+MemberSubscriberRelationshipsCode+"']")));
                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+MemberSubscriberRelationshipsCode+"']")).click();
                    System.out.println("clicked Member-Subscriber Relationships Record Mark");
                    Log.info("log4j msg- clicked Member-Subscriber Relationships Record Mark");
                    
                    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(MemberSubscriberRelationshipsEditLink));
                    driver.findElement(MemberSubscriberRelationshipsEditLink).click();
                    System.out.println("clicked Edit");
                    Log.info("log4j msg- clicked Edit");
                    
                    System.out.println("Member-Subscriber Relationships Record Mark"+recordMark);
                                                   
    //enter new description
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(MemberSubscriberRelationshipsRecordMark));
                    System.out.println("current description: "+driver.findElement(MemberSubscriberRelationshipsRecordMark).getText());
                    driver.findElement(MemberSubscriberRelationshipsRecordMark).clear();
                    Thread.sleep(1000);
                    driver.findElement(MemberSubscriberRelationshipsRecordMark).sendKeys(recordMark);
                    System.out.println("Entered new description");
                    Log.info("log4j msg- Entered new description");
                    
                    
                    
                    
                    //click save
                    wait.until(ExpectedConditions.visibilityOfElementLocated(MemberSubscriberRelationshipsSaveLink));
                    driver.findElement(MemberSubscriberRelationshipsSaveLink).click();
                    System.out.println("Clicked save");
                    Log.info("log4j msg- clicked save");
                    Thread.sleep(1000);
                      BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
            		}
                    
            		else{System.out.println("member subscriber relationship not found ");
                    Log.info("log4j msg- member subscriner relationship not found ");  
                    Thread.sleep(1000);
                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}
            		
            		}catch (Exception e){ e.printStackTrace();System.out.println("Error in Editing Member-Subscriber Relationships ");
                    Log.info("log4j msg- Error in Editing Member-Subscriber Relationships ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}
    
    
                    }
    //exit function
    public void exitMemberSubscriberRelationships( String MemberSubscriberRelationshipsCode) throws Exception{
    try{System.out.println("Member-Subscriber Relationships code"+MemberSubscriberRelationshipsCode);
                                   Thread.sleep(1000);
                                    driver.findElement(MemberSubscriberRelationshipsExitLink).click();
                                    Thread.sleep(1000);
                                    System.out.println("Clicked exit in  Member-Subscriber Relationships ");
                                    Log.info("log4j msg- clicked exit in  Member-Subscriber Relationships ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                                 
    	}catch (Exception e){ e.printStackTrace();System.out.println("Error in exit Member-Subscriber Relationships ");
    Log.info("log4j msg- Error in exit Member-Subscriber Relationships ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}}
    
    //add comm function
    public void addCommMemberSubscriberRelationships( String MemberSubscriberRelationshipsCode, String MemberSubscriberRelationshipsName, String MemberSubscriberRelationshipsCommsubject, String MemberSubscriberRelationshipsCommNoteType, String MemberSubscriberRelationshipsCommMedium, String MemberSubscriberRelationshipsCommDetails) throws Exception{
                    
                    try{     
                    int i= searchMemberSubscriberRelationships( MemberSubscriberRelationshipsCode, MemberSubscriberRelationshipsName);
            		
            		if (i==1){
            			System.out.println("Member-Subscriber Relationships  found, Continue with Add Communication");
            			Log.info("log4j msg- Member-Subscriber Relationships  found, Continue with Add Communication");
            		
            		
                    System.out.println("Member-Subscriber Relationships code"+MemberSubscriberRelationshipsCode);
                                    //find MemberSubscriberRelationships
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+MemberSubscriberRelationshipsCode+"']")));
                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+MemberSubscriberRelationshipsCode+"']")).click();
                    System.out.println("clicked Member-Subscriber Relationships Code");
                    Log.info("log4j msg- clicked Member-Subscriber Relationships code");
                    
                                                    //click comm
                                                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(MemberSubscriberRelationshipsCommLink));
                    driver.findElement(MemberSubscriberRelationshipsCommLink).click();
                    System.out.println("clicked Comm");
                    Log.info("log4j msg- clicked Comm");

                                                    
                                                    
                                                    //click add
                                                     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")));
                                                    driver.findElement(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")).click();
                                                    
                                                      System.out.println("clicked Add");
                                                    Log.info("log4j msg- clicked Add");
                                                    
                                                    //enter subject
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtSubject']")));
                                                    driver.findElement(By.xpath("//input[@id='txtSubject']")).sendKeys(MemberSubscriberRelationshipsCommsubject);
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
                                                    Select placeOfService = new Select(driver.findElement(By.xpath("//select[@id='ddlNoteType']")));
                                                    placeOfService.selectByVisibleText(MemberSubscriberRelationshipsCommNoteType);
                                                    System.out.println("selected note type");
                                                    Log.info("log4j msg-selected note type");
                                                    
                                                    Thread.sleep(1000);
                                                    //enter note details
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='txtNotes']")));
                                                    driver.findElement(By.xpath("//textarea[@id='txtNotes']")).sendKeys(MemberSubscriberRelationshipsCommDetails);
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
                                     BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}
            		
                    
            		else{System.out.println("member subscriber relationship not found");
            		Log.info("member subscriber relationship not found");}
            		
            			
                    }
                                                    
                                     catch (Exception e){
                                    	 e.printStackTrace();
                                     System.out.println("error in adding Comm to MemberSubscriberRelationships");
                                     Log.info("log4j msg - error in adding Comm to  MemberSubscriberRelationships"); 
                                     BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();  
                                     }   
                                     
                                     }
                    
    
    
    //delete function
    public void deleteMemberSubscriberRelationships( String MemberSubscriberRelationshipsCode, String MemberSubscriberRelationshipsDescription) throws Exception{
                    
                    try{            
                    int i= searchMemberSubscriberRelationships( MemberSubscriberRelationshipsCode, MemberSubscriberRelationshipsDescription);
            		
            		if (i==1){
            			System.out.println("Member-Subscriber Relationships found, continue with delete");
            			Log.info("log4j msg-Member-Subscriber Relationships found, continue with delete");
            			
                    //find MemberSubscriberRelationships
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+MemberSubscriberRelationshipsCode+"']")));
                                                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+MemberSubscriberRelationshipsCode+"']")).click();
                                                    System.out.println("clicked Member-Subscriber Relationships Code");
                                                    Log.info("log4j msg- clicked Member-Subscriber Relationships code");
                                    
                                                    //click delete
                                                    
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(MemberSubscriberRelationshipsDeleteLink));
                                                    driver.findElement(MemberSubscriberRelationshipsDeleteLink).click();
                                                    System.out.println("clicked Delete");
                                                    Log.info("log4j msg- clicked Delete");
                                                    
                    
                                                    //click confirm delete
                                                    
                                                    
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(confirmDeleteButton));
                                                    driver.findElement(confirmDeleteButton).click();
                                                    System.out.println("clicked confirm Delete");
                                                    Log.info("log4j msg- clicked confirm Delete");
                                                    Thread.sleep(1000);
                                                     BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                                                    
                                                    
                    


    
    
} else{
	System.out.println("cannot find Member-Subscriber Relationships ");
	Log.info("log4j msg- cannot find Member-Subscriber Relationships ");
	wait.until(ExpectedConditions.visibilityOfElementLocated(MemberSubscriberRelationshipsExitLink));
	driver.findElement(MemberSubscriberRelationshipsExitLink).click();
	System.out.println("clicked Exit");
	Log.info("log4j msg- clicked Exit");
	
	Thread.sleep(1000);
	 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
	
}} catch (Exception e){System.out.println("error in deleting Member-Subscriber Relationships ");
Log.info("log4j msg - error in deleting Member-Subscriber Relationships "); 

}   
    }


}
  



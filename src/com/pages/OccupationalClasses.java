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

public class OccupationalClasses{

	WebDriver driver;
	WebDriverWait wait ;   
	
	By OccupationalClassesCodeBeginsInput = By.xpath("//input[@id='txtCode']");
	
	By OccupationalClassesNameDescriptionBeginsInput = By.xpath("//input[@id='txtName']");
	
	By OccupationalClassesSearchButton= By.xpath("//button[@data-ng-click='search(0)']");
     
    By OccupationalClassesAddLink= By.linkText("Add");
    
    By OccupationalClassesCodeInput = By.xpath("//input[@id='code']");
    
    By OccupationalClassesDescriptionInput= By.xpath("//input[@id='name']");
    
    By OccupationalClassesRecordMark= By.xpath("//input[@style='width:20px;']");
    
    By OccupationalClassesValidateLink =By.linkText("Validate");
     
    By OccupationalClassesValidateSaveOKButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By OccupationalClassesSaveLink =  By.linkText("Save");
    
    By OccupationalClassesEditLink = By.linkText("Edit");
    
    By OccupationalClassesCopyLink = By.linkText("Copy");
    
    By OccupationalClassesDeleteLink= By.linkText("Delete");
   
    By confirmDeleteButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By OccupationalClassesCommLink= By.linkText("Commun.");
    
    By OccupationalClassesExitLink=  By.linkText("Exit");
    
    
    
    
    public OccupationalClasses(WebDriver driver){
                    this.driver= driver;
                    this.wait= new WebDriverWait(driver, 35); 
    }
    
    
	public int searchOccupationalClasses( String OccupationalClassesCode, String OccupationalClassesName) throws Exception{
		try{
		//enter  Occupational Classes code
		wait.until(ExpectedConditions.visibilityOfElementLocated(OccupationalClassesCodeBeginsInput));
		driver.findElement(OccupationalClassesCodeBeginsInput).clear();
		driver.findElement(OccupationalClassesCodeBeginsInput).sendKeys(OccupationalClassesCode);
		System.out.println("entered Occupational Classes code");
		Log.info("log4j msg- entered Occupational Classes code");
	
	
		//enter  Occupational Classes name
		wait.until(ExpectedConditions.visibilityOfElementLocated(OccupationalClassesNameDescriptionBeginsInput));
		driver.findElement(OccupationalClassesNameDescriptionBeginsInput).clear();
		driver.findElement(OccupationalClassesNameDescriptionBeginsInput).sendKeys(OccupationalClassesName);
		System.out.println("entered Occupational Classes name");
		Log.info("log4j msg- entered Occupational Classes name");
		
		//click search
		wait.until(ExpectedConditions.visibilityOfElementLocated(OccupationalClassesSearchButton));
		driver.findElement(OccupationalClassesSearchButton).click();
		System.out.println("clicked Search");
		Log.info("log4j msg- clicked Search");
				
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+OccupationalClassesCode+"']")));
		WebElement e = driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+OccupationalClassesCode+"']"));
		e.click();
		System.out.println("Found OccupationalClasses");
		Log.info("log4j msg- Found OccupationalClasses");
	
		return 1;
		}
		
	catch(Exception e){System.out.println("OccupationalClasses not found");
	Log.info("OccupationalClasses not found");return 0;}
		
	}

    //add function
    public void addOccupationalClasses( String OccupationalClassesCode, String OccupationalClassesDescription)throws Exception{
    
                    try{ 
                    int i= searchOccupationalClasses( OccupationalClassesCode, OccupationalClassesDescription);
            		
            		if (i==0){
            			System.out.println("Occupational Classes not found, Continue with Add");
            			Log.info("log4j msg- Occupational Classes not found, Continue with Add");
            		
            		
                    wait.until(ExpectedConditions.visibilityOfElementLocated(OccupationalClassesAddLink));
                    driver.findElement(OccupationalClassesAddLink).click();
                    System.out.println("clicked Add");
                    Log.info("log4j msg- clicked Add");
                    
                    
                    System.out.println("Occupational Classes code: "+OccupationalClassesCode);
                    //enter code
                    wait.until(ExpectedConditions.visibilityOfElementLocated(OccupationalClassesCodeInput));
                    driver.findElement(OccupationalClassesCodeInput).sendKeys(OccupationalClassesCode);
                    Thread.sleep(1000);
                    System.out.println("Entered code");
                    Log.info("log4j msg- Entered code");
                    
                    System.out.println("Occupational Classes description"+OccupationalClassesDescription);
                    //enter Description
                    wait.until(ExpectedConditions.visibilityOfElementLocated(OccupationalClassesDescriptionInput));
                    driver.findElement(OccupationalClassesDescriptionInput).sendKeys(OccupationalClassesDescription);
                    Thread.sleep(1000);
                    System.out.println("Entered description");
                    Log.info("log4j msg- Entered description");
    
                    
                    //click validate
    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(OccupationalClassesValidateLink));
                    driver.findElement(OccupationalClassesValidateLink).click();
                    System.out.println("clicked validate");
                    Log.info("log4j msg- clicked validate");
                    
                    //click ok
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(OccupationalClassesValidateSaveOKButton));
                    driver.findElement(OccupationalClassesValidateSaveOKButton).click();
                    System.out.println("clicked validate ok to save button");
                    Log.info("log4j msg- clicked validate ok to save button");
                    
            		
                    //click save
                    Thread.sleep(1000);
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(OccupationalClassesSaveLink));
                    driver.findElement(OccupationalClassesSaveLink).click();
                    System.out.println("clicked save ");
                    Log.info("log4j msg- clicked  save ");
                    Thread.sleep(1000);
                      BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                    
                    } else{
            			System.out.println("Occupational Classes is already present, cannot add OccupationalClasses");
            			Log.info("Occupational Classes is already present, cannot add OccupationalClasses");
            			wait.until(ExpectedConditions.visibilityOfElementLocated(OccupationalClassesExitLink));
            			driver.findElement(OccupationalClassesExitLink).click();
            			System.out.println("clicked Exit");
            			Log.info("log4j msg- clicked Exit");
            			Thread.sleep(1000);
            			 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
            		}
    
                    }catch (Exception e){System.out.println("error in adding OccupationalClasses");
                    Log.info("error in adding OccupationalClasses");BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}
            		}
                    
    //copy function
    
    public void copyOccupationalClasses( String OccupationalClassesCode, String OccupationalClassesName, String newOccupationalClassesCode, String newOccupationalClassesDescription)throws Exception{
                    
                    try{
                    int i= searchOccupationalClasses( OccupationalClassesCode, OccupationalClassesName);
            		
            		if (i==1){
            			System.out.println("Occupational Classes found, continue with copy");
            			Log.info("log4j msg-Occupational Classes found, continue with copy");
            		
                    
                    System.out.println("Occupational Classes code"+OccupationalClassesCode);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+OccupationalClassesCode+"']")));
                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+OccupationalClassesCode+"']")).click();
                    System.out.println("clicked Occupational Classes Code");
                    Log.info("log4j msg- clicked Occupational Classes code");
                    
                    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(OccupationalClassesCopyLink));
                    driver.findElement(OccupationalClassesCopyLink).click();
                    System.out.println("clicked Copy");
                    Log.info("log4j msg- clicked Copy");
                    
                    System.out.println("Occupational Classes newcode"+newOccupationalClassesCode);
                    
                    //enter new code
                    wait.until(ExpectedConditions.visibilityOfElementLocated(OccupationalClassesCodeInput));
                    driver.findElement(OccupationalClassesCodeInput).clear();
                    driver.findElement(OccupationalClassesCodeInput).sendKeys(newOccupationalClassesCode);
                    System.out.println("Entered new code");
                    Log.info("log4j msg- Entered new code");
    
                    System.out.println("Occupational Classes new description"+newOccupationalClassesDescription);
    //enter new description
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(OccupationalClassesDescriptionInput));
                    driver.findElement(OccupationalClassesDescriptionInput).clear();
                    driver.findElement(OccupationalClassesDescriptionInput).sendKeys(newOccupationalClassesDescription);
                    System.out.println("Entered new description");
                    Log.info("log4j msg- Entered new description");
                    
                    
                    
                    
                    
                    //click save
                    wait.until(ExpectedConditions.visibilityOfElementLocated(OccupationalClassesSaveLink));
                    driver.findElement(OccupationalClassesSaveLink).click();

                    System.out.println("Clicked save");
                    Log.info("log4j msg- clicked save");
                    Thread.sleep(1000);
                      BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
            		
                    
            		
                    } else{
            			System.out.println("Occupational Classes is not present, cannot copy OccupationalClasses");
            			Log.info("Occupational Classes is not present, cannot copy OccupationalClasses");
            			wait.until(ExpectedConditions.visibilityOfElementLocated(OccupationalClassesExitLink));
            			driver.findElement(OccupationalClassesExitLink).click();
            			System.out.println("clicked Exit");
            			Log.info("log4j msg- clicked Exit");
            			Thread.sleep(1000);
            			 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
            		}
    
                    }catch (Exception e){System.out.println("error in copying OccupationalClasses"); 
                    Log.info("error in copying occupational classes"); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}
            		}
            		
            		
    
    
    

    
    //edit function
public void editOccupationalClasses( String OccupationalClassesCode, String occupationalClassesDescription, String recordMark)throws Exception{
                    
                    try{  
                    int i= searchOccupationalClasses( OccupationalClassesCode, occupationalClassesDescription);
            		
            		if (i==1){
            			System.out.println("Occupational Classes  found, Continue with Edit");
            			Log.info("log4j msg- Occupational Classes  found, Continue with Edit");
            		
            		
                    System.out.println("Occupational Classes code"+OccupationalClassesCode);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+OccupationalClassesCode+"']")));
                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+OccupationalClassesCode+"']")).click();
                    System.out.println("clicked Occupational Class ");
                    Log.info("log4j msg- clicked Occupational Class");
                    
                    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(OccupationalClassesEditLink));
                    driver.findElement(OccupationalClassesEditLink).click();
                    System.out.println("clicked Edit");
                    Log.info("log4j msg- clicked Edit");
                    
                    System.out.println("Occupational Classes Record Mark"+recordMark);
                                                   
    //enter new record mark
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(OccupationalClassesRecordMark));
                    System.out.println("current record mark: "+driver.findElement(OccupationalClassesRecordMark).getText());
                    driver.findElement(OccupationalClassesRecordMark).clear();
                    Thread.sleep(1000);
                    driver.findElement(OccupationalClassesRecordMark).sendKeys(recordMark);
                    System.out.println("Entered new record mark");
                    Log.info("log4j msg- Entered new record mark");
                    
                    
                    
                    
                    //click save
                    wait.until(ExpectedConditions.visibilityOfElementLocated(OccupationalClassesSaveLink));
                    driver.findElement(OccupationalClassesSaveLink).click();
                    System.out.println("Clicked save");
                    Log.info("log4j msg- clicked save");
                    Thread.sleep(1000);
                      BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
            		}
                    
            		else{System.out.println(" Operational class code not found ");
                    Log.info("log4j msg- Operational class code not found "); 
                    Thread.sleep(1000);
                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}
            		
            		}catch (Exception e){ e.printStackTrace();System.out.println("Error in Editing Occupational Classes ");
                    Log.info("log4j msg- Error in Editing Occupational Classes ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}
    
    
                    }
    //exit function
    public void exitOccupationalClasses( String OccupationalClassesCode) throws Exception{
    try{
                    System.out.println("Occupational Classes code"+OccupationalClassesCode);
                                    Thread.sleep(1000);
                                    driver.findElement(OccupationalClassesExitLink).click();
                                    Thread.sleep(1000);
                                    System.out.println("Clicked exit in  Occupational Classes ");
                                    Log.info("log4j msg- clicked exit in  Occupational Classes ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                                 
    	}catch (Exception e){ e.printStackTrace();System.out.println("Error in Exit Occupational Classes ");
    Log.info("log4j msg- Error in Exit Occupational Classes ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}}
    
    //add comm function
    public void addCommOccupationalClasses( String OccupationalClassesCode, String OccupationalClassesName, String OccupationalClassesCommsubject, String OccupationalClassesCommNoteType, String OccupationalClassesCommMedium, String OccupationalClassesCommDetails) throws Exception{
                    
                    try{      
                    int i= searchOccupationalClasses( OccupationalClassesCode, OccupationalClassesName);
            		
            		if (i==1){
            			System.out.println("Occupational Classes  found, Continue with Add Communication");
            			Log.info("log4j msg- Occupational Classes  found, Continue with Add Communication");
            		
            		
                    System.out.println("Occupational Classes code"+OccupationalClassesCode);
                                    //find OccupationalClasses
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+OccupationalClassesCode+"']")));
                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+OccupationalClassesCode+"']")).click();
                    System.out.println("clicked Occupational Classes Code");
                    Log.info("log4j msg- clicked Occupational Classes code");
                    
                                                    //click comm
                                                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(OccupationalClassesCommLink));
                    driver.findElement(OccupationalClassesCommLink).click();
                    System.out.println("clicked Comm");
                    Log.info("log4j msg- clicked Comm");

                                                    
                                                    
                                                    //click add
                                                     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]")));
                                                    driver.findElement(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]")).click();
                                                    
                                                     System.out.println("clicked Add");
                                                    Log.info("log4j msg- clicked Add");
                                                    
                                                    //enter subject
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtSubject']")));
                                                    driver.findElement(By.xpath("//input[@id='txtSubject']")).sendKeys(OccupationalClassesCommsubject);
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
                                                    placeOfService.selectByVisibleText(OccupationalClassesCommNoteType);
                                                    System.out.println("selected note type");
                                                    Log.info("log4j msg-selected note type");
                                                    
                                                    Thread.sleep(1000);
                                                    //enter note details
                                                     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='txtNotes']")));
                                                    driver.findElement(By.xpath("//textarea[@id='txtNotes']")).sendKeys(OccupationalClassesCommDetails);
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
            		else
            		{System.out.println(" Operational class code not found ");
                    Log.info("log4j msg- Operational class code not found ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}
            		}
                                                    
                                     catch (Exception e){e.printStackTrace();System.out.println("error in adding Comm to OccupationalClasses");
                                                                                                                    Log.info("log4j msg - error in adding Comm to  OccupationalClasses"); 
                     BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();   }   
                                     
                                     }
                    
    
    
    //delete function
    public void deleteOccupationalClasses( String OccupationalClassesCode, String OccupationalClassesDescription) throws Exception{
                    
                    try{            
                    int i= searchOccupationalClasses(OccupationalClassesCode, OccupationalClassesDescription);
            		
            		if (i==1){
            			System.out.println("Occupational Classes found, continue with delete");
            			Log.info("log4j msg-Occupational Classes found, continue with delete");
            			
                    //find OccupationalClasses
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+OccupationalClassesCode+"']")));
                                                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+OccupationalClassesCode+"']")).click();
                                                    System.out.println("clicked Occupational Classes Code");
                                                    Log.info("log4j msg- clicked Occupational Classes code");
                                    
                                                    //click delete
                                                    
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(OccupationalClassesDeleteLink));
                                                    driver.findElement(OccupationalClassesDeleteLink).click();
                                                    System.out.println("clicked Delete");
                                                    Log.info("log4j msg- clicked Delete");
                                                    
                    
                                                    //click confirm delete
                                                    
                                                    
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(confirmDeleteButton));
                                                    driver.findElement(confirmDeleteButton).click();
                                                    System.out.println("clicked confirm Delete");
                                                    Log.info("log4j msg- clicked confirm Delete");
                                                     BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                                                    
                                                    
                    


    
    
} else{
	System.out.println("cannot find Occupational Classes ");
	Log.info("log4j msg- cannot find Occupational Classes ");
	wait.until(ExpectedConditions.visibilityOfElementLocated(OccupationalClassesExitLink));
	driver.findElement(OccupationalClassesExitLink).click();
	System.out.println("clicked Exit");
	Log.info("log4j msg- clicked Exit");
	
	
	 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
	
}} catch (Exception e){System.out.println("error in deleting Occupational Classes ");
Log.info("log4j msg - error in deleting Occupational Classes "); 

}   
    }

}
  



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

public class RVUGeographicMultipliers {
	
	WebDriver driver;
	WebDriverWait wait;    
	
	By RVUGeographicMultipliersNameDescriptionBeginsInput = By.xpath("//input[@data-ng-model='filterOptions.regionname']");
	
	By RVUGeographicMultipliersSearchButton= By.xpath("//button[@ng-click='search()']");
    
    By RVUGeographicMultipliersAddLink= By.linkText("Add");
    
    By RVUGeographicMultipliersCodeInput = By.xpath("//input[@id='txtRegionid']");
    
    By RVUGeographicMultipliersDescriptionInput= By.xpath("//input[@id='txtRegionname']");
    
    By RVUGeographicMultipliersRecordMark= By.xpath("//input[@style='width:20px;']");
    
    By RVUGeographicMultipliersValidateLink =By.linkText("Validate");
    
    By RVUGeographicMultipliersValidateSaveOKButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By RVUGeographicMultipliersSaveLink =  By.linkText("Save");
    
    By RVUGeographicMultipliersEditLink = By.linkText("Edit");
    
    By RVUGeographicMultipliersCopyLink = By.linkText("Copy");
    
    By RVUGeographicMultipliersDeleteLink= By.linkText("Delete");
    
    By confirmDeleteButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By RVUGeographicMultipliersCommLink= By.linkText("Commun.");
    
    By RVUGeographicMultipliersExitLink=  By.linkText("Exit");
    
    
    
    
    public RVUGeographicMultipliers(WebDriver driver){
                    this.driver= driver;
                    this.wait = new WebDriverWait(driver, 35);
    }
    
    
	public int searchRVUGeographicMultipliers( String RVUGeographicMultipliersCode, String RVUGeographicMultipliersName) throws Exception{
		try{
		//enter  RVU Geographic Multipliers code
		
	
	
		//enter  RVU Geographic Multipliers name
		wait.until(ExpectedConditions.visibilityOfElementLocated(RVUGeographicMultipliersNameDescriptionBeginsInput));
		driver.findElement(RVUGeographicMultipliersNameDescriptionBeginsInput).clear();
		driver.findElement(RVUGeographicMultipliersNameDescriptionBeginsInput).sendKeys(RVUGeographicMultipliersName);
		System.out.println("entered Name");
		Log.info("log4j msg- entered Name");
		
		//click search
		wait.until(ExpectedConditions.visibilityOfElementLocated(RVUGeographicMultipliersSearchButton));
		driver.findElement(RVUGeographicMultipliersSearchButton).click();
		System.out.println("clicked Search");
		Log.info("log4j msg- clicked Search");
				
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+RVUGeographicMultipliersCode+"']")));
		WebElement e = driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+RVUGeographicMultipliersCode+"']"));
		e.click();
		System.out.println("Found RVUGeographicMultipliers");
		Log.info("log4j msg- Found RVUGeographicMultipliers");
	
		return 1;
		}
		
	catch(Exception e){System.out.println("RVU Geographic Multipliers not found");Log.info("log4j msg- RVU Geographic Multipliers not found"); return 0;}
		
	}

    //add function
    public void addRVUGeographicMultipliers( String RVUGeographicMultipliersCode, String RVUGeographicMultipliersDescription)throws Exception{
    
                    try{ 
                    int i= searchRVUGeographicMultipliers( RVUGeographicMultipliersCode, RVUGeographicMultipliersDescription);
            		
            		if (i==0){
            			System.out.println("RVU Geographic Multipliers not found, Continue with Add");
            			Log.info("log4j msg- RVU Geographic Multipliers not found, Continue with Add");
            		
            		
                    wait.until(ExpectedConditions.visibilityOfElementLocated(RVUGeographicMultipliersAddLink));
                    driver.findElement(RVUGeographicMultipliersAddLink).click();
                    System.out.println("clicked Add");
                    Log.info("log4j msg- clicked Add");
                    
                    
                    System.out.println("RVU Geographic Multipliers code: "+RVUGeographicMultipliersCode);
                    Log.info("log4j msg- RVU Geographic Multipliers code: "+RVUGeographicMultipliersCode);
                    //enter code
                    wait.until(ExpectedConditions.visibilityOfElementLocated(RVUGeographicMultipliersCodeInput));
                    driver.findElement(RVUGeographicMultipliersCodeInput).sendKeys(RVUGeographicMultipliersCode);
                    Thread.sleep(1000);
                    System.out.println("Entered code");
                    Log.info("log4j msg- Entered code");
                    
                    System.out.println("RVU Geographic Multipliers description"+RVUGeographicMultipliersDescription);
                    Log.info("log4j msg- RVU Geographic Multipliers description"+RVUGeographicMultipliersDescription);
                    //enter Description
                    wait.until(ExpectedConditions.visibilityOfElementLocated(RVUGeographicMultipliersDescriptionInput));
                    driver.findElement(RVUGeographicMultipliersDescriptionInput).sendKeys(RVUGeographicMultipliersDescription);
                    Thread.sleep(1000);
                    System.out.println("Entered description");
                    Log.info("log4j msg- Entered description");
    
                    
                    //click validate
    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(RVUGeographicMultipliersValidateLink));
                    driver.findElement(RVUGeographicMultipliersValidateLink).click();
                    System.out.println("clicked validate");
                    Log.info("log4j msg- clicked validate");
                    
                    //click ok
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(RVUGeographicMultipliersValidateSaveOKButton));
                    driver.findElement(RVUGeographicMultipliersValidateSaveOKButton).click();
                    System.out.println("clicked validate ok to save button");
                    Log.info("log4j msg- clicked validate ok to save button");
                    
            		
                    //click save
                    Thread.sleep(1000);
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(RVUGeographicMultipliersSaveLink));
                    driver.findElement(RVUGeographicMultipliersSaveLink).click();
                    System.out.println("clicked save ");
                    Log.info("log4j msg- clicked  save ");
                      BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                    
                    } else{
            			System.out.println("RVU Geographic Multipliers is already present, cannot add RVUGeographicMultipliers");
            			 Log.info("log4j msg- RVU Geographic Multipliers is already present, cannot add RVUGeographicMultipliers");
            			wait.until(ExpectedConditions.visibilityOfElementLocated(RVUGeographicMultipliersExitLink));
            			driver.findElement(RVUGeographicMultipliersExitLink).click();
            			System.out.println("clicked Exit");
            			Log.info("log4j msg- clicked Exit");
            			
            			 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
            		}
    
                    }catch (Exception e){System.out.println("Error in adding RVU Geographic Multipliers"); Log.info("log4j msg- Error in adding RVU Geographic Multipliers"); }
            		}
                    
    //copy function
    
    public void copyRVUGeographicMultipliers( String RVUGeographicMultipliersCode, String RVUGeographicMultipliersName, String newRVUGeographicMultipliersCode, String newRVUGeographicMultipliersDescription)throws Exception{
                    
                    try{ 
                    int i= searchRVUGeographicMultipliers( RVUGeographicMultipliersCode, RVUGeographicMultipliersName);
            		
            		if (i==1){
            			System.out.println("RVU Geographic Multipliers found, continue with copy");
            			Log.info("log4j msg-RVU Geographic Multipliers found, continue with copy");
            		
                    
                    System.out.println("RVU Geographic Multipliers code"+RVUGeographicMultipliersCode);
                    Log.info("log4j msg-RVU Geographic Multipliers code"+RVUGeographicMultipliersCode);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+RVUGeographicMultipliersCode+"']")));
                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+RVUGeographicMultipliersCode+"']")).click();
                    System.out.println("clicked RVU Geographic Multipliers Code");
                    Log.info("log4j msg- clicked RVU Geographic Multipliers code");
                    
                    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(RVUGeographicMultipliersCopyLink));
                    driver.findElement(RVUGeographicMultipliersCopyLink).click();
                    System.out.println("clicked Copy");
                    Log.info("log4j msg- clicked Copy");
                    
                    System.out.println("RVU Geographic Multipliers newcode"+newRVUGeographicMultipliersCode);
                    Log.info("log4j msg-RVU Geographic Multipliers newcode"+newRVUGeographicMultipliersCode);
                    
                    //enter new code
                    wait.until(ExpectedConditions.visibilityOfElementLocated(RVUGeographicMultipliersCodeInput));
                    driver.findElement(RVUGeographicMultipliersCodeInput).clear();
                    driver.findElement(RVUGeographicMultipliersCodeInput).sendKeys(newRVUGeographicMultipliersCode);
                    System.out.println("Entered new code");
                    Log.info("log4j msg- Entered new code");
    
                    System.out.println("RVU Geographic Multipliers new description"+newRVUGeographicMultipliersDescription);
                    Log.info("log4j msg-RVU Geographic Multipliers new description"+newRVUGeographicMultipliersDescription);
    //enter new description
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(RVUGeographicMultipliersDescriptionInput));
                    driver.findElement(RVUGeographicMultipliersDescriptionInput).clear();
                    driver.findElement(RVUGeographicMultipliersDescriptionInput).sendKeys(newRVUGeographicMultipliersDescription);
                    System.out.println("Entered new description");
                    Log.info("log4j msg- Entered new description");
                    
                    
                    
                    
                    
                    //click save
                    wait.until(ExpectedConditions.visibilityOfElementLocated(RVUGeographicMultipliersSaveLink));
                    driver.findElement(RVUGeographicMultipliersSaveLink).click();

                    System.out.println("Clicked save");
                    Log.info("log4j msg- clicked save");
                      BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
            		
                    
            		
                    } else{
            			System.out.println("RVU Geographic Multipliers is already present, cannot copy RVUGeographicMultipliers");
            			 Log.info("log4j msg- RVU Geographic Multipliers is already present, cannot copy RVUGeographicMultipliers");
            			wait.until(ExpectedConditions.visibilityOfElementLocated(RVUGeographicMultipliersExitLink));
            			driver.findElement(RVUGeographicMultipliersExitLink).click();
            			System.out.println("clicked Exit");
            			Log.info("log4j msg- clicked Exit");
            			
            			 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
            		}
    
                    }catch (Exception e){System.out.println("Error in copying RVU Geographic Multipliers"); Log.info("log4j msg- Error in copying RVU Geographic Multipliers"); }
            		}
            		
            		
    
    
    

    
    //edit function
public void editRVUGeographicMultipliers( String RVUGeographicMultipliersCode, String rvugeographicMultipliersDescription, String recordMark)throws Exception{
                    
                    try{
                    int i= searchRVUGeographicMultipliers( RVUGeographicMultipliersCode, rvugeographicMultipliersDescription);
            		
            		if (i==1){
            			System.out.println("RVU Geographic Multipliers  found, Continue with Edit");
            			Log.info("log4j msg- RVU Geographic Multipliers  found, Continue with Edit");
            		}
            		
            		 System.out.println("RVU Geographic Multipliers code"+RVUGeographicMultipliersCode);
            		 Log.info("log4j msg- RVU Geographic Multipliers code"+RVUGeographicMultipliersCode);
                     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+RVUGeographicMultipliersCode+"']")));
                     driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+RVUGeographicMultipliersCode+"']")).click();
                     System.out.println("clicked RVU Geographic Multipliers Record Mark");
                     Log.info("log4j msg- clicked RVU Geographic Multipliers Record Mark");
                    
                    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(RVUGeographicMultipliersEditLink));
                    driver.findElement(RVUGeographicMultipliersEditLink).click();
                    System.out.println("clicked Edit");
                    Log.info("log4j msg- clicked Edit");
                    
                    System.out.println("RVU Geographic Multipliers Record Mark"+recordMark);
                    Log.info("log4j msg- RVU Geographic Multipliers Record Mark"+recordMark);                          
    //enter new description
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(RVUGeographicMultipliersRecordMark));
                    System.out.println("record mark: "+driver.findElement(RVUGeographicMultipliersRecordMark).getText());
                    driver.findElement(RVUGeographicMultipliersRecordMark).clear();
                    Thread.sleep(1000);
                    driver.findElement(RVUGeographicMultipliersRecordMark).sendKeys(recordMark);
                    System.out.println("Entered new description");
                    Log.info("log4j msg- Entered new description");
                    
                    
                    
                    
                    
                    //click save
                    wait.until(ExpectedConditions.visibilityOfElementLocated(RVUGeographicMultipliersSaveLink));
                    driver.findElement(RVUGeographicMultipliersSaveLink).click();
                    System.out.println("Clicked save");
                    Log.info("log4j msg- clicked save");
                      BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
            		
                    
            		}catch (Exception e){ e.printStackTrace();System.out.println("Error in Editing RVU Geographic Multipliers ");
                    Log.info("log4j msg- Error in Editing RVU Geographic Multipliers ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}
    
    
                    }
    //exit function
    public void exitRVUGeographicMultipliers( String RVUGeographicMultipliersCode) throws Exception{
    try{  System.out.println("RVU Geographic Multipliers code"+RVUGeographicMultipliersCode);
                    Log.info("log4j msg- RVU Geographic Multipliers code"+RVUGeographicMultipliersCode);
                                   Thread.sleep(1000);
                                    driver.findElement(RVUGeographicMultipliersExitLink).click();
                                    Thread.sleep(1000);
                                    System.out.println("Clicked exit in  RVU Geographic Multipliers ");
                                    Log.info("log4j msg- clicked exit in  RVU Geographic Multipliers ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                                    
    	}catch (Exception e){ e.printStackTrace();System.out.println("Error in exiting RVU Geographic Multipliers ");
    Log.info("log4j msg- Error in exiting RVU Geographic Multipliers ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}}
    
    //add comm function
    public void addCommRVUGeographicMultipliers( String RVUGeographicMultipliersCode, String RVUGeographicMultipliersName, String RVUGeographicMultipliersCommsubject, String RVUGeographicMultipliersCommNoteType, String RVUGeographicMultipliersCommMedium, String RVUGeographicMultipliersCommDetails) throws Exception{
                    
                    try{
                    int i= searchRVUGeographicMultipliers(RVUGeographicMultipliersCode, RVUGeographicMultipliersName);
            		
            		if (i==1){
            			System.out.println("RVU Geographic Multipliers found, Continue with Add Comm");
            			Log.info("log4j msg- RVU Geographic Multipliers found, Continue with Add Comm");
            		
            		
                    System.out.println("RVU Geographic Multipliers code"+RVUGeographicMultipliersCode);
                    Log.info("log4j msg- RVU Geographic Multipliers code"+RVUGeographicMultipliersCode);
                                    //find RVUGeographicMultipliers
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+RVUGeographicMultipliersCode+"']")));
                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+RVUGeographicMultipliersCode+"']")).click();
                    System.out.println("clicked RVU Geographic Multipliers Code");
                    Log.info("log4j msg- clicked RVU Geographic Multipliers code");
                    
                                                    //click comm
                                                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(RVUGeographicMultipliersCommLink));
                    driver.findElement(RVUGeographicMultipliersCommLink).click();
                    System.out.println("clicked Comm");
                    Log.info("log4j msg- clicked Comm");

                                                    
                                                    
                                                    //click add
                                                      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")));
                                                    driver.findElement(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")).click();
                                                    
                                                     System.out.println("clicked Add");
                                                    Log.info("log4j msg- clicked Add");
                                                    
                                                    //enter subject
                                                     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtSubject']")));
                                                    driver.findElement(By.xpath("//input[@id='txtSubject']")).sendKeys(RVUGeographicMultipliersCommsubject);
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
                                                    placeOfService.selectByVisibleText(RVUGeographicMultipliersCommNoteType);
                                                    System.out.println("selected note type");
                                                    Log.info("log4j msg-selected note type");
                                                    
                                                    Thread.sleep(1000);
                                                    //enter note details
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='txtNotes']")));
                                                    driver.findElement(By.xpath("//textarea[@id='txtNotes']")).sendKeys(RVUGeographicMultipliersCommDetails);
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
                                                    
                                     catch (Exception e){e.printStackTrace();System.out.println("Error in adding Comm to RVU Geographic Multipliers");
                                                                                                                    Log.info("log4j msg - Error in adding Comm to  RVU Geographic Multipliers"); 
                     BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();   }   
                                     
                                     }
                    
    
    
    //delete function
    public void deleteRVUGeographicMultipliers( String RVUGeographicMultipliersCode, String RVUGeographicMultipliersDescription) throws Exception{
                    
                    try{           
                    int i= searchRVUGeographicMultipliers( RVUGeographicMultipliersCode, RVUGeographicMultipliersDescription);
            		
            		if (i==1){
            			System.out.println("RVU Geographic Multipliers found, continue with delete");
            			Log.info("log4j msg-RVU Geographic Multipliers found, continue with delete");
            			
                    //find RVUGeographicMultipliers
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+RVUGeographicMultipliersCode+"']")));
                                                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+RVUGeographicMultipliersCode+"']")).click();
                                                    System.out.println("clicked RVU Geographic Multipliers Code");
                                                    Log.info("log4j msg- clicked RVU Geographic Multipliers code");
                                    
                                                    //click delete
                                                    
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(RVUGeographicMultipliersDeleteLink));
                                                    driver.findElement(RVUGeographicMultipliersDeleteLink).click();
                                                    System.out.println("clicked Delete");
                                                    Log.info("log4j msg- clicked Delete");
                                                    
                    
                                                    //click confirm delete
                                                    
                                                    
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(confirmDeleteButton));
                                                    driver.findElement(confirmDeleteButton).click();
                                                    System.out.println("clicked confirm Delete");
                                                    Log.info("log4j msg- clicked confirm Delete");
                                                     BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                                                    
                                                    
                    


    
    
} else{
	System.out.println("cannot find RVU Geographic Multipliers ");
	Log.info("log4j msg- cannot find RVU Geographic Multipliers ");
	wait.until(ExpectedConditions.visibilityOfElementLocated(RVUGeographicMultipliersExitLink));
	driver.findElement(RVUGeographicMultipliersExitLink).click();
	System.out.println("clicked Exit");
	Log.info("log4j msg- clicked Exit");
	
	
	 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
	
}} catch (Exception e){System.out.println("Error in deleting RVU Geographic Multipliers ");
Log.info("log4j msg - Error in deleting RVU Geographic Multipliers "); 

}   
    }


}
  





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

public class EthnicCategories{

	WebDriver driver;
	WebDriverWait wait;
	
	By EthnicCategoriesCodeBeginsInput = By.xpath("//input[@id='txtCode']");
	
	By EthnicCategoriesNameDescriptionBeginsInput = By.xpath("//input[@id='txtName']");
	
	By EthnicCategoriesSearchButton= By.xpath("//button[@data-ng-click='search(0)']");
    
    By EthnicCategoriesAddLink= By.linkText("Add");
    
    By EthnicCategoriesCodeInput = By.xpath("//input[@id='code']");
    
    By EthnicCategoriesDescriptionInput= By.xpath("//input[@id='name']");
    
    By EthnicCategoriesRecordMark= By.xpath("//input[@style='width:20px;']");
    
    By EthnicCategoriesValidateLink =By.linkText("Validate");
      
    By EthnicCategoriesValidateSaveOKButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By EthnicCategoriesSaveLink =  By.linkText("Save");
    
    By EthnicCategoriesEditLink = By.linkText("Edit");
    
    By EthnicCategoriesCopyLink = By.linkText("Copy");
    
    By EthnicCategoriesDeleteLink= By.linkText("Delete");
    
    By confirmDeleteButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By EthnicCategoriesCommLink= By.linkText("Commun.");
    
    By EthnicCategoriesExitLink=  By.linkText("Exit");
    
    
    public EthnicCategories(WebDriver driver){
                    this.driver= driver;
                    this.wait = new WebDriverWait(driver, 20);
    }
    
    
	public int searchEthnicCategories( String EthnicCategoriesCode, String EthnicCategoriesName) throws Exception{
		
		try{
		//enter  Ethnic Categories code
		wait.until(ExpectedConditions.visibilityOfElementLocated(EthnicCategoriesCodeBeginsInput));
		driver.findElement(EthnicCategoriesCodeBeginsInput).clear();
		driver.findElement(EthnicCategoriesCodeBeginsInput).sendKeys(EthnicCategoriesCode);
		System.out.println("entered Ethnic Categories  code");
		Log.info("log4j msg- entered Ethnic Categories code");
	
	
		//enter  Ethnic Categories name
		wait.until(ExpectedConditions.visibilityOfElementLocated(EthnicCategoriesNameDescriptionBeginsInput));
		driver.findElement(EthnicCategoriesNameDescriptionBeginsInput).clear();
		driver.findElement(EthnicCategoriesNameDescriptionBeginsInput).sendKeys(EthnicCategoriesName);
		System.out.println("entered Ethnic Categories name");
		Log.info("log4j msg- entered Ethnic Categories name");
		
		//click search
		wait.until(ExpectedConditions.visibilityOfElementLocated(EthnicCategoriesSearchButton));
		driver.findElement(EthnicCategoriesSearchButton).click();
		System.out.println("clicked Search");
		Log.info("log4j msg- clicked Search");
				
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+EthnicCategoriesCode+"']")));
		WebElement e = driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+EthnicCategoriesCode+"']"));
		e.click();
		System.out.println("Found EthnicCategories");
		Log.info("log4j msg- Found EthnicCategories");
	
		return 1;
		}
		
	catch(Exception e){System.out.println("Ethnic Categories not found"); 
	Log.info(" Ethnic Categories not found");
	return 0;}
		
	}

    //add function
    public void addEthnicCategories( String EthnicCategoriesCode, String EthnicCategoriesDescription)throws Exception{
    
                    try{ 
                    
                    int i= searchEthnicCategories( EthnicCategoriesCode, EthnicCategoriesDescription);
            		
            		if (i==0){
            			System.out.println("Ethnic Categories not found, Continue with Add");
            			Log.info("log4j msg- Ethnic Categories not found, Continue with Add");
            		
            		
                    wait.until(ExpectedConditions.visibilityOfElementLocated(EthnicCategoriesAddLink));
                    driver.findElement(EthnicCategoriesAddLink).click();
                    System.out.println("clicked Add");
                    Log.info("log4j msg- clicked Add");
                    
                    
                    System.out.println("Ethnic Categories code: "+EthnicCategoriesCode);
                    Log.info("Ethnic Categories code: "+EthnicCategoriesCode);
                    //enter code
                    wait.until(ExpectedConditions.visibilityOfElementLocated(EthnicCategoriesCodeInput));
                    driver.findElement(EthnicCategoriesCodeInput).sendKeys(EthnicCategoriesCode);
                    Thread.sleep(1000);
                    System.out.println("Entered code");
                    Log.info("log4j msg- Entered code");
                    
                    System.out.println("Ethnic Categories description"+EthnicCategoriesDescription);
                    //enter Description
                    wait.until(ExpectedConditions.visibilityOfElementLocated(EthnicCategoriesDescriptionInput));
                    driver.findElement(EthnicCategoriesDescriptionInput).sendKeys(EthnicCategoriesDescription);
                    Thread.sleep(1000);
                    System.out.println("Entered description");
                    Log.info("log4j msg- Entered description");
    
                    
                    //click validate
    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(EthnicCategoriesValidateLink));
                    driver.findElement(EthnicCategoriesValidateLink).click();
                    System.out.println("clicked validate");
                    Log.info("log4j msg- clicked validate");
                    
                    //click ok
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(EthnicCategoriesValidateSaveOKButton));
                    driver.findElement(EthnicCategoriesValidateSaveOKButton).click();
                    System.out.println("clicked validate ok to save button");
                    Log.info("log4j msg- clicked validate ok to save button");
                    
            		
                    //click save
                    Thread.sleep(1000);
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(EthnicCategoriesSaveLink));
                    driver.findElement(EthnicCategoriesSaveLink).click();
                    System.out.println("clicked save ");
                    Log.info("log4j msg- clicked  save ");
                    Thread.sleep(1000);
                      BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                      driver.quit(); 

                    
                    } else{
            			System.out.println("Ethnic Categories is already present, cannot add EthnicCategories");
            			wait.until(ExpectedConditions.visibilityOfElementLocated(EthnicCategoriesExitLink));
            			driver.findElement(EthnicCategoriesExitLink).click();
            			System.out.println("clicked Exit");
            			Log.info("log4j msg- clicked Exit");
            			
            			 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
            			 driver.quit(); 
            		}
    
                    }catch (Exception e){System.out.println("Error in Adding EthnicCategories"); 
                    Log.info("Error in Adding EthnicCategories");}
            		}
                    
    //copy function
    
    public void copyEthnicCategories( String EthnicCategoriesCode, String EthnicCategoriesName, String newEthnicCategoriesCode, String newEthnicCategoriesDescription)throws Exception{
                    
                    try{ 
                    
                    int i= searchEthnicCategories( EthnicCategoriesCode, EthnicCategoriesName);
            		
            		if (i==1){
            			System.out.println("Ethnic Categories found, continue with copy");
            			Log.info("log4j msg-Ethnic Categories found, continue with copy");
            		
                    
                    System.out.println("Ethnic Categories code"+EthnicCategoriesCode);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+EthnicCategoriesCode+"']")));
                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+EthnicCategoriesCode+"']")).click();
                    System.out.println("clicked Ethnic Categories Code");
                    Log.info("log4j msg- clicked Ethnic Categories code");
                    
                    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(EthnicCategoriesCopyLink));
                    driver.findElement(EthnicCategoriesCopyLink).click();
                    System.out.println("clicked Copy");
                    Log.info("log4j msg- clicked Copy");
                    
                    System.out.println("Ethnic Categories newcode"+newEthnicCategoriesCode);
                    
                    //enter new code
                    wait.until(ExpectedConditions.visibilityOfElementLocated(EthnicCategoriesCodeInput));
                    driver.findElement(EthnicCategoriesCodeInput).clear();
                    driver.findElement(EthnicCategoriesCodeInput).sendKeys(newEthnicCategoriesCode);
                    System.out.println("Entered new code");
                    Log.info("log4j msg- Entered new code");
    
                    System.out.println("Ethnic Categories new description"+newEthnicCategoriesDescription);
                    Log.info("log4j msg-Ethnic Categories new description"+newEthnicCategoriesDescription);
    //enter new description
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(EthnicCategoriesDescriptionInput));
                    driver.findElement(EthnicCategoriesDescriptionInput).clear();
                    driver.findElement(EthnicCategoriesDescriptionInput).sendKeys(newEthnicCategoriesDescription);
                    System.out.println("Entered new description");
                    Log.info("log4j msg- Entered new description");
                    
                    
                    
                    
                    
                    //click save
                    wait.until(ExpectedConditions.visibilityOfElementLocated(EthnicCategoriesSaveLink));
                    driver.findElement(EthnicCategoriesSaveLink).click();

                    System.out.println("Clicked save");
                    Log.info("log4j msg- clicked save");
                    Thread.sleep(1000);
                      BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                      driver.quit(); 
            		
                    
            		
                    } else{
            			System.out.println("Ethnic Categories is not present, cannot copy EthnicCategories");
            			Log.info("Ethnic Categories is not present, cannot copy EthnicCategories");
            			wait.until(ExpectedConditions.visibilityOfElementLocated(EthnicCategoriesExitLink));
            			driver.findElement(EthnicCategoriesExitLink).click();
            			System.out.println("clicked Exit");
            			Log.info("log4j msg- clicked Exit");
            			
            			 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
            			 driver.quit(); 
            		}
    
                    }catch (Exception e){System.out.println("error in Copying EthnicCategories");
                    Log.info("error in Copying EthnicCategories");}
            		}
            		
            		
    
    
    

    
    //edit function
public void editEthnicCategories( String EthnicCategoriesCode, String ethnicCategoriesDescription, String recordMark)throws Exception{
                    
                    try{ 
                    
                    int i= searchEthnicCategories( EthnicCategoriesCode, ethnicCategoriesDescription);
            		
            		if (i==1){
            			System.out.println("Ethnic Categories  found, Continue with Edit");
            			Log.info("log4j msg- Ethnic Categories  found, Continue with Edit");
            		
            		
                    System.out.println("Ethnic Categories code"+EthnicCategoriesCode);
                   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+EthnicCategoriesCode+"']")));
                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+EthnicCategoriesCode+"']")).click();
                    System.out.println("clicked Ethnic Categories ");
                    Log.info("log4j msg- clicked Ethnic Categories");
                    
                    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(EthnicCategoriesEditLink));
                    driver.findElement(EthnicCategoriesEditLink).click();
                    System.out.println("clicked Edit");
                    Log.info("log4j msg- clicked Edit");
                    
                    System.out.println("Ethnic Categories Record Mark"+recordMark);
                                                   
    //enter new description
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(EthnicCategoriesRecordMark));
                    System.out.println("current record mark: "+driver.findElement(EthnicCategoriesRecordMark).getText());
                    driver.findElement(EthnicCategoriesRecordMark).clear();
                    Thread.sleep(1000);
                    driver.findElement(EthnicCategoriesRecordMark).sendKeys(recordMark);
                    System.out.println("Entered new record mark");
                    Log.info("log4j msg- Entered new record mark");
                    
                    
                    
                    
                    //click save
                    wait.until(ExpectedConditions.visibilityOfElementLocated(EthnicCategoriesSaveLink));
                    driver.findElement(EthnicCategoriesSaveLink).click();
                    System.out.println("Clicked save");
                    Log.info("log4j msg- clicked save");
                    Thread.sleep(1000);
                      BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                      driver.quit();
            		}
                    
            		else{System.out.println("Ethnic Categories not found ");
                    Log.info("log4j msg- Ethnic Categories not found ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
                    driver.quit(); }
            		
            		}catch (Exception e){ e.printStackTrace();System.out.println("Error in Editing Ethnic Categories ");
                    Log.info("log4j msg- Error in Editing Ethnic Categories ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                    driver.quit(); }
    
    
                    }
    //exit function
    public void exitEthnicCategories( String EthnicCategoriesCode) throws Exception{
    try{
                 
                    System.out.println("Ethnic Categories code"+EthnicCategoriesCode);
                
                                    Thread.sleep(1000);
                                    driver.findElement(EthnicCategoriesExitLink).click();
                                    Thread.sleep(1000);
                                    System.out.println("Clicked exit in  Ethnic Categories ");
                                    Log.info("log4j msg- clicked exit in  Ethnic Categories ");
                                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                                    driver.quit(); 
                
                                    
    	}catch (Exception e){ e.printStackTrace();System.out.println("Error in Exit Ethnic Categories ");
    Log.info("log4j msg- Error in Exit Ethnic Categories ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
    driver.quit(); }}
    
    //add comm function
    public void addCommEthnicCategories( String EthnicCategoriesCode, String EthnicCategoriesName, String EthnicCategoriesCommsubject, String EthnicCategoriesCommNoteType, String EthnicCategoriesCommMedium, String EthnicCategoriesCommDetails) throws Exception{
                    
                    try{        
                    
                    int i= searchEthnicCategories( EthnicCategoriesCode, EthnicCategoriesName);
            		
            		if (i==1){
            			System.out.println("Ethnic Categories  found, Continue with Add Communication");
            			Log.info("log4j msg- Ethnic Categories  found, Continue with Add Communication");
            		
            		
                    System.out.println("Ethnic Categories code"+EthnicCategoriesCode);
                                    //find EthnicCategories
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+EthnicCategoriesCode+"']")));
                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+EthnicCategoriesCode+"']")).click();
                    System.out.println("clicked Ethnic Categories Code");
                    Log.info("log4j msg- clicked Ethnic Categories code");
                    
                                                    //click comm
                                                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(EthnicCategoriesCommLink));
                    driver.findElement(EthnicCategoriesCommLink).click();
                    System.out.println("clicked Comm");
                    Log.info("log4j msg- clicked Comm");

                                                    
                                                    
                                                    //click add
                                                   
                                                 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]")));
                                                 driver.findElement(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]")).click();
                                                   System.out.println("clicked Add");
                                                    
                                                    Log.info("log4j msg- clicked Add");
                                                    
                                                    //enter subject
                                                     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtSubject']")));
                                                    driver.findElement(By.xpath("//input[@id='txtSubject']")).sendKeys(EthnicCategoriesCommsubject);
                                                    System.out.println("entered subject");
                                                    Log.info("log4j msg- entered subject");
                                                    
                                                    
                                                    //page down
                                                  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@data-ng-model='currentRecord.notes']")));
                                                    driver.findElement(By.xpath("//textarea[@data-ng-model='currentRecord.notes']")).sendKeys(Keys.PAGE_DOWN);
                                                    System.out.println("clicked page down");
                                                    Log.info("log4j msg- clicked page down");
                                                    
                                                    Thread.sleep(2000);
                                                    
                                                    
                                                    //click add details
                                                   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-ng-click='addChildRecord()']")));
                                                    driver.findElement(By.xpath("//button[@data-ng-click='addChildRecord()']")).click();
                                                    System.out.println("clicked add details");
                                                    Log.info("log4j msg- clicked add details");
                                                    
                                                    Thread.sleep(2000);
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlNoteType"))); 
                                                    Select placeOfService = new Select(driver.findElement(By.xpath("//select[@id='ddlNoteType']")));
                                                    placeOfService.selectByVisibleText(EthnicCategoriesCommNoteType);
                                                    System.out.println("selected note type");
                                                    Log.info("log4j msg-selected note type");
                                                    
                                                    Thread.sleep(1000);
                                                    //enter note details
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='txtNotes']")));
                                                    driver.findElement(By.xpath("//textarea[@id='txtNotes']")).sendKeys(EthnicCategoriesCommDetails);
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
                                                    
                                     BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                                     driver.quit(); }}
                                                    
                                     catch (Exception e){e.printStackTrace();System.out.println("error in adding Comm to EthnicCategories");
                                                                                                                    Log.info("log4j msg - error in adding Comm to  EthnicCategories"); 
                     BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
                     driver.quit();  }   
                                     
                                     }
                    
    
    
    //delete function
    public void deleteEthnicCategories( String EthnicCategoriesCode, String EthnicCategoriesDescription) throws Exception{
                    
                    try{       
                                    
                    int i= searchEthnicCategories( EthnicCategoriesCode, EthnicCategoriesDescription);
            		
            		if (i==1){
            			System.out.println("Ethnic Categories found, continue with delete");
            			Log.info("log4j msg-Ethnic Categories found, continue with delete");
            			
                    //find EthnicCategories
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+EthnicCategoriesCode+"']")));
                                                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+EthnicCategoriesCode+"']")).click();
                                                    System.out.println("clicked Ethnic Categories Code");
                                                    Log.info("log4j msg- clicked Ethnic Categories code");
                                    
                                                    //click delete
                                                    
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(EthnicCategoriesDeleteLink));
                                                    driver.findElement(EthnicCategoriesDeleteLink).click();
                                                    System.out.println("clicked Delete");
                                                    Log.info("log4j msg- clicked Delete");
                                                    
                    
                                                    //click confirm delete
                                                    
                                                    
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(confirmDeleteButton));
                                                    driver.findElement(confirmDeleteButton).click();
                                                    System.out.println("clicked confirm Delete");
                                                    Log.info("log4j msg- clicked confirm Delete");
                                                     BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                                                     driver.quit(); 
                                                 
} else{
	System.out.println("cannot find Ethnic Categories ");
	Log.info("log4j msg- cannot find Ethnic Categories ");
	wait.until(ExpectedConditions.visibilityOfElementLocated(EthnicCategoriesExitLink));
	driver.findElement(EthnicCategoriesExitLink).click();
	System.out.println("clicked Exit");
	Log.info("log4j msg- clicked Exit");
	
	
	 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
	 driver.quit(); 
	
}} catch (Exception e){System.out.println("error in deleting Ethnic Categories ");
Log.info("log4j msg - error in deleting Ethnic Categories "); 

}   
    }

}
  



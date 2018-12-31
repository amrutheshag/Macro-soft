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

public class DiagnosticCategories {

	WebDriver driver;
	WebDriverWait wait ;

	
	By DiagnosticCategoriesCodeBeginsInput = By.xpath("//input[@id='txtCode']");
	
	By DiagnosticCategoriesNameDescriptionBeginsInput = By.xpath("//input[@id='txtName']");
	
	By DiagnosticCategoriesSearchButton= By.xpath("//button[@data-ng-click='search(0)']");
    
    By DiagnosticCategoriesAddLink= By.linkText("Add");
    
    By DiagnosticCategoriesCodeInput = By.xpath("//input[@id='code']");
    
    By DiagnosticCategoriesDescriptionInput= By.xpath("//input[@id='name']");
    
    By DiagnosticCategoriesRecordMark= By.xpath("//input[@style='width:20px;']");
    
    By DiagnosticCategoriesValidateLink =By.linkText("Validate");
    
    By DiagnosticCategoriesValidateSaveOKButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By DiagnosticCategoriesSaveLink =  By.linkText("Save");
    
    By DiagnosticCategoriesEditLink = By.linkText("Edit");
    
    By DiagnosticCategoriesCopyLink = By.linkText("Copy");
    
    By DiagnosticCategoriesDeleteLink= By.linkText("Delete");

    By confirmDeleteButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By DiagnosticCategoriesCommLink= By.linkText("Commun.");
    
    By DiagnosticCategoriesExitLink=  By.linkText("Exit");
    
    
    
    
    public DiagnosticCategories(WebDriver driver){
                    this.driver= driver;
                    this.wait= new WebDriverWait(driver, 30);
    }
    
    
	public int searchDiagnosticCategories( String DiagnosticCategoriesCode, String DiagnosticCategoriesName) throws Exception{
		
		try{
		//enter  Diagnostic Categories code
		wait.until(ExpectedConditions.visibilityOfElementLocated(DiagnosticCategoriesCodeBeginsInput));
		driver.findElement(DiagnosticCategoriesCodeBeginsInput).clear();
		driver.findElement(DiagnosticCategoriesCodeBeginsInput).sendKeys(DiagnosticCategoriesCode);
		System.out.println("entered Diagnostic Categories  Representivescode");
		Log.info("log4j msg- entered Diagnostic Categories code");
	
	
		//enter  Diagnostic Categories name
		wait.until(ExpectedConditions.visibilityOfElementLocated(DiagnosticCategoriesNameDescriptionBeginsInput));
		driver.findElement(DiagnosticCategoriesNameDescriptionBeginsInput).clear();
		driver.findElement(DiagnosticCategoriesNameDescriptionBeginsInput).sendKeys(DiagnosticCategoriesName);
		System.out.println("entered Diagnostic Categories name");
		Log.info("log4j msg- entered Diagnostic Categories name");
		
		//click search
		wait.until(ExpectedConditions.visibilityOfElementLocated(DiagnosticCategoriesSearchButton));
		driver.findElement(DiagnosticCategoriesSearchButton).click();
		System.out.println("clicked Search");
		Log.info("log4j msg- clicked Search");
				
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+DiagnosticCategoriesCode+"']")));
		WebElement e = driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+DiagnosticCategoriesCode+"']"));
		e.click();
		System.out.println("Found DiagnosticCategories");
		Log.info("log4j msg- Found DiagnosticCategories");
	
		return 1;
		}
		
	catch(Exception e){System.out.println("Diagnostic Categories Not found"); Log.info("log4j msg- Diagnostic Categories not found");return 0;}
		
	}

    //add function
    public void addDiagnosticCategories( String DiagnosticCategoriesCode, String DiagnosticCategoriesDescription)throws Exception{
    
                    try{ 
                    
                    int i= searchDiagnosticCategories( DiagnosticCategoriesCode, DiagnosticCategoriesDescription);
            		
            		if (i==0){
            			System.out.println("Diagnostic Categories not found, Continue with Add");
            			Log.info("log4j msg- Diagnostic Categories not found, Continue with Add");
            		
            		
                    wait.until(ExpectedConditions.visibilityOfElementLocated(DiagnosticCategoriesAddLink));
                    driver.findElement(DiagnosticCategoriesAddLink).click();
                    System.out.println("clicked Add");
                    Log.info("log4j msg- clicked Add");
                    
                    
                    System.out.println("Diagnostic Categories code: "+DiagnosticCategoriesCode);
                    Log.info("log4j msg- Diagnostic Categories code: "+DiagnosticCategoriesCode);
                    //enter code
                    wait.until(ExpectedConditions.visibilityOfElementLocated(DiagnosticCategoriesCodeInput));
                    driver.findElement(DiagnosticCategoriesCodeInput).sendKeys(DiagnosticCategoriesCode);
                    Thread.sleep(1000);
                    System.out.println("Entered code");
                    Log.info("log4j msg- Entered code");
                    
                    System.out.println("Diagnostic Categories description"+DiagnosticCategoriesDescription);
                    Log.info("log4j msg- Diagnostic Categories code: "+DiagnosticCategoriesDescription);
                    //enter Description
                    wait.until(ExpectedConditions.visibilityOfElementLocated(DiagnosticCategoriesDescriptionInput));
                    driver.findElement(DiagnosticCategoriesDescriptionInput).sendKeys(DiagnosticCategoriesDescription);
                    Thread.sleep(1000);
                    System.out.println("Entered description");
                    Log.info("log4j msg- Entered description");
    
                    
                    //click validate
    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(DiagnosticCategoriesValidateLink));
                    driver.findElement(DiagnosticCategoriesValidateLink).click();
                    System.out.println("clicked validate");
                    Log.info("log4j msg- clicked validate");
                    
                    //click ok
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(DiagnosticCategoriesValidateSaveOKButton));
                    driver.findElement(DiagnosticCategoriesValidateSaveOKButton).click();
                    System.out.println("clicked validate ok to save button");
                    Log.info("log4j msg- clicked validate ok to save button");
                    
            		
                    //click save
                    Thread.sleep(1000);
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(DiagnosticCategoriesSaveLink));
                    driver.findElement(DiagnosticCategoriesSaveLink).click();
                    System.out.println("clicked save ");
                    Log.info("log4j msg- clicked  save ");
                    Thread.sleep(1000);
                      BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                      driver.quit(); 
                    
                    } else{
            			System.out.println("Diagnostic Categories is already present, cannot add Diagnostic Categories");
            			Log.info("log4j msg- Diagnostic Categories is already present, cannot add Diagnostic Categories");
            			wait.until(ExpectedConditions.visibilityOfElementLocated(DiagnosticCategoriesExitLink));
            			driver.findElement(DiagnosticCategoriesExitLink).click();
            			System.out.println("clicked Exit");
            			Log.info("log4j msg- clicked Exit");
            			 Thread.sleep(1000);
            			 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
            			 driver.quit(); 
            		}
    
                    }catch (Exception e){System.out.println("error in adding Diagnostic Categories");Log.info("log4j msg- error in adding Diagnostic Categories"); }
            		}
                    
    //copy function
    
    public void copyDiagnosticCategories( String DiagnosticCategoriesCode, String DiagnosticCategoriesName, String newDiagnosticCategoriesCode, String newDiagnosticCategoriesDescription)throws Exception{
                    
                    try{ 
                    int i= searchDiagnosticCategories( DiagnosticCategoriesCode, DiagnosticCategoriesName);
            		
            		if (i==1){
            			System.out.println("Diagnostic Categories found, continue with copy");
            			Log.info("log4j msg-Diagnostic Categories found, continue with copy");
            		
                    
                    System.out.println("Diagnostic Categories code"+DiagnosticCategoriesCode);
                    Log.info("log4j msg-Diagnostic Categories code"+DiagnosticCategoriesCode);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+DiagnosticCategoriesCode+"']")));
                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+DiagnosticCategoriesCode+"']")).click();
                    System.out.println("clicked Diagnostic Categories Code");
                    Log.info("log4j msg- clicked Diagnostic Categories code");
                    
                    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(DiagnosticCategoriesCopyLink));
                    driver.findElement(DiagnosticCategoriesCopyLink).click();
                    System.out.println("clicked Copy");
                    Log.info("log4j msg- clicked Copy");
                    
                    System.out.println("Diagnostic Categories new code"+newDiagnosticCategoriesCode);
                    Log.info("log4j msg- Diagnostic Categories new code"+newDiagnosticCategoriesCode);
                    //enter new code
                    wait.until(ExpectedConditions.visibilityOfElementLocated(DiagnosticCategoriesCodeInput));
                    driver.findElement(DiagnosticCategoriesCodeInput).clear();
                    driver.findElement(DiagnosticCategoriesCodeInput).sendKeys(newDiagnosticCategoriesCode);
                    System.out.println("Entered new code");
                    Log.info("log4j msg- Entered new code");
    
                    System.out.println("Diagnostic Categories new description"+newDiagnosticCategoriesDescription);
                    Log.info("log4j msg- Diagnostic Categories new description"+newDiagnosticCategoriesDescription);
    //enter new description
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(DiagnosticCategoriesDescriptionInput));
                    driver.findElement(DiagnosticCategoriesDescriptionInput).clear();
                    driver.findElement(DiagnosticCategoriesDescriptionInput).sendKeys(newDiagnosticCategoriesDescription);
                    System.out.println("Entered new description");
                    Log.info("log4j msg- Entered new description");
                    
                    
                    
                    
                    
                    //click save
                    wait.until(ExpectedConditions.visibilityOfElementLocated(DiagnosticCategoriesSaveLink));
                    driver.findElement(DiagnosticCategoriesSaveLink).click();

                    System.out.println("Clicked save");
                    Log.info("log4j msg- clicked save");
                    Thread.sleep(1000);
                      BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
                      driver.quit(); 
            		
                    
            		
                    } else{
            			System.out.println("Diagnostic Categories is not present, cannot copy Diagnostic Categories");
            			Log.info("log4j msg- Diagnostic Categories is not present, cannot copy Diagnostic Categories");
            			wait.until(ExpectedConditions.visibilityOfElementLocated(DiagnosticCategoriesExitLink));
            			driver.findElement(DiagnosticCategoriesExitLink).click();
            			System.out.println("clicked Exit");
            			Log.info("log4j msg- clicked Exit");
            			 Thread.sleep(1000);
            			
            			 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
            			 driver.quit(); 
            		}
    
                    }catch (Exception e){System.out.println("error in copying Diagnostic Categories");Log.info("log4j msg- error in copying Diagnostic Categories"); }
            		}
            		
            		
    
    
    

    
    //edit function
public void editDiagnosticCategories( String DiagnosticCategoriesCode, String diagnosticCategoriesDescription, String recordMark)throws Exception{
                    
                    try{ 
                    	
                    int i= searchDiagnosticCategories( DiagnosticCategoriesCode, diagnosticCategoriesDescription);
            		
            		if (i==1){
            			System.out.println("Diagnostic Categories  found, Continue with Edit");
            			Log.info("log4j msg- Diagnostic Categories  found, Continue with Edit");
            		
            		
                    System.out.println("Diagnostic Categories code"+DiagnosticCategoriesCode);
                    Log.info("log4j msg- Diagnostic Categories code"+DiagnosticCategoriesCode);
                     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+DiagnosticCategoriesCode+"']")));
                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+DiagnosticCategoriesCode+"']")).click();
                    System.out.println("clicked Diagnostic Categories Record Mark");
                    Log.info("log4j msg- clicked Diagnostic Categories Record Mark");
                    
                    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(DiagnosticCategoriesEditLink));
                    driver.findElement(DiagnosticCategoriesEditLink).click();
                    System.out.println("clicked Edit");
                    Log.info("log4j msg- clicked Edit");
                    
                    System.out.println("Diagnostic Categories Record Mark"+recordMark);
                    Log.info("log4j msg-Diagnostic Categories Record Mark"+recordMark);
                                                   
    //enter new description
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(DiagnosticCategoriesRecordMark));
                  driver.findElement(DiagnosticCategoriesRecordMark).clear();
                    Thread.sleep(1000);
                    driver.findElement(DiagnosticCategoriesRecordMark).sendKeys(recordMark);
                    System.out.println("Entered new description");
                    Log.info("log4j msg- Entered new description");
                    
                    
                    
                    
                    //click save
                    wait.until(ExpectedConditions.visibilityOfElementLocated(DiagnosticCategoriesSaveLink));
                    driver.findElement(DiagnosticCategoriesSaveLink).click();
                    System.out.println("Clicked save");
                    Log.info("log4j msg- clicked save");
                    Thread.sleep(1000);
                      BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                      driver.quit();
            		}
                    
            		else{System.out.println("Diagnostic Categories not found, cannot edit Diagnostic Categories");
                    Log.info("log4j msg- Diagnostic Categories not found, cannot edit Diagnostic Categories");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
                    driver.quit(); }
            		
            		}catch (Exception e){ e.printStackTrace();System.out.println("Error in Editing Diagnostic Categories ");
                    Log.info("log4j msg- Error in Editing Diagnostic Categories ");   
                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                    driver.quit(); 
}
                    
    
    
                    }
    //exit function
    public void exitDiagnosticCategories( String DiagnosticCategoriesCode) throws Exception{
    try{
                    System.out.println("Diagnostic Categories code"+DiagnosticCategoriesCode);
                    Log.info("log4j msg- Diagnostic Categories code"+DiagnosticCategoriesCode);
                                    Thread.sleep(1000);
                                    driver.findElement(DiagnosticCategoriesExitLink).click();
                                    Thread.sleep(1000);
                                    System.out.println("Clicked exit in  Diagnostic Categories ");
                                    Log.info("log4j msg- clicked exit in  Diagnostic Categories ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                                    driver.quit(); 

                  
                                    
    	}catch (Exception e){ e.printStackTrace();System.out.println("Error in Exiting Diagnostic Categories ");
    Log.info("log4j msg- Error in Exiting Diagnostic Categories ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
    driver.quit(); }}
    
    //add comm function
    public void addCommDiagnosticCategories( String DiagnosticCategoriesCode, String DiagnosticCategoriesName, String DiagnosticCategoriesCommsubject, String DiagnosticCategoriesCommNoteType, String DiagnosticCategoriesCommMedium, String DiagnosticCategoriesCommDetails) throws Exception{
                    
                    try{        
                    	
                    int i= searchDiagnosticCategories( DiagnosticCategoriesCode, DiagnosticCategoriesName);
            		
            		if (i==1){
            			System.out.println("Diagnostic Categories  found, Continue with Add Communication");
            			Log.info("log4j msg- Diagnostic Categories  found, Continue with Add Communication");
            		
            		
                    System.out.println("Diagnostic Categories code"+DiagnosticCategoriesCode);
                    Log.info("log4j msg- Diagnostic Categories code"+DiagnosticCategoriesCode);
                                    //find DiagnosticCategories
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+DiagnosticCategoriesCode+"']")));
                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+DiagnosticCategoriesCode+"']")).click();
                    System.out.println("clicked Diagnostic Categories Code");
                    Log.info("log4j msg- clicked Diagnostic Categories code");
                    
                                                    //click comm
                                                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(DiagnosticCategoriesCommLink));
                    driver.findElement(DiagnosticCategoriesCommLink).click();
                    System.out.println("clicked Comm");
                    Log.info("log4j msg- clicked Comm");

                                                    
                                                    
                                                    //click add
                                                      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")));
                                                    driver.findElement(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")).click();
                                                    
                                                        System.out.println("clicked Add");
                                                    Log.info("log4j msg- clicked Add");
                                                    
                                                    //enter subject
                                                     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtSubject']")));
                                                    driver.findElement(By.xpath("//input[@id='txtSubject']")).sendKeys(DiagnosticCategoriesCommsubject);
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
                                                    placeOfService.selectByVisibleText(DiagnosticCategoriesCommNoteType);
                                                    System.out.println("selected note type");
                                                    Log.info("log4j msg-selected note type");
                                                    
                                                    Thread.sleep(1000);
                                                    //enter note details
                                                     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='txtNotes']")));
                                                    driver.findElement(By.xpath("//textarea[@id='txtNotes']")).sendKeys(DiagnosticCategoriesCommDetails);
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
                                                    
                                     catch (Exception e){e.printStackTrace();System.out.println("error in adding Comm to Diagnostic Categories");
                                                                                                                    Log.info("log4j msg - error in adding Comm to  Diagnostic Categories"); 
                     BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();    }   
                                     
                                     }
                    
    
    
    //delete function
    public void deleteDiagnosticCategories( String DiagnosticCategoriesCode, String DiagnosticCategoriesDescription) throws Exception{
                    
                    try{        
                    	              
                    int i= searchDiagnosticCategories(DiagnosticCategoriesCode, DiagnosticCategoriesDescription);
            		
            		if (i==1){
            			System.out.println("Diagnostic Categories found, continue with delete");
            			Log.info("log4j msg-Diagnostic Categories found, continue with delete");
            			
                    //find DiagnosticCategories
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+DiagnosticCategoriesCode+"']")));
                                                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+DiagnosticCategoriesCode+"']")).click();
                                                    System.out.println("clicked Diagnostic Categories Code");
                                                    Log.info("log4j msg- clicked Diagnostic Categories code");
                                    
                                                    //click delete
                                                    
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(DiagnosticCategoriesDeleteLink));
                                                    driver.findElement(DiagnosticCategoriesDeleteLink).click();
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
	System.out.println("cannot find Diagnostic Categories, cannot delete Diagnostic Categories ");
	Log.info("log4j msg- cannot find Diagnostic Categories, cannot delete Diagnostic Categories ");
	wait.until(ExpectedConditions.visibilityOfElementLocated(DiagnosticCategoriesExitLink));
	driver.findElement(DiagnosticCategoriesExitLink).click();
	System.out.println("clicked Exit");
	Log.info("log4j msg- clicked Exit");
	 Thread.sleep(1000);
	
	 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit(); 
	
}} catch (Exception e){System.out.println("error in deleting Diagnostic Categories ");
Log.info("log4j msg - error in deleting Diagnostic Categories "); 

}   
    }


}
  


  
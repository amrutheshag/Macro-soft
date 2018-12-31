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

public class JobStatusCategories{
            
	WebDriver driver;
	WebDriverWait wait;   
	
	By JobStatusCategoriesCodeBeginsInput = By.xpath("//input[@id='txtCode']");
	
	By JobStatusCategoriesNameDescriptionBeginsInput = By.xpath("//input[@id='txtName']");
	
	By JobStatusCategoriesSearchButton= By.xpath("//button[@data-ng-click='search(0)']");
    
    By JobStatusCategoriesAddLink= By.linkText("Add");
    
    By JobStatusCategoriesCodeInput = By.xpath("//input[@id='code']");
    
    By JobStatusCategoriesDescriptionInput= By.xpath("//input[@id='name']");
    
    By JobStatusCategoriesRecordMark= By.xpath("//input[@style='width:20px;']");
    
    By JobStatusCategoriesValidateLink =By.linkText("Validate");
    
    By JobStatusCategoriesValidateSaveOKButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By JobStatusCategoriesSaveLink =  By.linkText("Save");
    
    By JobStatusCategoriesEditLink = By.linkText("Edit");
    
    By JobStatusCategoriesCopyLink = By.linkText("Copy");
    
    By JobStatusCategoriesDeleteLink= By.linkText("Delete");
   
    By confirmDeleteButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By JobStatusCategoriesCommLink= By.linkText("Commun.");
    
    By JobStatusCategoriesExitLink=  By.linkText("Exit");
    
    
    
    public JobStatusCategories(WebDriver driver){
                    this.driver= driver;
                    this.wait = new WebDriverWait(driver, 35); 
    }
    
    
	public int searchJobStatusCategories( String JobStatusCategoriesCode, String JobStatusCategoriesName) throws Exception{
		
		try{
		//enter  Job Status Categories code
		wait.until(ExpectedConditions.visibilityOfElementLocated(JobStatusCategoriesCodeBeginsInput));
		driver.findElement(JobStatusCategoriesCodeBeginsInput).clear();
		driver.findElement(JobStatusCategoriesCodeBeginsInput).sendKeys(JobStatusCategoriesCode);
		System.out.println("entered Job Status Categories  code");
		Log.info("log4j msg- entered Job Status Categories code");
	
	
		//enter  Job Status Categories name
		wait.until(ExpectedConditions.visibilityOfElementLocated(JobStatusCategoriesNameDescriptionBeginsInput));
		driver.findElement(JobStatusCategoriesNameDescriptionBeginsInput).clear();
		driver.findElement(JobStatusCategoriesNameDescriptionBeginsInput).sendKeys(JobStatusCategoriesName);
		System.out.println("entered Job Status Categories name");
		Log.info("log4j msg- entered Job Status Categories name");
		
		//click search
		wait.until(ExpectedConditions.visibilityOfElementLocated(JobStatusCategoriesSearchButton));
		driver.findElement(JobStatusCategoriesSearchButton).click();
		System.out.println("clicked Search");
		Log.info("log4j msg- clicked Search");
				
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+JobStatusCategoriesCode+"']")));
		WebElement e = driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+JobStatusCategoriesCode+"']"));
		e.click();
		System.out.println("Found JobStatusCategories");
		Log.info("log4j msg- Found JobStatusCategories");
	
		return 1;
		}
		
	catch(Exception e){System.out.println("JobStatusCategories not found"); 
	Log.info("JobStatusCategories not found"); return 0;}
		
	}

    //add function
    public void addJobStatusCategories(String JobStatusCategoriesCode, String JobStatusCategoriesDescription)throws Exception{
    
                    try{
                    
                    int i= searchJobStatusCategories( JobStatusCategoriesCode, JobStatusCategoriesDescription);
            		
            		if (i==0){
            			System.out.println("Job Status Categories not found, Continue with Add");
            			Log.info("log4j msg- Job Status Categories not found, Continue with Add");
            		
            		
                    wait.until(ExpectedConditions.visibilityOfElementLocated(JobStatusCategoriesAddLink));
                    driver.findElement(JobStatusCategoriesAddLink).click();
                    System.out.println("clicked Add");
                    Log.info("log4j msg- clicked Add");
                    
                    
                    System.out.println("Job Status Categories code: "+JobStatusCategoriesCode);
                    //enter code
                    wait.until(ExpectedConditions.visibilityOfElementLocated(JobStatusCategoriesCodeInput));
                    driver.findElement(JobStatusCategoriesCodeInput).sendKeys(JobStatusCategoriesCode);
                    Thread.sleep(1000);
                    System.out.println("Entered code");
                    Log.info("log4j msg- Entered code");
                    
                    System.out.println("Job Status Categories description"+JobStatusCategoriesDescription);
                    //enter Description
                    wait.until(ExpectedConditions.visibilityOfElementLocated(JobStatusCategoriesDescriptionInput));
                    driver.findElement(JobStatusCategoriesDescriptionInput).sendKeys(JobStatusCategoriesDescription);
                    Thread.sleep(1000);
                    System.out.println("Entered description");
                    Log.info("log4j msg- Entered description");
    
                    
                    //click validate
    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(JobStatusCategoriesValidateLink));
                    driver.findElement(JobStatusCategoriesValidateLink).click();
                    System.out.println("clicked validate");
                    Log.info("log4j msg- clicked validate");
                    
                    //click ok
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(JobStatusCategoriesValidateSaveOKButton));
                    driver.findElement(JobStatusCategoriesValidateSaveOKButton).click();
                    System.out.println("clicked validate ok to save button");
                    Log.info("log4j msg- clicked validate ok to save button");
                    
            		
                    //click save
                    Thread.sleep(1000);
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(JobStatusCategoriesSaveLink));
                    driver.findElement(JobStatusCategoriesSaveLink).click();
                    System.out.println("clicked save ");
                    Log.info("log4j msg- clicked  save ");
                    Thread.sleep(1000);
                      BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                    
                    } else{
            			System.out.println("Job Status Categories is already present, cannot add JobStatusCategories");
            			wait.until(ExpectedConditions.visibilityOfElementLocated(JobStatusCategoriesExitLink));
            			driver.findElement(JobStatusCategoriesExitLink).click();
            			System.out.println("clicked Exit");
            			Log.info("log4j msg- clicked Exit");
            			
            			 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
            		}
    
                    }catch (Exception e){System.out.println("error in adding JobStatusCategories");
                    Log.info("error in adding JobStatusCategories");}
            		}
                    
    //copy function
    
    public void copyJobStatusCategories( String JobStatusCategoriesCode, String JobStatusCategoriesName, String newJobStatusCategoriesCode, String newJobStatusCategoriesDescription)throws Exception{
                    
                    try{
                    
                    int i= searchJobStatusCategories( JobStatusCategoriesCode, JobStatusCategoriesName);
            		
            		if (i==1){
            			System.out.println("Job Status Categories found, continue with copy");
            			Log.info("log4j msg-Job Status Categories found, continue with copy");
            		
                    
                    System.out.println("Job Status Categories code"+JobStatusCategoriesCode);
                    //<div class="form-control text-box-10-chactr ng-pristine ng-untouched ng-valid ng-isolate-scope ng-not-empty ng-valid-maxlength" title="ACSC-MCD">ACSC-MCD</div>
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+JobStatusCategoriesCode+"']")));
                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+JobStatusCategoriesCode+"']")).click();
                    System.out.println("clicked Job Status Categories Code");
                    Log.info("log4j msg- clicked Job Status Categories code");
                    
                    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(JobStatusCategoriesCopyLink));
                    driver.findElement(JobStatusCategoriesCopyLink).click();
                    System.out.println("clicked Copy");
                    Log.info("log4j msg- clicked Copy");
                    
                    System.out.println("Job Status Categories newcode"+newJobStatusCategoriesCode);
                    
                    //enter new code
                    wait.until(ExpectedConditions.visibilityOfElementLocated(JobStatusCategoriesCodeInput));
                    driver.findElement(JobStatusCategoriesCodeInput).clear();
                    driver.findElement(JobStatusCategoriesCodeInput).sendKeys(newJobStatusCategoriesCode);
                    System.out.println("Entered new code");
                    Log.info("log4j msg- Entered new code");
    
                    System.out.println("Job Status Categories new description"+newJobStatusCategoriesDescription);
    //enter new description
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(JobStatusCategoriesDescriptionInput));
                    driver.findElement(JobStatusCategoriesDescriptionInput).clear();
                    driver.findElement(JobStatusCategoriesDescriptionInput).sendKeys(newJobStatusCategoriesDescription);
                    System.out.println("Entered new description");
                    Log.info("log4j msg- Entered new description");
                    
                    
                    
                    
                    
                    //click save
                    wait.until(ExpectedConditions.visibilityOfElementLocated(JobStatusCategoriesSaveLink));
                    driver.findElement(JobStatusCategoriesSaveLink).click();

                    System.out.println("Clicked save");
                    Log.info("log4j msg- clicked save");
                    Thread.sleep(1000);
                      BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
            		
                    
            		
                    } else{
            			System.out.println("Job Status Categories is not present, cannot copy JobStatusCategories");
            			Log.info("Job Status Categories is not present, cannot copy JobStatusCategories");
            			wait.until(ExpectedConditions.visibilityOfElementLocated(JobStatusCategoriesExitLink));
            			driver.findElement(JobStatusCategoriesExitLink).click();
            			System.out.println("clicked Exit");
            			Log.info("log4j msg- clicked Exit");
            			
            			 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
            		}
    
                    }catch (Exception e){System.out.println("error in copying JobStatusCategories"); 
                    Log.info("error in copying JobStatusCategories");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}
            		}
            		
            		
    
    
    

    
    //edit function
public void editJobStatusCategories( String JobStatusCategoriesCode, String jobstatusCategoriesDescription, String recordMark)throws Exception{
                    
                    try{ 
                    
                    int i= searchJobStatusCategories(JobStatusCategoriesCode, jobstatusCategoriesDescription);
            		
            		if (i==1){
            			System.out.println("Job Status Categories  found, Continue with Edit");
            			Log.info("log4j msg- Job Status Categories  found, Continue with Edit");
            		
            		
                    System.out.println("Job Status Categories code"+JobStatusCategoriesCode);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+JobStatusCategoriesCode+"']")));
                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+JobStatusCategoriesCode+"']")).click();
                    System.out.println("clicked Job Status Categories ");
                    Log.info("log4j msg- clicked Job Status Categories ");
                    
                    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(JobStatusCategoriesEditLink));
                    driver.findElement(JobStatusCategoriesEditLink).click();
                    System.out.println("clicked Edit");
                    Log.info("log4j msg- clicked Edit");
                    
                    System.out.println("Job Status Categories Record Mark"+recordMark);
                                                   
    //enter new record mark
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(JobStatusCategoriesRecordMark));
                    System.out.println("current record mark: "+driver.findElement(JobStatusCategoriesRecordMark).getText());
                    driver.findElement(JobStatusCategoriesRecordMark).clear();
                    Thread.sleep(1000);
                    driver.findElement(JobStatusCategoriesRecordMark).sendKeys(recordMark);
                    System.out.println("Entered new record mark");
                    Log.info("log4j msg- Entered new record mark");
                    
                    
                    
                    
                    //click save
                    wait.until(ExpectedConditions.visibilityOfElementLocated(JobStatusCategoriesSaveLink));
                    driver.findElement(JobStatusCategoriesSaveLink).click();
                    System.out.println("Clicked save");
                    Log.info("log4j msg- clicked save");
                    Thread.sleep(1000);
                      BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
            		}
                    
            		else{System.out.println("Job status category not found ");
                    Log.info("log4j msg- job status category not found ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}
            		
            		}catch (Exception e){ e.printStackTrace();System.out.println("Error in Editing Job Status Categories ");
                    Log.info("log4j msg- Error in Editing Job Status Categories ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}
    
    
                    }
    //exit function
    public void exitJobStatusCategories( String JobStatusCategoriesCode) throws Exception{
    try{
                    System.out.println("Job Status Categories code"+JobStatusCategoriesCode);
                                    Thread.sleep(1000);
                                    driver.findElement(JobStatusCategoriesExitLink).click();
                                    Thread.sleep(1000);
                                    System.out.println("Clicked exit in  Job Status Categories ");
                                    Log.info("log4j msg- clicked exit in  Job Status Categories ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
              
    	}catch (Exception e){ e.printStackTrace();System.out.println("Error in Exit Job Status Categories ");
    Log.info("log4j msg- Error in Exit Job Status Categories ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}}
    
    //add comm function
    public void addCommJobStatusCategories( String JobStatusCategoriesCode, String JobStatusCategoriesName, String JobStatusCategoriesCommsubject, String JobStatusCategoriesCommNoteType, String JobStatusCategoriesCommMedium, String JobStatusCategoriesCommDetails) throws Exception{
                    
                    try{        
                    	
                    
                    int i= searchJobStatusCategories(JobStatusCategoriesCode, JobStatusCategoriesName);
            		
            		if (i==1){
            			System.out.println("Job Status Categories  found, Continue with Add Communication");
            			Log.info("log4j msg- Job Status Categories  found, Continue with Add Communication");
            		
            		
                    System.out.println("Job Status Categories code"+JobStatusCategoriesCode);
                                    //find JobStatusCategories
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+JobStatusCategoriesCode+"']")));
                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+JobStatusCategoriesCode+"']")).click();
                    System.out.println("clicked Job Status Categories Code");
                    Log.info("log4j msg- clicked Job Status Categories code");
                    
                                                    //click comm
                                                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(JobStatusCategoriesCommLink));
                    driver.findElement(JobStatusCategoriesCommLink).click();
                    System.out.println("clicked Comm");
                    Log.info("log4j msg- clicked Comm");

                                                    
                                                    
                                                    //click add
                                                    
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")));
                                                    driver.findElement(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")).click();
                                                     System.out.println("clicked Add");
                                                    Log.info("log4j msg- clicked Add");
                                                    
                                                    //enter subject
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtSubject']")));
                                                    driver.findElement(By.xpath("//input[@id='txtSubject']")).sendKeys(JobStatusCategoriesCommsubject);
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
                                                    placeOfService.selectByVisibleText(JobStatusCategoriesCommNoteType);
                                                    System.out.println("selected note type");
                                                    Log.info("log4j msg-selected note type");
                                                    
                                                    Thread.sleep(1000);
                                                    //enter note details
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='txtNotes']")));
                                                    driver.findElement(By.xpath("//textarea[@id='txtNotes']")).sendKeys(JobStatusCategoriesCommDetails);
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
            		
            		else{System.out.println("Job status category not found");
                    Log.info("log4j msg- Job status category not found");
                    
                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}
            		}
                                                    
                                     catch (Exception e){
                                    	 e.printStackTrace();
                                    	 System.out.println("error in adding Comm to JobStatusCategories");
                                         Log.info("log4j msg - error in adding Comm to  JobStatusCategories"); 
                     BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
                     driver.quit();   }   
                                     
                                     }
                    
    
    
    //delete function
    public void deleteJobStatusCategories( String JobStatusCategoriesCode, String JobStatusCategoriesDescription) throws Exception{
                    
                    try{        
                    	
                                    
                    int i= searchJobStatusCategories( JobStatusCategoriesCode, JobStatusCategoriesDescription);
            		
            		if (i==1){
            			System.out.println("Job Status Categories found, continue with delete");
            			Log.info("log4j msg-Job Status Categories found, continue with delete");
            			
                    //find JobStatusCategories
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+JobStatusCategoriesCode+"']")));
                                                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+JobStatusCategoriesCode+"']")).click();
                                                    System.out.println("clicked Job Status Categories Code");
                                                    Log.info("log4j msg- clicked Job Status Categories code");
                                    
                                                    //click delete
                                                    
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(JobStatusCategoriesDeleteLink));
                                                    driver.findElement(JobStatusCategoriesDeleteLink).click();
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
	System.out.println("cannot find Job Status Categories ");
	Log.info("log4j msg- cannot find Job Status Categories ");
	wait.until(ExpectedConditions.visibilityOfElementLocated(JobStatusCategoriesExitLink));
	driver.findElement(JobStatusCategoriesExitLink).click();
	System.out.println("clicked Exit");
	Log.info("log4j msg- clicked Exit");
	
	
	 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
	
}} catch (Exception e){System.out.println("error in deleting Job Status Categories ");
Log.info("log4j msg - error in deleting Job Status Categories "); 

}   
    }


}
  



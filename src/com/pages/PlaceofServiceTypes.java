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

public class PlaceofServiceTypes {

	WebDriver driver;
	WebDriverWait wait ; 
	
	By PlaceofServiceTypesCodeBeginsInput = By.xpath("//input[@id='txtCode']");
	
	By PlaceofServiceTypesNameDescriptionBeginsInput = By.xpath("//input[@id='txtName']");
	
	By PlaceofServiceTypesSearchButton= By.xpath("//button[@data-ng-click='search(0)']");
    
    By PlaceofServiceTypesAddLink= By.linkText("Add");
    
    By PlaceofServiceTypesCodeInput = By.xpath("//input[@id='code']");
    
    By PlaceofServiceTypesDescriptionInput= By.xpath("//input[@id='name']");
    
    By PlaceofServiceTypesRecordMark= By.xpath("//input[@style='width:20px;']");
    
    By PlaceofServiceTypesValidateLink =By.linkText("Validate");
    
    By PlaceofServiceTypesValidateSaveOKButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By PlaceofServiceTypesSaveLink =  By.linkText("Save");
    
    By PlaceofServiceTypesEditLink = By.linkText("Edit");
    
    By PlaceofServiceTypesCopyLink = By.linkText("Copy");
    
    By PlaceofServiceTypesDeleteLink= By.linkText("Delete");
    
    By confirmDeleteButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By PlaceofServiceTypesCommLink= By.linkText("Commun.");
    
    By PlaceofServiceTypesExitLink=  By.linkText("Exit");
    
    
    
    
    public PlaceofServiceTypes(WebDriver driver){
        this.driver= driver;
        this.wait= new WebDriverWait(driver, 35);   
}


public int searchPlaceofServiceTypes( String PlaceofServiceTypesCode, String PlaceofServiceTypesName) throws Exception{

try{
//enter  Place of Service Types code
wait.until(ExpectedConditions.visibilityOfElementLocated(PlaceofServiceTypesCodeBeginsInput));
driver.findElement(PlaceofServiceTypesCodeBeginsInput).clear();
driver.findElement(PlaceofServiceTypesCodeBeginsInput).sendKeys(PlaceofServiceTypesCode);
System.out.println("entered Place of Service Types  code");
Log.info("log4j msg- entered Place of Service Types code");


//enter  Place of Service Types name
wait.until(ExpectedConditions.visibilityOfElementLocated(PlaceofServiceTypesNameDescriptionBeginsInput));
driver.findElement(PlaceofServiceTypesNameDescriptionBeginsInput).clear();
driver.findElement(PlaceofServiceTypesNameDescriptionBeginsInput).sendKeys(PlaceofServiceTypesName);
System.out.println("entered Place of Service Types name");
Log.info("log4j msg- entered Place of Service Types name");

//click search
wait.until(ExpectedConditions.visibilityOfElementLocated(PlaceofServiceTypesSearchButton));
driver.findElement(PlaceofServiceTypesSearchButton).click();
System.out.println("clicked Search");
Log.info("log4j msg- clicked Search");
	
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+PlaceofServiceTypesCode+"']")));
WebElement e = driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+PlaceofServiceTypesCode+"']"));
e.click();
System.out.println("Found PlaceofServiceTypes");
Log.info("log4j msg- Found PlaceofServiceTypes");

return 1;
}

catch(Exception e){System.out.println("Place of Service Types not found"); Log.info("log4j msg- Place of Service Types not found");return 0;}

}

//add function
public void addPlaceofServiceTypes( String PlaceofServiceTypesCode, String PlaceofServiceTypesDescription)throws Exception{

        try{ 
        int i= searchPlaceofServiceTypes( PlaceofServiceTypesCode, PlaceofServiceTypesDescription);
		
		if (i==0){
			System.out.println("Place of Service Types not found, Continue with Add");
			Log.info("log4j msg- Place of Service Types not found, Continue with Add");
		
		
        wait.until(ExpectedConditions.visibilityOfElementLocated(PlaceofServiceTypesAddLink));
        driver.findElement(PlaceofServiceTypesAddLink).click();
        System.out.println("clicked Add");
        Log.info("log4j msg- clicked Add");
        
        
        System.out.println("Place of Service Types code: "+PlaceofServiceTypesCode);
        Log.info("log4j msg- Place of Service Types code: "+PlaceofServiceTypesCode);
        //enter code
        wait.until(ExpectedConditions.visibilityOfElementLocated(PlaceofServiceTypesCodeInput));
        driver.findElement(PlaceofServiceTypesCodeInput).sendKeys(PlaceofServiceTypesCode);
        Thread.sleep(1000);
        System.out.println("Entered code");
        Log.info("log4j msg- Entered code");
        
        System.out.println("Place of Service Types description"+PlaceofServiceTypesDescription);
        Log.info("log4j msg- Place of Service Types code: "+PlaceofServiceTypesDescription);
        //enter Description
        wait.until(ExpectedConditions.visibilityOfElementLocated(PlaceofServiceTypesDescriptionInput));
        driver.findElement(PlaceofServiceTypesDescriptionInput).sendKeys(PlaceofServiceTypesDescription);
        Thread.sleep(1000);
        System.out.println("Entered description");
        Log.info("log4j msg- Entered description");

        
        //click validate

        
        wait.until(ExpectedConditions.visibilityOfElementLocated(PlaceofServiceTypesValidateLink));
        driver.findElement(PlaceofServiceTypesValidateLink).click();
        System.out.println("clicked validate");
        Log.info("log4j msg- clicked validate");
        
        //click ok
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(PlaceofServiceTypesValidateSaveOKButton));
        driver.findElement(PlaceofServiceTypesValidateSaveOKButton).click();
        System.out.println("clicked validate ok to save button");
        Log.info("log4j msg- clicked validate ok to save button");
        
		
        //click save
        Thread.sleep(1000);
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(PlaceofServiceTypesSaveLink));
        driver.findElement(PlaceofServiceTypesSaveLink).click();
        System.out.println("clicked save ");
        Log.info("log4j msg- clicked  save ");
          BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
        
        } else{
			System.out.println("Place of Service Types is already present, cannot add Place of Service Types");
			Log.info("log4j msg- Place of Service Types is already present, cannot add Place of Service Types");
			wait.until(ExpectedConditions.visibilityOfElementLocated(PlaceofServiceTypesExitLink));
			driver.findElement(PlaceofServiceTypesExitLink).click();
			System.out.println("clicked Exit");
			Log.info("log4j msg- clicked Exit");
			
			 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
		}

        }catch (Exception e){System.out.println("error in adding Place of Service Types");Log.info("log4j msg- error in adding Place of Service Types"); }
		}
        
//copy function

public void copyPlaceofServiceTypes( String PlaceofServiceTypesCode, String PlaceofServiceTypesName, String newPlaceofServiceTypesCode, String newPlaceofServiceTypesDescription)throws Exception{
        
        try{ 
        int i= searchPlaceofServiceTypes( PlaceofServiceTypesCode, PlaceofServiceTypesName);
		
		if (i==1){
			System.out.println("Place of Service Types found, continue with copy");
			Log.info("log4j msg-Place of Service Types found, continue with copy");
		
        
        System.out.println("Place of Service Types code"+PlaceofServiceTypesCode);
        Log.info("log4j msg-Place of Service Types code"+PlaceofServiceTypesCode);
        //<div class="form-control text-box-10-chactr ng-pristine ng-untouched ng-valid ng-isolate-scope ng-not-empty ng-valid-maxlength" title="ACSC-MCD">ACSC-MCD</div>
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+PlaceofServiceTypesCode+"']")));
        driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+PlaceofServiceTypesCode+"']")).click();
        System.out.println("clicked Place of Service Types Code");
        Log.info("log4j msg- clicked Place of Service Types code");
        
        
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(PlaceofServiceTypesCopyLink));
        driver.findElement(PlaceofServiceTypesCopyLink).click();
        System.out.println("clicked Copy");
        Log.info("log4j msg- clicked Copy");
        
        System.out.println("Place of Service Types new code"+newPlaceofServiceTypesCode);
        Log.info("log4j msg- Place of Service Types new code"+newPlaceofServiceTypesCode);
        //enter new code
        wait.until(ExpectedConditions.visibilityOfElementLocated(PlaceofServiceTypesCodeInput));
        driver.findElement(PlaceofServiceTypesCodeInput).clear();
        driver.findElement(PlaceofServiceTypesCodeInput).sendKeys(newPlaceofServiceTypesCode);
        System.out.println("Entered new code");
        Log.info("log4j msg- Entered new code");

        System.out.println("Place of Service Types new description"+newPlaceofServiceTypesDescription);
        Log.info("log4j msg- Place of Service Types new description"+newPlaceofServiceTypesDescription);
//enter new description
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(PlaceofServiceTypesDescriptionInput));
        driver.findElement(PlaceofServiceTypesDescriptionInput).clear();
        driver.findElement(PlaceofServiceTypesDescriptionInput).sendKeys(newPlaceofServiceTypesDescription);
        System.out.println("Entered new description");
        Log.info("log4j msg- Entered new description");
        
        
        
        
        
        //click save
        wait.until(ExpectedConditions.visibilityOfElementLocated(PlaceofServiceTypesSaveLink));
        driver.findElement(PlaceofServiceTypesSaveLink).click();

        System.out.println("Clicked save");
        Log.info("log4j msg- clicked save");
          BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
		
        
		
        } else{
			System.out.println("Place of Service Types is not present, cannot copy Place of Service Types");
			Log.info("log4j msg- Place of Service Types is not present, cannot copy Place of Service Types");
			wait.until(ExpectedConditions.visibilityOfElementLocated(PlaceofServiceTypesExitLink));
			driver.findElement(PlaceofServiceTypesExitLink).click();
			System.out.println("clicked Exit");
			Log.info("log4j msg- clicked Exit");
			
			 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
		}

        }catch (Exception e){System.out.println("error in copying Place of Service Types");Log.info("log4j msg- error in copying Place of Service Types"); }
		}
		
		





//edit function
public void editPlaceofServiceTypes( String PlaceofServiceTypesCode, String placeofserviceTypesDescription, String recordMark)throws Exception{
        
        try{ 
        int i= searchPlaceofServiceTypes(PlaceofServiceTypesCode, placeofserviceTypesDescription);
		
		if (i==1){
			System.out.println("Place of Service Types  found, Continue with Edit");
			Log.info("log4j msg- Place of Service Types  found, Continue with Edit");
		
		
        System.out.println("Place of Service Types code"+PlaceofServiceTypesCode);
        Log.info("log4j msg- Place of Service Types code"+PlaceofServiceTypesCode);
        //<div class="form-control text-box-10-chactr ng-pristine ng-untouched ng-valid ng-isolate-scope ng-not-empty ng-valid-maxlength" title="ACSC-MCD">ACSC-MCD</div>
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+PlaceofServiceTypesCode+"']")));
        driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+PlaceofServiceTypesCode+"']")).click();
        System.out.println("clicked Place of Service Types Record Mark");
        Log.info("log4j msg- clicked Place of Service Types Record Mark");
        
        
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(PlaceofServiceTypesEditLink));
        driver.findElement(PlaceofServiceTypesEditLink).click();
        System.out.println("clicked Edit");
        Log.info("log4j msg- clicked Edit");
        
        System.out.println("Place of Service Types Record Mark"+recordMark);
        Log.info("log4j msg-Place of Service Types Record Mark"+recordMark);
                                       
//enter new description
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(PlaceofServiceTypesRecordMark));
        driver.findElement(PlaceofServiceTypesRecordMark).clear();
        Thread.sleep(1000);
        driver.findElement(PlaceofServiceTypesRecordMark).sendKeys(recordMark);
        System.out.println("Entered new description");
        Log.info("log4j msg- Entered new description");
        
        
        
        
        //click save
        wait.until(ExpectedConditions.visibilityOfElementLocated(PlaceofServiceTypesSaveLink));
        driver.findElement(PlaceofServiceTypesSaveLink).click();
        System.out.println("Clicked save");
        Log.info("log4j msg- clicked save");
          BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
		}
        
		else{System.out.println("Place of Service Types not found, cannot edit Place of Service Types");
        Log.info("log4j msg- Place of Service Types not found, cannot edit Place of Service Types");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}
		
		}catch (Exception e){ e.printStackTrace();System.out.println("Error in Editing Place of Service Types ");
        Log.info("log4j msg- Error in Editing Place of Service Types ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}


        }
//exit function
public void exitPlaceofServiceTypes( String PlaceofServiceTypesCode) throws Exception{
try{
        //int i = searchPlaceofServiceTypes(driver, PlaceofServiceTypesCode);
        System.out.println("Place of Service Types code"+PlaceofServiceTypesCode);
        Log.info("log4j msg- Place of Service Types code"+PlaceofServiceTypesCode);
        //if (i==1)
                        Thread.sleep(1000);
                        driver.findElement(PlaceofServiceTypesExitLink).click();
                        Thread.sleep(1000);
                        System.out.println("Clicked exit in  Place of Service Types ");
                        Log.info("log4j msg- clicked exit in  Place of Service Types ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
        //else
                        
                        //driver.findElement(BenefitClassExitLink).click();
                        
}catch (Exception e){ e.printStackTrace();System.out.println("Error in Exiting Place of Service Types ");
Log.info("log4j msg- Error in Exiting Place of Service Types ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}}

//add comm function
public void addCommPlaceofServiceTypes( String PlaceofServiceTypesCode, String PlaceofServiceTypesName, String PlaceofServiceTypesCommsubject, String PlaceofServiceTypesCommNoteType, String PlaceofServiceTypesCommMedium, String PlaceofServiceTypesCommDetails) throws Exception{
        
        try{ 
        int i= searchPlaceofServiceTypes( PlaceofServiceTypesCode, PlaceofServiceTypesName);
		
		if (i==1){
			System.out.println("Place of Service Types  found, Continue with Add Communication");
			Log.info("log4j msg- Place of Service Types  found, Continue with Add Communication");
		
		
        System.out.println("Place of Service Types code"+PlaceofServiceTypesCode);
        Log.info("log4j msg- Place of Service Types code"+PlaceofServiceTypesCode);
                        //find PlaceofServiceTypes
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+PlaceofServiceTypesCode+"']")));
        driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+PlaceofServiceTypesCode+"']")).click();
        System.out.println("clicked Place of Service Types Code");
        Log.info("log4j msg- clicked Place of Service Types code");
        
                                        //click comm
                                        
        wait.until(ExpectedConditions.visibilityOfElementLocated(PlaceofServiceTypesCommLink));
        driver.findElement(PlaceofServiceTypesCommLink).click();
        System.out.println("clicked Comm");
        Log.info("log4j msg- clicked Comm");

                                        
                                        
                                        //click add
                                        //<img src="../Content/images/icon-add-white.png" width="30" height="30">
                                        //id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]
                                        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]]")));
                                        //driver.findElement(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]]")).click();
                                        
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")));
                                        driver.findElement(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")).click();
                                        
                                        //id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]
                                        
                                        
                                        
                                        
                                        
                                        System.out.println("clicked Add");
                                        Log.info("log4j msg- clicked Add");
                                        
                                        //enter subject
                                        //<input type="text" id="txtSubject" tabindex="1" class="form-control ng-pristine ng-valid ng-empty ng-valid-maxlength ng-touched" maxlength="70" data-ng-model="currentRecord.subject" data-ng-disabled="isAuditing" style="width: 100%;">
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtSubject']")));
                                        driver.findElement(By.xpath("//input[@id='txtSubject']")).sendKeys(PlaceofServiceTypesCommsubject);
                                        System.out.println("entered subject");
                                        Log.info("log4j msg- entered subject");
                                        
                                        
                                        //page down
                                        //<textarea class="form-control ng-pristine ng-valid ng-empty ng-valid-maxlength ng-touched" tabindex="9" placeholder="" data-ng-model="currentRecord.notes" data-ng-disabled="isAuditing" maxlength="230" rows="5" style="width: 100%;"></textarea>
                                        
                                        //<input type="text" class="form-control text-uppercase calenderText form-control input-sm text-right ng-empty ng-dirty ng-invalid ng-valid-parse ng-valid-maxlength ng-touched" placeholder=" MM/dd/yyyy" maxlength="10" tabindex="8" id="txtFollowup" data-ng-model="currentRecord.followup" data-ng-disabled="isAuditing">
                                        
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtFollowup']")));
                                        driver.findElement(By.xpath("//input[@id='txtFollowup']")).sendKeys(Keys.PAGE_DOWN);
                                        System.out.println("clicked page down");
                                        Log.info("log4j msg- clicked page down");
                                        
                                        
                                        
                                        
                                        //click add details
                                        //<button type="button" class="btn btn-primary btn-bottom01" data-ng-click="addChildRecord()" style="">Add</button>
                                        
                                      //<button type="button" class="btn btn-primary btn-bottom01" data-ng-click="addChildRecord()">Add</button>
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-ng-click='addChildRecord()']")));
                                        driver.findElement(By.xpath("//button[@data-ng-click='addChildRecord()']")).click();
                                        System.out.println("clicked add details");
                                        Log.info("log4j msg- clicked add details");
                                        
                                        Thread.sleep(1000);
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlNoteType"))); 
                                        Select placeOfService = new Select(driver.findElement(By.xpath("//select[@id='ddlNoteType']")));
                                        placeOfService.selectByVisibleText(PlaceofServiceTypesCommNoteType);
                                        System.out.println("selected note type");
                                        Log.info("log4j msg-selected note type");
                                        
                                        Thread.sleep(1000);
                                        //enter note details
                                        //<textarea class="form-control ng-pristine ng-valid ng-empty ng-touched" id="txtNotes" placeholder="" rows="20" data-ng-model="currentJournalRecord.notes" data-ng-disabled="isAuditing" style="width: 100%;"></textarea>
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='txtNotes']")));
                                        driver.findElement(By.xpath("//textarea[@id='txtNotes']")).sendKeys(PlaceofServiceTypesCommDetails);
                                        System.out.println("entered notes details");
                                        Log.info("log4j msg- entered notes details");
                                        Thread.sleep(1000);
                                        
                                        
                                        //click hide
                                        //<button class="btn btn-secondary btn-bottom01 pull-right" type="button" data-dismiss="modal" aria-hidden="true" data-ng-click="closeMe()">Hide</button>
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-ng-click='closeMe()']")));
                                        driver.findElement(By.xpath("//button[@data-ng-click='closeMe()']")).click();
                                        System.out.println("clicked hide");
                                        Log.info("log4j msg- clicked hide");
                                        
                                        //click close case
                                        //<button type="button" class="btn btn-primary btn-bottom01" data-ng-click="closeCase()" data-ng-disabled="isAuditing">Close Case</button>
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
                                        
                         catch (Exception e){e.printStackTrace();System.out.println("error in adding Comm to Place of Service Types");
                                                                                                        Log.info("log4j msg - error in adding Comm to  Place of Service Types"); 
         BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();   }   
                         
                         }
        


//delete function
public void deletePlaceofServiceTypes( String PlaceofServiceTypesCode, String PlaceofServiceTypesDescription) throws Exception{
        
        try{            
        int i= searchPlaceofServiceTypes( PlaceofServiceTypesCode, PlaceofServiceTypesDescription);
		
		if (i==1){
			System.out.println("Place of Service Types found, continue with delete");
			Log.info("log4j msg-Place of Service Types found, continue with delete");
			
        //find PlaceofServiceTypes
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+PlaceofServiceTypesCode+"']")));
                                        driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+PlaceofServiceTypesCode+"']")).click();
                                        System.out.println("clicked Place of Service Types Code");
                                        Log.info("log4j msg- clicked Place of Service Types code");
                        
                                        //click delete
                                        
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(PlaceofServiceTypesDeleteLink));
                                        driver.findElement(PlaceofServiceTypesDeleteLink).click();
                                        System.out.println("clicked Delete");
                                        Log.info("log4j msg- clicked Delete");
                                        
        
                                        //click confirm delete
                                        
                                        
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmDeleteButton));
                                        driver.findElement(confirmDeleteButton).click();
                                        System.out.println("clicked confirm Delete");
                                        Log.info("log4j msg- clicked confirm Delete");
                                         BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                                        
                                        
        




} else{
System.out.println("cannot find Place of Service Types, cannot delete Place of Service Types ");
Log.info("log4j msg- cannot find Place of Service Types, cannot delete Place of Service Types ");
wait.until(ExpectedConditions.visibilityOfElementLocated(PlaceofServiceTypesExitLink));
driver.findElement(PlaceofServiceTypesExitLink).click();
System.out.println("clicked Exit");
Log.info("log4j msg- clicked Exit");


BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();

}} catch (Exception e){System.out.println("error in deleting Place of Service Types ");
Log.info("log4j msg - error in deleting Place of Service Types "); 

}   
}

}




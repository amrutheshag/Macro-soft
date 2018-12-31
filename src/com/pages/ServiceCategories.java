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

public class ServiceCategories {

	WebDriver driver;
	WebDriverWait wait;  
	
	By ServiceCategoriesCodeBeginsInput = By.xpath("//input[@id='txtCode']");
	
	By ServiceCategoriesNameDescriptionBeginsInput = By.xpath("//input[@id='txtName']");
	
	By ServiceCategoriesSearchButton= By.xpath("//button[@data-ng-click='search(0)']");
    
    By ServiceCategoriesAddLink= By.linkText("Add");
    
    By ServiceCategoriesCodeInput = By.xpath("//input[@id='code']");
    
    By ServiceCategoriesDescriptionInput= By.xpath("//input[@id='name']");
    
    By ServiceCategoriesRecordMark= By.xpath("//input[@style='width:20px;']");
    
    By ServiceCategoriesValidateLink =By.linkText("Validate");
    
    By ServiceCategoriesValidateSaveOKButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By ServiceCategoriesSaveLink =  By.linkText("Save");
    
    By ServiceCategoriesEditLink = By.linkText("Edit");
    
    By ServiceCategoriesCopyLink = By.linkText("Copy");
    
    By ServiceCategoriesDeleteLink= By.linkText("Delete");
    
    By confirmDeleteButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By ServiceCategoriesCommLink= By.linkText("Commun.");

    By ServiceCategoriesExitLink=  By.linkText("Exit");
    
    
    
    
    public ServiceCategories(WebDriver driver){
        this.driver= driver;
        this.wait = new WebDriverWait(driver, 50);  
}


public int searchServiceCategories( String ServiceCategoriesCode, String ServiceCategoriesName) throws Exception{

try{
//enter  Service Categories code
wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceCategoriesCodeBeginsInput));
driver.findElement(ServiceCategoriesCodeBeginsInput).clear();
driver.findElement(ServiceCategoriesCodeBeginsInput).sendKeys(ServiceCategoriesCode);
System.out.println("entered Service Categories  code");
Log.info("log4j msg- entered Service Categories code");


//enter  Service Categories name
wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceCategoriesNameDescriptionBeginsInput));
driver.findElement(ServiceCategoriesNameDescriptionBeginsInput).clear();
driver.findElement(ServiceCategoriesNameDescriptionBeginsInput).sendKeys(ServiceCategoriesName);
System.out.println("entered Service Categories name");
Log.info("log4j msg- entered Service Categories name");

//click search
wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceCategoriesSearchButton));
driver.findElement(ServiceCategoriesSearchButton).click();
System.out.println("clicked Search");
Log.info("log4j msg- clicked Search");

wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ServiceCategoriesCode+"']")));
WebElement e = driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ServiceCategoriesCode+"']"));
e.click();
System.out.println("Found ServiceCategories");
Log.info("log4j msg- Found ServiceCategories");

return 1;
}

catch(Exception e){System.out.println("Service Categories not found"); Log.info("log4j msg- Service Categories not found");return 0;}

}

//add function
public void addServiceCategories( String ServiceCategoriesCode, String ServiceCategoriesDescription)throws Exception{

        try{ 
        int i= searchServiceCategories( ServiceCategoriesCode, ServiceCategoriesDescription);
		
		if (i==0){
			System.out.println("Service Categories not found, Continue with Add");
			Log.info("log4j msg- Service Categories not found, Continue with Add");
		
		
        wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceCategoriesAddLink));
        driver.findElement(ServiceCategoriesAddLink).click();
        System.out.println("clicked Add");
        Log.info("log4j msg- clicked Add");
        
        
        System.out.println("Service Categories code: "+ServiceCategoriesCode);
        Log.info("log4j msg- Service Categories code: "+ServiceCategoriesCode);
        //enter code
        wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceCategoriesCodeInput));
        driver.findElement(ServiceCategoriesCodeInput).sendKeys(ServiceCategoriesCode);
        Thread.sleep(1000);
        System.out.println("Entered code");
        Log.info("log4j msg- Entered code");
        
        System.out.println("Service Categories description"+ServiceCategoriesDescription);
        Log.info("log4j msg- Service Categories code: "+ServiceCategoriesDescription);
        //enter Description
        wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceCategoriesDescriptionInput));
        driver.findElement(ServiceCategoriesDescriptionInput).sendKeys(ServiceCategoriesDescription);
        Thread.sleep(1000);
        System.out.println("Entered description");
        Log.info("log4j msg- Entered description");

        
        //click validate

        
        wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceCategoriesValidateLink));
        driver.findElement(ServiceCategoriesValidateLink).click();
        System.out.println("clicked validate");
        Log.info("log4j msg- clicked validate");
        
        //click ok
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceCategoriesValidateSaveOKButton));
        driver.findElement(ServiceCategoriesValidateSaveOKButton).click();
        System.out.println("clicked validate ok to save button");
        Log.info("log4j msg- clicked validate ok to save button");
        
		
        //click save
        Thread.sleep(1000);
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceCategoriesSaveLink));
        driver.findElement(ServiceCategoriesSaveLink).click();
        System.out.println("clicked save ");
        Log.info("log4j msg- clicked  save ");
          BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
        
        } else{
			System.out.println("Service Categories is already present, cannot add Service Categories");
			Log.info("log4j msg- Service Categories is already present, cannot add Service Categories");
			wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceCategoriesExitLink));
			driver.findElement(ServiceCategoriesExitLink).click();
			System.out.println("clicked Exit");
			Log.info("log4j msg- clicked Exit");
			
			 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
		}

        }catch (Exception e){System.out.println("Error in adding Service Categories");Log.info("log4j msg- Error in adding Service Categories"); }
		}
        
//copy function

public void copyServiceCategories( String ServiceCategoriesCode, String ServiceCategoriesName, String newServiceCategoriesCode, String newServiceCategoriesDescription)throws Exception{
        
        try{  
        int i= searchServiceCategories( ServiceCategoriesCode, ServiceCategoriesName);
		
		if (i==1){
			System.out.println("Service Categories found, continue with copy");
			Log.info("log4j msg-Service Categories found, continue with copy");
		
        
        System.out.println("Service Categories code"+ServiceCategoriesCode);
        Log.info("log4j msg-Service Categories code"+ServiceCategoriesCode);

 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ServiceCategoriesCode+"']")));
        driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ServiceCategoriesCode+"']")).click();
        System.out.println("clicked Service Categories Code");
        Log.info("log4j msg- clicked Service Categories code");
        
        
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceCategoriesCopyLink));
        driver.findElement(ServiceCategoriesCopyLink).click();
        System.out.println("clicked Copy");
        Log.info("log4j msg- clicked Copy");
        
        System.out.println("Service Categories new code"+newServiceCategoriesCode);
        Log.info("log4j msg- Service Categories new code"+newServiceCategoriesCode);
        //enter new code
        wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceCategoriesCodeInput));
        driver.findElement(ServiceCategoriesCodeInput).clear();
        driver.findElement(ServiceCategoriesCodeInput).sendKeys(newServiceCategoriesCode);
        System.out.println("Entered new code");
        Log.info("log4j msg- Entered new code");

        System.out.println("Service Categories new description"+newServiceCategoriesDescription);
        Log.info("log4j msg- Service Categories new description"+newServiceCategoriesDescription);
//enter new description
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceCategoriesDescriptionInput));
        driver.findElement(ServiceCategoriesDescriptionInput).clear();
        driver.findElement(ServiceCategoriesDescriptionInput).sendKeys(newServiceCategoriesDescription);
        System.out.println("Entered new description");
        Log.info("log4j msg- Entered new description");
        
        
        
        
        
        //click save
        wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceCategoriesSaveLink));
        driver.findElement(ServiceCategoriesSaveLink).click();

        System.out.println("Clicked save");
        Log.info("log4j msg- clicked save");
          BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
		
        
		
        } else{
			System.out.println("Service Categories is not present, cannot copy Service Categories");
			Log.info("log4j msg- Service Categories is not present, cannot copy Service Categories");
			wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceCategoriesExitLink));
			driver.findElement(ServiceCategoriesExitLink).click();
			System.out.println("clicked Exit");
			Log.info("log4j msg- clicked Exit");
			
			 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
		}

        }catch (Exception e){System.out.println("Error in copying Service Categories");Log.info("log4j msg- Error in copying Service Categories"); }
		}
		
		





//edit function
public void editServiceCategories( String ServiceCategoriesCode, String serviceCategoriesDescription, String recordMark)throws Exception{
        
        try{ 
        int i= searchServiceCategories( ServiceCategoriesCode, serviceCategoriesDescription);
		
		if (i==1){
			System.out.println("Service Categories  found, Continue with Edit");
			Log.info("log4j msg- Service Categories  found, Continue with Edit");
		
		
        System.out.println("Service Categories code"+ServiceCategoriesCode);
        Log.info("log4j msg- Service Categories code"+ServiceCategoriesCode);

  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ServiceCategoriesCode+"']")));
        driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ServiceCategoriesCode+"']")).click();
        System.out.println("clicked Service Categories Record Mark");
        Log.info("log4j msg- clicked Service Categories Record Mark");
        
        
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceCategoriesEditLink));
        driver.findElement(ServiceCategoriesEditLink).click();
        System.out.println("clicked Edit");
        Log.info("log4j msg- clicked Edit");
        
        System.out.println("Service Categories Record Mark"+recordMark);
        Log.info("log4j msg-Service Categories Record Mark"+recordMark);
                                       
//enter new description
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceCategoriesRecordMark));
       driver.findElement(ServiceCategoriesRecordMark).clear();
        Thread.sleep(1000);
        driver.findElement(ServiceCategoriesRecordMark).sendKeys(recordMark);
        System.out.println("Entered new description");
        Log.info("log4j msg- Entered new description");
        
        
        
        
        //click save
        wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceCategoriesSaveLink));
        driver.findElement(ServiceCategoriesSaveLink).click();
        System.out.println("Clicked save");
        Log.info("log4j msg- clicked save");
          BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
		}
        
		else{System.out.println("Service Categories not found, cannot edit Service Categories");
        Log.info("log4j msg- Service Categories not found, cannot edit Service Categories");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}
		
		}catch (Exception e){ e.printStackTrace();System.out.println("Error in Editing Service Categories ");
        Log.info("log4j msg- Error in Editing Service Categories ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}


        }
//exit function
public void exitServiceCategories( String ServiceCategoriesCode) throws Exception{
try{

   System.out.println("Service Categories code"+ServiceCategoriesCode);
        Log.info("log4j msg- Service Categories code"+ServiceCategoriesCode);

                  Thread.sleep(1000);
                        driver.findElement(ServiceCategoriesExitLink).click();
                        Thread.sleep(1000);
                        System.out.println("Clicked exit in  Service Categories ");
                        Log.info("log4j msg- clicked exit in  Service Categories ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                          
}catch (Exception e){ e.printStackTrace();System.out.println("Error in Exiting Service Categories ");
Log.info("log4j msg- Error in Exiting Service Categories ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}}

//add comm function
public void addCommServiceCategories( String ServiceCategoriesCode, String ServiceCategoriesName, String ServiceCategoriesCommsubject, String ServiceCategoriesCommNoteType, String ServiceCategoriesCommMedium, String ServiceCategoriesCommDetails) throws Exception{
        
        try{
        int i= searchServiceCategories( ServiceCategoriesCode, ServiceCategoriesName);
		
		if (i==1){
			System.out.println("Service Categories  found, Continue with Add Communication");
			Log.info("log4j msg- Service Categories  found, Continue with Add Communication");
		
		
        System.out.println("Service Categories code"+ServiceCategoriesCode);
        Log.info("log4j msg- Service Categories code"+ServiceCategoriesCode);
                        //find ServiceCategories
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ServiceCategoriesCode+"']")));
        driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ServiceCategoriesCode+"']")).click();
        System.out.println("clicked Service Categories Code");
        Log.info("log4j msg- clicked Service Categories code");
        
                                        //click comm
                                        
        wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceCategoriesCommLink));
        driver.findElement(ServiceCategoriesCommLink).click();
        System.out.println("clicked Comm");
        Log.info("log4j msg- clicked Comm");

                                        
                                        
                                        //click add
                                         
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")));
                                        driver.findElement(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")).click();
                                        
                                       System.out.println("clicked Add");
                                        Log.info("log4j msg- clicked Add");
                                        
                                        //enter subject
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtSubject']")));
                                        driver.findElement(By.xpath("//input[@id='txtSubject']")).sendKeys(ServiceCategoriesCommsubject);
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
                                        Select serviceCategories = new Select(driver.findElement(By.xpath("//select[@id='ddlNoteType']")));
                                        serviceCategories.selectByVisibleText(ServiceCategoriesCommNoteType);
                                        System.out.println("selected note type");
                                        Log.info("log4j msg-selected note type");
                                        
                                        Thread.sleep(1000);
                                        //enter note details
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='txtNotes']")));
                                        driver.findElement(By.xpath("//textarea[@id='txtNotes']")).sendKeys(ServiceCategoriesCommDetails);
                                        System.out.println("entered notes details");
                                        Log.info("log4j msg- entered notes details");
                                        Thread.sleep(2000);
                                        
                                     
                                        //click hide
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-ng-click='closeMe()']")));
                                        driver.findElement(By.xpath("//button[@data-ng-click='closeMe()']")).click();
                                        System.out.println("clicked hide");
                                        Log.info("log4j msg- clicked hide");
                                       
                                        
                                        /*
                                        //click close case
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-ng-click='closeCase()']")));
                                        driver.findElement(By.xpath("//button[@data-ng-click='closeCase()']")).click();
                                        System.out.println("clicked close case");
                                        Log.info("log4j msg- clicked close case");
                                        */
                                        
                                        Thread.sleep(2000);
                                        //click save
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Save")));
                                        driver.findElement(By.linkText("Save")).click();
                                        System.out.println("clicked save");
                                        Log.info("log4j msg- clicked save");
                                        
                         BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}}
                                        
                         catch (Exception e){e.printStackTrace();System.out.println("Error in adding Comm to Service Categories");
                                                                                                        Log.info("log4j msg - Error in adding Comm to  Service Categories"); 
         BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();   }   
                         
                         }
        


//delete function
public void deleteServiceCategories( String ServiceCategoriesCode, String ServiceCategoriesDescription) throws Exception{
        
        try{           
        int i= searchServiceCategories( ServiceCategoriesCode, ServiceCategoriesDescription);
		
		if (i==1){
			System.out.println("Service Categories found, continue with delete");
			Log.info("log4j msg-Service Categories found, continue with delete");
			
        //find ServiceCategories
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ServiceCategoriesCode+"']")));
                                        driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ServiceCategoriesCode+"']")).click();
                                        System.out.println("clicked Service Categories Code");
                                        Log.info("log4j msg- clicked Service Categories code");
                        
                                        //click delete
                                        
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceCategoriesDeleteLink));
                                        driver.findElement(ServiceCategoriesDeleteLink).click();
                                        System.out.println("clicked Delete");
                                        Log.info("log4j msg- clicked Delete");
                                        
        
                                        //click confirm delete
                                        
                                        
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmDeleteButton));
                                        driver.findElement(confirmDeleteButton).click();
                                        System.out.println("clicked confirm Delete");
                                        Log.info("log4j msg- clicked confirm Delete");
                                         BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                                        
                                        
        




} else{
System.out.println("cannot find Service Categories, cannot delete Service Categories ");
Log.info("log4j msg- cannot find Service Categories, cannot delete Service Categories ");
wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceCategoriesExitLink));
driver.findElement(ServiceCategoriesExitLink).click();
System.out.println("clicked Exit");
Log.info("log4j msg- clicked Exit");


BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();

}} catch (Exception e){System.out.println("Error in deleting Service Categories ");
Log.info("log4j msg - Error in deleting Service Categories "); 

}   
}


}




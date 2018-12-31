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

public class NorthAmericanIndustrialClassifications{

	WebDriver driver;
	WebDriverWait wait ;
		
				By NorthAmericanIndustrialClassificationsCodeBeginsInput = By.xpath("//input[@id='txtCode']");
				
				By NorthAmericanIndustrialClassificationsNameDescriptionBeginsInput = By.xpath("//input[@id='txtName']");
		
				By NorthAmericanIndustrialClassificationsSearchButton= By.xpath("//button[@data-ng-click='search(0)']");
                
                By NorthAmericanIndustrialClassificationsAddLink= By.linkText("Add");
                
                By NorthAmericanIndustrialClassificationsCodeInput = By.xpath("//input[@id='code']");
                
                By NorthAmericanIndustrialClassificationsDescriptionInput= By.xpath("//input[@id='name']");
                
                By NorthAmericanIndustrialClassificationsRecordMark= By.xpath("//input[@style='width:20px;']");
                
                By NorthAmericanIndustrialClassificationsValidateLink =By.linkText("Validate");
                
                By NorthAmericanIndustrialClassificationsValidateSaveOKButton= By.xpath("//button[@data-bb-handler='Success']");
                
                By NorthAmericanIndustrialClassificationsSaveLink =  By.linkText("Save");
                
                By NorthAmericanIndustrialClassificationsEditLink = By.linkText("Edit");
                
                By NorthAmericanIndustrialClassificationsCopyLink = By.linkText("Copy");
                
                By NorthAmericanIndustrialClassificationsDeleteLink= By.linkText("Delete");
                
                By confirmDeleteButton= By.xpath("//button[@data-bb-handler='Success']");
                
                By NorthAmericanIndustrialClassificationsCommLink= By.linkText("Commun.");
                
                By NorthAmericanIndustrialClassificationsExitLink=  By.linkText("Exit");
                
                
                
                
                public NorthAmericanIndustrialClassifications(WebDriver driver){
                                this.driver= driver;
                                this.wait= new WebDriverWait(driver, 35);    
                }
                
                
            	public int searchNorthAmericanIndustrialClassifications( String NorthAmericanIndustrialClassificationsCode, String NorthAmericanIndustrialClassificationsName) throws Exception{
            		
            		try{
            		//enter  North American Industrial Classifications code
            		wait.until(ExpectedConditions.visibilityOfElementLocated(NorthAmericanIndustrialClassificationsCodeBeginsInput));
            		driver.findElement(NorthAmericanIndustrialClassificationsCodeBeginsInput).clear();
            		driver.findElement(NorthAmericanIndustrialClassificationsCodeBeginsInput).sendKeys(NorthAmericanIndustrialClassificationsCode);
            		System.out.println("entered North American Industrial Classifications  Representivescode");
            		Log.info("log4j msg- entered North American Industrial Classifications code");
            	
            	
            		//enter  North American Industrial Classifications name
            		wait.until(ExpectedConditions.visibilityOfElementLocated(NorthAmericanIndustrialClassificationsNameDescriptionBeginsInput));
            		driver.findElement(NorthAmericanIndustrialClassificationsNameDescriptionBeginsInput).clear();
            		driver.findElement(NorthAmericanIndustrialClassificationsNameDescriptionBeginsInput).sendKeys(NorthAmericanIndustrialClassificationsName);
            		System.out.println("entered North American Industrial Classifications name");
            		Log.info("log4j msg- entered North American Industrial Classifications name");
            		
            		//click search
            		wait.until(ExpectedConditions.visibilityOfElementLocated(NorthAmericanIndustrialClassificationsSearchButton));
            		driver.findElement(NorthAmericanIndustrialClassificationsSearchButton).click();
            		System.out.println("clicked Search");
            		Log.info("log4j msg- clicked Search");
            				
            		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+NorthAmericanIndustrialClassificationsCode+"']")));
            		WebElement e = driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+NorthAmericanIndustrialClassificationsCode+"']"));
            		e.click();
            		System.out.println("Found NorthAmericanIndustrialClassifications");
            		Log.info("log4j msg- Found NorthAmericanIndustrialClassifications");
            	
            		return 1;
            		}
            		
            	catch(Exception e){System.out.println("Cannot find  NorthAmericanIndustrialClassifications");
            	Log.info("Cannot find  NorthAmericanIndustrialClassifications");
            	return 0;}
            		
            	}

                //add function
                public void addNorthAmericanIndustrialClassifications( String NorthAmericanIndustrialClassificationsCode, String NorthAmericanIndustrialClassificationsDescription)throws Exception{
                
                                try{
                                int i= searchNorthAmericanIndustrialClassifications( NorthAmericanIndustrialClassificationsCode, NorthAmericanIndustrialClassificationsDescription);
                        		
                        		if (i==0){
                        			System.out.println("North American Industrial Classifications not found, Continue with Add");
                        			Log.info("log4j msg- North American Industrial Classifications not found, Continue with Add");
                        		
                        		
                                wait.until(ExpectedConditions.visibilityOfElementLocated(NorthAmericanIndustrialClassificationsAddLink));
                                driver.findElement(NorthAmericanIndustrialClassificationsAddLink).click();
                                System.out.println("clicked Add");
                                Log.info("log4j msg- clicked Add");
                                
                                
                                System.out.println("North American Industrial Classifications code: "+NorthAmericanIndustrialClassificationsCode);
                                //enter code
                                wait.until(ExpectedConditions.visibilityOfElementLocated(NorthAmericanIndustrialClassificationsCodeInput));
                                driver.findElement(NorthAmericanIndustrialClassificationsCodeInput).sendKeys(NorthAmericanIndustrialClassificationsCode);
                                Thread.sleep(1000);
                                System.out.println("Entered code");
                                Log.info("log4j msg- Entered code");
                                
                                System.out.println("North American Industrial Classifications description"+NorthAmericanIndustrialClassificationsDescription);
                                //enter Description
                                wait.until(ExpectedConditions.visibilityOfElementLocated(NorthAmericanIndustrialClassificationsDescriptionInput));
                                driver.findElement(NorthAmericanIndustrialClassificationsDescriptionInput).sendKeys(NorthAmericanIndustrialClassificationsDescription);
                                Thread.sleep(1000);
                                System.out.println("Entered description");
                                Log.info("log4j msg- Entered description");
                
                                
                                //click validate
                
                                
                                wait.until(ExpectedConditions.visibilityOfElementLocated(NorthAmericanIndustrialClassificationsValidateLink));
                                driver.findElement(NorthAmericanIndustrialClassificationsValidateLink).click();
                                System.out.println("clicked validate");
                                Log.info("log4j msg- clicked validate");
                                
                                //click ok
                                
                                wait.until(ExpectedConditions.visibilityOfElementLocated(NorthAmericanIndustrialClassificationsValidateSaveOKButton));
                                driver.findElement(NorthAmericanIndustrialClassificationsValidateSaveOKButton).click();
                                System.out.println("clicked validate ok to save button");
                                Log.info("log4j msg- clicked validate ok to save button");
                                
                        		
                                //click save
                                Thread.sleep(1000);
                                
                                wait.until(ExpectedConditions.visibilityOfElementLocated(NorthAmericanIndustrialClassificationsSaveLink));
                                driver.findElement(NorthAmericanIndustrialClassificationsSaveLink).click();
                                System.out.println("clicked save ");
                                Log.info("log4j msg- clicked  save ");
                                  BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                                
                                } else{
                        			System.out.println("North American Industrial Classifications is already present, cannot add NorthAmericanIndustrialClassifications");
                        			wait.until(ExpectedConditions.visibilityOfElementLocated(NorthAmericanIndustrialClassificationsExitLink));
                        			driver.findElement(NorthAmericanIndustrialClassificationsExitLink).click();
                        			System.out.println("clicked Exit");
                        			Log.info("log4j msg- clicked Exit");
                        			
                        			 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                        		}
                
                                }catch (Exception e){System.out.println("error in searching NorthAmericanIndustrialClassifications"); }
                        		}
                                
                //copy function
                
                public void copyNorthAmericanIndustrialClassifications( String NorthAmericanIndustrialClassificationsCode, String NorthAmericanIndustrialClassificationsName, String newNorthAmericanIndustrialClassificationsCode, String newNorthAmericanIndustrialClassificationsDescription)throws Exception{
                                
                                try{  
                                int i= searchNorthAmericanIndustrialClassifications( NorthAmericanIndustrialClassificationsCode, NorthAmericanIndustrialClassificationsName);
                        		
                        		if (i==1){
                        			System.out.println("North American Industrial Classifications found, continue with copy");
                        			Log.info("log4j msg-North American Industrial Classifications found, continue with copy");
                        		
                                
                                System.out.println("North American Industrial Classifications code"+NorthAmericanIndustrialClassificationsCode);
                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+NorthAmericanIndustrialClassificationsCode+"']")));
                                driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+NorthAmericanIndustrialClassificationsCode+"']")).click();
                                System.out.println("clicked North American Industrial Classifications Code");
                                Log.info("log4j msg- clicked North American Industrial Classifications code");
                                
                                
                                
                                wait.until(ExpectedConditions.visibilityOfElementLocated(NorthAmericanIndustrialClassificationsCopyLink));
                                driver.findElement(NorthAmericanIndustrialClassificationsCopyLink).click();
                                System.out.println("clicked Copy");
                                Log.info("log4j msg- clicked Copy");
                                
                                System.out.println("North American Industrial Classifications newcode"+newNorthAmericanIndustrialClassificationsCode);
                                
                                //enter new code
                                wait.until(ExpectedConditions.visibilityOfElementLocated(NorthAmericanIndustrialClassificationsCodeInput));
                                driver.findElement(NorthAmericanIndustrialClassificationsCodeInput).clear();
                                driver.findElement(NorthAmericanIndustrialClassificationsCodeInput).sendKeys(newNorthAmericanIndustrialClassificationsCode);
                                System.out.println("Entered new code");
                                Log.info("log4j msg- Entered new code");
                
                                System.out.println("North American Industrial Classifications new description"+newNorthAmericanIndustrialClassificationsDescription);
                //enter new description
                                
                                wait.until(ExpectedConditions.visibilityOfElementLocated(NorthAmericanIndustrialClassificationsDescriptionInput));
                                driver.findElement(NorthAmericanIndustrialClassificationsDescriptionInput).clear();
                                driver.findElement(NorthAmericanIndustrialClassificationsDescriptionInput).sendKeys(newNorthAmericanIndustrialClassificationsDescription);
                                System.out.println("Entered new description");
                                Log.info("log4j msg- Entered new description");
                                
                                
                                
                                
                                
                                //click save
                                wait.until(ExpectedConditions.visibilityOfElementLocated(NorthAmericanIndustrialClassificationsSaveLink));
                                driver.findElement(NorthAmericanIndustrialClassificationsSaveLink).click();

                                System.out.println("Clicked save");
                                Log.info("log4j msg- clicked save");
                                  BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                        		
                                
                        		
                                } else{
                        			System.out.println("North American Industrial Classifications is not found, cannot copy NorthAmericanIndustrialClassifications");
                        			wait.until(ExpectedConditions.visibilityOfElementLocated(NorthAmericanIndustrialClassificationsExitLink));
                        			driver.findElement(NorthAmericanIndustrialClassificationsExitLink).click();
                        			System.out.println("clicked Exit");
                        			Log.info("log4j msg- clicked Exit");
                        			
                        			 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                        		}
                
                                }catch (Exception e){System.out.println("error in searching NorthAmericanIndustrialClassifications"); }
                        		}
                        		
                        		
                
                
                

                
                //edit function
public void editNorthAmericanIndustrialClassifications( String NorthAmericanIndustrialClassificationsCode, String northamericanindustrialClassificationsDescription, String recordMark)throws Exception{
                                
                                try{ 
                                int i= searchNorthAmericanIndustrialClassifications( NorthAmericanIndustrialClassificationsCode, northamericanindustrialClassificationsDescription);
                        		
                        		if (i==1){
                        			System.out.println("North American Industrial Classifications  found, Continue with Edit");
                        			Log.info("log4j msg- North American Industrial Classifications  found, Continue with Edit");
                        		
                        		
                                System.out.println("North American Industrial Classifications code"+NorthAmericanIndustrialClassificationsCode);
                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+NorthAmericanIndustrialClassificationsCode+"']")));
                                driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+NorthAmericanIndustrialClassificationsCode+"']")).click();
                                System.out.println("clicked North American Industrial Classifications Record Mark");
                                Log.info("log4j msg- clicked North American Industrial Classifications Record Mark");
                                
                                
                                
                                wait.until(ExpectedConditions.visibilityOfElementLocated(NorthAmericanIndustrialClassificationsEditLink));
                                driver.findElement(NorthAmericanIndustrialClassificationsEditLink).click();
                                System.out.println("clicked Edit");
                                Log.info("log4j msg- clicked Edit");
                                
                                System.out.println("North American Industrial Classifications Record Mark"+recordMark);
                                                               
                //enter new description
                                
                                wait.until(ExpectedConditions.visibilityOfElementLocated(NorthAmericanIndustrialClassificationsRecordMark));
                                System.out.println("current record mark: "+driver.findElement(NorthAmericanIndustrialClassificationsRecordMark).getText());
                                driver.findElement(NorthAmericanIndustrialClassificationsRecordMark).clear();
                                Thread.sleep(1000);
                                driver.findElement(NorthAmericanIndustrialClassificationsRecordMark).sendKeys(recordMark);
                                System.out.println("Entered new record mark");
                                Log.info("log4j msg- Entered new record mark");
                                
                                
                                
                                
                                //click save
                                wait.until(ExpectedConditions.visibilityOfElementLocated(NorthAmericanIndustrialClassificationsSaveLink));
                                driver.findElement(NorthAmericanIndustrialClassificationsSaveLink).click();
                                System.out.println("Clicked save");
                                Log.info("log4j msg- clicked save");
                                  BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                        		}
                                
                        		else{System.out.println("North American Industrial Classification not found ");
                                Log.info("log4j msg- North American Industrial Classification not found ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}
                        		
                        		}catch (Exception e){ e.printStackTrace();System.out.println("Error in Editing North American Industrial Classifications ");
                                Log.info("log4j msg- Error in Editing North American Industrial Classifications ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}
                
                
                                }
                //exit function
                public void exitNorthAmericanIndustrialClassifications( String NorthAmericanIndustrialClassificationsCode) throws Exception{
                try{
                                System.out.println("North American Industrial Classifications code"+NorthAmericanIndustrialClassificationsCode);
                                                Thread.sleep(1000);
                                                driver.findElement(NorthAmericanIndustrialClassificationsExitLink).click();
                                                Thread.sleep(1000);
                                                System.out.println("Clicked exit in  North American Industrial Classifications ");
                                                Log.info("log4j msg- clicked exit in  North American Industrial Classifications ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                                               
                	}catch (Exception e){ e.printStackTrace();System.out.println("Error in Editing North American Industrial Classifications ");
                Log.info("log4j msg- Error in Editing North American Industrial Classifications ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}}
                
                //add comm function
                public void addCommNorthAmericanIndustrialClassifications( String NorthAmericanIndustrialClassificationsCode, String NorthAmericanIndustrialClassificationsName, String NorthAmericanIndustrialClassificationsCommsubject, String NorthAmericanIndustrialClassificationsCommNoteType, String NorthAmericanIndustrialClassificationsCommMedium, String NorthAmericanIndustrialClassificationsCommDetails) throws Exception{
                                
                                try{      
                                int i= searchNorthAmericanIndustrialClassifications( NorthAmericanIndustrialClassificationsCode, NorthAmericanIndustrialClassificationsName);
                        		
                        		if (i==1){
                        			System.out.println("North American Industrial Classifications  found, Continue with Add Communication");
                        			Log.info("log4j msg- North American Industrial Classifications  found, Continue with Add Communication");
                        		
                        		
                                System.out.println("North American Industrial Classifications code"+NorthAmericanIndustrialClassificationsCode);
                                                //find NorthAmericanIndustrialClassifications
                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+NorthAmericanIndustrialClassificationsCode+"']")));
                                driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+NorthAmericanIndustrialClassificationsCode+"']")).click();
                                System.out.println("clicked North American Industrial Classifications Code");
                                Log.info("log4j msg- clicked North American Industrial Classifications code");
                                
                                                                //click comm
                                                                
                                wait.until(ExpectedConditions.visibilityOfElementLocated(NorthAmericanIndustrialClassificationsCommLink));
                                driver.findElement(NorthAmericanIndustrialClassificationsCommLink).click();
                                System.out.println("clicked Comm");
                                Log.info("log4j msg- clicked Comm");

                                                                
                                Thread.sleep(1000);                  
                                                                //click add
                                                                 
                                                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")));
                                                                driver.findElement(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")).click();
                                                                
                                                                 
                                                                System.out.println("clicked Add");
                                                                Log.info("log4j msg- clicked Add");
                                                                Thread.sleep(1000);
                                                                
                                                                
                                                                //enter subject
                                                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtSubject']")));
                                                                driver.findElement(By.xpath("//input[@id='txtSubject']")).sendKeys(NorthAmericanIndustrialClassificationsCommsubject);
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
                                                                placeOfService.selectByVisibleText(NorthAmericanIndustrialClassificationsCommNoteType);
                                                                System.out.println("selected note type");
                                                                Log.info("log4j msg-selected note type");
                                                                
                                                                Thread.sleep(1000);
                                                                //enter note details
                                                               wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='txtNotes']")));
                                                                driver.findElement(By.xpath("//textarea[@id='txtNotes']")).sendKeys(NorthAmericanIndustrialClassificationsCommDetails);
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
                                                                Thread.sleep(2000);
                                                 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}}
                                                                
                                                 catch (Exception e){e.printStackTrace();System.out.println("error in adding Comm to NorthAmericanIndustrialClassifications");
                                                                                                                                Log.info("log4j msg - error in adding Comm to  NorthAmericanIndustrialClassifications"); 
                                 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();   }   
                                                 
                                                 }
                                
                
                
                //delete function
                public void deleteNorthAmericanIndustrialClassifications( String NorthAmericanIndustrialClassificationsCode, String NorthAmericanIndustrialClassificationsDescription) throws Exception{
                                
                                try{            
                                int i= searchNorthAmericanIndustrialClassifications( NorthAmericanIndustrialClassificationsCode, NorthAmericanIndustrialClassificationsDescription);
                        		
                        		if (i==1){
                        			System.out.println("North American Industrial Classifications found, continue with delete");
                        			Log.info("log4j msg-North American Industrial Classifications found, continue with delete");
                        			
                                //find NorthAmericanIndustrialClassifications
                                                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+NorthAmericanIndustrialClassificationsCode+"']")));
                                                                driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+NorthAmericanIndustrialClassificationsCode+"']")).click();
                                                                System.out.println("clicked North American Industrial Classifications Code");
                                                                Log.info("log4j msg- clicked North American Industrial Classifications code");
                                                
                                                                //click delete
                                                                
                                                                wait.until(ExpectedConditions.visibilityOfElementLocated(NorthAmericanIndustrialClassificationsDeleteLink));
                                                                driver.findElement(NorthAmericanIndustrialClassificationsDeleteLink).click();
                                                                System.out.println("clicked Delete");
                                                                Log.info("log4j msg- clicked Delete");
                                                                
                                
                                                                //click confirm delete
                                                                
                                                                
                                                                wait.until(ExpectedConditions.visibilityOfElementLocated(confirmDeleteButton));
                                                                driver.findElement(confirmDeleteButton).click();
                                                                System.out.println("clicked confirm Delete");
                                                                Log.info("log4j msg- clicked confirm Delete");
                                                                 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                                                                
                                                                
                                
         

                
                
            } else{
    			System.out.println("cannot find North American Industrial Classifications ");
    			Log.info("log4j msg- cannot find North American Industrial Classifications ");
    			wait.until(ExpectedConditions.visibilityOfElementLocated(NorthAmericanIndustrialClassificationsExitLink));
    			driver.findElement(NorthAmericanIndustrialClassificationsExitLink).click();
    			System.out.println("clicked Exit");
    			Log.info("log4j msg- clicked Exit");
    			
    			
    			 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
    			
            }} catch (Exception e){System.out.println("error in deleting North American Industrial Classifications ");
            Log.info("log4j msg - error in deleting North American Industrial Classifications "); 
            
            }   
                }

}
              



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

public class Carriers {

    			WebDriver driver;
    			WebDriverWait wait ;
				
				By CarriersCodeBeginsInput = By.xpath("//input[@data-ng-model='searchOptions.carrier']");
				
				By CarriersNameDescriptionBeginsInput = By.xpath("//input[@data-ng-model='searchOptions.name']");
				
				By CarriersSearchButton= By.xpath("//button[@data-ng-click='search()']");
  
				By CarriersAddLink= By.linkText("Add");
                
                By CarriersCodeInput = By.xpath("//input[@id='txtCode']");
 
                By CarriersDescriptionInput= By.xpath("//input[@id='txtName']");
                
                By CarriersPhone = By.xpath("//input[@id='txtPhone']");
                
                By CarriersValidateLink =By.linkText("Validate");
                
                By CarriersValidateSaveOKButton= By.xpath("//button[@data-bb-handler='Success']");
                
                By CarriersSaveLink =  By.linkText("Save");
                
                By CarriersEditLink = By.linkText("Edit");
                
                By CarriersCopyLink = By.linkText("Copy");
                
                By CarriersDeleteLink= By.linkText("Delete");
 
                By confirmDeleteButton= By.xpath("//button[@data-bb-handler='Success']");
                
                By CarriersCommLink= By.linkText("Commun.");
                
                By CarriersExitLink=  By.linkText("Exit");
                
                
                
                
                public Carriers(WebDriver driver){
                                this.driver= driver;
                                this.wait= new WebDriverWait(driver, 25);
                }
                
                
            	public int searchCarriers( String CarriersCode, String CarriersName) throws Exception{
            		
            		try{
            		//enter  Carriers code
            		wait.until(ExpectedConditions.visibilityOfElementLocated(CarriersCodeBeginsInput));
            		driver.findElement(CarriersCodeBeginsInput).clear();
            		driver.findElement(CarriersCodeBeginsInput).sendKeys(CarriersCode);
            		System.out.println("entered Carriers code");
            		Log.info("log4j msg- entered Carriers code");
            	
            	
            		//enter  Carriers name
            		wait.until(ExpectedConditions.visibilityOfElementLocated(CarriersNameDescriptionBeginsInput));
            		driver.findElement(CarriersNameDescriptionBeginsInput).clear();
            		driver.findElement(CarriersNameDescriptionBeginsInput).sendKeys(CarriersName);
            		System.out.println("entered Carriers name");
            		Log.info("log4j msg- entered Carriers name");
            		Thread.sleep(1000);
            		
            		//click search
            		wait.until(ExpectedConditions.visibilityOfElementLocated(CarriersSearchButton));
            		driver.findElement(CarriersSearchButton).click();
            		System.out.println("clicked Search");
            		Log.info("log4j msg- clicked Search");
            		Thread.sleep(1000);	
            		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+CarriersCode+"']")));
            		WebElement e = driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+CarriersCode+"']"));
            		e.click();
            		System.out.println("Found Carriers");
            		Log.info("log4j msg- Found Carriers");
            	
            		return 1;
            		}
            		
            	catch(Exception e){ 
            	System.out.println("Carriers not found");
            	Log.info("Carriers not found");
            	return 0;}
            		
            	}

                //add function
                public void addCarriers( String CarriersCode, String CarriersDescription)throws Exception{
                	
                                try{ 
                                
                                int i= searchCarriers( CarriersCode, CarriersDescription);
                        		
                        		if (i==0){
                        			System.out.println("Carriers not found, Continue with Add");
                        			Log.info("log4j msg- Carriers not found, Continue with Add");
                        		
                        		
                                wait.until(ExpectedConditions.visibilityOfElementLocated(CarriersAddLink));
                                driver.findElement(CarriersAddLink).click();
                                System.out.println("clicked Add");
                                Log.info("log4j msg- clicked Add");
                                
                                
                                System.out.println("Carrierscode: "+CarriersCode);
                                //enter code
                                wait.until(ExpectedConditions.visibilityOfElementLocated(CarriersCodeInput));
                                driver.findElement(CarriersCodeInput).sendKeys(CarriersCode);
                               
                                System.out.println("Entered code");
                                Log.info("log4j msg- Entered code");
                                
                                System.out.println("Carriers description"+CarriersDescription);
                                //enter Description
                                wait.until(ExpectedConditions.visibilityOfElementLocated(CarriersDescriptionInput));
                                driver.findElement(CarriersDescriptionInput).sendKeys(CarriersDescription);
                                
                                System.out.println("Entered description");
                                Log.info("log4j msg- Entered description");
                
                                
                                //click validate
                
                                
                                wait.until(ExpectedConditions.visibilityOfElementLocated(CarriersValidateLink));
                                driver.findElement(CarriersValidateLink).click();
                                System.out.println("clicked validate");
                                Log.info("log4j msg- clicked validate");
                                
                                //click ok
                                
                                wait.until(ExpectedConditions.visibilityOfElementLocated(CarriersValidateSaveOKButton));
                                driver.findElement(CarriersValidateSaveOKButton).click();
                                System.out.println("clicked validate ok to save button");
                                Log.info("log4j msg- clicked validate ok to save button");
                                
                        		
                                //click save
                               
                                
                                wait.until(ExpectedConditions.visibilityOfElementLocated(CarriersSaveLink));
                                driver.findElement(CarriersSaveLink).click();
                                System.out.println("clicked save ");
                                Log.info("log4j msg- clicked  save ");
                                Thread.sleep(2000);
                               BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
                                 driver.quit();
                        		
                        		} else{
                          			System.out.println("Carriers is already present, cannot add Carriers");
                          			wait.until(ExpectedConditions.visibilityOfElementLocated(CarriersExitLink));
                          			driver.findElement(CarriersExitLink).click();
                          			System.out.println("clicked Exit");
                          			Log.info("log4j msg- clicked Exit");
                          			BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
                          			driver.quit();
                          		}
                  
                                  }catch (Exception e){System.out.println("error in adding  Carriers"); Log.info("error in adding  Carriers");
                                 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
                                  driver.quit();
                                  }
                          		}
                                  
                  //copy function
                                
                        		
                
                public void copyCarriers( String CarriersCode, String CarriersName, String newCarriersCode, String newCarriersDescription)throws Exception{
                    
                    try{ 
                    
                    int i= searchCarriers(CarriersCode, CarriersName);
            		
            		if (i==1){
            			System.out.println("Carriers found, continue with copy");
            			Log.info("log4j msg-Carriers found, continue with copy");
            		
                    
                    System.out.println("Carriers code"+CarriersCode);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+CarriersCode+"']")));
                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+CarriersCode+"']")).click();
                    System.out.println("clicked Carriers Code");
                    Log.info("log4j msg- clicked Carriers code");
                    
                    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(CarriersCopyLink));
                    driver.findElement(CarriersCopyLink).click();
                    System.out.println("clicked Copy");
                    Log.info("log4j msg- clicked Copy");
                    
                    System.out.println("Carriers newcode"+newCarriersCode);
                    
                    //enter new code
                    wait.until(ExpectedConditions.visibilityOfElementLocated(CarriersCodeInput));
                    driver.findElement(CarriersCodeInput).clear();
                    driver.findElement(CarriersCodeInput).sendKeys(newCarriersCode);
                    System.out.println("Entered new code");
                    Log.info("log4j msg- Entered new code");
    
                    System.out.println("Carriers new description"+newCarriersDescription);
                    //enter new description
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(CarriersDescriptionInput));
                    driver.findElement(CarriersDescriptionInput).clear();
                    driver.findElement(CarriersDescriptionInput).sendKeys(newCarriersDescription);
                    System.out.println("Entered new description");
                    Log.info("log4j msg- Entered new description");
                    
                    
                    
                    
                    
                    //click save
                    wait.until(ExpectedConditions.visibilityOfElementLocated(CarriersSaveLink));
                    driver.findElement(CarriersSaveLink).click();

                    System.out.println("Clicked save");
                    Log.info("log4j msg- clicked save");
                    Thread.sleep(1000);
                     BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();
            		
                    
            		
                    } else{
            			System.out.println("Carriers not found, cannot copy Carriers");
            			wait.until(ExpectedConditions.visibilityOfElementLocated(CarriersExitLink));
            			driver.findElement(CarriersExitLink).click();
            			System.out.println("clicked Exit");
            			Log.info("log4j msg- clicked Exit");
            			
            			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();
            		}
    
                    }catch (Exception e){System.out.println("error in Copying Carriers"); Log.info("log4j msg-error in Copying Carriers"); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();   }
            		}
            		
            		
    
    
                
                

                
                //edit function
public void editCarriers(String CarriersCode,String CarriersDescription, String phoneNumber)throws Exception{
                                
                                try{ 
                                
                                int i= searchCarriers( CarriersCode, CarriersDescription);
                        		
                        		if (i==0){
                        			System.out.println("Carriers found, Continue with Edit");
                        			Log.info("log4j msg- Carriers found, Continue with Edit");
                        		}
                        		
                                System.out.println("Carriers code: "+CarriersCode);
                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+CarriersCode+"']")));
                                driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+CarriersCode+"']")).click();
                                System.out.println("clicked Carriers Code");
                                Log.info("log4j msg- clicked Carriers code");
                                
                                
                                
                                wait.until(ExpectedConditions.visibilityOfElementLocated(CarriersEditLink));
                                driver.findElement(CarriersEditLink).click();
                                System.out.println("clicked Edit");
                                Log.info("log4j msg- clicked Edit");
                                
                                System.out.println("Carriers Phone"+phoneNumber);
                                                               
                //enter new description
                                
                                wait.until(ExpectedConditions.visibilityOfElementLocated(CarriersPhone));
                                driver.findElement(CarriersPhone).clear();
                                Thread.sleep(1000);
                                driver.findElement(CarriersPhone).sendKeys(phoneNumber);
                                System.out.println("Entered  Phone");
                                Log.info("log4j msg- Entered  Phone");
                                
                                
                                
                                
                                
                                //click save
                                wait.until(ExpectedConditions.visibilityOfElementLocated(CarriersSaveLink));
                                driver.findElement(CarriersSaveLink).click();
                                System.out.println("Clicked save");
                                Log.info("log4j msg- clicked save");
                                Thread.sleep(1000);
                               BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
                                 driver.quit();
                        		
                                
                        		}catch (Exception e){ e.printStackTrace();System.out.println("Error in Editing Carriers ");
                                Log.info("log4j msg- Error in Editing Carriers ");  BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());driver.quit();}
                
                
                                }
                //exit function
                public void exitCarriers( String CarriersCode) throws Exception{
                try{
                                System.out.println("Carriers code"+CarriersCode);
                                                driver.findElement(CarriersExitLink).click();
                                               
                                                System.out.println("Clicked exit in  Carriers ");
                                                Log.info("log4j msg- clicked exit in  Carriers ");
                                                Thread.sleep(2000);
                                                BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();
                     	}catch (Exception e){ e.printStackTrace();System.out.println("Error in Exit- Carriers ");
                Log.info("log4j msg- Error in Exit- Carriers ");  BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();}}
                
                //add comm function
                public void addCommCarriers( String CarriersCode, String CarriersDescription, String CarriersCommsubject, String CarriersCommNoteType, String CarriersCommMedium, String CarriersCommDetails) throws Exception{
                                
                	  
                	 try{         
                     
                     int i= searchCarriers( CarriersCode, CarriersDescription);
             		
             		if (i==1){
             			System.out.println("Carriers  found, Continue with Add communication");
             			Log.info("log4j msg- Carriers  found, Continue with Add communication");
             		
             		
                     System.out.println("Carriers code"+CarriersCode);
                                     //find Carriers
                     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+CarriersCode+"']")));
                     driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+CarriersCode+"']")).click();
                     System.out.println("clicked Carriers Code");
                     Log.info("log4j msg- clicked Carriers code");
                     
                                                     //click comm
                                                     
                     wait.until(ExpectedConditions.visibilityOfElementLocated(CarriersCommLink));
                     driver.findElement(CarriersCommLink).click();
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
                                                     driver.findElement(By.xpath("//input[@id='txtSubject']")).sendKeys(CarriersCommsubject);
                                                     System.out.println("entered subject");
                                                     Log.info("log4j msg- entered subject");
                                                     
                                                     
                                                     //page down
                                                     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-ng-model='currentRecord.followup']")));
                                                     driver.findElement(By.xpath("//input[@data-ng-model='currentRecord.followup']")).sendKeys(Keys.PAGE_DOWN);
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
                                                     placeOfService.selectByVisibleText(CarriersCommNoteType);
                                                     System.out.println("selected note type");
                                                     Log.info("log4j msg-selected note type");
                                                     
                                                     Thread.sleep(1000);
                                                     //enter note details
                                                     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='txtNotes']")));
                                                     driver.findElement(By.xpath("//textarea[@id='txtNotes']")).sendKeys(CarriersCommDetails);
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
                                                     
                                     BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();}
             		
                     
             		else{
             			 System.out.println("Carrier  not found, cannot add comm");
                          Log.info("log4j msg- Carrier not found, cannot add comm");
                          
                         BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();}
             			}
                     
                                                     
               catch (Exception e){
            	   e.printStackTrace();
            	   System.out.println("error in adding Comm to Carriers");
                   Log.info("log4j msg - error in adding Comm to  Carriers"); 
                   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                   driver.quit();   
                   }   
                                      
               }
                     
     
                
                
                //delete function
                public void deleteCarriers( String CarriersCode, String CarriersName) throws Exception{
                                
                                try{         
                                                
                                int i= searchCarriers( CarriersCode, CarriersName);
                        		
                        		if (i==1){
                        			System.out.println("Carriers found, continue with delete");
                        			Log.info("log4j msg-Carriers found, continue with delete");
                        			
                                //find Carriers
                                                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+CarriersCode+"']")));
                                                                driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+CarriersCode+"']")).click();
                                                                System.out.println("clicked Carriers Code");
                                                                Log.info("log4j msg- clicked Carriers code");
                                                
                                                                //click delete
                                                                
                                                                wait.until(ExpectedConditions.visibilityOfElementLocated(CarriersDeleteLink));
                                                                driver.findElement(CarriersDeleteLink).click();
                                                                System.out.println("clicked Delete");
                                                                Log.info("log4j msg- clicked Delete");
                                                                
                                
                                                                //click confirm delete
                                                                
                                                                
                                                                wait.until(ExpectedConditions.visibilityOfElementLocated(confirmDeleteButton));
                                                                driver.findElement(confirmDeleteButton).click();
                                                                System.out.println("clicked confirm Delete");
                                                                Log.info("log4j msg- clicked confirm Delete");
                                                                BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();
                                                                
                
            } else{
    			System.out.println("cannot find Carriers");
    			Log.info("log4j msg- cannot find Carriers");
    			wait.until(ExpectedConditions.visibilityOfElementLocated(CarriersExitLink));
    			driver.findElement(CarriersExitLink).click();
    			System.out.println("clicked Exit");
    			Log.info("log4j msg- clicked Exit");
    			
    			BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
    			driver.quit();
    			
            }} catch (Exception e){System.out.println("error in deleting Carriers");
            Log.info("log4j msg - error in deleting Carriers"); 
            
}   
}            
}
                
                
                
                
                
                
                
              



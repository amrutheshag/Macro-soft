package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BrowserUtils;
import utility.Log;

public class TierCopaySchedule {

	WebDriver driver;
	WebDriverWait wait ;
	
	By TierCopayScheduleNameBeginsInput= By.xpath("//input[@data-ng-model='searchOptions.name']");
	
	By TierCopayScheduleSearchButton= By.xpath("//button[@data-ng-click='search()']");
	
	By TierCopayScheduleAddLink = By.linkText("Add");
	
	By TierCopayScheduleEditLink = By.linkText("Edit");
	
	By TierCopayScheduleCopyLink = By.linkText("Copy");
	
	By TierCopayScheduleDeleteLink = By.linkText("Delete");
	
	By confirmDeleteButton= By.xpath("//button[@data-bb-handler='Success']");
	
	By TierCopayScheduleAddCommLink = By.linkText("Commun.");
	
	By TierCopayScheduleAddNameInput = By.xpath("//input[@id='txtName']");
	
	By TierCopayScheduleAddDetailsButton= By.xpath("//button[@data-ng-click='addChildRecord()']");
	
	By TierCopayScheduleAllowanceLo = By.xpath("(//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='$0.00'])[1]");
	
	By TierCopayScheduleAllowanceHi= By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='$1,000,000.00']");
	
	By TierCopayScheduleCopay = By.xpath("(//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='$0.00'])[2]");
	
	By TierCopayScheduleNotes = By.xpath("//textarea[@id='txtNotes']");
	
	By TierCopayScheduleSaveLink = By.linkText("Save");
	
	By TierCopayScheduleExitLink = By.linkText("Exit");
	
	
	
	public TierCopaySchedule(WebDriver driver){
		this.driver= driver;
		this.wait = new WebDriverWait(driver, 35);    
	}
	
	//search function
	public int searchTierCopaySchedule( String tierCopayScheduleName) throws Exception{
	try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(TierCopayScheduleNameBeginsInput));
		driver.findElement(TierCopayScheduleNameBeginsInput).sendKeys(tierCopayScheduleName);
		System.out.println("Entered Tier Copay Schedule Name");
		Log.info("log4j msg- Entered Tier Copay Schedule Name");
		Thread.sleep(1000);
	
		//click search
				wait.until(ExpectedConditions.visibilityOfElementLocated(TierCopayScheduleSearchButton));
				driver.findElement(TierCopayScheduleSearchButton).click();
				System.out.println("clicked Search");
				Log.info("log4j msg- clicked Search");
		
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+tierCopayScheduleName+"']")));
		
				WebElement e = driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+tierCopayScheduleName+"']"));
				e.click();
				System.out.println("Found Tier Copay Schedule");
				Log.info("log4j msg- Found Tier Copay Schedule");
		return 1;
		}
		
		catch(Exception e){System.out.println("Cannot find Tier Copay Schedule"); Log.info("log4j msg- Cannot find Tier Copay Schedule"); return 0;}
		
		}
	
	
	
	
	
	
	//add function
	public void addTierCopaySchedule( String tierCopayScheduleName, String AllowanceLo, String AllowanceHi, String Copay, String Notes) throws Exception{
		try{	
			int i= searchTierCopaySchedule( tierCopayScheduleName);
			
			if (i==0){
				//click add
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(TierCopayScheduleAddLink));
				driver.findElement(TierCopayScheduleAddLink).click();
				System.out.println("clicked Add");
				Log.info("log4j msg- clicked Add");
				
				//enter name
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(TierCopayScheduleAddNameInput));
				driver.findElement(TierCopayScheduleAddNameInput).sendKeys(tierCopayScheduleName);
				System.out.println("Entered name");
				Log.info("log4j msg- Entered name");
				
				
				//click add details
				wait.until(ExpectedConditions.visibilityOfElementLocated(TierCopayScheduleAddDetailsButton));
				driver.findElement(TierCopayScheduleAddDetailsButton).click();
				System.out.println("clicked Add Copay Details");
				Log.info("log4j msg- clicked Add Copay Details");
				
				//doubleclick on AllowanceLo
				
				
				Actions action = new Actions(driver);
				WebElement allowanceLo=driver.findElement(TierCopayScheduleAllowanceLo);

				//Double click, enter Allowance Lo
				action.doubleClick(allowanceLo).sendKeys(AllowanceLo).perform();
				System.out.println("Entered Allowance Lo");
				Log.info("log4j msg- Entered Allowance Lo");
				
				//doubleclick AllowanceHi
				WebElement allowanceHi= driver.findElement(TierCopayScheduleAllowanceHi);
				action.doubleClick(allowanceHi).sendKeys(AllowanceHi).perform();
				System.out.println("Entered Allowance Hi");
				Log.info("log4j msg- Entered Allowance Hi");
				
				//doubleclick on copay
				
				WebElement copay= driver.findElement(TierCopayScheduleCopay);
						action.doubleClick(copay).sendKeys(Copay).perform();
						System.out.println("Entered copay");
						Log.info("log4j msg- Entered copay");
						
				//click save
						wait.until(ExpectedConditions.visibilityOfElementLocated(TierCopayScheduleSaveLink));
						driver.findElement(TierCopayScheduleSaveLink).click();
						System.out.println("clicked Save");
						Log.info("log4j msg- clicked Save");	
						Thread.sleep(1000);
						BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();	
				
			} 
			else{
				System.out.println("Tier Copay Schedule is already present");
				Log.info("log4j msg - Tier Copay Schedule is already present"); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
			}
		} catch (Exception e){
			e.printStackTrace();
		System.out.println("error in adding Tier Copay Schedule");
								Log.info("log4j msg - error in adding Tier Copay Schedule"); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
			}
			}
			
			
			
			
			
	//edit function
	
	public void editTierCopaySchedule( String tierCopayScheduleName, String newCopayValue) throws Exception{
		
			try{
				int i= searchTierCopaySchedule( tierCopayScheduleName);
				
				if (i==1){
					//click edit
					
					wait.until(ExpectedConditions.visibilityOfElementLocated(TierCopayScheduleEditLink));
					driver.findElement(TierCopayScheduleEditLink).click();
					System.out.println("clicked Edit");
					Log.info("log4j msg- clicked Edit");
					
					//doubleclick on copay
					Actions action = new Actions(driver);
					WebElement copay= driver.findElement(By.xpath("(//div[@class='ui-grid-cell-contents ng-binding ng-scope'])[4]"));
							action.doubleClick(copay).sendKeys(newCopayValue).perform();
							System.out.println("Entered new copay");
							Log.info("log4j msg- Entered new copay");
							
					//click save
							wait.until(ExpectedConditions.visibilityOfElementLocated(TierCopayScheduleSaveLink));
							driver.findElement(TierCopayScheduleSaveLink).click();
							System.out.println("clicked Save");
							Log.info("log4j msg- clicked Save");
							Thread.sleep(1000);
							BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
		} else{
			System.out.println("Tier Copay Schedule is not present");
			Log.info("log4j msg - Tier Copay Schedule is not present"); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
		}
	} catch (Exception e){e.printStackTrace();
	System.out.println("error in editing Tier Copay Schedule");
							Log.info("log4j msg - error in editing Tier Copay Schedule"); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
		}
		}
		
		
		
		
		
		
		
		//copy function
		
		
		public void copyTierCopaySchedule( String tierCopayScheduleName, String newCopayScheduleName) throws Exception{
			
				try{
					int i= searchTierCopaySchedule( tierCopayScheduleName);
					
					if (i==1){
						//click copy
						
						wait.until(ExpectedConditions.visibilityOfElementLocated(TierCopayScheduleCopyLink));
						driver.findElement(TierCopayScheduleCopyLink).click();
						System.out.println("clicked Copy");
						Log.info("log4j msg- clicked Copy");
						
						
						//enter name
						
						wait.until(ExpectedConditions.visibilityOfElementLocated(TierCopayScheduleAddNameInput));
						driver.findElement(TierCopayScheduleAddNameInput).clear();
						driver.findElement(TierCopayScheduleAddNameInput).sendKeys(newCopayScheduleName);
						System.out.println("Entered new name");
						Log.info("log4j msg- Entered new name");
						
						
						
						//click save
								wait.until(ExpectedConditions.visibilityOfElementLocated(TierCopayScheduleSaveLink));
								driver.findElement(TierCopayScheduleSaveLink).click();
								System.out.println("clicked Save");
								Log.info("log4j msg- clicked Save"); 
								Thread.sleep(1000);
								BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();	
			} else{
				System.out.println("Tier Copay Schedule is not present");
				Log.info("log4j msg - Tier Copay Schedule is not present"); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
			}
		} catch (Exception e){System.out.println("error in copying Tier Copay Schedule");
								Log.info("log4j msg - error in copying Tier Copay Schedule"); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
			}
	}
		
		//exit function
		
		public void exitTierCopaySchedule( String tierCopayScheduleName) throws Exception{
			
			try{
				int i= searchTierCopaySchedule( tierCopayScheduleName);
				
				if (i==1){
					//click exit
					
					wait.until(ExpectedConditions.visibilityOfElementLocated(TierCopayScheduleExitLink));
					driver.findElement(TierCopayScheduleExitLink).click();
					System.out.println("clicked Exit");
					Log.info("log4j msg- clicked Exit"); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
					
					
			} else{
				System.out.println("Tier Copay Schedule is not present");
				Log.info("log4j msg - Tier Copay Schedule is not present");
				
				//click exit
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(TierCopayScheduleExitLink));
				driver.findElement(TierCopayScheduleExitLink).click();
				System.out.println("clicked Exit");
				Log.info("log4j msg- clicked Exit");
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
			}
		} catch (Exception e){System.out.println("error in exiting Tier Copay Schedule");
								Log.info("log4j msg - error in exiting Tier Copay Schedule"); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
			}
	}
		
		
		
		
		//delete function
		public void deleteTierCopaySchedule( String tierCopayScheduleName) throws Exception{
			
			try{	
				int i= searchTierCopaySchedule( tierCopayScheduleName);
				
				if (i==1){
					//click delete
					
					wait.until(ExpectedConditions.visibilityOfElementLocated(TierCopayScheduleDeleteLink));
					driver.findElement(TierCopayScheduleDeleteLink).click();
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
				System.out.println("Tier Copay Schedule is not present");
				Log.info("log4j msg - Tier Copay Schedule is not present"); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
			}
		} catch (Exception e){System.out.println("error in deleting Tier Copay Schedule");
								Log.info("log4j msg - error in deleting Tier Copay Schedule"); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
			}
	}
		
		
		
		
	
	//addcomm function
public void addCommTierCopaySchedule( String tierCopayScheduleName, String subject, String NoteType, String medium, String notes) throws Exception{
			
			try{ 	
				int i= searchTierCopaySchedule( tierCopayScheduleName);
				
				if (i==1){
					//click comm
					
					wait.until(ExpectedConditions.visibilityOfElementLocated(TierCopayScheduleAddCommLink));
					driver.findElement(TierCopayScheduleAddCommLink).click();
					System.out.println("clicked Comm");
					Log.info("log4j msg- clicked Comm");
					
					
					//click add
						
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")));
					driver.findElement(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")).click();
					
					System.out.println("clicked Add");
					Log.info("log4j msg- clicked Add");
					Thread.sleep(1000);
					//enter subject
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtSubject']")));
					driver.findElement(By.xpath("//input[@id='txtSubject']")).sendKeys(subject);
					System.out.println("entered subject");
					Log.info("log4j msg- entered subject");
					
					
					//page down
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtFollowup']")));
					driver.findElement(By.xpath("//input[@id='txtFollowup']")).sendKeys(Keys.PAGE_DOWN);
					System.out.println("clicked page down");
					Log.info("log4j msg- clicked page down");
					
					
					
					
					//click add details
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@data-ng-click='addChildRecord()'])[2]")));
					driver.findElement(By.xpath("(//button[@data-ng-click='addChildRecord()'])[2]")).click();
					System.out.println("clicked add details");
					Log.info("log4j msg- clicked add details");
					
					Thread.sleep(3000);
					//select note type
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlNoteType")));
					Select noteType = new Select(driver.findElement(By.id("ddlNoteType")));
					
					Thread.sleep(3000);
					noteType.selectByVisibleText(NoteType);
					System.out.println("selected note type");
					Log.info("log4j msg-selected note type");
					
					Thread.sleep(1000);
					//enter note details
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//textarea[@id='txtNotes'])[2]")));
					driver.findElement(By.xpath("(//textarea[@id='txtNotes'])[2]")).sendKeys(notes);
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
					BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
				driver.quit();
					
				} else{
					System.out.println("Tier Copay Schedule is not present");
					Log.info("log4j msg - Tier Copay Schedule is not present"); 
					BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
					driver.quit();
				}
			} catch (Exception e){e.printStackTrace();System.out.println("error in adding Comm to Tier Copay Schedule");
									
			Log.info("log4j msg - error in adding Comm to  Tier Copay Schedule"); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
			driver.quit();	
			}
		}
	
	
	
	
		
		
		
}

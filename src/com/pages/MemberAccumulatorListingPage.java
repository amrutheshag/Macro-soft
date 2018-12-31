package com.pages;

import java.util.List;

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



public class MemberAccumulatorListingPage {
	
	
	WebDriver driver;
	WebDriverWait wait ;  
	
	By memberName= By.xpath("//input[@id='txtSearchCode']");

	By memberCustomCode= By.xpath("//input[@data-ng-model='filterOptions.userfield1']");

	By memberDOB= By.xpath("//input[@data-ng-model='filterOptions.dob']");

	By searchButton= By.xpath("//button[@ng-click='search()']");
	
	By editLink= By.xpath("//a[@data-ng-click='editForm()']");
	
	By saveLink = By.linkText("Save"); 
	
	
	
	public MemberAccumulatorListingPage(WebDriver driver){
		this.driver= driver;
		this.wait= new WebDriverWait(driver, 35);  
	}
	
	public void   memberAccumulatorEdit( String mid, String mlname, String mfname, String mdob, String mssn, String deniedClaimNo, String deniedServiceFromDate, String deniedServiceToDate) throws Exception 
	{
		By deniedServiceToDateElement = By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+deniedServiceToDate+"']");
		
		By deniedServiceFromDateElement= By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+deniedServiceFromDate+"']");
		
		By Individual = By.xpath("//div[contains(@id, '000L')]");
		
		Actions action = new Actions(driver);
		
		try{
		
		//enter name
				wait.until(ExpectedConditions.visibilityOfElementLocated(memberName));
				driver.findElement(memberName).sendKeys(mlname);
				System.out.println("entered name");
				Log.info("log4j msg- entered name");

				//enter mid
				wait.until(ExpectedConditions.visibilityOfElementLocated(memberCustomCode));
				driver.findElement(memberCustomCode).sendKeys(mid);
				System.out.println("entered mid");
				Log.info("log4j msg- entered mid");

				Thread.sleep(2000);
				//enter dob		
				wait.until(ExpectedConditions.visibilityOfElementLocated(memberDOB));
				driver.findElement(memberDOB).sendKeys(mdob);
				System.out.println("entered dob");
				Log.info("log4j msg- entered dob");

				//click ok if dob is entered wrong and try entering dob again
				try{
					
					driver.findElement(By.xpath("//button[@class='btn btn-primary btn-bottom02' and text()='OK']")).click();
					System.out.println("clicked ok");
					Log.info("log4j msg- clicked ok");
					Thread.sleep(2000);
					driver.findElement(memberDOB).sendKeys(mdob);
					System.out.println("entered dob");
					Log.info("log4j msg- entered dob");
					
				}catch (Exception e){ System.out.println("dob is entered without issues");}
				
				Thread.sleep(2000);
				//click search
				wait.until(ExpectedConditions.visibilityOfElementLocated(searchButton));
				driver.findElement(searchButton).click();
				System.out.println("clicked search");
				Log.info("log4j msg- clicked search");

				try{
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(deniedServiceToDateElement));
				driver.findElement(deniedServiceToDateElement).click();
				System.out.println("Clicked on Denied Claim To Date Accumulator details");
				Log.info("log4j msg- Clicked on Denied Claim To Date Accumulator details");
				Thread.sleep(2000);
				}catch(Exception e){ 
					System.out.println("Accumulator data is not present with the given DOS, cannot edit"); 
					Log.info("log4j msg- Accumulator data is not present with the given DOS, cannot edit"); 

					BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
					driver.quit();
				}
		
		
		
		List<WebElement> deniedServiceRows= driver.findElements(deniedServiceFromDateElement);
		
		int l= deniedServiceRows.size();
		System.out.println("no. of denied service rows with the given from date:"+l);
		Log.info("log4j msg- no. of denied service rows with the given from date:"+l);
		int q;
		for (q=0; q<l; q++){
			deniedServiceRows.get(q).click();
				if (deniedServiceRows.get(q).findElements(deniedServiceToDateElement) !=null){
				List<WebElement> indi= deniedServiceRows.get(q).findElements(Individual);
				int m= indi.size();
				int r;
				for (r=0; r<m; r++){
				
					if(!(indi.get(r).getText().equals("0.00"))) {
						
					wait.until(ExpectedConditions.visibilityOfElementLocated(editLink));
					driver.findElement(editLink).click();
					System.out.println("clicked edit");
					Log.info("clicked edit");
					
					
					action.moveToElement(indi.get(r)).doubleClick().sendKeys("0").build().perform();					
					Thread.sleep(2000);			
					
					//click save
					wait.until(ExpectedConditions.visibilityOfElementLocated(saveLink));
					driver.findElement(saveLink).click();
					System.out.println("Clicked on Save");
					Log.info("log4j msg- clicked Save");	
					
					}
					else{ 
						
						System.out.println(""); Log.info("");
					
					}
				}			
			}
			}
		
		
		//23. Click MemberActivity
		//24. Click Claims, Examiner View
		//25. Click Claim ID begins field
		//26. Enter original claim number
		//27. Validate your claim---Please Confirm
		//This process will validate and update ALL listed records not marked "No Edit". Do you want to continue? yes/no
		//a. The total amount in your newly adjusted claim should change to reflect the modifications you made to the accumulator.

		
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit();
		
		} catch(Exception e){ e.printStackTrace(); System.out.println("error in editing accumulator");Log.info("error in editing accumulator");}
	}
	
	public void memberAccumulatorAddComm( String mid, String mlname, String mfname, String mdob, String mssn, String deniedClaimNo, String deniedServiceFromDate, String deniedServiceToDate, String subject, String type, String noteType, String medium, String details) throws Exception
	{
		
		//enter name
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtSearchCode']")));
			driver.findElement(By.xpath("//input[@id='txtSearchCode']")).sendKeys(mlname);
			System.out.println("entered name");
			Log.info("log4j msg- entered name");

			//enter mid
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-ng-model='filterOptions.userfield1']")));
			driver.findElement(By.xpath("//input[@data-ng-model='filterOptions.userfield1']")).sendKeys(mid);
			System.out.println("entered mid");
			Log.info("log4j msg- entered mid");

			Thread.sleep(2000);
			//enter dob
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-ng-model='filterOptions.dob']")));
			driver.findElement(By.xpath("//input[@data-ng-model='filterOptions.dob']")).sendKeys(mdob);
			System.out.println("entered dob");
			Log.info("log4j msg- entered dob");

			
			try{
				
				//if dob is entered incorrectly, try again
				
				driver.findElement(By.xpath("//button[@class='btn btn-primary btn-bottom02' and text()='OK']")).click();
				System.out.println("clicked ok");
				Log.info("log4j msg- clicked ok");
				
				
				driver.findElement(By.xpath("//input[@data-ng-model='filterOptions.dob']")).clear();
				driver.findElement(By.xpath("//input[@data-ng-model='filterOptions.dob']")).sendKeys(mdob);
				System.out.println("entered dob");
				Log.info("log4j msg- entered dob");
				
			} catch(Exception e){ System.out.println("no error in entering dob");}
			
			
			//click search
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@ng-click='search()']")));
			driver.findElement(By.xpath("//button[@ng-click='search()']")).click();
			System.out.println("clicked search");
			Log.info("log4j msg- clicked search");
		
		
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Commun.")));
			driver.findElement(By.linkText("Commun.")).click();
			System.out.println("Clicked on Commun.");
			Log.info("log4j msg- clicked Commun.");
		
			//5. In the next window that appears, click ‘Add’ in the top in the top row
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span")));
			driver.findElement(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span")).click();		
			System.out.println("clicked add");
			Log.info("log4j msg-clicked add");
			
			//6. Click the first text field under Tab 1-General
			//7. Type Accumulator Adjustment
			driver.findElement(By.xpath("//input[@id='txtSubject' and @data-ng-model='currentRecord.subject']")).sendKeys(subject);
			System.out.println("entered subject");
			Log.info("log4j msg-entered subject");
			
			
			
			//8. Click the Type field
			//9. In the Type field, select 2-Member
			Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlCaseType")));
			driver.findElement(By.id("ddlCaseType")).click();
			Select casetype=new Select(driver.findElement(By.id("ddlCaseType")));
			Thread.sleep(2000);
			
			System.out.println("Case type:"+ type);
			Log.info("Case type:"+ type);
			
			casetype.selectByVisibleText(type);
			Thread.sleep(2000);
			

			System.out.println("selected  case type");
			Log.info("log4j msg-selected  case type");
			driver.findElement(By.xpath("//textarea[@tabindex='9']")).sendKeys(Keys.PAGE_DOWN);
			
			//10. Click Add, bringing up the ‘Administrative Case Journal Entry’ box
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-ng-click='addChildRecord()']")));
			driver.findElement(By.xpath("//button[@data-ng-click='addChildRecord()']")).click();
			System.out.println("clicked add");
			Log.info("log4j msg-clicked add");
			
			
			//12. Click the ‘Note Type’ field (dropdown box)
		
			//13. Select 2- MAXADJ 
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlNoteType")));
			Select notetypes=new Select(driver.findElement(By.id("ddlNoteType")));
			System.out.println("Note Type:"+ noteType);
			Thread.sleep(2000);
			notetypes.selectByVisibleText(noteType);

			System.out.println("selected  note type");
			Log.info("log4j msg-selected  note type");
			
			
			
			
			
			//14. Click the Medium field
			
			//15. Select N (No) from the drop-down box
			
			/*
			Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlMedium")));
			Select mediums=new Select(driver.findElement(By.id("ddlMedium")));
			Thread.sleep(3000);
			System.out.println("Medium:"+ medium);
			Log.info("Medium:"+ medium);
			mediums.selectByVisibleText(medium);

			System.out.println("selected  medium");
			Log.info("log4j msg-selected  medium");
			
			*/
			
			//16. Click the blank field
			//17. Copy and paste the accumulator adjustment request you received into the blank field
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='txtNotes']")));
			driver.findElement(By.xpath("//textarea[@id='txtNotes']")).sendKeys(details);
			System.out.println("entered comm details");
			Log.info("entered comm details");
			
			
			//click Hide
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-ng-click='closeMe()']")));
			driver.findElement(By.xpath("//button[@data-ng-click='closeMe()']")).click();
			System.out.println("clicked on hide");
			Log.info("log4j msg-clicked on hide");
			
			
			//18. Click the Status field
			
			//19. Click Resolved from status field
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-ng-click='closeCase()']")));
			driver.findElement(By.xpath("//button[@data-ng-click='closeCase()']")).click();
			System.out.println("clicked on close case");
			Log.info("log4j msg-clicked on close case");
			Thread.sleep(2000);
			//20. Click Validate--All Edited Records are Valid.
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Validate")));
			driver.findElement(By.linkText("Validate")).click();
			System.out.println("clicked on validate");
			Log.info("log4j msg-clicked on validate");
			Thread.sleep(2000);
			//This Record (Set) May be Saved. click ok
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-bb-handler='Success']")));
			driver.findElement(By.xpath("//button[@data-bb-handler='Success']")).click();
			System.out.println("clicked on ok ");
			Log.info("log4j msg-clicked on ok");
			
			Thread.sleep(2000);
			//21. Click Save
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Save")));
			driver.findElement(By.linkText("Save")).click();
			System.out.println("clicked on Save");
			Log.info("log4j msg-clicked on Save");
			
			Thread.sleep(2000);
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
			driver.quit();
		
	}
	
	public void memberAccumulatorExit( String mid, String mlname, String mfname, String mdob, String mssn, String deniedClaimNo, String deniedServiceFromDate, String deniedServiceToDate) throws Exception
	{
			//enter name
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtSearchCode']")));
			driver.findElement(By.xpath("//input[@id='txtSearchCode']")).sendKeys(mlname);
			System.out.println("entered name");
			Log.info("log4j msg- entered name");

			//enter mid
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-ng-model='filterOptions.userfield1']")));
			driver.findElement(By.xpath("//input[@data-ng-model='filterOptions.userfield1']")).sendKeys(mid);
			System.out.println("entered mid");
			Log.info("log4j msg- entered mid");

			
			//enter dob
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-ng-model='filterOptions.dob']")));
			driver.findElement(By.xpath("//input[@data-ng-model='filterOptions.dob']")).sendKeys(mdob);
			System.out.println("entered dob");
			Log.info("log4j msg- entered dob");

			
			//click search
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@ng-click='search()']")));
			driver.findElement(By.xpath("//button[@ng-click='search()']")).click();
			System.out.println("clicked search");
			Log.info("log4j msg- clicked search");
		
			Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Commun.")));
			driver.findElement(By.linkText("Exit")).click();
			System.out.println("Clicked on Exit");
			Log.info("log4j msg- clicked Exit");
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
			driver.quit();
	}






}

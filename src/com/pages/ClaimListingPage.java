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

public class ClaimListingPage {

	WebDriver driver;
	WebDriverWait wait ;

	By customCodeBeginsInput = 	By.xpath("//input[@data-ng-model='filterOptions.userfield1']");

	By searchButton = 			By.xpath("id('memberactivitymodal')/div[@class='inner-window']/div[@class='col-sm-12 search-container member-search-new']/div[@class='col-sm-10 col-md-12 col-lg-12 no-padding']/div[@class='col-sm-12 col-md-12 col-lg-3 first-col no-right-padding']/div[@class='col-sm-12']/div[@class='col-sm-6 no-padding']/button[@class='btn btn-primary']");

	By nameInput =				By.xpath("//input[@id='txtSearchCode' and @data-ng-model='filterOptions.name']");

	By dobInput = 				By.xpath("//input[@data-ng-model='filterOptions.dob']");

	By ssnInput = 				By.xpath("//input[@data-ng-model='filterOptions.ssn']");
	
	By claimIDBegins = 			By.xpath("//input[@data-ng-model='paginationOptions.searchOptions.claimId']");
	
	By DispositionBegins =		By.xpath("//input[@data-ng-model='paginationOptions.searchOptions.diagnosisCode']");
	
	By ClaimSearchButton= 		By.xpath("//button[@data-ng-click='search()']");
	
	By ApprovedClaimIDLabel = 		By.xpath("//label[@class='control-label record-info pull-right ng-binding']");
	
	By ApprovedClaimMemberInfoLabel = By.xpath("//label[@class='control-label record-info ng-binding']");
	
	By ReceivedDate = By.xpath("//input[@data-ng-model='currentRecord.receiveddt']");
	
	
	public ClaimListingPage(WebDriver driver){
		this.driver= driver;
		this.wait= new WebDriverWait(driver, 50);
	}

	
	
	
	
	public int CEVSearchMember(String mid, String mlname, String mdob, String ssn)throws Exception{
		System.out.println("mlname:"+mlname+",mdob:"+mdob+",mid:"+mid+",ssn:"+ssn);
		try{	
			
			if (mid.isEmpty()){
				System.out.println("No more data to test"); 
			driver.quit(); 
			return 0;}
			else{
		
				
				// enter  name
				wait.until(ExpectedConditions.visibilityOfElementLocated(nameInput));
				driver.findElement(nameInput).sendKeys(mlname);
				System.out.println("entered lastname");
				Log.info("log4j msg- entered lastname");
							
				
				
				Thread.sleep(3000);
				//enter  dob
				wait.until(ExpectedConditions.visibilityOfElementLocated(dobInput));
				driver.findElement(dobInput).sendKeys(mdob);
				System.out.println("entered dob");
				Log.info("log4j msg- entered dob");
				Thread.sleep(1000);
		
				//enter  mid
				wait.until(ExpectedConditions.visibilityOfElementLocated(customCodeBeginsInput));
				driver.findElement(customCodeBeginsInput).sendKeys(mid);
				System.out.println("entered mid");
				Log.info("log4j msg- entered mid");
				Thread.sleep(1000);
			
		
	
				wait.until(ExpectedConditions.visibilityOfElementLocated(ssnInput));
				driver.findElement(ssnInput).sendKeys(ssn);
				System.out.println("entered ssn");
				Log.info("log4j msg- entered ssn");
				Thread.sleep(1000);
			
				wait.until(ExpectedConditions.visibilityOfElementLocated(searchButton));
				driver.findElement(searchButton).click();
				System.out.println("clicked on search");
				Log.info("log4j msg- clicked search");
				Thread.sleep(1000);
		
				//click on mid
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and contains(text(), '"+mid+"')]")));
				driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()= '"+mid+"']")).click();
				System.out.println("clicked on member");
				Log.info("log4j msg- Found member, clicked on member");
			
			
			
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and contains(text(), '"+mid+"')]")));
				driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()= '"+mid+"']")).click();
				System.out.println("clicked on member");
				Log.info("log4j msg- Found member, clicked on member");
				
				Thread.sleep(2000);
				//click return selection
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Return Selection")));
				driver.findElement(By.linkText("Return Selection")).click();
				System.out.println("clicked Return Selection");
				Log.info("log4j msg- clicked Return Selection");
				
				return 1;
			
			
			}
		}catch (Exception e){//e.printStackTrace();
			System.out.println("Timeout Exception occured, No Such Element Found in search, member Not found with the given Custom code, Last name and DOB");
		return 0;}

	}

	
	public void CEVsearchClaim( String claimNo) throws Exception{	
		Log.info("log4j msg- search claim");
		System.out.println("Claim Number:" +claimNo);
		try{
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtSearchCode")));
			driver.findElement(By.id("txtSearchCode")).sendKeys(claimNo);
			Log.info("log4j msg- enter claim no");
			driver.findElement(By.xpath("//button[@data-ng-click='search()' and text()='Search']")).click();
		
		
		
			System.out.println("Claim selected");	
			Log.info("log4j msg- claim selected");
		}
		
	catch(Exception e) {System.out.println("Given Claim is not present");	}

	}

	public void CEVadjudicateClaim( String claimNo) throws Exception{
		
		try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='"+claimNo+"']")));
		String oldDisposition= driver.findElement(By.xpath("//div[text()='"+claimNo+"']/../following-sibling::div/following-sibling::div/following-sibling::div/following-sibling::div/following-sibling::div/div")).getText();
		System.out.println("Claim NO:" +claimNo+ "\n old disposition :" +oldDisposition);
		
		
		if (oldDisposition.equalsIgnoreCase("PUnprocessed")|| oldDisposition.equalsIgnoreCase("PWebClaim") ) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Adjudicate")));
			driver.findElement(By.linkText("Adjudicate")).click();
			System.out.println("Clicked Adjudicate");
			Log.info("log4j msg- clicked adjudicate");
			Thread.sleep(2000);
		
			
			driver.findElement(By.xpath("//button[@class='btn btn-primary btn-bottom02' and text()='Yes']")).click();
			System.out.println("Clicked Yes to confirm Validation");
			Log.info("log4j msg- Clicked yes to confirm Validation");
			Thread.sleep(2000);
		
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary btn-bottom02' and text()='OK']")));
			driver.findElement(By.xpath("//button[@class='btn btn-primary btn-bottom02' and text()='OK']")).click();
			System.out.println("Clicked ok to confirm no. of records adjudicated");
			Log.info("log4j msg- Clicked ok to confirm no. of records adjudicated");
			
			String newDisposition = driver.findElement(By.xpath("//input[@id='txtManualDisposition']")).getText();
			
			System.out.println("new disposition: "+newDisposition);
			Log.info("new disposition: "+newDisposition);
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
			
			Thread.sleep(4000);
			driver.quit();
		}
		
		else{ 
			System.out.println("Claim is already adjudicated");
			Log.info("log4j msg- Claim is already adjudicated");
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
			driver.quit();
		}	
	
		}catch(Exception e){e.printStackTrace();
		System.out.println("error in adjudicate claim"); Log.info("error in adjudicate claim"); 
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit();}
		}
	
	
	public void CEVaddCommunication( String claimNo, String subject, String noteType, String details)throws Exception{
		
		try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Commun.")));
		driver.findElement(By.linkText("Commun.")).click();
		System.out.println("Clicked Communication");
		Log.info("log4j msg- clicked communication");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@tabindex='-1' and @class='modal fade  in']/div/div/div/div/div/div/div/following-sibling::div/ul/li/following-sibling::li/a")));
		driver.findElement(By.xpath("//div[@tabindex='-1' and @class='modal fade  in']/div/div/div/div/div/div/div/following-sibling::div/ul/li/following-sibling::li/a")).click();
		System.out.println("Clicked add");
		Log.info("log4j msg- clicked add");

		
		driver.findElement(By.xpath("//input[@id='txtSubject' and @data-ng-model='currentRecord.subject']")).sendKeys(subject);
		System.out.println("Entered subject");
		Log.info("log4j msg- entered subject");
		
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//textarea[@tabindex='9']")).sendKeys(Keys.PAGE_DOWN);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(.,'Add')]")));
		driver.findElement(By.xpath("//button[contains(.,'Add')]")).click();
		System.out.println("clicked add");
		Log.info("log4j msg- clicked add");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlNoteType")));
		Select notetypes=new Select(driver.findElement(By.id("ddlNoteType")));
		notetypes.selectByVisibleText(noteType);
		
		Thread.sleep(3000);
		System.out.println("selected notetype");
		Log.info("log4j msg- selected notetype");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='txtNotes']")));
		driver.findElement(By.xpath("//textarea[@id='txtNotes']")).sendKeys(details);
		
		Thread.sleep(2000);
		System.out.println("entered comm details");
		Log.info("log4j msg- entered communication details");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-ng-click='closeMe()']")));
		driver.findElement(By.xpath("//button[@data-ng-click='closeMe()']")).click();
		System.out.println("clicked on hide");
		Log.info("log4j msg- clicked hide");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-ng-click='closeCase()']")));
		driver.findElement(By.xpath("//button[@data-ng-click='closeCase()']")).click();

		System.out.println("clicked on close case");
		Log.info("log4j msg- clicked close case");
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Save")));
		driver.findElement(By.linkText("Save")).click();
		System.out.println("clicked on save");
		Log.info("log4j msg- clicked save");

		
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit();
	
		
	} catch(Exception e){
	System.out.println("error in add comm claim"); 
	Log.info("error in add comm claim");
	BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
	driver.quit();
	}
	}


	public String CEVcopyClaim( String claimNo, String newdos) throws Exception{
	
		try{
			Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Copy")));
		driver.findElement(By.linkText("Copy")).click();
		System.out.println("clicked copy");
		Log.info("log4j msg- clicked copy");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary btn-bottom02' and text()='OK']")));
		driver.findElement(By.xpath("//button[@class='btn btn-primary btn-bottom02' and text()='OK']")).click();
		System.out.println("clicked ok");
		Log.info("log4j msg- click ok");
		Thread.sleep(2000);
		WebElement claimStartDate = driver.findElement(By.xpath("//input[@id='txtClaimPeriodStart']"));
		claimStartDate.sendKeys(newdos);
		
		Thread.sleep(2000);
		
		claimStartDate.sendKeys(Keys.TAB);
		Log.info("log4j msg- enter new date of service, click tab");
		System.out.println("changed date of service");
		Log.info("log4j msg- changed date of service");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Save")));
		
		driver.findElement(By.linkText("Save")).click();
		System.out.println("clicked Save");
		Log.info("log4j msg- clicked save");
		try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-bb-handler='Success' and text()='OK']")));
		driver.findElement(By.xpath("//button[@data-bb-handler='Success' and text()='OK']")).click();
		System.out.println("clicked ok"); 
		Log.info("log4j msg- click ok");
		}catch(Exception e){System.out.println("");}
		
		String newClaimno= driver.findElement(By.xpath("//div[@class='col-sm-12 col-md-12 col-lg-8 tab-container claim-exam-right-cntr']/div")).getText();
		System.out.println("new Claim number="+newClaimno.substring(1,13)); 
		Thread.sleep(2000);
		
		
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();
	
		return newClaimno.substring(1,13);
		
		}catch(Exception e){e.printStackTrace(); System.out.println("error in copy claim"); Log.info("error in copy claim"); 
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit();
	
		return null;}
		
		
	}


	public void CEVdeleteClaimNumber( String mid, String claimNo) throws Exception{
	
	
	try{
		Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-ng-click='delete()']")));
	driver.findElement(By.xpath("//a[@data-ng-click='delete()']")).click();
	Log.info("log4j msg- clicked delete");	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-bb-handler='Success']")));
	driver.findElement(By.xpath("//button[@data-bb-handler='Success']")).click();
	System.out.println(" confirmed delete");
	Log.info("log4j msg- confirmed delete");
	
	System.out.println("Claim Deleted");
	Log.info("log4j msg- claim deleted");
	Thread.sleep(3000);
	BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
	driver.quit();

	
	}catch(Exception e){System.out.println("error in delete claim");Log.info("error in delete claim"); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
	driver.quit();}
	}


	public void CEVeditClaim(String mid, String claimNo) throws Exception{

		
		try{
			Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Edit")));
		driver.findElement(By.linkText("Edit")).click();
		System.out.println("Clicked on Edit");
		Log.info("log4j msg- clicked edit");
		Thread.sleep(2000);
		}catch(Exception e){System.out.println("error in clicking edit");Log.info("error in clicking edit");}
		
		try{

wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-ng-model='currentRecord.eobnote']")));
driver.findElement(By.xpath("//input[@data-ng-model='currentRecord.eobnote']")).sendKeys("Test Edit");
System.out.println("Edited Outgoing field");
Log.info("log4j msg- Edited outgoing field");
Thread.sleep(2000);
		}catch(Exception e1){System.out.println("Error in editing");Log.info("Error in editing");}
		
		Thread.sleep(3000);
		//step 9 - save claim
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Save")));
			driver.findElement(By.linkText("Save")).click();
			System.out.println("clicked save"); 
			Log.info("log4j msg- clicked save");
			
		}catch(Exception e){}
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-bb-handler='Success' and text()='OK']")));
			driver.findElement(By.xpath("//button[@data-bb-handler='Success' and text()='OK']")).click();
			System.out.println("clicked ok"); 
			Log.info("log4j msg- click ok");
			Thread.sleep(2000);
			}catch(Exception e){System.out.println("");}
			
			
			
	
			
			
			
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
			driver.quit();
			
			
		
			
			

		}
	
	public void CEVexitClaim( String mid, String claimNo) throws Exception
	{
	try{
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Exit')]")));
	driver.findElement(By.xpath("//span[contains(text(),'Exit')]")).click(); 
	System.out.println("Clicked exit");
	Log.info("log4j msg- clicked exit");
	Thread.sleep(2000);
	BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
	driver.quit();
	
	} catch(Exception e){
	System.out.println("error in exit claim"); 
	Log.info("error in exit claim");
	BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
	driver.quit();}
	} 

	
	
	public String CEVmoveClaim( String oldMID, String oldmlname, String oldmfname, String oldmdob, String oldmssn,String claimNo, String newMID, String newmlname, String newmfname, String newmdob, String newmssn) throws Exception{

	try{
		
		
		
		try{

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+claimNo+"']")));
			driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+claimNo+"']")).click();
			System.out.println("claim selected");
			Log.info("log4j msg- claim selected");
			} catch (Exception e){ System.out.println("The claim to be moved is not present");
			driver.quit(); return ("fail");}
			
		System.out.println("we will try to move the claim now");
		Log.info("log4j msg- Moving the claim now");
		
		//click on move
		driver.findElement(By.linkText("Move")).click();

		try
		{wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary btn-bottom02' and text()='Yes']")));
		driver.findElement(By.xpath("//button[@class='btn btn-primary btn-bottom02' and text()='Yes']")).click();
		System.out.println("Clicked Yes- to confirm the move, the claim will be deleted from the first member's history");
		Log.info("log4j msg- clicked yes to confirm move");
		}
		catch (Exception e){ System.out.println("Confirm Delete claim button took too long to get displayed"); return "fail";}
		
	
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='OK']")));
		
			driver.findElement(By.xpath("//span[text()='Cannot Continue']"));
			System.out.println("claim is marked no delete, cannot move");
			Log.info("claim is marked no delete");
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
			driver.findElement(By.xpath("//button[text()='OK']")).click();
			driver.quit();
			return "fail";
		}catch(Exception e){System.out.println("claim can be moved");Log.info("Claim can be moved");
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary btn-bottom02' and text()='OK']")));
		driver.findElement(By.xpath("//button[@class='btn btn-primary btn-bottom02' and text()='OK']")).click();
		System.out.println("Clicked OK- to go to the new claim form where new member needs to be selected");
		Log.info("log4j msg- click ok to go to the new claim form");
		
		try{
			
			int i = CEVSearchMember( newMID, newmlname, newmdob, newmssn);
		
		if (i==1) {
		
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary btn-bottom02' and text()='OK']")));
			driver.findElement(By.xpath("//button[@class='btn btn-primary btn-bottom02' and text()='OK']")).click();
			System.out.println("Clicked OK- You must Edit or Validate this Claim in order to process all records");

			Log.info("log4j msg- clicked ok- You must Edit or Validate this Claim in order to process all records");
			
			try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary btn-bottom02' and text()='OK']")));
			driver.findElement(By.xpath("//button[@class='btn btn-primary btn-bottom02' and text()='OK']")).click();
			System.out.println("Clicked OK- No Provider assignment to this Payer's Exclusive Network - Provider is Non-Network.");

			Log.info("log4j msg- Clicked OK- No Provider assignment to this Payer's Exclusive Network - Provider is Non-Network");
			
			Thread.sleep(3000);
			}catch(Exception e1){}
			try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Save")));
			driver.findElement(By.linkText("Save")).click();
			Log.info("log4j msg- clicked save");
			Thread.sleep(2000);
			}catch(Exception e2){e2.printStackTrace();}
			
			try{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary btn-bottom02' and text()='OK']")));
			
			driver.findElement(By.xpath("//button[@class='btn btn-primary btn-bottom02' and text()='OK']")).click();
			System.out.println("Clicked OK-Entire Claim Rebilling Status has been Pended due to a Service pending appropriate rebilling.");
			Log.info("log4j msg- Clicked OK-Entire Claim Rebilling Status has been Pended due to a Service pending appropriate rebilling.");
			Thread.sleep(2000);
			}catch(Exception e3){}
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();
		
			return "pass";
		
		}else {
			System.out.println("New Member not found");	
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit(); 
		return "fail";
		}
		} catch (Exception e1) {	
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
		System.out.println("New member cannot be selected"); 
		driver.quit(); 
		return "fail";}
		
	}
	}
	catch(Exception e2)	
	{
		System.out.println("There is a problem with move");  	
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
		driver.quit(); 
		return "fail"; 
	}
		
	
	}


	
	public String CEVaddClaim(String mid,String mlname, String mfname, String mdob, String mssn, String claimPeriod,String receivedDate,String taxID,String npi,String pname,String paddress,String pspecial,String pos,String icd,String diagnosisCode,String cptCode,String charges,String quantity, String modifier1, String modifier2, String modifier3) throws Exception
	{
		
		String newClaimNo="";
			try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Add']")));
		driver.findElement(By.xpath("//span[text()='Add']")).click();
		Log.info("log4j msg-click add");
	
	int i= CEVSearchMember( mid, mlname, mdob, mssn);
		
	if (i==1) {
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtClaimPeriodStart' and @placeholder='MM/dd/yyyy']")));
			Thread.sleep(3000);
		WebElement ClaimPeriod= driver.findElement(By.xpath("//input[@id='txtClaimPeriodStart' and @placeholder='MM/dd/yyyy']"));
		Thread.sleep(2000);
		ClaimPeriod.sendKeys(claimPeriod);
		Log.info("log4j msg-entered claim period start date");
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@tabindex='2']")));
		driver.findElement(By.xpath("//input[@tabindex='2']")).sendKeys(claimPeriod);
		Log.info("log4j msg-entered claim period end date");
		Thread.sleep(1000);
		} catch(Exception e){ System.out.println("error in entering claim Period"); }
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='?']")));
		driver.findElement(By.xpath("//button[text()='?']")).click();
		Log.info("log4j msg-clicked ?");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtSearchCode' and @data-ng-model='filterOptionsnew.NPI']")));
		WebElement ProviderNPI= driver.findElement(By.xpath("//input[@id='txtSearchCode' and @data-ng-model='filterOptionsnew.NPI']"));
		
		ProviderNPI.sendKeys(npi);
		Log.info("log4j msg-entered npi");
		WebElement SearchButton= driver.findElement(By.xpath("//div[@class='col-sm-12 no-padding pull-right']/button[@ng-click='getClaimProviderLookup()' and text()='Search']"));
		SearchButton.click();
		Log.info("log4j msg-clicked search");
		
		System.out.println("Getting Provider - Organization TIN combination data list now");
	 	Thread.sleep(2000);
		
	 	List <WebElement> dateBox1 = driver.findElements(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope']/ancestor::div[@class='ui-grid-cell ng-scope ui-grid-disable-selection ui-grid-coluiGrid-00ES']//following-sibling::div//div"));
	    for (WebElement webElement : dateBox1) {
	    System.out.println(webElement.getText());
	    }     
	    Thread.sleep(3000);
	    //click ok
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-secondary btn-bottom01 pull-right' and @ng-click='getProviderAddress()']")));
	   	WebElement ClickOk= driver.findElement(By.xpath("//button[@class='btn btn-secondary btn-bottom01 pull-right' and @ng-click='getProviderAddress()']"));
	   	ClickOk.click();
	   	System.out.println("selected provider");
	   	Log.info("log4j msg-selected provider");
	    	
	   	
	   	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='"+paddress+"']")));
    	driver.findElement(By.xpath("//div[text()='"+paddress+"']")).click();
    	System.out.println("clicked on address");
    	Log.info("log4j msg-clicked on address");
    	Thread.sleep(2000);
    	
	   	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@ng-click='providerLookupAddressokbuttonclick()']")));
	   	WebElement ClickOk2= driver.findElement(By.xpath("//button[@ng-click='providerLookupAddressokbuttonclick()']"));
		ClickOk2.click();
		System.out.println("selected address");
		Log.info("log4j msg-selected address");
		
		try{wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-bb-handler='Success']")));
		WebElement ClickOk3= driver.findElement(By.xpath("//button[@data-bb-handler='Success']"));
		ClickOk3.click();
		System.out.println("Just clicked  ok");
		Log.info("log4j msg-clicked  ok");
		
		
		
		}catch(Exception e){System.out.println("");}
		
			try{
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-bb-handler='Success']")));
			WebElement ClickOk4= driver.findElement(By.xpath("//button[@data-bb-handler='Success']"));
			ClickOk4.click();
			System.out.println("Just clicked  ok");
			Log.info("log4j msg-clicked ok");
			
			
			
			
			}catch(Exception e){System.out.println("");}
		
				Thread.sleep(2000);
				WebElement e=driver.findElement(By.xpath("//input[@tabindex='16']"));
				System.out.println(e.getText());
		
			e.clear();
			e.sendKeys(taxID);
			System.out.println("entered taxid");
			Log.info("log4j msg-entered tax id");
		
			Select placeOfService = new Select(driver.findElement(By.xpath("//select[@tabindex='18']")));
			placeOfService.selectByVisibleText(pos);
			Log.info("log4j msg-entered place of service");
			Thread.sleep(3000);	
			driver.findElement(By.xpath("//input[@data-ng-model='currentRecord.ordered_dt' and @data-ng-disabled='isAuditing']")).sendKeys(Keys.PAGE_DOWN);
			System.out.println ("scrolldown");
			Log.info("log4j msg-scrolled down");
			Thread.sleep(2000);
			Select icdcode = new Select(driver.findElement(By.xpath("//select[@tabindex='21']")));		
			icdcode.selectByIndex(2);
			System.out.println("ICD Code 10 selected");
			Log.info("log4j msg-ICD code 10 selected");
			WebElement enterdiagnosiscode = driver.findElement(By.xpath("//input[@id='txtIcd1']"));
		
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtIcd1']")));
			Thread.sleep(2000);
			enterdiagnosiscode.clear();
			enterdiagnosiscode.sendKeys(diagnosisCode);
			System.out.println("Entered Diagnosis code");
			Log.info("log4j msg-entered diagnosis code");
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-ng-click='gridServices.add()']")));
			driver.findElement(By.xpath("//button[@data-ng-click='gridServices.add()']")).click();	
			System.out.println("Clicked Add");
			Log.info("log4j msg-clicked add");
			Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtService']")));
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='txtService']")).sendKeys(cptCode);
		System.out.println("entered cpt code");
		Log.info("log4j msg-entered cpt code");
		Thread.sleep(2000);
		//enter modifier 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='modifiers']")));
		driver.findElement(By.xpath("//input[@id='modifiers']")).sendKeys(modifier1);
		System.out.println("entered modifier1");
		Log.info("log4j msg-entered modifier1");
		
		Thread.sleep(2000);
		//enter modifier 2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='modifiers2']")));
		driver.findElement(By.xpath("//input[@id='modifiers2']")).sendKeys(modifier2);
		System.out.println("entered modifier2");
		Log.info("log4j msg-entered modifier2");
		Thread.sleep(2000);
		//enter modifier 3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='modifiers3']")));
		driver.findElement(By.xpath("//input[@id='modifiers3']")).sendKeys(modifier3);
		System.out.println("entered modifier3");
		Log.info("log4j msg-entered modifier3");
		
		driver.findElement(By.xpath("//input[@data-ng-model='gridServices.selectedRecord.billed']")).sendKeys(charges);
		System.out.println("entered charges");
		Log.info("log4j msg-entered charges");
		driver.findElement(By.xpath("//input[@data-ng-model='gridServices.selectedRecord.billedunit']")).sendKeys(quantity);
		System.out.println("Entered quantity");
		Log.info("log4j msg-entered quantity");
		
		
		WebElement element1=driver.findElement(By.xpath("//input[@data-ng-model='gridServices.selectedRecord.recvdcheck']"));
		Actions builder = new Actions(driver); 
		element1.click();
		builder.dragAndDropBy(element1, 0,-300).build().perform();
		System.out.println("moved to another position");
		Log.info("log4j msg-clicked and pulled the window up to be able to see the Hide button");
		Thread.sleep(2000);
		
		WebElement element3= driver.findElement(By.xpath("//button[@class='btn btn-secondary btn-bottom01 pull-right' and @data-dismiss='modal'and @aria-hidden='true' and contains(text(),'Hide')]"));
		builder.moveToElement(element3).click().build().perform();
		Thread.sleep(3000);
		System.out.println("clicked on hide");
		Log.info("log4j msg-clicked hide");
		Thread.sleep(2000);
		System.out.println("Clicked pageup");
		Log.info("log4j msg-clicke pageup");
		
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Save")));
		driver.findElement(By.linkText("Save")).click();
		System.out.println("Clicked save"); 
		Log.info("log4j msg-clicked save");
		
			try {wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='OK']")));
			driver.findElement(By.xpath("//button[text()='OK']")).click();
			System.out.println("For your information alert-clicked ok ");
			Log.info("log4j msg-clicked ok to the for your info alert");
			} catch (Exception e1) {System.out.println("click ok alert didnot popup");}
						//class="control-label record-info pull-right ng-binding"

			newClaimNo= driver.findElement(By.xpath("//div[@class='col-sm-12 col-md-12 col-lg-8 tab-container claim-exam-right-cntr']/div")).getText();
			System.out.println("New Claim no:" +newClaimNo.substring(1,13));
			
			Thread.sleep(3000);
			
			
			
	}
	else { 
		System.out.println("Member not found");
		Log.info("Member not found");
	BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
	driver.quit();
	}
	BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
	driver.quit();

	return newClaimNo.substring(1,13);
	
	}catch(Exception e){e.printStackTrace(); System.out.println("error in add claim"); 
	Log.info("error in add claim"); 
	BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
	driver.quit();

	return null;
	}
	
	}
	
	public String findApprovedClaim() throws Exception{
	
	String claimNo= "";
	try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(claimIDBegins));
		driver.findElement(claimIDBegins).sendKeys("20180808");
		
		System.out.println("entered claim id begins");
		Log.info("log4j msg-entered claim id begins");
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(DispositionBegins));
		driver.findElement(DispositionBegins).sendKeys("Approved");
		
		System.out.println("entered disposition- Approved");
		Log.info("log4j msg-entered disposition - Approved");
		
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(ClaimSearchButton));
		driver.findElement(ClaimSearchButton).click();
		
		System.out.println("clicked search");
		Log.info("log4j msg-clicked search");
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(ApprovedClaimIDLabel));
		claimNo= driver.findElement(ApprovedClaimIDLabel).getText();
		
		System.out.println("claimNo:"+claimNo);
		Log.info("log4j msg-claimNo:"+claimNo);
		
		
		
		
		
		return claimNo;
	}catch(Exception e){ return claimNo;}
	}
	
	
	public void CEVsimpleReverseClaim( String mid, String claimNo, String receivedDate) throws Exception{

		
		
	
		try{
		
		// select on claim no
		MembersClaimsHistoryPage membersClaimsHistoryPageObject = new MembersClaimsHistoryPage(driver);
		membersClaimsHistoryPageObject.selectClaim( claimNo);
		System.out.println("claim no selected in member claim history");
		Log.info("log4j msg-claim no selected from claim history");
		
		String oldDisposition= driver.findElement(By.xpath("//div[text()='"+claimNo+"']/../following-sibling::div/following-sibling::div/following-sibling::div/following-sibling::div/following-sibling::div/div")).getText();

		System.out.println(claimNo+"old disposition :" +oldDisposition);
		if (oldDisposition.equalsIgnoreCase("Approved")) {

		clickReverse(driver);   
		
		// STEP 18 - ENTER CORRECTED CLAIM RECEIVED
	    
		String msg= "Corrected Claim Received";
		enterReversalMsg (driver, msg);
		    
		   

		// STEP 19 - CLICK CONTINUE
		    
		 clickContinue(driver);
		    
		   
		  
		  //validation 4: Check if A-Reversed Claim is created
		    
		    if(driver.findElement(By.xpath ("//div[text()='A-Reversed']")).isDisplayed())
		    {
		    	System.out.println("A-Reversed claim is created successfully");
		    	Log.info("log4j msg-A reversed claim created successfully");
		    	Thread.sleep(2000);
			    
			 	BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();
			 	
		    }
		    
		    else
		    {
		    	System.out.println("A-Reversed claim is not created, Reverse Action failed ");
		    	Log.info("log4j msg-A-Reversed claim is not created, Failed Reverse");
		    	BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();
		   
		   
		    }
		}else{ System.out.println("This is not an Approved claim, it cannot be Reversed"); 
		Log.info("log4j msg-this is not an approved claim, it cannot be reversed");
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();
		
		}
		}catch(Exception e){e.printStackTrace();
		System.out.println("error in reverse claim"); 
		Log.info("error in reverse claim");
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit();
		
		}
		}


	public void clickReverse(WebDriver b) throws InterruptedException{

		b.findElement(By.xpath("//input[@data-ng-model='paginationOptions.searchOptions.diagnosisCode']")).sendKeys(Keys.PAGE_UP);
		Log.info("log4j msg- PAGE UP");
		System.out.println("Page up");
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='Reverse']"))); 
		b.findElement(By.xpath("//span[.='Reverse']")).click();
		System.out.println("Clicked Reverse");
		Log.info("log4j msg-clicked reverse");
		Thread.sleep(2000);
		}

		public void enterReversalMsg (WebDriver c, String s) throws InterruptedException{

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-ng-model='formData.reversalMessage']"))); 		 
		c.findElement(By.xpath("//input[@data-ng-model='formData.reversalMessage']")).sendKeys(s);
		Thread.sleep(2000);
		}
	
		public void clickContinue(WebDriver e) throws InterruptedException{

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[.='Continue']")));
			e.findElement(By.xpath("//button[.='Continue']")).click();
			Log.info("log4j msg-clicked continue");
			Thread.sleep(2000);
			}
	

	
}

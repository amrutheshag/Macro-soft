package com.pages;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BrowserUtils;
import utility.Log;

public class MembersClaimsHistoryPage {
	
	WebDriver driver;
	WebDriverWait wait ;   
		
	public MembersClaimsHistoryPage(WebDriver driver){
		this.driver= driver;
		this.wait= new WebDriverWait(driver, 50); 
	}

	public void selectClaim( String claimNo) throws Exception{	
		System.out.println("Claim Number:" +claimNo);
		try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+claimNo+"']")));
		driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+claimNo+"']")).click();
		System.out.println("claim selected");
		Log.info("log4j msg- claim selected");
		}
		
	catch(Exception e) {
	System.out.println("Given Claim is not present");
	Log.info("log4j msg- Given Claim is not present");

	}
	}

	public void adjudicateClaimMC( String mid, String mlname, String mfname, String dob, String ssn, String claimNo) throws Exception{
		try{
		//enter mid, click search, click Return selection
		SelectMemberPage selectMemberPageObject= new SelectMemberPage(driver);
		int i=selectMemberPageObject.searchMember(mid, mlname, mfname, dob, ssn);
				
		
		if (i==1){
		
			selectClaim( claimNo);
		
			try{
				String oldDisposition= driver.findElement(By.xpath("//div[text()='"+claimNo+"']/../../div/div")).getText();
				System.out.println(claimNo+"old disposition :" +oldDisposition);
				if (oldDisposition.equalsIgnoreCase("PUnprocessed")|| oldDisposition.equalsIgnoreCase("PWebClaim") ) {
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Adjudicate")));
					driver.findElement(By.linkText("Adjudicate")).click();
					System.out.println("Clicked Adjudicate");
					Log.info("log4j msg-clicked Adjudicate");
					Thread.sleep(2000);
		
					driver.findElement(By.xpath("//button[@class='btn btn-primary btn-bottom02' and text()='Yes']")).click();
					System.out.println("Clicked Yes to confirm Validation");
					Log.info("log4j msg-clicked yes to confirm validation");
		
					Thread.sleep(3000);
		
	try{
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary btn-bottom02' and text()='OK']")));
					driver.findElement(By.xpath("//button[@class='btn btn-primary btn-bottom02' and text()='OK']")).click();
					System.out.println("Clicked ok to confirm no. of records adjudicated");
					Log.info("log4j msg- click ok to confirm no. of records adjudicated");
					
					Thread.sleep(2000);
				
	}catch(Exception e){System.out.println("");}
					
				}
		
				else{ 
					System.out.println("Claim is already adjudicated");
					Log.info("log4j msg-claim is already adjudicated");
					
				}	
			} 
			catch(Exception e){
			e.printStackTrace();
			System.out.println("This claim cannot be adjudicated");
			Log.info("log4j msg-this claim cannot be adjudicated");
			
			}
		
			
		}}catch(Exception e){
			System.out.println("error in adjudicate claim");
			Log.info("log4j msg- error in adjudicate claim");
			}
	
	
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit();
	
	}

	public String adjustClaimMC( String mid, String mlname, String mfname, String mdob, String mssn, String claimNo, String newdos, String AdjustmentType) throws Exception{
		try{
		SelectMemberPage selectMemberPageObject= new SelectMemberPage(driver);
		int i= selectMemberPageObject.searchMember( mid, mlname, mfname, mdob, mssn);
		System.out.println("searched  for member");
		
			if (i==1) {
				selectClaim( claimNo);
		
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Adjust")));
				driver.findElement(By.linkText("Adjust")).click();
				System.out.println("clicked Adjust");
				Log.info("log4j msg- clicked Adjust");
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary btn-bottom02' and text()='OK']")));
				driver.findElement(By.xpath("//button[@class='btn btn-primary btn-bottom02' and text()='OK']")).click();
				System.out.println("clicked ok");
				Log.info("log4j msg-clicked ok");
		
				
				WebElement claimStartDate = driver.findElement(By.xpath("//input[@id='txtClaimPeriodStart']"));
				claimStartDate.sendKeys(newdos);
				claimStartDate.sendKeys(Keys.TAB);
				Log.info("log4j msg-entered new date of service, clicked tab");
				
				
				System.out.println("changed date of service");

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("2-Pricing, Pmt, Notes")));
			
				driver.findElement(By.linkText("2-Pricing, Pmt, Notes")).click();
				System.out.println("clicked 2-Pricing, Pmt, Notes");
				Log.info("log4j msg- clicked 2-Pricing, Pmt, Notes");
				

				Select placeOfService = new Select(driver.findElement(By.xpath("//select[@style='width: 269px;']")));
				placeOfService.selectByVisibleText(AdjustmentType);
				Log.info("log4j msg-entered Adjustment Type");

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Save")));
				driver.findElement(By.linkText("Save")).click();
				System.out.println("clicked Save");
				Log.info("log4j msg-clicked save");
		
				try{
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-bb-handler='Success' and text()='OK']")));
					driver.findElement(By.xpath("//button[@data-bb-handler='Success' and text()='OK']")).click();
					System.out.println("clicked ok"); 
					Log.info("log4j msg-clicked ok");
				}
				catch(Exception e){ System.out.println("no ok button");}
				String newClaimno= driver.findElement(By.xpath("//div[@class='col-sm-12 tab-container']/div[@class='ng-binding']")).getText();
				System.out.println("new Claim number="+newClaimno); 
				Log.info("log4j msg- new Claim number="+newClaimno); 
				
				Thread.sleep(2000);
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
				driver.quit();
				return newClaimno;
		
		} else{ 
	System.out.println("cannot find member, cannot continue with Member Claims- Adjust claim");  
		Log.info("log4j msg-	cannot find member, cannot continue with Member Claims- Adjust claim");
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 	
		driver.quit(); 	
		return "Error"; 	
		}
		} catch(Exception e){ 
			System.out.println("error in Member claims- Adjust claim "); 
			Log.info("log4j msg- error in Member claims- Adjust claim ");
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
			driver.quit();
			return "Error";
			}
		
	}

public void addCommunicationMC( String mid, String mlname, String mfname, String mdob, String mssn, String claimNo, String subject, String noteType, String details) throws Exception{
	try{
	
	SelectMemberPage selectMemberPageObject= new SelectMemberPage(driver);
	int i= selectMemberPageObject.searchMember(mid, mlname, mfname, mdob, mssn);
	System.out.println("searched  for member");
	
	
	
	
	if (i==1) {
	
		
		selectClaim( claimNo);
		
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Commun.")));
		driver.findElement(By.linkText("Commun.")).click();
	System.out.println("clicked Communication");
	Log.info("log4j msg- clicked communication");
	
	
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]")));
	driver.findElement(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]")).click();
	
		
	System.out.println("Clicked add");
	Log.info("log4j msg-clicked add");

	driver.findElement(By.xpath("//input[@id='txtSubject' and @data-ng-model='currentRecord.subject']")).sendKeys(subject);
	System.out.println("entered subject");
	Log.info("log4j msg-entered subject");
	
	driver.findElement(By.xpath("//textarea[@tabindex='9']")).sendKeys(Keys.PAGE_DOWN);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(.,'Add')]")));
	driver.findElement(By.xpath("//button[contains(.,'Add')]")).click();
	System.out.println("clicked add");
	Log.info("log4j msg-clicked add");
	

Select notetypes=new Select(driver.findElement(By.id("ddlNoteType")));
notetypes.selectByVisibleText(noteType);

System.out.println("selected notetype");
Log.info("log4j msg-selected notetype");
driver.findElement(By.xpath("//textarea[@id='txtNotes']")).sendKeys(details);

System.out.println("entered comm details");
Log.info("log4j msg-entered communication details");
driver.findElement(By.xpath("//button[@data-ng-click='closeMe()']")).click();
System.out.println("clicked on hide");
Log.info("log4j msg-clicked on hide");
driver.findElement(By.xpath("//button[@data-ng-click='closeCase()']")).click();

System.out.println("clicked on close case");
Log.info("log4j msg-clicked on close case");
driver.findElement(By.linkText("Save")).click();
System.out.println("clicked on save");
Log.info("log4j msg- clicked on save");

Thread.sleep(2000);
BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
driver.quit();

	}
	else{
	System.out.println("member not found");
	Log.info("log4j msg- member not found");
	BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
	driver.quit();
	}
	}catch(Exception e){System.out.println("error in member claims add comm");
	Log.info("log4j msg- error in member claims add comm"); 
	BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
	driver.quit();
	}
		
}

public String copyClaimMC( String mid, String mlname, String mfname, String mdob, String mssn, String claimNo, String newdos) throws Exception{
	try{
	SelectMemberPage selectMemberPageObject= new SelectMemberPage(driver);
	int i= selectMemberPageObject.searchMember( mid, mlname, mfname, mdob, mssn);
	System.out.println("searched  for member");
	
		if (i==1) {
			selectClaim( claimNo);
	
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Copy")));
			driver.findElement(By.linkText("Copy")).click();
			System.out.println("clicked copy");
			Log.info("log4j msg- clicked copy");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary btn-bottom02' and text()='OK']")));
			driver.findElement(By.xpath("//button[@class='btn btn-primary btn-bottom02' and text()='OK']")).click();
			System.out.println("clicked ok");
			Log.info("log4j msg-clicked ok");
	
			WebElement claimStartDate = driver.findElement(By.xpath("//input[@id='txtClaimPeriodStart']"));
			claimStartDate.sendKeys(newdos);
			claimStartDate.sendKeys(Keys.TAB);
			Log.info("log4j msg-entered new date of service, clicked tab");
		
			System.out.println("changed date of service");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Save")));
			driver.findElement(By.linkText("Save")).click();
			System.out.println("clicked Save");
			Log.info("log4j msg-clicked save");
	
			try{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-bb-handler='Success' and text()='OK']")));
				driver.findElement(By.xpath("//button[@data-bb-handler='Success' and text()='OK']")).click();
				System.out.println("clicked ok"); 
				Log.info("log4j msg-clicked ok");
			}
			catch(Exception e){ System.out.println("");}
			String newClaimno= driver.findElement(By.xpath("//div[@class='col-sm-12 tab-container']/div[@class='ng-binding']")).getText();
			System.out.println("new Claim number="+newClaimno.substring(1,13)); 
			Log.info("log4j msg- new Claim number="+newClaimno.substring(1,13)); 
			
			Thread.sleep(2000);
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
			driver.quit();
			return newClaimno.substring(1,13);
	} else{ 
		System.out.println("cannot find member, cannot continue with Member Claims- copy claim");  
		Log.info("log4j msg-	cannot find member, cannot continue with Member Claims- copy claim");
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
		driver.quit(); 	
		return "Error"; 	
		}
	} catch(Exception e){ 
		System.out.println("error in Member claims- copy claim ");
		Log.info("log4j msg- error in Member claims- copy claim ");
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
		driver.quit();
		return "Error";
		}
	
}

public void deleteClaimNumberMC( String mid, String mlname, String mfname, String mdob, String mssn,  String claimNo) throws Exception{
try{
	SelectMemberPage selectMemberPageObject= new SelectMemberPage(driver);
	int i= selectMemberPageObject.searchMember( mid, mlname, mfname, mdob, mssn);
	System.out.println("searched  for member");
	
	
	
	
	if (i==1) {
	
		
		try{
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-bb-handler='Success' and text()='OK']")));
			driver.findElement(By.xpath("//button[@data-bb-handler='Success' and text()='OK']")).click();
			System.out.println("clicked ok"); 
			Log.info("log4j msg-clicked ok");
		}
		catch (Exception e){ System.out.println("");}
		
		selectClaim( claimNo);
	
	
	
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-ng-click='delete()']")));
	driver.findElement(By.xpath("//a[@data-ng-click='delete()']")).click();
	System.out.println("clicked delete");
	Log.info("log4j msg- clicked delete");
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-bb-handler='Success']")));
	driver.findElement(By.xpath("//button[@data-bb-handler='Success']")).click();
	
	System.out.println("clicked yes to confirm delete");
	Log.info("log4j msg- clicked Yes to confirm delete");
	BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
	driver.quit();
}
	else{
		System.out.println("member not found");
		Log.info("log4j msg- member not found");
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit();
	}
}catch(Exception e){System.out.println("error in member claims- delete claim"); 
Log.info("log4j msg- error in member claims- delete claim"); 
BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
driver.quit();
}
}

public void editClaimMC(String mid,String mlname, String mfname, String mdob, String mssn,  String claimNo) throws Exception{
try{
SelectMemberPage selectMemberPageObject= new SelectMemberPage(driver);
int i= selectMemberPageObject.searchMember( mid, mlname, mfname, mdob, mssn);
System.out.println("searched  for member");




if (i==1) {

	
	try{
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-bb-handler='Success' and text()='OK']")));
		driver.findElement(By.xpath("//button[@data-bb-handler='Success' and text()='OK']")).click();
		System.out.println("clicked ok"); 
		Log.info("log4j msg-clicked ok");
	}
	catch (Exception e){ System.out.println("");}
	
	selectClaim( claimNo);





wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Edit")));
driver.findElement(By.linkText("Edit")).click();
System.out.println("Clicked on Edit");
Log.info("log4j msg- clicked edit");

Thread.sleep(2000);

wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-ng-model='currentRecord.eobnote']")));
driver.findElement(By.xpath("//input[@data-ng-model='currentRecord.eobnote']")).click();
driver.findElement(By.xpath("//input[@data-ng-model='currentRecord.eobnote']")).sendKeys("Test Edit");
System.out.println("Edited Outgoing field");
Log.info("log4j msg- Edited outgoing field");

Thread.sleep(2000);
//step 9 - save claim
try{
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Save")));
	driver.findElement(By.linkText("Save")).click();
	System.out.println("clicked save"); 
	Log.info("log4j msg- clicked save");
	} catch(Exception e) {System.out.println("cannot find save"); Log.info("log4j msg-cannot find save");  }
	
Thread.sleep(2000);


try{
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-bb-handler='Success' and text()='OK']")));
	driver.findElement(By.xpath("//button[@data-bb-handler='Success' and text()='OK']")).click();
	System.out.println("clicked ok"); 
	Log.info("log4j msg-clicked ok");
	Thread.sleep(1000);
}
catch(Exception e){ System.out.println("");}
//step 10 - exit claim
BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
driver.quit();
}
else{ System.out.println("member not found");
Log.info("log4j msg- member not found");
BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
driver.quit();

}
}catch(Exception e){ 
	System.out.println("error in member claims- edit member"); 
	Log.info("log4j msg- error in member claims- edit member"); 
	BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
	driver.quit();
}

}

public void exitClaim( String mid,String mlname, String mfname, String mdob, String mssn, String claimNo) throws Exception
{
try{
SelectMemberPage selectMemberPageObject= new SelectMemberPage(driver);
int i= selectMemberPageObject.searchMember( mid, mlname, mfname, mdob, mssn);
System.out.println("searched  for member");
Log.info("log4j msg- searched  for member");



if (i==1) {

	
	try{
		
		driver.findElement(By.xpath("//button[@data-bb-handler='Success' and text()='OK']")).click();
		System.out.println("clicked ok"); 
		Log.info("log4j msg-clicked ok");
	}
	catch (Exception e){  }
	
	selectClaim( claimNo);




wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Exit')]")));
driver.findElement(By.xpath("//span[contains(text(),'Exit')]")).click(); 
System.out.println("Clicked exit");
Log.info("log4j msg - clicked exit");
BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
driver.quit();

}
else {System.out.println("member not found");
Log.info("log4j msg -  member not found");
BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
driver.quit();
}
}catch(Exception e){System.out.println("error in member claims- exit claim");
Log.info("log4j msg -  error in member claims- exit claim");
BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
driver.quit();}
} 

public WebDriver newMemberMC( String oldMID, String claimNo, String newMID) throws Exception{
	try{
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("New Member")));
	driver.findElement(By.linkText("New Member")).click();
	System.out.println("Clicked on New Member");
	Log.info("log4j msg- clicked on new member");
	
	BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
	
	return driver;
	} catch(Exception e){ System.out.println("Clicked in member claims- New Member");
	Log.info("log4j msg- error in member claims- new member");
	
	BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
	return driver;
	}
	


}


	public String moveClaim( String oldMID, String oldmlname, String oldmfname, String oldmdob, String oldmssn,String claimNo, String newMID, String newmlname, String newmfname, String newmdob, String newmssn) throws Exception
	{System.out.println("move claim script");
		Log.info("log4j msg - move claim script");
		try{
				SelectMemberPage selectMemberPageObject= new SelectMemberPage(driver);
				int i= selectMemberPageObject.searchMember( oldMID, oldmlname,oldmfname, oldmdob, oldmssn);
				System.out.println("searched  for member");
				Log.info("log4j msg -searched  for member");

				if (i==1) {

					
	
						try{
							wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+claimNo+"']")));
							driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+claimNo+"']")).click();
							System.out.println("claim selected");
							Log.info("log4j msg-claim selected");
						} catch (Exception e){ System.out.println("The claim to be moved is not present");BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit(); return ("fail");}
			
						System.out.println("we will try to move the claim now");
						Log.info("log4j msg-we will move the claim now");
						//click on move
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Move")));
						driver.findElement(By.linkText("Move")).click();
						Log.info("log4j msg-clicked move");
						System.out.println("clicked move");

						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary btn-bottom02' and text()='Yes']")));
						driver.findElement(By.xpath("//button[@class='btn btn-primary btn-bottom02' and text()='Yes']")).click();
						System.out.println("Clicked Yes- to confirm the move, the claim will be deleted from the first member's history");
						Log.info("log4j msg-clicked yes to cofirm the move, the claim will be deleted from the first member's history");
		
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary btn-bottom02' and text()='OK']")));
						driver.findElement(By.xpath("//button[@class='btn btn-primary btn-bottom02' and text()='OK']")).click();
						System.out.println("Clicked OK- to go to the new claim form where new member needs to be selected");
						Log.info("log4j msg-clicked ok to go to the new claim form where new member needs to be selected");

		
						try{
							int j= selectMemberPageObject.searchMember(newMID, newmlname,newmfname, newmdob, newmssn);
							if (j==1){
								System.out.println("new member selected");
								Log.info("log4j msg-new member selected");
		
								wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary btn-bottom02' and text()='OK']")));
								driver.findElement(By.xpath("//button[@class='btn btn-primary btn-bottom02' and text()='OK']")).click();
								System.out.println("Clicked OK- You must Edit or Validate this Claim in order to process all records");
								Log.info("log4j msg-clicked ok");
								Thread.sleep(2000);
								
								try{
								wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary btn-bottom02' and text()='OK']")));
								driver.findElement(By.xpath("//button[@class='btn btn-primary btn-bottom02' and text()='OK']")).click();
								System.out.println("Clicked OK- No Provider assignment to this Payer's Exclusive Network - Provider is Non-Network.");
								Log.info("log4j msg-clicked ok");
								Thread.sleep(2000);
								}catch(Exception e){
									//e.printStackTrace();
									}
								
								try{
								wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Save")));
								driver.findElement(By.linkText("Save")).click();
								System.out.println("clicked save");
								Log.info("log4j msg-clicked save");
								Thread.sleep(2000);
								}catch(Exception e){
									//e.printStackTrace();
									}
								
								try{
									wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary btn-bottom02' and text()='OK']")));
									driver.findElement(By.xpath("//button[@class='btn btn-primary btn-bottom02' and text()='OK']")).click();
									System.out.println("Clicked OK-Entire Claim Rebilling Status has been Pended due to a Service pending appropriate rebilling.");
									Log.info("log4j msg-clicked ok-Entire Claim Rebilling Status has been Pended due to a Service pending appropriate rebilling.");
									Thread.sleep(2000);
								}catch(Exception e)	{
									//e.printStackTrace(); 
									System.out.println("");
									}					
								}
							else {
								System.out.println("new member not found, cannot move claim");
								Log.info("log4j msg-new member not found, cannot move claim");
								BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
								driver.quit(); 
								return "fail";
								}
						} catch (Exception e) {
							System.out.println("error in selecting New member");
							Log.info("log4j msg-error in selecting New member "); 
							BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
							driver.quit(); 
							return "fail";
						}
					}
				else{ 
					System.out.println("Member not found, cannot move"); 
					Log.info("log4j msg- Member not found, cannot move"); 
					BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
					driver.quit();
					return "fail";
					}
		
	}catch(Exception e){
		System.out.println("Error in Member Claims- Move claim");
		Log.info("log4j msg- Error in Member Claims- Move claim"); 
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
		driver.quit(); 
		return "fail";
		}
	
		
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit();
		return "pass";
	}
	
	
public String addClaim(String mid,String mlname,String mfname, String mdob, String mssn, String claimPeriod,String receivedDate,String taxID,String npi,String pname,String paddress,String pspecial,String pos,String icd,String diagnosisCode,String cptCode,String charges,String quantity, String modifier1, String modifier2, String modifier3) throws Exception
{Log.info("log4j msg - Add claim script");
	System.out.println("Add Claim Script");
	String newClaimNo= "";
	try{
	// - search on mid and return selection
				SelectMemberPage selectMemberPageObject= new SelectMemberPage(driver);
				int i= selectMemberPageObject.searchMember( mid, mlname, mfname, mdob, mssn);
				System.out.println("searched  for member");
				Log.info("log4j msg - searched  for member");
	if (i==1) {
driver.findElement(By.xpath("//span[text()='Add']")).click();
	System.out.println("clicked add");
	Log.info("log4j msg-clicked add");
	System.out.println("claim period:" +claimPeriod);
	Log.info("log4j msg-claim period:" +claimPeriod);
	try{
	
		Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtClaimPeriodStart' and @placeholder='MM/dd/yyyy']")));
	
	WebElement ClaimPeriod= driver.findElement(By.xpath("//input[@id='txtClaimPeriodStart' and @placeholder='MM/dd/yyyy']"));
	ClaimPeriod.sendKeys(claimPeriod);

	System.out.println("entered claim period start date");
	Log.info("log4j msg-entered claim period");
	Thread.sleep(3000);
	//enter the claim period end date by clicking tab- autopopulates the claim start date
	
	} catch (Exception e){e.printStackTrace(); System.out.println("error in entering claim period"); 
	Log.info("log4j msg-error in entering claim period");
	}
	
	
	
	
	
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='?']")));
	driver.findElement(By.xpath("//button[text()='?']")).click();
	System.out.println("clicked ?");
	Log.info("log4j msg-clicked ?");
	Thread.sleep(2000);
	
	//enter npi
	try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtSearchCode' and @data-ng-model='filterOptionsnew.NPI']")));
	
	WebElement ProviderNPI= driver.findElement(By.xpath("//input[@id='txtSearchCode' and @data-ng-model='filterOptionsnew.NPI']"));
	
	ProviderNPI.sendKeys(npi);
	Thread.sleep(2000);
	System.out.println("entered npi");
	Log.info("log4j msg-entered npi");
	}catch(Exception e){ System.out.println("Error in entering NPI");Log.info("Error in entering NPI");}
	
	//click search
	WebElement SearchButton= driver.findElement(By.xpath("//button[text()='Search']"));
	SearchButton.click();
	
	Thread.sleep(2000);
	Log.info("log4j msg-clicked search");
	System.out.println("clicked search");
	//check provider tin
	System.out.println("Getting Provider - Organization TIN combination data list now");
    
	Thread.sleep(2000);
	List <WebElement> dateBox1 = driver.findElements(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope']/ancestor::div[@class='ui-grid-cell ng-scope ui-grid-disable-selection ui-grid-coluiGrid-00ES']//following-sibling::div//div"));
    for (WebElement webElement : dateBox1) {
    System.out.println(webElement.getText());
    
    }     

	//click ok
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-secondary btn-bottom01 pull-right' and @ng-click='getProviderAddress()']")));
    			WebElement ClickOk= driver.findElement(By.xpath("//button[@class='btn btn-secondary btn-bottom01 pull-right' and @ng-click='getProviderAddress()']"));
    	ClickOk.click();
    	Thread.sleep(2000);
    	System.out.println("Selected provider");
    	Log.info("selected provider");
    	
   
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='"+paddress+"']")));
    	driver.findElement(By.xpath("//div[text()='"+paddress+"']")).click();
    	System.out.println("clicked on address");
    	Log.info("log4j msg-clicked on address");
    	Thread.sleep(2000);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@ng-click='providerLookupAddressokbuttonclick()']")));
    	WebElement ClickOk2= driver.findElement(By.xpath("//button[@ng-click='providerLookupAddressokbuttonclick()']"));
	ClickOk2.click();
	Thread.sleep(2000);
	System.out.println("selected Address");
	Log.info("log4j msg-selected address");
	
	//<button data-bb-handler="Success" type="button" class="btn btn-primary btn-bottom02">OK</button>
	try{wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-bb-handler='Success']")));
	WebElement ClickOk3= driver.findElement(By.xpath("//button[@data-bb-handler='Success']"));
	ClickOk3.click();
	System.out.println("Just clicked ok");
	Log.info("log4j msg-clicked ok");
	
	}catch(Exception e){System.out.println(""); }
	
		try{
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-bb-handler='Success']")));
		WebElement ClickOk4= driver.findElement(By.xpath("//button[@data-bb-handler='Success']"));
		ClickOk4.click();
		System.out.println("Just clicked  ok");
		Log.info("log4j msg-clicked ok");
		}catch(Exception e){System.out.println("");}
	
	
		Thread.sleep(2000);
		
		/*
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-ng-model='currentRecord.specialty']")));
		driver.findElement(By.xpath("//input[@data-ng-model='currentRecord.specialty']")).sendKeys(pspecial);
		System.out.println("entered speciality");
		Log.info("log4j msg-entered speciality");
	Thread.sleep(2000);
		*/
		WebElement e= driver.findElement(By.xpath("//input[@tabindex='13']"));
		System.out.println(e.getText());
		e.clear();
		e.sendKeys(taxID);
		System.out.println("entered taxid");
		Log.info("log4j msg-entered taxid");
	
	Select placeOfService = new Select(driver.findElement(By.cssSelector("select")));
	
	placeOfService.selectByVisibleText(pos);
	Log.info("log4j msg-selected place of service");
	//scrolldown
			driver.findElement(By.xpath("//input[@data-ng-model='currentRecord.ordered_dt' and @data-ng-disabled='isAuditing']")).sendKeys(Keys.PAGE_DOWN);
			System.out.println ("scrolldown");
			Log.info("log4j msg-clicked scroll down");
	
	
Select icdcode = new Select(driver.findElement(By.xpath("//*[contains(text(), 'ICD Version(1)')]/../select")));
icdcode.selectByIndex(2);
	System.out.println("ICD Code 10 selected");
	Log.info("log4j msg-selected icd code 10");
	WebElement enterdiagnosiscode = driver.findElement(By.xpath("//input[@id='txtIcd1']"));
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtIcd1']")));
		enterdiagnosiscode.clear();
		enterdiagnosiscode.sendKeys(diagnosisCode);
		System.out.println("Entered Diagnosis code");
		Log.info("log4j msg-entered diagnosis code");
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@tabindex='35']")));
	driver.findElement(By.xpath("//input[@tabindex='35']")).click();
	driver.manage().window().maximize();
	System.out.println("window maximized");
	Log.info("log4j msg-maximized window");
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col-sm-5 no-padding text-right pull-right']/button/following-sibling::button/following-sibling::button")));
	driver.findElement(By.xpath("//div[@class='col-sm-5 no-padding text-right pull-right']/button/following-sibling::button/following-sibling::button")).click();
	System.out.println("Clicked Add");
	Log.info("log4j msg-clicked add");
	Thread.sleep(2000);	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtService']")));
	driver.findElement(By.xpath("//input[@id='txtService']")).sendKeys(cptCode);
	System.out.println("entered cpt code");
	Log.info("log4j msg-entered cpt code");
	
	Thread.sleep(2000);
	
	//enter modifier 1
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='modifiers']")));
	driver.findElement(By.xpath("//input[@id='modifiers']")).sendKeys(modifier1);
	System.out.println("entered modifier1");
	Log.info("log4j msg-entered modifier1");
	
	
	Thread.sleep(1000);
	
	//enter modifier 2
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='modifiers2']")));
	driver.findElement(By.xpath("//input[@id='modifiers2']")).sendKeys(modifier2);
	System.out.println("entered modifier2");
	Log.info("log4j msg-entered modifier2");
	Thread.sleep(1000);
	//enter modifier 3
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='modifiers3']")));
	driver.findElement(By.xpath("//input[@id='modifiers3']")).sendKeys(modifier3);
	System.out.println("entered modifier3");
	Log.info("log4j msg-entered modifier3");
	
	
	
	Thread.sleep(3000);
	
	
	
	
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-ng-model='gridServices.selectedRecord.billed']")));
	driver.findElement(By.xpath("//input[@data-ng-model='gridServices.selectedRecord.billed']")).sendKeys(charges);
	System.out.println("entered charges");
	Log.info("log4j msg-entered charges");
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-ng-model='gridServices.selectedRecord.billedunit']")));
	driver.findElement(By.xpath("//input[@data-ng-model='gridServices.selectedRecord.billedunit']")).sendKeys(quantity);
	System.out.println("Entered quantity");
	Log.info("log4j msg-entered quantity");
	
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-ng-model='gridServices.selectedRecord.ndC_units']")));
	WebElement element1=driver.findElement(By.xpath("//input[@data-ng-model= 'gridServices.selectedRecord.ndC_units']"));
	
	
	WebElement element3= driver.findElement(By.xpath("//button[@class='btn btn-secondary btn-bottom02 pull-right' and @data-dismiss='modal'and @aria-hidden='true' and contains(text(),'Hide')]"));
	Actions builder = new Actions(driver); 
	element1.click();
	builder.dragAndDropBy(element1, 0,-300).build().perform();
	System.out.println("moved to another position");
	Log.info("log4j msg-clicked and pulled the screen up to see the Hide button");
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-secondary btn-bottom02 pull-right' and @data-dismiss='modal'and @aria-hidden='true' and contains(text(),'Hide')]")));
	builder.moveToElement(element3).click().build().perform();
	
	System.out.println("clicked on hide");
	Log.info("log4j msg-clicked on hide");
	Thread.sleep(2000);
		//<input class="form-control ng-pristine ng-valid ng-empty ng-valid-maxlength ng-touched" tabindex="36" maxlength="254" data-toggle="tooltip" title="" data-placement="left" data-ng-model="currentRecord.adminnote" data-ng-readonly="isAuditing" data-original-title="">
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@tabindex='36']")));
	driver.findElement(By.xpath("//input[@tabindex='36']")).sendKeys(Keys.PAGE_UP);	
	System.out.println("Clicked pageup");
	Log.info("log4j msg-clicked pageup");
	
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-ng-click='saveForm()'] /img/following-sibling::span[text()='Save']")));
	driver.findElement(By.xpath("//a[@data-ng-click='saveForm()'] /img/following-sibling::span[text()='Save']")).click();
	System.out.println("Clicked save"); 
	Log.info("log4j msg-clicked save");
	Thread.sleep(2000);
	
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='OK']")));
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		System.out.println("For your information alert-clicked ok ");
		Log.info("log4j msg-clicked ok");
		Thread.sleep(2000);
		} catch (Exception e1) {System.out.println("");}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@style='position: absolute; right: 40px; top: 6px;' and @class='ng-binding']")));
		newClaimNo= driver.findElement(By.xpath("//div[@style='position: absolute; right: 40px; top: 6px;' and @class='ng-binding']")).getText();
		System.out.println("New Claim no:" +newClaimNo.substring(1,13));
		 Log.info("log4j msg- New Claim no:" +newClaimNo.substring(1,13));
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit();
	
	}
	return newClaimNo.substring(1,13);
	}catch(Exception e){
		e.printStackTrace(); 
		System.out.println("Error in Member claims- Add new claim"); 
		Log.info("log4j msg-Error in Member claims- Add new claim"); 
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
		driver.quit(); return null;
		}
	}


public void simpleReverseClaim( String mid,String mlname, String mfname, String mdob, String mssn, String claimNo, String receivedDate) throws Exception{

	Log.info("log4j msg- Member claims - Simple Reverse script");
	System.out.println("Member claims - Simple Reverse script");
	try{
		//search for member
	
		SelectMemberPage selectMemberPageObject= new SelectMemberPage(driver);
		selectMemberPageObject.searchMember( mid, mlname, mfname,mdob, mssn);
		System.out.println("searched  for member");
		Log.info("log4j msg- searched  for member");
	// select on claim no
		MembersClaimsHistoryPage membersClaimsHistoryPageObject = new MembersClaimsHistoryPage(driver);
		membersClaimsHistoryPageObject.selectClaim( claimNo);
		System.out.println("claim  selected in member claim history");
		Log.info("log4j msg-claim  selected in member claim history");
		try{
		
	
			String oldDisposition= driver.findElement(By.xpath("//div[text()='"+claimNo+"']/../../div/div")).getText();
			Log.info("log4j msg- "+claimNo+"old disposition :" +oldDisposition);
			System.out.println(claimNo+"old disposition :" +oldDisposition);
	
	
			if (oldDisposition.equalsIgnoreCase("Approved")) {

				clickReverse(driver);   
	
				// STEP 18 - ENTER CORRECTED CLAIM RECEIVED
    
				String msg= "Corrected Claim Received";
				enterReversalMsg (driver, msg);
				System.out.println("entered corrected claim received message");
				Log.info("log4j msg-entered corrected claim received message");    
	   

				// STEP 19 - CLICK CONTINUE
	    
				clickContinue(driver);
	    
	   
	  
				//validation 4: Check if A-Reversed Claim is created
				
				if(driver.findElement(By.xpath ("//div[text()='A-Reversed']")).isDisplayed())
				{
					System.out.println("A-Reversed claim is created successfully");
					Log.info("log4j msg- A-Reversed claim is created successfully");
					BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
				}else {
					System.out.println("A-Reversed Claim is not created, Reverse Action failed in RM");
					Log.info("log4j msg- A-Reversed claim is not created, Reverse Action failed in RM");
					BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
					System.exit(1);
				}
				}else{ 
					System.out.println("This is not an Approved claim, it cannot be Reversed");
					Log.info("log4j msg This is not an Approved claim, it cannot be Reversed");
					BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
					driver.quit();
					
				}
	} catch(Exception e){ System.out.println(" claim number not found"); 
	Log.info(" claim number not found");
	BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 

	driver.quit();
	}
	}catch(Exception e){ 
		e.printStackTrace(); 
		System.out.println("Error in Member Claims-Simple Reversal"); 
		Log.info("log4j msg -Error in Member Claims-Simple Reversal"); 
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit();
		}
}













public void reverseClaim( String mid, String claimNo, String receivedDate) throws Exception{
	//STEP 7 - ENTER CLAIM NUMBER	
	// select on claim no
	MembersClaimsHistoryPage membersClaimsHistoryPageObject = new MembersClaimsHistoryPage(driver);
	membersClaimsHistoryPageObject.selectClaim( claimNo);
	System.out.println("claim no selected in member claim history");
	
	
	// STEP 10 - Capture the Duplicate claim (pdupservice) Date of Service (dos), received date, provider details
	System.out.println("Getting Pduplservice claim data list now");
	List <WebElement> dateBox = driver.findElements(By.xpath("//div[text()='"+claimNo+"']"));	  
		for (WebElement webElement : dateBox) {
			System.out.println("inside for loop of webElement dateBox");
			System.out.println(webElement.getSize()+ "webElement datebox size");
			System.out.println(webElement.getText());   		
	}    

	
		
		//validation 1: check if the claim number given is duplicate claim number

String pdupserviceDisposition = dateBox.get(4).getText();
if (pdupserviceDisposition.equalsIgnoreCase("PDuplService"))
{
	System.out.println("Given Claim number is a Duplicate Claim Number");

String pdupserviceDOS = dateBox.get(1).getText();
String pdupserviceRD= dateBox.get(2).getText();
String pdupservicePNPI= dateBox.get(3).getText();     
String pdupservicePOS=dateBox.get(6).getText();
String pdupserviceNetPmt=dateBox.get(9).getText();

//validation 2: check if the net payment in Duplicate claim is $0.00 or empty
    if (pdupserviceNetPmt.equals("$0.00") || pdupserviceNetPmt.isEmpty()){
	System.out.println("Pdupservice claim is not yet Adjudicated");
      }
    else
    {
	System.out.println("This duplicate claim is already Adjudicated, pick a new Duplicate claim for Reversal");
	}
System.out.println("Duplicate claim DOS="+pdupserviceDOS);
System.out.println("Duplicate claim RD="+pdupserviceRD);
System.out.println("Duplicate claim provider="+pdupservicePNPI);
System.out.println("Duplicate claim netpayment="+pdupserviceNetPmt);
System.out.println("Duplicate claim Place of Service="+pdupservicePOS);
//validation 3: check if the paid or reported date is empty


//STEP 14 - CLICK ON APPROVED CLAIM

clickApprovedClaim(driver);



// STEP 15 - GET APPROVED CLAIM DATA LIST

System.out.println("Getting Approved claim data list now");

List <WebElement> dateBox1 = driver.findElements(By.xpath("//div[text()='Approved']/ancestor::div[@class='ui-grid-cell ng-scope ui-grid-disable-selection ui-grid-coluiGrid-000T']//following-sibling::div//div"));
for (WebElement webElement : dateBox1) {
System.out.println(webElement.getText());
}     




String approvedDOS = dateBox1.get(1).getText();
String approvedPNPI= dateBox1.get(2).getText();
String approvedNetPmt=dateBox1.get(7).getText();
String approvedPOS = dateBox1.get(4).getText();

System.out.println("Approved claim DOS="+approvedDOS);
System.out.println("Approved claim provider="+approvedPNPI);
System.out.println("Approved claim netpayment="+approvedNetPmt);
System.out.println("Approved claim Place of Service="+approvedPOS);

Locale locale = Locale.US;
Number pdupNetPmt = NumberFormat.getCurrencyInstance(locale).parse(pdupserviceNetPmt);
Number appNetPmt= NumberFormat.getCurrencyInstance(locale).parse(approvedNetPmt);
System.out.println("PDuplClaim net pmt"+pdupNetPmt);
System.out.println("Approved Claim net pmt"+ appNetPmt);
  
Thread.sleep(2000);

// STEP 16 - CHECK IF THE DUPLICATE CLAIM AND THE APPROVED CLAIM HAVE SAME PROVIDER NPI, DATE OF SERVICE, POS

//VALIDATION to check if the duplicate and Approved claims are for the same dos, pos, provider

if(pdupserviceDOS.equalsIgnoreCase(approvedDOS) && pdupservicePNPI.equalsIgnoreCase(approvedPNPI) && pdupservicePOS.equalsIgnoreCase(approvedPOS)) {
//if ((pdupNetPmt.intValue()-appNetPmt.intValue())>0) {
    	
System.out.println("The Duplicate claim and Approved claim have same dos, pos, providernpi");	




// STEP 17 - CLICK REVERSE ON APPROVED CLAIM
clickReverse(driver);   
    
}

else
{
	System.out.println("The Pdupservice claim and Approved claim are not matching");
	System.exit(1);
	driver.quit();
	
}
    






// STEP 18 - ENTER CORRECTED CLAIM RECEIVED
    
String msg= "Corrected Claim Received";
enterReversalMsg (driver, msg);
    
   

// STEP 19 - CLICK CONTINUE
    
 clickContinue(driver);
    
   
  
  //validation 4: Check if A-Reversed Claim is created
    
    if(driver.findElement(By.xpath ("//div[text()='A-Reversed']")).isDisplayed())
    {
    	System.out.println("A-Reversed claim is created successfully");
    }
    
    else
    {
    	System.out.println("A-Reversed Claim is not created, Reverse Action failed in RM");
    	System.exit(1);
    }
    
   
    
    //validation 5: check if A-Reversal Claim is created
    
    if(driver.findElement(By.xpath ("//div[text()='A-Reversal']")).isDisplayed())
    {
    	System.out.println("A-Reversal claim is created successfully");
    }
    
    else
    {
    	System.out.println("A-Reversal Claim is not created, Reverse Action failed in RM");
    	System.exit(1);
    }
    
    
    //validation 6: check if A-Reversal claim has no Paid/Reported date
    
   	        
    List <WebElement> dateBox2 = driver.findElements(By.xpath("//div[text()='A-Reversal']/ancestor::div[@class='ui-grid-cell ng-scope ui-grid-disable-selection ui-grid-coluiGrid-000T']//following-sibling::div//div"));
    for (WebElement webElement : dateBox2) {
    System.out.println(webElement.getText());
    }     
    
    
    String aReversalPaidReportedDate = dateBox2.get(8).getText();
    
    if (aReversalPaidReportedDate.isEmpty() ){
    	System.out.println("A-Reversal claim has no Paid/Reported Date - Working As Expected");
          }
    else
    {
    	System.out.println("Error in A-Reversal Claim, Paid/Reported Date is not empty, error in Reverse Action of RM ");
    	System.exit(1);
    }
    
   
    
    
    // STEP 20 - CLICK ON A- REVERSAL CLAIM
    
    clickAReversalClaim(driver);
  
   
   
    
    
   //STEP 21 - CLICK ON EDIT
   
    clickEditMAMC(driver);
   
   
   
   // STEP 22 - ENTER RECEIVED DATE
   
    enterReceivedDate(driver, receivedDate);
   
   
   
  // STEP 23 - CLICK MANUAL CHECKBOX
	
clickManualCheckbox(driver);
   
   
   
   
  // STEP 24 - Click on Tab 5 – COB Reported, Audit Info (Notifications & Audit Info)
   
clickTab5NotificationsAuditInfo(driver);
  
   
   
   
   //  STEP 25 - Enter a Record Mark “R” 
 
   enterRecordMarkR(driver);
  
 
 
 // STEP 26 - PAGE UP
 		   
 pageUpOnTab5CEV(driver);

 
 
 // STEP 27 -  Click on Tab 2 – Payment, Status, Notes 
 
 clickTab2PaymentStatusNotes(driver);

 
 
 
  //  STEP 28 -  In Tab 2 Payment Status Notes, Adujustment Reason #2 Enter ERC01 (adjustment reason code for Corrected Claim) 
	  
enterAdjustmentReasonCodeERC01inTab2PaymentStatusNotes(driver);
 


//* **Note** If the claim is outside of the cutoff date for the front-end close out the paid/reported date is required to be manually entered on the A-Reversal claim.friday-thrusday- next friday's date 

	   

// STEP 29 *****- ENTER PAID DATE--have to create a function***	

//cr.enterPaidDateInTab2PaymentStatusNotes(driver); 



String x= calculateNextCloseout();

wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='text' and @data-ng-model='currentRecord.reportdate']")));
 driver.findElement(By.xpath("//input[@type='text' and @data-ng-model='currentRecord.reportdate']")).sendKeys(x);
 System.out.println("Entered paid Date");
 Thread.sleep(2000);	   
	   
 
 
 // STEP 30 - Go back to tab 1
	  
 //cr.clickTab1General(driver);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='#ClaimGeneral' and text()='1 - General']")));
driver.findElement(By.xpath("//a[@href='#ClaimGeneral' and text()='1 - General']")).click();
System.out.println("Clicked on Tab 1 General");
Thread.sleep(2000);
	  

// STEP 31 - ENTER CORRECTED CLAIM RECEIVED IN OUTGOING FIELD

//cr.enterCorrectedClaimReceivedInOutgoingFieldInTab1(driver);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-toggle='tooltip' and @data-ng-model='currentRecord.eobnote' and @data-ng-readonly='isAuditing']")));
driver.findElement(By.xpath("//input[@data-toggle='tooltip' and @data-ng-model='currentRecord.eobnote' and @data-ng-readonly='isAuditing']")).sendKeys("Corrected Claim received");
System.out.println("Entered Corrected Claim Received in Outgoing filed in 1- General");
Thread.sleep(2000);
	   

// STEP 32 - SCROLL UP


//cr.scrollUponTab1GeneralinCEV(driver);
driver.findElement(By.id("txtClaimPeriodStart")).sendKeys(Keys.PAGE_UP);
System.out.println ("scrollup");
Thread.sleep(2000);



// STEP 33 - SAVE CLAIM
clickSave(driver);



//PART 2 - CHANGE CORRECTED CLAIM
// STEP 34 - CLICK ON CORRECTED CLAIM (PDUPLSERVICE - adjudicate, approve and save it as acorrclaim)
   	   
//cr.clickOnPDuplServiceClaim(driver);

wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='PDuplService']")));
driver.findElement(By.xpath("//div[text()='PDuplService']")).click();
System.out.println("Clicked on PDuplService claim");
Thread.sleep(2000);
	   
//step 35 click adjudicate
adjudicateClaim( claimNo);

//step 36 change disposition to ACORRCLAIM
changeDisposition(claimNo);
}


}
/*else
{
	System.out.println("Given Claim number is not a Duplicate claim");
	driver.quit();
} 
}*/

public void changeDisposition( String claimno) throws Exception{
String oldDisposition= driver.findElement(By.xpath("//div[text()='"+claimno+"']/../../div/div")).getText();

System.out.println(claimno+"old disposition :" +oldDisposition);
if (oldDisposition.equalsIgnoreCase("Approved")) {

wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Edit")));
driver.findElement(By.linkText("Edit")).click();
System.out.println("Clicked Edit");
Log.info("log4j msg-clicked edit");

wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtManualDisposition']")));
driver.findElement(By.xpath("//input[@id='txtManualDisposition']")).sendKeys("ACORRCLAIM");
System.out.println("changed disposition");
Log.info("log4j msg-changed disposition");

wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Save")));
driver.findElement(By.linkText("Save")).click();
System.out.println("Clicked Save");
Log.info("log4j msg-clicked save");


}
else{
System.out.println("Duplicate claim is not approved after adjudication");
}

}

public void adjudicateClaim( String claimno) throws Exception{



String oldDisposition= driver.findElement(By.xpath("//div[text()='"+claimno+"']/../../div/div")).getText();

System.out.println(claimno+"old disposition :" +oldDisposition);
if (oldDisposition.equalsIgnoreCase("PUnprocessed")) {

wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Adjudicate")));
driver.findElement(By.linkText("Adjudicate")).click();
System.out.println("Clicked Adjudicate");
Log.info("log4j msg-clicked adjudicate");
driver.findElement(By.xpath("//button[@class='btn btn-primary btn-bottom02' and text()='Yes']")).click();
System.out.println("Clicked Yes to confirm Validation");
Log.info("log4j msg-clicked yes to confirm validation");


wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary btn-bottom02' and text()='OK']")));
driver.findElement(By.xpath("//button[@class='btn btn-primary btn-bottom02' and text()='OK']")).click();
System.out.println("Clicked ok to confirm no. of records adjudicated");
Log.info("log4j msg-clicked ok to confirm no. of records adjudicated");
BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
driver.quit();
}

else
{ System.out.println("Claim is already adjudicated"); 
Log.info("log4j msg-claim is already adjudicated"); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}

}



public void clickApprovedClaim(WebDriver y) throws InterruptedException
{
try{
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Approved']")));
y.findElement(By.xpath("//div[text()='Approved']")).click();

System.out.println("clicked on Original Approved claim ");
Log.info("log4j msg-clicked on original approved claim");
Thread.sleep(2000);
}
finally{
System.out.println("No Approved claim for this Pdupl claim");
Log.info("log4j msg-no approved claim");
}
}



public void clickAReversalClaim(WebDriver z) throws InterruptedException
{

wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='A-Reversal']")));

z.findElement(By.xpath("//div[text()='A-Reversal']")).click();
System.out.println("Clicked A-Reversal claim");
Log.info("log4j msg-clicked on A- Reversal claim");
Thread.sleep(2000);
}


public void clickEditMAMC(WebDriver a) throws InterruptedException{
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='Edit']")));
a.findElement(By.xpath("//span[.='Edit']")).click();
System.out.println("Clicked Edit");
Log.info("log4j msg-clicked edit");
Thread.sleep(2000);
}


public void clickReverse(WebDriver b) throws InterruptedException{

wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='Reverse']"))); 
b.findElement(By.xpath("//span[.='Reverse']")).click();
System.out.println("Clicked Reverse");
Log.info("log4j msg-clicked reverse");
Thread.sleep(2000);
}

public void enterReversalMsg (WebDriver c, String s) throws InterruptedException{

wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-ng-model='formData.reversalMessage']"))); 		 
c.findElement(By.xpath("//input[@data-ng-model='formData.reversalMessage']")).sendKeys(s);
Log.info("log4j msg-entered reversal msg");
Thread.sleep(2000);
}

public void enterReceivedDate(WebDriver d, String t) throws InterruptedException{
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='text' and @data-ng-blur='validateReceivedDate()']")));
d.findElement(By.xpath("//input[@type='text' and @data-ng-blur='validateReceivedDate()']")).sendKeys(t);
System.out.println(" Entered Received date");
Log.info("log4j msg-entered received date");
Thread.sleep(2000);
}


public void clickContinue(WebDriver e) throws InterruptedException{
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[.='Continue']")));
e.findElement(By.xpath("//button[.='Continue']")).click();
Log.info("log4j msg-clicked continue");
Thread.sleep(2000);
}



public void clickSave(WebDriver f) throws InterruptedException, WebDriverException{	   
try{
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Save")));

   if (f.findElement(By.linkText("Save")).isDisplayed()){


	   	f.findElement(By.linkText("Save")).click();
   		System.out.println("Clicked on Save");
   		Log.info("log4j msg-clicked save");
   		Thread.sleep(2000);
   		}
}
   catch (Exception e){
	   System.out.println("Not able to click 'save'.");
	   Log.info("log4j msg-not able to click save");
	      	}

}


public void clickManualCheckbox(WebDriver g) throws InterruptedException{
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@tabindex='5']")));
g.findElement(By.xpath("//input[@tabindex='5']")).click();
System.out.println("Clicked Manual checkbox");
Log.info("log4j msg-clicked manual");
Thread.sleep(2000);
}



public void clickTab5NotificationsAuditInfo(WebDriver h) throws InterruptedException{
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='#ClaimNotify' and @aria-controls='ClaimNotify']")));
h.findElement(By.xpath("//a[@href='#ClaimNotify' and @aria-controls='ClaimNotify']")).click();
System.out.println("Clicked on Tab 5 Notifications and Audit Info");
Log.info("log4j msg-clicked tab 5 for notifications and audit info");
Thread.sleep(2000);
}


public void enterRecordMarkR(WebDriver i) throws InterruptedException{
 
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='text' and @id='txtMark' and @data-ng-model='currentRecord.mark']")));
i.findElement(By.xpath("//input[@type='text' and @id='txtMark' and @data-ng-model='currentRecord.mark']")).sendKeys("R");
System.out.println("Entered R");
Log.info("log4j msg-entered R");
Thread.sleep(2000);
}


public void pageUpOnTab5CEV(WebDriver j){
 
 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-ng-model='currentRecord.claimNotices[0].appeal_acknowledged']")));
 j.findElement(By.xpath("//input[@data-ng-model='currentRecord.claimNotices[0].appeal_acknowledged']")).sendKeys(Keys.PAGE_UP);
 Log.info("log4j msg-page up");
}


public void clickTab2PaymentStatusNotes(WebDriver k) throws InterruptedException{

 k.findElement(By.xpath("//a[@href='#ClaimPayStatusNotes']")).click();
 System.out.println("Clicked Tab 2 Payment Status, Notes");
 Log.info("log4j msg-clicked tab 2 payment status, notes");
 Thread.sleep(2000);
}

public void enterAdjustmentReasonCodeERC01inTab2PaymentStatusNotes(WebDriver l) throws InterruptedException{
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='text' and @data-ng-model='currentRecord.userfield2']")));
l.findElement(By.xpath("//input[@type='text' and @data-ng-model='currentRecord.userfield2']")).sendKeys("ERC01");
System.out.println("Clicked on # 2 and entered ERC01");
Log.info("log4j msg-clicked on #2 and entered ERC01");
Thread.sleep(2000);
}

public String calculateNextCloseout()throws Exception{
Date dt = new Date();

Integer Dte=dt.getDate();
System.out.println("Dte "+ Dte);
Integer Month=dt.getMonth() ;
System.out.println("Month "+Month+1);
Integer Year=dt.getYear()+1900;
System.out.println("Year "+Year);
Integer Day=dt.getDay();
System.out.println("Day "+Day);

//String newcloseoutdate;

Calendar calendar1 = new GregorianCalendar(Year,Month,Dte);

if(Day==4) // if thursday today
{
calendar1.add(calendar1.DAY_OF_MONTH, 1);
System.out.println("Next closeout Date " + calendar1.getTime());
}

if(Day==5) // if friday today
{
calendar1.add(calendar1.DAY_OF_MONTH, 7);
System.out.println("Next closeout Date " + calendar1.getTime());
}

if(Day==6) // if satudary today
{
calendar1.add(calendar1.DAY_OF_MONTH, 6);
System.out.println("Next closeout Date " + calendar1.getTime());
} 
if(Day==7) // if sunday today
{
calendar1.add(calendar1.DAY_OF_MONTH, 5);
System.out.println("Next closeout Date " + calendar1.getTime());
}
if(Day==1) // if monday today
{
calendar1.add(calendar1.DAY_OF_MONTH, 4);
System.out.println("Next closeout Date " + calendar1.getTime());
}
if(Day==2) // if tuesday today
{
calendar1.add(calendar1.DAY_OF_MONTH, 3);
System.out.println("Next closeout Date " + calendar1.getTime());
}
if(Day==3) // if wednesday today
{
calendar1.add(calendar1.DAY_OF_MONTH, 2);
System.out.println("Next closeout Date " + calendar1.getTime());
}

DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
String nextcloseout= dateFormat.format(calendar1.getTime());
System.out.println(nextcloseout);
return nextcloseout;
}



}













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

public class MembersPage {

WebDriver driver;
WebDriverWait wait ;   
		
By customCodeBeginsInput = 	By.xpath("//input[@data-ng-model='filterOptions.userfield1']");

By searchButton = 			By.xpath("id('memberactivitymodal')/div[@class='inner-window']/div[@class='col-sm-12 search-container member-search-new']/div[@class='col-sm-10 col-md-12 col-lg-12 no-padding']/div[@class='col-sm-12 col-md-12 col-lg-3 first-col no-right-padding']/div[@class='col-sm-12']/div[@class='col-sm-6 no-padding']/button[@class='btn btn-primary']");

By nameInput =				By.xpath("//input[@id='txtSearchCode' and @data-ng-model='filterOptions.name']");

By dobInput = 				By.xpath("//input[@data-ng-model='filterOptions.dob']");

By ssnInput =				By.xpath("//input[@data-ng-model='filterOptions.ssn']");

By addLink = 				By.xpath("//a[@data-ng-click='addForm()']");

By addLastNameInput =		By.xpath("//input[@id='txtName']");

By addFirstNameInput = 		By.xpath("//input[@data-ng-model='currentRecord.first_name']");

By addCustomCodeInput= 		By.xpath("//input[@data-ng-model='currentRecord.userfield1']");

By addDOBInput = 			By.xpath("//input[@id='txtDob']");

By addSSNInput = 			By.xpath("//input[@data-ng-model='currentRecord.ssn']");

By addStreetAddressInput= 	By.xpath("//input[@data-ng-model='currentRecord.address']");

By addCityInput = 			By.xpath("//input[@data-ng-model='currentRecord.city']");

By addState= 				By.xpath("//select[@id='txtState']");

By addZIPInput = 			By.xpath("//input[@data-ng-model='currentRecord.zipcode']");

By clickCoverage = 			By.linkText("2 - Coverage");

By addCoverageButton = 		By.xpath("//button[@data-ng-click='tabMemberCoverage.add()']");

By addCoverageStartDate = 	By.xpath("//input[@id='effectivedate']");

By addCoverageEndDate = 	By.xpath("//input[@id='txtterminates']");

By addRelation= 			By.xpath("//select[@id='ddlrelation']");

By addPayerCode = 			By.xpath("//input[@id='txtpayor']");

By addCoverageSequenceNo = 	By.xpath("//input[@id='txtsequence']");

By addCoverageExtent = 		By.xpath("//select[@id='txtcovextent']");

By hideButton= 				By.xpath("//button[@data-ng-click='returnSelection()']");

By GeneralTab= 				By.linkText("1 - General");

By SaveLink= 				By.linkText("Save");

public MembersPage(WebDriver driver){
		this.driver= driver;
		this.wait= new WebDriverWait(driver, 50); 
	}

public void copyMember( String mid, String mlname, String mdob, String ssn, String newmid, String newname, String newdob, String newfname) throws Exception{
	try{
		
	//search member- search mid,mlastname, mdob
	
	int i= membersSearchMember(mid, mlname, mdob, ssn);
	//ok button
	
	if (i==1) {
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Copy")));
	driver.findElement(By.linkText("Copy")).click();
	System.out.println("clicked copy");
	Log.info("log4j msg- clicked copy");
	
	//make changes to mid, mfname, dob
	
	System.out.println("new first name:"+newname);
	//mfirstname
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtName")));
	driver.findElement(By.id("txtName")).clear();
	Thread.sleep(1000);
	driver.findElement(By.id("txtName")).sendKeys(newname);
	System.out.println("entered new last name");
	Log.info("log4j msg- entered new last name");
	
	
	
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-ng-model='currentRecord.first_name']")));
	driver.findElement(By.xpath("//input[@data-ng-model='currentRecord.first_name']")).clear();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@data-ng-model='currentRecord.first_name']")).sendKeys(newfname);
	System.out.println("entered new first name");
	Log.info("log4j msg- entered new first name");
	
	
	
	
	System.out.println("new mid:"+newmid);
	//mid
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-ng-model='currentRecord.userfield1']")));
	driver.findElement(By.xpath("//input[@data-ng-model='currentRecord.userfield1']")).clear();
	driver.findElement(By.xpath("//input[@data-ng-model='currentRecord.userfield1']")).sendKeys(newmid);
	System.out.println("entered new mid");
	Log.info("log4j msg- entered new mid");
	
	System.out.println("new dob:"+newdob);
	Thread.sleep(2000);
	//dob
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtDob")));
	driver.findElement(By.id("txtDob")).clear();
	driver.findElement(By.id("txtDob")).sendKeys(newdob);
	System.out.println("entered new dob");
	Log.info("log4j msg- entered new dob");
	Thread.sleep(2000);
	//save member
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Save")));
	driver.findElement(By.linkText("Save")).click();
	System.out.println("clicked save");
	Log.info("log4j msg- clicked save");
	
	Thread.sleep(2000);
	BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
	driver.quit();
	}
	else {System.out.println("member not found, cannot copy"); 
	Log.info("log4j msg- member not found, cannot copy");  
	BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
	driver.quit();
	}

	}catch(Exception e){e.printStackTrace(); 
	System.out.println("Error in copying member"); 
	Log.info("log4j msg- Error in copying member"); 
	BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
	driver.quit();
	}
	}

public void editMember( String mid, String mlname, String mdob, String ssn, String hicnid) throws Exception{
System.out.println("Edit member");
Log.info("log4j msg- Edit Member");
try{	
//search member
int i= membersSearchMember(mid, mlname, mdob, ssn);
		
	if (i==1) {
		System.out.println("Member found");
		Log.info("log4j msg- Member found");
		
		//click edit
	Thread.sleep(2000);
		
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Edit")));
	driver.findElement(By.linkText("Edit")).click();
	System.out.println("clicked Edit");
	Log.info("log4j msg- clicked edit");
	Thread.sleep(3000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-ng-model='currentRecord.userfield1']")));
	driver.findElement(By.xpath("//input[@data-ng-model='currentRecord.userfield1']")).sendKeys(Keys.PAGE_DOWN);
	System.out.println("clicked Page Down");
	Log.info("log4j msg- clicked page down");
	Thread.sleep(3000);
		
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-ng-model='currentRecord.hicN_ID']")));
	driver.findElement(By.xpath("//input[@data-ng-model='currentRecord.hicN_ID']")).sendKeys(hicnid);	
	
	System.out.println("entered new hicn id");
	Log.info("log4j msg- entered new hicn id");
	//click save
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Save")));
	driver.findElement(By.linkText("Save")).click();
	System.out.println("clicked save");
	Log.info("log4j msg- clicked save");
	Thread.sleep(1000);
	
	BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
	driver.quit();
	}
	else{System.out.println("Member not found, cannot edit"); 
	Log.info("log4j msg- Member not found, cannot edit"); 
	BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
	driver.quit();
	}
	
	

}catch(Exception e){ 
e.printStackTrace(); 
System.out.println("error in editing member"); 
Log.info("log4j msg- error in editing member"); 
BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
driver.quit();
}

}

public void deleteMember( String mid, String mLastName, String mFirstName, String mdob, String ssn, String maddr, String mcity, String mstate, String mzip) throws Exception{
	try{
	int i= membersSearchMember(mid, mLastName, mdob, ssn);
	Log.info("log4j msg- click search");
		
	if (i==1) {
		System.out.println("Member found");
		Log.info("log4j msg- Member found");
		Thread.sleep(2000);
	//click delete
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-ng-click='delete()']")));
		driver.findElement(By.xpath("//a[@data-ng-click='delete()']")).click();
		System.out.println("clicked delete");
		Log.info("log4j msg- clicked delete");
		Thread.sleep(2000);	
		//confirm delete
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary btn-bottom02']")));
		driver.findElement(By.xpath("//button[@class='btn btn-primary btn-bottom02']")).click();
		System.out.println("clicked Yes to confirm delete");
		Log.info("log4j msg- clicked Yes to confirm delete");
		Thread.sleep(2000);
	BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
driver.quit();	
	
	}
		
		else {System.out.println("Member not found, cannot delete");
		Log.info("log4j msg- Member not found, cannot delete");
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit();
		}

	}catch(Exception e){ 
		e.printStackTrace(); 
		System.out.println("error in member delete");
	Log.info("log4j msg- error in member delete");
	BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
	driver.quit();
	}
	}


public void exitMember( String mid, String mlname, String mdob, String ssn) throws Exception{
	try{
	int i = membersSearchMember( mid, mlname, mdob, ssn);
	if (i==1){
		System.out.println("Member found");
		Log.info("log4j msg- Member found");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Exit")));
		driver.findElement(By.linkText("Exit")).click();
		System.out.println("Clicked on exit");
		Log.info("log4j msg- Clicked on exit");
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit();
		}

	else
		{
		System.out.println("Member not found");
		Log.info("log4j msg- member not found");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Exit")));
		driver.findElement(By.linkText("Exit")).click();
		System.out.println("Clicked on exit");
		Log.info("log4j msg- Clicked on exit");
		
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit();
		}

	}catch(Exception e){ System.out.println("error in member exit");
	Log.info("log4j msg- error in member exit");
	
	BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
	driver.quit();
	}
	}

public int membersSearchMember( String mid, String mlname, String mdob, String ssn)throws Exception{
	System.out.println("mlname:"+mlname+",mdob:"+mdob+",mid:"+mid+",ssn:"+ssn);
	try{	
		
		if (mid.isEmpty()){System.out.println("No more data to test"); driver.quit(); return 0;}
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
	Thread.sleep(2000);
	
	//enter  mid
		wait.until(ExpectedConditions.visibilityOfElementLocated(customCodeBeginsInput));
		driver.findElement(customCodeBeginsInput).sendKeys(mid);
		System.out.println("entered mid");
		Log.info("log4j msg- entered mid");
		Thread.sleep(2000);
		
	
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(ssnInput));
	driver.findElement(ssnInput).sendKeys(ssn);
	System.out.println("entered ssn");
	Log.info("log4j msg- entered ssn");
		Thread.sleep(2000);
		
	wait.until(ExpectedConditions.visibilityOfElementLocated(searchButton));
	driver.findElement(searchButton).click();
	System.out.println("clicked on search");
	Log.info("log4j msg- clicked search");
	Thread.sleep(2000);
	//click on mid
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and contains(text(), '"+mid+"')]")));
	driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()= '"+mid+"']")).click();
		System.out.println("clicked on member");
		Log.info("log4j msg- Found member, clicked on member");
		return 1;
		}
	}catch (Exception e){System.out.println("Member Not found with the given Custom code, Last name and DOB");
	Log.info("log4j msg- Member Not found with the given Custom code, Last name and DOB");
	return 0;}

}

public void memberAddCommunication( String mid, String mlname, String mdob, String ssn, String subject, String noteType, String details) throws Exception{
//search member
//add communication
	try{
	int i = membersSearchMember( mid, mlname, mdob, ssn);
	if (i==1){
		System.out.println("Member found");
		Log.info("log4j msg- Member found");
	
	
	
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Commun.")));
	driver.findElement(By.linkText("Commun.")).click();
	System.out.println("clicked Communication");
	Log.info("log4j msg- clicked communication");
	

	
	
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")));
	driver.findElement(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")).click();
	System.out.println("Clicked add");
	Log.info("log4j msg- clicked ADD");
	
	
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@id='txtSubject' and @data-ng-model='currentRecord.subject']")).sendKeys(subject);
	System.out.println("entered subject");
	Log.info("log4j msg- entered subject");
	Thread.sleep(5000);
	driver.findElement(By.xpath("//textarea[@tabindex='9']")).sendKeys(Keys.PAGE_DOWN);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(.,'Add')]")));
	driver.findElement(By.xpath("//button[contains(.,'Add')]")).click();
	System.out.println("clicked add");
	Log.info("log4j msg- clicked add");
	
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlNoteType")));
	Select notetypes=new Select(driver.findElement(By.id("ddlNoteType")));

	Thread.sleep(3000);
//notetypes.selectByValue(noteType);
notetypes.selectByVisibleText(noteType);
System.out.println("selected notetype");
Log.info("log4j msg- selected notetype");
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='txtNotes']")));
driver.findElement(By.xpath("//textarea[@id='txtNotes']")).sendKeys(details);
Thread.sleep(2000);
System.out.println("entered comm details");
Log.info("log4j msg- clicked comm details");
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-ng-click='closeMe()']")));
driver.findElement(By.xpath("//button[@data-ng-click='closeMe()']")).click();
System.out.println("clicked on hide");
Log.info("log4j msg- clicked on hide");
Thread.sleep(2000);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-ng-click='closeCase()']")));
driver.findElement(By.xpath("//button[@data-ng-click='closeCase()']")).click();

System.out.println("clicked on close case");
Log.info("log4j msg- clicked on close case");
Thread.sleep(2000);
driver.findElement(By.linkText("Save")).click();
System.out.println("clicked on save");
Log.info("log4j msg- clicked on save");
BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
driver.quit();

	}
	else
	{
	System.out.println("Member not found");
	Log.info("log4j msg- member not found");
	BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
	driver.quit();

	}



	
	}catch(Exception e){ e.printStackTrace(); System.out.println("error in member -add comm");
	Log.info("log4j msg- error in member -add comm");
	BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
	driver.quit();
	}
	}
	


public void addMember( String mid, String mlname, String mfname, String mdob, String ssn, String maddress,String mcity, String mstate, String mzip, String coverageEffectivePeriod, String relationToSubscriber,String payerCode, String coverageSequence, String coverageExtent) throws Exception{
	try{
	//Check if memb already exists with mid, dob, name
	int i= membersSearchMember( mid, mlname, mdob, ssn);

	if (i==1) {System.out.println("member is already present in the system, cannot add");
	Log.info("log4j msg- member is already present, cannot add");
	BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();
	}
	
	//If no Records returned- add member
	
	else {
		System.out.println("Adding member");	
		Log.info("log4j msg- adding member");
		Thread.sleep(2000);
	//click add
		wait.until(ExpectedConditions.visibilityOfElementLocated(addLink));
		driver.findElement(addLink).click();
		System.out.println("clicked add");
		Log.info("log4j msg- clicked add");
	//click page down
	//click customcode and click page down
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(addLastNameInput));
		driver.findElement(addLastNameInput).sendKeys(Keys.PAGE_DOWN);
		System.out.println("page down");
		Log.info("log4j msg- page down");
		Thread.sleep(2000);
	//Enter Last Name
		wait.until(ExpectedConditions.visibilityOfElementLocated(addLastNameInput));
		driver.findElement(addLastNameInput).sendKeys(mlname);
		System.out.println("entered lastname");
		Log.info("log4j msg- entered lastname");
	
		Thread.sleep(2000);
	//Enter First Name
		wait.until(ExpectedConditions.visibilityOfElementLocated(addFirstNameInput));
		driver.findElement(addFirstNameInput).sendKeys(mfname);
		System.out.println("entered firstname");
		Log.info("log4j msg- entered firstname");
		
	//Click customer code (or click tab, tab)- Enter Customer Code 
		wait.until(ExpectedConditions.visibilityOfElementLocated(addCustomCodeInput));
		driver.findElement(addCustomCodeInput).sendKeys(mid);
		System.out.println("entered mid");
		Log.info("log4j msg- entered mid");
		Thread.sleep(2000);
	//Click Birthdate (click tab, tab) -Enter Birthdate mmddyyyy, click tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(addDOBInput));
		driver.findElement(addDOBInput).sendKeys(mdob);
		System.out.println("entered dob");
		Log.info("log4j msg- entered dob");
		
	//enter ssn	
		wait.until(ExpectedConditions.visibilityOfElementLocated(addSSNInput));
		driver.findElement(addSSNInput).sendKeys(ssn);
		System.out.println("entered ssn");
		Log.info("log4j msg- entered ssn");
		
		Thread.sleep(2000);
	//Click Address- Enter street Address click tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(addStreetAddressInput));
		driver.findElement(addStreetAddressInput).sendKeys(maddress);
		System.out.println("entered street address");
		Log.info("log4j msg- entered street address");
	//Enter City- click tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(addCityInput));
		driver.findElement(addCityInput).sendKeys(mcity);
		System.out.println("entered city");
		Log.info("log4j msg- entered city");
	//Pick State click tab
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(addState));
		Select selectState=new Select(driver.findElement(addState));
		//selectState.selectByVisibleText(mstate);
		//selectState.selectByIndex(32);
		selectState.selectByValue(mstate);
		System.out.println("entered state");
		Log.info("log4j msg- entered state");
	//Enter zip code click tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(addZIPInput));
		driver.findElement(addZIPInput).sendKeys(mzip);
		System.out.println("entered zip");
		Log.info("log4j msg- entered zip");
		Thread.sleep(2000);
	//Click tab2- coverage
		wait.until(ExpectedConditions.visibilityOfElementLocated(clickCoverage));
		driver.findElement(clickCoverage).click();
		System.out.println("click coverage tab");
		Log.info("log4j msg- click coverage tab");
		Thread.sleep(2000);
	//Click add at the bottom
		wait.until(ExpectedConditions.visibilityOfElementLocated(addCoverageButton));
		driver.findElement(addCoverageButton).click();
		System.out.println("click add button to add coverage");
		Log.info("log4j msg- click add button to add coverage");
	//MEMBER COVERAGE- General Coverage Specs
		Thread.sleep(2000);
	//enter effective period mmddyyyy click tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(addCoverageStartDate));
		driver.findElement(addCoverageStartDate).sendKeys(coverageEffectivePeriod);
		System.out.println("enter coverage start date");
		Log.info("log4j msg- enter coverage start date");
	//coverage ends- period is filled as 12/31/9999 click tab
		Thread.sleep(2000);
		driver.findElement(addCoverageEndDate).sendKeys(Keys.TAB);
		System.out.println("click tab to autofill coverage end date");
		Log.info("log4j msg- click tab to autofill coverage end date");
	//Relation to subscriber pick SELF (default) click tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(addRelation));
		Select selectRelationToSubscriber=new Select(driver.findElement(addRelation));
		selectRelationToSubscriber.selectByVisibleText(relationToSubscriber);
		System.out.println("select relation to subscriber");
		Log.info("log4j msg- select relation to subscriber");
	//Enter Payer code click tab (key the starting letter, hit tab, select the payer code on the new window, Return Selection) 
		wait.until(ExpectedConditions.visibilityOfElementLocated(addPayerCode));
		driver.findElement(addPayerCode).sendKeys(payerCode);
		System.out.println("enter payer code");
		Log.info("log4j msg- enter payer code");
	//Enter coverage sequence#(?) click tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(addCoverageSequenceNo));
		driver.findElement(addCoverageSequenceNo).sendKeys(coverageSequence);
		System.out.println("enter coverage sequence number");
		Log.info("log4j msg- enter coverage sequence number");
	//Pick Coverage extent (IND, SPOUSE, FAMILY, CHILDREN)click tab
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(addCoverageExtent));
		Select selectCoverageExtent=new Select(driver.findElement(addCoverageExtent));
		selectCoverageExtent.selectByVisibleText(coverageExtent);
		System.out.println("enter coverage extent");
		Log.info("log4j msg- enter coverage extent");
		//pull the screen up
		WebElement element1=driver.findElement(By.xpath("//input[@data-ng-model='record.coB_beneficiary_SSN']"));
		Actions builder = new Actions(driver); 
		element1.click();
		builder.dragAndDropBy(element1, 0,-300).build().perform();
		System.out.println("click and drag the window so that Hide button is visible");
		Log.info("log4j msg- click and drag the window so that Hide button is visible");
		Thread.sleep(2000);
	//click hide
		wait.until(ExpectedConditions.visibilityOfElementLocated(hideButton));
		driver.findElement(hideButton).click();
		System.out.println("click hide button");
		Log.info("log4j msg- click hide button");
		
		//click general tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(GeneralTab));
		driver.findElement(GeneralTab).click();
		System.out.println("click General Tab");
		Log.info("log4j msg- click General Tab");
		
		//click on firstname
		wait.until(ExpectedConditions.visibilityOfElementLocated(addFirstNameInput));
		driver.findElement(addFirstNameInput).click();
		System.out.println("click add firstname input");
		Log.info("log4j msg- click add firstname input");
		//click pageup
		
		driver.findElement(addFirstNameInput).sendKeys(Keys.PAGE_UP);
		System.out.println("page up");
		Log.info("log4j msg- page up");
		Thread.sleep(2000);
		//Click save
		wait.until(ExpectedConditions.visibilityOfElementLocated(SaveLink));
		driver.findElement(SaveLink).click();
		System.out.println("click save");
		Log.info("log4j msg- click save");
		Thread.sleep(2000);
		
	//taking a screenshot
		System.out.println("Take a screenshot");
		Log.info("log4j msg- Take a screenshot");
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();
	} 
	}catch(Exception e){System.out.println("Take a screenshot");
	Log.info("log4j msg- Take a screenshot");
	BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();}
	}

}


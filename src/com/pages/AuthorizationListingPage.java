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

public class AuthorizationListingPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	By addAuth =				By.xpath("//a[@id='add' and @data-ng-click='addForm()']");

	By customCodeBeginsInput = 	By.xpath("//input[@data-ng-model='filterOptions.userfield1']");
	
	By searchButton = 			By.xpath("id('memberactivitymodal')/div[@class='inner-window']/div[@class='col-sm-12 search-container member-search-new']/div[@class='col-sm-10 col-md-12 col-lg-12 no-padding']/div[@class='col-sm-12 col-md-12 col-lg-3 first-col no-right-padding']/div[@class='col-sm-12']/div[@class='col-sm-6 no-padding']/button[@class='btn btn-primary']");
		
	By nameInput =				By.xpath("//input[@id='txtSearchCode' and @data-ng-model='filterOptions.name']");

	By dobInput = 				By.xpath("//input[@data-ng-model='filterOptions.dob']");

	By ssnInput = 				By.xpath("//input[@data-ng-model='filterOptions.ssn']");
	
	By CertNoInput=				By.xpath("//input[@id='txtSearchCode' and @data-ng-model='filterOptions.systemkey']"); 

	By ProviderBeginsInput = 	By.xpath("//input[@data-ng-model='filterOptions.provider']");
	
	By TreatmentFirstDayInput = By.xpath("//input[@data-ng-model='filterOptions.date']");
	
	By DispositionInput = 		By.xpath("input[@data-ng-model='filterOptions.dispositn']");
	
	By AuthListingSearch = 		By.xpath("//button[@class='btn btn-primary']");
	
	By Modifier1 = By.xpath("//input[@data-ng-model='refCert2.modifier']");
	
	By Modifier2 = By.xpath("//input[@data-ng-model='refCert2.modifier2']");
	
	By Modifier3 = By.xpath("//input[@data-ng-model='refCert2.modifier3']");
	
	public AuthorizationListingPage(WebDriver driver){
		this.driver= driver;
		 this.wait= new WebDriverWait(driver, 20);
	}

	
	
	// Search for Authorization
	public int searchAuth(String certNo, String pNPI) throws Exception{
		
		
		//enter cert no
		wait.until(ExpectedConditions.visibilityOfElementLocated(CertNoInput));
		driver.findElement(CertNoInput).sendKeys(certNo);
		System.out.println("entered Cert No");
		Log.info("log4j msg- entered Cert No");
		Thread.sleep(1000);
		
		//enter provider begins
		wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderBeginsInput));
		driver.findElement(ProviderBeginsInput).sendKeys(pNPI);
		System.out.println("entered provider NPI");
		Log.info("log4j msg- entered provider NPI");
		Thread.sleep(1000);
		
		//click search
		wait.until(ExpectedConditions.visibilityOfElementLocated(AuthListingSearch));
		driver.findElement(AuthListingSearch).click();
		System.out.println("clicked search");
		Log.info("log4j msg--clicked search");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope']/parent::div/following-sibling::div/div")));
		System.out.println(driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope']/parent::div/following-sibling::div/div")).getText());
		if (driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope']/parent::div/following-sibling::div/div")).getText().equals(certNo))
		return 1;
		
		else
			return 0;
	}
	
	
	
	//search for member
	public int AEVSearchMember(String mid, String mlname, String mdob, String ssn)throws Exception{
		System.out.println("mlname:"+mlname+",mdob:"+mdob+",mid:"+mid+",ssn:"+ssn);
		try{	
			
			if (mid.isEmpty()){System.out.println("No Data"); driver.quit(); return 0;}
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
				Thread.sleep(1000);
			
		
				// enter ssn
				wait.until(ExpectedConditions.visibilityOfElementLocated(ssnInput));
				driver.findElement(ssnInput).sendKeys(ssn);
				System.out.println("entered ssn");
				Log.info("log4j msg- entered ssn");
				Thread.sleep(1000);
			
				//click search
				wait.until(ExpectedConditions.visibilityOfElementLocated(searchButton));
				driver.findElement(searchButton).click();
				System.out.println("clicked on search");
				Log.info("log4j msg- clicked search");
				Thread.sleep(2000);
		
				//click on mid
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and contains(text(), '"+mid+"')]")));
				driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()= '"+mid+"']")).click();
				System.out.println("Found member, clicked on member");
				Log.info("log4j msg- Found member, clicked on member");
			
			
				Thread.sleep(2000);
				//click Return Selection
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Return Selection")));
				driver.findElement(By.linkText("Return Selection")).click();
				System.out.println("clicked Return Selection");
				Log.info("log4j msg- clicked Return Selection");
				
				return 1;
			
			
			}
		}catch (Exception e){
			System.out.println("Timeout Exception occured, No Such Element Found in search, member Not found with the given Custom code, Last name and DOB");
			return 0;
		}

	}

	//add authorization 
	public String AEVaddAuth( String mid, String mlname, String mfname, String mdob, String mssn, String refReason,String caseManager,String npi,String taxID,String pname, String paddr,String pspeciality, String pos, String icdCode, String refCertType, String treatmentPeriodEndDate, String printedProcessedDate, String pFollowupDate, String extensionDate, String serviceSet, String modifier1, String modifier2, String modifier3) throws Exception{
		try{
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(addAuth));
		driver.findElement(addAuth).click();
		System.out.println("clicked Add Authentication");
		Log.info("log4j msg- Clicked Add Authentication");
		
		//search for member
		int i=AEVSearchMember( mid, mlname, mdob, mssn);
		
		if (i==1){
			
			//select Referral reason
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@data-ng-model='referralCertification.refreason']")));
			Select referralReason=new Select(driver.findElement(By.xpath("//select[@data-ng-model='referralCertification.refreason']")));
			referralReason.selectByVisibleText(refReason);
			System.out.println("selected Referral Reason");
			Log.info("log4j msg-selected Referral Reason");
			
			Thread.sleep(2000);
			//select certifying case manager
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@data-ng-model='referralCertification.casemgr']")));
			Select certifyingCaseManager=new Select(driver.findElement(By.xpath("//select[@data-ng-model='referralCertification.casemgr']")));
			//certifyingCaseManager.selectByVisibleText(caseManager);
			certifyingCaseManager.selectByIndex(1);
			System.out.println("selected Certifying Case Manager");
			Log.info("log4j msg-selected Certifying Case Manager");
			
			Thread.sleep(2000);
			//enter provider details
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='?']")));
			driver.findElement(By.xpath("//button[text()='?']")).click();
			Log.info("log4j msg-clicked ?");
			System.out.println("Cliked ?");
			Thread.sleep(2000);
			//enter npi
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtSearchCode' and @data-ng-model='filterOptionsnew.NPI']")));
			WebElement ProviderNPI= driver.findElement(By.xpath("//input[@id='txtSearchCode' and @data-ng-model='filterOptionsnew.NPI']"));
			ProviderNPI.sendKeys(npi);
			Log.info("log4j msg-entered npi");
			System.out.println("entered npi");
			Thread.sleep(2000);
			//click search
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@ng-click='getClaimProviderLookup()' and text()='Search']")));
			WebElement SearchButton= driver.findElement(By.xpath("//button[@ng-click='getClaimProviderLookup()' and text()='Search']"));
			SearchButton.click();
			Log.info("log4j msg-clicked search");
			System.out.println("clicked search");
			Thread.sleep(2000);
			//check provider tin
			System.out.println("Getting Provider - Organization TIN combination data list now");
			Thread.sleep(2000);
			List <WebElement> dateBox1 = driver.findElements(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope']/ancestor::div[@class='ui-grid-cell ng-scope ui-grid-disable-selection ui-grid-coluiGrid-00ES']//following-sibling::div//div"));
		    for (WebElement webElement : dateBox1) {
		    System.out.println(webElement.getText());
		    }     
		    Thread.sleep(2000);
			//click ok
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-secondary btn-bottom01 pull-right' and @ng-click='getProviderAddress()']")));
		    WebElement ClickOk= driver.findElement(By.xpath("//button[@class='btn btn-secondary btn-bottom01 pull-right' and @ng-click='getProviderAddress()']"));
		    ClickOk.click();
		    System.out.println("clicked  ok");
		    Log.info("log4j msg-clicked ok");
		    
		    Thread.sleep(2000);
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@ng-click='providerLookupAddressokbuttonclick()']")));
		    WebElement ClickOk2= driver.findElement(By.xpath("//button[@ng-click='providerLookupAddressokbuttonclick()']"));
			ClickOk2.click();
			System.out.println("clicked  ok");
			Log.info("log4j msg-clicked ok");
			
			Thread.sleep(2000);
			//page down
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-ng-model='referralCertification.extension']")));
			WebElement referralCertificationExtension= driver.findElement(By.xpath("//input[@data-ng-model='referralCertification.extension']"));
			referralCertificationExtension.sendKeys(Keys.PAGE_DOWN);
			System.out.println("pagedown");
			
			Thread.sleep(2000);	
			//select place of service
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@data-ng-model='referralCertification.placeserv']")));
			Select placeOfService = new Select(driver.findElement(By.xpath("//select[@data-ng-model='referralCertification.placeserv']")));
			placeOfService.selectByVisibleText(pos);
			Log.info("log4j msg-selected place of service");
			System.out.println("selected place of service");
			
			Thread.sleep(2000);
			//enter icd code
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-ng-model='referralCertification.icd1']")));
			WebElement ICDCode= driver.findElement(By.xpath("//input[@data-ng-model='referralCertification.icd1']"));
			ICDCode.sendKeys(icdCode);
			Log.info("log4j msg-entered icd code");
			System.out.println("entered icd code");
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-ng-model='referralCertification.adminnote']")));
			WebElement OutgoingField= driver.findElement(By.xpath("//input[@data-ng-model='referralCertification.adminnote']"));
			OutgoingField.sendKeys(Keys.PAGE_UP);
			Log.info("log4j msg- page up");
			System.out.println("page up");
				
			Thread.sleep(3000);	
			//Referral/ Cert Type- auto populated- Original
				
			//Click Manual check box
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-ng-model='referralCertification.manual']")));
			WebElement manualCheckbox= driver.findElement(By.xpath("//input[@data-ng-model='referralCertification.manual']"));
			manualCheckbox.click();		
			Log.info("log4j msg-clicked manual check box");
			System.out.println("clicked manual check box");
			Thread.sleep(5000);
			
			//Disposition is auto populated- Approved
				
			//Treatment period- today's date to enter a future  date
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='terminatedate']")));
			WebElement enterTreatmentPeriodEndDate= driver.findElement(By.xpath("//input[@id='terminatedate']"));
			enterTreatmentPeriodEndDate.sendKeys(treatmentPeriodEndDate);
			Log.info("log4j msg-entered treatment period end date");
			System.out.println("entered treatment period end date");
			Thread.sleep(5000);
				
			//Printed or Processed date - today's date
			System.out.println("printed/processed date:"+printedProcessedDate);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-ng-model='referralCertification.processed']")));
			WebElement enterProcessedDate= driver.findElement(By.xpath("//input[@data-ng-model='referralCertification.processed']"));
			enterProcessedDate.sendKeys(printedProcessedDate);
			Log.info("log4j msg-entered Printed/Processed date");
			System.out.println("entered Printed/Processed date");
				
			Thread.sleep(3000);
			
			//Provider followup- today's date
			System.out.println("provider followup date:"+pFollowupDate);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-ng-model='referralCertification.followup']")));
			WebElement enterProviderFollowupDate= driver.findElement(By.xpath("//input[@data-ng-model='referralCertification.followup']"));
			enterProviderFollowupDate.sendKeys(pFollowupDate);
			Log.info("log4j msg-entered Provider Followup date");
			System.out.println("entered Provider Followup date");
			
			Thread.sleep(3000);
			//try to enter followup date again				
			try{
				WebElement enterProviderFollowupDate1= driver.findElement(By.xpath("//button[@class='btn btn-primary btn-bottom02' and text()='OK']"));
					driver.findElement(By.xpath("//button[@class='btn btn-primary btn-bottom02' and text()='OK']")).click();
					System.out.println("clicked ok");
					Log.info("log4j msg- clicked ok");
					
					enterProviderFollowupDate1.sendKeys(pFollowupDate);
					Log.info("log4j msg-entered Provider Followup date");
					System.out.println("entered Provider Followup date");
					
			}catch (Exception e){ 
				System.out.println("Provider Followup entered ");Log.info("log4j msg-Provider Followup entered ");}
				
				
			Thread.sleep(2000);	
			//Extension- a future date
			System.out.println("extension date:"+extensionDate);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-ng-model='referralCertification.extension']")));

			WebElement enterExtensionDate= driver.findElement(By.xpath("//input[@data-ng-model='referralCertification.extension']"));
			enterExtensionDate.sendKeys(extensionDate);
			Log.info("log4j msg-entered Extension date");
			System.out.println("entered Extension date");
			
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary btn-bottom02' and text()='OK']")));
			driver.findElement(By.xpath("//button[@class='btn btn-primary btn-bottom02' and text()='OK']")).click();
			System.out.println("clicked ok");
			Log.info("log4j msg- clicked ok");
			
			enterExtensionDate.sendKeys(extensionDate);
			Log.info("log4j msg-entered Extension date");
			System.out.println("entered Extension date");
			
		}catch (Exception e){ System.out.println("Exception in entering extension date 2nd time ");Log.info("log4j msg- Exception  in entering Extension date 2nd time");}
			
		Thread.sleep(3000);
			//click add at the bottom 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-ng-click='addRefCert2()']")));

			WebElement addButton= driver.findElement(By.xpath("//button[@data-ng-click='addRefCert2()']"));
			addButton.click();
			Log.info("log4j msg-clicked add");
			System.out.println("clicked add");
			Thread.sleep(3000);
			
			Thread.sleep(2000);
			//click service set- pick one from drop down
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@data-ng-model='refCert2.serviceset']")));

			Select ServiceSet=new Select(driver.findElement(By.xpath("//select[@data-ng-model='refCert2.serviceset']")));
			//ServiceSet.selectByVisibleText(serviceSet);
			ServiceSet.selectByIndex(1);
			System.out.println("selected Service set");
			Log.info("log4j msg-selected Service set");
				
			Thread.sleep(3000);
				
			
			//enter modifier 1
			wait.until(ExpectedConditions.visibilityOfElementLocated(Modifier1));
			driver.findElement(Modifier1).sendKeys(modifier1);
			System.out.println("entered modifier 1");
			Log.info("log4j msg-entered modifier 1");
				
			Thread.sleep(3000);
			//enter modifier 2
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(Modifier2));
			driver.findElement(Modifier2).sendKeys(modifier2);
			System.out.println("entered modifier 2");
			Log.info("log4j msg-entered modifier 2");
			
			//enter modifier 3
			wait.until(ExpectedConditions.visibilityOfElementLocated(Modifier3));
			driver.findElement(Modifier3).sendKeys(modifier3);
			System.out.println("entered modifier 3");
			Log.info("log4j msg-entered modifier 3");
			
			
			//click check
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-ng-click='refcer2_Adjudicate()']")));

			WebElement checkButton= driver.findElement(By.xpath("//button[@data-ng-click='refcer2_Adjudicate()']"));
			checkButton.click();
			Log.info("log4j msg-clicked check");
			System.out.println("clicked check");
			Thread.sleep(3000);
				
			//click No for duplicate	
			try{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-secondary btn-bottom02' and text()='No']")));

					WebElement DuplicateNo= driver.findElement(By.xpath("//button[@class='btn btn-secondary btn-bottom02' and text()='No']"));
					DuplicateNo.click();
					Log.info("log4j msg-Clicked No for Duplicate yes/no question");
					System.out.println("Clicked No for Duplicate yes/no question");
					
				}catch(Exception e) {System.out.println("");}
				
				Thread.sleep(3000);
				
				try{
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-secondary btn-bottom02' and text()='Yes']")));

					WebElement AuthorizationOverlapsYes = driver.findElement(By.xpath("//button[@class='btn btn-secondary btn-bottom02' and text()='Yes']"));
					AuthorizationOverlapsYes.click();
					Log.info("log4j msg-Clicked Yes for Authorization Overlaps - Is this ok?");
					System.out.println("Clicked Yes for Authorization Overlaps - Is this ok?");
					
				}catch (Exception e){System.out.println("");}
				Thread.sleep(3000);
				//click hide
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-ng-click='closeMe()']")));

				WebElement HideButton= driver.findElement(By.xpath("//button[@data-ng-click='closeMe()']"));
				HideButton.click();
				Log.info("log4j msg-clicked Hide");
				System.out.println("clicked Hide");
				
				Thread.sleep(3000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-ng-model='referralCertification.eobnote']")));

				//click on outgoing- for pageup
				WebElement Outgoing= driver.findElement(By.xpath("//input[@data-ng-model='referralCertification.eobnote']"));
				Outgoing.sendKeys(Keys.PAGE_UP);
				Log.info("log4j msg-clicked Page Up");
				System.out.println("clicked Page Up");
			Thread.sleep(3000);
				
				//click validate
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Validate")));

				WebElement Validate= driver.findElement(By.linkText("Validate"));
				Validate.click();
				Log.info("log4j msg-clicked Validate");
				System.out.println("clicked Validate");
				Thread.sleep(3000);
				
				try{
					
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-bb-handler='No' and @class='btn btn-secondary btn-bottom02']")));
					WebElement clickNo= driver.findElement(By.xpath("//button[@data-bb-handler='No' and @class='btn btn-secondary btn-bottom02']"));
					clickNo.click();
					Log.info("log4j msg-clicked No for duplicate question");
					System.out.println("clicked No for duplicate question");
				} catch(Exception e){System.out.println("");}
				
				Thread.sleep(3000);
				try{
				//click ok--All Edited Records are valid. This Record(set) may be saved.
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-bb-handler='Success']")));
				WebElement clickOK= driver.findElement(By.xpath("//button[@data-bb-handler='Success']"));
				clickOK.click();
				Log.info("log4j msg-clicked ok");
				System.out.println("clicked ok");
				}catch(Exception e){
					System.out.println(" "); 
					Log.info(" ");
					}
				
				
				Thread.sleep(3000);
				
				//click save
				try{
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Save")));

				WebElement clickSave= driver.findElement(By.linkText("Save"));
				clickSave.click();
				Log.info("log4j msg-clicked save");
				System.out.println("clicked save");
				Thread.sleep(5000);
				}
				catch(Exception e) {System.out.println("Unable to click save");Log.info("unable to click save");BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();}
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@class='control-label record-info pull-right ng-binding']")));
				String newAuthCode= driver.findElement(By.xpath("//label[@class='control-label record-info pull-right ng-binding']")).getText();
				System.out.println("new Auth code="+newAuthCode);
				Log.info("log4j msg-new Auth code="+newAuthCode);
				
				Thread.sleep(3000);
			
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();
	
				return newAuthCode;
				
				}
				else {
			
					System.out.println("Member not found, Cannot Add Authorization");
					Log.info("Member not found, Cannot Add Authorization");			
					BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();
				
					return null;
				}
		
		}catch(Exception e){
			e.printStackTrace(); 
			System.out.println("error in Adding Auth"); 
			Log.info("error in Adding Auth"); 
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
			driver.quit();  
			return null;
			}
	
	}
			
		
	
	
		
	public void AEVaddComm(String mid, String mlname, String mfname, String mdob, String mssn, String refCertNo, String providerName, String subject, String noteType, String details) throws Exception {
		try{
			int j=searchAuth( refCertNo, providerName);
			if (j==1){
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Commun.")));
				driver.findElement(By.linkText("Commun.")).click();
				System.out.println("clicked Communication");
				Log.info("log4j msg- clicked communication");
				System.out.println("clicking on  add  using katalon xpath");
		
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/img[1]")));
				WebElement e= driver.findElement(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/img[1]"));
				Actions action=new Actions(driver);
				action.moveToElement(e).click().perform();
				
				Thread.sleep(2000);
				System.out.println("Clicked add at the top");
				Log.info("log4j msg-clicked add at the top");
				Thread.sleep(2000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtSubject' and @data-ng-model='currentRecord.subject']")));
				driver.findElement(By.xpath("//input[@id='txtSubject' and @data-ng-model='currentRecord.subject']")).sendKeys(subject);
				System.out.println("entered subject");
				Log.info("log4j msg-entered subject");
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@tabindex='9']")));
				driver.findElement(By.xpath("//textarea[@tabindex='9']")).sendKeys(Keys.PAGE_DOWN);
				
				Thread.sleep(3000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("id('tabGeneral')/div[@class='row']/div[@class='col-lg-12 col-md-12 col-sm-12 col-xs-12 button-wrap']/div[@class='col-lg-10 col-md-10 col-sm-12 col-xs-12 no-padding text-right pull-right']/button[@class='btn btn-primary btn-bottom01' and @data-ng-click='addChildRecord()']")));
				driver.findElement(By.xpath("id('tabGeneral')/div[@class='row']/div[@class='col-lg-12 col-md-12 col-sm-12 col-xs-12 button-wrap']/div[@class='col-lg-10 col-md-10 col-sm-12 col-xs-12 no-padding text-right pull-right']/button[@class='btn btn-primary btn-bottom01' and @data-ng-click='addChildRecord()']")).click();
				System.out.println("clicked add");
				Log.info("log4j msg-clicked add");
		
				Thread.sleep(5000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlNoteType")));
				Select notetypes=new Select(driver.findElement(By.id("ddlNoteType")));
				Thread.sleep(3000);
				System.out.println("note type:"+ noteType);
				notetypes.selectByVisibleText(noteType);

				System.out.println("selected notetype");
				Log.info("log4j msg-selected notetype");
				Thread.sleep(2000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='txtNotes']")));
				driver.findElement(By.xpath("//textarea[@id='txtNotes']")).sendKeys(details);

				System.out.println("entered comm details");
				Log.info("log4j msg-entered communication details");
				Thread.sleep(2000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-ng-click='closeMe()']")));
				driver.findElement(By.xpath("//button[@data-ng-click='closeMe()']")).click();
				System.out.println("clicked on hide");
				Log.info("log4j msg-clicked on hide");
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-ng-click='closeCase()']")));
				driver.findElement(By.xpath("//button[@data-ng-click='closeCase()']")).click();
				
				Thread.sleep(2000);
				System.out.println("clicked on close case");
				Log.info("log4j msg-clicked on close case");
				Thread.sleep(3000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Save")));
				driver.findElement(By.linkText("Save")).click();
				System.out.println("clicked on save");
				Log.info("log4j msg- clicked on save");
	
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
				driver.quit();
			}else{Log.info("Auth cert no. not found");System.out.println("Auth cert no. not found");
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
			driver.quit();}
		}catch(Exception e){System.out.println("Error in Auth Examiner View- Add Comm"); 
		Log.info("Error in Auth Examiner View- Add Comm");
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
		driver.quit();}
	}
	

	
	public String  AEVcopyAuth(String mid, String mlname, String mfname, String mdob, String mssn, String refCertNo, String pNPI, String newTreatmentEndDate) throws Exception{
		try{
		//search for the refcertno
		int j=searchAuth(refCertNo, pNPI);
		
		if (j==1){
		
			System.out.println("Found Auth Ref CertNo, Continue with Member's Auths- Copy");
			Log.info("Found Auth Ref CertNo, Continue with Member's Auths- Copy");
			Thread.sleep(2000);
			//click copy 
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Copy")));

			WebElement clickCopy= driver.findElement(By.linkText("Copy"));
			clickCopy.click();
			Log.info("log4j msg-clicked Copy");
			System.out.println("clicked Copy");
			
			try{				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-secondary btn-bottom02' and text()='No']")));
				WebElement DuplicateNo= driver.findElement(By.xpath("//button[@class='btn btn-secondary btn-bottom02' and text()='No']"));
				DuplicateNo.click();
				Log.info("log4j msg-Clicked No for Duplicate yes/no question");
				System.out.println("Clicked No for Duplicate yes/no question");
				
			}catch(Exception e) {System.out.println("");}
			
			Thread.sleep(2000);
				try{
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary btn-bottom02' and text()='Yes']")));
				WebElement AuthorizationOverlapsYes	= driver.findElement(By.xpath("//button[@class='btn btn-primary btn-bottom02' and text()='Yes']"));
				AuthorizationOverlapsYes.click();
				Log.info("log4j msg-clicked Yes for Authorization overlaps with other is that ok");
				System.out.println("clicked Yes for Authorization overlaps with other is that ok");
				}catch(Exception e){System.out.println("No Authorization overlaps question");}
			
			Thread.sleep(2000);
			try{
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary btn-bottom02' and text()='OK']")));
				WebElement DeniedDuplicateReferralCertificationOK	= driver.findElement(By.xpath("//button[@class='btn btn-primary btn-bottom02' and text()='OK']"));
				DeniedDuplicateReferralCertificationOK.click();
				Log.info("log4j msg-clicked OK for Denied Authorization Processing Msg");
				System.out.println("clicked OK for Denied Authorization Processing Msg");
				}catch(Exception e){System.out.println("No Processing Msg");}
			
			
			
			try{
				Thread.sleep(2000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary btn-bottom02' and text()='OK']")));
				WebElement DeniedDuplicateReferralCertificationOK2	= driver.findElement(By.xpath("//button[@class='btn btn-primary btn-bottom02' and text()='OK']"));
				DeniedDuplicateReferralCertificationOK2.click();
				Log.info("log4j msg-clicked OK2 for Denied Authorization Processing Msg");
				System.out.println("clicked OK2 for Denied Authorization Processing Msg");
				}catch(Exception e){System.out.println("No Processing Msg");}
			
			Thread.sleep(2000);
						//click save
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Save")));
			WebElement clickSave= driver.findElement(By.linkText("Save"));
				clickSave.click();
				Log.info("log4j msg-clicked save");
				System.out.println("clicked save");
				
				Thread.sleep(3000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col-sm-3 col-md-3 col-lg-3 no-padding']/label")));
				String newAuthCode= driver.findElement(By.xpath("//div[@class='col-sm-3 col-md-3 col-lg-3 no-padding']/label")).getText();
				System.out.println("new Auth code="+newAuthCode);
				Log.info("log4j msg-new Auth code="+newAuthCode);
						
				Thread.sleep(3000);
						
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
				driver.quit();
				
				return newAuthCode;
						
		}else {System.out.println("Cannot find auth cert no");
		Log.info("Cannot find auth cert no"); 
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit(); 
		return null;}
		}catch(Exception e){System.out.println("Error in Auth Examiner View- copy"); 
		Log.info("Error in Auth Examiner View- copy");
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit();  
		return null;}
		}
		
	
		
	public void AEVeditAuth(String mid, String mlname, String mfname, String mdob, String mssn, String refCertNo, String pNPI, String newTreatmentEndDate) throws Exception{
		try{
		//search for the refcertno
		int j=searchAuth( refCertNo, pNPI);
		
		if (j==1){
		
			System.out.println("Found Auth Ref CertNo, Continue with Member's Auths- Edit");
			Log.info("Found Auth Ref CertNo, Continue with Member's Auths- Edit");
			
			//click Edit
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Edit")));

			WebElement clickCopy= driver.findElement(By.linkText("Edit"));
			clickCopy.click();
			Log.info("log4j msg-clicked Edit");
			System.out.println("clicked Edit");
			
			try{
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-secondary btn-bottom02' and text()='No']")));

				WebElement DuplicateNo= driver.findElement(By.xpath("//button[@class='btn btn-secondary btn-bottom02' and text()='No']"));
				DuplicateNo.click();
				Log.info("log4j msg-Clicked No for Duplicate yes/no question");
				System.out.println("Clicked No for Duplicate yes/no question");
				
			}catch(Exception e) {System.out.println("");}
			
			Thread.sleep(2000);
			
			System.out.println("New treatment end date:"+newTreatmentEndDate);
			Log.info("New treatment end date:"+newTreatmentEndDate);
			try{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='terminatedate']")));

			WebElement enterNewTreatmentPeriodEndDate= driver.findElement(By.xpath("//input[@id='terminatedate']"));
			enterNewTreatmentPeriodEndDate.clear();
			enterNewTreatmentPeriodEndDate.sendKeys(newTreatmentEndDate);
			Log.info("log4j msg-entered new treatment period end date");
			System.out.println("entered new treatment period end date");
		
			}catch(Exception e){System.out.println("not able to enter the new treatment period end date");
			Log.info("not able to enter the new treatment period end date");BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();}
			
				try{
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary btn-bottom02' and text()='Yes']")));

				WebElement AuthorizationOverlapsYes	= driver.findElement(By.xpath("//button[@class='btn btn-primary btn-bottom02' and text()='Yes']"));
				AuthorizationOverlapsYes.click();
				Log.info("log4j msg-clicked Yes for Authorization overlaps with other is that ok");
				System.out.println("clicked Yes for Authorization overlaps with other is that ok");
				}catch(Exception e){System.out.println("");}
			
			Thread.sleep(2000);
			
			try{
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary btn-bottom02' and text()='OK']")));

				WebElement DeniedDuplicateReferralCertificationOK	= driver.findElement(By.xpath("//button[@class='btn btn-primary btn-bottom02' and text()='OK']"));
				DeniedDuplicateReferralCertificationOK.click();
				Log.info("log4j msg-clicked OK for Denied Authorization Processing Msg");
				System.out.println("clicked OK for Denied Authorization Processing Msg");
				}catch(Exception e){System.out.println("");}
			
			try{
				Thread.sleep(2000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary btn-bottom02' and text()='OK']")));

				WebElement DeniedDuplicateReferralCertificationOK2	= driver.findElement(By.xpath("//button[@class='btn btn-primary btn-bottom02' and text()='OK']"));
				DeniedDuplicateReferralCertificationOK2.click();
				Log.info("log4j msg-clicked OK2 for Denied Authorization Processing Msg");
				System.out.println("clicked OK2 for Denied Authorization Processing Msg");
				}catch(Exception e){System.out.println("");}
			Thread.sleep(2000);
			//click save
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Save")));
	
			WebElement clickSave= driver.findElement(By.linkText("Save"));
			clickSave.click();
			Log.info("log4j msg-clicked save");
			System.out.println("clicked save");
				
			Thread.sleep(3000);
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
			driver.quit();
			
					
						
		}else {System.out.println("Cannot find auth cert no");
		Log.info("Cannot find auth cert no");
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit(); }
		
		}catch(Exception e){System.out.println("Error in Auth Examiner View- Edit"); 
		Log.info("Error in Auth Examiner View - Edit");
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
		driver.quit();}
		}
	
	
	
	public void AEVexitAuth(String mid, String mlname, String mfname, String mdob, String mssn, String refCertNo, String pNPI) throws Exception{
		try{
		//search for the refcertno
		int j=searchAuth(refCertNo, pNPI);
		
		if (j==1){
		
			System.out.println("Found Auth Ref CertNo, Continue with Member's Auths- Exit");
			Log.info("Found Auth Ref CertNo, Continue with Member's Auths- Exit");
			
			//click Exit 
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Exit")));
			WebElement clickCopy= driver.findElement(By.linkText("Exit"));
			clickCopy.click();
			Log.info("log4j msg-clicked Exit");
			System.out.println("clicked Exit");
			
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
			driver.quit();
		}else {System.out.println("Cannot find auth cert no"); 
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit();
		}
			}catch(Exception e){System.out.println("Error in Auth Examiner View- Exit"); 
		Log.info("Error in Auth Examiner View- Exit");
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit(); }
		}
	
	
	public void AEVvalidateAuth(String mid, String mlname, String mfname, String mdob, String mssn, String refCertNo, String pNPI) throws Exception{
		try{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		//search for the refcertno
		int j=searchAuth( refCertNo, pNPI);
		
		if (j==1){
		
			System.out.println("Found Auth Ref CertNo, Continue with Member's Auths- Validate");
			Log.info("Found Auth Ref CertNo, Continue with Member's Auths- Validate");
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Validate")));

			WebElement clickValidate= driver.findElement(By.linkText("Validate"));
			clickValidate.click();
			Log.info("log4j msg-clicked Validate");
			System.out.println("clicked Validate");
		
			//click yes to validate all records
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-bb-handler='Success']")));

			WebElement clickYes= driver.findElement(By.xpath("//button[@data-bb-handler='Success']"));
			clickYes.click();
			Log.info("log4j msg-clicked Yes");
			System.out.println("clicked Yes");
	
	
			Thread.sleep(2000);
	try{
			//click ok for finished validating
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-bb-handler='Success' and @class='btn btn-primary btn-bottom02' and text()='OK']")));

			WebElement clickOK= driver.findElement(By.xpath("//button[@data-bb-handler='Success' and @class='btn btn-primary btn-bottom02' and text()='OK']"));
			clickOK.click();
			Log.info("log4j msg-clicked OK");
			System.out.println("clicked OK");
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
			driver.quit(); 
	}catch(Exception e){	
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
	driver.quit();	}
	}
	else{ System.out.println("cannot find auth cert no");
		Log.info("cannot find auth cert no");
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
		driver.quit();}
		
		
		
		}catch(Exception e){System.out.println("Error in Auth Examiner View- validate"); Log.info("Error in Auth Examiner View- validate");BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit(); driver.quit();}
		
	}
	
	public void AEVdeleteAuth( String mid, String mlname, String mfname, String mdob, String mssn, String refCertNo, String pNPI) throws Exception{
		try{
			//search for the refcertno
		int j=searchAuth( refCertNo, pNPI);
		
		if (j==1){
		
			System.out.println("Found Auth Ref CertNo, Continue with Member's Auths- Delete");
			Log.info("Found Auth Ref CertNo, Continue with Member's Auths- Delete");
			
			
			//click delete
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Delete")));

			WebElement clickDelete= driver.findElement(By.linkText("Delete"));
			clickDelete.click();
			Log.info("log4j msg-clicked Delete");
			System.out.println("clicked Delete");
	
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-bb-handler='Success' and text()='Yes']")));

		
			WebElement clickYesToDelete= driver.findElement(By.xpath("//button[@data-bb-handler='Success' and text()='Yes']"));
			clickYesToDelete.click();
			
			Log.info("log4j msg-clicked Yes to confirm Delete");
			System.out.println("clicked Yes to confirm Delete");
			
						
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
			driver.quit();
			
					
						
		}else {System.out.println("Cannot find auth cert no"); 
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit();
		}
		
	}catch(Exception e){ System.out.println("Error in Auth Examiner View- Delete"); 
	Log.info("Error in Auth Examiner View- Delete");
	BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
	driver.quit(); }
}

}
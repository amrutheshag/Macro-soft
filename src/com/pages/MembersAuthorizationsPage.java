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

public class MembersAuthorizationsPage {

	WebDriver driver;
	WebDriverWait wait;

	By addAuth = By.xpath("//a[@id='add' and @data-ng-click='addForm()']");

	By Modifier1 = By.xpath("//input[@data-ng-model='refCert2.modifier']");

	By Modifier2 = By.xpath("//input[@data-ng-model='refCert2.modifier2']");

	By Modifier3 = By.xpath("//input[@data-ng-model='refCert2.modifier3']");

	public MembersAuthorizationsPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 35);
	}

	public int selectAuth(String refCertNo) throws Exception {
		System.out.println("Auth Ref/Cert Number:" + refCertNo);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='" + refCertNo + "']")));
			driver.findElement(By
					.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='" + refCertNo + "']"))
					.click();
			System.out.println("Member's Authorization selected- check details");
			Log.info("log4j msg- Member's Authorization selected- check details");
			return 1;
		} catch (Exception e) {
			System.out.println("Authorization with given Ref/CertNo is not present");
			return 0;
		}
	}

	public void exitMemAuth(String mid, String mlname, String mfname, String mdob, String mssn, String refCertNo)
			throws Exception {
		try {
			// enter mid, click search, click Return selection

			SelectMemberPage selectMemberPageObject = new SelectMemberPage(driver);
			int i = selectMemberPageObject.searchMember(mid, mlname, mfname, mdob, mssn);
			if (i == 1) {

				System.out.println("Continue with Member's Auths- Exit");
				Log.info("Continue with Member's Auths- Exit");

				int j = selectAuth(refCertNo);

				if (j == 1) {
					// click exit

					wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Exit")));
					driver.findElement(By.linkText("Exit")).click();
					System.out.println("Member's Authorization- Clicked Exit");
					Log.info("log4j msg- Member's Authorization- Clicked Exit");
					BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
					driver.quit();

				} else {
					System.out.println("Auth cert no. not found");
					Log.info("log4j msg- Auth cert no. not found");
					BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
					driver.quit();
				}

			} else {
				System.out.println("Cannot find member");
				Log.info("log4j msg- Cannot find member");
				BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
				driver.quit();
			}
		} catch (Exception e) {
			System.out.println("error in exit mem auth");
			Log.info("log4j msg- error in exit mem auth");
			BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
			driver.quit();
		}

	}

	public void addCommMemAuth(String mid, String mlname, String mfname, String mdob, String mssn, String refCertNo,
			String subject, String noteType, String details) throws Exception {
		try {
			SelectMemberPage selectMemberPageObject = new SelectMemberPage(driver);
			int i = selectMemberPageObject.searchMember(mid, mlname, mfname, mdob, mssn);
			System.out.println("searched  for member");
			if (i == 1) {
				int j = selectAuth(refCertNo);
				if (j == 1) {
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Commun.")));
					driver.findElement(By.linkText("Commun.")).click();
					System.out.println("clicked Communication");
					Log.info("log4j msg- clicked communication");

					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
							"id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/img[1]")));
					WebElement e = driver.findElement(By.xpath(
							"id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/img[1]"));
					Actions action = new Actions(driver);
					action.moveToElement(e).click().perform();

					System.out.println("Clicked add at the top");
					Log.info("log4j msg-clicked add at the top");

					driver.findElement(By.xpath("//input[@id='txtSubject' and @data-ng-model='currentRecord.subject']"))
							.sendKeys(subject);
					System.out.println("entered subject");
					Log.info("log4j msg-entered subject");
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@tabindex='9']")));
					driver.findElement(By.xpath("//textarea[@tabindex='9']")).sendKeys(Keys.PAGE_DOWN);

					Thread.sleep(2000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
							"id('tabGeneral')/div[@class='row']/div[@class='col-lg-12 col-md-12 col-sm-12 col-xs-12 button-wrap']/div[@class='col-lg-10 col-md-10 col-sm-12 col-xs-12 no-padding text-right pull-right']/button[@class='btn btn-primary btn-bottom01' and @data-ng-click='addChildRecord()']")));
					driver.findElement(By
							.xpath("id('tabGeneral')/div[@class='row']/div[@class='col-lg-12 col-md-12 col-sm-12 col-xs-12 button-wrap']/div[@class='col-lg-10 col-md-10 col-sm-12 col-xs-12 no-padding text-right pull-right']/button[@class='btn btn-primary btn-bottom01' and @data-ng-click='addChildRecord()']"))
							.click();
					System.out.println("clicked add");
					Log.info("log4j msg-clicked add");
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlNoteType")));
					Select notetypes = new Select(driver.findElement(By.id("ddlNoteType")));

					Thread.sleep(3000);
					System.out.println("note type:" + noteType);
					notetypes.selectByVisibleText(noteType);
					System.out.println("selected notetype");
					Log.info("log4j msg-selected notetype");
					Thread.sleep(2000);
					driver.findElement(By.xpath("//textarea[@id='txtNotes']")).sendKeys(details);

					System.out.println("entered comm details");
					Log.info("log4j msg-entered communication details");
					Thread.sleep(2000);
					driver.findElement(By.xpath("//button[@data-ng-click='closeMe()']")).click();
					System.out.println("clicked on hide");
					Log.info("log4j msg-clicked on hide");
					Thread.sleep(2000);
					driver.findElement(By.xpath("//button[@data-ng-click='closeCase()']")).click();
					System.out.println("clicked on close case");
					Log.info("log4j msg-clicked on close case");
					Thread.sleep(2000);
					driver.findElement(By.linkText("Save")).click();
					System.out.println("clicked on save");
					Log.info("log4j msg- clicked on save");

					BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
					driver.quit();
				} else {
					Log.info("log4j msg- Auth cert no. not found");
					System.out.println("Auth cert no. not found");
					BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
					driver.quit();
				}
			} else {
				Log.info("log4j msg- Member not found");
				System.out.println("Member not found");
				BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
				driver.quit();
			}

		} catch (Exception e) {
			System.out.println("error in mem auth add comm");
			Log.info("log4j msg- error in mem auth add comm");
			BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
			driver.quit();
		}
	}

	public String addMemAuth(String mid, String mlname, String mfname, String mdob, String mssn, String refReason,
			String caseManager, String npi, String taxID, String pname, String paddr, String pspeciality, String pos,
			String icdCode, String refCertType, String treatmentPeriodEndDate, String printedProcessedDate,
			String pFollowupDate, String extensionDate, String serviceSet, String modifier1, String modifier2,
			String modifier3) throws Exception {

		try {
			// search for member
			SelectMemberPage selectMemberPageObject = new SelectMemberPage(driver);
			int i = selectMemberPageObject.searchMember(mid, mlname, mfname, mdob, mssn);
			if (i == 1) {

				System.out.println("Continue with Adding Authorization");
				Log.info("Continue with Adding Authorization");

				wait.until(ExpectedConditions.visibilityOfElementLocated(addAuth));
				driver.findElement(addAuth).click();
				System.out.println("clicked Add Authentication");
				Log.info("log4j msg- Clicked Add Authentication");

				// select Referral reason

				Select referralReason = new Select(
						driver.findElement(By.xpath("//select[@data-ng-model='referralCertification.refreason']")));
				referralReason.selectByVisibleText(refReason);

				System.out.println("selected Referral Reason");
				Log.info("log4j msg-selected Referral Reason");
				// select certifying case manager

				Select certifyingCaseManager = new Select(
						driver.findElement(By.xpath("//select[@data-ng-model='referralCertification.casemgr']")));
				// certifyingCaseManager.selectByVisibleText(caseManager);
				certifyingCaseManager.selectByIndex(1);
				System.out.println("selected Certifying Case Manager");
				Log.info("log4j msg-selected Certifying Case Manager");

				Thread.sleep(2000);
				// enter provider details
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='?']")));
				driver.findElement(By.xpath("//button[text()='?']")).click();
				Log.info("log4j msg-clicked ?");
				System.out.println("Cliked ?");

				// enter npi
				wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//input[@id='txtSearchCode' and @data-ng-model='filterOptionsnew.NPI']")));
				WebElement ProviderNPI = driver.findElement(
						By.xpath("//input[@id='txtSearchCode' and @data-ng-model='filterOptionsnew.NPI']"));

				ProviderNPI.sendKeys(npi);
				Log.info("log4j msg-entered npi");
				System.out.println("entered npi");
				// click search
				WebElement SearchButton = driver.findElement(By.xpath("//button[text()='Search']"));
				SearchButton.click();
				Log.info("log4j msg-clicked search");
				System.out.println("clicked search");
				// check provider tin
				System.out.println("Getting Provider - Organization TIN combination data list now");

				Thread.sleep(2000);
				List<WebElement> dateBox1 = driver.findElements(By.xpath(
						"//div[@class='ui-grid-cell-contents ng-binding ng-scope']/ancestor::div[@class='ui-grid-cell ng-scope ui-grid-disable-selection ui-grid-coluiGrid-00ES']//following-sibling::div//div"));
				for (WebElement webElement : dateBox1) {
					System.out.println(webElement.getText());
				}

				// click ok
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
						"//button[@class='btn btn-secondary btn-bottom01 pull-right' and @ng-click='getProviderAddress()']")));
				WebElement ClickOk = driver.findElement(By.xpath(
						"//button[@class='btn btn-secondary btn-bottom01 pull-right' and @ng-click='getProviderAddress()']"));
				ClickOk.click();
				System.out.println("clicked  ok");
				Log.info("log4j msg-clicked ok");
				wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//button[@ng-click='providerLookupAddressokbuttonclick()']")));
				WebElement ClickOk2 = driver
						.findElement(By.xpath("//button[@ng-click='providerLookupAddressokbuttonclick()']"));
				ClickOk2.click();
				System.out.println("clicked  ok");
				Log.info("log4j msg-clicked ok");
				Thread.sleep(2000);
				// page down
				wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//input[@data-ng-model='referralCertification.extension']")));
				WebElement referralCertificationExtension = driver
						.findElement(By.xpath("//input[@data-ng-model='referralCertification.extension']"));
				referralCertificationExtension.sendKeys(Keys.PAGE_DOWN);

				System.out.println("pagedown");
				Thread.sleep(1000);
				// select place of service
				Select placeOfService = new Select(
						driver.findElement(By.xpath("//select[@data-ng-model='referralCertification.placeserv']")));

				placeOfService.selectByVisibleText(pos);
				Log.info("log4j msg-selected place of service");
				System.out.println("selected place of service");

				// enter icd code
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//input[@data-ng-model='referralCertification.icd1']")));
				WebElement ICDCode = driver
						.findElement(By.xpath("//input[@data-ng-model='referralCertification.icd1']"));
				ICDCode.sendKeys(icdCode);
				Log.info("log4j msg-entered icd code");
				System.out.println("entered icd code");

				// Referral/ Cert Type- auto populated- Original

				// Click Manual check box
				wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//input[@data-ng-model='referralCertification.manual']")));
				WebElement manualCheckbox = driver
						.findElement(By.xpath("//input[@data-ng-model='referralCertification.manual']"));
				manualCheckbox.click();
				Log.info("log4j msg-clicked manual check box");
				System.out.println("clicked manual check box");

				// Disposition is auto populated- Approved
				Thread.sleep(2000);
				// Treatment period- today's date to enter a future date
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='terminatedate']")));
				WebElement enterTreatmentPeriodEndDate = driver.findElement(By.xpath("//input[@id='terminatedate']"));
				enterTreatmentPeriodEndDate.sendKeys(treatmentPeriodEndDate);
				Log.info("log4j msg-entered treatment period end date");
				System.out.println("entered treatment period end date");

				Thread.sleep(2000);
				// extensionDate, String serviceSet

				// Printed or Processed date - today's date
				wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//input[@data-ng-model='referralCertification.processed']")));
				WebElement enterProcessedDate = driver
						.findElement(By.xpath("//input[@data-ng-model='referralCertification.processed']"));
				enterProcessedDate.sendKeys(printedProcessedDate);
				Log.info("log4j msg-entered Printed/Processed date");
				System.out.println("entered Printed/Processed date");

				Thread.sleep(2000);
				// Provider followup- today's date
				wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//input[@data-ng-model='referralCertification.followup']")));
				WebElement enterProviderFollowupDate = driver
						.findElement(By.xpath("//input[@data-ng-model='referralCertification.followup']"));
				enterProviderFollowupDate.sendKeys(pFollowupDate);
				Log.info("log4j msg-entered Provider Followup date");
				System.out.println("entered Provider Followup date");

				Thread.sleep(2000);

				// Extension- a future date
				wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//input[@data-ng-model='referralCertification.extension']")));
				WebElement enterExtensionDate = driver
						.findElement(By.xpath("//input[@data-ng-model='referralCertification.extension']"));
				enterExtensionDate.sendKeys(extensionDate);
				Log.info("log4j msg-entered Extension date");
				System.out.println("entered Extension date");

				Thread.sleep(2000);
				// click add at the bottom
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//button[@data-ng-click='addRefCert2()']")));
				WebElement addButton = driver.findElement(By.xpath("//button[@data-ng-click='addRefCert2()']"));
				addButton.click();
				Log.info("log4j msg-clicked add");
				System.out.println("clicked add");

				Thread.sleep(2000);

				// click service set- pick one from drop down
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//select[@data-ng-model='refCert2.serviceset']")));
				Select ServiceSet = new Select(
						driver.findElement(By.xpath("//select[@data-ng-model='refCert2.serviceset']")));
				// ServiceSet.selectByVisibleText(serviceSet);
				ServiceSet.selectByIndex(1);
				System.out.println("selected Service set");
				Log.info("log4j msg-selected Service set");

				Thread.sleep(2000);

				// enter modifier 1
				wait.until(ExpectedConditions.visibilityOfElementLocated(Modifier1));
				driver.findElement(Modifier1).sendKeys(modifier1);
				System.out.println("entered modifier 1");
				Log.info("log4j msg-entered modifier 1");

				Thread.sleep(3000);
				// enter modifier 2

				wait.until(ExpectedConditions.visibilityOfElementLocated(Modifier2));
				driver.findElement(Modifier2).sendKeys(modifier2);
				System.out.println("entered modifier 2");
				Log.info("log4j msg-entered modifier 2");

				// enter modifier 3
				wait.until(ExpectedConditions.visibilityOfElementLocated(Modifier3));
				driver.findElement(Modifier3).sendKeys(modifier3);
				System.out.println("entered modifier 3");
				Log.info("log4j msg-entered modifier 3");

				// click check
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//button[@data-ng-click='refcer2_Adjudicate()']")));
				WebElement checkButton = driver
						.findElement(By.xpath("//button[@data-ng-click='refcer2_Adjudicate()']"));
				checkButton.click();
				Log.info("log4j msg-clicked check");
				System.out.println("clicked check");

				// click No for duplicate
				Thread.sleep(1000);

				try {
					wait.until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath("//button[@class='btn btn-secondary btn-bottom02' and text()='No']")));
					WebElement DuplicateNo = driver
							.findElement(By.xpath("//button[@class='btn btn-secondary btn-bottom02' and text()='No']"));
					DuplicateNo.click();
					Log.info("log4j msg-Clicked No for Duplicate yes/no question");
					System.out.println("Clicked No for Duplicate yes/no question");

				} catch (Exception e) {
					System.out.println("");
				}

				Thread.sleep(2000);

				try {
					wait.until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath("//button[@class='btn btn-secondary btn-bottom02' and text()='Yes']")));
					WebElement AuthorizationOverlapsYes = driver.findElement(
							By.xpath("//button[@class='btn btn-secondary btn-bottom02' and text()='Yes']"));
					AuthorizationOverlapsYes.click();
					Log.info("log4j msg-Clicked Yes for Authorization Overlaps - Is this ok?");
					System.out.println("Clicked Yes for Authorization Overlaps - Is this ok?");

				} catch (Exception e) {
					System.out.println("");
				}
				Thread.sleep(2000);
				// click hide
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//button[@data-ng-click='closeMe()']")));
				WebElement HideButton = driver.findElement(By.xpath("//button[@data-ng-click='closeMe()']"));
				HideButton.click();
				Log.info("log4j msg-clicked Hide");
				System.out.println("clicked Hide");

				// click on outgoing- for pageup
				wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//input[@data-ng-model='referralCertification.eobnote']")));
				WebElement Outgoing = driver
						.findElement(By.xpath("//input[@data-ng-model='referralCertification.eobnote']"));
				Outgoing.sendKeys(Keys.PAGE_UP);
				Log.info("log4j msg-clicked Page Up");
				System.out.println("clicked Page Up");

				Thread.sleep(1000);
				// click validate
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Validate")));
				WebElement Validate = driver.findElement(By.linkText("Validate"));
				Validate.click();
				Log.info("log4j msg-clicked Validate");
				System.out.println("clicked Validate");

				Thread.sleep(2000);
				// click ok--All Edited Records are valid. This Record(set) may
				// be saved.
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//button[@data-bb-handler='Success']")));
				WebElement clickOK = driver.findElement(By.xpath("//button[@data-bb-handler='Success']"));
				clickOK.click();
				Log.info("log4j msg-clicked ok");
				System.out.println("clicked ok");
				Thread.sleep(2000);
				// click save
				try {
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Save")));
					WebElement clickSave = driver.findElement(By.linkText("Save"));

					clickSave.click();
					Log.info("log4j msg-clicked save");
					System.out.println("clicked save");
					Thread.sleep(3000);

					String newAuthCode = driver
							.findElement(
									By.xpath("//div[@class='col-sm-12 text-right record-info no-padding ng-binding']"))
							.getText();
					System.out.println("new Auth code=" + newAuthCode);
					Log.info("log4j msg-new Auth code=" + newAuthCode);

					Thread.sleep(3000);
					BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
					driver.quit();
					return newAuthCode;
				} catch (Exception e) {
					System.out.println("Unable to click save");
					Log.info("log4j msg- unable to click save");
					BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
				}
				BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
				driver.quit();
				return null;
			} else {

				System.out.println("Member not found, Cannot Add Authorization");
				Log.info("log4j msg- Member not found, Cannot Add Authorization");

				BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
				driver.quit();
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error in adding mem auth");
			Log.info("log4j msg- error in adding mem auth");
			BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
			driver.quit();
			return null;
		}

	}

	public void editMemAuth(String mid, String mlname, String mfname, String mdob, String mssn, String refCertNo,
			String newTreatmentEndDate) throws Exception {

		try {
			// search member
			SelectMemberPage selectMemberPageObject = new SelectMemberPage(driver);
			int i = selectMemberPageObject.searchMember(mid, mlname, mfname, mdob, mssn);

			if (i == 1) {

				System.out.println("Continue with Member's Auths- Edit");
				Log.info("log4j msg- Continue with Member's Auths- Edit");

				// search for the refcertno
				int j = selectAuth(refCertNo);

				if (j == 1) {
					// click edit
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Edit")));
					WebElement clickEdit = driver.findElement(By.linkText("Edit"));

					clickEdit.click();
					Log.info("log4j msg-clicked Edit");
					System.out.println("clicked Edit");

					// possbile duplicate- click no
					try {
						wait.until(ExpectedConditions.visibilityOfElementLocated(
								By.xpath("//button[@class='btn btn-secondary btn-bottom02' and text()='No']")));
						WebElement DuplicateNo = driver.findElement(
								By.xpath("//button[@class='btn btn-secondary btn-bottom02' and text()='No']"));

						DuplicateNo.click();
						Log.info("log4j msg-Clicked No for Duplicate yes/no question");
						System.out.println("Clicked No for Duplicate yes/no question");

					} catch (Exception e) {
						System.out.println("");
					}
					// edit the field to be updated

					Thread.sleep(2000);
					System.out.println("New treatment end date:" + newTreatmentEndDate);
					Log.info("log4j msg- New treatment end date:" + newTreatmentEndDate);
					try {
						wait.until(ExpectedConditions
								.visibilityOfElementLocated(By.xpath("//input[@id='terminatedate']")));
						WebElement enterNewTreatmentPeriodEndDate = driver
								.findElement(By.xpath("//input[@id='terminatedate']"));

						enterNewTreatmentPeriodEndDate.clear();
						enterNewTreatmentPeriodEndDate.sendKeys(newTreatmentEndDate);
						Log.info("log4j msg-entered new treatment period end date");
						System.out.println("entered new treatment period end date");

					} catch (Exception e) {
						System.out.println("not able to enter the new treatment period end date");
						Log.info("log4j msg- not able to enter the new treatment period end date");
					}

					Thread.sleep(1000);
					// click save
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Save")));
					WebElement clickSave = driver.findElement(By.linkText("Save"));

					clickSave.click();
					Log.info("log4j msg-clicked save");
					System.out.println("clicked save");

					try {
						wait.until(ExpectedConditions
								.visibilityOfElementLocated(By.xpath("//button[@data-bb-handler='Success']")));
						WebElement clickOK1 = driver.findElement(By.xpath("//button[@data-bb-handler='Success']"));

						clickOK1.click();
						Log.info("log4j msg- clicked ok");
						System.out.println("clicked ok");

						BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
						driver.quit();

					} catch (Exception e) {
						System.out.println("");
						BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
						driver.quit();
					}

				} else {
					System.out.println("Auth cert no. not found");
					Log.info("log4j msg- Auth cert no. not found");
					BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
					driver.quit();

				}
			} else {
				System.out.println("member not found");
				Log.info("log4j msg- member not found");
				BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
				driver.quit();
			}

		} catch (Exception e) {
			System.out.println("error in edit Member auth");
			Log.info("log4j msg- error in edit Member auth");
			BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
			driver.quit();
		}

	}

	public String copyMemAuth(String mid, String mlname, String mfname, String mdob, String mssn, String refCertNo,
			String newTreatmentEndDate) throws Exception {
		try {
			// search member
			SelectMemberPage selectMemberPageObject = new SelectMemberPage(driver);
			int i = selectMemberPageObject.searchMember(mid, mlname, mfname, mdob, mssn);

			if (i == 1) {

				System.out.println("Continue with Member's Auths- Copy");
				Log.info("log4j msg- Continue with Member's Auths- Copy");
				Thread.sleep(2000);
				// search for the refcertno
				int j = selectAuth(refCertNo);

				if (j == 1) {
					// click copy
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Copy")));
					WebElement clickCopy = driver.findElement(By.linkText("Copy"));

					clickCopy.click();
					Log.info("log4j msg-clicked Copy");
					System.out.println("clicked Copy");
					// possbile duplicate- click no
					try {
						wait.until(ExpectedConditions.visibilityOfElementLocated(
								By.xpath("//button[@class='btn btn-secondary btn-bottom02' and text()='No']")));
						WebElement DuplicateNo = driver.findElement(
								By.xpath("//button[@class='btn btn-secondary btn-bottom02' and text()='No']"));
						Thread.sleep(2000);
						DuplicateNo.click();
						Log.info("log4j msg-Clicked No for Duplicate yes/no question");
						System.out.println("Clicked No for Duplicate yes/no question");

					} catch (Exception e) {
						System.out.println("");
					}

					Thread.sleep(2000);

					// edit the field to be updated

					try {
						wait.until(ExpectedConditions.visibilityOfElementLocated(
								By.xpath("//button[@class='btn btn-primary btn-bottom02' and text()='Yes']")));
						WebElement AuthorizationOverlapsYes = driver.findElement(
								By.xpath("//button[@class='btn btn-primary btn-bottom02' and text()='Yes']"));

						AuthorizationOverlapsYes.click();
						Log.info("log4j msg-clicked Yes for Authorization overlaps with other is that ok");
						System.out.println("clicked Yes for Authorization overlaps with other is that ok");
					} catch (Exception e) {
						System.out.println("");
					}

					Thread.sleep(2000);
					try {
						wait.until(ExpectedConditions.visibilityOfElementLocated(
								By.xpath("//button[@class='btn btn-primary btn-bottom02' and text()='OK']")));
						WebElement DeniedDuplicateReferralCertificationOK = driver.findElement(
								By.xpath("//button[@class='btn btn-primary btn-bottom02' and text()='OK']"));

						DeniedDuplicateReferralCertificationOK.click();
						Log.info("log4j msg-clicked OK for Denied Authorization Processing Msg");
						System.out.println("clicked OK for Denied Authorization Processing Msg");
					} catch (Exception e) {
						System.out.println("");
					}

					try {
						wait.until(ExpectedConditions.visibilityOfElementLocated(
								By.xpath("//button[@class='btn btn-primary btn-bottom02' and text()='OK']")));
						WebElement DeniedDuplicateReferralCertificationOK2 = driver.findElement(
								By.xpath("//button[@class='btn btn-primary btn-bottom02' and text()='OK']"));

						DeniedDuplicateReferralCertificationOK2.click();
						Log.info("log4j msg-clicked OK2 for Denied Authorization Processing Msg");
						System.out.println("clicked OK2 for Denied Authorization Processing Msg");
					} catch (Exception e) {
						System.out.println("");
					}

					// click save
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Save")));
					WebElement clickSave = driver.findElement(By.linkText("Save"));

					clickSave.click();
					Log.info("log4j msg-clicked save");
					System.out.println("clicked save");

					Thread.sleep(3000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath("//div[@class='col-sm-12 text-right record-info no-padding ng-binding']")));
					String newAuthCode = driver
							.findElement(
									By.xpath("//div[@class='col-sm-12 text-right record-info no-padding ng-binding']"))
							.getText();
					System.out.println("new Auth code=" + newAuthCode);
					Log.info("log4j msg-new Auth code=" + newAuthCode);

					Thread.sleep(3000);

					BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
					driver.quit();
					return newAuthCode;

				} else {
					System.out.println("Cannot find auth cert no");
					Log.info("log4j msg- Cannot find auth cert no");
					BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
					driver.quit();
					return null;
				}
			} else {
				System.out.println("Cannot find member");
				Log.info("log4j msg- Cannot find member");
				BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
				driver.quit();
				return null;

			}
		} catch (Exception e) {
			System.out.println("error in copy member auth");
			Log.info("log4j msg- error in copy member auth");
			BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
			driver.quit();
			return null;
		}
	}

	public void deleteMemAuth(String mid, String mlname, String mfname, String mdob, String mssn, String refCertNo)
			throws Exception {
		try {
			// search member
			SelectMemberPage selectMemberPageObject = new SelectMemberPage(driver);
			int i = selectMemberPageObject.searchMember(mid, mlname, mfname, mdob, mssn);

			if (i == 1) {

				System.out.println("Continue with Member's Auths- Delete");
				Log.info("log4j msg- Continue with Member's Auths- Delete");

				// search for the refcertno
				selectAuth(refCertNo);
				Thread.sleep(3000);
				// click delete
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Delete")));
				WebElement clickDelete = driver.findElement(By.linkText("Delete"));

				clickDelete.click();
				Log.info("log4j msg-clicked Delete");
				System.out.println("clicked Delete");

				Thread.sleep(3000);
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//button[@data-bb-handler='Success' and text()='Yes']")));
				WebElement clickYesToDelete = driver
						.findElement(By.xpath("//button[@data-bb-handler='Success' and text()='Yes']"));

				clickYesToDelete.click();

				Log.info("log4j msg- clicked Yes to confirm Delete");
				System.out.println("clicked Yes to confirm Delete");
				Thread.sleep(2000);

				BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
				driver.quit();
			} else {
				System.out.println("Cannot find member");
				Log.info("log4j msg- Cannot find member");
				BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
				driver.quit();

			}
		} catch (Exception e) {
			System.out.println("error in delete mem auth");
			Log.info("log4j msg- error in delete mem auth");
			BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
			driver.quit();
		}
	}

	public void validateMemAuth(String mid, String mlname, String mfname, String mdob, String mssn, String refCertNo)
			throws Exception {
		try {
			// search member
			SelectMemberPage selectMemberPageObject = new SelectMemberPage(driver);
			int i = selectMemberPageObject.searchMember(mid, mlname, mfname, mdob, mssn);

			if (i == 1) {

				System.out.println("Continue with Member's Auths- Validate");
				Log.info("log4j msg- Continue with Member's Auths- Validate");

				// search for the refcertno
				int j = selectAuth(refCertNo);
				if (j == 1) {

					Thread.sleep(2000);
					// click Validate

					WebElement clickValidate = driver.findElement(By.linkText("Validate"));
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Validate")));
					clickValidate.click();
					Log.info("log4j msg- clicked Validate");
					System.out.println("clicked Validate");
					Thread.sleep(2000);
					// click yes to validate all records
					wait.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("//button[@data-bb-handler='Success']")));
					WebElement clickYes = driver.findElement(By.xpath("//button[@data-bb-handler='Success']"));

					clickYes.click();
					Log.info("log4j msg- clicked Yes");
					System.out.println("clicked Yes");

					Thread.sleep(2000);

					// click ok for finished validating

					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
							"//button[@data-bb-handler='Success' and @class='btn btn-primary btn-bottom02' and text()='OK']")));

					WebElement clickOK = driver.findElement(By.xpath(
							"//button[@data-bb-handler='Success' and @class='btn btn-primary btn-bottom02' and text()='OK']"));
					clickOK.click();
					Thread.sleep(2000);
					Log.info("log4j msg- clicked OK");
					System.out.println("clicked OK");
					Thread.sleep(2000);
					BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
					driver.quit();
				} else {
					System.out.println("cannot find auth cert no");
					Log.info("log4j msg- cannot find auth cert no");
					BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
					driver.quit();
				}
			} else {
				System.out.println("Cannot Validate");
				Log.info("log4j msg- cannot find auth cert no");
				BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
				driver.quit();
			}

		} catch (Exception e) {
			System.out.println("error in mem auth Validate");
			Log.info("log4j msg- error in mem auth validate");
			BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
			driver.quit();
		}
	}

}

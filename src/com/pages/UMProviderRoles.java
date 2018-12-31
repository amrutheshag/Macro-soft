package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BrowserUtils;
import utility.Log;

public class UMProviderRoles {

	WebDriver driver;
	WebDriverWait wait;

	By UMProviderRolesAddLink = By.linkText("Add");

	By UMProviderRolesCodeInput = By.xpath("//input[@id='code']");

	By UMProviderRolesDescriptionInput = By.xpath("//input[@id='name']");

	By UMProviderRolesRecordMark = By.xpath("//input[@style='width:20px;']");

	By UMProviderRolesValidateLink = By.linkText("Validate");

	By UMProviderRolesValidateSaveOKButton = By.xpath("//button[@data-bb-handler='Success']");

	By UMProviderRolesSaveLink = By.linkText("Save");

	By UMProviderRolesEditLink = By.linkText("Edit");

	By UMProviderRolesCopyLink = By.linkText("Copy");

	By UMProviderRolesDeleteLink = By.linkText("Delete");

	By confirmDeleteButton = By.xpath("//button[@data-bb-handler='Success']");

	By UMProviderRolesCommLink = By.linkText("Commun.");

	By UMProviderRolesExitLink = By.linkText("Exit");

	public UMProviderRoles(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 35);
	}

	// add function
	public void addUMProviderRoles(String umproviderRolesCode, String umproviderRolesDescription) throws Exception {

		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(UMProviderRolesAddLink));
			driver.findElement(UMProviderRolesAddLink).click();
			System.out.println("clicked Add");
			Log.info("log4j msg- clicked Add");

			System.out.println("um provider roles code: " + umproviderRolesCode);
			Log.info("log4j msg- um provider roles code: " + umproviderRolesCode);
			// enter code
			wait.until(ExpectedConditions.visibilityOfElementLocated(UMProviderRolesCodeInput));
			driver.findElement(UMProviderRolesCodeInput).sendKeys(umproviderRolesCode);
			Thread.sleep(1000);
			System.out.println("Entered code");
			Log.info("log4j msg- Entered code");

			System.out.println("um provider roles description" + umproviderRolesDescription);
			Log.info("log4j msg- um provider roles description" + umproviderRolesDescription);
			// enter Description
			wait.until(ExpectedConditions.visibilityOfElementLocated(UMProviderRolesDescriptionInput));
			driver.findElement(UMProviderRolesDescriptionInput).sendKeys(umproviderRolesDescription);
			Thread.sleep(1000);
			System.out.println("Entered description");
			Log.info("log4j msg- Entered description");

			// click validate

			wait.until(ExpectedConditions.visibilityOfElementLocated(UMProviderRolesValidateLink));
			driver.findElement(UMProviderRolesValidateLink).click();
			System.out.println("clicked validate");
			Log.info("log4j msg- clicked validate");

			// click ok

			wait.until(ExpectedConditions.visibilityOfElementLocated(UMProviderRolesValidateSaveOKButton));
			driver.findElement(UMProviderRolesValidateSaveOKButton).click();
			System.out.println("clicked validate ok to save button");
			Log.info("log4j msg- clicked validate ok to save button");

			// click save
			Thread.sleep(1000);

			wait.until(ExpectedConditions.visibilityOfElementLocated(UMProviderRolesSaveLink));
			driver.findElement(UMProviderRolesSaveLink).click();
			System.out.println("clicked save ");
			Log.info("log4j msg- clicked  save ");
			BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
			driver.quit();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in Adding UM Provider Roles ");
			Log.info("log4j msg- Error in Adding UM Provider Roles ");
			BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
			driver.quit();
		}

	}

	// copy function

	public void copyUMProviderRoles(String umproviderRolesCode, String newumproviderRolesCode,
			String newUMProviderRolesDescription) throws Exception {

		try {
			System.out.println("um provider roles code" + umproviderRolesCode);
			Log.info("log4j msg- um provider roles code" + umproviderRolesCode);
			// <div class="form-control text-box-10-chactr ng-pristine
			// ng-untouched ng-valid ng-isolate-scope ng-not-empty
			// ng-valid-maxlength" title="ACSC-MCD">ACSC-MCD</div>
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"
							+ umproviderRolesCode + "']")));
			driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"
					+ umproviderRolesCode + "']")).click();
			System.out.println("clicked um provider roles Code");
			Log.info("log4j msg- clicked um provider roles code");

			wait.until(ExpectedConditions.visibilityOfElementLocated(UMProviderRolesCopyLink));
			driver.findElement(UMProviderRolesCopyLink).click();
			System.out.println("clicked Copy");
			Log.info("log4j msg- clicked Copy");

			System.out.println("um provider roles new code" + newumproviderRolesCode);
			Log.info("log4j msg- um provider roles new code" + newumproviderRolesCode);
			// enter new code
			wait.until(ExpectedConditions.visibilityOfElementLocated(UMProviderRolesCodeInput));
			driver.findElement(UMProviderRolesCodeInput).clear();
			driver.findElement(UMProviderRolesCodeInput).sendKeys(newumproviderRolesCode);
			System.out.println("Entered new code");
			Log.info("log4j msg- Entered new code");

			System.out.println("um provider roles new description" + newUMProviderRolesDescription);
			Log.info("log4j msg- um provider roles new description" + newUMProviderRolesDescription);
			// enter new description
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(UMProviderRolesDescriptionInput));
			driver.findElement(UMProviderRolesDescriptionInput).clear();
			driver.findElement(UMProviderRolesDescriptionInput).sendKeys(newUMProviderRolesDescription);
			System.out.println("Entered new description");
			Log.info("log4j msg- Entered new description");

			Thread.sleep(2000);

			// click save
			wait.until(ExpectedConditions.visibilityOfElementLocated(UMProviderRolesSaveLink));
			driver.findElement(UMProviderRolesSaveLink).click();

			Thread.sleep(1000);

			System.out.println("Clicked save");
			Log.info("log4j msg- clicked save");
			BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
			driver.quit();

			Thread.sleep(1000);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in Copying UM Provider Roles ");
			Log.info("log4j msg- Error in Copying UM Provider Roles ");
			BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
			driver.quit();
		}

	}

	// edit function
	public void editUMProviderRoles(String umproviderRolesCode, String UMProviderRolesDescription, String recordMark)
			throws Exception {

		try {
			System.out.println("um provider roles code" + umproviderRolesCode);
			Log.info("log4j msg- um provider roles code" + umproviderRolesCode);
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"
							+ umproviderRolesCode + "']")));
			driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"
					+ umproviderRolesCode + "']")).click();
			System.out.println("clicked UM Provider Roles");
			Log.info("log4j msg- clicked UM Provider Roles");

			wait.until(ExpectedConditions.visibilityOfElementLocated(UMProviderRolesEditLink));
			driver.findElement(UMProviderRolesEditLink).click();
			System.out.println("clicked Edit");
			Log.info("log4j msg- clicked Edit");

			System.out.println("um provider roles Record Mark" + recordMark);
			Log.info("log4j msg- um provider roles Record Mark" + recordMark);

			// enter new Record Mark

			wait.until(ExpectedConditions.visibilityOfElementLocated(UMProviderRolesRecordMark));
			driver.findElement(UMProviderRolesRecordMark).clear();
			Thread.sleep(1000);
			driver.findElement(UMProviderRolesRecordMark).sendKeys(recordMark);
			System.out.println("Entered new Record Mark");
			Log.info("log4j msg- Entered new Record Mark");

			// click save
			wait.until(ExpectedConditions.visibilityOfElementLocated(UMProviderRolesSaveLink));
			driver.findElement(UMProviderRolesSaveLink).click();
			System.out.println("Clicked save");
			Log.info("log4j msg- clicked save");
			BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
			driver.quit();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in Editing UM Provider Roles ");
			Log.info("log4j msg- Error in Editing UM Provider Roles ");
			BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
			driver.quit();
		}

	}

	// exit function
	public void exitUMProviderRoles(String umproviderRolesCode) throws Exception {
		try {
			System.out.println("um provider roles code" + umproviderRolesCode);
			Log.info("log4j msg- um provider roles code" + umproviderRolesCode);
			Thread.sleep(1000);
			driver.findElement(UMProviderRolesExitLink).click();
			Thread.sleep(1000);
			System.out.println("Clicked exit in  UM Provider Roles ");
			Log.info("log4j msg- clicked exit in  UM Provider Roles ");
			BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
			driver.quit();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in Exiting UM Provider Roles ");
			Log.info("log4j msg- Error in Exiting UM Provider Roles ");
			BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
			driver.quit();
		}
	}

	// add comm function
	public void addCommUMProviderRoles(String umproviderRolesCode, String subject, String NoteType, String medium,
			String notes) throws Exception {

		try {
			System.out.println("um provider roles code" + umproviderRolesCode);
			Log.info("log4j msg- um provider roles code" + umproviderRolesCode);
			// find um provider roles
			
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"
							+ umproviderRolesCode + "']")));
			driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"
					+ umproviderRolesCode + "']")).click();
			System.out.println("clicked UM Provider Roles Code");
			Log.info("log4j msg- clicked UM Provider Roles code");

			// click comm

			wait.until(ExpectedConditions.visibilityOfElementLocated(UMProviderRolesCommLink));
			driver.findElement(UMProviderRolesCommLink).click();
			System.out.println("clicked Comm");
			Log.info("log4j msg- clicked Comm");

			// click add
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")));
			driver.findElement(By
					.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]"))
					.click();

			System.out.println("clicked Add");
			Log.info("log4j msg- clicked Add");

			// enter subject
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtSubject']")));
			driver.findElement(By.xpath("//input[@id='txtSubject']")).sendKeys(subject);
			System.out.println("entered subject");
			Log.info("log4j msg- entered subject");

			// page down

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtFollowup']")));
			driver.findElement(By.xpath("//input[@id='txtFollowup']")).sendKeys(Keys.PAGE_DOWN);
			System.out.println("clicked page down");
			Log.info("log4j msg- clicked page down");

			// click add details
			// <button type="button" class="btn btn-primary btn-bottom01"
			// data-ng-click="addChildRecord()" style="">Add</button>

			// <button type="button" class="btn btn-primary btn-bottom01"
			// data-ng-click="addChildRecord()">Add</button>
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//button[@data-ng-click='addChildRecord()']")));
			driver.findElement(By.xpath("//button[@data-ng-click='addChildRecord()']")).click();
			System.out.println("clicked add details");
			Log.info("log4j msg- clicked add details");
			
			//Added wait
			Thread.sleep(3000);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='ddlNoteType']")));
			Select noteType = new Select(driver.findElement(By.xpath("//select[@id='ddlNoteType']")));
			noteType.selectByVisibleText(NoteType);
			System.out.println("selected note type");
			Log.info("log4j msg-selected note type");

			Thread.sleep(1000);
			// enter note details
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='txtNotes']")));
			driver.findElement(By.xpath("//textarea[@id='txtNotes']")).sendKeys(notes);
			System.out.println("entered notes details");
			Log.info("log4j msg- entered notes details");
			Thread.sleep(1000);

			// click hide
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-ng-click='closeMe()']")));
			driver.findElement(By.xpath("//button[@data-ng-click='closeMe()']")).click();
			System.out.println("clicked hide");
			Log.info("log4j msg- clicked hide");

			// click close case
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-ng-click='closeCase()']")));
			driver.findElement(By.xpath("//button[@data-ng-click='closeCase()']")).click();
			System.out.println("clicked close case");
			Log.info("log4j msg- clicked close case");

			// click save
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Save")));
			driver.findElement(By.linkText("Save")).click();
			System.out.println("clicked save");
			Log.info("log4j msg- clicked save");
			BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
			driver.quit();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in adding Comm to UM Provider Roles");
			Log.info("log4j msg - Error in adding Comm to  UM Provider Roles");
			BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
			driver.quit();
		}
	}

	// delete function
	public void deleteUMProviderRoles(String umproviderRolesCode) throws Exception {

		try {
			// find UM Provider Roles
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"
							+ umproviderRolesCode + "']")));
			driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"
					+ umproviderRolesCode + "']")).click();
			System.out.println("clicked UM Provider Roles Code");
			Log.info("log4j msg- clicked UM Provider Roles code");

			// click delete

			wait.until(ExpectedConditions.visibilityOfElementLocated(UMProviderRolesDeleteLink));
			driver.findElement(UMProviderRolesDeleteLink).click();
			System.out.println("clicked Delete");
			Log.info("log4j msg- clicked Delete");

			// click confirm delete

			wait.until(ExpectedConditions.visibilityOfElementLocated(confirmDeleteButton));
			driver.findElement(confirmDeleteButton).click();
			System.out.println("clicked confirm Delete");
			Log.info("log4j msg- clicked confirm Delete");
			BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
			driver.quit();

		} catch (Exception e) {
			System.out.println("Error in deleting UM Provider Roles");
			Log.info("log4j msg - Error in deleting UM Provider Roles");
			BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
			driver.quit();
		}
	}

}

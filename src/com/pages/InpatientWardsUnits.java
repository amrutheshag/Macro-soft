package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BrowserUtils;
import utility.Log;

public class InpatientWardsUnits {

	WebDriver driver;
	WebDriverWait wait;

	By InpatientWardsUnitsAddLink = By.linkText("Add");

	By inpatientwardsUnitsCodeInput = By.xpath("//input[@id='code']");

	By InpatientWardsUnitsDescriptionInput = By.xpath("//input[@id='name']");

	By InpatientWardsUnitsRecordMark = By.xpath("//input[@style='width:20px;']");

	By InpatientWardsUnitsValidateLink = By.linkText("Validate");

	By InpatientWardsUnitsValidateSaveOKButton = By.xpath("//button[@data-bb-handler='Success']");

	By InpatientWardsUnitsSaveLink = By.linkText("Save");

	By InpatientWardsUnitsEditLink = By.linkText("Edit");

	By InpatientWardsUnitsCopyLink = By.linkText("Copy");

	By InpatientWardsUnitsDeleteLink = By.linkText("Delete");

	By confirmDeleteButton = By.xpath("//button[@data-bb-handler='Success']");

	By InpatientWardsUnitsCommLink = By.linkText("Commun.");

	By InpatientWardsUnitsExitLink = By.linkText("Exit");

	public InpatientWardsUnits(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
	}

	// add function
	public void addInpatientWardsUnits(String inpatientwardsUnitsCode, String inpatientwardsUnitsDescription)
			throws Exception {

		try {

			wait.until(ExpectedConditions.visibilityOfElementLocated(InpatientWardsUnitsAddLink));
			driver.findElement(InpatientWardsUnitsAddLink).click();
			System.out.println("clicked Add");
			Log.info("log4j msg- clicked Add");

			System.out.println("inpatient wards/units code: " + inpatientwardsUnitsCode);
			Log.info("log4j msg- inpatient wards/units code: " + inpatientwardsUnitsCode);
			// enter code
			wait.until(ExpectedConditions.visibilityOfElementLocated(inpatientwardsUnitsCodeInput));
			driver.findElement(inpatientwardsUnitsCodeInput).sendKeys(inpatientwardsUnitsCode);
			Thread.sleep(1000);
			System.out.println("Entered code");
			Log.info("log4j msg- Entered code");

			System.out.println("inpatient wards/units description" + inpatientwardsUnitsDescription);
			Log.info("log4j msg- inpatient wards/units description" + inpatientwardsUnitsDescription);
			// enter Description
			wait.until(ExpectedConditions.visibilityOfElementLocated(InpatientWardsUnitsDescriptionInput));
			driver.findElement(InpatientWardsUnitsDescriptionInput).sendKeys(inpatientwardsUnitsDescription);
			Thread.sleep(1000);
			System.out.println("Entered description");
			Log.info("log4j msg- Entered description");

			// click validate

			wait.until(ExpectedConditions.visibilityOfElementLocated(InpatientWardsUnitsValidateLink));
			driver.findElement(InpatientWardsUnitsValidateLink).click();
			System.out.println("clicked validate");
			Log.info("log4j msg- clicked validate");

			// click ok

			wait.until(ExpectedConditions.visibilityOfElementLocated(InpatientWardsUnitsValidateSaveOKButton));
			driver.findElement(InpatientWardsUnitsValidateSaveOKButton).click();
			System.out.println("clicked validate ok to save button");
			Log.info("log4j msg- clicked validate ok to save button");

			// click save
			Thread.sleep(1000);

			wait.until(ExpectedConditions.visibilityOfElementLocated(InpatientWardsUnitsSaveLink));
			driver.findElement(InpatientWardsUnitsSaveLink).click();
			System.out.println("clicked save ");
			Log.info("log4j msg- clicked  save ");
			BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
			driver.quit();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in Adding Inpatient Wards/Units ");
			Log.info("log4j msg- Error in Adding Inpatient Wards/Units ");
			BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
			driver.quit();
		}

	}

	// copy function

	public void copyInpatientWardsUnits(String inpatientwardsUnitsCode, String newinpatientwardsUnitsCode,
			String newInpatientWardsUnitsDescription) throws Exception {

		try {

			System.out.println("inpatient wards/units code" + inpatientwardsUnitsCode);
			Log.info("log4j msg- inpatient wards/units code" + inpatientwardsUnitsCode);
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"
							+ inpatientwardsUnitsCode + "']")));
			driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"
					+ inpatientwardsUnitsCode + "']")).click();
			System.out.println("clicked inpatient wards/units Code");
			Log.info("log4j msg- clicked inpatient wards/units code");

			wait.until(ExpectedConditions.visibilityOfElementLocated(InpatientWardsUnitsCopyLink));
			driver.findElement(InpatientWardsUnitsCopyLink).click();
			System.out.println("clicked Copy");
			Log.info("log4j msg- clicked Copy");

			System.out.println("inpatient wards/units new code" + newinpatientwardsUnitsCode);
			Log.info("log4j msg- inpatient wards/units new code" + newinpatientwardsUnitsCode);
			// enter new code
			wait.until(ExpectedConditions.visibilityOfElementLocated(inpatientwardsUnitsCodeInput));
			driver.findElement(inpatientwardsUnitsCodeInput).clear();
			driver.findElement(inpatientwardsUnitsCodeInput).sendKeys(newinpatientwardsUnitsCode);
			System.out.println("Entered new code");
			Log.info("log4j msg- Entered new code");

			System.out.println("inpatient wards/units new description" + newInpatientWardsUnitsDescription);
			Log.info("log4j msg- inpatient wards/units new description" + newInpatientWardsUnitsDescription);
			// enter new description
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(InpatientWardsUnitsDescriptionInput));
			driver.findElement(InpatientWardsUnitsDescriptionInput).clear();
			driver.findElement(InpatientWardsUnitsDescriptionInput).sendKeys(newInpatientWardsUnitsDescription);
			System.out.println("Entered new description");
			Log.info("log4j msg- Entered new description");

			Thread.sleep(1000);

			// click save
			wait.until(ExpectedConditions.visibilityOfElementLocated(InpatientWardsUnitsSaveLink));
			driver.findElement(InpatientWardsUnitsSaveLink).click();

			Thread.sleep(1000);

			System.out.println("Clicked save");
			Log.info("log4j msg- clicked save");
			BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
			driver.quit();

			Thread.sleep(1000);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in Copying Inpatient Wards/Units ");
			Log.info("log4j msg- Error in Copying Inpatient Wards/Units ");
			BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
			driver.quit();
		}

	}

	// edit function
	public void editInpatientWardsUnits(String inpatientwardsUnitsCode, String InpatientWardsUnitsDescription,
			String recordMark) throws Exception {

		try {

			System.out.println("inpatient wards/units code" + inpatientwardsUnitsCode);
			Log.info("log4j msg- inpatient wards/units code" + inpatientwardsUnitsCode);
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"
							+ inpatientwardsUnitsCode + "']")));
			driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"
					+ inpatientwardsUnitsCode + "']")).click();
			System.out.println("clicked Inpatient Wards/Units");
			Log.info("log4j msg- clicked Inpatient Wards/Units");

			wait.until(ExpectedConditions.visibilityOfElementLocated(InpatientWardsUnitsEditLink));
			driver.findElement(InpatientWardsUnitsEditLink).click();
			System.out.println("clicked Edit");
			Log.info("log4j msg- clicked Edit");

			System.out.println("inpatient wards/units Record Mark" + recordMark);
			Log.info("log4j msg- inpatient wards/units Record Mark" + recordMark);

			// enter new Record Mark

			wait.until(ExpectedConditions.visibilityOfElementLocated(InpatientWardsUnitsRecordMark));
			driver.findElement(InpatientWardsUnitsRecordMark).clear();
			Thread.sleep(1000);
			driver.findElement(InpatientWardsUnitsRecordMark).sendKeys(recordMark);
			System.out.println("Entered new Record Mark");
			Log.info("log4j msg- Entered new Record Mark");

			// click save
			wait.until(ExpectedConditions.visibilityOfElementLocated(InpatientWardsUnitsSaveLink));
			driver.findElement(InpatientWardsUnitsSaveLink).click();
			System.out.println("Clicked save");
			Log.info("log4j msg- clicked save");
			BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
			driver.quit();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in Editing Inpatient Wards/Units ");
			Log.info("log4j msg- Error in Editing Inpatient Wards/Units ");
			BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
			driver.quit();
		}

	}

	// exit function
	public void exitInpatientWardsUnits(String inpatientwardsUnitsCode) throws Exception {
		try {
			System.out.println("inpatient wards/units code" + inpatientwardsUnitsCode);
			Log.info("log4j msg- inpatient wards/units code" + inpatientwardsUnitsCode);
			driver.findElement(InpatientWardsUnitsExitLink).click();
			Thread.sleep(1000);
			System.out.println("Clicked exit in  Inpatient Wards/Units ");
			Log.info("log4j msg- clicked exit in  Inpatient Wards/Units ");
			BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
			driver.quit();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in Exiting Inpatient Wards/Units ");
			Log.info("log4j msg- Error in Exiting Inpatient Wards/Units ");
			BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
			driver.quit();
		}
	}

	// add comm function
	public void addCommInpatientWardsUnits(String inpatientwardsUnitsCode, String subject, String NoteType,
			String medium, String notes) throws Exception {

		try {

			System.out.println("inpatient wards/units code" + inpatientwardsUnitsCode);
			Log.info("log4j msg- inpatient wards/units code" + inpatientwardsUnitsCode);
			// find inpatient wards/units
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"
							+ inpatientwardsUnitsCode + "']")));
			driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"
					+ inpatientwardsUnitsCode + "']")).click();
			System.out.println("clicked Inpatient Wards/Units Code");
			Log.info("log4j msg- clicked Inpatient Wards/Units code");

			// click comm

			wait.until(ExpectedConditions.visibilityOfElementLocated(InpatientWardsUnitsCommLink));
			driver.findElement(InpatientWardsUnitsCommLink).click();
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
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//button[@data-ng-click='addChildRecord()']")));
			driver.findElement(By.xpath("//button[@data-ng-click='addChildRecord()']")).click();
			System.out.println("clicked add details");
			Log.info("log4j msg- clicked add details");
			Thread.sleep(2000);
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
			System.out.println("Error in adding Comm to Inpatient Wards/Units");
			Log.info("log4j msg - Error in adding Comm to  Inpatient Wards/Units");
			BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
			driver.quit();
		}
	}

	// delete function
	public void deleteInpatientWardsUnits(String inpatientwardsUnitsCode) throws Exception {

		try {

			// find Inpatient Wards/Units
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"
							+ inpatientwardsUnitsCode + "']")));
			driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"
					+ inpatientwardsUnitsCode + "']")).click();
			System.out.println("clicked Inpatient Wards/Units Code");
			Log.info("log4j msg- clicked Inpatient Wards/Units code");

			// click delete

			wait.until(ExpectedConditions.visibilityOfElementLocated(InpatientWardsUnitsDeleteLink));
			driver.findElement(InpatientWardsUnitsDeleteLink).click();
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
			System.out.println("Error in deleting Inpatient Wards/Units");
			Log.info("log4j msg - Error in deleting Inpatient Wards/Units");
			BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
			driver.quit();
		}
	}

}

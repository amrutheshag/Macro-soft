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

public class AcademicDegrees {

	WebDriver driver;
	WebDriverWait wait;

	By AcademicDegreesCodeBeginsInput = By.xpath("//input[@id='txtCode']");

	By AcademicDegreesNameDescriptionBeginsInput = By.xpath("//input[@id='txtName']");

	By AcademicDegreesSearchButton = By.xpath("//button[@data-ng-click='search(0)']");

	By AcademicDegreesAddLink = By.linkText("Add");

	By AcademicDegreesCodeInput = By.xpath("//input[@id='code']");

	By AcademicDegreesDescriptionInput = By.xpath("//input[@id='name']");

	By AcademicDegreesRecordMark = By.xpath("//input[@style='width:20px;']");

	By AcademicDegreesValidateLink = By.linkText("Validate");

	By AcademicDegreesValidateSaveOKButton = By.xpath("//button[@data-bb-handler='Success']");

	By AcademicDegreesSaveLink = By.linkText("Save");

	By AcademicDegreesEditLink = By.linkText("Edit");

	By AcademicDegreesCopyLink = By.linkText("Copy");

	By AcademicDegreesDeleteLink = By.linkText("Delete");

	By confirmDeleteButton = By.xpath("//button[@data-bb-handler='Success']");

	By AcademicDegreesCommLink = By.linkText("Commun.");

	By AcademicDegreesExitLink = By.linkText("Exit");

	public AcademicDegrees(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 25);
	}

	public int searchAcademicDegrees(String AcademicDegreesCode, String AcademicDegreesName) throws Exception {

		try {
			// enter Academic Degrees code
			wait.until(ExpectedConditions.visibilityOfElementLocated(AcademicDegreesCodeBeginsInput));
			driver.findElement(AcademicDegreesCodeBeginsInput).clear();
			driver.findElement(AcademicDegreesCodeBeginsInput).sendKeys(AcademicDegreesCode);
			System.out.println("entered Academic Degrees  code");
			Log.info("log4j msg- entered Academic Degrees code");

			// enter Academic Degrees name
			wait.until(ExpectedConditions.visibilityOfElementLocated(AcademicDegreesNameDescriptionBeginsInput));
			driver.findElement(AcademicDegreesNameDescriptionBeginsInput).clear();
			driver.findElement(AcademicDegreesNameDescriptionBeginsInput).sendKeys(AcademicDegreesName);
			System.out.println("entered Academic Degrees name");
			Log.info("log4j msg- entered Academic Degrees name");

			// click search
			wait.until(ExpectedConditions.visibilityOfElementLocated(AcademicDegreesSearchButton));
			driver.findElement(AcademicDegreesSearchButton).click();
			System.out.println("clicked Search");
			Log.info("log4j msg- clicked Search");

			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"
							+ AcademicDegreesCode + "']")));
			WebElement e = driver
					.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"
							+ AcademicDegreesCode + "']"));
			e.click();
			System.out.println("Found AcademicDegrees");
			Log.info("log4j msg- Found AcademicDegrees");

			return 1;
		}

		catch (Exception e) {
			System.out.println("Academic Degrees Not found");
			Log.info("log4j msg- Academic Degrees Not found");
			return 0;
		}

	}

	// add function
	public void addAcademicDegrees(String AcademicDegreesCode, String AcademicDegreesDescription) throws Exception {

		try {
			int i = searchAcademicDegrees(AcademicDegreesCode, AcademicDegreesDescription);

			if (i == 0) {
				System.out.println("Academic Degrees not found, Continue with Add");
				Log.info("log4j msg- Academic Degrees not found, Continue with Add");

				wait.until(ExpectedConditions.visibilityOfElementLocated(AcademicDegreesAddLink));
				driver.findElement(AcademicDegreesAddLink).click();
				System.out.println("clicked Add");
				Log.info("log4j msg- clicked Add");

				System.out.println("Academic Degrees code: " + AcademicDegreesCode);
				Log.info("log4j msg- Academic Degrees code: " + AcademicDegreesCode);
				// enter code
				wait.until(ExpectedConditions.visibilityOfElementLocated(AcademicDegreesCodeInput));
				driver.findElement(AcademicDegreesCodeInput).sendKeys(AcademicDegreesCode);
				Thread.sleep(1000);
				System.out.println("Entered code");
				Log.info("log4j msg- Entered code");

				System.out.println("Academic Degrees description" + AcademicDegreesDescription);
				Log.info("log4j msg- Academic Degrees code: " + AcademicDegreesDescription);
				// enter Description
				wait.until(ExpectedConditions.visibilityOfElementLocated(AcademicDegreesDescriptionInput));
				driver.findElement(AcademicDegreesDescriptionInput).sendKeys(AcademicDegreesDescription);
				Thread.sleep(1000);
				System.out.println("Entered description");
				Log.info("log4j msg- Entered description");

				Thread.sleep(1000);
				// click validate

				wait.until(ExpectedConditions.visibilityOfElementLocated(AcademicDegreesValidateLink));
				driver.findElement(AcademicDegreesValidateLink).click();
				System.out.println("clicked validate");
				Log.info("log4j msg- clicked validate");

				// click ok

				wait.until(ExpectedConditions.visibilityOfElementLocated(AcademicDegreesValidateSaveOKButton));
				driver.findElement(AcademicDegreesValidateSaveOKButton).click();
				System.out.println("clicked validate ok to save button");
				Log.info("log4j msg- clicked validate ok to save button");

				// click save
				Thread.sleep(1000);

				wait.until(ExpectedConditions.visibilityOfElementLocated(AcademicDegreesSaveLink));
				driver.findElement(AcademicDegreesSaveLink).click();
				System.out.println("clicked save ");
				Log.info("log4j msg- clicked  save ");
				Thread.sleep(1000);
				BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
				driver.quit();

			} else {
				System.out.println("Academic Degrees is already present, cannot add Academic Degrees");
				Log.info("log4j msg- Academic Degrees is already present, cannot add Academic Degrees");
				wait.until(ExpectedConditions.visibilityOfElementLocated(AcademicDegreesExitLink));
				driver.findElement(AcademicDegreesExitLink).click();
				System.out.println("clicked Exit");
				Log.info("log4j msg- clicked Exit");
				Thread.sleep(1000);

				BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
				driver.quit();
			}

		} catch (Exception e) {
			System.out.println("Error in adding Academic Degrees");
			Log.info("log4j msg- Error in adding Academic Degrees");
			BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
			driver.quit();
		}
	}

	// copy function

	public void copyAcademicDegrees(String AcademicDegreesCode, String AcademicDegreesName,
			String newAcademicDegreesCode, String newAcademicDegreesDescription) throws Exception {

		try {

			int i = searchAcademicDegrees(AcademicDegreesCode, AcademicDegreesName);

			if (i == 1) {
				System.out.println("Academic Degrees found, continue with copy");
				Log.info("log4j msg-Academic Degrees found, continue with copy");

				System.out.println("Academic Degrees code" + AcademicDegreesCode);
				Log.info("log4j msg-Academic Degrees code" + AcademicDegreesCode);
				wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"
								+ AcademicDegreesCode + "']")));
				driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"
						+ AcademicDegreesCode + "']")).click();
				System.out.println("clicked Academic Degrees Code");
				Log.info("log4j msg- clicked Academic Degrees code");

				wait.until(ExpectedConditions.visibilityOfElementLocated(AcademicDegreesCopyLink));
				driver.findElement(AcademicDegreesCopyLink).click();
				System.out.println("clicked Copy");
				Log.info("log4j msg- clicked Copy");

				System.out.println("Academic Degrees new code" + newAcademicDegreesCode);
				Log.info("log4j msg- Academic Degrees new code" + newAcademicDegreesCode);
				// enter new code
				wait.until(ExpectedConditions.visibilityOfElementLocated(AcademicDegreesCodeInput));
				driver.findElement(AcademicDegreesCodeInput).clear();
				driver.findElement(AcademicDegreesCodeInput).sendKeys(newAcademicDegreesCode);
				System.out.println("Entered new code");
				Log.info("log4j msg- Entered new code");

				System.out.println("Academic Degrees new description" + newAcademicDegreesDescription);
				Log.info("log4j msg- Academic Degrees new description" + newAcademicDegreesDescription);
				// enter new description

				wait.until(ExpectedConditions.visibilityOfElementLocated(AcademicDegreesDescriptionInput));
				driver.findElement(AcademicDegreesDescriptionInput).clear();
				driver.findElement(AcademicDegreesDescriptionInput).sendKeys(newAcademicDegreesDescription);
				System.out.println("Entered new description");
				Log.info("log4j msg- Entered new description");

				// click save
				wait.until(ExpectedConditions.visibilityOfElementLocated(AcademicDegreesSaveLink));
				driver.findElement(AcademicDegreesSaveLink).click();

				System.out.println("Clicked save");
				Log.info("log4j msg- clicked save");
				Thread.sleep(1000);
				BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
				driver.quit();
			} else {
				System.out.println("Academic Degrees is not present, cannot copy Academic Degrees");
				Log.info("log4j msg- Academic Degrees is not present, cannot copy Academic Degrees");
				wait.until(ExpectedConditions.visibilityOfElementLocated(AcademicDegreesExitLink));
				driver.findElement(AcademicDegreesExitLink).click();
				System.out.println("clicked Exit");
				Log.info("log4j msg- clicked Exit");
				Thread.sleep(1000);
				BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
				driver.quit();
			}
		} catch (Exception e) {
			System.out.println("Error in copying Academic Degrees");
			Log.info("log4j msg- Error in copying Academic Degrees");
			BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
			driver.quit();

		}
	}

	// edit function
	public void editAcademicDegrees(String AcademicDegreesCode, String academicDegreesDescription, String recordMark)
			throws Exception {

		try {

			// WebDriverWait wait = new WebDriverWait(driver, 25);

			int i = searchAcademicDegrees(AcademicDegreesCode, academicDegreesDescription);

			if (i == 1) {
				System.out.println("Academic Degrees  found, Continue with Edit");
				Log.info("log4j msg- Academic Degrees  found, Continue with Edit");

				System.out.println("Academic Degrees code" + AcademicDegreesCode);
				Log.info("log4j msg- Academic Degrees code" + AcademicDegreesCode);
				wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"
								+ AcademicDegreesCode + "']")));
				driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"
						+ AcademicDegreesCode + "']")).click();
				System.out.println("clicked Academic Degrees Record Mark");
				Log.info("log4j msg- clicked Academic Degrees Record Mark");
				wait.until(ExpectedConditions.visibilityOfElementLocated(AcademicDegreesEditLink));
				driver.findElement(AcademicDegreesEditLink).click();
				System.out.println("clicked Edit");
				Log.info("log4j msg- clicked Edit");

				System.out.println("Academic Degrees Record Mark: " + recordMark);
				Log.info("log4j msg-Academic Degrees Record Mark: " + recordMark);

				// enter new description

				wait.until(ExpectedConditions.visibilityOfElementLocated(AcademicDegreesRecordMark));
				driver.findElement(AcademicDegreesRecordMark).clear();
				Thread.sleep(1000);
				driver.findElement(AcademicDegreesRecordMark).sendKeys(recordMark);
				System.out.println("Entered new Record Mark");
				Log.info("log4j msg- Entered new Record Mark");

				// click save
				wait.until(ExpectedConditions.visibilityOfElementLocated(AcademicDegreesSaveLink));
				driver.findElement(AcademicDegreesSaveLink).click();
				System.out.println("Clicked save");
				Log.info("log4j msg- clicked save");
				Thread.sleep(1000);
				BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
				driver.quit();
			} else {
				System.out.println("Academic Degrees not found, cannot edit Academic Degrees");
				Log.info("log4j msg- Academic Degrees not found, cannot edit Academic Degrees");
				BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
				driver.quit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in Editing Academic Degrees ");
			Log.info("log4j msg- Error in Editing Academic Degrees ");
			BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
			driver.quit();
		}

	}

	// exit function
	public void exitAcademicDegrees(String AcademicDegreesCode) throws Exception {
		try {
			System.out.println("Academic Degrees code" + AcademicDegreesCode);
			Log.info("log4j msg- Academic Degrees code" + AcademicDegreesCode);
			Thread.sleep(1000);
			driver.findElement(AcademicDegreesExitLink).click();
			Thread.sleep(1000);
			System.out.println("Clicked exit in  Academic Degrees ");
			Log.info("log4j msg- clicked exit in  Academic Degrees ");
			Thread.sleep(1000);
			BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in Exiting Academic Degrees ");
			Log.info("log4j msg- Error in Exiting Academic Degrees ");
			BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
			driver.quit();
		}
	}

	// add comm function
	public void addCommAcademicDegrees(String AcademicDegreesCode, String AcademicDegreesName,
			String AcademicDegreesCommsubject, String AcademicDegreesCommNoteType, String AcademicDegreesCommMedium,
			String AcademicDegreesCommDetails) throws Exception {

		try {
			int i = searchAcademicDegrees(AcademicDegreesCode, AcademicDegreesName);
			if (i == 1) {
				System.out.println("Academic Degrees  found, Continue with Add Communication");
				Log.info("log4j msg- Academic Degrees  found, Continue with Add Communication");
				System.out.println("Academic Degrees code" + AcademicDegreesCode);
				Log.info("log4j msg- Academic Degrees code" + AcademicDegreesCode);
				// find AcademicDegrees
				wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"
								+ AcademicDegreesCode + "']")));
				driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"
						+ AcademicDegreesCode + "']")).click();
				System.out.println("clicked Academic Degrees Code");
				Log.info("log4j msg- clicked Academic Degrees code");

				// click comm

				wait.until(ExpectedConditions.visibilityOfElementLocated(AcademicDegreesCommLink));
				driver.findElement(AcademicDegreesCommLink).click();
				System.out.println("clicked Comm");
				Log.info("log4j msg- clicked Comm");

				Thread.sleep(3000);
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
				driver.findElement(By.xpath("//input[@id='txtSubject']")).sendKeys(AcademicDegreesCommsubject);
				System.out.println("entered subject");
				Log.info("log4j msg- entered subject");

				// page down

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtFollowup']")));
				driver.findElement(By.xpath("//input[@id='txtFollowup']")).sendKeys(Keys.PAGE_DOWN);
				System.out.println("clicked page down");
				Log.info("log4j msg- clicked page down");

				Thread.sleep(8000);
				// click add details
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//button[@data-ng-click='addChildRecord()']")));
				driver.findElement(By.xpath("//button[@data-ng-click='addChildRecord()']")).click();
				System.out.println("clicked add details");
				Log.info("log4j msg- clicked add details");

				/* added thread */

				Thread.sleep(8000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlNoteType")));
				Select academicDegrees = new Select(driver.findElement(By.xpath("//select[@id='ddlNoteType']")));
				academicDegrees.selectByVisibleText(AcademicDegreesCommNoteType);
				System.out.println("selected note type");
				Log.info("log4j msg-selected note type");

				Thread.sleep(3000);
				// enter note details
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='txtNotes']")));
				driver.findElement(By.xpath("//textarea[@id='txtNotes']")).sendKeys(AcademicDegreesCommDetails);
				System.out.println("entered notes details");
				Log.info("log4j msg- entered notes details");
				Thread.sleep(1000);

				// click hide
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//button[@data-ng-click='closeMe()']")));
				driver.findElement(By.xpath("//button[@data-ng-click='closeMe()']")).click();
				System.out.println("clicked hide");
				Log.info("log4j msg- clicked hide");

				// click close case
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//button[@data-ng-click='closeCase()']")));
				driver.findElement(By.xpath("//button[@data-ng-click='closeCase()']")).click();
				System.out.println("clicked close case");
				Log.info("log4j msg- clicked close case");
				Thread.sleep(2000);
				// click save
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Save")));
				driver.findElement(By.linkText("Save")).click();
				System.out.println("clicked save");
				Log.info("log4j msg- clicked save");
				Thread.sleep(1000);

				BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
				driver.quit();
			}
		}

		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in adding Comm to Academic Degrees");
			Log.info("log4j msg - Error in adding Comm to  Academic Degrees");
			BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
			driver.quit();
		}

	}

	// delete function
	public void deleteAcademicDegrees(String AcademicDegreesCode, String AcademicDegreesDescription) throws Exception {

		try {
			int i = searchAcademicDegrees(AcademicDegreesCode, AcademicDegreesDescription);

			if (i == 1) {
				System.out.println("Academic Degrees found, continue with delete");
				Log.info("log4j msg-Academic Degrees found, continue with delete");

				// find AcademicDegrees
				wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"
								+ AcademicDegreesCode + "']")));
				driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"
						+ AcademicDegreesCode + "']")).click();
				System.out.println("clicked Academic Degrees Code");
				Log.info("log4j msg- clicked Academic Degrees code");

				// click delete

				wait.until(ExpectedConditions.visibilityOfElementLocated(AcademicDegreesDeleteLink));
				driver.findElement(AcademicDegreesDeleteLink).click();
				System.out.println("clicked Delete");
				Log.info("log4j msg- clicked Delete");

				// click confirm delete

				wait.until(ExpectedConditions.visibilityOfElementLocated(confirmDeleteButton));
				driver.findElement(confirmDeleteButton).click();
				System.out.println("clicked confirm Delete");
				Log.info("log4j msg- clicked confirm Delete");
				Thread.sleep(1000);
				BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
				driver.quit();
			} else {
				System.out.println("cannot find Academic Degrees, cannot delete Academic Degrees ");
				Log.info("log4j msg- cannot find Academic Degrees, cannot delete Academic Degrees ");
				wait.until(ExpectedConditions.visibilityOfElementLocated(AcademicDegreesExitLink));
				driver.findElement(AcademicDegreesExitLink).click();
				System.out.println("clicked Exit");
				Log.info("log4j msg- clicked Exit");
				Thread.sleep(1000);

				BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
				driver.quit();

			}
		} catch (Exception e) {
			System.out.println("Error in deleting Academic Degrees ");
			Log.info("log4j msg - Error in deleting Academic Degrees ");
			BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
			driver.quit();

		}
	}

}

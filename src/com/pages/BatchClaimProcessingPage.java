package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BrowserUtils;
import utility.Log;

public class BatchClaimProcessingPage {
	
	WebDriver driver;
	WebDriverWait wait;

	By BatchNumberInput = By.id("txtSearchCode");

	By DispositionToProcessInput = By.id("txtClaimDisposition");

	By ProcessButton = By.xpath("//button[@class='btn btn-primary pull-right' and text()='Process']");

	By ClaimBatchConfirmOKButton = By.xpath("//button[@class='btn btn-primary btn-bottom02' and text()='OK']");

	By ConfirmCancelYesButton = By.xpath("//button[@class='btn btn-primary btn-bottom02' and text()='Yes']");

	By ConfirmDispositionProcessOKButton = By.xpath("//button[@class='btn btn-primary btn-bottom02' and text()='OK']");

	By CancelButton = By.xpath("//button[@data-ng-click='cancelSection.cancel()' and text()='Cancel']");

	By OKButton = By.xpath("//button[text()='OK']");

	public BatchClaimProcessingPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 20);
	}

	public void batchNumberProcess(String batchNo) throws Exception {
		
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(BatchNumberInput));
			driver.findElement(BatchNumberInput).sendKeys(batchNo);
			System.out.println("entered batch number");
			Log.info("log4j - msg- entered batch number");

			Thread.sleep(2000);

			// click process

			wait.until(ExpectedConditions.visibilityOfElementLocated(ProcessButton));
			driver.findElement(ProcessButton).click();
			System.out.println("clicked process button");
			Log.info("log4j - msg- clicked process button");

			// click ok to confirm
			wait.until(ExpectedConditions.visibilityOfElementLocated(ClaimBatchConfirmOKButton));
			driver.findElement(ClaimBatchConfirmOKButton).click();
			System.out.println("clicked ok");
			Log.info("log4j - msg- clicked ok");
			BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
			
			driver.quit();
		} catch (Exception e) {
			System.out.println("error in Batch NUmber Process");
			Log.info("error in Batch NUmber Process");
			BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
			
			driver.quit();
		}
	}

	public void dispositionProcess( String disposition) throws Exception {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(DispositionToProcessInput));
			driver.findElement(DispositionToProcessInput).sendKeys(disposition);
			System.out.println("entered disposition");
			Log.info("log4j - msg- entered disposition");

			Thread.sleep(2000);

			// click process

			wait.until(ExpectedConditions.visibilityOfElementLocated(ProcessButton));
			driver.findElement(ProcessButton).click();
			System.out.println("clicked process button");
			Log.info("log4j - msg- clicked process button");

			// click ok to confirm
			wait.until(ExpectedConditions.visibilityOfElementLocated(ConfirmDispositionProcessOKButton));
			driver.findElement(ConfirmDispositionProcessOKButton).click();
			System.out.println("clicked ok");
			Log.info("log4j - msg- clicked ok");
			BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
			
			driver.quit();
		} catch (Exception e) {
			System.out.println("error in Disposition Process");
			Log.info("error in Disposition Process");
			BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
			
			driver.quit();
		}
	}

	public void dispositionCancel(String disposition) throws Exception {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(DispositionToProcessInput));
			driver.findElement(DispositionToProcessInput).sendKeys(disposition);
			System.out.println("entered disposition");
			Log.info("log4j - msg- entered disposition");

			Thread.sleep(2000);

			// click cancel

			wait.until(ExpectedConditions.visibilityOfElementLocated(CancelButton));
			driver.findElement(CancelButton).click();
			System.out.println("clicked cancel button");
			Log.info("log4j - msg- clicked cancel button");

			// click ok to confirm
			wait.until(ExpectedConditions.visibilityOfElementLocated(ConfirmCancelYesButton));
			driver.findElement(ConfirmCancelYesButton).click();
			System.out.println("clicked cancel yes");
			Log.info("log4j - msg- clicked cancel yes");

			try {
				// click ok to confirm
				wait.until(ExpectedConditions.visibilityOfElementLocated(OKButton));
				driver.findElement(OKButton).click();
				System.out.println("clicked ok");
				Log.info("log4j - msg- clicked ok");

			} catch (Exception e) {
				System.out.println("no ok button");
			}
			BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
			driver.quit();
			
		} catch (Exception e) {
			System.out.println("error in Disposition cancel batch process");
			Log.info("error in Disposition cancel batch process");
			BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
			driver.quit();
			
		}
	}

	public void batchNumberCancel(String batchNo) throws Exception {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(BatchNumberInput));
			driver.findElement(BatchNumberInput).sendKeys(batchNo);
			System.out.println("entered batch number");
			Log.info("log4j - msg- entered batch number");

			Thread.sleep(2000);

			// click cancel

			wait.until(ExpectedConditions.visibilityOfElementLocated(CancelButton));
			driver.findElement(CancelButton).click();
			System.out.println("clicked cancel button");
			Log.info("log4j - msg- clicked cancel button");

			// click yes to confirm
			wait.until(ExpectedConditions.visibilityOfElementLocated(ConfirmCancelYesButton));
			driver.findElement(ConfirmCancelYesButton).click();
			System.out.println("clicked yes");
			Log.info("log4j - msg- clicked yes");
			try {
				// click ok to confirm
				wait.until(ExpectedConditions.visibilityOfElementLocated(OKButton));
				driver.findElement(OKButton).click();
				System.out.println("clicked ok");
				Log.info("log4j - msg- clicked ok");

			} catch (Exception e) {
				System.out.println("no ok button");
			}
			BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
			driver.quit();
		} catch (Exception e) {
			System.out.println("error in Batch NUmber Process");
			Log.info("error in Batch NUmber Process");
			BrowserUtils.takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
			driver.quit();
		
		}
	}

	

}

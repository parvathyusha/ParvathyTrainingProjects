package ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import utilityClasses.GeneralUtilities;

public class ReportPage {
	WebDriver driver;
	GeneralUtilities generalUtility = new GeneralUtilities();

	@FindBy(xpath = "//div[@id='w0-collapse']//a[@href='/payrollapp/report/payslip']")
	WebElement reportStepper;

	@FindBy(xpath = "//input[@id='ratesearch-created_at_range']")
	WebElement datePicker;

	@FindBy(xpath = "//span[@id='select2-ratesearch-worker_id-container']")
	WebElement workersId;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement searchBttn;

	@FindBy(xpath = "//button[@class='btn btn-default dropdown-toggle']")
	WebElement exportButtn;

	public ReportPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void callImplictWait(long time) {
		generalUtility.applyImplicitWait(driver, time);
	}

	public void clickReportStepper() {
		reportStepper.click();
	}

	public void enterDateValue() {
		datePicker.sendKeys("01-01-2020-31-12-2020");
	}

	public void clickSearchBttn() {
		searchBttn.click();
	}

	public void delayInWorkersPage() throws InterruptedException {
		generalUtility.threadDelay();
	}

	public void selectWorkerIdDropDown() {
		generalUtility.selectDropDown(workersId, "Goutham  Vijay");
	}

	public boolean toolTipExportButtn() {
		boolean toolExport = generalUtility.getAttributeValue(exportButtn, "title", "Export");
		return toolExport;

	}
}

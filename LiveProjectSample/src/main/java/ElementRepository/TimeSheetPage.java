package ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import utilityClasses.GeneralUtilities;

public class TimeSheetPage {
	WebDriver driver;
	GeneralUtilities generalUtility = new GeneralUtilities();

	@FindBy(xpath = "//div[@id='w0-collapse']//a[@href='/payrollapp/timesheet/index']")
	WebElement timeSheetStepper;

	@FindBy(xpath = "//button[text()='Generate Invoice']")
	WebElement generateInvoice;

	@FindBy(xpath = "//div[@class='col-sm-6 page-title']")
	WebElement timeSheetTitle;

	@FindBy(xpath = "//table[@class='table table-striped table-bordered']//tr[1]//span[@class='glyphicon glyphicon-eye-open']")
	WebElement viewBttn;

	@FindBy(xpath = "//div[@class='col-sm-6 page-title']")
	WebElement pageText;

	public TimeSheetPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void delayInTimeSheetPage() throws InterruptedException {
		generalUtility.threadDelay();
	}

	public void clickTimeSheetHeader() {
		timeSheetStepper.click();
	}

	public void callImplictWait(long time) {
		generalUtility.applyImplicitWait(driver, time);
	}

	public void clickGenerateInvoice() throws InterruptedException {
		generateInvoice.click();
		generalUtility.acceptTheAlerts(driver);
		generalUtility.threadDelay();
		generalUtility.threadDelay();
		generalUtility.acceptTheAlerts(driver);
	}

	public String getTextOfTimeSheetPage() {
		String titleValue = generalUtility.getElementText(timeSheetTitle);
		System.out.println(titleValue);
		return titleValue;
	}

	public void clickViewButtn() {
		viewBttn.click();
	}

	public String getTextValueOfViewPage() {
		String textPageValue = generalUtility.getElementText(pageText);
		return textPageValue;

	}
}

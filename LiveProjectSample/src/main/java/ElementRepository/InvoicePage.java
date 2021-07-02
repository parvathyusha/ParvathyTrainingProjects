package ElementRepository;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import utilityClasses.GeneralUtilities;

public class InvoicePage {
	WebDriver driver;
	GeneralUtilities generalUtility = new GeneralUtilities();

	@FindBy(xpath = "//div[@id='w0-collapse']//a[@href='/payrollapp/invoice/index']")
	WebElement invoiceStepper;

	@FindBy(xpath = "//tr[1]//span[@class='glyphicon glyphicon-paperclip']")
	WebElement pdfBttn;

	public InvoicePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void callImplictWait(long time) {
		generalUtility.applyImplicitWait(driver, time);
	}

	public void delayInInvoicePage() throws InterruptedException {
		generalUtility.threadDelay();
	}

	public void clickInvoiceHeader() {
		invoiceStepper.click();
	}

	public String clickPDFButtn() throws InterruptedException {
		pdfBttn.click();
		String parentWindow = generalUtility.getWindowHandle(driver);
		System.out.println(parentWindow);
		Set<String> allWindows = generalUtility.getWindowHandles(driver);
		Iterator<String> iterate = allWindows.iterator();
		while (iterate.hasNext()) {
			String childWindow = iterate.next();
			System.out.println(childWindow);
			if (!parentWindow.equalsIgnoreCase(childWindow)) {
				generalUtility.SwitchToWindow(driver, childWindow);
				generalUtility.threadDelay();
			}
		}
		generalUtility.SwitchToWindow(driver, parentWindow);
		String currentParentUrl = generalUtility.getCurrentUrl(driver);
		System.out.println(currentParentUrl);
		return currentParentUrl;
	}
}

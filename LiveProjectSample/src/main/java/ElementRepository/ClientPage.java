package ElementRepository;

import java.util.ArrayList;
import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilityClasses.GeneralUtilities;

public class ClientPage {
	WebDriver driver;
	GeneralUtilities generalUtility = new GeneralUtilities();

	@FindBy(xpath = "//div[@id='w0-collapse']//a[text()='Clients']")
	WebElement clientStepper;

	@FindBy(xpath = "//ul[@id='w3']//li[3]")
	WebElement clientMain;

	@FindBy(xpath = "//a[text()='Create Client']")
	WebElement createClient;

	@FindBy(xpath = "//select[@id='client-branch_id']")
	WebElement branchDropdown;

	@FindBy(xpath = "//form[@id='w0']//button[@type='submit']")
	WebElement clientSaveButtn;

	@FindBy(xpath = "//input[@id='clientsearch-client_name']")
	WebElement clientName;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement searchBttn;

	@FindBy(xpath = "//a[@href='/payrollapp/client/update?id=585']//span[@class='glyphicon glyphicon-pencil']")
	WebElement clientEditBttn;

	@FindBy(xpath = "//select[@id='client-vat_rate']")
	WebElement vatRate;

	@FindBy(xpath = "//input[@id='client-require_po']")
	WebElement requiredPro;

	@FindBy(xpath = "//div[@class='col-sm-6 page-title']")
	WebElement dafHeader;

	@FindBy(xpath = "//a[@href='/payrollapp/client/view?id=585']//span[@class='glyphicon glyphicon-eye-open']")
	WebElement viewOption;

	@FindBy(xpath = "//div[@class='form-group field-client-vat_rate required has-error']//div[@class='help-block']")
	WebElement vatRateText;

	@FindBy(xpath = "//li[3]//a[@href='/payrollapp/client/index?page=2']")
	WebElement scndPagination;

	@FindBy(xpath = "//div[@id='w1']//li[3]")
	WebElement classScndPagination;

	@FindBy(xpath = "//table[@class='table table-striped table-bordered']//tr[1]//td[1]")
	WebElement dafFilterGrid;

	public ClientPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void delayInClientsPage() throws InterruptedException {
		generalUtility.threadDelay();
	}

	public void clickClientHeader() {
		clientStepper.click();
	}

	public void callImplictWait(long time) {
		generalUtility.applyImplicitWait(driver, time);
	}

	public boolean verifyClientHeader() {
		boolean clientAttrbtValue = generalUtility.getAttributeValue(clientMain, "class", "active");
		return clientAttrbtValue;
	}

	public void clickCreateClient() {
		createClient.click();
	}

	public void selectBranchDropDown() {
		generalUtility.selectDropDown(branchDropdown, "Alpha_new");
	}

	public void clickSaveButtonClientPage() {
		clientSaveButtn.click();
	}

	public void enterClientName(String clientNameValue) {
		clientName.sendKeys(clientNameValue);
	}

	public void clickSearchBttn() {
		searchBttn.click();
	}

	public void clickEditBtTn() {
		clientEditBttn.click();

	}

	public void selectVatRateDropdwn() {
		generalUtility.selectDropDown(vatRate, "VAT 20.00%");
	}

	public String verifyTheTextOFVatRate() {
		String vatText = generalUtility.getElementText(vatRateText);
		return vatText;

	}

	public void unSelectRequiredProCheckBox() {
		requiredPro.click();
	}

	public String verifyEditedclientHeader() {

		String userValue = generalUtility.getElementText(dafHeader);
		return userValue;

	}

	public void viewExistingClientDetals() {
		viewOption.click();
	}

	public void clickScndPage() {
		scndPagination.click();
	}

	public boolean verifyScndPageActive() {
		boolean scndPageValue = generalUtility.getAttributeValue(classScndPagination, "class", "active");
		return scndPageValue;
	}

	public String getTheTextOfFilterGrid() {
		String actualtextValue = generalUtility.getElementText(dafFilterGrid);
		System.out.println(actualtextValue);
		return actualtextValue;

	}

	public void scrollDownTheClientPage() {
		generalUtility.scrollDown(driver);
	}
}

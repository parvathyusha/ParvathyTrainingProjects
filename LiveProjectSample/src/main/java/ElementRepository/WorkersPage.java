package ElementRepository;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import utilityClasses.GeneralUtilities;

public class WorkersPage {
	WebDriver driver;
	GeneralUtilities generalUtility = new GeneralUtilities();
	@FindBy(xpath = "//li[4]//a[text()='Workers']")
	WebElement workersHeader;

	@FindBy(xpath = "//ul[@id='w3']//li[4]")
	WebElement workersMain;

	@FindBy(xpath = "//input[@id='workersearch-first_name']")
	WebElement firstName;

	@FindBy(xpath = "//input[@id='worker-first_name']")
	WebElement firstNameCreateClient;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement searchBttn;

	@FindBy(xpath = "//a[3]//span[@class='glyphicon glyphicon-trash']")
	WebElement deleteBttn;

	@FindBy(xpath = "//div[text()='No results found.']")
	WebElement deletedMessage;

	@FindBy(xpath = "//div[@class='col-sm-6 page-title']")
	WebElement workersTitle;

	@FindBy(xpath = "//table[@class='table table-striped table-bordered']//tr[1]//td[2]")
	WebElement partWorker;

	@FindBy(xpath = "//a[1]//span[@class='glyphicon glyphicon-eye-open']")
	WebElement viewWorker;

	@FindBy(xpath = "//a[2]//span[@class='glyphicon glyphicon-pencil']")
	WebElement updateButtn;

	@FindBy(xpath = "//input[@class='form-control krajee-datepicker']")
	WebElement datePicker;

	@FindBy(xpath = "//button[text()='Next']")
	WebElement nextBttnUpdatePage;

	@FindBy(xpath = "//input[@class='form-control krajee-datepicker']")
	WebElement startDate;

	@FindBy(xpath = "//div[@class='col-lg-12 col-sm-12']//button[@type='submit']")
	WebElement submitBtnUpdatePage;

	@FindBy(xpath = "//div[@class='col-sm-6 breadcrumb-navigation']//li[2]")
	WebElement workersEabledHeader;

	@FindBy(xpath = "//select[@id='worker-division_id']")
	WebElement division;

	@FindBy(xpath = "//div[@class='form-group field-worker-division_id required has-error']//div[@class='help-block']")
	WebElement divisionError;

	@FindBy(xpath = "//select[@id='worker-branch_id']")
	WebElement branch;

	@FindBy(xpath = "//input[@id='worker-last_name']")
	WebElement lastName;

	@FindBy(xpath = "//input[@id='worker-dob']")
	WebElement dateOfBirth;

	@FindBy(xpath = "//select[@id='worker-employment_type']")
	WebElement employementType;

	@FindBy(xpath = "//input[@id='worker-address1']")
	WebElement addressLine1;

	@FindBy(xpath = "//select[@id='worker-payslip_method']")
	WebElement payslipMethod;

	@FindBy(xpath = "//input[@id='worker-phone']")
	WebElement phone;

	@FindBy(xpath = "//input[@id='worker-postcode']")
	WebElement postCode;

	@FindBy(xpath = "//input[@id='worker-ni_number']")
	WebElement niNumber;

	@FindBy(xpath = "//input[@id='worker-email']")
	WebElement email;

	@FindBy(xpath = "//select[@id='worker-gender']")
	WebElement gender;

	@FindBy(xpath = "//div[@class='col-lg-2 col-sm-4 left-menu no-padding']//a[@href='/payrollapp/worker/create']")
	WebElement createClient;

	@FindBy(xpath = "//input[@id='worker-ac_name']")
	WebElement accountName;

	@FindBy(xpath = "//input[@id='worker-ac_no']")
	WebElement accountNumber;

	@FindBy(xpath = "//input[@id='worker-sort_code']")
	WebElement sortCode;

	@FindBy(xpath = "//div[@class='col-sm-6 page-title']")
	WebElement pageTitleOfCreatedClient;

	@FindBy(xpath = "//div[@class='col-sm-6 page-title']")
	WebElement createWorkerHeader;

	public void callImplictWait(long time) {
		generalUtility.applyImplicitWait(driver, time);
	}

	public WorkersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickWorkerHeader() {
		workersHeader.click();
	}

	public boolean verifyWorkersHeader() {
		boolean clientAttrbtValue = generalUtility.getAttributeValue(workersMain, "class", "active");
		return clientAttrbtValue;
	}

	public void enterFirstName(String firstNameValue) {
		firstName.sendKeys(firstNameValue);
	}

	public void clickSearchBttn() {
		searchBttn.click();
	}

	public void clickDeleteButtn() {
		deleteBttn.click();
	}

	public void clickOkToDelete() {
		generalUtility.acceptTheAlerts(driver);
	}

	public String getDeletedMessage() {
		String deleteMessage = generalUtility.getElementText(deletedMessage);
		return deleteMessage;
	}

	public void delayInWorkersPage() throws InterruptedException {
		generalUtility.threadDelay();
	}

	public String verifyWorkersText() {
		String workersText = generalUtility.getElementText(workersHeader);
		return workersText;
	}

	public String getTextOFPartWorker() {
		String partWorkerText = generalUtility.getElementText(partWorker);
		return partWorkerText;

	}

	public void clickViewWorker() {
		viewWorker.click();
	}

	public String getTheTextOfViewWorkerPage() {
		String workTitle = generalUtility.getElementText(workersTitle);
		return workTitle;
	}

	public void clickUpdateButtn() {
		updateButtn.click();

	}

	public void enterDatePickerValue(String rdate) {
		datePicker.sendKeys(rdate);
	}

	public void clickNextBttnUpdatePage() {
		nextBttnUpdatePage.click();
	}

	public void enterStartDate(String startDateTime) {
		startDate.sendKeys(startDateTime);
	}

	public void clickSubmitBttnUpdatePage() {
		submitBtnUpdatePage.click();
	}

	public boolean workersHeaderEnabledOrNot() {
		boolean enabledValue = generalUtility.isEnabledOrNot(workersEabledHeader);
		return enabledValue;

	}

	public void selectDivisionDropDown() {
		generalUtility.selectDropDown(division, "-- Please Select --");
	}

	public String getErrorMessageDivisionFieldBlank() {
		String errorMessage = generalUtility.getElementText(divisionError);
		return errorMessage;
	}

	public boolean workersDisplayed() {
		boolean displayedValue = generalUtility.isDisplayedOrNot(workersEabledHeader);
		return displayedValue;

	}

	public void clickCreateClient() {
		createClient.click();
	}

	public void enterFirstNameFull(String firstNameValue) {
		firstNameCreateClient.sendKeys(firstNameValue);
	}

	public void enterBranch(String branchValue) {
		branch.sendKeys(branchValue);
	}

	public void enterLastName(String LastNameValue) {
		lastName.sendKeys(LastNameValue);
	}

	public void enterPhoneNumber(String phoneNumberValue) {
		phone.sendKeys(phoneNumberValue);
	}

	public void enterEmail(String emailAddress) {
		email.sendKeys(emailAddress);
	}

	public void enterGender(String genderValue) {
		gender.sendKeys(genderValue);
	}

	public void enterDateOfBirth(String dob) {
		dateOfBirth.sendKeys(dob);
	}

	public void enterAddressLine1(String address) {
		addressLine1.sendKeys(address);
	}

	public void enterTheBranch(String branchValue) {
		branch.sendKeys(branchValue);
	}

	public void enterTheDivision(String divisionValue) {
		division.sendKeys(divisionValue);
	}

	public void enterTheEmploymentType(String employmntTypeValue) {
		employementType.sendKeys(employmntTypeValue);
	}

	public void enterPaySlipMethod(String payslipMethodValue) {
		payslipMethod.sendKeys(payslipMethodValue);
	}

	public void enterPostCode(String postCodeValue) {
		postCode.sendKeys(postCodeValue);
	}

	public void enterNiNumber(String niNumberValue) {
		niNumber.sendKeys(niNumberValue);
	}

	public void enterAccountName(String accountNameValue) {
		accountName.sendKeys(accountNameValue);
	}

	public void enterAccountNumber(String accountNumberValue) {
		accountNumber.sendKeys(accountNumberValue);
	}

	public void enterSortCode(String sortCodeValue) {
		sortCode.sendKeys(sortCodeValue);
	}

	public String getTextOfCreatedClient() {
		String textValue = generalUtility.getElementText(pageTitleOfCreatedClient);
		System.out.println(textValue);
		return textValue;
	}

	public void dynamicLocatorEdit(String editIcon) {
		String locator = "//table[@class='table table-striped table-bordered']//tr//td[1]";
		List<WebElement> firstColumns = driver.findElements(By.xpath(locator));
		List<String> textValues = new ArrayList<String>();
		// System.out.println(firstColumns);
		for (int i = 0; i < firstColumns.size(); i++) {
			textValues.add(firstColumns.get(i).getText());
		}

		for (int j = 0; j < textValues.size(); j++) {
			if (textValues.get(j).contentEquals(editIcon)) {
				j = j + 1;
				String expectedLocator = "//table[@class='table table-striped table-bordered']//tr[" + j
						+ "]//td[8]//a[2]";
				WebElement locatorElement = driver.findElement(By.xpath(expectedLocator));
				locatorElement.click();
			}
		}

	}

	public void selectDateFromDatePicker() {
		dateOfBirth.click();
		String expectedDate = "October 2021";
		while (true) {
			String currentDate = "(//table[@class='table-condensed']//tr[2]//th[2])[1]";
			WebElement currentDateElement = driver.findElement(By.xpath(currentDate));
			String currentDateText = generalUtility.getElementText(currentDateElement);
			if (currentDateText.equals(expectedDate)) {
				break;
			} else {
				WebElement nextButtnDatePicker = driver
						.findElement(By.xpath("(//table[@class='table-condensed']//tr[2]//th[3])[1]"));
				nextButtnDatePicker.click();
			}
		}
		WebElement actualDate = driver.findElement(By.xpath("//table[@class='table-condensed']//tr[2]//td[4]"));
		actualDate.click();
	}

	public void clearText() {
		dateOfBirth.clear();
	}

	public String getTextOfCreateWorkerHeader() {
		String actualText = generalUtility.getElementText(createWorkerHeader);
		System.out.println(actualText);
		return actualText;

	}

	public void scrollThePage() {
		generalUtility.scrollDown(driver);
	}
}

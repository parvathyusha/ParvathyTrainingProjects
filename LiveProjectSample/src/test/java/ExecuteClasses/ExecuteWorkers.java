package ExecuteClasses;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import ElementRepository.LoginPage;
import ElementRepository.WorkersPage;
import utilityClasses.DataProviderExcel;

public class ExecuteWorkers extends BaseClass {
	DataProviderExcel excel = new DataProviderExcel();
	LoginPage login;
	WorkersPage workers;

	@Test(enabled = false)
	public void testcase12VerifyWorkersHeaderHighlighted() throws InterruptedException {
		login = new LoginPage(driver);
		login.enterUserName("carol");
		login.enterPassword("1q2w3e4r");
		login.clickLogin();
		workers = new WorkersPage(driver);
		workers.clickWorkerHeader();
		workers.verifyWorkersHeader();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(workers.verifyWorkersHeader());
		softAssert.assertAll();
	}

	@Test(enabled = false)
	public void testcase13FilterOnlyWithFirstName() throws InterruptedException {
		login = new LoginPage(driver);
		login.enterUserName("carol");
		login.enterPassword("1q2w3e4r");
		login.clickLogin();
		workers = new WorkersPage(driver);
		workers.callImplictWait(10);
		workers.clickWorkerHeader();
		workers.enterFirstName("goutham");
		workers.clickSearchBttn();
		String expectedText = "Goutham Vijay";
		workers.delayInWorkersPage();
		Assert.assertEquals(workers.getTextOFPartWorker(), expectedText);

	}

	@Test(enabled = false)
	public void testcase14DeleteTheExistedWorkersDetails() throws InterruptedException {
		login = new LoginPage(driver);
		login.enterUserName("carol");
		login.enterPassword("1q2w3e4r");
		login.clickLogin();
		workers = new WorkersPage(driver);
		workers.delayInWorkersPage();
		workers.clickWorkerHeader();
		workers.enterFirstName("testprint");
		workers.delayInWorkersPage();
		workers.clickSearchBttn();
		workers.delayInWorkersPage();
		workers.clickDeleteButtn();
		workers.delayInWorkersPage();
		workers.clickOkToDelete();
		String expectedTilte = "Workers";
		Assert.assertEquals(workers.verifyWorkersText(), expectedTilte);

	}

	@Test(enabled = false)

	public void tescase15FilterWihDeletedWorkersDetails() throws InterruptedException {
		login = new LoginPage(driver);
		login.enterUserName("carol");
		login.enterPassword("1q2w3e4r");
		login.clickLogin();
		workers = new WorkersPage(driver);
		workers.delayInWorkersPage();
		workers.clickWorkerHeader();
		workers.enterFirstName("testdummy");
		workers.delayInWorkersPage();
		workers.clickSearchBttn();
		String expectedMessage = "No results found.";
		workers.delayInWorkersPage();
		Assert.assertEquals(workers.getDeletedMessage(), expectedMessage);
	}

	@Test(enabled = false)
	public void testcase16ViewTheExistingWorkerDetails() throws InterruptedException {
		login = new LoginPage(driver);
		login.enterUserName("carol");
		login.enterPassword("1q2w3e4r");
		login.clickLogin();
		workers = new WorkersPage(driver);
		workers.clickWorkerHeader();
		workers.enterFirstName("goutham");
		workers.clickSearchBttn();
		workers.delayInWorkersPage();
		workers.clickViewWorker();
		String expectedText = "GOUTHAM VIJAY";
		workers.delayInWorkersPage();
		Assert.assertEquals(workers.getTheTextOfViewWorkerPage(), expectedText);

	}

	@Test(enabled = false)
	public void testcase17UpdateTheExistingWorkersDetails() throws InterruptedException {
		login = new LoginPage(driver);
		login.enterUserName("carol");
		login.enterPassword("1q2w3e4r");
		login.clickLogin();
		workers = new WorkersPage(driver);
		workers.callImplictWait(10);
		workers.clickWorkerHeader();
		workers.enterFirstName("goutham");
		workers.clickSearchBttn();
		workers.delayInWorkersPage();
		workers.clickUpdateButtn();
		workers.clearText();
		workers.enterDatePickerValue("30-11-1994");
		workers.scrollThePage();
		workers.clickNextBttnUpdatePage();
		workers.delayInWorkersPage();
		workers.enterStartDate("22-05-2021");
		workers.callImplictWait(10);
		workers.clickSubmitBttnUpdatePage();
		String expectedText = "GOUTHAM VIJAY";
		workers.delayInWorkersPage();
		Assert.assertEquals(workers.getTheTextOfViewWorkerPage(), expectedText);
	}

	@Test(enabled = false)
	public void testcase18WorkersHeaderIsEnabledOrNot() {
		login = new LoginPage(driver);
		login.enterUserName("carol");
		login.enterPassword("1q2w3e4r");
		login.clickLogin();
		workers = new WorkersPage(driver);
		workers.clickWorkerHeader();
		Assert.assertTrue(workers.workersHeaderEnabledOrNot());
	}

	@Test(enabled = false)
	public void testcase19SaveTheWorkerDetailsWithoutMandatoryfields() throws InterruptedException {
		login = new LoginPage(driver);
		login.enterUserName("carol");
		login.enterPassword("1q2w3e4r");
		login.clickLogin();
		workers = new WorkersPage(driver);
		workers.callImplictWait(10);
		workers.clickWorkerHeader();
		workers.enterFirstName("goutham");
		workers.clickSearchBttn();
		workers.delayInWorkersPage();
		workers.clickUpdateButtn();
		workers.selectDivisionDropDown();
		String expectedError = "Division cannot be blank.";
		Assert.assertEquals(expectedError, workers.getErrorMessageDivisionFieldBlank());
	}

	@Test(enabled = false)
	public void testcase20WorkersDisplayed() {
		login = new LoginPage(driver);
		login.enterUserName("carol");
		login.enterPassword("1q2w3e4r");
		login.clickLogin();
		workers = new WorkersPage(driver);
		workers.clickWorkerHeader();
		Assert.assertTrue(workers.workersDisplayed());
	}

	@Test(enabled = false)
	public void testcase23DynamicCheck() throws InterruptedException {
		login = new LoginPage(driver);
		login.enterUserName("carol");
		login.enterPassword("1q2w3e4r");
		login.clickLogin();
		workers = new WorkersPage(driver);
		workers.clickWorkerHeader();
		workers.dynamicLocatorEdit("3");
		String expectedText = "UPDATE WORKER: LUMINITA BUZEA";
		workers.delayInWorkersPage();
		Assert.assertEquals(expectedText, workers.getTextOfCreatedClient());

	}

	@Test(enabled = false)
	public void testCase24CreateWorkerDetailsUsingExcel() throws InterruptedException {
		login = new LoginPage(driver);
		login.enterUserName("carol");
		login.enterPassword("1q2w3e4r");
		login.clickLogin();
		workers = new WorkersPage(driver);
		workers.clickWorkerHeader();
		workers.clickCreateClient();
		workers.delayInWorkersPage();
		workers.enterFirstNameFull(excel.getDataFromExcel(0, 3, 0));
		workers.enterLastName(excel.getDataFromExcel(0, 4, 0));
		workers.enterPhoneNumber(excel.getDataFromExcel(0, 5, 0));
		workers.enterGender(excel.getDataFromExcel(0, 7, 0));
		workers.delayInWorkersPage();
		workers.enterDateOfBirth(excel.getDataFromExcel(0, 8, 0));
		workers.enterAddressLine1(excel.getDataFromExcel(0, 9, 0));
		workers.enterBranch(excel.getDataFromExcel(0, 11, 0));
		workers.enterTheDivision(excel.getDataFromExcel(0, 12, 0));
		workers.enterTheEmploymentType(excel.getDataFromExcel(0, 13, 0));
		workers.enterPaySlipMethod(excel.getDataFromExcel(0, 14, 0));
		workers.enterEmail(excel.getDataFromExcel(0, 6, 0));
		workers.enterPostCode(excel.getDataFromExcel(0, 10, 0));
		workers.enterNiNumber(excel.getDataFromExcel(0, 15, 0));
		workers.scrollThePage();
		workers.clickNextBttnUpdatePage();
		workers.delayInWorkersPage();
		workers.enterAccountName(excel.getDataFromExcel(0, 16, 0));
		workers.enterAccountNumber(excel.getDataFromExcel(0, 17, 0));
		workers.enterSortCode(excel.getDataFromExcel(0, 18, 0));
		workers.clickSubmitBttnUpdatePage();
		String expectedText = "PARVATHY USHA";
		workers.delayInWorkersPage();
		Assert.assertEquals(expectedText, workers.getTextOfCreatedClient());
	}

	@Test
	public void testcase32SelectingDateUsingDatePicker() throws InterruptedException {
		login = new LoginPage(driver);
		login.enterUserName("carol");
		login.enterPassword("1q2w3e4r");
		login.clickLogin();
		workers = new WorkersPage(driver);
		workers.clickWorkerHeader();
		workers.clickCreateClient();
		workers.selectDateFromDatePicker();
		String expectedText = "CREATE WORKER";
		workers.delayInWorkersPage();
		Assert.assertEquals(expectedText, workers.getTextOfCreateWorkerHeader());

	}
}

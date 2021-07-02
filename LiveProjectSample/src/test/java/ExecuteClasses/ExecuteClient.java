package ExecuteClasses;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import ElementRepository.ClientPage;
import ElementRepository.LoginPage;

public class ExecuteClient extends BaseClass {
	LoginPage login;
	ClientPage client;

	@Test(enabled = false)
	public void testcase05VerifyClientHeaderHighlighted() {
		login = new LoginPage(driver);
		login.enterUserName("carol");
		login.enterPassword("1q2w3e4r");
		login.clickLogin();
		client = new ClientPage(driver);
		client.clickClientHeader();
		client.verifyClientHeader();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(client.verifyClientHeader());
		softAssert.assertAll();

	}

	@Test(enabled = false)
	public void testcase06VerifyTheErrorMessageCreateClientWithoutMandatoryFields() {
		login = new LoginPage(driver);
		login.enterUserName("carol");
		login.enterPassword("1q2w3e4r");
		login.clickLogin();
		client = new ClientPage(driver);
		client.clickClientHeader();
		client.enterClientName("daf");
		client.clickSearchBttn();
		client.clickEditBtTn();
		client.selectVatRateDropdwn();
		String expectedTitle = "Vat Rate cannot be blank.";
		Assert.assertEquals(expectedTitle, client.verifyTheTextOFVatRate());

	}

	@Test
	public void testcase07FilterOnlyWithClientName() throws InterruptedException {
		login = new LoginPage(driver);
		login.enterUserName("carol");
		login.enterPassword("1q2w3e4r");
		login.clickLogin();
		client = new ClientPage(driver);
		client.clickClientHeader();
		client.enterClientName("daf");
		client.clickSearchBttn();
		String expectedTextValue = "585";
		client.delayInClientsPage();
		Assert.assertEquals(expectedTextValue, client.getTheTextOfFilterGrid());

	}

	@Test(enabled = false)
	public void testcase08EditTheClientDetails() throws InterruptedException {
		login = new LoginPage(driver);
		login.enterUserName("carol");
		login.enterPassword("1q2w3e4r");
		login.clickLogin();
		client = new ClientPage(driver);
		client.callImplictWait(10);
		client.clickClientHeader();
		client.enterClientName("daf");
		client.clickSearchBttn();
		client.clickEditBtTn();
		client.selectVatRateDropdwn();
		client.unSelectRequiredProCheckBox();
		client.scrollDownTheClientPage();
		client.clickSaveButtonClientPage();
		String expectedTitle = "DAF";
		client.delayInClientsPage();
		Assert.assertEquals(expectedTitle, client.verifyEditedclientHeader());

	}

	@Test(enabled = false)
	public void testcase09ViewTheClientDetails() {
		login = new LoginPage(driver);
		login.enterUserName("carol");
		login.enterPassword("1q2w3e4r");
		login.clickLogin();
		client = new ClientPage(driver);
		client.clickClientHeader();
		client.enterClientName("daf");
		client.clickSearchBttn();
		client.viewExistingClientDetals();
		String expectedTitle = "DAF";
		Assert.assertEquals(expectedTitle, client.verifyEditedclientHeader());

	}

	@Test(enabled = false)
	public void testcase10VerifyPagination() throws InterruptedException {
		login = new LoginPage(driver);
		login.enterUserName("carol");
		login.enterPassword("1q2w3e4r");
		login.clickLogin();
		client = new ClientPage(driver);
		client.callImplictWait(10);
		client.clickClientHeader();
		client.scrollDownTheClientPage();
		client.delayInClientsPage();
		client.clickScndPage();
		client.scrollDownTheClientPage();
		SoftAssert softAssert = new SoftAssert();
		client.verifyScndPageActive();
		client.delayInClientsPage();
		softAssert.assertTrue(client.verifyScndPageActive());
		softAssert.assertAll();
	}
}

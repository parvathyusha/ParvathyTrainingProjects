package ExecuteClasses;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import ElementRepository.LoginPage;
import ElementRepository.TimeSheetPage;

public class ExecuteTimeSheet extends BaseClass {
	LoginPage login;
	TimeSheetPage timeSheet;

	@Test(enabled = false)
	public void testCase25VerifyInvoiceGenerated() throws InterruptedException {
		login = new LoginPage(driver);
		login.enterUserName("carol");
		login.enterPassword("1q2w3e4r");
		login.clickLogin();
		timeSheet = new TimeSheetPage(driver);
		timeSheet.delayInTimeSheetPage();
		timeSheet.clickTimeSheetHeader();
		timeSheet.delayInTimeSheetPage();
		timeSheet.clickGenerateInvoice();
		timeSheet.getTextOfTimeSheetPage();
		String expectedTitleValue = "TIMESHEETS";
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(timeSheet.getTextOfTimeSheetPage(), expectedTitleValue);
		softAssert.assertAll();

	}

	@Test(enabled = false)
	public void testCase26ToVerifyLogoutFunctionality() throws InterruptedException {
		login = new LoginPage(driver);
		login.enterUserName("carol");
		login.enterPassword("1q2w3e4r");
		login.clickLogin();
		timeSheet = new TimeSheetPage(driver);
		timeSheet.delayInTimeSheetPage();
		timeSheet.clickTimeSheetHeader();
		timeSheet.delayInTimeSheetPage();
		login.clickCarolThomasBtn();
		timeSheet.delayInTimeSheetPage();
		login.clicklogOutButton();
		String expectedUrl = "https://www.qabible.in/payrollapp/site/login";
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(login.getUrlOfCuurentPage(), expectedUrl);
		softAssert.assertAll();
	}

	@Test(enabled = false)
	public void testCase27ToVerifyViewProfileFunctionality() throws InterruptedException {
		login = new LoginPage(driver);
		login.enterUserName("carol");
		login.enterPassword("1q2w3e4r");
		login.clickLogin();
		timeSheet = new TimeSheetPage(driver);
		timeSheet.delayInTimeSheetPage();
		timeSheet.clickTimeSheetHeader();
		timeSheet.delayInTimeSheetPage();
		login.clickCarolThomasBtn();
		timeSheet.delayInTimeSheetPage();
		login.clickViewFullProfile();
		String expectedUrl = "https://www.qabible.in/payrollapp/user/profile";
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(login.getUrlOfCuurentPage(), expectedUrl);
		softAssert.assertAll();
	}

	@Test(enabled = false)
	public void testCase28ToVerifySettingsButtnFunctionality() throws InterruptedException {
		login = new LoginPage(driver);
		login.enterUserName("carol");
		login.enterPassword("1q2w3e4r");
		login.clickLogin();
		timeSheet = new TimeSheetPage(driver);
		timeSheet.delayInTimeSheetPage();
		timeSheet.clickTimeSheetHeader();
		timeSheet.delayInTimeSheetPage();
		login.clickSettingsButtn();
		String expectedUrl = "https://www.qabible.in/payrollapp/user";
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(login.getUrlOfCuurentPage(), expectedUrl);
		softAssert.assertAll();
	}

	@Test(enabled = false)
	public void testCase29ToVerifyHomeButtnFunctionality() throws InterruptedException {
		login = new LoginPage(driver);
		login.enterUserName("carol");
		login.enterPassword("1q2w3e4r");
		login.clickLogin();
		timeSheet = new TimeSheetPage(driver);
		timeSheet.delayInTimeSheetPage();
		timeSheet.clickTimeSheetHeader();
		timeSheet.delayInTimeSheetPage();
		login.clickHomeButtn();
		String expectedUrl = "https://www.qabible.in/payrollapp/site/index";
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(login.getUrlOfCuurentPage(), expectedUrl);
		softAssert.assertAll();
	}

	@Test
	public void testCase30CheckTheExistingTimesheetDetails() throws InterruptedException {
		login = new LoginPage(driver);
		login.enterUserName("carol");
		login.enterPassword("1q2w3e4r");
		login.clickLogin();
		timeSheet = new TimeSheetPage(driver);
		timeSheet.delayInTimeSheetPage();
		timeSheet.clickTimeSheetHeader();
		timeSheet.delayInTimeSheetPage();
		timeSheet.clickViewButtn();
		String expectedText = "TIMESHEET# 9632";
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(timeSheet.getTextOfTimeSheetPage(), expectedText);
		softAssert.assertAll();

	}

}

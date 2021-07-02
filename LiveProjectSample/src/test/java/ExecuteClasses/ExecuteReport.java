package ExecuteClasses;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import ElementRepository.LoginPage;
import ElementRepository.ReportPage;

public class ExecuteReport extends BaseClass {
	LoginPage login;
	ReportPage report;

	@Test(enabled = false)
	public void testCase22VerifyTooltipOfExportButnn() {
		login = new LoginPage(driver);
		login.enterUserName("carol");
		login.enterPassword("1q2w3e4r");
		login.clickLogin();
		report = new ReportPage(driver);
		report.clickReportStepper();
		report.toolTipExportButtn();
		SoftAssert softAssert = new SoftAssert();
		report.callImplictWait(10);
		softAssert.assertTrue(report.toolTipExportButtn());
		softAssert.assertAll();
	}

}

package ExecuteClasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import ElementRepository.ClientPage;
import ElementRepository.LoginPage;
import utilityClasses.DataProviderExcel;

public class ExecuteLogin extends BaseClass {
	DataProviderExcel excel = new DataProviderExcel();
	LoginPage login;

	@Test(enabled = false)
	public void testcase01VerifyLogin() throws InterruptedException {

		login = new LoginPage(driver);
		Thread.sleep(3000);
		login.enterUserName("carol");
		login.enterPassword("1q2w3e4r");
		login.clickLogin();
		String expectedUser = "CAROL";
		login.callImplictWait(10);
		Assert.assertEquals(expectedUser, login.verifyUserLogin());
	}

	@Test(enabled = false)
	public void testcase02VerifyInvalidUserLogin() {
		login.callImplictWait(10);
		login = new LoginPage(driver);
		login.enterUserName("caroltyuiii");
		login.enterPassword("1q2w3e4r");
		login.clickLogin();
		String invalidUserMessage = "Incorrect username or password.";
		Assert.assertEquals(invalidUserMessage, login.verifyInvalidUserLogin());
	}

	@Test(enabled = false)
	public void testcase03VerifyRememberCheckbox() throws InterruptedException {
		login = new LoginPage(driver);
		login.enterUserName("carol");
		login.enterPassword("1q2w3e4r");
		Thread.sleep(4000);
		login.verifyRememberMeCheckboxSelected();
		Assert.assertTrue(login.verifyRememberMeCheckboxSelected());
	}

	@Test(enabled = false)
	public void testcase04VerifyResettOptionIsALink() {
		login = new LoginPage(driver);
		login.tagNameOfResetIt();
		String expectedResetTagName = "a";
		Assert.assertEquals(login.tagNameOfResetIt(), expectedResetTagName);
	}

	@Test
	public void testcase11VerifyLoginExcel() throws InterruptedException {

		login = new LoginPage(driver);
		Thread.sleep(3000);
		login.enterUserName(excel.getDataFromExcel(0, 0, 0));
		login.enterPassword(excel.getDataFromExcel(0, 1, 0));
		login.clickLogin();
		String expectedUser = "CAROL THOMAS";
		Assert.assertEquals(expectedUser, login.verifyUserLogin());
	}

}

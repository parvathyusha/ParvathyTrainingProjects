package ExecuteClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import ElementRepository.InvoicePage;
import ElementRepository.LoginPage;

public class ExecuteInvoice extends BaseClass {
	LoginPage login;
	InvoicePage invoice;
  @Test
  public void testcase21ClickThePDF() throws InterruptedException {
	    login = new LoginPage(driver);
		login.enterUserName("carol");
		login.enterPassword("1q2w3e4r");
		login.clickLogin();
		invoice=new InvoicePage(driver);
		invoice.clickInvoiceHeader();
		invoice.clickPDFButtn();
		String expectedUrl="https://www.qabible.in/payrollapp/invoice/index";
		invoice.delayInInvoicePage();
		Assert.assertEquals(invoice.clickPDFButtn(), expectedUrl);
		
  }
}

package ExecuteClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utilityClasses.GeneralUtilities;
import utilityClasses.ScreenshotCapture;

public class BaseClass {
	WebDriver driver;
	ScreenshotCapture ob;
	GeneralUtilities generalUtil = new GeneralUtilities();

	@BeforeMethod
	@Parameters({ "browser" })
	public void launchBrowser(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Parvathy Usha\\Downloads\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://www.qabible.in/payrollapp/site/login");
			driver.manage().window().maximize();
			generalUtil.applyImplicitWait(driver, 10);
		} else if (browser.equalsIgnoreCase("fireFox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Parvathy Usha\\Downloads\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get("https://www.qabible.in/payrollapp/site/login");
			driver.manage().window().maximize();
			generalUtil.applyImplicitWait(driver, 10);
		}
	}

	@AfterMethod
	public void closeBrowser(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == iTestResult.FAILURE) {
			ob = new ScreenshotCapture();
			ob.takeScreenshotFailure(driver, iTestResult.getName());

		}
		driver.quit();
	}
}

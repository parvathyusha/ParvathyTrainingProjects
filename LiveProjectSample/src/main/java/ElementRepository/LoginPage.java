package ElementRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import utilityClasses.GeneralUtilities;

public class LoginPage {
	WebDriver driver;
	GeneralUtilities generalUtility = new GeneralUtilities();

	@FindBy(xpath = "//input[@type='text']")
	WebElement userName;

	@FindBy(xpath = "//input[@type='password']")
	WebElement passWord;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginBttn;

	@FindBy(xpath = "//a[text()='Carol Thomas']")
	WebElement userLogged;

	@FindBy(xpath = "//p[text()='Incorrect username or password.']")
	WebElement invalidUserLogged;

	@FindBy(xpath = "//input[@name='LoginForm[rememberMe]'][2]")
	WebElement rememberMeCheckBox;

	@FindBy(xpath = "//a[text()='reset it']")
	WebElement resetIt;

	@FindBy(xpath = "//a[@class='dropdown-toggle']")
	WebElement carolThomasButtn;

	@FindBy(xpath = "//div[@class='col-sm-12']//a[@href='/payrollapp/site/logout']")
	WebElement logOutBttn;

	@FindBy(xpath = "//div[@class='col-sm-12']//a[@href='/payrollapp/user/profile']")
	WebElement viewFullProfile;

	@FindBy(xpath = "//div[@class='col-lg-12 col-sm-10 panel-nav no-padding']//a[@href='/payrollapp/user']")
	WebElement settingsButtn;

	@FindBy(xpath = "//div[@class='col-sm-6 breadcrumb-navigation']//a[@href='/payrollapp/site/index']")
	WebElement homeButtn;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterUserName(String username) {
		userName.sendKeys(username);

	}

	public void enterPassword(String password) {
		passWord.sendKeys(password);
	}

	public void clickLogin() {
		loginBttn.click();

	}

	public String verifyUserLogin() {

		String userValue = generalUtility.getElementText(userLogged);
		return userValue;

	}

	public void callImplictWait(long time) {
		generalUtility.applyImplicitWait(driver, time);
	}

	public String verifyInvalidUserLogin() {
		String invalidUserValue = generalUtility.getElementText(invalidUserLogged);
		return invalidUserValue;

	}

	public boolean verifyRememberMeCheckboxSelected() {
		if (generalUtility.isSelectedCheckBox(rememberMeCheckBox) == false) {
			rememberMeCheckBox.click();
		}
		boolean rememberCheckBox = generalUtility.isSelectedCheckBox(rememberMeCheckBox);
		return rememberCheckBox;

	}

	public String tagNameOfResetIt() {
		String actualResetTagName = generalUtility.getElementTagName(resetIt);
		return actualResetTagName;

	}

	public void clickCarolThomasBtn() {
		carolThomasButtn.click();
	}

	public void clicklogOutButton() {
		generalUtility.clickByMouse(logOutBttn, driver);
	}

	public String getUrlOfCuurentPage() {
		String currentUrlLogin = generalUtility.getCurrentUrl(driver);
		return currentUrlLogin;

	}

	public void clickViewFullProfile() {
		generalUtility.clickByMouse(viewFullProfile, driver);
	}

	public void clickSettingsButtn() {
		settingsButtn.click();
	}

	public void clickHomeButtn() {
		generalUtility.clickByMouse(homeButtn, driver);
	}

}

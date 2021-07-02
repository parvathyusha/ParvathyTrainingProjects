package utilityClasses;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class GeneralUtilities {

	public String getElementText(WebElement element) {
		String elementText = element.getText();
		return elementText;
	}

	public void applyImplicitWait(WebDriver driver, long time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public boolean isSelectedCheckBox(WebElement element) {
		boolean isSelectedCheck = element.isSelected();
		return isSelectedCheck;

	}

	public boolean isEnabledOrNot(WebElement element) {
		boolean isEnableOr = element.isEnabled();
		return isEnableOr;
	}

	public boolean isDisplayedOrNot(WebElement element) {
		boolean isDisplayedOr = element.isDisplayed();
		return isDisplayedOr;
	}

	public String getElementTagName(WebElement element) {
		String tagName = element.getTagName();
		return tagName;
	}

	public String getElementTextColor(WebElement element) {
		String textColor = element.getCssValue("color");
		return textColor;

	}

	public String getBackgroundColor(WebElement element) {
		String backgrndColor = element.getCssValue("background-color");
		return backgrndColor;

	}

	public boolean getAttributeValue(WebElement element, String attbtType, String attrbtValue) {
		boolean attributeValue = element.getAttribute(attbtType).contains(attrbtValue);
		return attributeValue;

	}

	public void selectDropDown(WebElement element, String textValue) {
		Select elementValue = new Select(element);
		elementValue.selectByVisibleText(textValue);
	}

	public void clickByMouse(WebElement element, WebDriver driver) {
		Actions action = new Actions(driver);
		action.click(element).perform();

	}

	public void acceptTheAlerts(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public String getWindowHandle(WebDriver driver) {
		String value = driver.getWindowHandle();
		return value;
	}

	public Set<String> getWindowHandles(WebDriver driver) {
		Set<String> multipleVslues = driver.getWindowHandles();
		return multipleVslues;
	}

	public void SwitchToWindow(WebDriver driver, String window) {
		driver.switchTo().window(window);
	}

	public String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public void threadDelay() throws InterruptedException {
		Thread.sleep(3000);
	}

	public String toolTip(WebElement element, String titleValue) {
		String tooltipElement = element.getAttribute(titleValue);
		return tooltipElement;
	}

	public void scrollDown(WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,2000)");
	}
}

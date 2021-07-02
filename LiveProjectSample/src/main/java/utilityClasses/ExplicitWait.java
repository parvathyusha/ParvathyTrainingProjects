package utilityClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ExplicitWait { 
	
	public void elementSelectedExpWait(WebElement element,WebDriver driver, long time) {
	WebDriverWait wait=new WebDriverWait(driver,time);
	wait.until(ExpectedConditions.elementToBeSelected(element));
	}
	
	public void attrbtValuePresentExpWait(WebElement element, WebDriver driver, long time, String attrbtType, String attrbtValue) {
		WebDriverWait wait= new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.attributeContains(element, attrbtType, attrbtValue));
	}
	
	
		
}

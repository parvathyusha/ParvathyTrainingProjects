package utilityClasses;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class ScreenshotCapture {
	
  @Test
  public void takeScreenshotFailure(WebDriver driver, String name) throws IOException {
	  TakesScreenshot scrShot =((TakesScreenshot)driver);
	  File screenShot = scrShot.getScreenshotAs(OutputType.FILE);
	  String timeStamp=new SimpleDateFormat("dd_mm_yyyy_hh_mm_ss").format(new Date());
	  String destination=System.getProperty("user.dir")+"//Screenshots//"+name+timeStamp+".png";
	  File finalDestination=new File(destination);
	  FileHandler.copy(screenShot, finalDestination);


  }
}

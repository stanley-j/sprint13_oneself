package org.baseOneSelf;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

public static WebDriver driver;
	    
public static void browserLaunch(String url){
	/*
	 * System.setProperty("webdriver.chrome.driver",
	 * "C:\\Users\\stanleyathish.j\\eclipse-workspace\\Stephen\\driver\\chromedriver.exe"
	 * ); driver = new ChromeDriver(); driver.manage().window().maximize();
	 * driver.get(url); driver.manage().timeouts().implicitlyWait(30,
	 * TimeUnit.SECONDS);
	 */

WebDriverManager.chromedriver().setup();
driver = new ChromeDriver();
driver.manage().window().maximize();
driver.get(url);
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}

/*public static void maximizebrowser(){
   driver.manage().window().maximize();
}

public static void getlink(){
	driver.get("https://oneself-admin-test.optisolbusiness.com");
  }*/
public static void sendkeys(By locator, String s) throws Exception {
	try {
		WebElement element = driver.findElement(locator);
		element.sendKeys(s);
	} catch (Exception e) {
		throw new Exception("unable to send the data" + locator);

	}
}

public static void click(By locator) throws Exception {
	try {
		WebElement element = driver.findElement(locator);
		element.click();

	} catch (Exception e) {
		throw new Exception("unable to click the element");

	}
  }

public static void implicitWait(long sec) {
	driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);

}

public static boolean idDispalyed(By locator) {
    WebElement element = driver.findElement(locator);
    boolean b = element.isDisplayed();
    System.out.println(b);
    return true;
}

public static boolean IsElementDisplayed(By Locator) throws Throwable {

	WebDriverWait wait = new WebDriverWait(driver, 200);
	WebElement ElementDisplay = wait.until(ExpectedConditions.elementToBeClickable(Locator));
	return ElementDisplay.isDisplayed();
}

public static String captureScreenshot() throws IOException {

	File srcFiler = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	byte[] encoded;
	try {
		encoded = Base64.encodeBase64(FileUtils.readFileToByteArray(srcFiler));
		String shot = new String(encoded, StandardCharsets.US_ASCII);
		return shot;

	} catch (IOException e) {
		e.printStackTrace();

	}
	return null;
}
}
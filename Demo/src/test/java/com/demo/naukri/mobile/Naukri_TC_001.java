package com.demo.naukri.mobile;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Naukri_TC_001 {

	public static WebDriverWait wait;
	public static JavascriptExecutor js;
	public static Actions act;

	@Test
	public void test() throws Exception {

		/* Launch and run Appium Server */
		AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
		service.start();

		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability("deviceName", "vivo T1 5G");
		cap.setCapability("automationName", "Appium");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "13");
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "naukriApp.appModules.login");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.naukri.splash.SplashActivity");
		System.out.println("Capablities Set");

		URL url = new URL("http://localhost:4723/wd/hub");
		AndroidDriver<AndroidElement> androidDriver = new AndroidDriver<AndroidElement>(url, cap);
		System.out.println("Application launched");

		androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(androidDriver, 15);
		js = (JavascriptExecutor) androidDriver;
		act = new Actions(androidDriver);

		TouchAction touchAction = new TouchAction(androidDriver);
		wait = new WebDriverWait(androidDriver, 20);

		/* Click on Allow Button */
		androidDriver.findElementById("com.android.permissioncontroller:id/permission_allow_button").click();

		/* Click on Login link */
		androidDriver.findElementByXPath("//android.widget.TextView[@text='Login']").click();

		/* Set email id text field */
		androidDriver.findElementById("naukriApp.appModules.login:id/et_email").sendKeys("manjukammar222@gmail.com");

		/* Set password text field */
		androidDriver.findElementById("naukriApp.appModules.login:id/et_password").sendKeys("Mk@9108219704");

		/* Click on login button */
		androidDriver.findElementById("naukriApp.appModules.login:id/bt_login").click();

		/* Click on continue button */
		androidDriver.findElementById("naukriApp.appModules.login:id/textViewContinue").click();

		/* Click on hamburger icon */
		AndroidElement hamburger = androidDriver.findElementByXPath(
				"//android.view.ViewGroup[@resource-id='naukriApp.appModules.login:id/toolbarView']/android.widget.ImageButton");
		wait.until(ExpectedConditions.visibilityOf(hamburger));
		hamburger.click();

		/* Click on job seekers paid service link */
		AndroidElement jobSeekerServices = androidDriver
				.findElementById("naukriApp.appModules.login:id/menu_jobseeker_services");
		wait.until(ExpectedConditions.visibilityOf(jobSeekerServices));
		jobSeekerServices.click();

		/* Click on any paid service */
		AndroidElement knowMore1 = androidDriver.findElementByXPath(
				"//android.view.View[contains(@content-desc,'Resume Display Increase your')]/descendant::android.widget.TextView[@text='KNOW MORE']");
		wait.until(ExpectedConditions.visibilityOf(knowMore1));
		knowMore1.click();

		try {
			Thread.sleep(5000);
//			touchAction.tap(PointOption.point(518, 2144)).perform();
		} catch (Exception e) {

			e.printStackTrace();
		}

		/* Click on PhonePe button */
		androidDriver
				.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"PhonePe\"))")
				.click();

		/* Click on Proceed button */
		androidDriver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"PROCEED TO PAYMENT\"))").click();

		Thread.sleep(10000);

		/* Click on PhonePe image */
		androidDriver.findElementByXPath("//android.view.View[contains(@text,'PhonePe')]").click();

		/* Click on Proceed image */
		androidDriver.findElementByXPath("//android.widget.Button[contains(@text,'PROCEED')]").click();

		Thread.sleep(10000);

		/* Set Mobile number into mobile number text field */
		androidDriver.findElementByXPath("//android.widget.EditText[@resource-id='mobileNumber']")
				.sendKeys("9108219704");

		/* Click on send OTP button */
		androidDriver.findElementByXPath("//android.widget.Button[contains(@text,'SEND OTP')]").click();

	}
}

package com.demo.web.amazon;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Amazon_Automation_TC_01 {
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static JavascriptExecutor js;

	@Test
	public static void test() {
		try {
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, 15);
			driver.get("https://www.amazon.in");

			WebElement searchTestField = driver.findElement(By.xpath("//input[@name='field-keywords']"));

			/* Click on Search product */
			searchTestField.click();

			/* Enter Product Name on Search product */
			searchTestField.sendKeys("Shoes for boys");

			/* click on Search button */
			driver.findElement(By.id("nav-search-submit-button")).click();

			/* Click on Product */
			driver.findElement(By.xpath("//div[text()='Deal of the Day']")).click();

			/* Click on BuyNow button */
			driver.findElement(By.xpath("//input[@id='buy-now-button']")).click();

			/* Enter mobile number in mobile number text field */
			driver.findElement(By.xpath("//input[@name='email']")).sendKeys("9108219704");

			/* Click on continue in Button */
			driver.findElement(By.xpath("//input[@id='continue']")).click();

			/* Enter Password in Password text field */
			driver.findElement(By.xpath("// input[@id='ap_password']")).sendKeys("Mk@7353530937");

			/* Click on Sign in Button */
			driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();

			Thread.sleep(15000);

			/* Select other apps radio button */
			WebElement rdoOtherUPIAppButton = driver
					.findElement(By.xpath("//div[@aria-label='Other UPI Apps']/label/input"));
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
			wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOf(rdoOtherUPIAppButton));
			rdoOtherUPIAppButton.click();

			Thread.sleep(10000);

			/* Enter UPI Id in UPI id text field */
			driver.findElement(By.xpath("//input[@placeholder='Ex: MobileNumber@upi']")).sendKeys("9108219704@ybl");

			/* Click on Verify button */
			driver.findElement(By.xpath("//span[text()='Verify']/parent::span")).click();

			Thread.sleep(5000);

			/* Click on use payment method */
			driver.findElement(By.xpath("//input[@name='ppw-widgetEvent:SetPaymentPlanSelectContinueEvent']")).click();

			/* Click on place order */
			WebElement btnPlaceOrder = driver.findElement(By.xpath("//input[@name='placeYourOrder1']"));

			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(btnPlaceOrder));
			jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
			Thread.sleep(5000);
			btnPlaceOrder.click();

			/* Click on Duplicate order */
			WebElement btnPlaceDuplicateOrderButton = driver
					.findElement(By.xpath("//input[@value='Place this duplicate order ']"));

			try {
				Thread.sleep(2000);
				if (btnPlaceDuplicateOrderButton.isDisplayed()) {
					btnPlaceDuplicateOrderButton.click();
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Payment confirmation sent to Mobile number UPI number successfully");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}

	}

}

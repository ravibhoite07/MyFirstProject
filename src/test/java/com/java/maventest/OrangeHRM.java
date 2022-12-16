package com.java.maventest;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class OrangeHRM {

	WebDriver driver;

	@Test
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\java_automaion_aug\\PracticeMaven\\driver\\chromedriver.exe");
		// WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name=\"username\"]")));
//		wait.sendKeys("Admin");
		
//        WebElement set= new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("abc"))); 	
		By element = By.xpath("//input[@name=\"username\"]");

		waitForElementPresent(driver, element, 10).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin123");
	}

	// generic code for explicite wait short cut use multiple time
	public static WebElement waitForElementPresent(WebDriver driver, By Locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.presenceOfElementLocated(Locator));
		return driver.findElement(Locator);
	}
}

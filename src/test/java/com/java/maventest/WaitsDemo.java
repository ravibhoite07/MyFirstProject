package com.java.maventest;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitsDemo {

	WebDriver driver;

	@Test
	public void expliciteWait() {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://google.com/ncr");
		driver.findElement(By.name("q")).sendKeys("cheese" + Keys.ENTER);
		// Initialize and wait till element(link) became clickable - timeout in 10
		// seconds
		WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a/h3")));
		// Print the first result
		System.out.println(firstResult.getText());

	}

}

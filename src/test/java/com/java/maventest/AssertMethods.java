package com.java.maventest;

import static org.testng.Assert.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssertMethods {

	WebDriver driver;
	
	@Test
	public void openbroweser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		String expectedTitle="Online Shoppin site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String actualTitle=driver.getTitle();
		
		// 3rd Parameter is custom message for understanding of what we are tested show in result if fail
		
		assertEquals(actualTitle, expectedTitle,"Title of Amazon.in Expected");
		assertEquals(actualTitle,expectedTitle );
		
	}
	
	
}

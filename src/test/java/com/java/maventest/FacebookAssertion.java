package com.java.maventest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookAssertion {

	
	
WebDriver driver;
	
	@BeforeClass
	public void openbroweser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
	}
	
		@Test(priority = 1)
		public void verifyCurrentUrl() {
		String actualUrl=driver.getCurrentUrl();
		String expectedUrl="https://www.facebook.com/";
		Assert.assertEquals(actualUrl, expectedUrl, "Url is mismached " );
		System.out.println(actualUrl);
		}
		
		
		@Test(priority = 2)
		public void verifyCurrentTitle() throws InterruptedException {
		String actualTitle=driver.getTitle();
		String expectedTitle="Facebook – log in or sign up";
		assertEquals(actualTitle, expectedTitle, "Title is Mismatched" );
		
		driver.findElement(By.name("email")).sendKeys("abc",Keys.ENTER);
        Thread.sleep(5000);
	    
		}
		
		@Test(priority = 3)
		public void verifyUsername() {
	    String actualText=driver.findElement(By.name("email")).getAttribute("value");
	    String expectedText="";
	    assertEquals(actualText, expectedText, "Username Text is Mismatched" );
	    System.out.println("GetAttribute() value is="+actualText);
		}
		
		
		@Test(priority = 4)
		public void verifyBorderCssValue() {
	    
	    String actualBorder=driver.findElement(By.name("email")).getCssValue("border");
	    String expectedBorder="1px solid rgb(240, 40, 73)";
 	    
	    SoftAssert softAssert=new SoftAssert();
 	    softAssert.assertEquals(actualBorder, expectedBorder);
 	    softAssert.assertAll();
 	//  assertEquals(actualBorder, expectedBorder, "Username Border is Mismatched" );
		}
		
		
		@Test(priority = 5)
		public void verifyIfSameErrorMsgDisplayed() {
    
 	    // ErrorMessage Assertion
	    String actualErrorMessage=driver.findElement(By.xpath("(//div)[13]")).getText();
	    String expectedErrorMessage="The email address or mobile number you entered isn't connected to an account. Find your account and log in.";
	    assertEquals(actualErrorMessage, expectedErrorMessage, " ErrorMessage is Mismatched" );
		}
		
		
		@AfterClass
		public void closeBrowser() {
        driver.quit();	
        
	}
	}

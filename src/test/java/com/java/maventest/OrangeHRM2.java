package com.java.maventest;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM2 {

	
	WebDriver driver;
	@BeforeTest
	@Parameters("browserName")
	
	public void InitialiseBrowser(String browserName) {
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			System.out.println("Chrome started successfully");
			
		}else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			System.out.println("Firefox started successfully");
			
		}else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			System.out.println("EdgeDriver started successfully");
		}
			
	}

	
	@Test
	@Parameters("url")
	
	public void LaunchApp(String url) throws InterruptedException {
		driver.get(url);
		Thread.sleep(3000);
		driver.manage().window().maximize();
	}
	@Test
	@Parameters({"username", "password"})
	
	public void EnterLoginDetails(String userName, String password) throws InterruptedException {
		driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		Thread.sleep(3000);
	}

	@Test
	public void NavigateToMyInfo() {
		driver.findElement(By.xpath("//a[@href=\"/web/index.php/pim/viewMyDetails\"]")).click();
	}
  
	
	@Test
	public void VerifyMyInfo() throws InterruptedException {
		Thread.sleep(3000);
		boolean actualValue = driver.findElement(By.xpath("(//h6[@class=\"oxd-text oxd-text--h6 orangehrm-main-title\"])[1]")).isDisplayed();
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(actualValue, true);
		sa.assertAll();
		
	}

	@Test
	public void VerifyLogin() {
		WebElement element = driver.findElement(By.id("welcome"));
		assertTrue(element.isDisplayed());
		assertTrue(element.getText().startsWith("Welcome"));
		System.out.println(element.isDisplayed());
		System.out.println(element.getText().startsWith("Welcome"));
	}
}




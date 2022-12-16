package com.java.maventest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestScript {

   
	@Test(description="Smoke Testing")
	public void TestGoogle(){
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Tata Safari", Keys.ENTER);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	
	
}

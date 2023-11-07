package com.aman.SelCommands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IncognitoWindowExample {
	
	protected WebDriver driver;
	
	public void setup() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public WebElement isElementVisible(By by, int timeInSeconds) {
		return new WebDriverWait(driver, timeInSeconds).until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	public WebElement isElementClickable(By by, int timeInSeconds) {
		return new WebDriverWait(driver, timeInSeconds).until(ExpectedConditions.elementToBeClickable(by));
	}
	
	public void tearDown() {
		driver.close();
	}


}

package com.aman.SelCommands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	private WebDriver driver;
	 
	
	public final String WEBROOT_URL = "https://www.webroot.com/us/en/cart?key=9C8868A3-2846-4BC4-AAFC-C7B9B69AF60C";
	public final String NAUTOMATION_URL = "https://naveenautomationlabs.com/opencart/index.php?route=information/contact";
	public final String DEMOQA_URL ="https://demoqa.com/forms" ;
	public final String WEBROOT_TRIAL_PAGE_URL = "https://www.carbonite.com/personal/trial/";
			

	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public void selectDropDown(WebElement element, String value) {
		Select sc= new Select(element);
		sc.selectByVisibleText(value);
	}
	
	public WebElement isElementVisible(By by, int timeInSeconds) {
		return new WebDriverWait(driver, timeInSeconds).until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	public WebElement isElementClickable(By by, int timeInSeconds) {
		return new WebDriverWait(driver, timeInSeconds).until(ExpectedConditions.elementToBeClickable(by));
	}

	public void sleep() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void tearDown() {
		driver.close();
	}

}

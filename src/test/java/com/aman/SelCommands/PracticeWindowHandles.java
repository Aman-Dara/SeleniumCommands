package com.aman.SelCommands;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeWindowHandles extends IncognitoWindowExample {
	
	@BeforeMethod
	public void launchBrowser() {
		setup();
		driver.get("https://demoqa.com/");
	}
	
	@Test
	public void validateTabs() {
		
		isElementVisible(By.cssSelector("img[class='banner-image']"),5).click();
		String defaultWindowHandle = driver.getWindowHandle();
		System.out.println(defaultWindowHandle);
		
		isElementVisible(By.xpath("//a[text()='Home']"),5).click();
		String childWindowHandle1 = driver.getWindowHandle();
		System.out.println(childWindowHandle1);
		
		isElementClickable(By.xpath("//a[text()='Enroll Yourself']"),5).click();
		String childWindowHandle2 = driver.getWindowHandle();
		System.out.println(childWindowHandle2);	
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		Iterator<String> iterator = windowHandles.iterator();
		while(iterator.hasNext()) {
			driver.switchTo().window(iterator.next());
		}
	}
	
	
	public void closeBrowser() {
		driver.quit();
	}

}

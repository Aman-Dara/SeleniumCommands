package com.aman.SelCommands;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CarterTest extends BaseClass{
	
	@BeforeMethod
	public void launchBrowser() {
		setup();
		getDriver().get("https://www.cartersoshkosh.ca/en_CA/home?id=carters");
	}
	@Test
	public void checkIfLogoIsPresent() {
		WebElement logo = getDriver().findElement(By.cssSelector("div[class=\"logo\"]>a"));
		logo.isDisplayed();
		Assert.assertEquals(logo.isDisplayed(), true);
	}
	@AfterMethod
	@Override
	public void tearDown() {
		super.tearDown();
		
	}

}

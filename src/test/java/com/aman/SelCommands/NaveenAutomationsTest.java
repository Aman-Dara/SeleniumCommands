package com.aman.SelCommands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NaveenAutomationsTest extends BaseClass {

	@BeforeMethod
	public void launchBrowser() {
		setup();
		getDriver().get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

	}

	@Test
	public void fillContactUsForm() {
		getDriver().findElement(By.id("input-name")).sendKeys("wendy");
		getDriver().findElement(By.id("input-email")).sendKeys("wendy12@yahoo.com");
		getDriver().findElement(By.id("input-enquiry")).sendKeys("Naveen Automation Labs......");
		getDriver().findElement(By.cssSelector("input[type='submit']")).submit();
		WebElement message = getDriver().findElement(By.cssSelector("#content>p"));
		String enquirySentMessage = message.getText();
		Assert.assertEquals(enquirySentMessage, "Your enquiry has been successfully sent to the store owner!",
				"Enquiry is not sent, hence test has failed");
	}
	
	@Test
	public void getLoginText() {
		//getDriver().navigate().to("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		WebElement loginLink = getDriver().findElement(By.cssSelector("div.list-group>a:first-of-type"));
		String loginText = loginLink.getText();
		System.out.println(loginText);
	}

	@AfterMethod
	@Override
	public void tearDown() {
		super.tearDown();
	}

}

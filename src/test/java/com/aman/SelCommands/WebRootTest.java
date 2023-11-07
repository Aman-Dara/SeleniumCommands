package com.aman.SelCommands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebRootTest extends BaseClass {
	
	
	@BeforeMethod
	public void launchBrowser() {
		setup();
		getDriver().get(WEBROOT_URL);
	}
	@Test
	private void fillBillingFields() {
		// Identify the WebElements you want to interact with
		WebElement cookiesBtn = isElementVisible(By.xpath("//button[text()= 'Accept All']"), 5);
		cookiesBtn.click();
		getDriver().findElement(By.cssSelector("input[name='billing.customer_email']")).sendKeys("andreas123@gmail.com");
		getDriver().findElement(By.cssSelector("input[name='billing.first_name']")).sendKeys("Andreas");
		getDriver().findElement(By.cssSelector("input[name='billing.last_name']")).sendKeys("Huber");
		getDriver().findElement(By.cssSelector("input[name='billing.address_1']")).sendKeys("55 Hawtrey Road");
		getDriver().findElement(By.cssSelector("input[name='billing.city']")).sendKeys("Brampton");
		getDriver().findElement(By.cssSelector("input[name='billing.postal_code']")).sendKeys("L6Z 3Y3");	

		WebElement country = getDriver().findElement(By.cssSelector("select[name='billing.country']"));
		Select sc= new Select(country);
		sc.selectByVisibleText("United States");
		WebElement state = getDriver().findElement(By.cssSelector("select[name='billing.state']"));
		sc= new Select(state);
		sc.selectByVisibleText("Arizona");
	}	
	
	@Test
	public void validateEmail() {
		WebElement emailInput = getDriver().findElement(By.cssSelector("input[name='billing.customer_email']"));
		emailInput.sendKeys("abc");
		String email = emailInput.getText();
		if(email.isEmpty()) {
			System.out.println("Email field can not be empty");
			//Assert.assertEquals(email, "Email Field can not be empty");
		}
	
		
	}
	
	
	
	@Test
	public void getTitleOfPage() {
		System.out.println(getDriver().getTitle());
		
	}
	
	
	@AfterMethod
	@Override
	public void tearDown() {
		super.tearDown();
	}
	
	
	
	
	
	
	

}

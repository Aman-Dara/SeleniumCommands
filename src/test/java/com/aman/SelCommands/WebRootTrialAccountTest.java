package com.aman.SelCommands;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebRootTrialAccountTest extends BaseClass {
	
	
	
	@BeforeMethod
	public void launchBrowser() {
		setup();
		getDriver().get(WEBROOT_TRIAL_PAGE_URL);
		
	}
	@Test
	public void fillForm() {
		WebElement cookiesBtn = isElementVisible(By.xpath("//button[text()= 'Accept All']"), 5);
		cookiesBtn.click();
		WebElement emailInput = isElementVisible(By.id("personal-trial-email"), 5);
		WebElement confirmEmailInput = isElementVisible(By.id("personal-trial-confirm-email"), 5);
		WebElement passwordInput = isElementVisible(By.id("personal-trial-password"), 5);
		WebElement confirmPasswordInput = isElementVisible(By.id("personal-trial-confirm-password"), 5);
		emailInput.sendKeys("andreashuber@yahoo.com");
		confirmEmailInput.sendKeys("andreashuber@yahoo.com");
		passwordInput.sendKeys("Abcxyz@12");
		confirmPasswordInput.sendKeys("Abcxyz@12");
		
		WebElement autoSuggestionPlaceholder = isElementClickable(By.cssSelector("form>div:nth-of-type(5)>div>button"),10);
		autoSuggestionPlaceholder.sendKeys(Keys.ARROW_DOWN);
		//action.contextClick(dropDown).perform();
		WebElement countryInput = isElementVisible(By.id("personal-trial-country-selection"),10);
		countryInput.sendKeys("Canada");
		countryInput.sendKeys(Keys.ARROW_DOWN);
		countryInput.sendKeys(Keys.ENTER);
		
		
		WebElement checkbox = isElementVisible(By.id("personal-trial-email-optin"), 5);
		checkbox.click();
		WebElement claimTrialBtn = isElementClickable(By.xpath("//p[text()='Claim Free Trial']"), 5);
		claimTrialBtn.submit();
		
		
		
	}
	@Test
	public void validateConfirmEmail() {
		WebElement emailInput = getDriver().findElement(By.id("personal-trial-email"));
		emailInput.sendKeys("andreashuber@yahoo.com");
		WebElement confirmEmailInput = getDriver().findElement(By.id("personal-trial-confirm-email"));
		confirmEmailInput.sendKeys("andreashuber@yahoo.com");
		if(confirmEmailInput.equals(emailInput)) {
			System.out.println("Email matched");
		}
		else {
			Assert.assertEquals(confirmEmailInput, emailInput,"Email must match,confirm email");
		}
	}
	
	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

}

package com.aman.SelCommands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NaveenWebsiteCheckoutTest extends BaseClass {

	@BeforeMethod
	public void launchBrowser() {
		setup();
		getDriver().get(NAUTOMATION_URL);

	}

	@Test
	public void validateCheckout() {
		/*-----------------------Login into the website -----------------------------*/
		getDriver().navigate().to("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		getDriver().findElement(By.id("input-email")).sendKeys("andreas@email.com");
		getDriver().findElement(By.id("input-password")).sendKeys("qwerty");
		getDriver().findElement(By.cssSelector("input[type='submit']")).submit();
		

		/*------------------ Validating if login is successful------------------------------*/
		WebElement myAcctBanner = isElementVisible(By.cssSelector("#content>h2:first-of-type"), 5);
		String banner = myAcctBanner.getText();
		System.out.println(banner);
		Assert.assertEquals(banner, "My Account", "My Account Banner not visible,hence login failed");
		

		/*------------------ Validating title of the page------------------------------------*/
		getDriver().findElement(By.xpath("//a[text()='MP3 Players']")).click();
		getDriver().findElement(By.xpath("//a[text()='Show All MP3 Players']")).click();
		String pageTitle = getDriver().getTitle();
		Assert.assertEquals(pageTitle, "MP3 Players", "Page Title is incorrect, hence test failed");

		/*--------------------- Cliking on the item and adding to cart-----------------------------------*/
		isElementClickable(By.xpath("//a[text()='iPod Classic']"),5).click();
		isElementClickable(By.id("button-cart"), 5).click();


		/*------------------------- Validating if the item has been added to the cart---------------*/
		WebElement total = isElementVisible(By.cssSelector("#cart-total"), 5);
		String itemTotal = total.getText();
		Assert.assertEquals(itemTotal, " 1 item(s) - $100.00",
				"Item has not been added to the cart, hence test failed");

		/*---------------------- Clicking on the checkout button---------------------------------*/
		
		getDriver().findElement(By.cssSelector("div#cart>button")).click();
		getDriver().findElement(By.cssSelector("div>p>a:nth-of-type(2)>strong")).click();

		/*----------------------------Entering the Billing Details--------------------------------------------*/
		getDriver().findElement(By.id("input-payment-firstname")).sendKeys("Andreas");
		getDriver().findElement(By.id("input-payment-lastname")).sendKeys("Huber");
		getDriver().findElement(By.id("input-payment-company")).sendKeys("CC");
		getDriver().findElement(By.id("input-payment-address-1")).sendKeys("Matheson blvd");
		getDriver().findElement(By.id("input-payment-address-2")).sendKeys("East");
		getDriver().findElement(By.id("input-payment-city")).sendKeys("Mississauga");
		getDriver().findElement(By.id("input-payment-postcode")).sendKeys("123456");
		WebElement selectCountry = getDriver().findElement(By.id("input-payment-country"));
		selectDropDown(selectCountry, "Canada");
		WebElement paymentZone = getDriver().findElement(By.id("input-payment-zone"));
		selectDropDown(paymentZone, "Nunavut");
		isElementClickable(By.id("button-payment-address"), 5).submit();
		

		/*------------------------------------Validating Address Radio Buttons ----------------------------------------*/
		WebElement existingAddBtn = isElementClickable(By.cssSelector("div[class=['radio']>label>input:first-of-type"), 5);
		existingAddBtn.click();
		if(!existingAddBtn.isSelected()) {
			existingAddBtn.click();
		}
		Assert.assertTrue(existingAddBtn.isSelected(), "Radio button is not selected");
		
		isElementClickable(By.id("button-shipping-address"), 5).submit();
		
		/*------------------------------------Validating Delivery Method Radio Buttons ----------------------------------------*/
		WebElement shippingRateBtn = isElementClickable(By.cssSelector("div[class='radio']>label>input[name='shipping_method']"), 5);
		if(!shippingRateBtn.isSelected()) {
			shippingRateBtn.click();
		}
		Assert.assertTrue(shippingRateBtn.isSelected(),"Button is not selected, hence test failed");
		
		getDriver().findElement(By.cssSelector("p>textarea[name='comment']")).sendKeys("Old Macdonald had a farm EIEIO");
		
		isElementClickable(By.id("button-shipping-method"), 5).submit();
		
		/*------------------------------------Validating COD Delivery Method Radio Buttons ----------------------------------------*/
		WebElement cashOnDelBtn = isElementClickable(By.cssSelector("input[value ='cod']"), 5);
		if(!cashOnDelBtn.isSelected()) {
			cashOnDelBtn.click();
		}
		Assert.assertTrue(cashOnDelBtn.isSelected(),"Button is not selected, hence test failed");
		
		WebElement termsChkBox = isElementClickable(By.cssSelector("input[type = 'checkbox']"), 5);
		if(!termsChkBox.isSelected()) {
			termsChkBox.click();
		}
		isElementClickable(By.id("button-payment-method"), 5).submit();
		
		/*----------------------------------Confirm Order------------------------------------*/
		WebElement verifyQuantity = getDriver().findElement(By.cssSelector("tbody>tr>td:nth-of-type(3)"));
		String quant = verifyQuantity.getText();
		Assert.assertEquals(quant, "1","Quantity is not matching, please verify the order");
		isElementClickable(By.id("button-confirm"), 5).submit();
		
		WebElement orderConfirmBanner = getDriver().findElement(By.xpath("//h1[text()='Your order has been placed!']"));
		String bannerOrder = orderConfirmBanner.getText();
		Assert.assertEquals(bannerOrder, "Your order has been placed!","Order has not been placed, hence test failed");
		
		

	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

}

package com.aman.SelCommands;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DemoQATest extends BaseClass {

	@BeforeMethod
	public void launchBrowser() {
		setup();
		getDriver().get(DEMOQA_URL);
	}

	@Test
	public void validateToolsLogo() {
		WebElement logo = getDriver().findElement(By.cssSelector("div[id ='app']>header>a>img"));
		logo.isDisplayed();
		Assert.assertTrue(logo.isDisplayed(),"Logo not found");

	}
	@Test
	public void findMultipleElements() {
		List<WebElement> listOfElements = getDriver().findElements(By.cssSelector("div[class='left-pannel']"));
		for(int i=0;i<listOfElements.size();i++) {
			System.out.println(listOfElements.get(i).getText());
			if(listOfElements.get(i).getText().equals("Forms")) {
				listOfElements.get(i).click();
			}
		}
	}

	@AfterMethod
	@Override
	public void tearDown() {
		super.tearDown();
	}

}

package tickertapeFW;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class logoutFunctionality extends mainDriver{
	@BeforeMethod
	public void setup() {
		mainDriver.CreaterInstance("Chrome");
		driver.manage().window().maximize();
		driver.get("https://www.tickertape.in/");
		try {
			driver.findElement(By.xpath("//i[@class=\"jsx-1245644719 jsx-2319868650 icon-Close text-24 text-primary\"]")).click();
		} catch (NoSuchElementException e) {
		}
	}
	
	@Test
	public void logoutTest() throws InterruptedException {
		common.hover("//h5[@class=\"jsx-24004412 typography-body-medium-l navtext \"]");
		common.click("//*[@class=\"jsx-2679829868 jsx-1727362249 regular secondary button-root\"]");
		common.click("//*[@alt=\"Email Logo\"]");
		common.sendKeys("//input[@type=\"email\"]", "pay1@kpay.be");	
		common.click("//*[@class=\"jsx-2679829868 jsx-2491292752 large primary email-login-btn button full-width button-root\"]");
		common.sendKeys("//input[@aria-label=\"Please enter verification code. Digit 1\"]", common.scanner());
		common.hover("//h5[@class=\"jsx-24004412 user-name text-white ellipsis typography-body-medium-m \"]");
		common.click("//*[@class=\"jsx-1033646475 icon-Log-out text-20 rocket-icon mr2\"]");
		Thread.sleep(1000);
		common.hover("//h5[@class=\"jsx-24004412 typography-body-medium-l navtext \"]");
		Assert.assertTrue(common.isDisplayed("//*[@class=\"jsx-2679829868 jsx-1727362249 regular secondary button-root\"]"));
	}
	
	@AfterMethod
	public void close() {
		driver.quit();
	}

}

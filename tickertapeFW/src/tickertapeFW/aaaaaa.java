package tickertapeFW;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class aaaaaa {
	public static WebDriver driver;
	@BeforeMethod
	public void setup()
	{
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\bhaye\\OneDrive\\Desktop\\Data\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("https://www.tickertape.in/");
	driver.manage().window().maximize();
	try
	{
	driver.findElement(By.xpath("//i[@class=\"jsx-1245644719 jsx-2319868650 icon-Close text-24 text-primary\"]")).click();
	}
	catch (NoSuchElementException e)
	{
	}
	}


	@Test
	public void Verify_finance_tab() throws InterruptedException
	{
	driver.findElement(By.xpath("//input[@id=\"search-stock-input\"]")).sendKeys("Infosys");
	Thread.sleep(1000);
	List<WebElement> text_webelement = driver.findElements(By.xpath("//ul[@class=\"react-autosuggest__suggestions-list\"]/li/a/div[1]/p[1]/span[1]"));
	List<WebElement> click_webelement= driver.findElements(By.xpath("//ul[@class=\"react-autosuggest__suggestions-list\"]/li/a/div"));
	int count = text_webelement.size();
	System.out.println(count);
	for(int i=0;i<count;i++)
	{
	String value = text_webelement.get(i).getText();
	if(value.contentEquals("Infosys Ltd"))
	{
	click_webelement.get(i).click();
	break;
	}
	else
	{
	}
	}
	Thread.sleep(2000);
	try
		{
		driver.findElement(By.xpath("(//*[@class=\"jsx-2679829868 jsx-2491292752 regular secondary button-root\"])[1]")).click();
		}
	catch(NoSuchElementException e)
		{
		System.out.println("no popup found");
		}
	driver.findElement(By.xpath("//a[text()=\"Financials\"]")).click();
	}
	
	@AfterMethod
	public void close()
	{
	//driver.quit();
	}

}

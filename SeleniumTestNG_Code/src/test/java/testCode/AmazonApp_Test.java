package testCode;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AmazonApp_Test 
{
	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\m.saif.sanaguppam\\Desktop\\Azure\\SAIF\\Java Notes\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
	}
	
	@Test(priority = 1, groups="Test")
	public void amazonLogoTest()
	{
		boolean a = driver.findElement(By.xpath("//a[contains(@id,'nav-logo-sprites')]")).isDisplayed();
		System.out.println(a);
		//Assert.assertEquals(a, true);
		Assert.assertTrue(a);
	}
	
	@Test(priority = 2, groups="Test")
	public void titleTest()
	{
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in", "Title is not matched");
	}
	
	@Test(priority = 3, groups="Test")
	public void testAddress()
	{
		boolean b = driver.findElement(By.xpath("//a[contains(@id,'nav-global-location-popover-link')]")).isDisplayed();
		System.out.println(b);
		Assert.assertEquals(b, true);
	}
	
	@Test(priority=4, invocationCount = 4)
	public void sampleTest() 
	{
		System.out.println("Test this app");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}


}

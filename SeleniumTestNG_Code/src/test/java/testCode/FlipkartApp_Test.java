package testCode;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FlipkartApp_Test 
{
WebDriver driver;
	
	@Parameters({"username", "password"})
	@BeforeMethod
	public void setUp(String username, String password)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\m.saif.sanaguppam\\Desktop\\Azure\\SAIF\\Java Notes\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
	
		driver.findElement(By.xpath("//input[contains(@class,'_2IX_2- VJZDxU')]")).sendKeys(username);
		driver.findElement(By.xpath("//input[contains(@type,'password')]")).sendKeys(password);
		driver.findElement(By.xpath("//button[contains(@class,'_2KpZ6l _2HKlqd _3AWRsL')]")).click();
	}

	@Test(priority = 1, groups = "Test")
	public void logoTest()
	{
		boolean a = driver.findElement(By.xpath("//div[contains(@class,'_3qX0zy')]")).isDisplayed();
		System.out.println(a);
		Assert.assertTrue(a);
	}

	@Test(priority = 2, groups = "Test")
	public void getTitle()
	{
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!", "Title is not matched");
	}

	@AfterMethod
	public void tearDown() throws InterruptedException 
	{
		Thread.sleep(5000);
		driver.quit();
	}

}

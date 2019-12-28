import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;


public class NewTest
{
	public WebDriver driver;
	@Test
	public void getTitle()
	{
		// assertTrue(driver.getTitle().contains("Change login password of pinkubhui"));
	}
	@BeforeMethod
	public void beforeMethod()
	{
		driver.findElement(By.id("memberUsername")).sendKeys("pinkubhui");
		driver.findElement(By.id("memberName")).sendKeys("pinkubhui");

	}

	@AfterMethod
	public void afterMethod() throws AWTException, InterruptedException 
	{
		Robot robot =new Robot();
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_DOWN);
		driver.findElement(By.xpath("//input[@linkurl='managePasswords?userId=3']")).click();
		

	}

	@BeforeClass
	public void beforeClass() 
	{
		driver.findElement(By.id("cyclosUsername")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@value='1']")).click();
		driver.findElement(By.xpath("//input[@value='2']")).click();
		driver.findElement(By.xpath("//input[@value='3']")).click();
		driver.findElement(By.xpath("//input[@value='4']")).click();

		driver.findElement(By.xpath("//input[@value='Submit']")).click(); 


	}

	@AfterClass
	public void afterClass() 
	{
		
		driver.findElement(By.xpath("//input[@name='newPassword']")).sendKeys("12345"); 
		driver.findElement(By.xpath("//input[@name='newPasswordConfirmation']")).sendKeys("12345");
		driver.findElement(By.xpath("//*[@class='button']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();


	}

	@BeforeTest
	public void beforeTest()
	{

		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8585/");
		driver.manage().window().maximize(); 


	}

	@AfterTest
	public void afterTest()
	{
		String expected ="Change login password of pinkubhui";
		WebElement res = driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]"));
		String actres = res.getText();
		System.out.println(actres);
		assertEquals(actres,expected);
		//driver.quit();  
	}

}

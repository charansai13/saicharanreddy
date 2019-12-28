// This module will check for the change password in the module2 

import org.testng.annotations.Test;
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

public class Admin_Home_Page
{ 
	public WebDriver driver;
	@Test(priority = 1)
	public void login()
	{
		driver.findElement(By.id("cyclosUsername")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@value='1']")).click();
		driver.findElement(By.xpath("//input[@value='2']")).click();
		driver.findElement(By.xpath("//input[@value='3']")).click();
		driver.findElement(By.xpath("//input[@value='4']")).click();
		driver.findElement(By.xpath("//input[@value='Submit']")).click(); 

		driver.findElement(By.id("memberUsername")).sendKeys("pinkubhui");
		driver.findElement(By.id("memberName")).sendKeys("pinkubhui");

	}

	@Test(priority = 2)
	public void personal() throws InterruptedException, AWTException
	{
		Robot robot =new Robot();
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_DOWN);
		driver.findElement(By.xpath("//input[@linkurl='managePasswords?userId=3']")).click();

		String expected ="Change login password of pinkubhui";
		WebElement res = driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]"));
		String actres = res.getText();
		System.out.println(actres);
		assertEquals(actres,expected);
		driver.findElement(By.xpath("//input[@name='newPassword']")).sendKeys("12345"); 
		driver.findElement(By.xpath("//input[@name='newPasswordConfirmation']")).sendKeys("12345");
		driver.findElement(By.xpath("//*[@class='button']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}


	@BeforeClass
	public void beforeClass()
	{
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8585/");
		driver.manage().window().maximize();  
	}

	@AfterClass
	public void afterClass() 
	{
		driver.quit();
	}

}

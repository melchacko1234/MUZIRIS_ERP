package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import manager.BaseClass;

public class Cashopening extends BaseClass{
	
	
public WebDriver Driver=null;

	
	
	@BeforeClass 
	public void setUp() 
	{
		BaseClass bs= new BaseClass();
		driver = bs.initialize_driver();
		driver.get("http://192.168.0.131:8394/posmodules/");
	}
	
	@Test
	public  void cashopened() throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("arun");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.findElement(By.xpath("//*[@id='menu-list']/li[5]/div/a")).click();
		Thread.sleep(5000);

		for (String window : driver.getWindowHandles())
		{

			System.out.println(window);

		}
		// System.out.println(((String) driver.getWindowHandles()).toArray().length);
		String handlewindow = (String) driver.getWindowHandles().toArray()[1];
		driver.switchTo().window(handlewindow);
		Thread.sleep(5000);
	}
		
	}



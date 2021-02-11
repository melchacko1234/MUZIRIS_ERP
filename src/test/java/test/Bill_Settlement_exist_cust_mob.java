package test;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import listners.Allure_listner;
import manager.BaseClass;

public class Bill_Settlement_exist_cust_mob {

	@Listeners({Allure_listner.class})
	public class Customer_Mobile_new_Test {

		WebDriver driver = null;
		public File scrFile;

		@BeforeClass 
		public void setUp()
		{
			BaseClass bs= new BaseClass();
			driver = bs.initialize_driver();
			driver.get("http://192.168.0.131:8394/posmodules/");
		}

		@Severity(SeverityLevel.NORMAL)	
		@Test(priority=1, description="Verify user Registration")
		@Description("Verify user Registration........")
		@Epic("EP0008")
		@Feature("Feature 1: Registration for Customer_Mobile_New ")
		@Story("Story: User registration for Customer_Mobile_New")
		@Step("Verify login Registration for Customer_Mobile_New")
		public void login_Customer_Mobile_New() throws InterruptedException 
		{


			driver.findElement(By.xpath("//input[@name='username']")).sendKeys("arun");
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin");
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			Thread.sleep(5000);

			// Sales Invoice - Estimate Page

			driver.findElement(By.linkText("Bill Settlement")).click();
			

			/*for (String window : driver.getWindowHandles())
			{

				System.out.println(window);

			}*/
			// System.out.println(((String) driver.getWindowHandles()).toArray().length);
			String handlewindow = (String) driver.getWindowHandles().toArray()[1];
			driver.switchTo().window(handlewindow);
			Thread.sleep(5000);
		}

		@Severity(SeverityLevel.CRITICAL)	
		@Test(priority=2, description="Verify user can complete new mobile number registration")
		@Description("Verify user can complete new mobile number registration........")
		@Epic("EP0008")
		@Feature("Feature2: Registration for Customer_Mobile_New ")
		@Story("Story:User registration for Customer_Mobile_New")
		@Step("Verify Registration for Customer_Mobile_New in Customer_Mobile_New page ")
		public void Bill_Settlement_exist_Mobile_cust() throws InterruptedException, IOException

		{
			Thread.sleep(5000);
			driver.findElement(By.xpath("//input[@name='customerInfo_phoneno']")).clear();
			driver.findElement(By.xpath("//input[@name='customerInfo_phoneno']")).sendKeys("9037203719");
			driver.findElement(By.xpath("//input[@name='customerInfo_phoneno']")).click();
			
			Thread.sleep(5000);
			driver.findElement(By.xpath("//button[@id='btnLoyaltyCardRedemption']")).click();
			driver.findElement(By.xpath("//input[@name='loyalty_value']")).sendKeys("30");
			driver.findElement(By.xpath("//button[@id='btnLoyalty_apply']")).click();
			driver.findElement(By.xpath("//button[@id='btnInstrument_Process']")).click();
			
			
			
			//card section
			
			driver.findElement(By.xpath("//button[@id='btnCardPayment']")).click();
			

			
			new Select(driver.findElement(By.id("ddlCardPayment_bank"))).selectByVisibleText("HDFC");
			driver.findElement(By.id("ddlCardPayment_bank")).click();

			
			new Select(driver.findElement(By.id("ddlCardPayment_provider"))).selectByVisibleText("Visa Card");
			driver.findElement(By.id("ddlCardPayment_provider")).click();
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//input[@id='txtCardPayment_amount']")).click();
			driver.findElement(By.xpath("//input[@id='txtCardPayment_amount']")).sendKeys("3700");
			
			driver.findElement(By.xpath("//input[@name='cardPayment_authorizationNo']")).sendKeys("37");
			
			

			new Select(driver.findElement(By.id("ddlCardPayment_cardType"))).selectByVisibleText("Debit Card");
			driver.findElement(By.id("ddlCardPayment_cardType")).click();

			driver.findElement(By.xpath("//input[@id='txtCardPayment_cardNo']")).sendKeys("5200450063007400");
			
			driver.findElement(By.xpath("//input[@id='txtCardPayment_slipNo']")).sendKeys("52");
			Thread.sleep(3000);
			new Select(driver.findElement(By.id("ddlCardPayment_swipingMachine"))).selectByVisibleText("IDBI Machine");
			driver.findElement(By.id("ddlCardPayment_swipingMachine")).click();
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//button[@id='btnCardPayment_addNew']")).sendKeys(Keys.RETURN);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@id='btnCardPayment_apply']")).sendKeys(Keys.RETURN);
			
			//cheque/DD section
			driver.findElement(By.xpath("//button[@id='btnChequePayment']")).sendKeys(Keys.RETURN);
			Thread.sleep(3000);
			new Select(driver.findElement(By.id("ddlChequePayment_mode"))).selectByVisibleText("DD");
			driver.findElement(By.id("ddlChequePayment_mode")).click();
			
			
			new Select(driver.findElement(By.id("ddlChequePayment_bank"))).selectByVisibleText("HDFC");
			driver.findElement(By.id("ddlChequePayment_bank")).click();
			
			
			driver.findElement(By.xpath("//input[@id='txtChequePayment_instrumentNo']")).sendKeys("100");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='txtChequePayment_amount']")).click();
			driver.findElement(By.xpath("//input[@id='txtChequePayment_amount']")).sendKeys("15");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@id='btnChequePayment_addNew']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@id='btnChequePayment_apply']")).click();
			
			//Cashsection
			
			driver.findElement(By.xpath("//button[@id='btnDenominations']")).click();
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("(//input[@value='0'])[9]")).sendKeys("1");
		    driver.findElement(By.xpath("(//input[@value='0'])[10]")).sendKeys("1");
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("//button[@id='btnDenomination_apply']")).click();
			
			Thread.sleep(4000);
			
			
			
			
			
			
		
		}

	}
}

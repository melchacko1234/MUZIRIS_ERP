package test_Bill_settlement;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
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

public class Promotion_123_Nitems_Exist_cust {
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
		public void Bill_Settlement_exist_Mobile_cust_promotion123_scan_estimate() throws InterruptedException, IOException

		{
	
			driver.findElement(By.xpath("//input[@name='scanEstimate']")).sendKeys("EKM30820SIE0378");
			driver.findElement(By.xpath("//input[@name='scanEstimate']")).click();
			driver.findElement(By.xpath("//button[@id='btnGenDiscount']")).click();
			
			
			String handlewindow1 = (String) driver.getWindowHandles().toArray()[1];
			driver.switchTo().window(handlewindow1);
			Thread.sleep(5000);
			
			
			
			new Select(driver.findElement(By.id("ddlGenDisc_additionalDisType"))).selectByVisibleText("Care of");
			driver.findElement(By.id("ddlGenDisc_additionalDisType")).click();
			Thread.sleep(3000);

			driver.findElement(By.xpath("//input[@name='genDisc_additionalDisRate']")).click();
			driver.findElement(By.xpath("//input[@name='genDisc_additionalDisRate']")).sendKeys("3");
			
			
			new Select(driver.findElement(By.id("ddlGenDisc_additionalApprovedBy"))).selectByVisibleText("ANIL KUMAR C.S");
			driver.findElement(By.id("ddlGenDisc_additionalApprovedBy")).click();
			Thread.sleep(3000);
			
			new Select(driver.findElement(By.id("ddlGenDisc_specialDisType"))).selectByVisibleText("MD Refered");
			driver.findElement(By.id("ddlGenDisc_specialDisType")).click();
			Thread.sleep(3000);
			
			
			driver.findElement(By.xpath("//input[@name='genDisc_specialDisRate']")).click();
			driver.findElement(By.xpath("//input[@name='genDisc_specialDisRate']")).sendKeys("1");
			
			
			new Select(driver.findElement(By.id("ddlGenDisc_specialApprovedBy"))).selectByVisibleText("ANIL KUMAR C.S");
			driver.findElement(By.id("ddlGenDisc_specialApprovedBy")).click();
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//button[@id='btnGenDisc_ApplyAndClose']")).click();
			
			String gettext1 =driver.findElement(By.id("notification")).getText();
			System.out.println(gettext1);
			Thread.sleep(5000);
			driver.findElement(By.xpath("//button[@class='close-btn']")).click();
			
			driver.findElement(By.xpath("//input[@name='genDisc_specialDisRate']")).click();
			driver.findElement(By.xpath("//input[@name='genDisc_specialDisRate']")).clear();
			driver.findElement(By.xpath("//input[@name='genDisc_specialDisRate']")).sendKeys("10");
			
			driver.findElement(By.xpath("//button[@id='btnGenDisc_ApplyAndClose']")).click();
		
			
			Thread.sleep(3000);
			
			
		
		
		//public void Bill_Settlement_exist_Mobile_cust_promotion121_apply_cancel_promotion121() throws InterruptedException, IOException

		//{
			//apply promotion
			
			
			/*WebElement element = driver.findElement(By.xpath("//button[@id='btnPromotions']"));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);*/
			driver.findElement(By.xpath("//button[@id='btnPromotions']")).sendKeys(Keys.RETURN);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@id='btnPromotions_ApplyPromotion']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@id='btnPromotions_Close']")).click();
			
			Thread.sleep(3000);
			//cancel promotion
			driver.findElement(By.xpath("//button[@id='btnPromotions']")).sendKeys(Keys.RETURN);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@id='btnPromotions_CancelPromotion']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@id='btnPromotions_Close']")).click();
			Thread.sleep(3000);
			//apply promotion
			
			driver.findElement(By.xpath("//button[@id='btnPromotions']")).sendKeys(Keys.RETURN);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@id='btnPromotions_ApplyPromotion']")).click();
			
			scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("E:\\MUZIRIS_ERP\\Bill_Settlement\\Promotion_123\\Promotion_123_Apply.png"));
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@id='btnPromotions_Close']")).click();
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@id='btnTaxInfo']")).sendKeys(Keys.RETURN);
			Thread.sleep(3000);
			scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("E:\\MUZIRIS_ERP\\Bill_Settlement\\Promotion_123\\Promotion_123_Billsettlement_Tax.png"));

			driver.findElement(By.xpath("//button[@id='btnTaxInfoCancel']")).click();
		}

			@Severity(SeverityLevel.TRIVIAL)	
			@Test(priority=4, description="Verify user can complete Payment")
			@Description("Verify user can complete Payment........")
			@Epic("EP0004")
			@Feature("Feature1: complete Payment ")
			@Story("Story:User complete Payment")
			@Step("complete Payment ")
			
			public void Bill_Settlement_exist_Mobile_cust_promotion123_card_payment() throws InterruptedException

			{
			
			
				driver.findElement(By.xpath("//button[@id='btnInstrument_Process']")).sendKeys(Keys.RETURN);
				driver.findElement(By.xpath("//button[@id='btnCardPayment']")).click();
				

				
				new Select(driver.findElement(By.id("ddlCardPayment_bank"))).selectByVisibleText("HDFC");
				driver.findElement(By.id("ddlCardPayment_bank")).click();

				
				new Select(driver.findElement(By.id("ddlCardPayment_provider"))).selectByVisibleText("Visa Card");
				driver.findElement(By.id("ddlCardPayment_provider")).click();
				Thread.sleep(3000);
				
				driver.findElement(By.xpath("//input[@id='txtCardPayment_amount']")).click();
				driver.findElement(By.xpath("//input[@id='txtCardPayment_amount']")).sendKeys("1000.15");
				
				driver.findElement(By.xpath("//input[@name='cardPayment_authorizationNo']")).sendKeys("40");
				
				

				new Select(driver.findElement(By.id("ddlCardPayment_cardType"))).selectByVisibleText("Debit Card");
				driver.findElement(By.id("ddlCardPayment_cardType")).click();

				driver.findElement(By.xpath("//input[@id='txtCardPayment_cardNo']")).sendKeys("5200450063007412");
				
				driver.findElement(By.xpath("//input[@id='txtCardPayment_slipNo']")).sendKeys("77");
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
				
				
				driver.findElement(By.xpath("//input[@id='txtChequePayment_instrumentNo']")).sendKeys("101");
				Thread.sleep(3000);
				driver.findElement(By.xpath("//input[@id='txtChequePayment_amount']")).click();
				driver.findElement(By.xpath("//input[@id='txtChequePayment_amount']")).sendKeys("8");
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@id='btnChequePayment_addNew']")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@id='btnChequePayment_apply']")).click();
				
				//Cashsection
				
				driver.findElement(By.xpath("//button[@id='btnDenominations']")).click();
				Thread.sleep(3000);
				/*driver.findElement(By.xpath("(//input[@value='0'and@tab-order='6']")).sendKeys("2");
				driver.findElement(By.xpath("(//input[@value='0'and@tab-order='9']")).sendKeys("1");
				driver.findElement(By.xpath("(//input[@value='0'and@tab-order='10']")).sendKeys("1");*/
				
				driver.findElement(By.xpath("(//input[@value='0'])[7]")).sendKeys("1");
				
			    Thread.sleep(3000);
			    
			    
			    
			    driver.findElement(By.xpath("//button[@id='btnDenomination_apply']")).click();
				
				Thread.sleep(4000);
			
			}

	}
}

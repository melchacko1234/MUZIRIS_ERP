package test;

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
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import listners.Allure_listner;
import manager.BaseClass;
import errorvalidations.Invalid_Popup;

public class Promotion_145_ED_500_2500_10percent_discount_existmobilecust extends Invalid_Popup {

	@Listeners({Allure_listner.class})
	public class Customer_Mobile_new_existingTest_Promotion_145_ED_500_2500_10percent_discount extends BaseClass  {

		public WebDriver driver;

		public File scrFile;
		SoftAssert softassert =new SoftAssert();
		public String winHandleBefore;

		public String winHandle;
		public Samplereadtestbarcodescan sc=new Samplereadtestbarcodescan();

		public String handlewindow, handlewindow1, handlewindow2, handlewindow3, handlewindow4;

		@BeforeClass 
		public void setUp() {
			BaseClass bs= new BaseClass();
			driver = bs.initialize_driver();
			driver.get("http://192.168.0.131:8394/posmodules/");
		}

		@Test(priority = 1, description = "verifying MUziris ERP login test")
		@Severity(SeverityLevel.NORMAL)
		@Description("Testcase description: Verfiy login credentinals of MUziris ERP")
		@Epic("EP001")
		@Feature("Feature1: Login")
		@Story("Story:Valid login")
		@Step("Verify login")

		public void Customer_Mobile_existing_login_Promotion_145()  throws InterruptedException, IOException  {

			//Login Page



			driver.findElement(By.xpath("//input[@name='username']")).sendKeys("reshmi");
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin");
			driver.findElement(By.xpath("//button[@type='submit']")).click();


			



			//Sales Invoice - Estimate Page

			driver.findElement(By.linkText("Sales Invoice - Estimate")).click();
			Thread.sleep(5000);
			winHandleBefore = driver.getWindowHandle();

			handlewindow = (String) driver.getWindowHandles().toArray()[1];
			driver.switchTo().window(handlewindow);
			Thread.sleep(5000);

			for(String winHandle : driver.getWindowHandles())
			{
				driver.switchTo().window(winHandle);
			}

			scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("E:\\MUZIRIS_ERP\\Promotion\\Promotion145\\Sales Invoice-Estimate_page.png"));
		}

		@Test(priority = 2, description = "Verifying scanning of first barcode test")
		@Severity(SeverityLevel.NORMAL)
		@Description("Testcase description: Verfiy scanning of first barcode in Sales Invoice - Estimate ")
		@Epic("EP003")
		@Feature("Feature 1: First barcode")
		@Story("Story:First barcode")
		@Step("Verify scanning of first barcode")
		public  void barcode1_promotion145() throws InterruptedException, IOException
		{

			driver.findElement(By.xpath("//input[@name='customerInfo_phoneno']")).sendKeys("9037203719");
			driver.findElement(By.id("form")).submit();
			
			Object [][] arr1=sc.myTest1();
			/*driver.findElement(By.xpath("//input[@name='scanBarcode']")).sendKeys((String) arr1[25][0]);
			//driver.findElement(By.xpath("//input[@name='scanBarcode']")).sendKeys("104680468");
			driver.findElement(By.xpath("//input[@name='scanBarcode']")).sendKeys(Keys.RETURN);
			String gettext =driver.findElement(By.id("notification")).getText();
			System.out.println(gettext);
			Thread.sleep(10000);
			//driver.switchTo().alert().getText();
			driver.findElement(By.xpath("//button[@class='close-btn']")).click();
			//Invalid_Popup.infoBox("YOUR INFORMATION HERE", "TITLE BAR MESSAGE", "HEADER MESSAGE");
			Thread.sleep(5000);*/
			driver.findElement(By.xpath("//input[@name='scanBarcode']")).sendKeys((String) arr1[25][0]);
			//driver.findElement(By.xpath("//input[@name='scanBarcode']")).sendKeys("215983408");
			driver.findElement(By.xpath("//input[@name='scanBarcode']")).click();
			driver.findElement(By.id("txtSalesmanCode")).clear();
			driver.findElement(By.id("txtSalesmanCode")).sendKeys("101");
			driver.findElement(By.xpath("//button[@id='btnDiscount']")).click();
			handlewindow1 = (String) driver.getWindowHandles().toArray()[1];
			driver.switchTo().window(handlewindow1);
			Thread.sleep(5000);
			

			driver.findElement(By.xpath("//input[@name='pdt_additionalDisRate']")).click();
			driver.findElement(By.xpath("//input[@name='pdt_additionalDisRate']")).sendKeys("10");
			
			
			driver.findElement(By.xpath("//button[@id='btnPdt_Apply']")).click();
			Thread.sleep(4000);
			scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("E:\\MUZIRIS_ERP\\Promotion\\Promotion145\\Sales_Invoice-Estimate_Barcode1_promotion.png"));

		}


		//Scanning 2nd item of the barcode


		@Test(priority = 3, description = "Verifying sacnning of Second barcode test")
		@Severity(SeverityLevel.NORMAL)
		@Description("Testcase description: Verfiy sacnning of Second barcode in Sales Invoice - Estimate ")
		@Epic("EP003")
		@Feature("Feature 2: Second barcode")
		@Story("Story:Second barcode")
		@Step("Verify scanning of second barcode")
		public  void barcode2_promotion145() throws InterruptedException, IOException
		{

			Object [][] arr1=sc.myTest1();
			driver.findElement(By.xpath("//input[@name='scanBarcode']")).sendKeys((String) arr1[26][0]);
			//driver.findElement(By.xpath("//input[@name='scanBarcode']")).sendKeys("214688491");
			driver.findElement(By.id("form")).submit();
			driver.findElement(By.id("txtSalesmanCode")).clear();
			driver.findElement(By.id("txtSalesmanCode")).sendKeys("101");
			
		
			
			driver.findElement(By.xpath("//button[@id='btnDone']")).click();
			Thread.sleep(3000);


			//new Select(driver.findElement(By.id("ddlPdt_additionalApprovedBy"))).selectByVisibleText("ANIL KUMAR C.S");
			//driver.findElement(By.name("pdt_additionalApprovedBy")).click();
			
			scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("E:\\MUZIRIS_ERP\\Promotion\\Promotion145\\Sales_Invoice-Estimate_Barcode2_promotion.png"));

		}
		
		@Test(priority = 5, description = "Verifying all barcodes Discount")
		@Severity(SeverityLevel.NORMAL)
		@Description("Testcase description: Verfiy all barcodes Discount in Sales Invoice - Estimate ")
		@Epic("EP003")
		@Feature("Feature 4: All barcodes Discount")
		@Story("Story:all barcodes Discount")
		@Step("Verifying all barcodes Discount")
		public  void promotion145_Discount() throws InterruptedException, IOException
		{

			driver.findElement(By.id("btnGenDiscount")).sendKeys(Keys.RETURN);

			handlewindow3 = (String) driver.getWindowHandles().toArray()[1];
			driver.switchTo().window(handlewindow3);
			Thread.sleep(5000);

			new Select(driver.findElement(By.name("genDisc_additionalDisType"))).selectByVisibleText("Damage");
			driver.findElement(By.name("genDisc_additionalDisType")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='txtGenDisc_additionalDisRate']")).click();
			driver.findElement(By.xpath("//input[@id='txtGenDisc_additionalDisRate']")).sendKeys("10");
		


			
			Thread.sleep(4000);
			driver.findElement(By.xpath("//button[@id='btnGenDisc_ApplyAndClose']")).click();
			Thread.sleep(3000);
			scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("E:\\MUZIRIS_ERP\\Promotion\\Promotion145\\Sales_Invoice-Estimate_Allbarcodes_discount.png"));


		}


		@Test(priority = 6, description = "Verifying whether promotion145 can be applied for the selected barcodes")
		@Severity(SeverityLevel.NORMAL)
		@Description("Testcase description: Verfiy all barcodes Discount in Sales Invoice - Estimate ")
		@Epic("EP003")
		@Feature("Feature 4: All barcodes Discount")
		@Story("Story:all barcodes Discount")
		@Step("Verifying promotion145")
		public  void promotion145() throws InterruptedException, IOException
		{
			driver.findElement(By.xpath("//button[@id='btnPromotions']")).sendKeys(Keys.RETURN);

			handlewindow4 = (String) driver.getWindowHandles().toArray()[1];
			driver.switchTo().window(handlewindow4);
			Thread.sleep(5000);
			 //apply auto Promotion when checked  if Auto Apply is set as 'Y'  in the parameter

			WebElement radioBtn1 = driver.findElement(By.xpath("//input[@id='chkPromotions_Auto']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", radioBtn1);
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//button[@id='btnPromotions_ApplyPromotion']")).click();
			scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("E:\\MUZIRIS_ERP\\Promotion\\Promotion145\\Sales_Invoice-Estimate_Promotion145autoapplyfailedpassed.png"));
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@id='btnPromotions_CancelPromotion']")).click();
			driver.findElement(By.xpath("//input[@name='promotions_PromoCode']")).sendKeys("145");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@id='btnPromotions_ApplyPromotion']")).click();
			Thread.sleep(3000);
			scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("E:\\MUZIRIS_ERP\\Promotion\\Promotion145\\Sales_Invoice-Estimate_Promotion145textappliedfailedpass.png"));
			

			driver.findElement(By.xpath("//button[@id='btnPromotions_CancelPromotion']")).click();
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//button[@id='btnPromotions_Close']")).click();
			
			
			//Promotion only if the Additional Discount is less than 5
			
			
			driver.findElement(By.id("btnGenDiscount")).sendKeys(Keys.RETURN);

			String handlewindow6 = (String) driver.getWindowHandles().toArray()[1];
			driver.switchTo().window(handlewindow6);
			Thread.sleep(5000);
			
			driver.findElement(By.xpath("//input[@id='txtGenDisc_additionalDisRate']")).clear();
			driver.findElement(By.xpath("//input[@id='txtGenDisc_additionalDisRate']")).click();
			driver.findElement(By.xpath("//input[@id='txtGenDisc_additionalDisRate']")).sendKeys("4");
			
			driver.findElement(By.xpath("//button[@id='btnGenDisc_ApplyAndClose']")).click();
			
			driver.findElement(By.xpath("//button[@id='btnPromotions']")).sendKeys(Keys.RETURN);

			String handlewindow8 = (String) driver.getWindowHandles().toArray()[1];
			driver.switchTo().window(handlewindow8);
			Thread.sleep(5000);
			
			driver.findElement(By.xpath("//input[@name='promotions_PromoCode']")).sendKeys("145");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@id='btnPromotions_ApplyPromotion']")).click();
			Thread.sleep(5000);
			scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("E:\\MUZIRIS_ERP\\Promotion\\Promotion145\\Sales_Invoice-Estimate_Promotion145applied.png"));

			driver.findElement(By.xpath("//button[@id='btnPromotions_Close']")).click();
			Thread.sleep(6000);
			
			scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("E:\\MUZIRIS_ERP\\Promotion\\Promotion145\\Sales_Invoice-Estimate_Promotion145finalscreen.png"));



			driver.switchTo().window(winHandleBefore);

			driver.findElement(By.xpath("//a[@id='profileDropdown']/span")).click();
			driver.findElement(By.xpath("//button[@type='submit']")).click();

		}

		@AfterClass
		public void tearDown()
		{	
			driver.close();
			driver.quit();
		}


	}
}


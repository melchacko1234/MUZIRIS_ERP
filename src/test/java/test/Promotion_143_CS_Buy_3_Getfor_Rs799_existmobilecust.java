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

public class Promotion_143_CS_Buy_3_Getfor_Rs799_existmobilecust {

	@Listeners({Allure_listner.class})
	public class Customer_Mobile_new_existing_Promotion_143_CS_Buy_3_Getfor_Rs799 extends BaseClass  {

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

		@Test(priority = 1, description = "verifying MUziris ERP login test for promotion143")
		@Severity(SeverityLevel.NORMAL)
		@Description("Testcase description: Verfiy login credentinals of MUziris ERP")
		@Epic("EP001")
		@Feature("Feature1: Login")
		@Story("Story:Valid login")
		@Step("Verify login")

		public void Customer_Mobile_existing_login_Promotion_143_combo_sales ()  throws InterruptedException, IOException  {

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
			FileUtils.copyFile(scrFile, new File("E:\\MUZIRIS_ERP\\Promotion\\Promotion143\\Sales Invoice-Estimate_page.png"));
		}

		@Test(priority = 2, description = "Verifying scanning of first barcode test for Promotion143")
		@Severity(SeverityLevel.NORMAL)
		@Description("Testcase description: Verfiy scanning of first barcode in Sales Invoice - Estimate ")
		@Epic("EP009")
		@Feature("Feature 1: First barcode for Promotion143")
		@Story("Story:First barcodefor  Promotion143")
		@Step("Verify scanning of first barcode for Promotion143")
		public  void barcode1_promotion143() throws InterruptedException, IOException
		{

			driver.findElement(By.xpath("//input[@name='customerInfo_phoneno']")).sendKeys("9037203719");
			driver.findElement(By.id("form")).submit();
			
			
			Object [][] arr1=sc.myTest1();
			//driver.findElement(By.xpath("//input[@name='scanBarcode']")).sendKeys((String) arr1[17][0]);
			//driver.findElement(By.xpath("//input[@name='scanBarcode']")).sendKeys("228309444");
			/*driver.findElement(By.xpath("//input[@name='scanBarcode']")).sendKeys(Keys.RETURN);
			String gettext =driver.findElement(By.id("notification")).getText();
			System.out.println(gettext);
			Thread.sleep(5000);
			driver.findElement(By.xpath("//button[@class='close-btn']")).click();
			driver.findElement(By.xpath("//input[@name='scanBarcode']")).sendKeys((String) arr1[18][0]);
			//driver.findElement(By.xpath("//input[@name='scanBarcode']")).sendKeys("2212598913452");
			driver.findElement(By.xpath("//input[@name='scanBarcode']")).sendKeys(Keys.RETURN);
			String gettext1 =driver.findElement(By.id("notification")).getText();
			System.out.println(gettext1);
			Thread.sleep(5000);
			driver.findElement(By.xpath("//button[@class='close-btn']")).click();*/
			
			
			
			driver.findElement(By.xpath("//input[@name='scanBarcode']")).sendKeys((String) arr1[17][0]);
			
			driver.findElement(By.xpath("//input[@name='scanBarcode']")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("txtSalesmanCode")).clear();
			driver.findElement(By.id("txtSalesmanCode")).sendKeys("101");
			driver.findElement(By.xpath("//button[@id='btnDiscount']")).click();
			handlewindow1 = (String) driver.getWindowHandles().toArray()[1];
			driver.switchTo().window(handlewindow1);
			Thread.sleep(5000);
			new Select(driver.findElement(By.id("ddlPdt_additionalDisType"))).selectByVisibleText("Care of");
			driver.findElement(By.id("ddlPdt_additionalDisType")).click();
			Thread.sleep(3000);

			driver.findElement(By.xpath("//input[@name='pdt_additionalDisRate']")).click();
			driver.findElement(By.xpath("//input[@name='pdt_additionalDisRate']")).sendKeys("3.5");
			
			
			driver.findElement(By.xpath("//button[@id='btnPdt_Apply']")).click();
			Thread.sleep(4000);
			scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("E:\\MUZIRIS_ERP\\Promotion\\Promotion143\\Sales_Invoice-Estimate_Barcode1_promotion143.png"));

		}


		//Scanning 2nd item of the barcode


		@Test(priority = 3, description = "Verifying scanning of Second barcode test for promotion143")
		@Severity(SeverityLevel.NORMAL)
		@Description("Testcase description: Verfiy scanning of Second barcode in Sales Invoice - Estimate for promotion143 ")
		@Epic("EP009")
		@Feature("Feature 2: Second barcode f or promotion143")
		@Story("Story:Second barcode for promotion143")
		@Step("Verify scanning of second barcode for promotion143")
		public  void barcode2_promotion143() throws InterruptedException, IOException
		{

			Object [][] arr1=sc.myTest1();
			driver.findElement(By.xpath("//input[@name='scanBarcode']")).sendKeys((String) arr1[18][0]);
			//driver.findElement(By.xpath("//input[@name='scanBarcode']")).sendKeys("228097347");
			driver.findElement(By.xpath("//input[@name='scanBarcode']")).click();
			driver.findElement(By.id("txtSalesmanCode")).clear();
			driver.findElement(By.id("txtSalesmanCode")).sendKeys("101");
			
		
			
			driver.findElement(By.xpath("//button[@id='btnDone']")).click();
			Thread.sleep(4000);
			scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("E:\\MUZIRIS_ERP\\Promotion\\Promotion143\\Sales_Invoice-Estimate_Barcode2_promotion143.png"));

		}
		

		@Test(priority = 4, description = "Verifying sacnning of third barcode test for promotion143")
		@Severity(SeverityLevel.NORMAL)
		@Description("Testcase description: Verfiy scanning of third barcode in Sales Invoice - Estimate for promotion122 ")
		@Epic("EP009")
		@Feature("Feature 4: Third barcode for promotion143")
		@Story("Story:Third barcode for promotion143")
		@Step("Verify scanning of Third barcode for promotion143")
		public  void barcode3_promotion143() throws InterruptedException, IOException
		{
			Object [][] arr1=sc.myTest1();
			driver.findElement(By.xpath("//input[@name='scanBarcode']")).sendKeys((String) arr1[19][0]);
			//driver.findElement(By.xpath("//input[@name='scanBarcode']")).sendKeys("228097349");
			driver.findElement(By.xpath("//input[@name='scanBarcode']")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("txtSalesmanCode")).clear();
			driver.findElement(By.id("txtSalesmanCode")).sendKeys("101");
		
			driver.findElement(By.xpath("//button[@id='btnDone']")).click();

			Thread.sleep(2000);
			scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("E:\\MUZIRIS_ERP\\Promotion\\Promotion143\\Sales_Invoice-Estimate_Barcode3_promotion143.png"));

		}
		
		
		@Test(priority = 5, description = "Verifying all barcodes Discount")
		@Severity(SeverityLevel.NORMAL)
		@Description("Testcase description: Verfiy all barcodes Discount in Sales Invoice - Estimate ")
		@Epic("EP009")
		@Feature("Feature 9: All barcodes Discount")
		@Story("Story:All barcodes Discount")
		@Step("Verifying all barcodes Discount")
		public  void promotion143_Discount() throws InterruptedException, IOException
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
			Thread.sleep(3000);


			
			driver.findElement(By.xpath("//button[@id='btnGenDisc_ApplyAndClose']")).click();
			Thread.sleep(3000);
			scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("E:\\MUZIRIS_ERP\\Promotion\\Promotion143\\Sales_Invoice-Estimate_Allbarcodes_discount124.png"));


		}


		@Test(priority = 6, description = "Verifying whether promotion143 can be applied for the selected barcodes")
		@Severity(SeverityLevel.NORMAL)
		@Description("Testcase description: Verfiy all barcodes Discount in Sales Invoice - Estimate ")
		@Epic("EP009")
		@Feature("Feature 10: All barcodes promotion")
		@Story("Story:all barcodes promotion")
		@Step("Verifying promotion143")
		public  void promotion143() throws InterruptedException, IOException
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
			FileUtils.copyFile(scrFile, new File("E:\\MUZIRIS_ERP\\Promotion\\Promotion143\\Sales_Invoice-Estimate_Promotion143autoapplyfailedpassed.png"));
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@id='btnPromotions_CancelPromotion']")).click();
			driver.findElement(By.xpath("//input[@name='promotions_PromoCode']")).sendKeys("143");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@id='btnPromotions_ApplyPromotion']")).click();
			Thread.sleep(3000);
			scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("E:\\MUZIRIS_ERP\\Promotion\\Promotion143\\Sales_Invoice-Estimate_Promotion143textappliedfailedpass.png"));
			

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
			
			driver.findElement(By.xpath("//input[@name='promotions_PromoCode']")).sendKeys("143");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@id='btnPromotions_ApplyPromotion']")).click();
			Thread.sleep(5000);
			scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("E:\\MUZIRIS_ERP\\Promotion\\Promotion143\\Sales_Invoice-Estimate_Promotion143applied.png"));

			driver.findElement(By.xpath("//button[@id='btnPromotions_Close']")).click();
			Thread.sleep(6000);
			
			scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("E:\\MUZIRIS_ERP\\Promotion\\Promotion143\\Sales_Invoice-Estimate_Promotion143finalscreen.png"));







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






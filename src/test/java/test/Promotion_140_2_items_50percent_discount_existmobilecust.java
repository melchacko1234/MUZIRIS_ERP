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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
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
import utils.Readingbarcode_excel;
import test.Samplereadtestbarcodescan;

public class Promotion_140_2_items_50percent_discount_existmobilecust {




	@Listeners({Allure_listner.class})
	public class Customer_Mobile_new_existingTest_Promotion_140_2_items_50percent_discount extends BaseClass  {

		public WebDriver driver;

		public File scrFile;
		SoftAssert softassert =new SoftAssert();
		public String winHandleBefore;

		public Samplereadtestbarcodescan sc=new Samplereadtestbarcodescan();


		public String winHandle;

		public String handlewindow, handlewindow1, handlewindow2, handlewindow3, handlewindow4;

		@BeforeClass 
		public void setUp() {
			BaseClass bs= new BaseClass();
			driver = bs.initialize_driver();
			driver.get("http://192.168.0.131:8394/posmodules/");
		}

		@Test(priority = 1, description = "verifying MUziris ERP login test for Promotion140")
		@Severity(SeverityLevel.NORMAL)
		@Description("Testcase description: Verfiy login credentinals of MUziris ERP")
		@Epic("EP001")
		@Feature("Feature1: Login")
		@Story("Story:Valid login")
		@Step("Verify login")

		public void Customer_Mobile_existing_login_Promotion_140_2_items_50percent_discount()  throws InterruptedException, IOException  {

			//Login Page



			driver.findElement(By.xpath("//input[@name='username']")).sendKeys("reshmi");
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin");
			driver.findElement(By.xpath("//button[@type='submit']")).click();


			/* String actualTitle = driver.getTitle();
			String expectedTitle = "Admin home";
			softassert.assertEquals(false, true, expectedTitle);
		   softassert.assertEquals(driver.getTitle(), "Admin home1");
		   softassert.assertAll();*/

			//if user is logged in steps to logout and login  again

			/*	
			if(driver.findElement(By.xpath("//button[@id='btnLogout']")).isDisplayed())
			{
				driver.findElement(By.xpath("//button[@id='btnLogout']")).click();

				driver.findElement(By.xpath("//input[@name='username']")).sendKeys("arun");
				driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin");
				driver.findElement(By.xpath("//button[@type='submit']")).click();

			} else {


				driver.findElement(By.xpath("//input[@name='username']")).sendKeys("arun");
				driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin");
				driver.findElement(By.xpath("//button[@type='submit']")).click();
			 */




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
			FileUtils.copyFile(scrFile, new File("E:\\MUZIRIS_ERP\\Promotion\\Promotion140\\Sales Invoice-Estimate_page.png"));
		}

		@Test(priority = 2, description = "Verifying scanning of first barcode test for Promotion140")
		@Severity(SeverityLevel.NORMAL)
		@Description("Testcase description: Verfiy scanning of first barcode in Sales Invoice - Estimate for Promotion140 ")
		@Epic("EP004")
		@Feature("Feature 1: First barcode for Promotion140")
		@Story("Story:First barcode for Promotion140")
		@Step("Verify scanning of first barcode for Promotion140")
		public  void barcode1_promotion140() throws InterruptedException, IOException
		{



			driver.findElement(By.xpath("//input[@name='customerInfo_phoneno']")).sendKeys("9037203719");
			driver.findElement(By.id("form")).submit();
			//Samplereadtestbarcodescan sc=new Samplereadtestbarcodescan();
			Object [][] arr1=sc.myTest1();

			//for(int i=1;i<arr1.length;i++)

			driver.findElement(By.xpath("//input[@name='scanBarcode']")).sendKeys((String) arr1[1][0]);





			//driver.findElement(By.xpath("//input[@name='scanBarcode']")).sendKeys("281500095145");
			driver.findElement(By.xpath("//input[@name='scanBarcode']")).sendKeys(Keys.RETURN);
			Thread.sleep(7000);
			driver.findElement(By.xpath("//input[@id='txtPiece']")).clear();
			driver.findElement(By.xpath("//input[@id='txtPiece']")).sendKeys("2");
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
			driver.findElement(By.xpath("//input[@name='pdt_additionalDisRate']")).sendKeys("5");
			/*new Select(driver.findElement(By.name("pdt_additionalApprovedBy"))).selectByVisibleText("ANIL KUMAR C.S");
			driver.findElement(By.name("pdt_additionalApprovedBy")).click();*/
			Thread.sleep(4000);
			driver.findElement(By.xpath("//button[@id='btnPdt_Apply']")).click();
			scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("E:\\MUZIRIS_ERP\\Promotion\\Promtion140\\Sales_Invoice-Estimate_Barcode1_promotion.png"));

		}


		//Scanning 2nd item of the barcode


		@Test(priority = 3, description = "Verifying sacnning of Second barcode test for Promotion140")
		@Severity(SeverityLevel.NORMAL)
		@Description("Testcase description: Verfiy sacnning of Second barcode in Sales Invoice - Estimate for Promotion140 ")
		@Epic("EP004")
		@Feature("Feature 2: Second barcode for Promotion140")
		@Story("Story:Second barcode for Promotion140")
		@Step("Verify scanning of second barcode for Promotion140")
		public  void barcode2_promotion140() throws InterruptedException, IOException



		{

			
			Object [][] arr1=sc.myTest1();



			driver.findElement(By.xpath("//input[@name='scanBarcode']")).sendKeys((String) arr1[2][0]);


			//driver.findElement(By.xpath("//input[@name='scanBarcode']")).sendKeys("281500117291");
			driver.findElement(By.xpath("//input[@name='scanBarcode']")).sendKeys(Keys.RETURN);
			driver.findElement(By.id("txtSalesmanCode")).clear();
			driver.findElement(By.id("txtSalesmanCode")).sendKeys("101");
			driver.findElement(By.xpath("//button[@id='btnDone']")).click();
			
			//button[@id='btnDone']
			/*driver.findElement(By.xpath("//button[@id='btnDiscount']")).sendKeys(Keys.RETURN);
			handlewindow2 = (String) driver.getWindowHandles().toArray()[1];
			driver.switchTo().window(handlewindow2);
			Thread.sleep(5000);
			new Select(driver.findElement(By.id("ddlPdt_additionalDisType"))).selectByVisibleText("Damage");
			driver.findElement(By.id("ddlPdt_additionalDisType")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@name='pdt_additionalDisAmt']")).click();
			driver.findElement(By.xpath("//input[@name='pdt_additionalDisAmt']")).sendKeys("10");

			Thread.sleep(3000);*/


			/*new Select(driver.findElement(By.id("ddlPdt_additionalApprovedBy"))).selectByVisibleText("ANIL KUMAR C.S");
			driver.findElement(By.name("pdt_additionalApprovedBy")).click();*/
			Thread.sleep(4000);
			//driver.findElement(By.xpath("//button[@id='btnPdt_Apply']")).click();
			scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("E:\\MUZIRIS_ERP\\Promotion\\Promotion140\\Sales_Invoice-Estimate_Barcode2_promotion140.png"));

		}
		//3rd bardcode scan and also validation of enough stock for the particular barcode.

		/*@Test(priority = 4, description = "Verifying sacnning of third barcode test for Promtion121")
		@Severity(SeverityLevel.NORMAL)
		@Description("Testcase description: Verfiy sacnning of third barcode in Sales Invoice - Estimate for Promtion121 ")
		@Epic("EP004")
		@Feature("Feature 4: Third barcode for Promtion121")
		@Story("Story:Third barcode for Promtion121")
		@Step("Verify scanning of Third barcode for Promtion121")
		public  void barcode3_promotion121() throws InterruptedException, IOException
		{
			Object [][] arr1=sc.myTest1();



			driver.findElement(By.xpath("//input[@name='scanBarcode']")).sendKeys((String) arr1[3][0]);

			//driver.findElement(By.xpath("//input[@name='scanBarcode']")).sendKeys("172657942");
			driver.findElement(By.id("form")).submit();
			//Thread.sleep(3000);
			//driver.findElement(By.xpath("//input[@id='txtPiece']")).clear();
			//driver.findElement(By.xpath("//input[@id='txtPiece']")).sendKeys("2");
			Thread.sleep(5000);
			//driver.findElement(By.id("txtSalesmanCode")).click();
			//driver.findElement(By.id("txtSalesmanCode")).sendKeys("102");
			driver.findElement(By.xpath("//button[@id='btnDone']")).click();

			Thread.sleep(2000);
			scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("E:\\MUZIRIS_ERP\\Promotion\\Promtion121\\Sales_Invoice-Estimate_Barcode3_promotion.png"));

		}*/



		@Test(priority = 5, description = "Verifying all barcodes Discount for Promotion140")
		@Severity(SeverityLevel.NORMAL)
		@Description("Testcase description: Verfiy all barcodes Discount in Sales Invoice - Estimate for Promotion140")
		@Epic("EP004")
		@Feature("Feature 6: All barcodes Discount for Promotion140")
		@Story("Story:all barcodes Discount for Promotion140")
		@Step("Verifying all barcodes Discount for Promotion140")
		public  void Promotion140_Discount() throws InterruptedException, IOException
		{

			driver.findElement(By.id("btnGenDiscount")).sendKeys(Keys.RETURN);

			handlewindow3 = (String) driver.getWindowHandles().toArray()[1];
			driver.switchTo().window(handlewindow3);
			Thread.sleep(5000);

			new Select(driver.findElement(By.name("genDisc_additionalDisType"))).selectByVisibleText("Damage");
			driver.findElement(By.name("genDisc_additionalDisType")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='txtGenDisc_additionalDisRate']")).click();
			driver.findElement(By.xpath("//input[@id='txtGenDisc_additionalDisRate']")).sendKeys("6");
			Thread.sleep(3000);


			//new Select(driver.findElement(By.name("genDisc_additionalApprovedBy"))).selectByVisibleText("ANIL KUMAR C.S");
			//driver.findElement(By.name("genDisc_additionalApprovedBy")).click();
			Thread.sleep(4000);
			driver.findElement(By.xpath("//button[@id='btnGenDisc_ApplyAndClose']")).click();
			Thread.sleep(3000);
			scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("E:\\MUZIRIS_ERP\\Promotion\\Promotion140\\Sales_Invoice-Estimate_Allbarcodes_discount.png"));


		}


		@Test(priority = 6, description = "Verifying whether Promotion140 can be applied for the selected barcodes")
		@Severity(SeverityLevel.NORMAL)
		@Description("Testcase description: Verfiy whether promotion140 applied in Sales Invoice ")
		@Epic("EP004")
		@Feature("Feature 7: Whether Promotion140 applied")
		@Story("Story:Whether Promotion140 applied or not ")
		@Step("Verifying Promotion140")
		public  void Promotion140() throws InterruptedException, IOException
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
			FileUtils.copyFile(scrFile, new File("E:\\MUZIRIS_ERP\\Promotion\\Promotion140\\Sales_Invoice-Estimate_promotion140autoapplyfailedpassed.png"));
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@id='btnPromotions_CancelPromotion']")).click();
			driver.findElement(By.xpath("//input[@name='promotions_PromoCode']")).sendKeys("140");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@id='btnPromotions_ApplyPromotion']")).click();
			Thread.sleep(3000);

			driver.findElement(By.xpath("//button[@id='btnPromotions_CancelPromotion']")).click();
			Thread.sleep(3000);
			scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("E:\\MUZIRIS_ERP\\Promotion\\Promotion140\\Sales_Invoice-Estimate_promotion140textappliedfailedpass.png"));
			
			driver.findElement(By.xpath("//button[@id='btnPromotions_Close']")).click();
			
			
			//Promotion only if the Additional Discount is less than 5
			
			
			driver.findElement(By.id("btnGenDiscount")).sendKeys(Keys.RETURN);

			String handlewindow6 = (String) driver.getWindowHandles().toArray()[1];
			driver.switchTo().window(handlewindow6);
			Thread.sleep(5000);
			
			driver.findElement(By.xpath("//input[@id='txtGenDisc_additionalDisRate']")).clear();
			driver.findElement(By.xpath("//input[@id='txtGenDisc_additionalDisRate']")).click();
			driver.findElement(By.xpath("//input[@id='txtGenDisc_additionalDisRate']")).sendKeys("3.5");
			
			driver.findElement(By.xpath("//button[@id='btnGenDisc_ApplyAndClose']")).click();
			
			driver.findElement(By.xpath("//button[@id='btnPromotions']")).sendKeys(Keys.RETURN);

			String handlewindow8 = (String) driver.getWindowHandles().toArray()[1];
			driver.switchTo().window(handlewindow8);
			Thread.sleep(5000);
			
			driver.findElement(By.xpath("//input[@name='promotions_PromoCode']")).sendKeys("140");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@id='btnPromotions_ApplyPromotion']")).click();
			
			
			driver.findElement(By.xpath("//button[@id='btnPromotions_Close']")).click();
			Thread.sleep(3000);
			scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("E:\\MUZIRIS_ERP\\Promotion\\Promtion140\\Sales_Invoice-Estimate_promotion140.png"));

			

			
			
			driver.switchTo().window(winHandleBefore);
			
			driver.findElement(By.xpath("//a[@id='profileDropdown']/span")).click();
		    driver.findElement(By.xpath("//button[@type='submit']")).click();
		
			

		}


		@AfterClass
		public void tearDown()
		{	
			//driver.close();
			//driver.quit();
		}



	}
}

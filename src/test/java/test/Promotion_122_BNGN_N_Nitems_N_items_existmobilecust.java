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

public class Promotion_122_BNGN_N_Nitems_N_items_existmobilecust {
	@Listeners({Allure_listner.class})
	public class Customer_Mobile_new_existingTest_Promotion_122_N_items extends BaseClass  {

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

		@Test(priority = 1, description = "verifying MUziris ERP login test for promotion122")
		@Severity(SeverityLevel.NORMAL)
		@Description("Testcase description: Verfiy login credentinals of MUziris ERP")
		@Epic("EP001")
		@Feature("Feature1: Login")
		@Story("Story:Valid login")
		@Step("Verify login")

		public void Customer_Mobile_existing_login_Promotion_122_N_items ()  throws InterruptedException, IOException  {

			//Login Page



			driver.findElement(By.xpath("//input[@name='username']")).sendKeys("arun");
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin");
			driver.findElement(By.xpath("//button[@type='submit']")).click();


			/* String actualTitle = driver.getTitle();
			String expectedTitle = "Admin home";
			softassert.assertEquals(false, true, expectedTitle);
		   softassert.assertEquals(driver.getTitle(), "Admin home1");
		   softassert.assertAll();*/



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
			FileUtils.copyFile(scrFile, new File("E:\\MUZIRIS_ERP\\Promotion\\Promtion122\\Sales Invoice-Estimate_page.png"));
		}

		@Test(priority = 2, description = "Verifying scanning of first barcode test for Promtion122")
		@Severity(SeverityLevel.NORMAL)
		@Description("Testcase description: Verfiy scanning of first barcode in Sales Invoice - Estimate ")
		@Epic("EP007")
		@Feature("Feature 1: First barcode for Promtion122")
		@Story("Story:First barcodefor  Promtion122")
		@Step("Verify scanning of first barcode for Promtion122")
		public  void barcode1_promotion122() throws InterruptedException, IOException
		{
			
			
			Object [][] arr1=sc.myTest1();
			driver.findElement(By.xpath("//input[@name='customerInfo_phoneno']")).sendKeys("9037203719");
			driver.findElement(By.id("form")).submit();
			driver.findElement(By.xpath("//input[@name='scanBarcode']")).sendKeys((String) arr1[5][0]);
			driver.findElement(By.xpath("//input[@name='scanBarcode']")).sendKeys(Keys.RETURN);
			String gettext =driver.findElement(By.id("notification")).getText();
			System.out.println(gettext);
			Thread.sleep(5000);
			driver.findElement(By.xpath("//button[@class='close-btn']")).click();
			
			driver.findElement(By.xpath("//input[@name='scanBarcode']")).sendKeys((String) arr1[6][0]);
			driver.findElement(By.xpath("//input[@name='scanBarcode']")).sendKeys(Keys.RETURN);
			String gettext1 =driver.findElement(By.id("notification")).getText();
			System.out.println(gettext1);
			Thread.sleep(5000);
			driver.findElement(By.xpath("//button[@class='close-btn']")).click();
			
			
			//Invalid_Popup.infoBox("YOUR INFORMATION HERE", "TITLE BAR MESSAGE", "HEADER MESSAGE");
			
			driver.findElement(By.xpath("//input[@name='scanBarcode']")).sendKeys("221387482");
			driver.findElement(By.xpath("//input[@name='scanBarcode']")).click();
			driver.findElement(By.id("txtSalesmanCode")).sendKeys("102");
			driver.findElement(By.xpath("//button[@id='btnDiscount']")).click();
			handlewindow1 = (String) driver.getWindowHandles().toArray()[1];
			driver.switchTo().window(handlewindow1);
			Thread.sleep(5000);
			new Select(driver.findElement(By.id("ddlPdt_additionalDisType"))).selectByVisibleText("Care of");
			driver.findElement(By.id("ddlPdt_additionalDisType")).click();
			Thread.sleep(3000);

			driver.findElement(By.xpath("//input[@name='pdt_additionalDisRate']")).click();
			driver.findElement(By.xpath("//input[@name='pdt_additionalDisRate']")).sendKeys("3.5");
			new Select(driver.findElement(By.name("pdt_additionalApprovedBy"))).selectByVisibleText("ANIL KUMAR C.S");
			driver.findElement(By.name("pdt_additionalApprovedBy")).click();
			Thread.sleep(4000);
			driver.findElement(By.xpath("//button[@id='btnPdt_Apply']")).click();
			scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("E:\\MUZIRIS_ERP\\Promotion\\Promtion125\\Sales_Invoice-Estimate_Barcode1_promotion122.png"));

		}


		//Scanning 2nd item of the barcode


		@Test(priority = 3, description = "Verifying scanning of Second barcode test for promotion122")
		@Severity(SeverityLevel.NORMAL)
		@Description("Testcase description: Verfiy scanning of Second barcode in Sales Invoice - Estimate for promotion122 ")
		@Epic("EP007")
		@Feature("Feature 2: Second barcode f or promotion122")
		@Story("Story:Second barcode for promotion122")
		@Step("Verify scanning of second barcode for promotion122")
		public  void barcode2_promotion122() throws InterruptedException, IOException
		{

			Object [][] arr1=sc.myTest1();
			driver.findElement(By.xpath("//input[@name='scanBarcode']")).sendKeys((String) arr1[7][0]);
			driver.findElement(By.xpath("//input[@name='scanBarcode']")).click();
			//driver.findElement(By.id("txtSalesmanCode")).sendKeys("102");
			driver.findElement(By.xpath("//button[@id='btnDiscount']")).click();
			handlewindow2 = (String) driver.getWindowHandles().toArray()[1];
			driver.switchTo().window(handlewindow2);
			Thread.sleep(5000);
			new Select(driver.findElement(By.id("ddlPdt_additionalDisType"))).selectByVisibleText("Damage");
			driver.findElement(By.id("ddlPdt_additionalDisType")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@name='pdt_additionalDisAmt']")).click();
			driver.findElement(By.xpath("//input[@name='pdt_additionalDisAmt']")).sendKeys("10");

			Thread.sleep(3000);


			new Select(driver.findElement(By.id("ddlPdt_additionalApprovedBy"))).selectByVisibleText("ANIL KUMAR C.S");
			driver.findElement(By.name("pdt_additionalApprovedBy")).click();
			Thread.sleep(4000);
			driver.findElement(By.xpath("//button[@id='btnPdt_Apply']")).click();
			scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("E:\\MUZIRIS_ERP\\Promotion\\Promtion122\\Sales_Invoice-Estimate_Barcode2_promotion122.png"));

		}
		

		@Test(priority = 4, description = "Verifying sacnning of third barcode test for promotion122")
		@Severity(SeverityLevel.NORMAL)
		@Description("Testcase description: Verfiy sacnning of third barcode in Sales Invoice - Estimate for promotion122 ")
		@Epic("EP007")
		@Feature("Feature 4: Third barcode for promotion122")
		@Story("Story:Third barcode for promotion122")
		@Step("Verify scanning of Third barcode for promotion122")
		public  void barcode3_promotion122() throws InterruptedException, IOException
		{
			//code to check validation of enough stock.
			Object [][] arr1=sc.myTest1();
			driver.findElement(By.xpath("//input[@name='scanBarcode']")).sendKeys((String) arr1[8][0]);
			driver.findElement(By.xpath("//input[@name='scanBarcode']")).click();
			Thread.sleep(3000);
		
			driver.findElement(By.xpath("//button[@id='btnDone']")).click();

			Thread.sleep(2000);
			scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("E:\\MUZIRIS_ERP\\Promotion\\Promtion122\\Sales_Invoice-Estimate_Barcode3_promotion122.png"));

		}
		
		
		@Test(priority = 5, description = "Verifying sacnning of fourth barcode test for promotion122")
		@Severity(SeverityLevel.NORMAL)
		@Description("Testcase description: Verfiy sacnning of fourth barcode in Sales Invoice - Estimate for promotion122 ")
		@Epic("EP007")
		@Feature("Feature 5: Fourth  barcode for promotion122")
		@Story("Fourth barcode for promotion122")
		@Step("Verify scanning of Fourth barcode for promotion122")
		public  void barcode4_promotion122() throws InterruptedException, IOException
		{
			//code to check validation of enough stock.
			Object [][] arr1=sc.myTest1();
			driver.findElement(By.xpath("//input[@name='scanBarcode']")).sendKeys((String) arr1[9][0]);
			driver.findElement(By.xpath("//input[@name='scanBarcode']")).click();
			Thread.sleep(3000);
		
			driver.findElement(By.xpath("//button[@id='btnDone']")).click();

			Thread.sleep(2000);
			scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("E:\\MUZIRIS_ERP\\Promotion\\Promtion122\\Sales_Invoice-Estimate_Barcode4_promotion122.png"));

		}
		
		@Test(priority = 6, description = "Verifying sacnning of Fifth barcode test for promotion122")
		@Severity(SeverityLevel.NORMAL)
		@Description("Testcase description: Verfiy sacnning of Fifth barcode in Sales Invoice - Estimate for promotion122 ")
		@Epic("EP007")
		@Feature("Feature 6: Fifth  barcode for promotion122")
		@Story("Fifth barcode for promotion122")
		@Step("Verify scanning of Fifth barcode for promotion122")
		public  void barcode5_promotion122() throws InterruptedException, IOException
		{
			//code to check validation of enough stock.
			Object [][] arr1=sc.myTest1();
			driver.findElement(By.xpath("//input[@name='scanBarcode']")).sendKeys((String) arr1[9][0]);
			driver.findElement(By.xpath("//input[@name='scanBarcode']")).click();
			Thread.sleep(3000);
		
			driver.findElement(By.xpath("//button[@id='btnDone']")).click();

			Thread.sleep(2000);
			scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("E:\\MUZIRIS_ERP\\Promotion\\Promtion122\\Sales_Invoice-Estimate_Barcode5_promotion122.png"));

		}
		

		@Test(priority = 7, description = "Verifying sacnning of Sixth barcode test for promotion122")
		@Severity(SeverityLevel.NORMAL)
		@Description("Testcase description: Verfiy sacnning of Sixth barcode in Sales Invoice - Estimate for promotion122 ")
		@Epic("EP007")
		@Feature("Feature 7: Sixth  barcode for promotion122")
		@Story("Sixth barcode for promotion122")
		@Step("Verify scanning of Sixth barcode for promotion122")
		public  void barcode6_promotion122() throws InterruptedException, IOException
		{
			//code to check validation of enough stock.

			driver.findElement(By.xpath("//input[@name='scanBarcode']")).sendKeys("171909759");
			driver.findElement(By.xpath("//input[@name='scanBarcode']")).click();
			Thread.sleep(3000);
		
			driver.findElement(By.xpath("//button[@id='btnDone']")).click();

			Thread.sleep(2000);
			scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("E:\\MUZIRIS_ERP\\Promotion\\Promtion122\\Sales_Invoice-Estimate_Barcode6_promotion122.png"));

		}
		
		@Test(priority = 8, description = "Verifying sacnning of Seventh barcode test for promotion122")
		@Severity(SeverityLevel.NORMAL)
		@Description("Testcase description: Verfiy sacnning of Seventh barcode in Sales Invoice - Estimate for promotion122 ")
		@Epic("EP007")
		@Feature("Feature 8: Seventh barcode for promotion122")
		@Story("Seventh barcode for promotion122")
		@Step("Verify scanning of Seventh barcode for promotion122")
		public  void barcode7_promotion122() throws InterruptedException, IOException
		{
			//code to check validation of enough stock.
			Object [][] arr1=sc.myTest1();
			driver.findElement(By.xpath("//input[@name='scanBarcode']")).sendKeys((String) arr1[10][0]);
			//driver.findElement(By.xpath("//input[@name='scanBarcode']")).sendKeys("172210801");
			driver.findElement(By.xpath("//input[@name='scanBarcode']")).click();
			Thread.sleep(3000);
		
			driver.findElement(By.xpath("//button[@id='btnDone']")).click();

			Thread.sleep(2000);
			scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("E:\\MUZIRIS_ERP\\Promotion\\Promtion122\\Sales_Invoice-Estimate_Barcode7_promotion122.png"));

		}




		@Test(priority = 9, description = "Verifying all barcodes Discount")
		@Severity(SeverityLevel.NORMAL)
		@Description("Testcase description: Verfiy all barcodes Discount in Sales Invoice - Estimate ")
		@Epic("EP007")
		@Feature("Feature 9: All barcodes Discount")
		@Story("Story:All barcodes Discount")
		@Step("Verifying all barcodes Discount")
		public  void promotion122_Discount() throws InterruptedException, IOException
		{

			driver.findElement(By.id("btnGenDiscount")).sendKeys(Keys.RETURN);

			handlewindow3 = (String) driver.getWindowHandles().toArray()[1];
			driver.switchTo().window(handlewindow3);
			Thread.sleep(5000);

			new Select(driver.findElement(By.name("genDisc_additionalDisType"))).selectByVisibleText("Damage");
			driver.findElement(By.name("genDisc_additionalDisType")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='txtGenDisc_additionalDisRate']")).click();
			driver.findElement(By.xpath("//input[@id='txtGenDisc_additionalDisRate']")).sendKeys("11");
			Thread.sleep(3000);


			new Select(driver.findElement(By.name("genDisc_additionalApprovedBy"))).selectByVisibleText("ANIL KUMAR C.S");
			driver.findElement(By.name("genDisc_additionalApprovedBy")).click();
			Thread.sleep(4000);
			driver.findElement(By.xpath("//button[@id='btnGenDisc_ApplyAndClose']")).click();
			Thread.sleep(3000);
			scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("E:\\MUZIRIS_ERP\\Promotion\\Promtion122\\Sales_Invoice-Estimate_Allbarcodes_discount122.png"));


		}


		@Test(priority = 10, description = "Verifying whether promotion122 can be applied for the selected barcodes")
		@Severity(SeverityLevel.NORMAL)
		@Description("Testcase description: Verfiy all barcodes Discount in Sales Invoice - Estimate ")
		@Epic("EP007")
		@Feature("Feature 10: All barcodes promotion")
		@Story("Story:all barcodes promotion")
		@Step("Verifying promotion122")
		public  void promotion122() throws InterruptedException, IOException
		{
			driver.findElement(By.xpath("//button[@id='btnPromotions']")).sendKeys(Keys.RETURN);

			handlewindow4 = (String) driver.getWindowHandles().toArray()[1];
			driver.switchTo().window(handlewindow4);
			Thread.sleep(5000);
			
			
             //Should not apply Promotion automatically if Auto Apply is set as 'N'  in the parameter
			
			WebElement radioBtn1 = driver.findElement(By.xpath("//input[@id='chkPromotions_Auto']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", radioBtn1);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@id='btnPromotions_ApplyPromotion']")).click();
			
			String gettext =  driver.findElement(By.xpath("//div[@id='notification']/div[2]/h6")).getText();
			System.out.println(gettext);
			Thread.sleep(5000);
			driver.findElement(By.xpath("//button[@class='close-btn']")).click();
			Thread.sleep(3000);
			WebElement radioBtn2 = driver.findElement(By.xpath("//input[@id='chkPromotions_Auto']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].checked = false;", radioBtn2);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@name='promotions_PromoCode']")).sendKeys("122");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@id='btnPromotions_ApplyPromotion']")).click();
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//button[@id='btnPromotions_CancelPromotion']")).click();
			scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("E:\\MUZIRIS_ERP\\Promotion\\Promtion122\\Sales_Invoice-Estimate_promotion122failed.png"));
			
			driver.findElement(By.xpath("//button[@id='btnPromotions_Close']")).click();
			
			
			//Promotion only if the Additional Discount is less 5
			
			
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
			
			driver.findElement(By.xpath("//input[@name='promotions_PromoCode']")).sendKeys("122");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@id='btnPromotions_ApplyPromotion']")).click();
			
			scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("E:\\MUZIRIS_ERP\\Promotion\\Promtion122\\Sales_Invoice-Estimate_promotion122.png"));

			driver.findElement(By.xpath("//button[@id='btnPromotions_Close']")).click();
			

			
			
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





package TestRunner;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import BasePackage.BaseClass;
import PageObjects.homePage;

public class HomePageTest extends BaseClass {
	
	static homePage hm;
	static ExtentReports report; 
	static ExtentTest test;
	
	@BeforeTest
	public void setUp() throws MalformedURLException {
		setup();//initalise browser
		System.out.println("browser opened---PASSED");
	}
	
	@AfterTest
	public  void tearDown() {
		//driver.close();
		System.out.println("browser CLOSED---PASSED");
	}

	@Test(priority=0)
	public void clickAll()
	{
		homePage hm=new homePage();
		//clicking on the all hamburger sign
		hm.all().click();
		//implicit wait 
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		System.out.println("click on ALL ---PASSED");		
	}
	@Test(priority=1)
	public void clickOnElectronic() throws InterruptedException
	{
		homePage hm = new homePage();
		//click on the electronics opton
		Thread.sleep(3000);
		hm.electronics().click();
		System.out.println("click on ELECTRONICS ---PASSED");		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);		
	}
	
	@Test(priority=2)
	public void selectTV() throws InterruptedException
	{
		//selecting tv and other appliances option
		homePage hm = new homePage();
		//WebDriverWait wait = new WebDriverWait(driver, null);
		//wait.until(ExpectedConditions.visibilityOf(hm.tv()));
		
		Thread.sleep(2000);
		hm.tv().click();
		System.out.println("click on TV ---PASSED");	
		//Wait wait= new WebDriverWait(driver);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	@Test(priority=3)
	public void Televisions()
	{
		//select tv from other options
		homePage hm = new homePage();
		hm.Televisions().click();
		System.out.println("click on Televisions ---PASSED");		
	}
	
	@Test(priority=4)
	public void samsung()
	{
		//check the checkbox for SAMSUNG brand 
		homePage hm = new homePage();
		hm.samsung().click();
		System.out.println("click on samsung ---PASSED");		
	}
	@Test(priority=5)
	public void sort()
	{
		//click on the sorting menu 
		homePage hm = new homePage();
		hm.sort().click();
		System.out.println("click on sort ---PASSED");		
	}
	@Test(priority=6)
	public void highToLow()
	{
		//sort by price : high to low
		homePage hm = new homePage();
		hm.highToLow().click();
		System.out.println("sort Price ---PASSED");		
	}
	@Test(priority=7)
	public void selectSecondItem()
	{
		//select the second last highest price item from the list 
		homePage hm = new homePage();
		hm.secondItem().click();
		System.out.println("select second highest product ---PASSED");		
	}
	@Test(priority=8)
	public void getBack()
	{
		//navigating to the previous page 
		driver.navigate().back();
	}
	
	@Test(priority=9)
	public void scrolldown()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,250)", "");
		System.out.println("scroll down ---PASSED");	
	}
	
	
	@BeforeClass
	public void openTest()
	{
		//extent report 
		report = new ExtentReports("C:\\Users\\SUKANNYA GHOSH\\eclipse-workspace\\amazon\\Reports\\login.html", true);
		test = report.startTest("amazon test report");		
	}
	
	@AfterClass 
	public  void closeTest()
	{
	  report.endTest(test);
	  report.flush();		
	}
}

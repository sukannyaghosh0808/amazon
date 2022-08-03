package TestRunner;

import java.util.concurrent.TimeUnit;

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
	public void setUp() {
		setup();
		System.out.println("browser opened---PASSED");
	}
	
	@AfterTest
	public static void tearDown() {
		//driver.close();
		System.out.println("browser CLOSED---PASSED");
	}

	@Test(priority=0)
	public void clickAll()
	{
		homePage hm=new homePage();
		hm.all().click();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		System.out.println("click on ALL ---PASSED");		
	}
	@Test(priority=1)
	public void clickOnElectronic()
	{
		homePage hm = new homePage();
		hm.electronics().click();
		System.out.println("click on ELECTRONICS ---PASSED");		
	}
	@Test(priority=2)
	public void selectTV()
	{
		homePage hm = new homePage();
		hm.tv().click();
		System.out.println("click on TV ---PASSED");		
	}
	@Test(priority=3)
	public void Televisions()
	{
		homePage hm = new homePage();
		hm.Televisions().click();
		System.out.println("click on Televisions ---PASSED");		
	}
	@Test(priority=4)
	public void samsung()
	{
		homePage hm = new homePage();
		hm.samsung().click();
		System.out.println("click on samsung ---PASSED");		
	}
	@Test(priority=5)
	public void sort()
	{
		homePage hm = new homePage();
		hm.sort().click();
		System.out.println("click on sort ---PASSED");		
	}
	@Test(priority=6)
	public void highToLow()
	{
		homePage hm = new homePage();
		hm.highToLow().click();
		System.out.println("sort Price ---PASSED");		
	}
	@Test(priority=7)
	public void selectSecondItem()
	{
		homePage hm = new homePage();
		hm.secondItem().click();
		System.out.println("select second highest product ---PASSED");		
	}
	@Test(priority=8)
	public void getBack()
	{
		driver.navigate().back();
	}
	@BeforeClass
	public void openTest()
	{
		report = new ExtentReports("C:\\Users\\SUKANNYA GHOSH\\eclipse-workspace\\amazon\\Reports\\login.html", true);
		test = report.startTest("amazon test report");		
	}
	
	@AfterClass 
	public static void closeTest()
	{
	  report.endTest(test);
	  report.flush();		
	}
}

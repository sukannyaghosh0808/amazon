package TestRunner;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
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
import com.relevantcodes.extentreports.LogStatus;

import BasePackage.BaseClass;
import PageObjects.homePage;

public class HomePageTest extends BaseClass {
	
	static homePage hm;
	static ExtentReports report; 
	static ExtentTest test;
	static Set<String> handles;
	
	@BeforeTest
	public void setUp() throws MalformedURLException {
		setup();//initialise browser
		System.out.println("browser opened");
	}
	
	@AfterTest
	public  void tearDown() {
		driver.quit();
		System.out.println("browser CLOSED");
	}

	@Test(priority=0)
	public void clickAll()
	{
		homePage hm=new homePage();
		//clicking on the all hamburger sign
		hm.all().click();
		//implicit wait 
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			
	}
	@Test(priority=1)
	public void clickOnElectronic() throws InterruptedException
	{
		homePage hm = new homePage();
		//click on the electronics opton
		Thread.sleep(3000);
		hm.electronics().click();			
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);		
	}
	

	@Test(priority=2)
	public void Televisions()
	{
		//select tv from other options
		homePage hm = new homePage();
		hm.Televisions().click();
	}
	@Test(priority=3)
	public void scrollTillBrands()
	{
		homePage hm = new homePage();
		WebElement brand = hm.brands();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",brand);	
	}
	
	@Test(priority=4)
	public void samsung()
	{
		//check the checkbox for SAMSUNG brand 
		homePage hm = new homePage();
		hm.samsung().click();		
	}
	
	@Test(priority=5)
	public void sort()
	{
		//click on the sorting menu 
		homePage hm = new homePage();
		hm.sort().click();	
	}
	
	@Test(priority=6)
	public void highToLow()
	{
		//sort by price : high to low
		homePage hm = new homePage();
		hm.highToLow().click();	
	}
	
	@Test(priority=7)
	public void selectSecondItem() throws InterruptedException
	{
		//select the second last highest price item from the list 
		homePage hm = new homePage();
		hm.secondItem().click();		
		handles=driver.getWindowHandles();
		Thread.sleep(5000);
	}
	
	@Test(priority=8)
	public void scrolldown()
	{
		//Getting WindowHandles
		homePage hm=new homePage();
		WebElement aboutThisItem=hm.aboutThisItem();
		
		String parent=driver.getWindowHandle(); //getting current window handle
		Set<String>s=driver.getWindowHandles(); //getting all handles
		Iterator<String> I1= s.iterator();

		while(I1.hasNext())
		{

		String child_window=I1.next();
		if(!parent.equals(child_window))
		{
		       driver.switchTo().window(child_window);
				//using js to scroll down vertically 							
				JavascriptExecutor js = (JavascriptExecutor)driver;				
				js.executeScript("arguments[0].scrollIntoView(true);",aboutThisItem);	//scroll till element is visible
			}
		}
		   Boolean flag = hm.aboutThisItem().isDisplayed();
			Assert.assertTrue(flag);
			if(flag==true)
			{
				test.log(LogStatus.PASS, "About this item section is present");
			}
	}
	
	
	@BeforeClass
	public void openTest()
	{
		//extent report create
		report = new ExtentReports("C:\\Users\\SUKANNYA GHOSH\\eclipse-workspace\\amazon\\Reports\\amazon.html", true);
		test = report.startTest("amazon test report");		
	}
	
	@AfterClass 
	public  void closeTest()
	{
		//end report
	  report.endTest(test);
	  report.flush();		
	}
}

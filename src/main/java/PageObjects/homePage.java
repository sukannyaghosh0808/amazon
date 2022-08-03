package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePackage.BaseClass;

public class homePage extends BaseClass{
	
	@FindBy(xpath="//a[@id='nav-hamburger-menu']")
	WebElement all;
	@FindBy(xpath="//a[@data-menu-id='5']")
	WebElement electronics;
	@FindBy(xpath="//ul[@data-menu-id='5']/li[15]")
	WebElement tv;
	@FindBy(xpath="//span[text()='Televisions']")
	WebElement Televisions;
	@FindBy(xpath="//li[@id='p_89/SAMSUNG']/span/a/div/label/i")
	WebElement samsung;
	@FindBy(xpath="//*[@id='a-autoid-2']")
	WebElement sort;
	@FindBy(xpath="//a[text()='Price: High to Low']")
	WebElement highToLow;
	@FindBy(xpath="//div[@data-index='2']")
	WebElement secondItem;
	
	public WebElement secondItem()
	{
		return secondItem;
	}
	
	public WebElement highToLow()
	{
		return highToLow;
	}
	
	public WebElement all()
	{
		return all;
	}
	public WebElement sort()
	{
		return sort;
	}
	public WebElement electronics()
	{
		return electronics;
	}
	public WebElement tv()
	{
		return tv;
	}
	public WebElement Televisions()
	{
		return Televisions;
	}
	public WebElement samsung()
	{
		return samsung;
	}
	
	public homePage()
	{
		PageFactory.initElements(driver, this);
	}

}

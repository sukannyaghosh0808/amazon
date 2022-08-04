package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePackage.BaseClass;

public class homePage extends BaseClass{
	
	@FindBy(xpath="//a[@id='nav-hamburger-menu']")
	WebElement all;
	@FindBy(xpath="//a[@data-menu-id='9']")
	WebElement electronics;
	@FindBy(xpath="//ul[@data-menu-id='9']/li[3]/a[text()='Televisions']")
	WebElement Televisions;
	@FindBy(xpath="//*[text()='Brands']")
	WebElement brands;
	@FindBy(xpath="//*[@id=\"s-refinements\"]/div[20]/ul/li[3]/span/a/span")
	WebElement samsung;
	@FindBy(xpath="//*[@id='a-autoid-0-announce']")
	WebElement sort;
	@FindBy(xpath="//a[text()='Price: High to Low']")
	WebElement highToLow;
	@FindBy(xpath="//div[@data-index='2']")
	WebElement secondItem;
	@FindBy(xpath="//*[text()=' About this item ']")
	WebElement aboutThisItem;
	
	public WebElement aboutThisItem()
	{
		return aboutThisItem;
	}
	public WebElement secondItem()
	{
		return secondItem;
	}
	public WebElement brands()
	{
		return brands;
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

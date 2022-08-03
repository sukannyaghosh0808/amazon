package BasePackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;



public class BaseClass {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public BaseClass() 
	{
		prop = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("C:\\Users\\Sukannya Ghosh\\eclipse-workspace\\amazon\\config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	
		public static void setup() throws MalformedURLException 
		{
		String browserName = prop.getProperty("browser");
		String platform=prop.getProperty("platform");
		
		if(browserName.equalsIgnoreCase("chrome") && platform.equalsIgnoreCase("win10"))
		{
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\SUKANNYA GHOSH\\eclipse-workspace\\amazon\\Drivers\\chromedriver.exe");
			//driver=new ChromeDriver();
			
			//opening browser in windows10 chrome browser
		DesiredCapabilities cap= new DesiredCapabilities();
		cap.setBrowserName("chrome"); //setting up browser 
		cap.setPlatform(Platform.WIN10); //setting up platform
		driver = new RemoteWebDriver(new URL("http://192.168.1.102:4444/wd/hub"),cap);
		}
		else if(browserName.equalsIgnoreCase("chrome") && platform.equalsIgnoreCase("mac"))
		{
			//opening browser in mac chrome browser
			DesiredCapabilities cap= new DesiredCapabilities();
			cap.setBrowserName("chrome"); //setting up browser 
			cap.setPlatform(Platform.MAC); //setting up platform
			driver = new RemoteWebDriver(new URL("http://192.168.1.102:4444/wd/hub"),cap);
		}
		
		
		driver.get(prop.getProperty("url"));//opening browser
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
	}
	}
	

	



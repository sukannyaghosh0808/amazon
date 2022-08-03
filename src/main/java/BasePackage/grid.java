package BasePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class grid {
	
	public static WebDriver driver;
    public static String nodeUrl;
    
	public void gridtest()
	{
		nodeUrl="http://192.168.1.102:4377";
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setCapability("browserVersion", "100");
		chromeOptions.setCapability("platformName", "Windows");
		// Showing a test name instead of the session id in the Grid UI
		chromeOptions.setCapability("se:name", "My simple test"); 
		// Other type of metadata can be seen in the Grid UI by clicking on the 
		// session info or via GraphQL
		chromeOptions.setCapability("se:sampleMetadata", "Sample metadata value"); 
	}
}

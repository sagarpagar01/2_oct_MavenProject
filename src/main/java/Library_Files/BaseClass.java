package Library_Files;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

	  public WebDriver driver;
	
	public void InitializeBrowser()
	{
		
		// System.setProperty("webdriver.chrome.driver", "C:\\Users\\sagar pagar\\eclipse-workspace\\02_Oct_JavaBasics_Mavenframework\\Browsers\\chromedriver.exe");
		
		 driver = new ChromeDriver();
		
		driver.get("https://demo.guru99.com/insurance/v1/index.php");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	}
	
	
	
}

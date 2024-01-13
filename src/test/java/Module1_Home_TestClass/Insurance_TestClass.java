package Module1_Home_TestClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Library_Files.BaseClass;
import Library_Files.UtilityClass;
import Modole1_Home.Broker_Page;
import Modole1_Home.Insurance_HomePage;

public class Insurance_TestClass extends BaseClass
{
	
	//  public WebDriver driver;
	// InitializeBrowser()
	
	Insurance_HomePage Loginpage;
	Broker_Page Brokerpage;
	
	int TestCaseID;
	
	@BeforeClass
	public void OpenBrowser()
	{
		InitializeBrowser();
		
		 Loginpage = new Insurance_HomePage(driver);
		
		 Brokerpage = new Broker_Page(driver);
		
	}
	
	@BeforeMethod
	public void LoginToApp() throws IOException, InterruptedException
	{
	
		Thread.sleep(2000);
		
		Loginpage.EnterEmail(UtilityClass.getDataFromPropFile("EM"));
		
		Thread.sleep(2000);
		
		Loginpage.Enterpassword(UtilityClass.getDataFromPropFile("psw"));
		
		
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		
		Loginpage.ClickLogInbtn();
		
		Thread.sleep(2000);
		
		
	}
	
	
	@Test(priority=1)
	public void verifyEmail() throws EncryptedDocumentException, IOException, InterruptedException
	{
		TestCaseID = 1;
		
		  String ActualEmail = Brokerpage.getEmail();
		  
		  driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		  
		  String ExpectedEmail = UtilityClass.getDataFromExcelSheet(2, 0);
		  
		
		  Assert.assertEquals(ActualEmail,ExpectedEmail );
		
	}
	
	
	@Test(priority = 2)
	public void VerifyTitle() throws EncryptedDocumentException, IOException
	{
       // Assert.fail();
		
		TestCaseID = 2;
		
	 String ActualTitle = driver.getTitle();
	 
	 System.out.println("Actual Title is = "+ ActualTitle);
	 
	 String ExpectedTitle = UtilityClass.getDataFromExcelSheet(3, 0);
		
	 Assert.assertEquals(ActualTitle, ExpectedTitle);
	 
	}
	
	
	@AfterMethod
	public void LogOutToApp(ITestResult Result) throws IOException, InterruptedException
	{
		if(Result.getStatus()==ITestResult.FAILURE)
		{
			UtilityClass.captureScreenshot(driver, TestCaseID);
		}
		
		
		Thread.sleep(2000);
		
		Brokerpage.ClickLogOutBtn();
		
	}
	
	@AfterClass
	public void CloseBrowser() throws InterruptedException
	{
		Thread.sleep(2000);
		
		driver.close();
		
	}
	
	// Git Repository  - 2_oct_MavenProject

	// https://github.com/sagarpagar01/2_oct_MavenProject.git
	

}

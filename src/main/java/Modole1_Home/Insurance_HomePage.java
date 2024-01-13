package Modole1_Home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Insurance_HomePage
{
	
	// data members /variables will be declared globally with access level private and @FindBy annotation 
	
	  @FindBy(xpath="//input[@id='email']")    private WebElement Email;
	
	  @FindBy(xpath="//input[@id='password']")   private WebElement Password;
	
	  @FindBy(xpath="//input[@type='submit']")   private WebElement LoginBtn;
	  
  // Initialise within constructor with access level public and using pagefactory

	  public Insurance_HomePage(WebDriver driver)
	  {
		  PageFactory.initElements(driver, this);
	  }
	  
	// Utilise within method with access level public 
	  
	  public void EnterEmail(String email)
	  {
		  Email.sendKeys(email);
	  }

	  public void Enterpassword(String pass)
	  {
		  Password.sendKeys(pass);
	  }
	  
	  public void ClickLogInbtn( )
	  {
		  LoginBtn.click();
	  }
	  
}

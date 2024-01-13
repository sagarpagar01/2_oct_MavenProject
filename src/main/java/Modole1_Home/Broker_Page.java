package Modole1_Home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Broker_Page 
{
	 @FindBy(xpath="//h4[text()='saradeg42@gmail.com']")    private WebElement SignedInAs;
		
	  @FindBy(xpath="//input[@type='submit']")   private WebElement LogOutbtn;
	
	
	public Broker_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getEmail( )
	  {
		 String   ActualEmail =  SignedInAs.getText();
		   
		   return ActualEmail;
	  }
	
   public void ClickLogOutBtn()
	  {
		LogOutbtn.click();
	  }
	
	
	
}

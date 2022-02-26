package PSLPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.baseClass;

public class LoginPage  
{
	public WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="txtUsername")
	WebElement username;
	
	
	@FindBy(id="txtPassword")
	WebElement password;

	
	@FindBy(xpath="//*[@value='LOGIN']")
	WebElement submit;
	
	
	public WebElement enterUsername()
	{
		return username;
	}
	
	public WebElement enterPassword()
	{
		return password;
	}
	
	public WebElement clickSubmit()
	{
		return submit;
	}
	
	
}

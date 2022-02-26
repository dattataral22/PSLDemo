package PSLPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class page2Dashboard 
{ 
	public WebDriver driver;

	public page2Dashboard(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Admin")
	WebElement admintab;
	
	@FindBy(id="searchSystemUser_userName")
	WebElement username;
	
	@FindBy(id="searchSystemUser_userType")
	WebElement selectuser;
	
	@FindBy(xpath="(//*[@type=\"text\"])[2]")
	WebElement empName;
	
	@FindBy(id="searchSystemUser_status")
	WebElement selectStatus;
	
	
	@FindBy(id="searchBtn")
	WebElement serachbtn;
	
	@FindBy(xpath="//img[@alt='OrangeHRM']")
	WebElement imageverify;
	
	public WebElement ClickAdmin()
	{
		return admintab;
	}
	
	public WebElement enterName()
	{
		return username;
	}
	
	public Select selectuserType()
	{
		return new Select(selectuser);
		
	}
	
	public WebElement enterempName()
	{
		return empName;
	}
	
	public Select selectStatus()
	{
		return new Select(selectStatus);
		
	}
	

	public WebElement clickbtn() {
		return serachbtn;
	}
	

	
	
	public WebElement imageTest()
	{
		
		return imageverify;
	}
}

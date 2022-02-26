package PSL;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PSLPageObject.LoginPage;
import PSLPageObject.page2Dashboard;
import Utility.baseClass;

public class LoginpageTest extends baseClass
{
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(baseClass.class.getName());
	
	@BeforeTest
	public void startBrowser1() throws IOException 
	{
		driver = startBrowser();

	}

	@Test(dataProvider = "getData")
	public void HRMTest(String username1,String password1)
 {
		LoginPage psl = new LoginPage(driver);
		psl.enterUsername().sendKeys(username1);
		psl.enterPassword().sendKeys(password1);
		psl.clickSubmit().click();
		log.info("credential enter successfully");
		log.info("successfully tested");
		System.out.println("login page test");
		
		page2Dashboard ps2 = new page2Dashboard(driver);
		ps2.ClickAdmin().click();
		ps2.enterName().sendKeys("datta");
		ps2.selectuserType().selectByValue("2");
		ps2.enterempName().sendKeys("Taral");
		ps2.selectStatus().selectByVisibleText("Enabled");
		ps2.clickbtn().click();
		log.info("user detailed enter ");
		log.info("datta taral diididi");
System.out.println("aurangabad is largest city");
		
	}

	@AfterTest
	public void tearDown() {
		driver.close();
		log.info("driver closed successfully");
		log.info("suraj edited");
System.out.println("pune is the city");
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][2];
		data[0][0] = "Admin";
		data[0][1] = "adm45in123";

		data[1][0] = "Admin";
		data[1][1] = "admin123";

		return data;

	}
}

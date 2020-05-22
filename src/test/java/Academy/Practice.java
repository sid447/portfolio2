package Academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.UserPage;
import resources.base;

public class Practice extends base {

	public WebDriver driver;


	@BeforeTest
	public void Initialize() throws IOException {
		driver = initializeDriver();
	}

	@Test

	public void signout() throws InterruptedException {
		driver.get("https://sso.teachable.com/secure/9521/users/sign_in?clean_login=true&reset_purchase_session=1");

		LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys("aab@test.com");
		lp.getPassword().sendKeys("test123");
		lp.getLogin().click();
	

		
		UserPage up=new UserPage(driver);
		up.getUserName().click();

		Thread.sleep(5000);
		System.out.println(up.getSignOut().getText());
		up.getSignOut().click();

	}

	@AfterTest
	public void teardown() {

		driver.close();

	}

}

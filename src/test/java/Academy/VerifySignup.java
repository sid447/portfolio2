package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.SignupPage;
import pageObjects.UserPage;
import resources.base;

public class VerifySignup extends base {

	public WebDriver driver;

	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void Initialize() throws IOException {
		driver = initializeDriver();
	}

	@Test

	public void verifySignup() throws InterruptedException {
		driver.get(prop.getProperty("uat"));
		String useremail = "testusera@test.com";
		String password = "test123";
		String username = "Testusera";

		// Create new user

		SignupPage spa = new SignupPage(driver);
		spa.getSignup();
		spa.getFullName().sendKeys(username);
		spa.getEmail().sendKeys(useremail);
		spa.getPassword().sendKeys(password);
		spa.getConfPass().sendKeys(password);
		spa.getPromoEmails().click();
		spa.getAgreement().click();
		spa.getSignupClick().click();

		log.info("Signed up successfully.");

		// Verify that the user is created and Sign out of the application

		UserPage up = new UserPage(driver);
		up.getUserName().click();
		Thread.sleep(3000);
		up.getSignOut().click();


		// Verify successful sign in with created user.

		LandingPage lap = new LandingPage(driver);
		lap.getLogin();

		LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys(useremail);
		lp.getPassword().sendKeys(password);
		lp.getLogin().click();

		Assert.assertEquals(up.getUserName().getText(), username);
		log.info("Successfully validated created user is able to sign in");

	}

	@AfterTest
	public void teardown() {

		driver.close();

	}

}

package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignupPage {

	public WebDriver driver;

	By signup = By.cssSelector("a[class='theme-btn register-btn']");
	By fullname = By.id("user_name");
	By email = By.id("user_email");
	By password = By.id("user_password");
	By confpass = By.id("user_password_confirmation");
	By promoemails = By.id("user_unsubscribe_from_marketing_emails");
	By agreement = By.id("user_agreed_to_terms");
	By signupclick = By.name("commit");

	public SignupPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public SignupPage getSignup() {

		driver.findElement(signup).click();
		SignupPage sp = new SignupPage(driver);
		return sp;
	}

	public WebElement getFullName() {
		return driver.findElement(fullname);
	}

	public WebElement getEmail() {
		return driver.findElement(email);
	}

	public WebElement getPassword() {
		return driver.findElement(password);
	}

	public WebElement getConfPass() {
		return driver.findElement(confpass);
	}

	public WebElement getPromoEmails() {
		return driver.findElement(promoemails);
	}

	public WebElement getAgreement() {
		return driver.findElement(agreement);
	}

	public WebElement getSignupClick() {
		return driver.findElement(signupclick);
	}


}



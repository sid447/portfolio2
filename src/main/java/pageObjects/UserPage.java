package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class UserPage {
	
	public WebDriver driver;
	
	By username = By.cssSelector("span[class='navbar-current-user']");
	By signout = By.cssSelector("a[href='/sign_out']");
	
	public UserPage(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
	}

	public WebElement getUserName() {
		return driver.findElement(username);
	}

	public WebElement getSignOut() {


		return driver.findElement(signout);
	}


}

package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {

	public  WebDriver driver;
	public Properties prop;
public WebDriver initializeDriver() throws IOException
{
	
 prop= new Properties();
	FileInputStream fis = new FileInputStream(
			"//Users//siddhi//mysandbox//STS//siddhi//portfolio2//src//main//java//resources//data.properties");

prop.load(fis);
String browserName=prop.getProperty("browser");
System.out.println(browserName);

if(browserName.equals("chrome"))
{
	System.setProperty("webdriver.chrome.driver", "//Users//siddhi//Downloads//chromedriver");
	driver= new ChromeDriver();
		//execute in chrome driver
	
}
else if (browserName.equals("firefox"))
{

	System.setProperty("webdriver.gecko.driver", "//Users//siddhi//Downloads//geckodriver");
	 driver= new FirefoxDriver();
	//firefox code
}
else if (browserName.equals("IE"))
{
	System.setProperty("webdriver.IE.driver", "//Users//siddhi//Downloads//geckodriver");
	driver = new FirefoxDriver();
}

driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
return driver;


}


public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
{
	TakesScreenshot ts=(TakesScreenshot) driver;
	File source =ts.getScreenshotAs(OutputType.FILE);
	String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
	FileUtils.copyFile(source,new File(destinationFile));
	return destinationFile;


}

}

package CommonFunLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.PropertyFileUtil;

public class FunctionLibrary {

	public static WebDriver driver;
	//method for launching browser
	public static WebDriver startBrowser() throws Throwable
	{
		if(PropertyFileUtil.getValueForKey("Browser").equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","D:\\Selenium_FramWorks\\ERP_Accounting\\CommonDrivers");
			driver=new ChromeDriver();
		}
		else if(PropertyFileUtil.getValueForKey("Browser").equalsIgnoreCase("Firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(PropertyFileUtil.getValueForKey("Browser").equalsIgnoreCase("ie"))
		{
			driver= new InternetExplorerDriver();
		}
		else
		{
			System.out.println("Browser is not matching");
		}
		return driver;
	}
	//Method to open the Application (Common)
	public static void openApplication(WebDriver driver) throws Throwable
	{
		driver.get(PropertyFileUtil.getValueForKey("Url"));
		driver.manage().window().maximize();
	}
	public static void waitForElement(WebDriver driver, String locatortype, String locatorvalue,String waittime)
	{
		WebDriverWait mywait= new WebDriverWait(driver, Integer.parseInt(waittime));
		if(locatortype.equalsIgnoreCase("id"))
		{
			mywait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorvalue)));
		}
		else if(locatortype.equalsIgnoreCase("name"))
			{
			mywait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorvalue)));
			}
		else if(locatortype.equalsIgnoreCase("xpath"))
		{

			mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorvalue)));
			
		}
		else
		{
			System.out.println("unable to excute wait for element");
		}
	}
	 public static void typeAction(WebDriver  driver, String locatortype, String locatorvalue, String testdata)
	 {
		 if(locatortype.equalsIgnoreCase("id"))
		 {
			 driver.findElement(By.id(locatorvalue)).clear();
			 driver.findElement(By.id(locatorvalue)).sendKeys(testdata);
		 }
		 else if(locatortype.equalsIgnoreCase("name"))
			{
			 driver.findElement(By.name(locatorvalue)).clear();
			 driver.findElement(By.name(locatorvalue)).sendKeys(testdata);
			}
		 else if(locatortype.equalsIgnoreCase("xpath"))
		 {
			 driver.findElement(By.xpath(locatorvalue)).clear();
			 driver.findElement(By.xpath(locatorvalue)).sendKeys(testdata);
		 }
		 else
		 {
			 System.out.println("unable to excute typeaction method");
		 }
		 
		 }
	 
	 //method for Click action
	 public static void clickAction(WebDriver driver, String locatortype,String locatorvalue)
	 {
		 if(locatortype.equalsIgnoreCase("id"))
		 {
			 driver.findElement(By.id(locatortype)).click();
		 }
		 else if(locatortype.equalsIgnoreCase("name"))
		{
			 driver.findElement(By.name(locatortype)).click();
		}
		 else if(locatortype.equalsIgnoreCase("xpath"))
		 {
			 driver.findElement(By.xpath(locatortype)).click();
		 }
		 else
		 {
			 System.out.println("Unable to perform click action");
		 }
	 }
	 
	 public static void closeBrowser(WebDriver driver)
	 {
		 driver.close();
	 }
}

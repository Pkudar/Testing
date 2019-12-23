package commonFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonFunctions {
	
	static WebDriver driver;

public static void waitForElement(WebDriver driver,String locatortype,String locatorvalue,String waittitme) throws Exception{
		WebDriverWait mywait=new WebDriverWait(driver, Integer.parseInt(waittitme));
		
		if(locatortype.equalsIgnoreCase("id")){
			mywait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorvalue)));
		}
		else if(locatortype.equalsIgnoreCase("name")){
			mywait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorvalue)));
		}else if(locatortype.equalsIgnoreCase("xpath"))
		{
			mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorvalue)));
		}
		else
		{		System.out.println("exception caught");
				throw new Exception();
		}	
		
	}
	
	
	public static void typeAction(WebDriver driver,String locatortype,String locatorvalue,String testdata){
		if(locatortype.equalsIgnoreCase("id")){
			driver.findElement(By.id(locatorvalue)).clear();
			driver.findElement(By.id(locatorvalue)).sendKeys(testdata);
		}else if(locatortype.equalsIgnoreCase("xpath")){
			driver.findElement(By.xpath(locatorvalue)).clear();
			driver.findElement(By.xpath(locatorvalue)).sendKeys(testdata);
		}else if(locatortype.equalsIgnoreCase("name"))
		{
			driver.findElement(By.name(locatorvalue)).clear();
			driver.findElement(By.name(locatorvalue)).sendKeys(testdata);
		}else{
			System.out.println("Locator not matching for typeAction method");
		}
		
	}
	
	
	public static void clickAction(WebDriver driver,String locatortype,String locatorvalue){
		if(locatortype.equalsIgnoreCase("id")){
			driver.findElement(By.id(locatorvalue)).click();
		}else if(locatortype.equalsIgnoreCase("xpath")){
			driver.findElement(By.xpath(locatorvalue)).click();
		}
		else if(locatortype.equalsIgnoreCase("name")){
			driver.findElement(By.name(locatorvalue)).click();
		}
	}
	
	
	public static void closeBrowser(WebDriver driver)
	{
	driver.close();
	}
	
	
	public static WebDriver startBrowser(String browser) throws Exception{
		
		if(browser.equalsIgnoreCase("chrome")){
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\rangareddy.QEDGE\\Documents\\MyNewWorkspace\\StockAccounting_BDD2\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "./CommonJars/firefoxdriver.exe");
			 driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", "./CommonJars/Internetexplorerdriver.exe");
			driver=new InternetExplorerDriver();
		}
		else{
			System.out.println("Browser value not matching");
		}
	
		return driver;
				
	}
	
	
	public static void openApplication(WebDriver driver) throws Exception{
		System.out.println("came to openapplication");
		driver.get("http://webapp.qedge.com/login.php");
		driver.manage().window().maximize();	
	}

	
}

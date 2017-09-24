package com.hybridframework.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.zone.ZoneOffsetTransitionRule.TimeDefinition;
import java.util.Calendar;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;




public class TestBase {
	WebDriver driver; 
	Properties p1;
	File f1;
	FileInputStream file;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static ITestResult result;
	
	public void LaunchBrowser(){
	try {
		Reporter.log("launch browser");
		loadproperties();
		getBrowser(p1.getProperty("browser"));
		Reporter.log("browser launched");
	} 
	catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
	}
	
	}
	
	public void getBrowser(String browser){
		// If system is windows Machine then if block will be Executed
		if(System.getProperty("os.name").contains("window")){
			// if browser is firefox 
			if(browser.equalsIgnoreCase("firefox")){
				System.out.println(System.getProperty("user.dir"));
				driver=new FirefoxDriver();
			}
			// if browser is chrome
			else if(browser.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver", "H:\\workspace1\\talisma\\Drivers\\chromedriver.exe");
				driver=new ChromeDriver();
			}
			
			// if browser is Internet Explorer 
          else if(browser.equalsIgnoreCase("ie")){
        	  System.setProperty("webdriver.ie.driver", "H:\\workspace1\\talisma\\Drivers\\IEDriverServer.exe");
				driver=new InternetExplorerDriver();
			}
		}
		
	}
	
	public WebElement getLocator(String locator) throws Exception{
		System.out.println(locator);
		String[] split=locator.split(":");
		String locatorType=split[0];
		String locatorValue=split[1];
		System.out.println("locator Type :"+locatorType);
		System.out.println("locatortor value is "+locatorValue);
		if(locatorType.toLowerCase().equals("id"))
			return driver.findElement(By.id(locatorValue));
		
		else if(locatorType.toLowerCase().equals("name"))
			return driver.findElement(By.name(locatorValue));
		else if(locatorType.toLowerCase().equals("classname")
			 || (locatorType.toLowerCase().equals("class")))
			 return driver.findElement(By.className(locatorValue));
		else if(locatorType.toLowerCase().equals("tagname")
				 || (locatorType.toLowerCase().equals("tag")))
			 return driver.findElement(By.tagName(locatorValue));
		else if(locatorType.toLowerCase().equals("linktext")
				 || (locatorType.toLowerCase().equals("link")))
			 return driver.findElement(By.linkText(locatorValue));
		
		else if(locatorType.toLowerCase().equals("partiallinktext")
				 || (locatorType.toLowerCase().equals("partial")))
			 return driver.findElement(By.partialLinkText(locatorValue));
		
		else if(locatorType.toLowerCase().equals("cssselector")
				 || (locatorType.toLowerCase().equals("css")))
			 return driver.findElement(By.cssSelector(locatorValue));
		
		else if(locatorType.toLowerCase().equals("xpath"))
			 return driver.findElement(By.xpath(locatorValue));
		else 	
			throw new Exception("unknown error type "+locatorType +"");
	}
	
	
	public List <WebElement >getLocators(String locator) throws Exception{
		System.out.println(locator);
		String[] split=locator.split(":");
		String locatorType=split[0];
		String locatorValue=split[1];
		System.out.println("locator Type :"+locatorType);
		System.out.println("locator value is "+locatorValue);
		if(locatorType.toLowerCase().equals("id"))
			return driver.findElements(By.id(locatorValue));
		
		else if(locatorType.toLowerCase().equals("name"))
			return driver.findElements(By.name(locatorValue));
		else if(locatorType.toLowerCase().equals("classname")
			 || (locatorType.toLowerCase().equals("class")))
			 return driver.findElements(By.className(locatorValue));
		else if(locatorType.toLowerCase().equals("tagname")
				 || (locatorType.toLowerCase().equals("tag")))
			 return driver.findElements(By.tagName(locatorValue));
		else if(locatorType.toLowerCase().equals("linktext")
				 || (locatorType.toLowerCase().equals("link")))
			 return driver.findElements(By.linkText(locatorValue));
		
		else if(locatorType.toLowerCase().equals("partiallinktext")
				 || (locatorType.toLowerCase().equals("partial")))
			 return driver.findElements(By.partialLinkText(locatorValue));
		
		else if(locatorType.toLowerCase().equals("cssselector")
				 || (locatorType.toLowerCase().equals("css")))
			 return driver.findElements(By.cssSelector(locatorValue));
		
		else if(locatorType.toLowerCase().equals("xpath"))
			 return driver.findElements(By.xpath(locatorValue));
		else 	
			throw new Exception("unknown error type "+locatorType +"");
	}
	
	public WebElement getWebelement(String locator) throws Exception
	{
		return getLocator(p1.getProperty(locator));
		
	}
	public List <WebElement> getWebelements(String locator) throws Exception
	{
		return getLocators(p1.getProperty(locator));
		
	}
	
	public void loadproperties() throws IOException{
		p1=new Properties();
		f1=new File("H:\\workspace1\\talisma\\src\\main\\java\\com\\hybridframework\\config\\config.properties");
		file=new FileInputStream(f1);
		p1.load(file);
		
		f1=new File("H:\\workspace1\\talisma\\src\\main\\java\\com\\hybridframework\\config\\Repositories.properties");
		file=new FileInputStream(f1);
		p1.load(file);
		
		f1=new File("H:\\workspace1\\talisma\\src\\main\\java\\com\\hybridframework\\properties\\homepage.properties");
		file=new FileInputStream(f1);
		p1.load(file);
		
	}
	public void getProperties()
	{
		
	}
	public void getScreenShot(String imageName) throws IOException
	{
		if(imageName.equals("")){
			imageName="blank";
		}
		File image=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String imageLocation="H:\\workspace1\\talisma\\src\\main\\java\\com\\hybridframework\\screenshot\\";
		Calendar calendar=Calendar.getInstance();
		SimpleDateFormat format=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String actualImage=imageLocation+imageName+"_"+format.format(calendar.getTime()+".png");
		File destFile=new File(actualImage);
		FileUtils.copyFile(image, destFile);
	}
	public WebElement  waitForElement(WebDriver driver,long Time,WebElement element){
		WebDriverWait wait=new WebDriverWait(driver,Time);
		
		return wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	public WebElement  waitForElementWithPollingInterval(WebDriver driver,long Time,WebElement element){
		WebDriverWait wait=new WebDriverWait(driver,Time);
		wait.pollingEvery(5, TimeUnit.SECONDS);
		wait.ignoring(NoSuchElementException.class);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	public void implicitWait(long time){
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		
	}

}

package com.webautomation.base;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import com.webautomation.pages.CustomerServicePage;
import com.webautomation.pages.HomePage;
import com.webautomation.utils.PropFileHandler;
import com.webautomation.utils.Screenshot;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * @author Kaushik Banerjee
 */

public class BaseClass {

	public static WebDriver driver;
	public static HomePage homepage;
	public static CustomerServicePage customerservicepage;
	
	@BeforeClass
	public void setup(){
		setDriverConfig();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(PropFileHandler.getConfigProperty("implicitWait")), TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		driver.get(PropFileHandler.getConfigProperty("baseUrl"));
		initPages();
	}
	
	@BeforeMethod
	public void getMethodName(Method name){
		Reporter.log("************************************************");
		Reporter.log("Executed "+name.getName());
		Reporter.log("************************************************");
	}
	
	@AfterMethod
	public void takeScreenshot(ITestResult result){
		Screenshot.takeScreenshotOnException(result,PropFileHandler.getConfigProperty("screenshotPath"),result.getMethod().getMethodName());
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
	
	public static void setDriverConfig(){
		if(PropFileHandler.getConfigProperty("browserName").equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}else if(PropFileHandler.getConfigProperty("browserName").equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}else if(PropFileHandler.getConfigProperty("browserName").equalsIgnoreCase("edge")){
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
		}
	}
	
	public void initPages(){
		homepage=new HomePage(driver);
		customerservicepage=new CustomerServicePage(driver);
	}
	
}

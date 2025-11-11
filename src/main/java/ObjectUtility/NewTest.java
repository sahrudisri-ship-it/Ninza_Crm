	package ObjectUtility;

import org.testng.annotations.Test;

import propertyUtility.ExcelFileUtility;
import propertyUtility.JavaUtility;
import propertyUtility.PropertyFileUtility;
import propertyUtility.WebDriverUtility;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class NewTest {
	public WebDriver driver;
	public ExcelFileUtility efu=new ExcelFileUtility();
	public WebDriverUtility wil=new WebDriverUtility();
	public JavaUtility jLib=new JavaUtility();
	public PropertyFileUtility pfu=new PropertyFileUtility();
	 @BeforeSuite
	  public void beforeSuite() {
		  System.out.println("Establish Database executions");
	  }

  @Test
  public void f() {
	  
  }
  @BeforeMethod 
  public void beforeMethod() {
	  System.out.println("Login");
	
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("Logout");
  }
 
	
  @BeforeClass
  
  public void beforeClass() {
	  ChromeOptions settings = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<>(); 
		prefs.put("profile.password_manager_leak_detection", false); 
		settings.setExperimentalOption("prefs", prefs); 
		ChromeDriver driver= new ChromeDriver(settings);
		driver.manage().window().maximize();
		
		wil.impicitwait(driver);
		driver.get("http://49.249.28.218:8098/ ");
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
	  System.out.println("Launch Browser");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("close Browser");
	  driver.quit();
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("Pre conditions  for the parallel executions");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("Post conditions  for the parallel executions");
  }

 
  @AfterSuite
  public void afterSuite() {
	  System.out.println("close the  Database executions");
  }

}

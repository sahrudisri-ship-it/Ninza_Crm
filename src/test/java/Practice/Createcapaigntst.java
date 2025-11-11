package Practice;

import java.awt.Desktop.Action;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ObjectUtility.CampaignPage;
import ObjectUtility.CreateCampaignPage;
import propertyUtility.ExcelFileUtility;
import propertyUtility.WebDriverUtility;

public class Createcapaigntst {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		ChromeOptions settings = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<>(); prefs.put("profile.password_manager_leak_detection", false); settings.setExperimentalOption("prefs", prefs); 
		
		
		ExcelFileUtility efu=new ExcelFileUtility();
		WebDriverUtility wil=new WebDriverUtility();
		String campaignname=efu.readDataFromExcel("Sheet1", 1, 2);
		String TARGETSIZE=efu.readDataFromExcel("Sheet1", 1, 3);
		String STATUS=efu.readDataFromExcel("Sheet1", 1, 4);

	
				ChromeDriver driver= new ChromeDriver(settings);
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wil.impicitwait(driver);
		driver.get("http://49.249.28.218:8098/ ");
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		
		//driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
		
		CampaignPage cp= new CampaignPage(driver);
		cp.getAddCreateCampaignBtn().click();
		
		
		CreateCampaignPage campaigpage=new CreateCampaignPage(driver);
		campaigpage.getCampaignNameTF().sendKeys("campaignname");
		campaigpage.getGetcampaignstaus().sendKeys("pass");
		//driver.findElement(By.name("campaignName")).sendKeys(campaignname);
		//driver.findElement(By.name("campaignStatus")).sendKeys(STATUS);
		//WebElement targetSize = driver.findElement(By.name("targetSize"));
		campaigpage.getTargetSizeTF().clear();
		//targetSize.clear();
		campaigpage.getTargetSizeTF().sendKeys(TARGETSIZE);
		
		//driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
		campaigpage.getCreateCampaignbt().click();
		WebElement Message = driver.findElement(By.xpath("//div[role='alert']"));
	//	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		//wait.until(ExpectedConditions.visibilityOf(Message));
		wil.waitUntilElementTobeVisible(driver, Message);
		String Toastmsg = Message.getText();
		if(Toastmsg.contains("Successfully"))
		{
		System.out.print("Created campaign");
		}
		else
		{
			System.out.print(" campaign not created");	
		}
		driver.findElement(By.xpath("//button[@aria-label='close']")).click();
		
		
		
		WebElement useicon = driver.findElement(By.className("user-icon"));
		Actions action =new Actions(driver);
		action.moveToElement(useicon).perform();
		WebElement logout = driver.findElement(By.xpath("//div[text()='Logout ']"));
		action.moveToElement(logout).click().perform();
		driver.quit();
		
}}


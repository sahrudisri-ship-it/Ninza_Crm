package CampaignTest;

import java.io.FileInputStream;
import java.io.IOException;
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
import org.testng.annotations.Test;

import ObjectUtility.CampaignPage;
import ObjectUtility.CreateCampaignPage;
import ObjectUtility.NewTest;
import propertyUtility.ExcelFileUtility;
import propertyUtility.WebDriverUtility;

 public class CreateCampaign extends NewTest {

	@Test	
	
	public void createCampaignMandatoryFielsTest() throws EncryptedDocumentException, IOException
	{
	
		
		String campaignname=efu.readDataFromExcel("Sheet1", 1, 2);
		String TARGETSIZE=efu.readDataFromExcel("Sheet1", 1, 3);
		String STATUS=efu.readDataFromExcel("Sheet1", 1, 4);

	
				
		
		
		CampaignPage cp= new CampaignPage(driver);
		cp.getAddCreateCampaignBtn().click();
		
		
		CreateCampaignPage campaigpage=new CreateCampaignPage(driver);
		campaigpage.getCampaignNameTF().sendKeys("campaignname");
		campaigpage.getGetcampaignstaus().sendKeys("pass");
		
		campaigpage.getTargetSizeTF().clear();
		
		campaigpage.getTargetSizeTF().sendKeys(TARGETSIZE);
		
	
		campaigpage.getCreateCampaignbt().click();
		WebElement Message = driver.findElement(By.xpath("//div[role='alert']"));
	
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
		
}
@Test	
	
	public void excelMethod() throws EncryptedDocumentException, IOException
	
	{
	FileInputStream file= new FileInputStream("C:\\Users\\Hp\\Documents\\CamapignTestcase1.xlsx");
	Workbook wb = WorkbookFactory.create(file);

	String campaignname = wb.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
	System.out.println(campaignname);
	}
 }
	


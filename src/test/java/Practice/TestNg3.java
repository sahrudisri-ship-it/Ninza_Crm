package Practice;





import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ObjectUtility.LoginPage;
import propertyUtility.ExcelFileUtility;
	

public class TestNg3 {

	@Test(dataProvider = "loginDetails")
	public void login(String un,String pw) {
		ChromeDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp("http://49.249.28.218:8098/",un , pw);
		driver.quit();
	}
	
	@DataProvider
	public 	Object [][] loginDetails() throws EncryptedDocumentException, IOException{
		ExcelFileUtility excel=new ExcelFileUtility();
		Object[][] objArr	=new Object[excel.getRowCount("Credentials")][2];
	
		
		for(int i=1;i<excel.getRowCount("Credentials");i++)
		{
				objArr[i-1][0]=excel.readDataFromExcel("Credentials", i, 0);
				objArr[i-1][1]=excel.readDataFromExcel("Credentials", i, 1);
		}
		return objArr;	
		}
}
		
		
	
	
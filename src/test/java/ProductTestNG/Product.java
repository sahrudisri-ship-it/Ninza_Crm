package ProductTestNG;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import ObjectUtility.CreateProductP;
import ObjectUtility.NewTest;
import ObjectUtility.productPage;
import propertyUtility.JavaUtility;
import propertyUtility.PropertyFileUtility;
import propertyUtility.WebDriverUtility;

public class Product extends NewTest{
	
	@Test
	
	public void createProduct() throws IOException
	{
		
		
//String BROWSER = pfu.readDataFromPropertyFile("Browser");


FileInputStream file= new FileInputStream("C:\\Users\\Hp\\Documents\\CamapignTestcase1.xlsx");
Workbook wb = WorkbookFactory.create(file);
 
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		productPage pp=new productPage(driver);
		pp.getAddProductBtn().click();
		//driver.findElement(By.xpath("//span[text()='Add Product']")).click();
		
		
		String PRODUCT_NAME= wb.getSheet("PRODUCT").getRow(1).getCell(1).getStringCellValue();
		//Random random=new Random();
		//IntStream num = random.ints(1000);
		String CATEGORY = wb.getSheet("PRODUCT").getRow(1).getCell(2).getStringCellValue();
		String QUANTITY= wb.getSheet("PRODUCT").getRow(1).getCell(3).getStringCellValue();
		String PRICE = wb.getSheet("PRODUCT").getRow(1).getCell(4).getStringCellValue();
		String VENDOR= wb.getSheet("PRODUCT").getRow(1).getCell(5).getStringCellValue();
		
           CreateProductP createproduct= new CreateProductP(driver);
		//driver.findElement(By.name("productName")).sendKeys(PRODUCT_NAME+ jlib.generateRandomNumber());
	createproduct.getProductNameTF().sendKeys(PRODUCT_NAME+ jLib.generateRandomNumber());
		WebElement productCategory =createproduct.getProductNameTF();
		//Select PC= new Select(productCategory);
		//PC.selectByValue(CATEGORY);
		wil.selectByValue(productCategory, CATEGORY);
		WebElement QUANTITY1 =createproduct.getQuantityTF();
		QUANTITY1.clear();
		QUANTITY1.sendKeys(QUANTITY);
		WebElement price1 = createproduct.getPriceTF();	
		price1.clear();
		price1.sendKeys(PRICE);
		WebElement vend = createproduct.getVendorIdDD();
		
		//Select vc=new Select(vend);
		//vc.selectByValue(VENDOR);
		wil.selectByValue(vend, VENDOR);
		WebElement toastMsg = driver.findElement(By.xpath("//div[@role='alert']"));
	//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	//	wait.until(ExpectedConditions.visibilityOf(toastMsg));
		wil.waitUntilElementTobeVisible(driver, toastMsg);
		String msg = toastMsg.getText();
		System.out.println(msg);
		if (msg.contains("Successfully Added"))
			System.out.println("Product Created");
		else
			System.out.println("Product Not Created");
		createproduct.getAddBtn().click();

		// Logout
		WebElement userIcon = driver.findElement(By.className("user-icon"));
		//Actions action = new Actions(driver);
		//action.moveToElement(userIcon).perform();
		wil.mouseoveOnWebElement(driver, userIcon);
		WebElement logoutBtn = driver.findElement(By.xpath("//div[text()='Logout ']"));
		//action.moveToElement(logoutBtn).click().perform();
		wil.clickOnWebElement(driver, logoutBtn);

		// Close browser
	
		
	}

}

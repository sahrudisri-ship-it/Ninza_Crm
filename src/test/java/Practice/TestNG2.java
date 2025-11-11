package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestNG2 {
	@Test
	public void createProduct()
	
	{
		WebDriver driver=new ChromeDriver();
		driver.get(null);
		driver.get("http://49.249.28.218:8098/ ");
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		driver.close();
	}
	@Test (dependsOnMethods = "createProduct")
	public void updateProduct()
	{
		Reporter.log("updateProduct",true);
	}
	
	@Test(dependsOnMethods = {"createProduct","updateProduct"})
	public void deleteProduct() {
		System.out.println("deleteProduct");
	}
}

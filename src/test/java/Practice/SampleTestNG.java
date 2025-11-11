package Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class SampleTestNG {
	
	@Test(priority=-200, invocationCount=5, threadPoolSize = 2,enabled=false)
	
	public void createProduct()
	
	{
		WebDriver driver=new ChromeDriver();
		//System.out.println("createProduct");
		driver.close();
	}
	@Test (invocationCount=0)
	public void updateProduct()
	{
		Reporter.log("updateProduct",true);
	}
	
	@Test
	public void deleteProduct() {
		System.out.println("deleteProduct");
	}

}

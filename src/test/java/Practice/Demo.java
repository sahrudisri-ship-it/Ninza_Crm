package Practice;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

	public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/ ");
		driver.findElement(By.linkText("Facebook")).click();
		String parent = driver.getWindowHandle();
		Set<String> all = driver.getWindowHandles();
		all.remove(parent);
		
			
	}

}

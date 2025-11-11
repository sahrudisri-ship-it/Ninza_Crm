package Practice;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class takeScreenshot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

	WebDriver driver=new ChromeDriver();
	driver.get("https://www.facebook.com/");
	TakesScreenshot ts = (TakesScreenshot)driver;
	File file = ts.getScreenshotAs(OutputType.FILE);
	File fl=new File("C:\\Users\\Hp\\Documents");
			org.openqa.selenium.io.FileHandler.copy(file, fl);
	}

}

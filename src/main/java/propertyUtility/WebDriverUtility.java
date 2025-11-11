package propertyUtility;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	public void impicitwait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
public void waitUntilElementTobeVisible(WebDriver driver, WebElement element)
{
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
	wait.until(ExpectedConditions.visibilityOf(element));
}
public void selectByValue(WebElement element,String value )
{
Select s=new Select(element);
s.selectByValue(value);
}
public void selectByText(String Text,WebElement element )
{
Select s=new Select(element);
s.selectByValue(Text);
}
public void selectByIndex(WebElement element,String Index )
{
Select s=new Select(element);
s.selectByValue(Index);
}
public void mouseoveOnWebElement(WebDriver driver, WebElement element)
{
	Actions action=new Actions(driver);
	action.moveToElement(element).perform();
}
public void clickOnWebElement(WebDriver driver, WebElement element)
{
	Actions action=new Actions(driver);
	action.moveToElement(element).click().perform();
}
public void switchDriverControlOnTitle(WebDriver driver,String title )
{
	String ParentId=driver.getWindowHandle();
	Set<String> allIds = driver.getWindowHandles();
	allIds.remove(ParentId);
	for(String id: allIds)
	{
		driver.switchTo().window(id);
		if(driver.getTitle().contains(title))
			break;
	}
	}
public void switchDriverControlOnCurrentUrl(WebDriver driver,String url )
{
	String ParentId=driver.getWindowHandle();
	Set<String> allIds = driver.getWindowHandles();
	allIds.remove(ParentId);
	for(String id: allIds)
	{
		driver.switchTo().window(id);
		if(driver.getTitle().contains(url))
			break;
	}
	}
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	public void switchToFrame(WebDriver driver, String nameOrId)
	{
		driver.switchTo().frame(nameOrId);
	}
	public void switchToFrame(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}
	public void switchToAlertandAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	public void switchToAlertandDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	public void switchToAlertandGetText(WebDriver driver)
	{
		driver.switchTo().alert().getText();
	}
	public void doubleclick(WebDriver driver,WebElement element)
	{
		Actions action =new Actions(driver);
		action.doubleClick().perform();
	}
	public void rightClick(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.contextClick().perform();  
	}
	
	
}


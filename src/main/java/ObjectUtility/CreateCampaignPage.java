package ObjectUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage {
	WebDriver driver;
	public CreateCampaignPage(WebDriver driver)
	{
		this.driver=driver;
	
	PageFactory.initElements(driver, this);
	}
	@FindBy(name="campaignName")
	private WebElement campaignNameTF;
	
	@FindBy(name="targetSize")
	private WebElement targetSizeTF;
	
	@FindBy(name="expectedCloseDate")
	private WebElement expectedCloseDateTF;
	
	@FindBy(xpath="//button[text()='Create Campaign']")
	private WebElement CreateCampaignbt;
	
	@FindBy(name="campaignStatus")
	private WebElement getcampaignstaus;
	public WebElement getCampaignNameTF() {
		return campaignNameTF;
	}

	public WebElement getTargetSizeTF() {
		return targetSizeTF;
	}

	public WebElement getExpectedCloseDateTF() {
		return expectedCloseDateTF;
	}

	public WebElement getCreateCampaignbt() {
		return CreateCampaignbt;
	}

	public WebElement getGetcampaignstaus() {
		return getcampaignstaus;
	}
	
	
}

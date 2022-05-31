package pomClassOfFlipkart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	@FindBy (xpath="(//input[@type='text'])[2]")
	private WebElement username;
	

	@FindBy (xpath="//input[@type='password']")
	private WebElement password;

	

	@FindBy (xpath="(//span[text()='Login'])[2]")
	private WebElement login;


	WebDriver driver;


	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void sendusername(String test)
	{
		username.sendKeys(test);
	}
	public void sendpassword(String test1)
	{
		password.sendKeys(test1);
	}
	public void clickOnlogin()
	{
		login.click();
	}
}

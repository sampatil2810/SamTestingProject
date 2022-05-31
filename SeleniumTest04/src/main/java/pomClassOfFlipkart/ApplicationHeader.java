package pomClassOfFlipkart;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApplicationHeader
{
	@FindBy(xpath="//img[@alt='Top Offers']")
	private WebElement topOffers;
	
	@FindBy (xpath = "//div[text()='Mobiles']")
	private WebElement mobilestab;
	
	@FindBy (xpath ="//div[text()='Grocery']")
	private WebElement grocerytab;
	
	@FindBy(xpath="//img[@alt='Travel']")
	private WebElement travelTab;
	
	@FindBy (xpath= "//div[text()='Home']")
	private WebElement hometab;
	
	@FindBy (xpath="(//div[@class='exehdJ'])[1]")
	private WebElement sumittab;
	
	@FindBy (xpath="//a[@href='#']")
	private WebElement logouttab;
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public ApplicationHeader(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void selectglocerytab()
	{
		grocerytab.click();
	}
	
	public void selectsignout()
	{
		//wait = new WebDriverWait(driver, 5);
		//wait.until(ExpectedConditions.visibilityOf(sumittab));
		
		Actions act = new Actions(driver);
		act.moveToElement(sumittab).perform();
		act.moveToElement(logouttab).click().perform();
	}
//	public void clickontopOffers()
//	{
//		topOffers.click();
//	}
//	
//
//	public void clickmobilesTab()
//	{
//		mobilestab.clear();
//	}
//	
//
//	public void clickgloceryTab()
//	{
//		grocerytab.click();
//	}
//	
//	public void clicktravelTab()
//	{
//		travelTab.click();
//	}
//	
//
//	public void clickhomeTab()
//	{
//		hometab.click();
//	}
//	
//	public void clickonsumittab()
//	{
//		
//		Alert alert = driver.switchTo().alert();
//		alert.accept();
//		wait = new WebDriverWait(driver,10);
//		wait.until(ExpectedConditions.visibilityOf(sumittab));
//
//	
//		sumittab.click();
//	}
//	
//	public void cliikOnlogouttab()
//	{
//	
//		logouttab.click();
//	}
	

}

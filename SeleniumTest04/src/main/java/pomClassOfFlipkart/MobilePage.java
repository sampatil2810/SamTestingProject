package pomClassOfFlipkart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MobilePage 
{
	@FindBy (xpath ="(//p[text()='Shop Now'])[1]")
	private WebElement shopnowtab1;
	
	@FindBy (xpath ="(//p[text()='Shop Now'])[2]")
	private WebElement shopnowtab2;
	
	@FindBy (xpath ="(//p[text()='Shop Now'])[3]")
	private WebElement shopnowtab3;
	
	@FindBy (xpath ="(//p[text()='Shop Now'])[4]")
	private WebElement shopnowtab4;
	
	@FindBy (xpath ="(//p[text()='Shop Now'])[5]")
	private WebElement shopnowtab5;
	
	
	
	
//	public MobilePage(WebDriver driver)
//	{
//		PageFactory.initElements(driver, this);
//	}
//	
//	public void clickOnshopnowtab1()
//	{
//		shopnowtab1.click();
//	}
//	
//
//	public void clickOnshopnowtab2()
//	{
//		shopnowtab2.click();
//	}
//
//
//	public void clickOnshopnowtab3()
//	{
//		shopnowtab3.click();
//	}


	public void clickOnshopnowtab4()
	{
		shopnowtab4.click();
	}


	public void clickOnshopnowtab5()
	{
		shopnowtab5.click();
	}
	
	


}

package pack04;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pomClassOfFlipkart.ApplicationHeader;
import pomClassOfFlipkart.LoginPage;
import pomClassOfFlipkart.MobilePage;

public class VerifyHeadersOfFlipkart 
{
	public static void main(String[]args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium  folder\\chrome 2022\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://www.flipkart.com/account/login?ret=/");
		
		LoginPage loginpage = new LoginPage(driver);
	//.sendusername();
	//	loginpage.sendpassword();
		loginpage.clickOnlogin();
		
		ApplicationHeader header = new ApplicationHeader(driver);
		
		Thread.sleep(7000);
		
		header.selectglocerytab();
		
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		 
		if(url.equals("https://www.flipkart.com/grocery-supermart-store?marketplace=GROCERY&fm=neo%2Fmerchandising&iid=M_e2bc43da-6b91-49d4-b3cd-6d012fd07fbf_1_372UD5BXDFYS_MC.CBUR1Q46W5F1&otracker=hp_rich_navigation_2_1.navigationCard.RICH_NAVIGATION_Grocery_CBUR1Q46W5F1&otracker1=hp_rich_navigation_PINNED_neo%2Fmerchandising_NA_NAV_EXPANDABLE_navigationCard_cc_2_L0_view-all&cid=CBUR1Q46W5F1") && title.equals("Flipkart Grocery Store - Buy Groceries Online & Get Rs.1 Deals at Flipkart.com"))
		{
			System.out.println("PAss");
		}
		else
		{
			System.out.println("FAil");
		}
		Thread.sleep(10000);
	
		header.selectsignout();
		
		Thread.sleep(2000);
		
		driver.close();
	
		
		
		
		
	}

}

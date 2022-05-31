package pack04;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import browsers.Base;
import pomClassOfFlipkart.ApplicationHeader;
import pomClassOfFlipkart.LoginPage;
import utils.utility;

@Test
public class testNgOfFlipkart 
{
    WebDriver driver;
    LoginPage loginpage ;
	ApplicationHeader header;
	int row=1;
	@Parameters("browserName")
    
	@BeforeTest
	public void launchTheBrowser(String browser)
	{
		System.out.println(browser);
		if(browser.equals("Chrome"))
		{
			driver =Base.openchromebrowser();
		}
		
		if(browser.equals("Firefox"))
		{
			driver =Base.openFirefoxbrowser();
		}
		
		if(browser.equals("Edge"))
		{
			driver =Base.openchromebrowser();
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	@BeforeClass
	public void createPOMobject()
	{
		 loginpage =new LoginPage(driver);
		 header = new ApplicationHeader(driver);
	}
	
	@BeforeMethod
	public void logintoApplication() throws InterruptedException, EncryptedDocumentException, IOException
	{
		driver.get("https://www.flipkart.com/account/login?ret=/");
		driver.manage().window().maximize();
		
	 
		String data=utility.getDataFromExcelsheet("Sheet1",1,0);
		loginpage.sendusername(data);
		data=utility.getDataFromExcelsheet("Sheet1",1,1);
		loginpage.sendpassword(data);
		loginpage.clickOnlogin();
		
	   Thread.sleep(7000);
	}
	@Test
	public void verifyTheGloceryTab() throws InterruptedException
	{
        header.selectglocerytab();
        Thread.sleep(2000);
		
		String url = driver.getCurrentUrl();
		Assert.assertEquals("//www.flipkart.com/grocery-supermart-store?marketplace=GROCERY&fm=neo%2Fmerchandising&iid=M_92bc90ec-4de0-4613-842b-806678fefa01_1_372UD5BXDFYS_MC.CBUR1Q46W5F1&otracker=hp_rich_navigation_2_1.navigationCard.RICH_NAVIGATION_Grocery_CBUR1Q46W5F1&otracker1=hp_rich_navigation_PINNED_neo%2Fmerchandising_NA_NAV_EXPANDABLE_navigationCard_cc_2_L0_view-all&cid=CBUR1Q46W5F1", url);
		
		String title = driver.getTitle();
		Assert.assertEquals("Flipkart Grocery Store - Buy Groceries Online & Get Rs.1 Deals at Flipkart.com", title);
//		 
//		SoftAssert soft = new SoftAssert();
//	    soft.assertEquals("https://www.flipkart.com/grocery-supermart-store?marketplace=GROCERY&fm=neo%2Fmerchandising&iid=M_e2bc43da-6b91-49d4-b3cd-6d012fd07fbf_1_372UD5BXDFYS_MC.CBUR1Q46W5F1&otracker=hp_rich_navigation_2_1.navigationCard.RICH_NAVIGATION_Grocery_CBUR1Q46W5F1&otracker1=hp_rich_navigation_PINNED_neo%2Fmerchandising_NA_NAV_EXPANDABLE_navigationCard_cc_2_L0_view-all&cid=CBUR1Q46W5F1", url);
//			
//		soft.assertEquals("Flipkart Grocery Store - Buy Groceries Online & Get Rs.1 Deals at Flipkart.com", title);
//		
//		soft.assertAll();
		row++;
	}
	
	@AfterMethod
	public void logoutfromApplication(ITestResult result) throws IOException, InterruptedException 
	{
		if( ITestResult.FAILURE == result.getStatus())
		{
			utility.capturescreenshot(driver, result.getName());
	}
		Thread.sleep(8000);	
		header.selectsignout();
	}
	
	@AfterClass
	public void clearobject()
	{
		loginpage =null;
		header=null;
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
		driver =null;
		System.gc();
		
	}

}

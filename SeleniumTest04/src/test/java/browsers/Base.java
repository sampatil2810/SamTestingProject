package browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base 
{
	public static WebDriver openchromebrowser()
	{
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\browser\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		 return driver;
	}
	
	public static WebDriver openFirefoxbrowser()
	{
		System.setProperty("webdriver.gecko.driver", "F:\\Selenium  folder\\geckodriver.exe");
		 WebDriver driver = new FirefoxDriver();
		 return driver;
	}
	

    public static WebDriver openmsedgebrowser()
	{
		System.setProperty("webdriver.edge.driver", "F:\\Selenium  folder\\msedgedriver.exe");
	 WebDriver driver = new EdgeDriver();
		 return driver;
	}


}

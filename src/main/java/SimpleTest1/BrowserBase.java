package SimpleTest1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BrowserBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	 
	public static void initialization() throws IOException

	{
		
		prop=new Properties();
		FileInputStream ip=new FileInputStream("C:\\Users\\Vega\\eclipse-workspace1\\Gmail_Access\\src\\main\\java\\ObjectRepository\\Launch.properties");
		 
		 prop.load(ip);
		String browser=prop.getProperty("Browser");
		
		
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vega\\eclipse-workspace1\\Gmail_Access\\src\\main\\java\\Drivers\\chromedriver.exe");
			 
		    driver = new ChromeDriver();
		    
		    //Alternative for browser launch is WebDriver Manager or selenide API can be used
		    //WebDriverManager.chromedriver().setup();
		}
		    
		    else if(browser.equals("Firefox"))
		    {
		    	System.setProperty("webdriver.gecko.driver","C:\\Users\\Vega\\Downloads\\geckodriver.exe");
			    driver = new FirefoxDriver();
			    
			   
		    	
		    }
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		 driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
			
		}
	
	public static void main(String args[]) throws IOException {
		initialization();
	}
	


}

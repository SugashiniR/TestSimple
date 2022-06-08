package SimpleTest1;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ObjectRepository.DevicePage;
import ObjectRepository.HomePage;

public class Validate_About_This_Item extends BrowserBase {
	
    // TestNG issue in my Eclipse, so used Java Main method to execute..
	// Its very simple framework I used for time being 
	public static void main(String args[]) throws IOException
	{
		initialization();
			try {		
			HomePage.NavigatetoTVpage();
			HomePage.switchtodevicepage();
			System.out.println("-------------------------------------------------");
			DevicePage.verify_about_this_Item();
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * In case if i am using TestNG framework, I will be executing my test methods after @Test annotation
	 * I can use logger to log my execution steps  or for console reports
	 * 
	 * Example : 
	 * 
	 * @BeforeMethod

public void setup()
{
	initialization();
	
}

@Test
public void verify ()
{
	//Test steps;
}

@AfterMethod
public void teardown()
{
	driver.close();
	
	
}

	 */

}

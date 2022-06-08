package ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import SimpleTest1.BrowserBase;

public class DevicePage extends BrowserBase {
	
	//@FindBy(xpath="//div[@id='feature-bullets']/h1[contains(text(),'About this item')]")
	//static WebElement AboutthisItem;
	
	static By AboutthisItem=By.xpath("//div[@id='feature-bullets']/h1[contains(text(),'About this item')]");
	static By ListElements =By.xpath("//div[@id='feature-bullets']/ul/li");
	//Initializing page objects
	public DevicePage(WebDriver driver)
	{
			this.driver=driver;
			
			// Page factory class can be used in Page object module with @FindBy annotations
			//PageFactory.initElements(driver, this);
			
	}
	
	public static void verify_about_this_Item() {
	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,900)", "");
		 
		 String text=driver.findElement(AboutthisItem).getText();
		 System.out.println(text);
		 
		 List<WebElement> DeviceDetails=driver.findElements(ListElements);
		 
		 for(WebElement e:DeviceDetails) {
			 String deviceinfo=e.getText();
			 
			 System.out.println(deviceinfo);
			 
			 
		 }
		 
	}
	
	 

}

package ObjectRepository;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SimpleTest1.BrowserBase;


public class HomePage extends BrowserBase  {
	
	
	
		    static By HamburgerMenu=By.xpath("//i[@class='hm-icon nav-sprite']");
			
			static By ElectronicsMenu=By.xpath("//div[@id='hmenu-content']/ul/li[16]/a/div[contains(text(),'Electronics')]");
			 
			static By TelevisionMenu=By.xpath("//ul[@class='hmenu hmenu-visible hmenu-translateX']/li[3]/a[contains(text(),'Televisions')]");
			
			static By Brands_Samsung=By.xpath("//div/span[contains(text(),'Brands')]/parent::div//following-sibling::ul/li[2][contains(text(),Samsung)]/span/a/div");
						
			static By Sort_Feature=By.xpath("//span[@class='a-button-inner']/span[@id='a-autoid-0-announce']");
			
			static By High_to_Low=By.xpath("//div[@class='a-popover-inner']/ul/li[3]/a[text()='Price: High to Low']");
			
			static By SecondndDevice=By.xpath("//div[@class='sg-col-inner']/span/div[2]/div[3]/div/div/div/div/div[1]");
			
			//@FindBy(xpath="//div[@id='feature-bullets']/h1[contains(text(),'About this item')]")
			//static WebElement menu;
			
			//Initializing page objects
				public HomePage(WebDriver driver)
				{
					this.driver=driver;
					
					// Page factory class can be used in Page object module with @FindBy annotations
					//PageFactory.initElements(driver, this);
					
					
				}
					
				public static void NavigatetoTVpage() throws InterruptedException  {
					
					WebDriverWait wait = new WebDriverWait(driver,20);
					driver.findElement(HamburgerMenu).click();
					sleeps(5000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(ElectronicsMenu));
					driver.findElement(ElectronicsMenu).click();					 
					JavascriptExecutor js = (JavascriptExecutor) driver; 
					js.executeScript("arguments[0].scrollIntoView();", driver.findElement(HamburgerMenu)); 
					sleeps(5000);					 
					 WebElement TVMenu=driver.findElement(TelevisionMenu);
					 TVMenu.click();
					 sleeps(5000); 
					 js.executeScript("window.scrollBy(0,1800)", "");
					 sleeps(5000); 					 					 
					 Actions action = new Actions(driver);					 
					 action.moveToElement(driver.findElement(Brands_Samsung)).click().build().perform();
					 sleeps(5000); 
					 driver.findElement(Sort_Feature).click();;
					 sleeps(5000); 
					 driver.findElement(High_to_Low).click();
					 sleeps(5000); 
			         driver.findElement(SecondndDevice).click();
		
				}
				
				
				public static void switchtodevicepage() throws InterruptedException {
					String parent=driver.getWindowHandle();
				    Set<String>s=driver.getWindowHandles();
					// Now iterate using Iterator
					Iterator<String> I1= s.iterator();
					while(I1.hasNext())
					{
					String child_window=I1.next();
					if(!parent.equals(child_window))
					{
					driver.switchTo().window(child_window);

					System.out.println("Device Page title: "+driver.switchTo().window(child_window).getTitle());
					}
					}
					sleeps(5000); 
				}
				
				public static void sleeps(int n) throws InterruptedException {
					Thread.sleep(n);
				}
				
	
		}

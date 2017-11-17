package GitProject.gittest;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest
{

    @Test
	public void testApp() throws InterruptedException
    {

    	/*
		final List<String> optionArray = new ArrayList<String>();
	           
	        optionArray.add("--window-size=800,1000");
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments(optionArray);
		WebDriver driver = new ChromeDriver(options);
		
		
    	String exePath = "/Users/Shared/Jenkins/Home/geckodriver";
		System.setProperty("webdriver.gecko.driver", exePath);
		WebDriver driver = new FirefoxDriver();
    	*/
    	
		String exePath = "/Users/Shared/Jenkins/Home/chromedriver";
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();
		
		//System.out.println(driver.manage().window().getSize());
		
		driver.get("http://beta.capecloud.ch/#logIn"); 
		
		//driver.manage().window().setSize(new Dimension(1024, 768));
		
		
		//System.out.println(driver.manage().window().getSize());
		
		
		WebDriverWait wait = new WebDriverWait(driver, 15);

		// Enter credentials

		driver.findElement(By.id("username")).sendKeys("adminuser");

		driver.findElement(By.id("password")).sendKeys("hasmipele");

		driver.findElement(By.id("sign-in")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.id("sms_code")));

		driver.findElement(By.id("sms_code")).sendKeys("0");

		driver.findElement(By.id("sign-in")).click();

		String title = driver.getTitle();				 
		
		wait.until(ExpectedConditions.urlToBe("http://beta.capecloud.ch/#/"));

		
		System.out.println("Success");
						
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-mdlname='ccM4']")));
		
				
		driver.findElement(By.cssSelector("button[data-mdlname='ccM4']")).click();

		
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("ul.select2-selection__rendered li")));
		
		Boolean isPresent = driver.findElements(By.cssSelector("ul.select2-selection__rendered li")).size() > 0;
		if(isPresent){
			
			
			System.out.println(isPresent);
			
			List<WebElement> allElements = driver.findElements(By.cssSelector("ul.select2-selection__rendered li"));
			
			for (WebElement element: allElements) {
			      System.out.println(element.getText());
			}
			
			Boolean newsPresents = driver.findElements(By.cssSelector(".dbProjectsTable .feed_item")).size() == 0;
			
			System.out.println(newsPresents);
		}
		
		else{
		Assert.fail();
		}
		//driver.quit();

    }
}

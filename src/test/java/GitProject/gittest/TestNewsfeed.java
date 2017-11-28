package GitProject.gittest;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Unit test for simple App.
 */
public class TestNewsfeed
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
    	
    	
    	//String exePath = "/Users/Shared/Jenkins/Home/chromedriver";
		String exePath = "C:\\Program Files (x86)\\Jenkins\\workspace\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		
		System.out.println(driver.manage().window().getSize());
		
		driver.get("http://beta.capecloud.ch/#logIn"); 
		
		driver.manage().window().maximize();


		// Enter credentials

		driver.findElement(By.id("username")).sendKeys("adminuser");

		driver.findElement(By.id("password")).sendKeys("hasmipele");

		driver.findElement(By.id("sign-in")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.id("sms_code")));

		driver.findElement(By.id("sms_code")).sendKeys("1994");

		driver.findElement(By.id("sign-in")).click();

		String title = driver.getTitle();				 
		
		wait.until(ExpectedConditions.urlToBe("http://beta.capecloud.ch/#/"));

		
		System.out.println("Success");
		
		//Messages
		Thread.sleep(10000);
		
		driver.findElement(By.id("ccMenuMsg")).click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.cssSelector("[data-names='Web Driver']")).click();
			
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".addTopic")));
		
		driver.findElement(By.cssSelector(".addTopic")).click();
		
		driver.findElement(By.cssSelector(".newTopicInputField")).sendKeys("azbuka");
		
		driver.findElement(By.cssSelector(".newTopicInputField")).sendKeys(Keys.ENTER);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cd-timeline-addCom")));
		driver.findElement(By.cssSelector(".cd-timeline-addCom")).click();
		
		driver.findElement(By.id("newCommentId")).sendKeys("How are you");
		
		driver.findElement(By.id("submitNewCommentId")).click();
		
		Thread.sleep(5000);
		
		
		System.out.println("Add new topic");
		
		
		
		//Newsfeed	
		/*
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
		*/
		
		//driver.quit();

    }
}

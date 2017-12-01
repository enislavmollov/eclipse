package GitProject.gittest;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Test1Message {
  @Test
  public void mess() throws InterruptedException {
	  
	    String exePath = "/Users/Shared/Jenkins/Home/chromedriver";
		//String exePath = "C:\\Program Files (x86)\\Jenkins\\workspace\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();
	  
	  driver.get("http://beta.capecloud.ch");
		
		driver.manage().window().maximize();

		WebDriverWait wait = new WebDriverWait(driver, 15);

		// Enter credentials

		driver.findElement(By.id("username")).sendKeys("ehoff@abv.bg");

		driver.findElement(By.id("password")).sendKeys("Password.1");

		driver.findElement(By.id("sign-in")).click();
		
		Thread.sleep(5000);
		
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("sms_code")));

		driver.findElement(By.id("sms_code")).sendKeys("1994");

		driver.findElement(By.id("sign-in")).click();

		String title = driver.getTitle();				 
		
		wait.until(ExpectedConditions.urlToBe("http://beta.capecloud.ch/#/"));

		
		System.out.println("Success");
		
		/*
	
		driver.findElement(By.xpath(".//*[@id='originalForm']/div[3]/a/span")).click();
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mdl-content']/div[2]/div/button[1]")));
		
		driver.findElement(By.xpath(".//*[@id='mdl-content']/div[2]/div/button[1]")).click();
		
				
		//Go to the email and get the sms code 
		
		Thread.sleep(10000);
		
		String url = "https://www.abv.bg/";

		((JavascriptExecutor) driver).executeScript("window.open(arguments[0])", url);

		String site = driver.getCurrentUrl();

		System.out.println("Current URL:" + site);

		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());

		driver.switchTo().window(tabs2.get(1));
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("username")));
		
		driver.findElement(By.id("username")).sendKeys("ehoff");
		
		driver.findElement(By.id("password")).sendKeys("Password.1");
		
		driver.findElement(By.id("loginBut")).click();
		
		
		
		
		Thread.sleep(5000);
				
		driver.findElement(By.xpath(".//*[@id='middlePagePanel']/div[2]/div/div[2]/span")).click();
		
		driver.findElement(By.xpath(".//*[@id='inboxTable']/tbody[1]/tr[1]/td[2]/div")).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String smsCode = driver.findElement(By.xpath(".//tbody//strong")).getText();
		
		System.out.println(smsCode);
		
		
		driver.switchTo().window(tabs2.get(0));
		
		driver.findElement(By.id("sms_code")).sendKeys(smsCode);
		
		driver.findElement(By.id("sign-in")).click();

		wait.until(ExpectedConditions.urlToBe("http://beta.capecloud.ch/#/"));

		System.out.println("Successful login");
		
		*/
		
		Thread.sleep(10000);
			
		String foundCount = driver.findElement(By.cssSelector(".ccMessNotif")).getText();
	
		
		Assert.assertEquals(foundCount, "1");
		
		System.out.println("Message sent");
		
		driver.findElement(By.id("ccMenuMsg")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-names='System User']")));
		
		//String messCount = driver.findElement(By.cssSelector("[class='listImage']")).getAttribute("data-msgcounter");
			
		//Assert.assertEquals(messCount, "1");
		
		//System.out.println("Message is there");
		
		
		
		driver.findElement(By.cssSelector("[data-names='System User']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("[data-name='azbuka']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("#rightSide > h1 > button")).click();
		Thread.sleep(2000);
		
		System.out.println("Edit but");
		
		//driver.findElement(By.cssSelector("[class='adminModal']")).click();
		//Thread.sleep(2000);
		
		Select dropdown = new Select(driver.findElement(By.cssSelector("[class='adminModal']")));
		
		dropdown.selectByVisibleText("Delete topic");
		
		//driver.findElement(By.cssSelector("#rightSide > h1 > div.modalDropDown.active > ul > li:nth-child(2) > button")).click();
		
		
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//button[contains(.,'Delete')]")).click();
		
		//driver.findElement(By.cssSelector("[data-names='Anne Henke']")).click();
		
		//driver.findElement(By.xpath(".//*[@id='chatContactGroupList']/li[1]/div/div[2]/div")).click();
		
		
		//driver.findElement(By.cssSelector(".listTopics .addTopic")).click();
		
		
  }
}

package GitProject.gittest;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestMessage {
  @Test
  public void mess() throws InterruptedException {
	  
	 //String exePath = "/Users/Shared/Jenkins/Home/chromedriver";
		String exePath = "C:\\Program Files (x86)\\Jenkins\\workspace\\chromedriver.exe";
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
		
		driver.findElement(By.id("loginBut")).click();;
		
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
  }
}

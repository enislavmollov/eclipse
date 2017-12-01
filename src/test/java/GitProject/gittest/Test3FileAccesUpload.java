package GitProject.gittest;

import org.testng.annotations.Test;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test3FileAccesUpload {
  @Test
  public void f() throws InterruptedException {
	  
  		//String exePath = "/Users/Shared/Jenkins/Home/chromedriver";
		String exePath = "C:\\Program Files (x86)\\Jenkins\\workspace\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		
		System.out.println(driver.manage().window().getSize());
		
		driver.get("http://beta.capecloud.ch/#logIn"); 
		
		driver.manage().window().maximize();


		// Enter credentials

		driver.findElement(By.id("username")).sendKeys("ehoff@abv.bg");

		driver.findElement(By.id("password")).sendKeys("Password.1");

		driver.findElement(By.id("sign-in")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.id("sms_code")));

		driver.findElement(By.id("sms_code")).sendKeys("1994");

		driver.findElement(By.id("sign-in")).click();
		
		wait.until(ExpectedConditions.urlToBe("http://beta.capecloud.ch/#/"));
		
		Thread.sleep(5000);
		
		
		//Go to Investments/Core holdings
		
		Boolean isPresent = driver.findElements(By.cssSelector("[href='#businessIntelligence']")).size() > 0;
		
		System.out.println(isPresent);
		
		driver.get("http://beta.capecloud.ch/#businessIntelligence"); 
			
		System.out.println("Step 1");
		
		//driver.get("http://beta.capecloud.ch/#businessIntelligence/Core Holdings");
		Thread.sleep(5000);
		
		driver.get("http://beta.capecloud.ch/#/businessIntelligence/company/1595/company");
		
		Thread.sleep(5000);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[href='/#/businessIntelligence/company/1595/files']")));
		
		driver.findElement(By.cssSelector("[href='/#/businessIntelligence/company/1595/files']")).click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.cssSelector("[class='ccEditDocs']")).click();
		
		WebElement element = driver.findElement(By.cssSelector("#accordion > div > button"));

		Actions actions = new Actions(driver);

		actions.moveToElement(element).click().perform();
		
		Thread.sleep(3000);
		
		driver.findElement(By.cssSelector("#accordion > div > button")).click();
		
		Thread.sleep(5000);
		
		//driver.findElement(By.id("getFile")).sendKeys("/Users/enislavmollov/Downloads/IMG_3127.PNG");
		driver.findElement(By.id("getFile")).sendKeys("C:\\Program Files (x86)\\Jenkins\\workspace\\chart.jpeg");
		
		
		driver.findElement(By.id("displayName")).sendKeys("Document for test");
		
		Select dropdown = new Select(driver.findElement(By.cssSelector("[class='form-control js-example-basic-single select2-hidden-accessible']")));
		
		dropdown.selectByVisibleText("148");

		Select dropdown1 = new Select(driver.findElement(By.id("permissions")));
		
		dropdown1.selectByVisibleText("Enislav");
		
		driver.findElement(By.id("uploadFile")).click();
		
		Thread.sleep(10000);
		
				
		//Delete uploaded file
		
		driver.findElement(By.cssSelector("[class='ccEditDocs']")).click();
		
		Thread.sleep(3000);
		
		WebElement delFile = driver.findElement(By.cssSelector("[class='ccModal deleteItem']"));

		Actions action = new Actions(driver);

		action.moveToElement(delFile).click().perform();
				
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[@id='mdl-content']/div[3]/button[1]")).click();
		
		Thread.sleep(5000);
		
		int test = driver.findElements(By.xpath(".//a[contains(.,'Document for test')]")).size();
		
		Assert.assertEquals(test, 0);

						
		System.out.println("Success");
	  
  }
}

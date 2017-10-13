package Albums;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class albums {
  @Test
  public void f() {
	  
	  {
	    	String exePath = "/Users/Shared/Jenkins/Home/chromedriver";
			System.setProperty("webdriver.chrome.driver", exePath);
			WebDriver driver = new ChromeDriver();

			driver.get("http://beta.capecloud.ch"); 
			
			
			WebDriverWait wait = new WebDriverWait(driver, 15);

			// Enter credentials

			driver.findElement(By.id("username")).sendKeys("adminuser");

			driver.findElement(By.id("password")).sendKeys("testing");

			driver.findElement(By.id("sign-in")).click();
	  
  }
}
}
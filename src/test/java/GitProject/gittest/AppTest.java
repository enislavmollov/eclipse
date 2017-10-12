package GitProject.gittest;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;

/**
 * Unit test for simple App.
 */
public class AppTest
{

    @Test
	public void testApp()
    {
    	//String exePath = "/Users/enislavmollov/Downloads/chromedriver";
		System.setProperty("webdriver.chrome.driver", "/Users/enislavmollov/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();

		driver.get("http://beta.capecloud.ch");

		WebDriverWait wait = new WebDriverWait(driver, 15);

		// Enter credentials

		driver.findElement(By.id("username")).sendKeys("adminuser");

		driver.findElement(By.id("password")).sendKeys("testing");

		driver.findElement(By.id("sign-in")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.id("sms_code")));

		driver.findElement(By.id("sms_code")).sendKeys("0");

		driver.findElement(By.id("sign-in")).click();

		wait.until(ExpectedConditions.urlToBe("http://beta.capecloud.ch/#/"));

    }
}

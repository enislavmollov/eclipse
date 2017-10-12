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
    	String exePath = "/Users/enislavmollov/Downloads/chromedriver";
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();

		driver.get("http://www.google.com");

		System.out.println("Success");
		
		driver.quit();
    }
}
